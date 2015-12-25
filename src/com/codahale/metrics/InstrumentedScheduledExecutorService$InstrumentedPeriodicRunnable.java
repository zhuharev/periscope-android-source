// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            InstrumentedScheduledExecutorService, Counter, Timer, Meter, 
//            Histogram

class periodInNanos
    implements Runnable
{

    private final Runnable command;
    private final long periodInNanos;
    final InstrumentedScheduledExecutorService this$0;

    public void run()
    {
        periodInNanos periodinnanos;
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).inc();
        periodinnanos = InstrumentedScheduledExecutorService.access$100(InstrumentedScheduledExecutorService.this).time();
        command.run();
        long l = periodinnanos.command();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        if (l > periodInNanos)
        {
            InstrumentedScheduledExecutorService.access$300(InstrumentedScheduledExecutorService.this).inc();
        }
        InstrumentedScheduledExecutorService.access$400(InstrumentedScheduledExecutorService.this).update((100L * l) / periodInNanos);
        return;
        Exception exception;
        exception;
        long l1 = periodinnanos.periodInNanos();
        InstrumentedScheduledExecutorService.access$000(InstrumentedScheduledExecutorService.this).dec();
        InstrumentedScheduledExecutorService.access$200(InstrumentedScheduledExecutorService.this).mark();
        if (l1 > periodInNanos)
        {
            InstrumentedScheduledExecutorService.access$300(InstrumentedScheduledExecutorService.this).inc();
        }
        InstrumentedScheduledExecutorService.access$400(InstrumentedScheduledExecutorService.this).update((100L * l1) / periodInNanos);
        throw exception;
    }

    (Runnable runnable, long l, TimeUnit timeunit)
    {
        this$0 = InstrumentedScheduledExecutorService.this;
        super();
        command = runnable;
        periodInNanos = timeunit.toNanos(l);
    }
}
