// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsSampleSource

class val.loadDurationMs
    implements Runnable
{

    final HlsSampleSource this$0;
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
        HlsSampleSource.access$100(HlsSampleSource.this).onLoadCompleted(HlsSampleSource.access$000(HlsSampleSource.this), val$bytesLoaded, val$type, val$trigger, val$format, usToMs(val$mediaStartTimeUs), usToMs(val$mediaEndTimeUs), val$elapsedRealtimeMs, val$loadDurationMs);
    }

    entListener()
    {
        this$0 = final_hlssamplesource;
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
