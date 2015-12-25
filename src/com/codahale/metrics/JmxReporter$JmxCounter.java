// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import javax.management.ObjectName;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter, Counter

static class <init> extends n
    implements Bean
{

    private final Counter metric;

    public long getCount()
    {
        return metric.getCount();
    }

    private Bean(Counter counter, ObjectName objectname)
    {
        super(objectname);
        metric = counter;
    }

    metric(Counter counter, ObjectName objectname, metric metric1)
    {
        this(counter, objectname);
    }
}
