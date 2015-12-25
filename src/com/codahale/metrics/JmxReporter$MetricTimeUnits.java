// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            JmxReporter

static class durationOverrides
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

    (TimeUnit timeunit, TimeUnit timeunit1, Map map, Map map1)
    {
        defaultRate = timeunit;
        defaultDuration = timeunit1;
        rateOverrides = map;
        durationOverrides = map1;
    }
}
