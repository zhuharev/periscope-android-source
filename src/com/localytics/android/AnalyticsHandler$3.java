// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class this._cls0
    implements Runnable
{

    final AnalyticsHandler this$0;

    public void run()
    {
        if (AnalyticsHandler.access$200(AnalyticsHandler.this))
        {
            com.localytics.android.this._mth0("Data collection is opted out");
            return;
        } else
        {
            AnalyticsHandler.access$300(AnalyticsHandler.this);
            return;
        }
    }

    ()
    {
        this$0 = AnalyticsHandler.this;
        super();
    }
}
