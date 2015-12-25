// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.codahale.metrics:
//            MetricRegistry, Meter, Timer, Counter

public class InstrumentedExecutorService
    implements ExecutorService
{
    class InstrumentedCallable
        implements Callable
    {

        private final Callable callable;
        final InstrumentedExecutorService this$0;

        public Object call()
        {
            Timer.Context context;
            running.inc();
            context = duration.time();
            Object obj = callable.call();
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

        InstrumentedCallable(Callable callable1)
        {
            this$0 = InstrumentedExecutorService.this;
            super();
            callable = callable1;
        }
    }

    class InstrumentedRunnable
        implements Runnable
    {

        private final Runnable task;
        final InstrumentedExecutorService this$0;

        public void run()
        {
            Timer.Context context;
            running.inc();
            context = duration.time();
            task.run();
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
            this$0 = InstrumentedExecutorService.this;
            super();
            task = runnable;
        }
    }


    private static final AtomicLong nameCounter = new AtomicLong();
    private final Meter completed;
    private final ExecutorService _flddelegate;
    private final Timer duration;
    private final Counter running;
    private final Meter submitted;

    public InstrumentedExecutorService(ExecutorService executorservice, MetricRegistry metricregistry)
    {
        this(executorservice, metricregistry, (new StringBuilder("instrumented-delegate-")).append(nameCounter.incrementAndGet()).toString());
    }

    public InstrumentedExecutorService(ExecutorService executorservice, MetricRegistry metricregistry, String s)
    {
        _flddelegate = executorservice;
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
