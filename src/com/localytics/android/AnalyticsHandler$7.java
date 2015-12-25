// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsHandler

class val.value
    implements Runnable
{

    final AnalyticsHandler this$0;
    final int val$dimension;
    final String val$value;

    public void run()
    {
        AnalyticsHandler.access$700(AnalyticsHandler.this, val$dimension, val$value);
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$dimension = i;
        val$value = String.this;
        super();
    }
}
