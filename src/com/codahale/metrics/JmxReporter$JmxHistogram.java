// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter, Histogram, Snapshot

static class <init>
    implements Bean
{

    private final Histogram metric;
    private final ObjectName objectName;

    public double get50thPercentile()
    {
        return metric.getSnapshot().getMedian();
    }

    public double get75thPercentile()
    {
        return metric.getSnapshot().get75thPercentile();
    }

    public double get95thPercentile()
    {
        return metric.getSnapshot().get95thPercentile();
    }

    public double get98thPercentile()
    {
        return metric.getSnapshot().get98thPercentile();
    }

    public double get999thPercentile()
    {
        return metric.getSnapshot().get999thPercentile();
    }

    public double get99thPercentile()
    {
        return metric.getSnapshot().get99thPercentile();
    }

    public long getCount()
    {
        return metric.getCount();
    }

    public long getMax()
    {
        return metric.getSnapshot().getMax();
    }

    public double getMean()
    {
        return metric.getSnapshot().getMean();
    }

    public long getMin()
    {
        return metric.getSnapshot().getMin();
    }

    public double getStdDev()
    {
        return metric.getSnapshot().getStdDev();
    }

    public ObjectName objectName()
    {
        return objectName;
    }

    public long[] values()
    {
        return metric.getSnapshot().getValues();
    }

    private Bean(Histogram histogram, ObjectName objectname)
    {
        metric = histogram;
        objectName = objectname;
    }

    objectName(Histogram histogram, ObjectName objectname, objectName objectname1)
    {
        this(histogram, objectname);
    }
}
