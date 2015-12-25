// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, MarketingHandler, MessagingListener

class init> extends InAppCallable
{

    final InAppManager this$0;

    public Object call(Object aobj[])
    {
        ((MessagingListener)InAppManager.access$200(InAppManager.this).listeners).localyticsDidDisplayInAppMessage();
        return null;
    }

    er()
    {
        this$0 = InAppManager.this;
        super();
    }
}
