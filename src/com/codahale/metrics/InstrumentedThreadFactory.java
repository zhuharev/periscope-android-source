// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            MetricRegistry, Meter, Counter

public class InstrumentedThreadFactory
    implements ThreadFactory
{
    class InstrumentedRunnable
        implements Runnable
    {

        private final Runnable task;
        final InstrumentedThreadFactory this$0;

        public void run()
        {
            running.inc();
            task.run();
            running.dec();
            terminated.mark();
            return;
            Exception exception;
            exception;
            running.dec();
            terminated.mark();
            throw exception;
        }

        InstrumentedRunnable(Runnable runnable)
        {
            this$0 = InstrumentedThreadFactory.this;
            super();
            task = runnable;
        }
    }


    private static final AtomicLong nameCounter = new AtomicLong();
    private final Meter created;
    private final ThreadFactory _flddelegate;
    private final Counter running;
    private final Meter terminated;

    public InstrumentedThreadFactory(ThreadFactory threadfactory, MetricRegistry metricregistry)
    {
        this(threadfactory, metricregistry, (new StringBuilder("instrumented-thread-delegate-")).append(nameCounter.incrementAndGet()).toString());
    }

    public InstrumentedThreadFactory(ThreadFactory threadfactory, MetricRegistry metricregistry, String s)
    {
        _flddelegate = threadfactory;
        created = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "created"
        }));
        running = metricregistry.counter(MetricRegistry.name(s, new String[] {
            "running"
        }));
        terminated = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "terminated"
        }));
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new InstrumentedRunnable(runnable);
        runnable = _flddelegate.newThread(runnable);
        created.mark();
        return runnable;
    }



}
