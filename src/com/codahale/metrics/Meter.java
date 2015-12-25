// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            Metered, Clock, EWMA, LongAdder

public class Meter
    implements Metered
{

    private static final long TICK_INTERVAL;
    private final Clock clock;
    private final LongAdder count;
    private final AtomicLong lastTick;
    private final EWMA m15Rate;
    private final EWMA m1Rate;
    private final EWMA m5Rate;
    private final long startTime;

    public Meter()
    {
        this(Clock.defaultClock());
    }

    public Meter(Clock clock1)
    {
        m1Rate = EWMA.oneMinuteEWMA();
        m5Rate = EWMA.fiveMinuteEWMA();
        m15Rate = EWMA.fifteenMinuteEWMA();
        count = new LongAdder();
        clock = clock1;
        startTime = clock.getTick();
        lastTick = new AtomicLong(startTime);
    }

    private void tickIfNecessary()
    {
        long l = lastTick.get();
        long l2 = clock.getTick();
        long l4 = l2 - l;
        if (l4 > TICK_INTERVAL)
        {
            long l5 = TICK_INTERVAL;
            if (lastTick.compareAndSet(l, l2 - l4 % l5))
            {
                long l3 = l4 / TICK_INTERVAL;
                for (long l1 = 0L; l1 < l3; l1++)
                {
                    m1Rate.tick();
                    m5Rate.tick();
                    m15Rate.tick();
                }

            }
        }
    }

    public long getCount()
    {
        return count.sum();
    }

    public double getFifteenMinuteRate()
    {
        tickIfNecessary();
        return m15Rate.getRate(TimeUnit.SECONDS);
    }

    public double getFiveMinuteRate()
    {
        tickIfNecessary();
        return m5Rate.getRate(TimeUnit.SECONDS);
    }

    public double getMeanRate()
    {
        if (getCount() == 0L)
        {
            return 0.0D;
        } else
        {
            double d = clock.getTick() - startTime;
            return ((double)getCount() / d) * (double)TimeUnit.SECONDS.toNanos(1L);
        }
    }

    public double getOneMinuteRate()
    {
        tickIfNecessary();
        return m1Rate.getRate(TimeUnit.SECONDS);
    }

    public void mark()
    {
        mark(1L);
    }

    public void mark(long l)
    {
        tickIfNecessary();
        count.add(l);
        m1Rate.update(l);
        m5Rate.update(l);
        m15Rate.update(l);
    }

    static 
    {
        TICK_INTERVAL = TimeUnit.SECONDS.toNanos(5L);
    }
}
