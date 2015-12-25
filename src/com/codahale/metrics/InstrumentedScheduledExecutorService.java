// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            MetricRegistry, Meter, Timer, Histogram, 
//            Counter

public class InstrumentedScheduledExecutorService
    implements ScheduledExecutorService
{
    class InstrumentedCallable
        implements Callable
    {

        private final Callable task;
        final InstrumentedScheduledExecutorService this$0;

        public Object call()
        {
            Timer.Context context;
            running.inc();
            context = duration.time();
            Object obj = task.call();
            context.stop();
            running.dec();
            completed.mark();
            return obj;
            Exception exception;
            exception;
            context.stop();
            running.dec();
            completed.mark();
            throw exception;
        }

        InstrumentedCallable(Callable callable)
        {
            this$0 = InstrumentedScheduledExecutorService.this;
            super();
            task = callable;
        }
    }

    class InstrumentedPeriodicRunnable
        implements Runnable
    {

        private final Runnable command;
        private final long periodInNanos;
        final InstrumentedScheduledExecutorService this$0;

        public void run()
        {
            Timer.Context context;
            running.inc();
            context = duration.time();
            command.run();
            long l = context.stop();
            running.dec();
            completed.mark();
            if (l > periodInNanos)
            {
                scheduledOverrun.inc();
            }
            percentOfPeriod.update((100L * l) / periodInNanos);
            return;
            Exception exception;
            exception;
            long l1 = context.stop();
            running.dec();
            completed.mark();
            if (l1 > periodInNanos)
            {
                scheduledOverrun.inc();
            }
            percentOfPeriod.update((100L * l1) / periodInNanos);
            throw exception;
        }

        InstrumentedPeriodicRunnable(Runnable runnable, long l, TimeUnit timeunit)
        {
            this$0 = InstrumentedScheduledExecutorService.this;
            super();
            command = runnable;
            periodInNanos = timeunit.toNanos(l);
        }
    }

    class InstrumentedRunnable
        implements Runnable
    {

        private final Runnable command;
        final InstrumentedScheduledExecutorService this$0;

        public void run()
        {
            Timer.Context context;
            running.inc();
            context = duration.time();
            command.run();
            context.stop();
            running.dec();
            completed.mark();
            return;
            Exception exception;
            exception;
            context.stop();
            running.dec();
            completed.mark();
            throw exception;
        }

        InstrumentedRunnable(Runnable runnable)
        {
            this$0 = InstrumentedScheduledExecutorService.this;
            super();
            command = runnable;
        }
    }


    private static final AtomicLong nameCounter = new AtomicLong();
    private final Meter completed;
    private final ScheduledExecutorService _flddelegate;
    private final Timer duration;
    private final Histogram percentOfPeriod;
    private final Counter running;
    private final Meter scheduledOnce;
    private final Counter scheduledOverrun;
    private final Meter scheduledRepetitively;
    private final Meter submitted;

    public InstrumentedScheduledExecutorService(ScheduledExecutorService scheduledexecutorservice, MetricRegistry metricregistry)
    {
        this(scheduledexecutorservice, metricregistry, (new StringBuilder("instrumented-scheduled-executor-service-")).append(nameCounter.incrementAndGet()).toString());
    }

    public InstrumentedScheduledExecutorService(ScheduledExecutorService scheduledexecutorservice, MetricRegistry metricregistry, String s)
    {
        _flddelegate = scheduledexecutorservice;
        submitted = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "submitted"
        }));
        running = metricregistry.counter(MetricRegistry.name(s, new String[] {
            "running"
        }));
        completed = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "completed"
        }));
        duration = metricregistry.timer(MetricRegistry.name(s, new String[] {
            "duration"
        }));
        scheduledOnce = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "scheduled.once"
        }));
        scheduledRepetitively = metricregistry.meter(MetricRegistry.name(s, new String[] {
            "scheduled.repetitively"
        }));
        scheduledOverrun = metricregistry.counter(MetricRegistry.name(s, new String[] {
            "scheduled.overrun"
        }));
        percentOfPeriod = metricregistry.histogram(MetricRegistry.name(s, new String[] {
            "scheduled.percent-of-period"
        }));
    }

    private Collection instrument(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new InstrumentedCallable((Callable)collection.next()))) { }
        return arraylist;
    }

    public boolean awaitTermination(long l, TimeUnit timeunit)
    {
        return _flddelegate.awaitTermination(l, timeunit);
    }

    public void execute(Runnable runnable)
    {
        submitted.mark();
        _flddelegate.execute(new InstrumentedRunnable(runnable));
    }

    public List invokeAll(Collection collection)
    {
        submitted.mark(collection.size());
        collection = instrument(collection);
        return _flddelegate.invokeAll(collection);
    }

    public List invokeAll(Collection collection, long l, TimeUnit timeunit)
    {
        submitted.mark(collection.size());
        collection = instrument(collection);
        return _flddelegate.invokeAll(collection, l, timeunit);
    }

    public Object invokeAny(Collection collection)
    {
        submitted.mark(collection.size());
        collection = instrument(collection);
        return _flddelegate.invokeAny(collection);
    }

    public Object invokeAny(Collection collection, long l, TimeUnit timeunit)
    {
        submitted.mark(collection.size());
        collection = instrument(collection);
        return _flddelegate.invokeAny(collection, l, timeunit);
    }

    public boolean isShutdown()
    {
        return _flddelegate.isShutdown();
    }

    public boolean isTerminated()
    {
        return _flddelegate.isTerminated();
    }

    public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeunit)
    {
        scheduledOnce.mark();
        return _flddelegate.schedule(new InstrumentedRunnable(runnable), l, timeunit);
    }

    public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeunit)
    {
        scheduledOnce.mark();
        return _flddelegate.schedule(new InstrumentedCallable(callable), l, timeunit);
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l1, TimeUnit timeunit)
    {
        scheduledRepetitively.mark();
        return _flddelegate.scheduleAtFixedRate(new InstrumentedPeriodicRunnable(runnable, l1, timeunit), l, l1, timeunit);
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l1, TimeUnit timeunit)
    {
        scheduledRepetitively.mark();
        return _flddelegate.scheduleAtFixedRate(new InstrumentedRunnable(runnable), l, l1, timeunit);
    }

    public void shutdown()
    {
        _flddelegate.shutdown();
    }

    public List shutdownNow()
    {
        return _flddelegate.shutdownNow();
    }

    public Future submit(Runnable runnable)
    {
        submitted.mark();
        return _flddelegate.submit(new InstrumentedRunnable(runnable));
    }

    public Future submit(Runnable runnable, Object obj)
    {
        submitted.mark();
        return _flddelegate.submit(new InstrumentedRunnable(runnable), obj);
    }

    public Future submit(Callable callable)
    {
        submitted.mark();
        return _flddelegate.submit(new InstrumentedCallable(callable));
    }






}
