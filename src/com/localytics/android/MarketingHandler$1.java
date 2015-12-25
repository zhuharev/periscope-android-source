// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, InAppManager

class val.campaignId
    implements Callable
{

    final MarketingHandler this$0;
    final int val$campaignId;

    public Boolean call()
    {
        return Boolean.valueOf(mInAppManager._setInAppMessageAsDisplayed(val$campaignId));
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = final_marketinghandler;
        val$campaignId = I.this;
        super();
    }
}
