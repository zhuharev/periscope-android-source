// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.EventListener;

// Referenced classes of package com.codahale.metrics:
//            Counter, Gauge, Histogram, Meter, 
//            Timer

public interface MetricRegistryListener
    extends EventListener
{
    public static abstract class Base
        implements MetricRegistryListener
    {

        public void onCounterAdded(String s, Counter counter)
        {
        }

        public void onCounterRemoved(String s)
        {
        }

        public void onGaugeAdded(String s, Gauge gauge)
        {
        }

        public void onGaugeRemoved(String s)
        {
        }

        public void onHistogramAdded(String s, Histogram histogram)
        {
        }

        public void onHistogramRemoved(String s)
        {
        }

        public void onMeterAdded(String s, Meter meter)
        {
        }

        public void onMeterRemoved(String s)
        {
        }

        public void onTimerAdded(String s, Timer timer)
        {
        }

        public void onTimerRemoved(String s)
        {
        }

        public Base()
        {
        }
    }


    public abstract void onCounterAdded(String s, Counter counter);

    public abstract void onCounterRemoved(String s);

    public abstract void onGaugeAdded(String s, Gauge gauge);

    public abstract void onGaugeRemoved(String s);

    public abstract void onHistogramAdded(String s, Histogram histogram);

    public abstract void onHistogramRemoved(String s);

    public abstract void onMeterAdded(String s, Meter meter);

    public abstract void onMeterRemoved(String s);

    public abstract void onTimerAdded(String s, Timer timer);

    public abstract void onTimerRemoved(String s);
}
