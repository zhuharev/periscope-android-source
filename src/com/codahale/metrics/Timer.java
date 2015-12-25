// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            Metered, Sampling, ExponentiallyDecayingReservoir, Clock, 
//            Meter, Histogram, Reservoir, Snapshot

public class Timer
    implements Metered, Sampling
{
    public static class Context
        implements Closeable
    {

        private final Clock clock;
        private final long startTime;
        private final Timer timer;

        public void close()
        {
            stop();
        }

        public long stop()
        {
            long l = clock.getTick() - startTime;
            timer.update(l, TimeUnit.NANOSECONDS);
            return l;
        }

        private Context(Timer timer1, Clock clock1)
        {
            timer = timer1;
            clock = clock1;
            startTime = clock1.getTick();
        }

    }


    private final Clock clock;
    private final Histogram histogram;
    private final Meter meter;

    public Timer()
    {
        this(((Reservoir) (new ExponentiallyDecayingReservoir())));
    }

    public Timer(Reservoir reservoir)
    {
        this(reservoir, Clock.defaultClock());
    }

    public Timer(Reservoir reservoir, Clock clock1)
    {
        meter = new Meter(clock1);
        clock = clock1;
        histogram = new Histogram(reservoir);
    }

    private void update(long l)
    {
        if (l >= 0L)
        {
            histogram.update(l);
            meter.mark();
        }
    }

    public long getCount()
    {
        return histogram.getCount();
    }

    public double getFifteenMinuteRate()
    {
        return meter.getFifteenMinuteRate();
    }

    public double getFiveMinuteRate()
    {
        return meter.getFiveMinuteRate();
    }

    public double getMeanRate()
    {
        return meter.getMeanRate();
    }

    public double getOneMinuteRate()
    {
        return meter.getOneMinuteRate();
    }

    public Snapshot getSnapshot()
    {
        return histogram.getSnapshot();
    }

    public Context time()
    {
        return new Context(this, clock);
    }

    public Object time(Callable callable)
    {
        long l = clock.getTick();
        callable = ((Callable) (callable.call()));
        update(clock.getTick() - l);
        return callable;
        callable;
        update(clock.getTick() - l);
        throw callable;
    }

    public void update(long l, TimeUnit timeunit)
    {
        update(timeunit.toNanos(l));
    }
}
