// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.codahale.metrics:
//            ScheduledReporter

static class <init>
    implements ThreadFactory
{

    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(group, runnable, (new StringBuilder()).append(namePrefix).append(threadNumber.getAndIncrement()).toString(), 0L);
        runnable.setDaemon(true);
        if (runnable.getPriority() != 5)
        {
            runnable.setPriority(5);
        }
        return runnable;
    }

    private (String s)
    {
        threadNumber = new AtomicInteger(1);
        Object obj = System.getSecurityManager();
        if (obj != null)
        {
            obj = ((SecurityManager) (obj)).getThreadGroup();
        } else
        {
            obj = Thread.currentThread().getThreadGroup();
        }
        group = ((ThreadGroup) (obj));
        namePrefix = (new StringBuilder("metrics-")).append(s).append("-thread-").toString();
    }

    namePrefix(String s, namePrefix nameprefix)
    {
        this(s);
    }
}
