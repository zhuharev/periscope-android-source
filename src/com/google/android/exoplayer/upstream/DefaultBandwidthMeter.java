// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.os.Handler;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Clock;
import com.google.android.exoplayer.util.SlidingPercentile;
import com.google.android.exoplayer.util.SystemClock;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            BandwidthMeter

public final class DefaultBandwidthMeter
    implements BandwidthMeter
{

    public static final int DEFAULT_MAX_WEIGHT = 2000;
    private long bitrateEstimate;
    private long bytesAccumulator;
    private final Clock clock;
    private final Handler eventHandler;
    private final BandwidthMeter.EventListener eventListener;
    private final SlidingPercentile slidingPercentile;
    private long startTimeMs;
    private int streamCount;

    public DefaultBandwidthMeter()
    {
        this(null, null);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventlistener)
    {
        this(handler, eventlistener, ((Clock) (new SystemClock())));
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventlistener, int i)
    {
        this(handler, eventlistener, ((Clock) (new SystemClock())), i);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventlistener, Clock clock1)
    {
        this(handler, eventlistener, clock1, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventlistener, Clock clock1, int i)
    {
        eventHandler = handler;
        eventListener = eventlistener;
        clock = clock1;
        slidingPercentile = new SlidingPercentile(i);
        bitrateEstimate = -1L;
    }

    private void notifyBandwidthSample(final int elapsedMs, final long bytes, final long bitrate)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    public final long getBitrateEstimate()
    {
        this;
        JVM INSTR monitorenter ;
        long l = bitrateEstimate;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onBytesTransferred(int i)
    {
        this;
        JVM INSTR monitorenter ;
        bytesAccumulator = bytesAccumulator + (long)i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onTransferEnd()
    {
        this;
        JVM INSTR monitorenter ;
        float f;
        Exception exception;
        int i;
        long l;
        long l1;
        boolean flag;
        if (streamCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        l1 = clock.elapsedRealtime();
        i = (int)(l1 - startTimeMs);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        f = (bytesAccumulator * 8000L) / (long)i;
        slidingPercentile.addSample((int)Math.sqrt(bytesAccumulator), f);
        f = slidingPercentile.getPercentile(0.5F);
        if (Float.isNaN(f))
        {
            l = -1L;
        } else
        {
            l = (long)f;
        }
        bitrateEstimate = l;
        notifyBandwidthSample(i, bytesAccumulator, bitrateEstimate);
        streamCount = streamCount - 1;
        if (streamCount > 0)
        {
            startTimeMs = l1;
        }
        bytesAccumulator = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public final void onTransferStart()
    {
        this;
        JVM INSTR monitorenter ;
        if (streamCount == 0)
        {
            startTimeMs = clock.elapsedRealtime();
        }
        streamCount = streamCount + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1
        implements Runnable
    {

        final DefaultBandwidthMeter this$0;
        final long val$bitrate;
        final long val$bytes;
        final int val$elapsedMs;

        public void run()
        {
            eventListener.onBandwidthSample(elapsedMs, bytes, bitrate);
        }

        _cls1()
        {
            this$0 = DefaultBandwidthMeter.this;
            elapsedMs = i;
            bytes = l;
            bitrate = l1;
            super();
        }
    }

}
