// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer:
//            SampleSource, MediaFormat, MediaFormatHolder, SampleHolder

public final class SingleSampleSource
    implements SampleSource, SampleSource.SampleSourceReader, com.google.android.exoplayer.upstream.Loader.Callback, com.google.android.exoplayer.upstream.Loader.Loadable
{

    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final int INITIAL_SAMPLE_SIZE = 1;
    private static final int STATE_END_OF_STREAM = 2;
    private static final int STATE_SEND_FORMAT = 0;
    private static final int STATE_SEND_SAMPLE = 1;
    private IOException currentLoadableException;
    private int currentLoadableExceptionCount;
    private long currentLoadableExceptionTimestamp;
    private final DataSource dataSource;
    private final MediaFormat format;
    private Loader loader;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private byte sampleData[];
    private int sampleSize;
    private int state;
    private final Uri uri;

    public SingleSampleSource(Uri uri1, DataSource datasource, MediaFormat mediaformat)
    {
        this(uri1, datasource, mediaformat, 3);
    }

    public SingleSampleSource(Uri uri1, DataSource datasource, MediaFormat mediaformat, int i)
    {
        uri = uri1;
        dataSource = datasource;
        format = mediaformat;
        minLoadableRetryCount = i;
        sampleData = new byte[1];
    }

    private void clearCurrentLoadableException()
    {
        currentLoadableException = null;
        currentLoadableExceptionCount = 0;
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private void maybeStartLoading()
    {
        if (loadingFinished || state == 2 || loader.isLoading())
        {
            return;
        }
        if (currentLoadableException != null)
        {
            if (SystemClock.elapsedRealtime() - currentLoadableExceptionTimestamp < getRetryDelayMillis(currentLoadableExceptionCount))
            {
                return;
            }
            currentLoadableException = null;
        }
        loader.startLoading(this, this);
    }

    public final void cancelLoad()
    {
    }

    public final boolean continueBuffering(int i, long l)
    {
        maybeStartLoading();
        return loadingFinished;
    }

    public final void disable(int i)
    {
        state = 2;
    }

    public final void enable(int i, long l)
    {
        state = 0;
        clearCurrentLoadableException();
        maybeStartLoading();
    }

    public final long getBufferedPositionUs()
    {
        return !loadingFinished ? 0L : -3L;
    }

    public final MediaFormat getFormat(int i)
    {
        return format;
    }

    public final int getTrackCount()
    {
        return 1;
    }

    public final boolean isLoadCanceled()
    {
        return false;
    }

    public final void load()
    {
        sampleSize = 0;
        dataSource.open(new DataSpec(uri));
        int i = 0;
_L2:
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        sampleSize = sampleSize + i;
        if (sampleSize == sampleData.length)
        {
            sampleData = Arrays.copyOf(sampleData, sampleData.length << 1);
        }
        i = dataSource.read(sampleData, sampleSize, sampleData.length - sampleSize);
        if (true) goto _L2; else goto _L1
_L1:
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }

    public final void maybeThrowError()
    {
        if (currentLoadableException != null && currentLoadableExceptionCount > minLoadableRetryCount)
        {
            throw currentLoadableException;
        } else
        {
            return;
        }
    }

    public final void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
    }

    public final void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        loadingFinished = true;
        clearCurrentLoadableException();
    }

    public final void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        currentLoadableException = ioexception;
        currentLoadableExceptionCount = currentLoadableExceptionCount + 1;
        currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
        maybeStartLoading();
    }

    public final boolean prepare(long l)
    {
        if (loader == null)
        {
            loader = new Loader((new StringBuilder("Loader:")).append(format.mimeType).toString());
        }
        return true;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        if (flag)
        {
            return -2;
        }
        if (state == 2)
        {
            return -1;
        }
        if (state == 0)
        {
            mediaformatholder.format = format;
            state = 1;
            return -4;
        }
        if (state == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (!loadingFinished)
        {
            return -2;
        } else
        {
            sampleholder.timeUs = 0L;
            sampleholder.size = sampleSize;
            sampleholder.flags = 1;
            sampleholder.ensureSpaceForWrite(sampleholder.size);
            sampleholder.data.put(sampleData, 0, sampleSize);
            state = 2;
            return -3;
        }
    }

    public final SampleSource.SampleSourceReader register()
    {
        return this;
    }

    public final void release()
    {
        if (loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public final void seekToUs(long l)
    {
        if (state == 2)
        {
            state = 1;
        }
    }
}
