// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            Reservoir, Clock, UniformSnapshot, Snapshot

public class SlidingTimeWindowReservoir
    implements Reservoir
{

    private static final int COLLISION_BUFFER = 256;
    private static final int TRIM_THRESHOLD = 256;
    private final Clock clock;
    private final AtomicLong count;
    private final AtomicLong lastTick;
    private final ConcurrentSkipListMap measurements;
    private final long window;

    public SlidingTimeWindowReservoir(long l, TimeUnit timeunit)
    {
        this(l, timeunit, Clock.defaultClock());
    }

    public SlidingTimeWindowReservoir(long l, TimeUnit timeunit, Clock clock1)
    {
        clock = clock1;
        measurements = new ConcurrentSkipListMap();
        window = timeunit.toNanos(l) << 8;
        lastTick = new AtomicLong(clock1.getTick() << 8);
        count = new AtomicLong();
    }

    private long getTick()
    {
        long l;
        long l1;
        do
        {
            l1 = lastTick.get();
            l = clock.getTick() << 8;
            if (l - l1 <= 0L)
            {
                l = l1 + 1L;
            }
        } while (!lastTick.compareAndSet(l1, l));
        return l;
    }

    private void trim()
    {
        measurements.headMap(Long.valueOf(getTick() - window)).clear();
    }

    public Snapshot getSnapshot()
    {
        trim();
        return new UniformSnapshot(measurements.values());
    }

    public int size()
    {
        trim();
        return measurements.size();
    }

    public void update(long l)
    {
        if (count.incrementAndGet() % 256L == 0L)
        {
            trim();
        }
        measurements.put(Long.valueOf(getTick()), Long.valueOf(l));
    }
}
