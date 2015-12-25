// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;


// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSampleSource, Format

class val.positionUs
    implements Runnable
{

    final ChunkSampleSource this$0;
    final Format val$format;
    final long val$positionUs;
    final int val$trigger;

    public void run()
    {
        ChunkSampleSource.access$100(ChunkSampleSource.this).onDownstreamFormatChanged(ChunkSampleSource.access$000(ChunkSampleSource.this), val$format, val$trigger, usToMs(val$positionUs));
    }

    entListener()
    {
        this$0 = final_chunksamplesource;
        val$format = format1;
        val$trigger = i;
        val$positionUs = J.this;
        super();
    }
}
