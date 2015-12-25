// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package com.codahale.metrics:
//            Reservoir, Clock, WeightedSnapshot, ThreadLocalRandom, 
//            Snapshot

public class ExponentiallyDecayingReservoir
    implements Reservoir
{

    private static final double DEFAULT_ALPHA = 0.014999999999999999D;
    private static final int DEFAULT_SIZE = 1028;
    private static final long RESCALE_THRESHOLD;
    private final double alpha;
    private final Clock clock;
    private final AtomicLong count;
    private final ReentrantReadWriteLock lock;
    private final AtomicLong nextScaleTime;
    private final int size;
    private volatile long startTime;
    private final ConcurrentSkipListMap values;

    public ExponentiallyDecayingReservoir()
    {
        this(1028, 0.014999999999999999D);
    }

    public ExponentiallyDecayingReservoir(int i, double d)
    {
        this(i, d, Clock.defaultClock());
    }

    public ExponentiallyDecayingReservoir(int i, double d, Clock clock1)
    {
        values = new ConcurrentSkipListMap();
        lock = new ReentrantReadWriteLock();
        alpha = d;
        size = i;
        clock = clock1;
        count = new AtomicLong(0L);
        startTime = currentTimeInSeconds();
        nextScaleTime = new AtomicLong(clock1.getTick() + RESCALE_THRESHOLD);
    }

    private long currentTimeInSeconds()
    {
        return TimeUnit.MILLISECONDS.toSeconds(clock.getTime());
    }

    private void lockForRegularUsage()
    {
        lock.readLock().lock();
    }

    private void lockForRescale()
    {
        lock.writeLock().lock();
    }

    private void rescale(long l, long l1)
    {
        if (!nextScaleTime.compareAndSet(l1, RESCALE_THRESHOLD + l))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        lockForRescale();
        l = startTime;
        startTime = currentTimeInSeconds();
        double d = Math.exp(-alpha * (double)(startTime - l));
        Double double1;
        WeightedSnapshot.WeightedSample weightedsample;
        for (Iterator iterator = (new ArrayList(values.keySet())).iterator(); iterator.hasNext(); values.put(Double.valueOf(double1.doubleValue() * d), weightedsample))
        {
            double1 = (Double)iterator.next();
            weightedsample = (WeightedSnapshot.WeightedSample)values.remove(double1);
            weightedsample = new WeightedSnapshot.WeightedSample(weightedsample.value, weightedsample.weight * d);
        }

        count.set(values.size());
        unlockForRescale();
        return;
        Exception exception;
        exception;
        unlockForRescale();
        throw exception;
    }

    private void rescaleIfNeeded()
    {
        long l = clock.getTick();
        long l1 = nextScaleTime.get();
        if (l >= l1)
        {
            rescale(l, l1);
        }
    }

    private void unlockForRegularUsage()
    {
        lock.readLock().unlock();
    }

    private void unlockForRescale()
    {
        lock.writeLock().unlock();
    }

    private double weight(long l)
    {
        return Math.exp(alpha * (double)l);
    }

    public Snapshot getSnapshot()
    {
        lockForRegularUsage();
        WeightedSnapshot weightedsnapshot = new WeightedSnapshot(values.values());
        unlockForRegularUsage();
        return weightedsnapshot;
        Exception exception;
        exception;
        unlockForRegularUsage();
        throw exception;
    }

    public int size()
    {
        return (int)Math.min(size, count.get());
    }

    public void update(long l)
    {
        update(l, currentTimeInSeconds());
    }

    public void update(long l, long l1)
    {
        rescaleIfNeeded();
        lockForRegularUsage();
        double d;
        WeightedSnapshot.WeightedSample weightedsample;
        d = weight(l1 - startTime);
        weightedsample = new WeightedSnapshot.WeightedSample(l, d);
        d /= ThreadLocalRandom.current().nextDouble();
        if (count.incrementAndGet() <= (long)size)
        {
            values.put(Double.valueOf(d), weightedsample);
            break MISSING_BLOCK_LABEL_144;
        }
        Double double1 = (Double)values.firstKey();
        if (double1.doubleValue() < d && values.putIfAbsent(Double.valueOf(d), weightedsample) == null)
        {
            for (; values.remove(double1) == null; double1 = (Double)values.firstKey()) { }
        }
        unlockForRegularUsage();
        return;
        Exception exception;
        exception;
        unlockForRegularUsage();
        throw exception;
    }

    static 
    {
        RESCALE_THRESHOLD = TimeUnit.HOURS.toNanos(1L);
    }
}
