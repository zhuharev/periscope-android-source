// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            CsvReporter, Clock, MetricFilter, MetricRegistry

public static class <init>
{

    private Clock clock;
    private TimeUnit durationUnit;
    private MetricFilter filter;
    private Locale locale;
    private TimeUnit rateUnit;
    private final MetricRegistry registry;

    public CsvReporter build(File file)
    {
        return new CsvReporter(registry, file, locale, rateUnit, durationUnit, clock, filter, null);
    }

    public filter convertDurationsTo(TimeUnit timeunit)
    {
        durationUnit = timeunit;
        return this;
    }

    public durationUnit convertRatesTo(TimeUnit timeunit)
    {
        rateUnit = timeunit;
        return this;
    }

    public rateUnit filter(MetricFilter metricfilter)
    {
        filter = metricfilter;
        return this;
    }

    public filter formatFor(Locale locale1)
    {
        locale = locale1;
        return this;
    }

    public locale withClock(Clock clock1)
    {
        clock = clock1;
        return this;
    }

    private (MetricRegistry metricregistry)
    {
        registry = metricregistry;
        locale = Locale.getDefault();
        rateUnit = TimeUnit.SECONDS;
        durationUnit = TimeUnit.MILLISECONDS;
        clock = Clock.defaultClock();
        filter = MetricFilter.ALL;
    }

    filter(MetricRegistry metricregistry, filter filter1)
    {
        this(metricregistry);
    }
}
