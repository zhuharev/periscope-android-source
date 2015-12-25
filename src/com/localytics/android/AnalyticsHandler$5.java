// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Map;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.clv
    implements Runnable
{

    final AnalyticsHandler this$0;
    final Map val$attributes;
    final Long val$clv;
    final String val$event;

    public void run()
    {
        if (AnalyticsHandler.access$200(AnalyticsHandler.this))
        {
            com.localytics.android.this._mth0("Data collection is opted out");
            return;
        } else
        {
            AnalyticsHandler.access$500(AnalyticsHandler.this, val$event, val$attributes, val$clv);
            return;
        }
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$event = s;
        val$attributes = map;
        val$clv = Long.this;
        super();
    }
}
