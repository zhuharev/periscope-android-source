// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            InstrumentedExecutorService, Counter, Timer, Meter

class task
    implements Runnable
{

    private final Runnable task;
    final InstrumentedExecutorService this$0;

    public void run()
    {
        task task1;
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).inc();
        task1 = InstrumentedExecutorService.access$100(InstrumentedExecutorService.this).time();
        task.run();
        task1.task();
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).dec();
        InstrumentedExecutorService.access$200(InstrumentedExecutorService.this).mark();
        return;
        Exception exception;
        exception;
        task1._mth0();
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).dec();
        InstrumentedExecutorService.access$200(InstrumentedExecutorService.this).mark();
        throw exception;
    }

    (Runnable runnable)
    {
        this$0 = InstrumentedExecutorService.this;
        super();
        task = runnable;
    }
}
