// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;


// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSampleSource

class val.bytesLoaded
    implements Runnable
{

    final ChunkSampleSource this$0;
    final long val$bytesLoaded;

    public void run()
    {
        ChunkSampleSource.access$100(ChunkSampleSource.this).onLoadCanceled(ChunkSampleSource.access$000(ChunkSampleSource.this), val$bytesLoaded);
    }

    entListener()
    {
        this$0 = final_chunksamplesource;
        val$bytesLoaded = J.this;
        super();
    }
}
