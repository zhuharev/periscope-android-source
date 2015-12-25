// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.localytics.android:
//            Localytics

public class LocalyticsActivity extends Activity
{

    public LocalyticsActivity()
    {
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onPause()
    {
        Localytics.closeSession();
        Localytics.upload();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Localytics.openSession();
        Localytics.handlePushNotificationOpened(getIntent());
        Localytics.upload();
    }
}
