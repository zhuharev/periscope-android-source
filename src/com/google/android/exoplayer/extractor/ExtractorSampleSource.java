// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorOutput, Extractor, SeekMap, TrackOutput, 
//            PositionHolder, DefaultExtractorInput, ExtractorInput, DefaultTrackOutput

public final class ExtractorSampleSource
    implements SampleSource, com.google.android.exoplayer.SampleSource.SampleSourceReader, ExtractorOutput, com.google.android.exoplayer.upstream.Loader.Callback
{
    static class ExtractingLoadable
        implements com.google.android.exoplayer.upstream.Loader.Loadable
    {

        private final Allocator allocator;
        private final DataSource dataSource;
        private final ExtractorHolder extractorHolder;
        private volatile boolean loadCanceled;
        private boolean pendingExtractorSeek;
        private final PositionHolder positionHolder = new PositionHolder();
        private final int requestedBufferSize;
        private final Uri uri;

        public void cancelLoad()
        {
            loadCanceled = true;
        }

        public boolean isLoadCanceled()
        {
            return loadCanceled;
        }

        public void load()
        {
            int i = 0;
_L4:
            DefaultExtractorInput defaultextractorinput;
            DefaultExtractorInput defaultextractorinput1;
            int k;
            if (i != 0 || loadCanceled)
            {
                break; /* Loop/switch isn't completed */
            }
            defaultextractorinput1 = null;
            k = i;
            defaultextractorinput = defaultextractorinput1;
            long l3 = positionHolder.position;
            k = i;
            defaultextractorinput = defaultextractorinput1;
            long l2 = dataSource.open(new DataSpec(uri, l3, -1L, null));
            long l1;
            long l = l2;
            l1 = l;
            if (l2 != -1L)
            {
                l1 = l + l3;
            }
            k = i;
            defaultextractorinput = defaultextractorinput1;
            defaultextractorinput1 = new DefaultExtractorInput(dataSource, l3, l1);
            k = i;
            defaultextractorinput = defaultextractorinput1;
            Extractor extractor = extractorHolder.selectExtractor(defaultextractorinput1);
            int j;
            j = i;
            k = i;
            defaultextractorinput = defaultextractorinput1;
            if (!pendingExtractorSeek)
            {
                break MISSING_BLOCK_LABEL_171;
            }
            k = i;
            defaultextractorinput = defaultextractorinput1;
            extractor.seek();
            k = i;
            defaultextractorinput = defaultextractorinput1;
            pendingExtractorSeek = false;
            j = i;
_L2:
            if (j != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = j;
            defaultextractorinput = defaultextractorinput1;
            if (loadCanceled)
            {
                break; /* Loop/switch isn't completed */
            }
            k = j;
            defaultextractorinput = defaultextractorinput1;
            allocator.blockWhileTotalBytesAllocatedExceeds(requestedBufferSize);
            k = j;
            defaultextractorinput = defaultextractorinput1;
            j = extractor.read(defaultextractorinput1, positionHolder);
            if (true) goto _L2; else goto _L1
_L1:
            if (j == 1)
            {
                i = 0;
            } else
            {
                positionHolder.position = defaultextractorinput1.getPosition();
                i = j;
            }
            dataSource.close();
            if (true) goto _L4; else goto _L3
            Exception exception;
            exception;
            if (k != 1 && defaultextractorinput != null)
            {
                positionHolder.position = defaultextractorinput.getPosition();
            }
            dataSource.close();
            throw exception;
_L3:
        }

        public ExtractingLoadable(Uri uri1, DataSource datasource, ExtractorHolder extractorholder, Allocator allocator1, int i, long l)
        {
            uri = (Uri)Assertions.checkNotNull(uri1);
            dataSource = (DataSource)Assertions.checkNotNull(datasource);
            extractorHolder = (ExtractorHolder)Assertions.checkNotNull(extractorholder);
            allocator = (Allocator)Assertions.checkNotNull(allocator1);
            requestedBufferSize = i;
            positionHolder.position = l;
            pendingExtractorSeek = true;
        }
    }

    static final class ExtractorHolder
    {

        private Extractor extractor;
        private final ExtractorOutput extractorOutput;
        private final Extractor extractors[];

        public final Extractor selectExtractor(ExtractorInput extractorinput)
        {
            if (extractor != null)
            {
                return extractor;
            }
            Extractor aextractor[] = extractors;
            int j = aextractor.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    break;
                }
                Extractor extractor1 = aextractor[i];
                try
                {
                    if (extractor1.sniff(extractorinput))
                    {
                        extractor = extractor1;
                        break;
                    }
                }
                catch (EOFException eofexception) { }
                extractorinput.resetPeekPosition();
                i++;
            } while (true);
            if (extractor == null)
            {
                throw new UnrecognizedInputFormatException(extractors);
            } else
            {
                extractor.init(extractorOutput);
                return extractor;
            }
        }

        public ExtractorHolder(Extractor aextractor[], ExtractorOutput extractoroutput)
        {
            extractors = aextractor;
            extractorOutput = extractoroutput;
        }
    }

    public static final class UnrecognizedInputFormatException extends ParserException
    {

        public UnrecognizedInputFormatException(Extractor aextractor[])
        {
            super((new StringBuilder("None of the available extractors (")).append(Util.getCommaDelimitedSimpleClassNames(aextractor)).append(") could read the stream.").toString());
        }
    }


    private static final List DEFAULT_EXTRACTOR_CLASSES;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    private static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    private static final long NO_RESET_PENDING = 0x8000000000000000L;
    private final Allocator allocator;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final DataSource dataSource;
    private long downstreamPositionUs;
    private volatile DrmInitData drmInitData;
    private int enabledTrackCount;
    private int extractedSampleCount;
    private int extractedSampleCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    private boolean havePendingNextSampleUs;
    private long lastSeekPositionUs;
    private ExtractingLoadable loadable;
    private Loader loader;
    private boolean loadingFinished;
    private long maxTrackDurationUs;
    private MediaFormat mediaFormats[];
    private final int minLoadableRetryCount;
    private boolean pendingDiscontinuities[];
    private boolean pendingMediaFormat[];
    private long pendingNextSampleUs;
    private long pendingResetPositionUs;
    private boolean prepared;
    private int remainingReleaseCount;
    private final int requestedBufferSize;
    private final SparseArray sampleQueues;
    private long sampleTimeOffsetUs;
    private volatile SeekMap seekMap;
    private boolean trackEnabledStates[];
    private volatile boolean tracksBuilt;
    private final Uri uri;

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, int i, int j, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, ((Allocator) (new DefaultAllocator(0x10000))), i, j, aextractor);
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, int i, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, ((Allocator) (new DefaultAllocator(0x10000))), i, aextractor);
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, Allocator allocator1, int i, int j, Extractor aextractor[])
    {
label0:
        {
            Object();
            uri = uri1;
            dataSource = datasource;
            allocator = allocator1;
            requestedBufferSize = i;
            minLoadableRetryCount = j;
            if (aextractor != null)
            {
                uri1 = aextractor;
                if (aextractor.length != 0)
                {
                    break label0;
                }
            }
            datasource = new Extractor[DEFAULT_EXTRACTOR_CLASSES.size()];
            i = 0;
            do
            {
                uri1 = datasource;
                if (i >= datasource.length)
                {
                    break;
                }
                try
                {
                    datasource[i] = (Extractor)((Class)DEFAULT_EXTRACTOR_CLASSES.get(i)).newInstance();
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri1)
                {
                    throw new IllegalStateException("Unexpected error creating default extractor", uri1);
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri1)
                {
                    throw new IllegalStateException("Unexpected error creating default extractor", uri1);
                }
                i++;
            } while (true);
        }
        extractorHolder = new ExtractorHolder(uri1, this);
        sampleQueues = new SparseArray();
        pendingResetPositionUs = 0x8000000000000000L;
    }

    public transient ExtractorSampleSource(Uri uri1, DataSource datasource, Allocator allocator1, int i, Extractor aextractor[])
    {
        ExtractorSampleSource(uri1, datasource, allocator1, i, -1, aextractor);
    }

    private void clearState()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            ((InternalTrackOutput)sampleQueues.valueAt(i)).clear();
        }

        loadable = null;
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private ExtractingLoadable createLoadableFromPositionUs(long l)
    {
        return new ExtractingLoadable(uri, dataSource, extractorHolder, allocator, requestedBufferSize, seekMap.getPosition(l));
    }

    private ExtractingLoadable createLoadableFromStart()
    {
        return new ExtractingLoadable(uri, dataSource, extractorHolder, allocator, requestedBufferSize, 0L);
    }

    private void discardSamplesForDisabledTracks(long l)
    {
        for (int i = 0; i < trackEnabledStates.length; i++)
        {
            if (!trackEnabledStates[i])
            {
                ((InternalTrackOutput)sampleQueues.valueAt(i)).discardUntil(l);
            }
        }

    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private boolean haveFormatsForAllTracks()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            if (!((InternalTrackOutput)sampleQueues.valueAt(i)).hasFormat())
            {
                return false;
            }
        }

        return true;
    }

    private boolean isCurrentLoadableExceptionFatal()
    {
        return currentLoadableException instanceof UnrecognizedInputFormatException;
    }

    private boolean isPendingReset()
    {
        return pendingResetPositionUs != 0x8000000000000000L;
    }

    private void maybeStartLoading()
    {
        if (loadingFinished || loader.isLoading())
        {
            return;
        }
        if (currentLoadableException != null)
        {
            if (isCurrentLoadableExceptionFatal())
            {
                return;
            }
            boolean flag;
            if (loadable != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            if (SystemClock.elapsedRealtime() - currentLoadableExceptionTimestamp >= getRetryDelayMillis(currentLoadableExceptionCount))
            {
                currentLoadableException = null;
                if (!prepared)
                {
                    for (int i = 0; i < sampleQueues.size(); i++)
                    {
                        ((InternalTrackOutput)sampleQueues.valueAt(i)).clear();
                    }

                    loadable = createLoadableFromStart();
                } else
                if (!seekMap.isSeekable() && maxTrackDurationUs == -1L)
                {
                    for (int j = 0; j < sampleQueues.size(); j++)
                    {
                        ((InternalTrackOutput)sampleQueues.valueAt(j)).clear();
                    }

                    loadable = createLoadableFromStart();
                    pendingNextSampleUs = downstreamPositionUs;
                    havePendingNextSampleUs = true;
                }
                extractedSampleCountAtStartOfLoad = extractedSampleCount;
                loader.startLoading(loadable, this);
            }
            return;
        }
        sampleTimeOffsetUs = 0L;
        havePendingNextSampleUs = false;
        if (!prepared)
        {
            loadable = createLoadableFromStart();
        } else
        {
            Assertions.checkState(isPendingReset());
            if (maxTrackDurationUs != -1L && pendingResetPositionUs >= maxTrackDurationUs)
            {
                loadingFinished = true;
                pendingResetPositionUs = 0x8000000000000000L;
                return;
            }
            loadable = createLoadableFromPositionUs(pendingResetPositionUs);
            pendingResetPositionUs = 0x8000000000000000L;
        }
        extractedSampleCountAtStartOfLoad = extractedSampleCount;
        loader.startLoading(loadable, this);
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
        discardSamplesForDisabledTracks(downstreamPositionUs);
        if (loadingFinished)
        {
            return true;
        }
        maybeStartLoading();
        if (isPendingReset())
        {
            return false;
        }
        return !((InternalTrackOutput)sampleQueues.valueAt(i)).isEmpty();
    }

    public final void disable(int i)
    {
        Assertions.checkState(prepared);
        Assertions.checkState(trackEnabledStates[i]);
        enabledTrackCount = enabledTrackCount - 1;
        trackEnabledStates[i] = false;
        if (enabledTrackCount == 0)
        {
            downstreamPositionUs = 0x8000000000000000L;
            if (loader.isLoading())
            {
                loader.cancelLoading();
                return;
            }
            clearState();
            allocator.trim(0);
        }
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
        drmInitData = drminitdata;
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
        pendingMediaFormat[i] = true;
        pendingDiscontinuities[i] = false;
        if (enabledTrackCount == 1)
        {
            if (!seekMap.isSeekable())
            {
                l = 0L;
            }
            downstreamPositionUs = l;
            lastSeekPositionUs = l;
            restartFrom(l);
        }
    }

    public final void endTracks()
    {
        tracksBuilt = true;
    }

    public final long getBufferedPositionUs()
    {
        if (loadingFinished)
        {
            return -3L;
        }
        if (isPendingReset())
        {
            return pendingResetPositionUs;
        }
        long l = 0x8000000000000000L;
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            l = Math.max(l, ((InternalTrackOutput)sampleQueues.valueAt(i)).getLargestParsedTimestampUs());
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
        return mediaFormats[i];
    }

    public final int getTrackCount()
    {
        return sampleQueues.size();
    }

    public final void maybeThrowError()
    {
        if (currentLoadableException == null)
        {
            return;
        }
        if (isCurrentLoadableExceptionFatal())
        {
            throw currentLoadableException;
        }
        int i;
        if (minLoadableRetryCount != -1)
        {
            i = minLoadableRetryCount;
        } else
        if (seekMap != null && !seekMap.isSeekable())
        {
            i = 6;
        } else
        {
            i = 3;
        }
        if (currentLoadableExceptionCount > i)
        {
            throw currentLoadableException;
        } else
        {
            return;
        }
    }

    public final void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable1)
    {
        if (enabledTrackCount > 0)
        {
            restartFrom(pendingResetPositionUs);
            return;
        } else
        {
            clearState();
            allocator.trim(0);
            return;
        }
    }

    public final void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable1)
    {
        loadingFinished = true;
    }

    public final void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable1, IOException ioexception)
    {
        currentLoadableException = ioexception;
        int i;
        if (extractedSampleCount > extractedSampleCountAtStartOfLoad)
        {
            i = 1;
        } else
        {
            i = currentLoadableExceptionCount + 1;
        }
        currentLoadableExceptionCount = i;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        maybeStartLoading();
    }

    public final boolean prepare(long l)
    {
        if (prepared)
        {
            return true;
        }
        if (loader == null)
        {
            loader = new Loader("Loader:ExtractorSampleSource");
        }
        maybeStartLoading();
        if (seekMap != null && tracksBuilt && haveFormatsForAllTracks())
        {
            int j = sampleQueues.size();
            trackEnabledStates = new boolean[j];
            pendingDiscontinuities = new boolean[j];
            pendingMediaFormat = new boolean[j];
            mediaFormats = new MediaFormat[j];
            maxTrackDurationUs = -1L;
            for (int i = 0; i < j; i++)
            {
                MediaFormat mediaformat = ((InternalTrackOutput)sampleQueues.valueAt(i)).getFormat();
                mediaFormats[i] = mediaformat;
                if (mediaformat.durationUs != -1L && mediaformat.durationUs > maxTrackDurationUs)
                {
                    maxTrackDurationUs = mediaformat.durationUs;
                }
            }

            prepared = true;
            return true;
        } else
        {
            return false;
        }
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        downstreamPositionUs = l;
        if (pendingDiscontinuities[i])
        {
            pendingDiscontinuities[i] = false;
            return -5;
        }
        if (flag || isPendingReset())
        {
            return -2;
        }
        InternalTrackOutput internaltrackoutput = (InternalTrackOutput)sampleQueues.valueAt(i);
        if (pendingMediaFormat[i])
        {
            mediaformatholder.format = internaltrackoutput.getFormat();
            mediaformatholder.drmInitData = drmInitData;
            pendingMediaFormat[i] = false;
            return -4;
        }
        if (internaltrackoutput.getSample(sampleholder))
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
            if (havePendingNextSampleUs)
            {
                sampleTimeOffsetUs = pendingNextSampleUs - sampleholder.timeUs;
                havePendingNextSampleUs = false;
            }
            sampleholder.timeUs = sampleholder.timeUs + sampleTimeOffsetUs;
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

    public final void seekMap(SeekMap seekmap)
    {
        seekMap = seekmap;
    }

    public final void seekToUs(long l)
    {
        Assertions.checkState(prepared);
        boolean flag1;
        if (enabledTrackCount > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        if (!seekMap.isSeekable())
        {
            l = 0L;
        }
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
        if (!isPendingReset())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (int j = 0; flag && j < sampleQueues.size(); j++)
        {
            flag &= ((InternalTrackOutput)sampleQueues.valueAt(j)).skipToKeyframeBefore(l);
        }

        if (!flag)
        {
            restartFrom(l);
        }
        for (int i = 0; i < pendingDiscontinuities.length; i++)
        {
            pendingDiscontinuities[i] = true;
        }

    }

    public final TrackOutput track(int i)
    {
        InternalTrackOutput internaltrackoutput1 = (InternalTrackOutput)sampleQueues.get(i);
        InternalTrackOutput internaltrackoutput = internaltrackoutput1;
        if (internaltrackoutput1 == null)
        {
            internaltrackoutput = new InternalTrackOutput(allocator);
            sampleQueues.put(i, internaltrackoutput);
        }
        return internaltrackoutput;
    }

    static 
    {
        DEFAULT_EXTRACTOR_CLASSES = new ArrayList();
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.webm.WebmExtractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception1) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp4.Mp4Extractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception2) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp3.Mp3Extractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception3) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.ts.AdtsExtractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception4) { }
        try
        {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.ts.TsExtractor").asSubclass(com/google/android/exoplayer/extractor/Extractor));
        }
        catch (ClassNotFoundException classnotfoundexception5) { }
    }


/*
    static int access$008(ExtractorSampleSource extractorsamplesource)
    {
        int i = extractorsamplesource.extractedSampleCount;
        extractorsamplesource.extractedSampleCount = i + 1;
        return i;
    }

*/
}
