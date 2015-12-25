// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;


// Referenced classes of package com.google.android.exoplayer.chunk:
//            ChunkSampleSource, Format

class val.loadDurationMs
    implements Runnable
{

    final ChunkSampleSource this$0;
    final long val$bytesLoaded;
    final long val$elapsedRealtimeMs;
    final Format val$format;
    final long val$loadDurationMs;
    final long val$mediaEndTimeUs;
    final long val$mediaStartTimeUs;
    final int val$trigger;
    final int val$type;

    public void run()
    {
        ChunkSampleSource.access$100(ChunkSampleSource.this).onLoadCompleted(ChunkSampleSource.access$000(ChunkSampleSource.this), val$bytesLoaded, val$type, val$trigger, val$format, usToMs(val$mediaStartTimeUs), usToMs(val$mediaEndTimeUs), val$elapsedRealtimeMs, val$loadDurationMs);
    }

    entListener()
    {
        this$0 = final_chunksamplesource;
        val$bytesLoaded = l;
        val$type = i;
        val$trigger = j;
        val$format = format1;
        val$mediaStartTimeUs = l1;
        val$mediaEndTimeUs = l2;
        val$elapsedRealtimeMs = l3;
        val$loadDurationMs = J.this;
        super();
    }
}
