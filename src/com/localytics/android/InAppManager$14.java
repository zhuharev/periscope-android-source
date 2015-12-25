// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, LocalyticsDao, MarketingHandler, 
//            InAppMessagesAdapter

class nit> extends InAppCallable
{

    final InAppManager this$0;
    final InAppMessagesAdapter val$adapter;

    Object call(Object aobj[])
    {
        mLocalyticsDao.tagEvent("Test Mode Update Data");
        InAppManager.access$402(InAppManager.this, val$adapter);
        InAppManager.access$200(InAppManager.this).upload(mLocalyticsDao.getCustomerIdInMemory());
        return null;
    }

    pter()
    {
        this$0 = final_inappmanager;
        val$adapter = InAppMessagesAdapter.this;
        super();
    }
}
