// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter, Timer, Snapshot

static class <init> extends <init>
    implements Bean
{

    private final double durationFactor;
    private final String durationUnit;
    private final Timer metric;

    public double get50thPercentile()
    {
        return metric.getSnapshot().getMedian() * durationFactor;
    }

    public double get75thPercentile()
    {
        return metric.getSnapshot().get75thPercentile() * durationFactor;
    }

    public double get95thPercentile()
    {
        return metric.getSnapshot().get95thPercentile() * durationFactor;
    }

    public double get98thPercentile()
    {
        return metric.getSnapshot().get98thPercentile() * durationFactor;
    }

    public double get999thPercentile()
    {
        return metric.getSnapshot().get999thPercentile() * durationFactor;
    }

    public double get99thPercentile()
    {
        return metric.getSnapshot().get99thPercentile() * durationFactor;
    }

    public String getDurationUnit()
    {
        return durationUnit;
    }

    public double getMax()
    {
        return (double)metric.getSnapshot().getMax() * durationFactor;
    }

    public double getMean()
    {
        return metric.getSnapshot().getMean() * durationFactor;
    }

    public double getMin()
    {
        return (double)metric.getSnapshot().getMin() * durationFactor;
    }

    public double getStdDev()
    {
        return metric.getSnapshot().getStdDev() * durationFactor;
    }

    public long[] values()
    {
        return metric.getSnapshot().getValues();
    }

    private Bean(Timer timer, ObjectName objectname, TimeUnit timeunit, TimeUnit timeunit1)
    {
        super(timer, objectname, timeunit, null);
        metric = timer;
        durationFactor = 1.0D / (double)timeunit1.toNanos(1L);
        durationUnit = timeunit1.toString().toLowerCase(Locale.US);
    }

    durationUnit(Timer timer, ObjectName objectname, TimeUnit timeunit, TimeUnit timeunit1, durationUnit durationunit)
    {
        this(timer, objectname, timeunit, timeunit1);
    }
}
