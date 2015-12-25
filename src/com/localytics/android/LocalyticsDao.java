// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import java.net.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

interface LocalyticsDao
{

    public abstract String getApiKey();

    public abstract Context getAppContext();

    public abstract Calendar getCalendar();

    public abstract long getCurrentTimeMillis();

    public abstract String getCustomDimension(int i);

    public abstract String getCustomerIdInMemory();

    public abstract String getCustomerIdInMemory(boolean flag);

    public abstract CountDownLatch getCustomerIdInitiatedLatch();

    public abstract Map getIdentifiers();

    public abstract String getInstallationId();

    public abstract Proxy getProxy();

    public abstract String getPushRegistrationId();

    public abstract String getTimeStringForSQLite();

    public abstract boolean isAppInForeground();

    public abstract boolean isAutoIntegrate();

    public abstract boolean isPushDisabled();

    public abstract void setCustomDimension(int i, String s);

    public abstract void setCustomerIdInMemory(String s);

    public abstract void setInstallationId(String s);

    public abstract void setScreenFlow(List list);

    public abstract void setTestModeEnabled(boolean flag);

    public abstract void tagEvent(String s);

    public abstract void tagEvent(String s, Map map);

    public abstract void tagEvent(String s, Map map, long l);

    public abstract void triggerInAppMessage(String s);

    public abstract void triggerInAppMessage(String s, Map map);

    public abstract void triggerInAppMessage(String s, Map map, boolean flag);

    public abstract void upload();
}
