// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            LocalyticsManager, AnalyticsHandler, MarketingHandler, ProfileHandler

final class <init>
{

    AnalyticsHandler analyticsHandler;
    MarketingHandler marketingHandler;
    ProfileHandler profileHandler;
    final LocalyticsManager this$0;

    private (AnalyticsHandler analyticshandler, MarketingHandler marketinghandler, ProfileHandler profilehandler)
    {
        this$0 = LocalyticsManager.this;
        super();
        analyticsHandler = analyticshandler;
        marketingHandler = marketinghandler;
        profileHandler = profilehandler;
    }

    profileHandler(AnalyticsHandler analyticshandler, MarketingHandler marketinghandler, ProfileHandler profilehandler, profileHandler profilehandler1)
    {
        this(analyticshandler, marketinghandler, profilehandler);
    }
}
