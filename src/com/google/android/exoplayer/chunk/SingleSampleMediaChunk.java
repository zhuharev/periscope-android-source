// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            BaseMediaChunk, Format

public final class SingleSampleMediaChunk extends BaseMediaChunk
{

    private volatile int bytesLoaded;
    private volatile boolean loadCanceled;
    private final DrmInitData sampleDrmInitData;
    private final MediaFormat sampleFormat;

    public SingleSampleMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, MediaFormat mediaformat, DrmInitData drminitdata, int k)
    {
        super(datasource, dataspec, i, format, l, l1, j, true, k);
        sampleFormat = mediaformat;
        sampleDrmInitData = drminitdata;
    }

    public final long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public final DrmInitData getDrmInitData()
    {
        return sampleDrmInitData;
    }

    public final MediaFormat getMediaFormat()
    {
        return sampleFormat;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        DataSpec dataspec = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
        dataSource.open(dataspec);
        int i = 0;
_L1:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        bytesLoaded = bytesLoaded + i;
        i = getOutput().sampleData(dataSource, 0x7fffffff, true);
          goto _L1
        int j = bytesLoaded;
        getOutput().sampleMetadata(startTimeUs, 1, j, 0, null);
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }
}
