// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.Closeable;
import java.io.PrintStream;
import java.util.Locale;
import java.util.SortedMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import o.wt;
import o.wu;

// Referenced classes of package com.codahale.metrics:
//            Reporter, MetricRegistry, MetricFilter

public abstract class ScheduledReporter
    implements Closeable, Reporter
{
    static class NamedThreadFactory
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

        private NamedThreadFactory(String s)
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

        NamedThreadFactory(String s, _cls1 _pcls1)
        {
            this(s);
        }
    }


    private static final AtomicInteger FACTORY_ID = new AtomicInteger();
    private static final wt LOG = wu._mth02BF(com/codahale/metrics/ScheduledReporter);
    private final double durationFactor;
    private final String durationUnit;
    private final ScheduledExecutorService executor;
    private final MetricFilter filter;
    private final double rateFactor;
    private final String rateUnit;
    private final MetricRegistry registry;

    protected ScheduledReporter(MetricRegistry metricregistry, String s, MetricFilter metricfilter, TimeUnit timeunit, TimeUnit timeunit1)
    {
        this(metricregistry, s, metricfilter, timeunit, timeunit1, Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory((new StringBuilder()).append(s).append('-').append(FACTORY_ID.incrementAndGet()).toString(), null)));
    }

    protected ScheduledReporter(MetricRegistry metricregistry, String s, MetricFilter metricfilter, TimeUnit timeunit, TimeUnit timeunit1, ScheduledExecutorService scheduledexecutorservice)
    {
        registry = metricregistry;
        filter = metricfilter;
        executor = scheduledexecutorservice;
        rateFactor = timeunit.toSeconds(1L);
        rateUnit = calculateRateUnit(timeunit);
        durationFactor = 1.0D / (double)timeunit1.toNanos(1L);
        durationUnit = timeunit1.toString().toLowerCase(Locale.US);
    }

    private String calculateRateUnit(TimeUnit timeunit)
    {
        timeunit = timeunit.toString().toLowerCase(Locale.US);
        return timeunit.substring(0, timeunit.length() - 1);
    }

    public void close()
    {
        stop();
    }

    protected double convertDuration(double d)
    {
        return durationFactor * d;
    }

    protected double convertRate(double d)
    {
        return rateFactor * d;
    }

    protected String getDurationUnit()
    {
        return durationUnit;
    }

    protected String getRateUnit()
    {
        return rateUnit;
    }

    public void report()
    {
        this;
        JVM INSTR monitorenter ;
        report(registry.getGauges(filter), registry.getCounters(filter), registry.getHistograms(filter), registry.getMeters(filter), registry.getTimers(filter));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract void report(SortedMap sortedmap, SortedMap sortedmap1, SortedMap sortedmap2, SortedMap sortedmap3, SortedMap sortedmap4);

    public void start(long l, TimeUnit timeunit)
    {
        executor.scheduleAtFixedRate(new _cls1(), l, l, timeunit);
    }

    public void stop()
    {
        InterruptedException interruptedexception;
        executor.shutdown();
        try
        {
            if (!executor.awaitTermination(1L, TimeUnit.SECONDS))
            {
                executor.shutdownNow();
                if (!executor.awaitTermination(1L, TimeUnit.SECONDS))
                {
                    System.err.println((new StringBuilder()).append(getClass().getSimpleName()).append(": ScheduledExecutorService did not terminate").toString());
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            executor.shutdownNow();
        }
        Thread.currentThread().interrupt();
    }



    private class _cls1
        implements Runnable
    {

        final ScheduledReporter this$0;

        public void run()
        {
            try
            {
                report();
                return;
            }
            catch (RuntimeException runtimeexception)
            {
                ScheduledReporter.LOG._mth02CB("RuntimeException thrown from {}#report. Exception was suppressed.", getClass().getSimpleName(), runtimeexception);
            }
        }

        _cls1()
        {
            this$0 = ScheduledReporter.this;
            super();
        }
    }

}
