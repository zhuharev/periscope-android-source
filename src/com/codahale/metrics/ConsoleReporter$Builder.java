// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.PrintStream;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            ConsoleReporter, Clock, MetricFilter, MetricRegistry

public static class <init>
{

    private Clock clock;
    private TimeUnit durationUnit;
    private MetricFilter filter;
    private Locale locale;
    private PrintStream output;
    private TimeUnit rateUnit;
    private final MetricRegistry registry;
    private TimeZone timeZone;

    public ConsoleReporter build()
    {
        return new ConsoleReporter(registry, output, locale, clock, timeZone, rateUnit, durationUnit, filter, null);
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

    public filter formattedFor(Locale locale1)
    {
        locale = locale1;
        return this;
    }

    public locale formattedFor(TimeZone timezone)
    {
        timeZone = timezone;
        return this;
    }

    public timeZone outputTo(PrintStream printstream)
    {
        output = printstream;
        return this;
    }

    public output withClock(Clock clock1)
    {
        clock = clock1;
        return this;
    }

    private (MetricRegistry metricregistry)
    {
        registry = metricregistry;
        output = System.out;
        locale = Locale.getDefault();
        clock = Clock.defaultClock();
        timeZone = TimeZone.getDefault();
        rateUnit = TimeUnit.SECONDS;
        durationUnit = TimeUnit.MILLISECONDS;
        filter = MetricFilter.ALL;
    }

    filter(MetricRegistry metricregistry, filter filter1)
    {
        this(metricregistry);
    }
}
