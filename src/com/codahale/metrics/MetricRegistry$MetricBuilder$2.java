// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Histogram, ExponentiallyDecayingReservoir, Metric

final class _cls9
    implements _cls9
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

    _cls9()
    {
    }
}
