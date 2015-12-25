// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            MessagingListener, MarketingHandler

final class <init> extends <init>
    implements MessagingListener
{

    final MarketingHandler this$0;

    public final void localyticsDidDismissInAppMessage()
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsDidDismissInAppMessage", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void localyticsDidDisplayInAppMessage()
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsDidDisplayInAppMessage", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void localyticsWillDismissInAppMessage()
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsWillDismissInAppMessage", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void localyticsWillDisplayInAppMessage()
    {
        this;
        JVM INSTR monitorenter ;
        callListeners("localyticsWillDisplayInAppMessage", null, null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private ()
    {
        this$0 = MarketingHandler.this;
        super(MarketingHandler.this);
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
