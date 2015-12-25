// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Chunk, ChunkExtractorWrapper, Format

public final class InitializationChunk extends Chunk
    implements ChunkExtractorWrapper.SingleTrackOutput
{

    private volatile int bytesLoaded;
    private DrmInitData drmInitData;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private MediaFormat mediaFormat;
    private SeekMap seekMap;

    public InitializationChunk(DataSource datasource, DataSpec dataspec, int i, Format format1, ChunkExtractorWrapper chunkextractorwrapper)
    {
        this(datasource, dataspec, i, format1, chunkextractorwrapper, -1);
    }

    public InitializationChunk(DataSource datasource, DataSpec dataspec, int i, Format format1, ChunkExtractorWrapper chunkextractorwrapper, int j)
    {
        super(datasource, dataspec, 2, i, format1, j);
        extractorWrapper = chunkextractorwrapper;
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
        mediaFormat = mediaformat;
    }

    public final DrmInitData getDrmInitData()
    {
        return drmInitData;
    }

    public final MediaFormat getFormat()
    {
        return mediaFormat;
    }

    public final SeekMap getSeekMap()
    {
        return seekMap;
    }

    public final boolean hasDrmInitData()
    {
        return drmInitData != null;
    }

    public final boolean hasFormat()
    {
        return mediaFormat != null;
    }

    public final boolean hasSeekMap()
    {
        return seekMap != null;
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
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public final void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public final void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public final void seekMap(SeekMap seekmap)
    {
        seekMap = seekmap;
    }
}
