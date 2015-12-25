// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.isOptingOut
    implements Runnable
{

    final AnalyticsHandler this$0;
    final boolean val$isOptingOut;

    public void run()
    {
        AnalyticsHandler.access$1100(AnalyticsHandler.this, val$isOptingOut);
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$isOptingOut = Z.this;
        super();
    }
}
