// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.pushRegId
    implements Runnable
{

    final AnalyticsHandler this$0;
    final String val$pushRegId;

    public void run()
    {
        if (AnalyticsHandler.access$000(AnalyticsHandler.this))
        {
            com.localytics.android.this._mth0("Registering for GCM but push disabled");
            return;
        } else
        {
            AnalyticsHandler.access$900(AnalyticsHandler.this, val$pushRegId);
            return;
        }
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$pushRegId = String.this;
        super();
    }
}
