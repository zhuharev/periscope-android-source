// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

// Referenced classes of package com.codahale.metrics:
//            Reservoir, ThreadLocalRandom, UniformSnapshot, Snapshot

public class UniformReservoir
    implements Reservoir
{

    private static final int BITS_PER_LONG = 63;
    private static final int DEFAULT_SIZE = 1028;
    private final AtomicLong count;
    private final AtomicLongArray values;

    public UniformReservoir()
    {
        this(1028);
    }

    public UniformReservoir(int i)
    {
        count = new AtomicLong();
        values = new AtomicLongArray(i);
        for (i = 0; i < values.length(); i++)
        {
            values.set(i, 0L);
        }

        count.set(0L);
    }

    private static long nextLong(long l)
    {
        long l1;
        long l2;
        do
        {
            l1 = ThreadLocalRandom.current().nextLong() & 0x7fffffffffffffffL;
            l2 = l1 % l;
        } while ((l1 - l2) + (l - 1L) < 0L);
        return l2;
    }

    public Snapshot getSnapshot()
    {
        int j = size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(Long.valueOf(values.get(i)));
        }

        return new UniformSnapshot(arraylist);
    }

    public int size()
    {
        long l = count.get();
        if (l > (long)values.length())
        {
            return values.length();
        } else
        {
            return (int)l;
        }
    }

    public void update(long l)
    {
        long l1 = count.incrementAndGet();
        if (l1 <= (long)values.length())
        {
            values.set((int)l1 - 1, l);
            return;
        }
        l1 = nextLong(l1);
        if (l1 < (long)values.length())
        {
            values.set((int)l1, l);
        }
    }
}
