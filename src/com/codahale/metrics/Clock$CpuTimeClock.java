// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

// Referenced classes of package com.codahale.metrics:
//            Clock

public static class  extends Clock
{

    private static final ThreadMXBean THREAD_MX_BEAN = ManagementFactory.getThreadMXBean();

    public long getTick()
    {
        return THREAD_MX_BEAN.getCurrentThreadCpuTime();
    }


    public ()
    {
    }
}
