// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultExtractorInput;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            BaseMediaChunk, ChunkExtractorWrapper, Format

public class ContainerMediaChunk extends BaseMediaChunk
    implements ChunkExtractorWrapper.SingleTrackOutput
{

    private final int adaptiveMaxHeight;
    private final int adaptiveMaxWidth;
    private volatile int bytesLoaded;
    private DrmInitData drmInitData;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private MediaFormat mediaFormat;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource datasource, DataSpec dataspec, int i, Format format1, long l, long l1, int j, long l2, ChunkExtractorWrapper chunkextractorwrapper, MediaFormat mediaformat, int k, 
            int i1, DrmInitData drminitdata, boolean flag, int j1)
    {
        super(datasource, dataspec, i, format1, l, l1, j, flag, j1);
        extractorWrapper = chunkextractorwrapper;
        sampleOffsetUs = l2;
        adaptiveMaxWidth = k;
        adaptiveMaxHeight = i1;
        mediaFormat = getAdjustedMediaFormat(mediaformat, l2, k, i1);
        drmInitData = drminitdata;
    }

    private static MediaFormat getAdjustedMediaFormat(MediaFormat mediaformat, long l, int i, int j)
    {
label0:
        {
            if (mediaformat == null)
            {
                return null;
            }
            MediaFormat mediaformat1 = mediaformat;
            if (l != 0L)
            {
                mediaformat1 = mediaformat;
                if (mediaformat.subsampleOffsetUs != 0x7fffffffffffffffL)
                {
                    mediaformat1 = mediaformat.copyWithSubsampleOffsetUs(mediaformat.subsampleOffsetUs + l);
                }
            }
            if (i == -1)
            {
                mediaformat = mediaformat1;
                if (j == -1)
                {
                    break label0;
                }
            }
            mediaformat = mediaformat1.copyWithMaxVideoDimensions(i, j);
        }
        return mediaformat;
    }

    public final long bytesLoaded()
    {
        return (long)bytesLoaded;
    }

    public final void cancelLoad()
    {
        loadCanceled = true;
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
        drmInitData = drminitdata;
    }

    public final void format(MediaFormat mediaformat)
    {
        mediaFormat = getAdjustedMediaFormat(mediaformat, sampleOffsetUs, adaptiveMaxWidth, adaptiveMaxHeight);
    }

    public final DrmInitData getDrmInitData()
    {
        return drmInitData;
    }

    public final MediaFormat getMediaFormat()
    {
        return mediaFormat;
    }

    public final boolean isLoadCanceled()
    {
        return loadCanceled;
    }

    public final void load()
    {
        Object obj = Util.getRemainderDataSpec(dataSpec, bytesLoaded);
        obj = new DefaultExtractorInput(dataSource, ((DataSpec) (obj)).absoluteStreamPosition, dataSource.open(((DataSpec) (obj))));
        if (bytesLoaded == 0)
        {
            extractorWrapper.init(this);
        }
        int i = 0;
_L2:
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (loadCanceled)
        {
            break; /* Loop/switch isn't completed */
        }
        i = extractorWrapper.read(((ExtractorInput) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        bytesLoaded = (int)(((ExtractorInput) (obj)).getPosition() - dataSpec.absoluteStreamPosition);
        break MISSING_BLOCK_LABEL_122;
        Exception exception1;
        exception1;
        bytesLoaded = (int)(((ExtractorInput) (obj)).getPosition() - dataSpec.absoluteStreamPosition);
        throw exception1;
        dataSource.close();
        return;
        Exception exception;
        exception;
        dataSource.close();
        throw exception;
    }

    public final int sampleData(ExtractorInput extractorinput, int i, boolean flag)
    {
        return getOutput().sampleData(extractorinput, i, flag);
    }

    public final void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        getOutput().sampleData(parsablebytearray, i);
    }

    public final void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        getOutput().sampleMetadata(sampleOffsetUs + l, i, j, k, abyte0);
    }

    public final void seekMap(SeekMap seekmap)
    {
    }
}
