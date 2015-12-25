// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Gauge

public abstract class DerivativeGauge
    implements Gauge
{

    private final Gauge base;

    protected DerivativeGauge(Gauge gauge)
    {
        base = gauge;
    }

    public Object getValue()
    {
        return transform(base.getValue());
    }

    protected abstract Object transform(Object obj);
}
