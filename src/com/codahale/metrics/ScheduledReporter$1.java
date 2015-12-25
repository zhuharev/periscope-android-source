// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import o.wt;

// Referenced classes of package com.codahale.metrics:
//            ScheduledReporter

class this._cls0
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
            ScheduledReporter.access$100()._mth02CB("RuntimeException thrown from {}#report. Exception was suppressed.", getClass().getSimpleName(), runtimeexception);
        }
    }

    ()
    {
        this$0 = ScheduledReporter.this;
        super();
    }
}
