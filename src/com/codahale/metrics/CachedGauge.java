// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            Gauge, Clock

public abstract class CachedGauge
    implements Gauge
{

    private final Clock clock;
    private final AtomicLong reloadAt;
    private final long timeoutNS;
    private volatile Object value;

    protected CachedGauge(long l, TimeUnit timeunit)
    {
        this(Clock.defaultClock(), l, timeunit);
    }

    protected CachedGauge(Clock clock1, long l, TimeUnit timeunit)
    {
        clock = clock1;
        reloadAt = new AtomicLong(0L);
        timeoutNS = timeunit.toNanos(l);
    }

    private boolean shouldLoad()
    {
        long l;
        long l1;
        do
        {
            l = clock.getTick();
            l1 = reloadAt.get();
            if (l1 > l)
            {
                return false;
            }
        } while (!reloadAt.compareAndSet(l1, timeoutNS + l));
        return true;
    }

    public Object getValue()
    {
        if (shouldLoad())
        {
            value = loadValue();
        }
        return value;
    }

    protected abstract Object loadValue();
}
