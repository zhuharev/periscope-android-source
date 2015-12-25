// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.screen
    implements Runnable
{

    final AnalyticsHandler this$0;
    final String val$screen;

    public void run()
    {
        if (AnalyticsHandler.access$200(AnalyticsHandler.this))
        {
            com.localytics.android.this._mth0("Data collection is opted out");
            return;
        } else
        {
            AnalyticsHandler.access$600(AnalyticsHandler.this, val$screen);
            return;
        }
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$screen = String.this;
        super();
    }
}
