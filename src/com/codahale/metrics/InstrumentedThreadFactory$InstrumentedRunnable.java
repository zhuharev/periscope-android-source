// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            InstrumentedThreadFactory, Counter, Meter

class task
    implements Runnable
{

    private final Runnable task;
    final InstrumentedThreadFactory this$0;

    public void run()
    {
        InstrumentedThreadFactory.access$000(InstrumentedThreadFactory.this).inc();
        task.run();
        InstrumentedThreadFactory.access$000(InstrumentedThreadFactory.this).dec();
        InstrumentedThreadFactory.access$100(InstrumentedThreadFactory.this).mark();
        return;
        Exception exception;
        exception;
        InstrumentedThreadFactory.access$000(InstrumentedThreadFactory.this).dec();
        InstrumentedThreadFactory.access$100(InstrumentedThreadFactory.this).mark();
        throw exception;
    }

    I(Runnable runnable)
    {
        this$0 = InstrumentedThreadFactory.this;
        super();
        task = runnable;
    }
}
