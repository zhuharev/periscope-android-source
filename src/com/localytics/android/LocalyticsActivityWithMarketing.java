// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Intent;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            Localytics

public class LocalyticsActivityWithMarketing extends _cls02C9
{

    public LocalyticsActivityWithMarketing()
    {
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onPause()
    {
        Localytics.dismissCurrentInAppMessage();
        Localytics.clearInAppMessageDisplayActivity();
        Localytics.closeSession();
        Localytics.upload();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Localytics.openSession();
        Localytics.setInAppMessageDisplayActivity(this);
        Localytics.handlePushNotificationOpened(getIntent());
        Localytics.handleTestMode(getIntent());
        Localytics.upload();
    }
}
