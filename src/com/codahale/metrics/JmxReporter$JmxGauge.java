// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter, Gauge

static class <init> extends ean
    implements Bean
{

    private final Gauge metric;

    public Object getValue()
    {
        return metric.getValue();
    }

    private Bean(Gauge gauge, ObjectName objectname)
    {
        super(objectname);
        metric = gauge;
    }

    metric(Gauge gauge, ObjectName objectname, metric metric1)
    {
        this(gauge, objectname);
    }
}
