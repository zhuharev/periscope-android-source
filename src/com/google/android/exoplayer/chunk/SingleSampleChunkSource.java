// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSource, SingleSampleMediaChunk, ChunkOperationHolder, Format, 
//            Chunk

public final class SingleSampleChunkSource
    implements ChunkSource
{

    private final DataSource dataSource;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final MediaFormat mediaFormat;

    public SingleSampleChunkSource(DataSource datasource, DataSpec dataspec, Format format1, long l, MediaFormat mediaformat)
    {
        dataSource = datasource;
        dataSpec = dataspec;
        format = format1;
        durationUs = l;
        mediaFormat = mediaformat;
    }

    private SingleSampleMediaChunk initChunk()
    {
        return new SingleSampleMediaChunk(dataSource, dataSpec, 0, format, 0L, durationUs, 0, mediaFormat, null, -1);
    }

    public final void continueBuffering(long l)
    {
    }

    public final void disable(List list)
    {
    }

    public final void enable(int i)
    {
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        if (!list.isEmpty())
        {
            chunkoperationholder.endOfStream = true;
            return;
        } else
        {
            chunkoperationholder.chunk = initChunk();
            return;
        }
    }

    public final MediaFormat getFormat(int i)
    {
        return mediaFormat;
    }

    public final int getTrackCount()
    {
        return 1;
    }

    public final void maybeThrowError()
    {
    }

    public final void onChunkLoadCompleted(Chunk chunk)
    {
    }

    public final void onChunkLoadError(Chunk chunk, Exception exception)
    {
    }

    public final boolean prepare()
    {
        return true;
    }
}
