// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


public interface MessagingListener
    extends BaseHandler.BaseListener
{

    public abstract void localyticsDidDismissInAppMessage();

    public abstract void localyticsDidDisplayInAppMessage();

    public abstract void localyticsWillDismissInAppMessage();

    public abstract void localyticsWillDisplayInAppMessage();
}
