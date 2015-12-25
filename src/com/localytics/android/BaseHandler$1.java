// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.concurrent.FutureTask;

// Referenced classes of package com.localytics.android:
//            BaseHandler

class val.fTask
    implements Runnable
{

    final BaseHandler this$0;
    final FutureTask val$fTask;

    public void run()
    {
        val$fTask.run();
    }

    ()
    {
        this$0 = final_basehandler;
        val$fTask = FutureTask.this;
        super();
    }
}
