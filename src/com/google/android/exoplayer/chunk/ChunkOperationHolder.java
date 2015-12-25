// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;


// Referenced classes of package com.google.android.exoplayer.chunk:
//            Chunk

public final class ChunkOperationHolder
{

    public Chunk chunk;
    public boolean endOfStream;
    public int queueSize;

    public ChunkOperationHolder()
    {
    }

    public final void clear()
    {
        queueSize = 0;
        chunk = null;
        endOfStream = false;
    }
}
