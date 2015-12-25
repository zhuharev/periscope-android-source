// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package com.localytics.android:
//            DatapointHelper, Localytics, LocalyticsManager

public class ReferralReceiver extends BroadcastReceiver
{

    public ReferralReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        try
        {
            obj = intent.getExtras();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        ((Bundle) (obj)).containsKey(null);
        if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
            obj = DatapointHelper.getLocalyticsAppKeyOrNull(context);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                Localytics.integrate(context.getApplicationContext(), ((String) (obj)));
            }
            context = intent.getStringExtra("referrer");
            if (!TextUtils.isEmpty(context))
            {
                LocalyticsManager.getInstance().setReferrerId(context);
            }
        }
        return;
    }
}
