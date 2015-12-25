// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.MediaFormat;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkOperationHolder, Chunk

public interface ChunkSource
{

    public abstract void continueBuffering(long l);

    public abstract void disable(List list);

    public abstract void enable(int i);

    public abstract void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder);

    public abstract MediaFormat getFormat(int i);

    public abstract int getTrackCount();

    public abstract void maybeThrowError();

    public abstract void onChunkLoadCompleted(Chunk chunk);

    public abstract void onChunkLoadError(Chunk chunk, Exception exception);

    public abstract boolean prepare();
}
