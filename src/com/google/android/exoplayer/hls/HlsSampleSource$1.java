// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsSampleSource

class val.mediaEndTimeUs
    implements Runnable
{

    final HlsSampleSource this$0;
    final Format val$format;
    final long val$length;
    final long val$mediaEndTimeUs;
    final long val$mediaStartTimeUs;
    final int val$trigger;
    final int val$type;

    public void run()
    {
        HlsSampleSource.access$100(HlsSampleSource.this).onLoadStarted(HlsSampleSource.access$000(HlsSampleSource.this), val$length, val$type, val$trigger, val$format, usToMs(val$mediaStartTimeUs), usToMs(val$mediaEndTimeUs));
    }

    entListener()
    {
        this$0 = final_hlssamplesource;
        val$length = l;
        val$type = i;
        val$trigger = j;
        val$format = format1;
        val$mediaStartTimeUs = l1;
        val$mediaEndTimeUs = J.this;
        super();
    }
}
