// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.concurrent.FutureTask;

// Referenced classes of package com.localytics.android:
//            InAppMessagesAdapter

class val.fTask extends Thread
{

    final InAppMessagesAdapter this$0;
    final FutureTask val$fTask;

    public void run()
    {
        try
        {
            val$fTask.run();
            return;
        }
        catch (Exception exception)
        {
            val.fTask("Caught an exception", exception);
        }
    }

    ()
    {
        this$0 = final_inappmessagesadapter;
        val$fTask = FutureTask.this;
        super();
    }
}
