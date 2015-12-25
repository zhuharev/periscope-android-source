// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkOperationHolder, BaseMediaChunk, ChunkSource, Chunk, 
//            Format, MediaChunk, BaseChunkSampleSourceEventListener

public class ChunkSampleSource
    implements SampleSource, com.google.android.exoplayer.SampleSource.SampleSourceReader, com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
        extends BaseChunkSampleSourceEventListener
    {
    }


    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final long NO_RESET_PENDING = 0x8000000000000000L;
    private static final int STATE_ENABLED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_PREPARED = 2;
    private final int bufferSizeContribution;
    private final ChunkSource chunkSource;
    private long currentLoadStartTimeMs;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final ChunkOperationHolder currentLoadableHolder;
    private Format downstreamFormat;
    private MediaFormat downstreamMediaFormat;
    private long downstreamPositionUs;
    private int enabledTrackCount;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int eventSourceId;
    private long lastPerformedBufferOperation;
    private long lastSeekPositionUs;
    private final LoadControl loadControl;
    private Loader loader;
    private boolean loadingFinished;
    private final LinkedList mediaChunks;
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuity;
    private long pendingResetPositionUs;
    private final List readOnlyMediaChunks;
    private final DefaultTrackOutput sampleQueue;
    private int state;

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i)
    {
        this(chunksource, loadcontrol, i, null, null, 0);
    }

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j)
    {
        this(chunksource, loadcontrol, i, handler, eventlistener, j, 3);
    }

    public ChunkSampleSource(ChunkSource chunksource, LoadControl loadcontrol, int i, Handler handler, EventListener eventlistener, int j, int k)
    {
        chunkSource = chunksource;
        loadControl = loadcontrol;
        bufferSizeContribution = i;
        eventHandler = handler;
        eventListener = eventlistener;
        eventSourceId = j;
        minLoadableRetryCount = k;
        currentLoadableHolder = new ChunkOperationHolder();
        mediaChunks = new LinkedList();
        readOnlyMediaChunks = Collections.unmodifiableList(mediaChunks);
        sampleQueue = new DefaultTrackOutput(loadcontrol.getAllocator());
        state = 0;
        pendingResetPositionUs = 0x8000000000000000L;
    }

    private void clearCurrentLoadable()
    {
        currentLoadableHolder.chunk = null;
        clearCurrentLoadableException();
    }

    private void clearCurrentLoadableException()
    {
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private boolean discardUpstreamMediaChunks(int i)
    {
        if (mediaChunks.size() <= i)
        {
            return false;
        }
        long l = 0L;
        long l1 = ((BaseMediaChunk)mediaChunks.getLast()).endTimeUs;
        BaseMediaChunk basemediachunk = null;
        while (mediaChunks.size() > i) 
        {
            basemediachunk = (BaseMediaChunk)mediaChunks.removeLast();
            l = basemediachunk.startTimeUs;
        }
        sampleQueue.discardUpstreamSamples(basemediachunk.getFirstSampleIndex());
        notifyUpstreamDiscarded(l, l1);
        return true;
    }

    private void doChunkOperation()
    {
        currentLoadableHolder.endOfStream = false;
        currentLoadableHolder.queueSize = readOnlyMediaChunks.size();
        chunkSource.getChunkOperation(readOnlyMediaChunks, pendingResetPositionUs, downstreamPositionUs, currentLoadableHolder);
        loadingFinished = currentLoadableHolder.endOfStream;
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
        } else
        {
            return ((BaseMediaChunk)mediaChunks.getLast()).endTimeUs;
        }
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean isMediaChunk(Chunk chunk)
    {
        return chunk instanceof BaseMediaChunk;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != 0x8000000000000000L;
    }

    private void maybeStartLoading()
    {
        Chunk chunk = currentLoadableHolder.chunk;
        if (chunk == null)
        {
            return;
        }
        currentLoadStartTimeMs = SystemClock.elapsedRealtime();
        if (isMediaChunk(chunk))
        {
            BaseMediaChunk basemediachunk = (BaseMediaChunk)chunk;
            basemediachunk.init(sampleQueue);
            mediaChunks.add(basemediachunk);
            if (isPendingReset())
            {
                pendingResetPositionUs = 0x8000000000000000L;
            }
            notifyLoadStarted(basemediachunk.dataSpec.length, basemediachunk.type, basemediachunk.trigger, basemediachunk.format, basemediachunk.startTimeUs, basemediachunk.endTimeUs);
        } else
        {
            notifyLoadStarted(chunk.dataSpec.length, chunk.type, chunk.trigger, chunk.format, -1L, -1L);
        }
        loader.startLoading(chunk, this);
    }

    private void notifyDownstreamFormatChanged(final Format format, final int trigger, final long positionUs)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls6());
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

    private void notifyUpstreamDiscarded(final long mediaStartTimeUs, final long mediaEndTimeUs)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls5());
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
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            updateLoadControl();
            return;
        }
    }

    private void resumeFromBackOff()
    {
        currentLoadableException = null;
        Chunk chunk = currentLoadableHolder.chunk;
        if (!isMediaChunk(chunk))
        {
            doChunkOperation();
            discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
            if (currentLoadableHolder.chunk == chunk)
            {
                loader.startLoading(chunk, this);
                return;
            } else
            {
                notifyLoadCanceled(chunk.bytesLoaded());
                maybeStartLoading();
                return;
            }
        }
        if (chunk == mediaChunks.getFirst())
        {
            loader.startLoading(chunk, this);
            return;
        }
        BaseMediaChunk basemediachunk = (BaseMediaChunk)mediaChunks.removeLast();
        boolean flag;
        if (chunk == basemediachunk)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        doChunkOperation();
        mediaChunks.add(basemediachunk);
        if (currentLoadableHolder.chunk == chunk)
        {
            loader.startLoading(chunk, this);
            return;
        } else
        {
            notifyLoadCanceled(chunk.bytesLoaded());
            discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
            clearCurrentLoadableException();
            maybeStartLoading();
            return;
        }
    }

    private void updateLoadControl()
    {
        boolean flag;
        long l;
        long l2;
        boolean flag1;
label0:
        {
            l2 = SystemClock.elapsedRealtime();
            long l1 = getNextLoadPositionUs();
            if (currentLoadableException != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (loader.isLoading() || flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l = l1;
            if (flag1)
            {
                break label0;
            }
            if (currentLoadableHolder.chunk != null || l1 == -1L)
            {
                l = l1;
                if (l2 - lastPerformedBufferOperation <= 2000L)
                {
                    break label0;
                }
            }
            lastPerformedBufferOperation = l2;
            doChunkOperation();
            boolean flag2 = discardUpstreamMediaChunks(currentLoadableHolder.queueSize);
            if (currentLoadableHolder.chunk == null)
            {
                l = -1L;
            } else
            {
                l = l1;
                if (flag2)
                {
                    l = getNextLoadPositionUs();
                }
            }
        }
        flag1 = loadControl.update(this, downstreamPositionUs, l, flag1);
        if (flag)
        {
            if (l2 - currentLoadableExceptionTimestamp >= getRetryDelayMillis(currentLoadableExceptionCount))
            {
                resumeFromBackOff();
            }
            return;
        }
        if (!loader.isLoading() && flag1)
        {
            maybeStartLoading();
        }
    }

    public boolean continueBuffering(int i, long l)
    {
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        downstreamPositionUs = l;
        chunkSource.continueBuffering(l);
        updateLoadControl();
        return loadingFinished || !sampleQueue.isEmpty();
    }

    public void disable(int i)
    {
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        i = enabledTrackCount - 1;
        enabledTrackCount = i;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 2;
        chunkSource.disable(mediaChunks);
        loadControl.unregister(this);
        if (loader.isLoading())
        {
            loader.cancelLoading();
            return;
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
            return;
        }
        Exception exception;
        exception;
        loadControl.unregister(this);
        if (loader.isLoading())
        {
            loader.cancelLoading();
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
        }
        throw exception;
    }

    public void enable(int i, long l)
    {
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        int j = enabledTrackCount;
        enabledTrackCount = j + 1;
        if (j == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 3;
        chunkSource.enable(i);
        loadControl.register(this, bufferSizeContribution);
        downstreamFormat = null;
        downstreamMediaFormat = null;
        downstreamPositionUs = l;
        lastSeekPositionUs = l;
        pendingDiscontinuity = false;
        restartFrom(l);
    }

    public long getBufferedPositionUs()
    {
        boolean flag;
        if (state == 3)
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
        long l = sampleQueue.getLargestParsedTimestampUs();
        if (l == 0x8000000000000000L)
        {
            return downstreamPositionUs;
        } else
        {
            return l;
        }
    }

    public MediaFormat getFormat(int i)
    {
        boolean flag;
        if (state == 2 || state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return chunkSource.getFormat(i);
    }

    public int getTrackCount()
    {
        boolean flag;
        if (state == 2 || state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return chunkSource.getTrackCount();
    }

    public void maybeThrowError()
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        }
        if (currentLoadableHolder.chunk == null)
        {
            chunkSource.maybeThrowError();
        }
    }

    public void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        notifyLoadCanceled(currentLoadableHolder.chunk.bytesLoaded());
        clearCurrentLoadable();
        if (state == 3)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            sampleQueue.clear();
            mediaChunks.clear();
            clearCurrentLoadable();
            loadControl.trimAllocator();
            return;
        }
    }

    public void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = l - currentLoadStartTimeMs;
        loadable = currentLoadableHolder.chunk;
        chunkSource.onChunkLoadCompleted(loadable);
        if (isMediaChunk(loadable))
        {
            BaseMediaChunk basemediachunk = (BaseMediaChunk)loadable;
            notifyLoadCompleted(loadable.bytesLoaded(), basemediachunk.type, basemediachunk.trigger, basemediachunk.format, basemediachunk.startTimeUs, basemediachunk.endTimeUs, l, l1);
        } else
        {
            notifyLoadCompleted(loadable.bytesLoaded(), ((Chunk) (loadable)).type, ((Chunk) (loadable)).trigger, ((Chunk) (loadable)).format, -1L, -1L, l, l1);
        }
        clearCurrentLoadable();
        updateLoadControl();
    }

    public void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        currentLoadableException = ioexception;
        currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        notifyLoadError(ioexception);
        chunkSource.onChunkLoadError(currentLoadableHolder.chunk, ioexception);
        updateLoadControl();
    }

    protected void onSampleRead(MediaChunk mediachunk, SampleHolder sampleholder)
    {
    }

    public boolean prepare(long l)
    {
        boolean flag;
        if (state == 1 || state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (state == 2)
        {
            return true;
        }
        if (!chunkSource.prepare())
        {
            return false;
        }
        if (chunkSource.getTrackCount() > 0)
        {
            loader = new Loader((new StringBuilder("Loader:")).append(chunkSource.getFormat(0).mimeType).toString());
        }
        state = 2;
        return true;
    }

    public int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        boolean flag1;
        if (state == 3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        downstreamPositionUs = l;
        if (pendingDiscontinuity)
        {
            pendingDiscontinuity = false;
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
        if (!sampleQueue.isEmpty())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        BaseMediaChunk basemediachunk;
        for (basemediachunk = (BaseMediaChunk)mediaChunks.getFirst(); i != 0 && mediaChunks.size() > 1 && ((BaseMediaChunk)mediaChunks.get(1)).getFirstSampleIndex() <= sampleQueue.getReadIndex(); basemediachunk = (BaseMediaChunk)mediaChunks.getFirst())
        {
            mediaChunks.removeFirst();
        }

        if (downstreamFormat == null || !downstreamFormat.equals(basemediachunk.format))
        {
            notifyDownstreamFormatChanged(basemediachunk.format, basemediachunk.trigger, basemediachunk.startTimeUs);
            downstreamFormat = basemediachunk.format;
        }
        if (i != 0 || basemediachunk.isMediaFormatFinal)
        {
            MediaFormat mediaformat = basemediachunk.getMediaFormat();
            if (!mediaformat.equals(downstreamMediaFormat))
            {
                mediaformatholder.format = mediaformat;
                mediaformatholder.drmInitData = basemediachunk.getDrmInitData();
                downstreamMediaFormat = mediaformat;
                return -4;
            }
        }
        if (i == 0)
        {
            return !loadingFinished ? -2 : -1;
        }
        if (sampleQueue.getSample(sampleholder))
        {
            if (sampleholder.timeUs < lastSeekPositionUs)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            int j = sampleholder.flags;
            if (i != 0)
            {
                i = 0x8000000;
            } else
            {
                i = 0;
            }
            sampleholder.flags = j | i;
            onSampleRead(basemediachunk, sampleholder);
            return -3;
        } else
        {
            return -2;
        }
    }

    public com.google.android.exoplayer.SampleSource.SampleSourceReader register()
    {
        boolean flag;
        if (state == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 1;
        return this;
    }

    public void release()
    {
        boolean flag;
        if (state != 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (loader != null)
        {
            loader.release();
            loader = null;
        }
        state = 0;
    }

    public void seekToUs(long l)
    {
        boolean flag2;
        if (state == 3)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Assertions.checkState(flag2);
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
        boolean flag;
        if (!isPendingReset() && sampleQueue.skipToKeyframeBefore(l))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            boolean flag1;
            if (!sampleQueue.isEmpty())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            for (; flag1 && mediaChunks.size() > 1 && ((BaseMediaChunk)mediaChunks.get(1)).getFirstSampleIndex() <= sampleQueue.getReadIndex(); mediaChunks.removeFirst()) { }
        } else
        {
            restartFrom(l);
        }
        pendingDiscontinuity = true;
    }

    protected final long usToMs(long l)
    {
        return l / 1000L;
    }



    private class _cls6
        implements Runnable
    {

        final ChunkSampleSource this$0;
        final Format val$format;
        final long val$positionUs;
        final int val$trigger;

        public void run()
        {
            eventListener.onDownstreamFormatChanged(eventSourceId, format, trigger, usToMs(positionUs));
        }

        _cls6()
        {
            this$0 = ChunkSampleSource.this;
            format = format1;
            trigger = i;
            positionUs = l;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final ChunkSampleSource this$0;
        final long val$bytesLoaded;

        public void run()
        {
            eventListener.onLoadCanceled(eventSourceId, bytesLoaded);
        }

        _cls3()
        {
            this$0 = ChunkSampleSource.this;
            bytesLoaded = l;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final ChunkSampleSource this$0;
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
            this$0 = ChunkSampleSource.this;
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

        final ChunkSampleSource this$0;
        final IOException val$e;

        public void run()
        {
            eventListener.onLoadError(eventSourceId, e);
        }

        _cls4()
        {
            this$0 = ChunkSampleSource.this;
            e = ioexception;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final ChunkSampleSource this$0;
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
            this$0 = ChunkSampleSource.this;
            length = l;
            type = i;
            trigger = j;
            format = format1;
            mediaStartTimeUs = l1;
            mediaEndTimeUs = l2;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final ChunkSampleSource this$0;
        final long val$mediaEndTimeUs;
        final long val$mediaStartTimeUs;

        public void run()
        {
            eventListener.onUpstreamDiscarded(eventSourceId, usToMs(mediaStartTimeUs), usToMs(mediaEndTimeUs));
        }

        _cls5()
        {
            this$0 = ChunkSampleSource.this;
            mediaStartTimeUs = l;
            mediaEndTimeUs = l1;
            super();
        }
    }

}
