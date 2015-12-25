// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            Localytics

public class LocalyticsActivityLifecycleCallbacks
    implements android.app.Application.ActivityLifecycleCallbacks
{

    public LocalyticsActivityLifecycleCallbacks(Context context)
    {
        this(context, null);
    }

    public LocalyticsActivityLifecycleCallbacks(Context context, String s)
    {
        Localytics.integrate(context, s);
        Localytics.setIsAutoIntegrate(true);
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        if (activity instanceof _cls02C9)
        {
            Localytics.dismissCurrentInAppMessage();
            Localytics.clearInAppMessageDisplayActivity();
        }
        Localytics.closeSession();
        Localytics.upload();
    }

    public void onActivityResumed(Activity activity)
    {
        Localytics.openSession();
        Localytics.upload();
        if (activity instanceof _cls02C9)
        {
            Localytics.setInAppMessageDisplayActivity((_cls02C9)activity);
        }
        Localytics.handleTestMode(activity.getIntent());
        Localytics.handlePushNotificationOpened(activity.getIntent());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        Localytics.incrementActivityCounter();
    }

    public void onActivityStopped(Activity activity)
    {
        Localytics.decrementActivityCounter();
    }
}
