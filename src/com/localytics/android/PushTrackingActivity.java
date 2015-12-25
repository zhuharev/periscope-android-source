// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package com.localytics.android:
//            DatapointHelper, Localytics

public class PushTrackingActivity extends Activity
{

    public static final String LAUNCH_INTENT = "ll_launch_intent";

    public PushTrackingActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent = getIntent();
        bundle = DatapointHelper.getLocalyticsAppKeyOrNull(this);
        if (!TextUtils.isEmpty(bundle))
        {
            Localytics.integrate(getApplicationContext(), bundle);
        }
        Localytics.openSession();
        Localytics.handlePushNotificationOpened(intent);
        finish();
        bundle = (Intent)intent.getParcelableExtra("ll_launch_intent");
        if (bundle != null)
        {
            intent.removeExtra("ll_launch_intent");
        } else
        {
            bundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
            bundle.addFlags(0x24000000);
        }
        bundle.putExtras(intent);
        startActivity(bundle);
    }
}
