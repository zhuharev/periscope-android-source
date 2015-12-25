// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.newSenderId
    implements Runnable
{

    final AnalyticsHandler this$0;
    final String val$newSenderId;

    public void run()
    {
        AnalyticsHandler.access$1200(AnalyticsHandler.this, val$newSenderId);
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$newSenderId = String.this;
        super();
    }
}
