// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.Closeable;
import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import o.wt;
import o.wu;

// Referenced classes of package com.codahale.metrics:
//            Reporter, MetricRegistry, MetricFilter, ObjectNameFactory, 
//            DefaultObjectNameFactory, Counter, Gauge, Histogram, 
//            Snapshot, MetricRegistryListener, Meter, Timer, 
//            Metered

public class JmxReporter
    implements Reporter, Closeable
{
    static abstract class AbstractBean
        implements MetricMBean
    {

        private final ObjectName objectName;

        public ObjectName objectName()
        {
            return objectName;
        }

        AbstractBean(ObjectName objectname)
        {
            objectName = objectname;
        }
    }

    public static class Builder
    {

        private String domain;
        private TimeUnit durationUnit;
        private MetricFilter filter;
        private MBeanServer mBeanServer;
        private ObjectNameFactory objectNameFactory;
        private TimeUnit rateUnit;
        private final MetricRegistry registry;
        private Map specificDurationUnits;
        private Map specificRateUnits;

        public JmxReporter build()
        {
            MetricTimeUnits metrictimeunits = new MetricTimeUnits(rateUnit, durationUnit, specificRateUnits, specificDurationUnits);
            if (mBeanServer == null)
            {
                mBeanServer = ManagementFactory.getPlatformMBeanServer();
            }
            return new JmxReporter(mBeanServer, domain, registry, filter, metrictimeunits, objectNameFactory);
        }

        public Builder convertDurationsTo(TimeUnit timeunit)
        {
            durationUnit = timeunit;
            return this;
        }

        public Builder convertRatesTo(TimeUnit timeunit)
        {
            rateUnit = timeunit;
            return this;
        }

        public Builder createsObjectNamesWith(ObjectNameFactory objectnamefactory)
        {
            if (objectnamefactory == null)
            {
                throw new IllegalArgumentException("null objectNameFactory");
            } else
            {
                objectNameFactory = objectnamefactory;
                return this;
            }
        }

        public Builder filter(MetricFilter metricfilter)
        {
            filter = metricfilter;
            return this;
        }

        public Builder inDomain(String s)
        {
            domain = s;
            return this;
        }

        public Builder registerWith(MBeanServer mbeanserver)
        {
            mBeanServer = mbeanserver;
            return this;
        }

        public Builder specificDurationUnits(Map map)
        {
            specificDurationUnits = Collections.unmodifiableMap(map);
            return this;
        }

        public Builder specificRateUnits(Map map)
        {
            specificRateUnits = Collections.unmodifiableMap(map);
            return this;
        }

        private Builder(MetricRegistry metricregistry)
        {
            filter = MetricFilter.ALL;
            registry = metricregistry;
            rateUnit = TimeUnit.SECONDS;
            durationUnit = TimeUnit.MILLISECONDS;
            domain = "metrics";
            objectNameFactory = new DefaultObjectNameFactory();
            specificDurationUnits = Collections.emptyMap();
            specificRateUnits = Collections.emptyMap();
        }

    }

    static class JmxCounter extends AbstractBean
        implements JmxCounterMBean
    {

        private final Counter metric;

        public long getCount()
        {
            return metric.getCount();
        }

        private JmxCounter(Counter counter, ObjectName objectname)
        {
            super(objectname);
            metric = counter;
        }

    }

    public static interface JmxCounterMBean
        extends MetricMBean
    {

        public abstract long getCount();
    }

    static class JmxGauge extends AbstractBean
        implements JmxGaugeMBean
    {

        private final Gauge metric;

        public Object getValue()
        {
            return metric.getValue();
        }

        private JmxGauge(Gauge gauge, ObjectName objectname)
        {
            super(objectname);
            metric = gauge;
        }

    }

    public static interface JmxGaugeMBean
        extends MetricMBean
    {

        public abstract Object getValue();
    }

    static class JmxHistogram
        implements JmxHistogramMBean
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

        private JmxHistogram(Histogram histogram, ObjectName objectname)
        {
            metric = histogram;
            objectName = objectname;
        }

    }

    public static interface JmxHistogramMBean
        extends MetricMBean
    {

        public abstract double get50thPercentile();

        public abstract double get75thPercentile();

        public abstract double get95thPercentile();

        public abstract double get98thPercentile();

        public abstract double get999thPercentile();

        public abstract double get99thPercentile();

        public abstract long getCount();

        public abstract long getMax();

        public abstract double getMean();

        public abstract long getMin();

        public abstract double getStdDev();

        public abstract long[] values();
    }

    static class JmxListener
        implements MetricRegistryListener
    {

        private final MetricFilter filter;
        private final MBeanServer mBeanServer;
        private final String name;
        private final ObjectNameFactory objectNameFactory;
        private final Map registered;
        private final MetricTimeUnits timeUnits;

        private ObjectName createName(String s, String s1)
        {
            return objectNameFactory.createName(s, name, s1);
        }

        private void registerMBean(Object obj, ObjectName objectname)
        {
            obj = mBeanServer.registerMBean(obj, objectname);
            if (obj != null)
            {
                registered.put(objectname, ((ObjectInstance) (obj)).getObjectName());
                return;
            } else
            {
                registered.put(objectname, objectname);
                return;
            }
        }

        private void unregisterMBean(ObjectName objectname)
        {
            ObjectName objectname1 = (ObjectName)registered.remove(objectname);
            if (objectname1 != null)
            {
                mBeanServer.unregisterMBean(objectname1);
                return;
            } else
            {
                mBeanServer.unregisterMBean(objectname);
                return;
            }
        }

        public void onCounterAdded(String s, Counter counter)
        {
            try
            {
                if (filter.matches(s, counter))
                {
                    s = createName("counters", s);
                    registerMBean(new JmxCounter(counter, s), s);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to register counter", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to register counter", s);
            }
        }

        public void onCounterRemoved(String s)
        {
            try
            {
                unregisterMBean(createName("counters", s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to unregister counter", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to unregister counter", s);
            }
        }

        public void onGaugeAdded(String s, Gauge gauge)
        {
            try
            {
                if (filter.matches(s, gauge))
                {
                    s = createName("gauges", s);
                    registerMBean(new JmxGauge(gauge, s), s);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to register gauge", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to register gauge", s);
            }
        }

        public void onGaugeRemoved(String s)
        {
            try
            {
                unregisterMBean(createName("gauges", s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to unregister gauge", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to unregister gauge", s);
            }
        }

        public void onHistogramAdded(String s, Histogram histogram)
        {
            try
            {
                if (filter.matches(s, histogram))
                {
                    s = createName("histograms", s);
                    registerMBean(new JmxHistogram(histogram, s), s);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to register histogram", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to register histogram", s);
            }
        }

        public void onHistogramRemoved(String s)
        {
            try
            {
                unregisterMBean(createName("histograms", s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to unregister histogram", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to unregister histogram", s);
            }
        }

        public void onMeterAdded(String s, Meter meter)
        {
            try
            {
                if (filter.matches(s, meter))
                {
                    ObjectName objectname = createName("meters", s);
                    registerMBean(new JmxMeter(meter, objectname, timeUnits.rateFor(s)), objectname);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to register meter", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to register meter", s);
            }
        }

        public void onMeterRemoved(String s)
        {
            try
            {
                unregisterMBean(createName("meters", s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to unregister meter", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to unregister meter", s);
            }
        }

        public void onTimerAdded(String s, Timer timer)
        {
            try
            {
                if (filter.matches(s, timer))
                {
                    ObjectName objectname = createName("timers", s);
                    registerMBean(new JmxTimer(timer, objectname, timeUnits.rateFor(s), timeUnits.durationFor(s)), objectname);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to register timer", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to register timer", s);
            }
        }

        public void onTimerRemoved(String s)
        {
            try
            {
                unregisterMBean(createName("timers", s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CB("Unable to unregister timer", s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                JmxReporter.LOGGER._mth02CE("Unable to unregister timer", s);
            }
        }

        void unregisterAll()
        {
            for (Iterator iterator = registered.keySet().iterator(); iterator.hasNext();)
            {
                ObjectName objectname = (ObjectName)iterator.next();
                try
                {
                    unregisterMBean(objectname);
                }
                catch (InstanceNotFoundException instancenotfoundexception)
                {
                    JmxReporter.LOGGER._mth02CB("Unable to unregister metric", instancenotfoundexception);
                }
                catch (MBeanRegistrationException mbeanregistrationexception)
                {
                    JmxReporter.LOGGER._mth02CE("Unable to unregister metric", mbeanregistrationexception);
                }
            }

            registered.clear();
        }


        private JmxListener(MBeanServer mbeanserver, String s, MetricFilter metricfilter, MetricTimeUnits metrictimeunits, ObjectNameFactory objectnamefactory)
        {
            mBeanServer = mbeanserver;
            name = s;
            filter = metricfilter;
            timeUnits = metrictimeunits;
            registered = new ConcurrentHashMap();
            objectNameFactory = objectnamefactory;
        }

    }

    static class JmxMeter extends AbstractBean
        implements JmxMeterMBean
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

        private JmxMeter(Metered metered, ObjectName objectname, TimeUnit timeunit)
        {
            super(objectname);
            metric = metered;
            rateFactor = timeunit.toSeconds(1L);
            rateUnit = (new StringBuilder("events/")).append(calculateRateUnit(timeunit)).toString();
        }

    }

    public static interface JmxMeterMBean
        extends MetricMBean
    {

        public abstract long getCount();

        public abstract double getFifteenMinuteRate();

        public abstract double getFiveMinuteRate();

        public abstract double getMeanRate();

        public abstract double getOneMinuteRate();

        public abstract String getRateUnit();
    }

    static class JmxTimer extends JmxMeter
        implements JmxTimerMBean
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

        private JmxTimer(Timer timer, ObjectName objectname, TimeUnit timeunit, TimeUnit timeunit1)
        {
            super(timer, objectname, timeunit);
            metric = timer;
            durationFactor = 1.0D / (double)timeunit1.toNanos(1L);
            durationUnit = timeunit1.toString().toLowerCase(Locale.US);
        }

    }

    public static interface JmxTimerMBean
        extends JmxMeterMBean
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

    public static interface MetricMBean
    {

        public abstract ObjectName objectName();
    }

    static class MetricTimeUnits
    {

        private final TimeUnit defaultDuration;
        private final TimeUnit defaultRate;
        private final Map durationOverrides;
        private final Map rateOverrides;

        public TimeUnit durationFor(String s)
        {
            if (durationOverrides.containsKey(s))
            {
                return (TimeUnit)durationOverrides.get(s);
            } else
            {
                return defaultDuration;
            }
        }

        public TimeUnit rateFor(String s)
        {
            if (rateOverrides.containsKey(s))
            {
                return (TimeUnit)rateOverrides.get(s);
            } else
            {
                return defaultRate;
            }
        }

        MetricTimeUnits(TimeUnit timeunit, TimeUnit timeunit1, Map map, Map map1)
        {
            defaultRate = timeunit;
            defaultDuration = timeunit1;
            rateOverrides = map;
            durationOverrides = map1;
        }
    }


    private static final wt LOGGER = wu._mth02BF(com/codahale/metrics/JmxReporter);
    private final JmxListener listener;
    private final MetricRegistry registry;

    private JmxReporter(MBeanServer mbeanserver, String s, MetricRegistry metricregistry, MetricFilter metricfilter, MetricTimeUnits metrictimeunits, ObjectNameFactory objectnamefactory)
    {
        registry = metricregistry;
        listener = new JmxListener(mbeanserver, s, metricfilter, metrictimeunits, objectnamefactory);
    }


    public static Builder forRegistry(MetricRegistry metricregistry)
    {
        return new Builder(metricregistry);
    }

    public void close()
    {
        stop();
    }

    ObjectNameFactory getObjectNameFactory()
    {
        return listener.objectNameFactory;
    }

    public void start()
    {
        registry.addListener(listener);
    }

    public void stop()
    {
        registry.removeListener(listener);
        listener.unregisterAll();
    }


}
