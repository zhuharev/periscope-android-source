// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.codahale.metrics:
//            MetricSet

public class JvmAttributeGaugeSet
    implements MetricSet
{

    private final RuntimeMXBean runtime;

    public JvmAttributeGaugeSet()
    {
        this(ManagementFactory.getRuntimeMXBean());
    }

    public JvmAttributeGaugeSet(RuntimeMXBean runtimemxbean)
    {
        runtime = runtimemxbean;
    }

    public Map getMetrics()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", new _cls1());
        hashmap.put("vendor", new _cls2());
        hashmap.put("uptime", new _cls3());
        return Collections.unmodifiableMap(hashmap);
    }


    private class _cls1
        implements Gauge
    {

        final JvmAttributeGaugeSet this$0;

        public volatile Object getValue()
        {
            return getValue();
        }

        public String getValue()
        {
            return runtime.getName();
        }

        _cls1()
        {
            this$0 = JvmAttributeGaugeSet.this;
            super();
        }
    }


    private class _cls2
        implements Gauge
    {

        final JvmAttributeGaugeSet this$0;

        public volatile Object getValue()
        {
            return getValue();
        }

        public String getValue()
        {
            return String.format(Locale.US, "%s %s %s (%s)", new Object[] {
                runtime.getVmVendor(), runtime.getVmName(), runtime.getVmVersion(), runtime.getSpecVersion()
            });
        }

        _cls2()
        {
            this$0 = JvmAttributeGaugeSet.this;
            super();
        }
    }


    private class _cls3
        implements Gauge
    {

        final JvmAttributeGaugeSet this$0;

        public Long getValue()
        {
            return Long.valueOf(runtime.getUptime());
        }

        public volatile Object getValue()
        {
            return getValue();
        }

        _cls3()
        {
            this$0 = JvmAttributeGaugeSet.this;
            super();
        }
    }

}
