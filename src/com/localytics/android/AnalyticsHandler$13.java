// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Intent;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.intent
    implements Runnable
{

    final AnalyticsHandler this$0;
    final Intent val$intent;

    public void run()
    {
        AnalyticsHandler.access$1300(AnalyticsHandler.this, val$intent);
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$intent = Intent.this;
        super();
    }
}
