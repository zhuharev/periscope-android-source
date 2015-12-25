// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.OutputStream;

public abstract class Snapshot
{

    public Snapshot()
    {
    }

    public abstract void dump(OutputStream outputstream);

    public double get75thPercentile()
    {
        return getValue(0.75D);
    }

    public double get95thPercentile()
    {
        return getValue(0.94999999999999996D);
    }

    public double get98thPercentile()
    {
        return getValue(0.97999999999999998D);
    }

    public double get999thPercentile()
    {
        return getValue(0.999D);
    }

    public double get99thPercentile()
    {
        return getValue(0.98999999999999999D);
    }

    public abstract long getMax();

    public abstract double getMean();

    public double getMedian()
    {
        return getValue(0.5D);
    }

    public abstract long getMin();

    public abstract double getStdDev();

    public abstract double getValue(double d);

    public abstract long[] getValues();

    public abstract int size();
}
