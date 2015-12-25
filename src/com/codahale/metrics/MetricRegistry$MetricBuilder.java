// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            MetricRegistry, Metric

static interface _cls4
{

    public static final _cls4 COUNTERS = new _cls1();
    public static final _cls1 HISTOGRAMS = new _cls2();
    public static final _cls2 METERS = new _cls3();
    public static final _cls3 TIMERS = new _cls4();

    public abstract boolean isInstance(Metric metric);

    public abstract Metric newMetric();


    class _cls1
        implements MetricRegistry.MetricBuilder
    {

        public final boolean isInstance(Metric metric)
        {
            return com/codahale/metrics/Counter.isInstance(metric);
        }

        public final Counter newMetric()
        {
            return new Counter();
        }

        public final volatile Metric newMetric()
        {
            return newMetric();
        }

            _cls1()
            {
            }
    }


    class _cls2
        implements MetricRegistry.MetricBuilder
    {

        public final boolean isInstance(Metric metric)
        {
            return com/codahale/metrics/Histogram.isInstance(metric);
        }

        public final Histogram newMetric()
        {
            return new Histogram(new ExponentiallyDecayingReservoir());
        }

        public final volatile Metric newMetric()
        {
            return newMetric();
        }

            _cls2()
            {
            }
    }


    class _cls3
        implements MetricRegistry.MetricBuilder
    {

        public final boolean isInstance(Metric metric)
        {
            return com/codahale/metrics/Meter.isInstance(metric);
        }

        public final Meter newMetric()
        {
            return new Meter();
        }

        public final volatile Metric newMetric()
        {
            return newMetric();
        }

            _cls3()
            {
            }
    }


    class _cls4
        implements MetricRegistry.MetricBuilder
    {

        public final boolean isInstance(Metric metric)
        {
            return com/codahale/metrics/Timer.isInstance(metric);
        }

        public final volatile Metric newMetric()
        {
            return newMetric();
        }

        public final Timer newMetric()
        {
            return new Timer();
        }

            _cls4()
            {
            }
    }

}
