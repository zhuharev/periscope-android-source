// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Random;

class ThreadLocalRandom extends Random
{

    private static final long addend = 11L;
    private static final ThreadLocal localRandom = new _cls1();
    private static final long mask = 0xffffffffffffL;
    private static final long multiplier = 0x5deece66dL;
    private static final long serialVersionUID = 0xaeca4f167a867673L;
    boolean initialized;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;

    ThreadLocalRandom()
    {
        initialized = true;
    }

    public static ThreadLocalRandom current()
    {
        return (ThreadLocalRandom)localRandom.get();
    }

    protected int next(int i)
    {
        rnd = rnd * 0x5deece66dL + 11L & 0xffffffffffffL;
        return (int)(rnd >>> 48 - i);
    }

    public double nextDouble(double d)
    {
        if (d <= 0.0D)
        {
            throw new IllegalArgumentException("n must be positive");
        } else
        {
            return nextDouble() * d;
        }
    }

    public double nextDouble(double d, double d1)
    {
        if (d >= d1)
        {
            throw new IllegalArgumentException();
        } else
        {
            return nextDouble() * (d1 - d) + d;
        }
    }

    public int nextInt(int i, int j)
    {
        if (i >= j)
        {
            throw new IllegalArgumentException();
        } else
        {
            return nextInt(j - i) + i;
        }
    }

    public long nextLong(long l)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException("n must be positive");
        }
        long l1 = 0L;
        long l2;
        for (l2 = l; l2 >= 0x7fffffffL; l2 = l)
        {
            int i = next(2);
            l = l2 >>> 1;
            if ((i & 2) != 0)
            {
                l = l2 - l;
            }
            long l3 = l1;
            if ((i & 1) == 0)
            {
                l3 = l1 + (l2 - l);
            }
            l1 = l3;
        }

        return (long)nextInt((int)l2) + l1;
    }

    public long nextLong(long l, long l1)
    {
        if (l >= l1)
        {
            throw new IllegalArgumentException();
        } else
        {
            return nextLong(l1 - l) + l;
        }
    }

    public void setSeed(long l)
    {
        if (initialized)
        {
            throw new UnsupportedOperationException();
        } else
        {
            rnd = (0x5deece66dL ^ l) & 0xffffffffffffL;
            return;
        }
    }


    private class _cls1 extends ThreadLocal
    {

        protected final ThreadLocalRandom initialValue()
        {
            return new ThreadLocalRandom();
        }

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        _cls1()
        {
        }
    }

}
