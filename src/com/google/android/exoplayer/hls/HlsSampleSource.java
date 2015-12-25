// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.ChunkOperationHolder;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import java.io.IOException;
import java.util.LinkedList;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsExtractorWrapper, TsChunk, HlsChunkSource

public final class HlsSampleSource
    implements SampleSource, com.google.android.exoplayer.SampleSource.SampleSourceReader, com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }


    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final long NO_RESET_PENDING = 0x8000000000000000L;
    private final int bufferSizeContribution;
    private final ChunkOperationHolder chunkOperationHolder;
    private final HlsChunkSource chunkSource;
    private long currentLoadStartTimeMs;
    private Chunk currentLoadable;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private TsChunk currentTsLoadable;
    private Format downstreamFormat;
    private MediaFormat downstreamMediaFormats[];
    private long downstreamPositionUs;
    private int enabledTrackCount;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int eventSourceId;
    private final LinkedList extractors;
    private long lastSeekPositionUs;
    private final LoadControl loadControl;
    private boolean loadControlRegistered;
    private Loader loader;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuities[];
    private long pendingResetPositionUs;
    private boolean prepared;
    private TsChunk previousTsLoadable;
    private int remainingReleaseCount;
    private int trackCount;
    private boolean trackEnabledStates[];
    private MediaFormat trackFormat[];

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i)
    {
        this(hlschunksource, loadcontrol, i, null, null, 0);
    }

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j)
    {
        this(hlschunksource, loadcontrol, i, handler, eventlistener, j, 3);
    }

    public HlsSampleSource(HlsChunkSource hlschunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j, int k)
    {
        chunkSource = hlschunksource;
        loadControl = loadcontrol;
        bufferSizeContribution = i;
        minLoadableRetryCount = k;
        eventHandler = handler;
        eventListener = eventlistener;
        eventSourceId = j;
        pendingResetPositionUs = 0x8000000000000000L;
        extractors = new LinkedList();
        chunkOperationHolder = new ChunkOperationHolder();
    }

    private void clearCurrentLoadable()
    {
        currentTsLoadable = null;
        currentLoadable = null;
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private void clearState()
    {
        for (int i = 0; i < extractors.size(); i++)
        {
            ((HlsExtractorWrapper)extractors.get(i)).clear();
        }

        extractors.clear();
        clearCurrentLoadable();
        previousTsLoadable = null;
    }

    private void discardSamplesForDisabledTracks(HlsExtractorWrapper hlsextractorwrapper, long l)
    {
        if (!hlsextractorwrapper.isPrepared())
        {
            return;
        }
        for (int i = 0; i < trackEnabledStates.length; i++)
        {
            if (!trackEnabledStates[i])
            {
                hlsextractorwrapper.discardUntil(i, l);
            }
        }

    }

    private HlsExtractorWrapper getCurrentExtractor()
    {
        HlsExtractorWrapper hlsextractorwrapper;
        for (hlsextractorwrapper = (HlsExtractorWrapper)extractors.getFirst(); extractors.size() > 1 && !haveSamplesForEnabledTracks(hlsextractorwrapper); hlsextractorwrapper = (HlsExtractorWrapper)extractors.getFirst())
        {
            ((HlsExtractorWrapper)extractors.removeFirst()).clear();
        }

        return hlsextractorwrapper;
    }

    private long getNextLoadPositionUs()
    {
        if (isPendingReset())
        {
            return pendingResetPositionUs;
        }
        if (loadingFinished)
        {
            return -1L;
        }
        if (currentTsLoadable != null)
        {
            return currentTsLoadable.endTimeUs;
        } else
        {
            return previousTsLoadable.endTimeUs;
        }
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean haveSamplesForEnabledTracks(HlsExtractorWrapper hlsextractorwrapper)
    {
        if (!hlsextractorwrapper.isPrepared())
        {
            return false;
        }
        for (int i = 0; i < trackEnabledStates.length; i++)
        {
            if (trackEnabledStates[i] && hlsextractorwrapper.hasSamples(i))
            {
                return true;
            }
        }

        return false;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != 0x8000000000000000L;
    }

    private boolean isTsChunk(Chunk chunk)
    {
        return chunk instanceof TsChunk;
    }

    private void maybeStartLoading()
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = getNextLoadPositionUs();
        boolean flag;
        if (currentLoadableException != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (loader.isLoading() || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag1 = loadControl.update(this, downstreamPositionUs, l1, flag1);
        if (flag)
        {
            if (l - currentLoadableExceptionTimestamp >= getRetryDelayMillis(currentLoadableExceptionCount))
            {
                currentLoadableException = null;
                loader.startLoading(currentLoadable, this);
            }
            return;
        }
        if (loader.isLoading() || !flag1)
        {
            return;
        }
        chunkSource.getChunkOperation(previousTsLoadable, pendingResetPositionUs, downstreamPositionUs, chunkOperationHolder);
        flag1 = chunkOperationHolder.endOfStream;
        Chunk chunk = chunkOperationHolder.chunk;
        chunkOperationHolder.clear();
        if (flag1)
        {
            loadingFinished = true;
            return;
        }
        if (chunk == null)
        {
            return;
        }
        currentLoadStartTimeMs = l;
        currentLoadable = chunk;
        if (isTsChunk(currentLoadable))
        {
            TsChunk tschunk = (TsChunk)currentLoadable;
            if (isPendingReset())
            {
                pendingResetPositionUs = 0x8000000000000000L;
            }
            HlsExtractorWrapper hlsextractorwrapper = tschunk.extractorWrapper;
            if (extractors.isEmpty() || extractors.getLast() != hlsextractorwrapper)
            {
                hlsextractorwrapper.init(loadControl.getAllocator());
                extractors.addLast(hlsextractorwrapper);
            }
            notifyLoadStarted(tschunk.dataSpec.length, tschunk.type, tschunk.trigger, tschunk.format, tschunk.startTimeUs, tschunk.endTimeUs);
            currentTsLoadable = tschunk;
        } else
        {
            notifyLoadStarted(currentLoadable.dataSpec.length, currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L);
        }
        loader.startLoading(currentLoadable, this);
    }

    private void notifyDownstreamFormatChanged(final Format format, final int trigger, final long positionUs)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls5());
        }
    }

    private void notifyLoadCanceled(final long bytesLoaded)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls3());
        }
    }

    private void notifyLoadCompleted(final long bytesLoaded, final int type, final int trigger, final Format format, final long mediaStartTimeUs, 
            final long mediaEndTimeUs, final long elapsedRealtimeMs, final long loadDurationMs)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls2());
        }
    }

    private void notifyLoadError(final IOException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls4());
        }
    }

    private void notifyLoadStarted(final long length, final int type, final int trigger, final Format format, final long mediaStartTimeUs, 
            final long mediaEndTimeUs)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void restartFrom(long l)
    {
        pendingResetPositionUs = l;
        loadingFinished = false;
        if (loader.isLoading())
        {
            loader.cancelLoading();
            return;
        } else
        {
            clearState();
            maybeStartLoading();
            return;
        }
    }

    public final boolean continueBuffering(int i, long l)
    {
        Assertions.checkState(prepared);
        Assertions.checkState(trackEnabledStates[i]);
        downstreamPositionUs = l;
        if (!extractors.isEmpty())
        {
            discardSamplesForDisabledTracks(getCurrentExtractor(), downstreamPositionUs);
        }
        if (loadingFinished)
        {
            return true;
        }
        maybeStartLoading();
        if (isPendingReset() || extractors.isEmpty())
        {
            return false;
        }
        int j = 0;
        do
        {
            if (j >= extractors.size())
            {
                break;
            }
            HlsExtractorWrapper hlsextractorwrapper = (HlsExtractorWrapper)extractors.get(j);
            if (!hlsextractorwrapper.isPrepared())
            {
                break;
            }
            if (hlsextractorwrapper.hasSamples(i))
            {
                return true;
            }
            j++;
        } while (true);
        return false;
    }

    public final void disable(int i)
    {
        Assertions.checkState(prepared);
        Assertions.checkState(trackEnabledStates[i]);
        enabledTrackCount = enabledTrackCount - 1;
        trackEnabledStates[i] = false;
        if (enabledTrackCount == 0)
        {
            chunkSource.reset();
            downstreamPositionUs = 0x8000000000000000L;
            if (loadControlRegistered)
            {
                loadControl.unregister(this);
                loadControlRegistered = false;
            }
            if (loader.isLoading())
            {
                loader.cancelLoading();
                return;
            }
            clearState();
            loadControl.trimAllocator();
        }
    }

    public final void enable(int i, long l)
    {
        Assertions.checkState(prepared);
        boolean flag;
        if (!trackEnabledStates[i])
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        enabledTrackCount = enabledTrackCount + 1;
        trackEnabledStates[i] = true;
        downstreamMediaFormats[i] = null;
        pendingDiscontinuities[i] = false;
        downstreamFormat = null;
        flag = loadControlRegistered;
        if (!loadControlRegistered)
        {
            loadControl.register(this, bufferSizeContribution);
            loadControlRegistered = true;
        }
        if (enabledTrackCount == 1)
        {
            lastSeekPositionUs = l;
            if (flag && downstreamPositionUs == l)
            {
                maybeStartLoading();
                return;
            }
            downstreamPositionUs = l;
            restartFrom(l);
        }
    }

    public final long getBufferedPositionUs()
    {
        Assertions.checkState(prepared);
        boolean flag;
        if (enabledTrackCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (isPendingReset())
        {
            return pendingResetPositionUs;
        }
        if (loadingFinished)
        {
            return -3L;
        }
        long l1 = ((HlsExtractorWrapper)extractors.getLast()).getLargestParsedTimestampUs();
        long l = l1;
        if (extractors.size() > 1)
        {
            l = Math.max(l1, ((HlsExtractorWrapper)extractors.get(extractors.size() - 2)).getLargestParsedTimestampUs());
        }
        if (l == 0x8000000000000000L)
        {
            return downstreamPositionUs;
        } else
        {
            return l;
        }
    }

    public final MediaFormat getFormat(int i)
    {
        Assertions.checkState(prepared);
        return trackFormat[i];
    }

    public final int getTrackCount()
    {
        Assertions.checkState(prepared);
        return trackCount;
    }

    public final void maybeThrowError()
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        }
        if (currentLoadable == null)
        {
            chunkSource.maybeThrowError();
        }
    }

    public final void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        notifyLoadCanceled(currentLoadable.bytesLoaded());
        if (enabledTrackCount > 0)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            clearState();
            loadControl.trimAllocator();
            return;
        }
    }

    public final void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        boolean flag;
        if (loadable == currentLoadable)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        long l = SystemClock.elapsedRealtime();
        long l1 = l - currentLoadStartTimeMs;
        chunkSource.onChunkLoadCompleted(currentLoadable);
        if (isTsChunk(currentLoadable))
        {
            boolean flag1;
            if (currentLoadable == currentTsLoadable)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assertions.checkState(flag1);
            previousTsLoadable = currentTsLoadable;
            notifyLoadCompleted(currentLoadable.bytesLoaded(), currentTsLoadable.type, currentTsLoadable.trigger, currentTsLoadable.format, currentTsLoadable.startTimeUs, currentTsLoadable.endTimeUs, l, l1);
        } else
        {
            notifyLoadCompleted(currentLoadable.bytesLoaded(), currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L, l, l1);
        }
        clearCurrentLoadable();
        if (enabledTrackCount > 0 || !prepared)
        {
            maybeStartLoading();
        }
    }

    public final void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        if (chunkSource.onChunkLoadError(currentLoadable, ioexception))
        {
            if (previousTsLoadable == null && !isPendingReset())
            {
                pendingResetPositionUs = lastSeekPositionUs;
            }
            clearCurrentLoadable();
        } else
        {
            currentLoadableException = ioexception;
            currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
            currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        }
        notifyLoadError(ioexception);
        maybeStartLoading();
    }

    public final boolean prepare(long l)
    {
        if (prepared)
        {
            return true;
        }
        if (!extractors.isEmpty())
        {
            do
            {
                HlsExtractorWrapper hlsextractorwrapper = (HlsExtractorWrapper)extractors.getFirst();
                if (hlsextractorwrapper.isPrepared())
                {
                    trackCount = hlsextractorwrapper.getTrackCount();
                    trackEnabledStates = new boolean[trackCount];
                    pendingDiscontinuities = new boolean[trackCount];
                    downstreamMediaFormats = new MediaFormat[trackCount];
                    trackFormat = new MediaFormat[trackCount];
                    l = chunkSource.getDurationUs();
                    for (int i = 0; i < trackCount; i++)
                    {
                        MediaFormat mediaformat1 = hlsextractorwrapper.getMediaFormat(i).copyWithDurationUs(l);
                        MediaFormat mediaformat = mediaformat1;
                        if (MimeTypes.isVideo(mediaformat1.mimeType))
                        {
                            mediaformat = mediaformat1.copyAsAdaptive();
                        }
                        trackFormat[i] = mediaformat;
                    }

                    prepared = true;
                    return true;
                }
                if (extractors.size() <= 1)
                {
                    break;
                }
                ((HlsExtractorWrapper)extractors.removeFirst()).clear();
            } while (true);
        }
        if (loader == null)
        {
            loader = new Loader("Loader:HLS");
        }
        if (!loadControlRegistered)
        {
            loadControl.register(this, bufferSizeContribution);
            loadControlRegistered = true;
        }
        if (!loader.isLoading())
        {
            pendingResetPositionUs = l;
            downstreamPositionUs = l;
        }
        maybeStartLoading();
        return false;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        Assertions.checkState(prepared);
        downstreamPositionUs = l;
        if (pendingDiscontinuities[i])
        {
            pendingDiscontinuities[i] = false;
            return -5;
        }
        if (flag)
        {
            return -2;
        }
        if (isPendingReset())
        {
            return -2;
        }
        Object obj = getCurrentExtractor();
        if (!((HlsExtractorWrapper) (obj)).isPrepared())
        {
            return -2;
        }
        if (downstreamFormat == null || !downstreamFormat.equals(((HlsExtractorWrapper) (obj)).format))
        {
            notifyDownstreamFormatChanged(((HlsExtractorWrapper) (obj)).format, ((HlsExtractorWrapper) (obj)).trigger, ((HlsExtractorWrapper) (obj)).startTimeUs);
            downstreamFormat = ((HlsExtractorWrapper) (obj)).format;
        }
        if (extractors.size() > 1)
        {
            ((HlsExtractorWrapper) (obj)).configureSpliceTo((HlsExtractorWrapper)extractors.get(1));
        }
        for (int j = 0; extractors.size() > j + 1 && !((HlsExtractorWrapper) (obj)).hasSamples(i);)
        {
            obj = extractors;
            j++;
            HlsExtractorWrapper hlsextractorwrapper = (HlsExtractorWrapper)((LinkedList) (obj)).get(j);
            obj = hlsextractorwrapper;
            if (!hlsextractorwrapper.isPrepared())
            {
                return -2;
            }
        }

        MediaFormat mediaformat = ((HlsExtractorWrapper) (obj)).getMediaFormat(i);
        if (mediaformat != null && !mediaformat.equals(downstreamMediaFormats[i]))
        {
            mediaformatholder.format = mediaformat;
            downstreamMediaFormats[i] = mediaformat;
            return -4;
        }
        if (((HlsExtractorWrapper) (obj)).getSample(i, sampleholder))
        {
            if (sampleholder.timeUs < lastSeekPositionUs)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            int k = sampleholder.flags;
            if (i != 0)
            {
                i = 0x8000000;
            } else
            {
                i = 0;
            }
            sampleholder.flags = k | i;
            return -3;
        }
        return !loadingFinished ? -2 : -1;
    }

    public final com.google.android.exoplayer.SampleSource.SampleSourceReader register()
    {
        remainingReleaseCount = remainingReleaseCount + 1;
        return this;
    }

    public final void release()
    {
        boolean flag;
        if (remainingReleaseCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        int i = remainingReleaseCount - 1;
        remainingReleaseCount = i;
        if (i == 0 && loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public final void seekToUs(long l)
    {
        Assertions.checkState(prepared);
        boolean flag;
        if (enabledTrackCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        long l1;
        if (isPendingReset())
        {
            l1 = pendingResetPositionUs;
        } else
        {
            l1 = downstreamPositionUs;
        }
        downstreamPositionUs = l;
        lastSeekPositionUs = l;
        if (l1 == l)
        {
            return;
        }
        downstreamPositionUs = l;
        for (int i = 0; i < pendingDiscontinuities.length; i++)
        {
            pendingDiscontinuities[i] = true;
        }

        restartFrom(l);
    }

    final long usToMs(long l)
    {
        return l / 1000L;
    }



    private class _cls5
        implements Runnable
    {

        final HlsSampleSource this$0;
        final Format val$format;
        final long val$positionUs;
        final int val$trigger;

        public void run()
        {
            eventListener.onDownstreamFormatChanged(eventSourceId, format, trigger, usToMs(positionUs));
        }

        _cls5()
        {
            this$0 = HlsSampleSource.this;
            format = format1;
            trigger = i;
            positionUs = l;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final HlsSampleSource this$0;
        final long val$bytesLoaded;

        public void run()
        {
            eventListener.onLoadCanceled(eventSourceId, bytesLoaded);
        }

        _cls3()
        {
            this$0 = HlsSampleSource.this;
            bytesLoaded = l;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final HlsSampleSource this$0;
        final long val$bytesLoaded;
        final long val$elapsedRealtimeMs;
        final Format val$format;
        final long val$loadDurationMs;
        final long val$mediaEndTimeUs;
        final long val$mediaStartTimeUs;
        final int val$trigger;
        final int val$type;

        public void run()
        {
            eventListener.onLoadCompleted(eventSourceId, bytesLoaded, type, trigger, format, usToMs(mediaStartTimeUs), usToMs(mediaEndTimeUs), elapsedRealtimeMs, loadDurationMs);
        }

        _cls2()
        {
            this$0 = HlsSampleSource.this;
            bytesLoaded = l;
            type = i;
            trigger = j;
            format = format1;
            mediaStartTimeUs = l1;
            mediaEndTimeUs = l2;
            elapsedRealtimeMs = l3;
            loadDurationMs = l4;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final HlsSampleSource this$0;
        final IOException val$e;

        public void run()
        {
            eventListener.onLoadError(eventSourceId, e);
        }

        _cls4()
        {
            this$0 = HlsSampleSource.this;
            e = ioexception;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final HlsSampleSource this$0;
        final Format val$format;
        final long val$length;
        final long val$mediaEndTimeUs;
        final long val$mediaStartTimeUs;
        final int val$trigger;
        final int val$type;

        public void run()
        {
            eventListener.onLoadStarted(eventSourceId, length, type, trigger, format, usToMs(mediaStartTimeUs), usToMs(mediaEndTimeUs));
        }

        _cls1()
        {
            this$0 = HlsSampleSource.this;
            length = l;
            type = i;
            trigger = j;
            format = format1;
            mediaStartTimeUs = l1;
            mediaEndTimeUs = l2;
            super();
        }
    }

}
