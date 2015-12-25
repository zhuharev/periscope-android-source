// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.TimeUnit;
import o.wt;
import o.wu;
import o.wv;

// Referenced classes of package com.codahale.metrics:
//            Slf4jReporter, MetricFilter, MetricRegistry

public static class <init>
{

    private TimeUnit durationUnit;
    private MetricFilter filter;
    private wt logger;
    private evel loggingLevel;
    private wv marker;
    private TimeUnit rateUnit;
    private final MetricRegistry registry;

    public Slf4jReporter build()
    {
        Object obj;
        switch (hMap.com.codahale.metrics.Slf4jReporter.LoggingLevel[loggingLevel.ordinal()])
        {
        case 1: // '\001'
            obj = new gerProxy(logger);
            break;

        case 2: // '\002'
            obj = new erProxy(logger);
            break;

        case 3: // '\003'
            obj = new erProxy(logger);
            break;

        case 4: // '\004'
            obj = new gerProxy(logger);
            break;

        default:
            obj = new gerProxy(logger);
            break;
        }
        return new Slf4jReporter(registry, ((oxy) (obj)), marker, rateUnit, durationUnit, filter, null);
    }

    public oxy convertDurationsTo(TimeUnit timeunit)
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

    public filter markWith(wv wv)
    {
        marker = wv;
        return this;
    }

    public marker outputTo(wt wt)
    {
        logger = wt;
        return this;
    }

    public evel withLoggingLevel(evel evel)
    {
        loggingLevel = evel;
        return this;
    }

    private evel(MetricRegistry metricregistry)
    {
        registry = metricregistry;
        logger = wu._mth02E4("metrics");
        marker = null;
        rateUnit = TimeUnit.SECONDS;
        durationUnit = TimeUnit.MILLISECONDS;
        filter = MetricFilter.ALL;
        loggingLevel = evel.INFO;
    }

    evel.INFO(MetricRegistry metricregistry, evel.INFO info)
    {
        this(metricregistry);
    }
}
