// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Map;

// Referenced classes of package com.codahale.metrics:
//            Metric

public interface MetricSet
    extends Metric
{

    public abstract Map getMetrics();
}
