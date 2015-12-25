// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Metric

public interface MetricFilter
{

    public static final MetricFilter ALL = new _cls1();

    public abstract boolean matches(String s, Metric metric);


    private class _cls1
        implements MetricFilter
    {

        public final boolean matches(String s, Metric metric)
        {
            return true;
        }

        _cls1()
        {
        }
    }

}
