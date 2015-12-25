// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.concurrent.Callable;

// Referenced classes of package com.codahale.metrics:
//            InstrumentedExecutorService, Counter, Timer, Meter

class callable
    implements Callable
{

    private final Callable callable;
    final InstrumentedExecutorService this$0;

    public Object call()
    {
        callable callable1;
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).inc();
        callable1 = InstrumentedExecutorService.access$100(InstrumentedExecutorService.this).time();
        Object obj = callable.call();
        callable1.callable();
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).dec();
        InstrumentedExecutorService.access$200(InstrumentedExecutorService.this).mark();
        return obj;
        Exception exception;
        exception;
        callable1._mth0();
        InstrumentedExecutorService.access$000(InstrumentedExecutorService.this).dec();
        InstrumentedExecutorService.access$200(InstrumentedExecutorService.this).mark();
        throw exception;
    }

    (Callable callable1)
    {
        this$0 = InstrumentedExecutorService.this;
        super();
        callable = callable1;
    }
}
