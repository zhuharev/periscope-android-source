// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            MediaChunk, Format

public abstract class BaseMediaChunk extends MediaChunk
{

    private int firstSampleIndex;
    public final boolean isMediaFormatFinal;
    private DefaultTrackOutput output;

    public BaseMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format, long l, long l1, int j, boolean flag, int k)
    {
        super(datasource, dataspec, i, format, l, l1, j, k);
        isMediaFormatFinal = flag;
    }

    public abstract DrmInitData getDrmInitData();

    public final int getFirstSampleIndex()
    {
        return firstSampleIndex;
    }

    public abstract MediaFormat getMediaFormat();

    protected final DefaultTrackOutput getOutput()
    {
        return output;
    }

    public void init(DefaultTrackOutput defaulttrackoutput)
    {
        output = defaulttrackoutput;
        firstSampleIndex = defaulttrackoutput.getWriteIndex();
    }
}
