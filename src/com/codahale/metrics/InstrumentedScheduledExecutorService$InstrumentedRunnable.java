// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            InstrumentedScheduledExecutorService, Counter, Timer, Meter

class command
    implements Runnable
{

    private final Runnable command;
    final InstrumentedScheduledExecutorService this$0;

    public void run()
    {
        command command1;
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).inc();
        command1 = InstrumentedScheduledExecutorService.access$100(InstrumentedScheduledExecutorService.this).time();
        command.run();
        command1.command();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        return;
        Exception exception;
        exception;
        command1._mth0();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        throw exception;
    }

    (Runnable runnable)
    {
        this$0 = InstrumentedScheduledExecutorService.this;
        super();
        command = runnable;
    }
}
