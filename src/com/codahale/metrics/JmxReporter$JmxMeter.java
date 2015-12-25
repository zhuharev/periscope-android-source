// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter, Metered

static class <init> extends ean
    implements Bean
{

    private final Metered metric;
    private final double rateFactor;
    private final String rateUnit;

    private String calculateRateUnit(TimeUnit timeunit)
    {
        timeunit = timeunit.toString().toLowerCase(Locale.US);
        return timeunit.substring(0, timeunit.length() - 1);
    }

    public long getCount()
    {
        return metric.getCount();
    }

    public double getFifteenMinuteRate()
    {
        return metric.getFifteenMinuteRate() * rateFactor;
    }

    public double getFiveMinuteRate()
    {
        return metric.getFiveMinuteRate() * rateFactor;
    }

    public double getMeanRate()
    {
        return metric.getMeanRate() * rateFactor;
    }

    public double getOneMinuteRate()
    {
        return metric.getOneMinuteRate() * rateFactor;
    }

    public String getRateUnit()
    {
        return rateUnit;
    }

    private Bean(Metered metered, ObjectName objectname, TimeUnit timeunit)
    {
        super(objectname);
        metric = metered;
        rateFactor = timeunit.toSeconds(1L);
        rateUnit = (new StringBuilder("events/")).append(calculateRateUnit(timeunit)).toString();
    }

    calculateRateUnit(Metered metered, ObjectName objectname, TimeUnit timeunit, calculateRateUnit calculaterateunit)
    {
        this(metered, objectname, timeunit);
    }
}
