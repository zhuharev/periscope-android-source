// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;


// Referenced classes of package com.google.android.exoplayer.upstream:
//            TransferListener

public interface BandwidthMeter
    extends TransferListener
{
    public static interface EventListener
    {

        public abstract void onBandwidthSample(int i, long l, long l1);
    }


    public static final long NO_ESTIMATE = -1L;

    public abstract long getBitrateEstimate();
}
