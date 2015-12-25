// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Map;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, InAppManager

class val.attributes
    implements Runnable
{

    final MarketingHandler this$0;
    final Map val$attributes;
    final String val$event;

    public void run()
    {
        mInAppManager._inAppMessageTrigger(val$event, val$attributes);
    }

    ()
    {
        this$0 = final_marketinghandler;
        val$event = s;
        val$attributes = Map.this;
        super();
    }
}
