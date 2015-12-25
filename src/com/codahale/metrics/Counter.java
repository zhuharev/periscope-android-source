// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Metric, Counting, LongAdder

public class Counter
    implements Metric, Counting
{

    private final LongAdder count = new LongAdder();

    public Counter()
    {
    }

    public void dec()
    {
        dec(1L);
    }

    public void dec(long l)
    {
        count.add(-l);
    }

    public long getCount()
    {
        return count.sum();
    }

    public void inc()
    {
        inc(1L);
    }

    public void inc(long l)
    {
        count.add(l);
    }
}
