// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public abstract class Clock
{
    public static class CpuTimeClock extends Clock
    {

        private static final ThreadMXBean THREAD_MX_BEAN = ManagementFactory.getThreadMXBean();

        public long getTick()
        {
            return THREAD_MX_BEAN.getCurrentThreadCpuTime();
        }


        public CpuTimeClock()
        {
        }
    }

    public static class UserTimeClock extends Clock
    {

        public long getTick()
        {
            return System.nanoTime();
        }

        public UserTimeClock()
        {
        }
    }


    private static final Clock DEFAULT = new UserTimeClock();

    public Clock()
    {
    }

    public static Clock defaultClock()
    {
        return DEFAULT;
    }

    public abstract long getTick();

    public long getTime()
    {
        return System.currentTimeMillis();
    }

}
