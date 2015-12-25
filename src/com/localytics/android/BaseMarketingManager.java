// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            LocalyticsDao, BaseProvider

public abstract class BaseMarketingManager
{

    protected LocalyticsDao mLocalyticsDao;
    protected BaseProvider mProvider;

    public BaseMarketingManager(LocalyticsDao localyticsdao)
    {
        mLocalyticsDao = localyticsdao;
    }

    public void setProvider(BaseProvider baseprovider)
    {
        mProvider = baseprovider;
    }
}
