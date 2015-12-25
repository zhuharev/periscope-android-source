// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsSampleSource

class val.positionUs
    implements Runnable
{

    final HlsSampleSource this$0;
    final Format val$format;
    final long val$positionUs;
    final int val$trigger;

    public void run()
    {
        HlsSampleSource.access$100(HlsSampleSource.this).onDownstreamFormatChanged(HlsSampleSource.access$000(HlsSampleSource.this), val$format, val$trigger, usToMs(val$positionUs));
    }

    entListener()
    {
        this$0 = final_hlssamplesource;
        val$format = format1;
        val$trigger = i;
        val$positionUs = J.this;
        super();
    }
}
