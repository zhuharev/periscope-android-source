// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            JmxReporter

public static interface 
    extends 
{

    public abstract double get50thPercentile();

    public abstract double get75thPercentile();

    public abstract double get95thPercentile();

    public abstract double get98thPercentile();

    public abstract double get999thPercentile();

    public abstract double get99thPercentile();

    public abstract String getDurationUnit();

    public abstract double getMax();

    public abstract double getMean();

    public abstract double getMin();

    public abstract double getStdDev();

    public abstract long[] values();
}
