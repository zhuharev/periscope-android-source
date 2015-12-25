// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Metric, Sampling, Counting, LongAdder, 
//            Reservoir, Snapshot

public class Histogram
    implements Metric, Sampling, Counting
{

    private final LongAdder count = new LongAdder();
    private final Reservoir reservoir;

    public Histogram(Reservoir reservoir1)
    {
        reservoir = reservoir1;
    }

    public long getCount()
    {
        return count.sum();
    }

    public Snapshot getSnapshot()
    {
        return reservoir.getSnapshot();
    }

    public void update(int i)
    {
        update(i);
    }

    public void update(long l)
    {
        count.increment();
        reservoir.update(l);
    }
}
