// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.Callable;

// Referenced classes of package com.codahale.metrics:
//            InstrumentedScheduledExecutorService, Counter, Timer, Meter

class task
    implements Callable
{

    private final Callable task;
    final InstrumentedScheduledExecutorService this$0;

    public Object call()
    {
        task task1;
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).inc();
        task1 = InstrumentedScheduledExecutorService.access$100(InstrumentedScheduledExecutorService.this).time();
        Object obj = task.call();
        task1.task();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        return obj;
        Exception exception;
        exception;
        task1._mth0();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        throw exception;
    }

    (Callable callable)
    {
        this$0 = InstrumentedScheduledExecutorService.this;
        super();
        task = callable;
    }
}
