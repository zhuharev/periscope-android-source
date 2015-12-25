// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;


// Referenced classes of package com.google.android.exoplayer.upstream:
//            DefaultBandwidthMeter

class val.bitrate
    implements Runnable
{

    final DefaultBandwidthMeter this$0;
    final long val$bitrate;
    final long val$bytes;
    final int val$elapsedMs;

    public void run()
    {
        DefaultBandwidthMeter.access$000(DefaultBandwidthMeter.this).onBandwidthSample(val$elapsedMs, val$bytes, val$bitrate);
    }

    ener()
    {
        this$0 = final_defaultbandwidthmeter;
        val$elapsedMs = i;
        val$bytes = l;
        val$bitrate = J.this;
        super();
    }
}
