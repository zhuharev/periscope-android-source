// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.codahale.metrics:
//            MetricRegistry

public class SharedMetricRegistries
{

    private static final ConcurrentMap REGISTRIES = new ConcurrentHashMap();

    private SharedMetricRegistries()
    {
    }

    public static MetricRegistry add(String s, MetricRegistry metricregistry)
    {
        return (MetricRegistry)REGISTRIES.putIfAbsent(s, metricregistry);
    }

    public static void clear()
    {
        REGISTRIES.clear();
    }

    public static MetricRegistry getOrCreate(String s)
    {
        MetricRegistry metricregistry = (MetricRegistry)REGISTRIES.get(s);
        if (metricregistry == null)
        {
            metricregistry = new MetricRegistry();
            s = add(s, metricregistry);
            if (s == null)
            {
                return metricregistry;
            } else
            {
                return s;
            }
        } else
        {
            return metricregistry;
        }
    }

    public static Set names()
    {
        return REGISTRIES.keySet();
    }

    public static void remove(String s)
    {
        REGISTRIES.remove(s);
    }

}
