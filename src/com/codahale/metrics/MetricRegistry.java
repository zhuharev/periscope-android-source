// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.codahale.metrics:
//            MetricSet, Metric, MetricFilter, Gauge, 
//            MetricRegistryListener, Counter, Histogram, Meter, 
//            Timer

public class MetricRegistry
    implements MetricSet
{
    static interface MetricBuilder
    {

        public static final MetricBuilder COUNTERS = new _cls1();
        public static final MetricBuilder HISTOGRAMS = new _cls2();
        public static final MetricBuilder METERS = new _cls3();
        public static final MetricBuilder TIMERS = new _cls4();

        public abstract boolean isInstance(Metric metric);

        public abstract Metric newMetric();


        class _cls1
            implements MetricBuilder
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
            implements MetricBuilder
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
            implements MetricBuilder
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
            implements MetricBuilder
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


    private final List listeners = new CopyOnWriteArrayList();
    private final ConcurrentMap metrics = buildMap();

    public MetricRegistry()
    {
    }

    private static void append(StringBuilder stringbuilder, String s)
    {
        if (s != null && !s.isEmpty())
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('.');
            }
            stringbuilder.append(s);
        }
    }

    private SortedMap getMetrics(Class class1, MetricFilter metricfilter)
    {
        TreeMap treemap = new TreeMap();
        Iterator iterator = metrics.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (class1.isInstance(entry.getValue()) && metricfilter.matches((String)entry.getKey(), (Metric)entry.getValue()))
            {
                treemap.put(entry.getKey(), (Metric)entry.getValue());
            }
        } while (true);
        return Collections.unmodifiableSortedMap(treemap);
    }

    private Metric getOrAdd(String s, MetricBuilder metricbuilder)
    {
        Metric metric;
        metric = (Metric)metrics.get(s);
        if (metricbuilder.isInstance(metric))
        {
            return metric;
        }
        if (metric != null) goto _L2; else goto _L1
_L1:
        metric = register(s, metricbuilder.newMetric());
        return metric;
_L4:
        Metric metric1 = (Metric)metrics.get(s);
        if (metricbuilder.isInstance(metric1))
        {
            return metric1;
        }
_L2:
        throw new IllegalArgumentException((new StringBuilder()).append(s).append(" is already used for a different type of metric").toString());
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient String name(Class class1, String as[])
    {
        return name(class1.getName(), as);
    }

    public static transient String name(String s, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        append(stringbuilder, s);
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                append(stringbuilder, as[i]);
            }

        }
        return stringbuilder.toString();
    }

    private void notifyListenerOfAddedMetric(MetricRegistryListener metricregistrylistener, Metric metric, String s)
    {
        if (metric instanceof Gauge)
        {
            metricregistrylistener.onGaugeAdded(s, (Gauge)metric);
            return;
        }
        if (metric instanceof Counter)
        {
            metricregistrylistener.onCounterAdded(s, (Counter)metric);
            return;
        }
        if (metric instanceof Histogram)
        {
            metricregistrylistener.onHistogramAdded(s, (Histogram)metric);
            return;
        }
        if (metric instanceof Meter)
        {
            metricregistrylistener.onMeterAdded(s, (Meter)metric);
            return;
        }
        if (metric instanceof Timer)
        {
            metricregistrylistener.onTimerAdded(s, (Timer)metric);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown metric type: ")).append(metric.getClass()).toString());
        }
    }

    private void notifyListenerOfRemovedMetric(String s, Metric metric, MetricRegistryListener metricregistrylistener)
    {
        if (metric instanceof Gauge)
        {
            metricregistrylistener.onGaugeRemoved(s);
            return;
        }
        if (metric instanceof Counter)
        {
            metricregistrylistener.onCounterRemoved(s);
            return;
        }
        if (metric instanceof Histogram)
        {
            metricregistrylistener.onHistogramRemoved(s);
            return;
        }
        if (metric instanceof Meter)
        {
            metricregistrylistener.onMeterRemoved(s);
            return;
        }
        if (metric instanceof Timer)
        {
            metricregistrylistener.onTimerRemoved(s);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown metric type: ")).append(metric.getClass()).toString());
        }
    }

    private void onMetricAdded(String s, Metric metric)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); notifyListenerOfAddedMetric((MetricRegistryListener)iterator.next(), metric, s)) { }
    }

    private void onMetricRemoved(String s, Metric metric)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); notifyListenerOfRemovedMetric(s, metric, (MetricRegistryListener)iterator.next())) { }
    }

    private void registerAll(String s, MetricSet metricset)
    {
        for (metricset = metricset.getMetrics().entrySet().iterator(); metricset.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)metricset.next();
            if (entry.getValue() instanceof MetricSet)
            {
                registerAll(name(s, new String[] {
                    (String)entry.getKey()
                }), (MetricSet)entry.getValue());
            } else
            {
                register(name(s, new String[] {
                    (String)entry.getKey()
                }), (Metric)entry.getValue());
            }
        }

    }

    public void addListener(MetricRegistryListener metricregistrylistener)
    {
        listeners.add(metricregistrylistener);
        java.util.Map.Entry entry;
        for (Iterator iterator = metrics.entrySet().iterator(); iterator.hasNext(); notifyListenerOfAddedMetric(metricregistrylistener, (Metric)entry.getValue(), (String)entry.getKey()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    protected ConcurrentMap buildMap()
    {
        return new ConcurrentHashMap();
    }

    public Counter counter(String s)
    {
        return (Counter)getOrAdd(s, MetricBuilder.COUNTERS);
    }

    public SortedMap getCounters()
    {
        return getCounters(MetricFilter.ALL);
    }

    public SortedMap getCounters(MetricFilter metricfilter)
    {
        return getMetrics(com/codahale/metrics/Counter, metricfilter);
    }

    public SortedMap getGauges()
    {
        return getGauges(MetricFilter.ALL);
    }

    public SortedMap getGauges(MetricFilter metricfilter)
    {
        return getMetrics(com/codahale/metrics/Gauge, metricfilter);
    }

    public SortedMap getHistograms()
    {
        return getHistograms(MetricFilter.ALL);
    }

    public SortedMap getHistograms(MetricFilter metricfilter)
    {
        return getMetrics(com/codahale/metrics/Histogram, metricfilter);
    }

    public SortedMap getMeters()
    {
        return getMeters(MetricFilter.ALL);
    }

    public SortedMap getMeters(MetricFilter metricfilter)
    {
        return getMetrics(com/codahale/metrics/Meter, metricfilter);
    }

    public Map getMetrics()
    {
        return Collections.unmodifiableMap(metrics);
    }

    public SortedSet getNames()
    {
        return Collections.unmodifiableSortedSet(new TreeSet(metrics.keySet()));
    }

    public SortedMap getTimers()
    {
        return getTimers(MetricFilter.ALL);
    }

    public SortedMap getTimers(MetricFilter metricfilter)
    {
        return getMetrics(com/codahale/metrics/Timer, metricfilter);
    }

    public Histogram histogram(String s)
    {
        return (Histogram)getOrAdd(s, MetricBuilder.HISTOGRAMS);
    }

    public Meter meter(String s)
    {
        return (Meter)getOrAdd(s, MetricBuilder.METERS);
    }

    public Metric register(String s, Metric metric)
    {
        if (metric instanceof MetricSet)
        {
            registerAll(s, (MetricSet)metric);
            return metric;
        }
        if ((Metric)metrics.putIfAbsent(s, metric) == null)
        {
            onMetricAdded(s, metric);
            return metric;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("A metric named ")).append(s).append(" already exists").toString());
        }
    }

    public void registerAll(MetricSet metricset)
    {
        registerAll(null, metricset);
    }

    public boolean remove(String s)
    {
        Metric metric = (Metric)metrics.remove(s);
        if (metric != null)
        {
            onMetricRemoved(s, metric);
            return true;
        } else
        {
            return false;
        }
    }

    public void removeListener(MetricRegistryListener metricregistrylistener)
    {
        listeners.remove(metricregistrylistener);
    }

    public void removeMatching(MetricFilter metricfilter)
    {
        Iterator iterator = metrics.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (metricfilter.matches((String)entry.getKey(), (Metric)entry.getValue()))
            {
                remove((String)entry.getKey());
            }
        } while (true);
    }

    public Timer timer(String s)
    {
        return (Timer)getOrAdd(s, MetricBuilder.TIMERS);
    }
}
