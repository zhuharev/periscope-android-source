// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import o.wt;

// Referenced classes of package com.codahale.metrics:
//            MetricRegistryListener, JmxReporter, ObjectNameFactory, MetricFilter, 
//            Counter, Gauge, Histogram, Meter, 
//            Timer

static class its
    implements MetricRegistryListener
{

    private final MetricFilter filter;
    private final MBeanServer mBeanServer;
    private final String name;
    private final ObjectNameFactory objectNameFactory;
    private final Map registered;
    private final its timeUnits;

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
                registerMBean(new init>(counter, s, null), s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CB("Unable to register counter", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to register counter", s);
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
            JmxReporter.access$400()._mth02CB("Unable to unregister counter", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to unregister counter", s);
        }
    }

    public void onGaugeAdded(String s, Gauge gauge)
    {
        try
        {
            if (filter.matches(s, gauge))
            {
                s = createName("gauges", s);
                registerMBean(new it>(gauge, s, null), s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CB("Unable to register gauge", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to register gauge", s);
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
            JmxReporter.access$400()._mth02CB("Unable to unregister gauge", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to unregister gauge", s);
        }
    }

    public void onHistogramAdded(String s, Histogram histogram)
    {
        try
        {
            if (filter.matches(s, histogram))
            {
                s = createName("histograms", s);
                registerMBean(new (histogram, s, null), s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CB("Unable to register histogram", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to register histogram", s);
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
            JmxReporter.access$400()._mth02CB("Unable to unregister histogram", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to unregister histogram", s);
        }
    }

    public void onMeterAdded(String s, Meter meter)
    {
        try
        {
            if (filter.matches(s, meter))
            {
                ObjectName objectname = createName("meters", s);
                registerMBean(new it>(meter, objectname, timeUnits.rateFor(s), null), objectname);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CB("Unable to register meter", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to register meter", s);
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
            JmxReporter.access$400()._mth02CB("Unable to unregister meter", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to unregister meter", s);
        }
    }

    public void onTimerAdded(String s, Timer timer)
    {
        try
        {
            if (filter.matches(s, timer))
            {
                ObjectName objectname = createName("timers", s);
                registerMBean(new it>(timer, objectname, timeUnits.rateFor(s), timeUnits.durationFor(s), null), objectname);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CB("Unable to register timer", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to register timer", s);
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
            JmxReporter.access$400()._mth02CB("Unable to unregister timer", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            JmxReporter.access$400()._mth02CE("Unable to unregister timer", s);
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
                JmxReporter.access$400()._mth02CB("Unable to unregister metric", instancenotfoundexception);
            }
            catch (MBeanRegistrationException mbeanregistrationexception)
            {
                JmxReporter.access$400()._mth02CE("Unable to unregister metric", mbeanregistrationexception);
            }
        }

        registered.clear();
    }


    private its(MBeanServer mbeanserver, String s, MetricFilter metricfilter, its its, ObjectNameFactory objectnamefactory)
    {
        mBeanServer = mbeanserver;
        name = s;
        filter = metricfilter;
        timeUnits = its;
        registered = new ConcurrentHashMap();
        objectNameFactory = objectnamefactory;
    }

    its(MBeanServer mbeanserver, String s, MetricFilter metricfilter, its its, ObjectNameFactory objectnamefactory, its its1)
    {
        this(mbeanserver, s, metricfilter, its, objectnamefactory);
    }
}
