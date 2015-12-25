// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            LongAdder

public class EWMA
{

    private static final int FIFTEEN_MINUTES = 15;
    private static final int FIVE_MINUTES = 5;
    private static final int INTERVAL = 5;
    private static final double M15_ALPHA = 1.0D - Math.exp(-0.0055555555555555549D);
    private static final double M1_ALPHA = 1.0D - Math.exp(-0.083333333333333329D);
    private static final double M5_ALPHA = 1.0D - Math.exp(-0.016666666666666666D);
    private static final int ONE_MINUTE = 1;
    private static final double SECONDS_PER_MINUTE = 60D;
    private final double alpha;
    private volatile boolean initialized;
    private final double interval;
    private volatile double rate;
    private final LongAdder uncounted = new LongAdder();

    public EWMA(double d, long l, TimeUnit timeunit)
    {
        initialized = false;
        rate = 0.0D;
        interval = timeunit.toNanos(l);
        alpha = d;
    }

    public static EWMA fifteenMinuteEWMA()
    {
        return new EWMA(M15_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public static EWMA fiveMinuteEWMA()
    {
        return new EWMA(M5_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public static EWMA oneMinuteEWMA()
    {
        return new EWMA(M1_ALPHA, 5L, TimeUnit.SECONDS);
    }

    public double getRate(TimeUnit timeunit)
    {
        return rate * (double)timeunit.toNanos(1L);
    }

    public void tick()
    {
        double d = (double)uncounted.sumThenReset() / interval;
        if (initialized)
        {
            rate = rate + alpha * (d - rate);
            return;
        } else
        {
            rate = d;
            initialized = true;
            return;
        }
    }

    public void update(long l)
    {
        uncounted.add(l);
    }

}
