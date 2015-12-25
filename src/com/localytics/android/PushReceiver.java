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
//            DatapointHelper, Localytics, ReflectionUtils

public class PushReceiver extends BroadcastReceiver
{

    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY = 5000L;
    private static int numRetries = 0;
    static String retrySenderId = null;

    public PushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = DatapointHelper.getLocalyticsAppKeyOrNull(context);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            Localytics.integrate(context.getApplicationContext(), ((String) (obj)));
        }
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION"))
        {
            Localytics.handleRegistration(intent);
            return;
        }
        obj = intent.getExtras();
        int i;
        try
        {
            context = ((Context) (ReflectionUtils.tryInvokeStatic("com.google.android.gms.gcm.GoogleCloudMessaging", "getInstance", new Class[] {
                android/content/Context
            }, new Object[] {
                context
            })));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("Something went wrong with GCM", context);
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        context = (String)ReflectionUtils.tryInvokeInstance(context, "getMessageType", new Class[] {
            android/content/Intent
        }, new Object[] {
            intent
        });
        if (((Bundle) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!ReflectionUtils.tryGetStaticField("com.google.android.gms.gcm.GoogleCloudMessaging", "ERROR_SERVICE_NOT_AVAILABLE").equals(context))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (TextUtils.isEmpty(retrySenderId))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        i = numRetries + 1;
        numRetries = i;
        if (i > 3)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        Localytics.Log.w("GCM registration ERROR_SERVICE_NOT_AVAILABLE. Retrying in 5000 milliseconds.");
        Localytics.registerPush(retrySenderId, 5000L);
        break MISSING_BLOCK_LABEL_168;
        numRetries = 0;
        retrySenderId = null;
        return;
        if (ReflectionUtils.tryGetStaticField("com.google.android.gms.gcm.GoogleCloudMessaging", "MESSAGE_TYPE_MESSAGE").equals(context))
        {
            Localytics.handleNotificationReceived(intent);
        }
    }

    static 
    {
        numRetries = 0;
    }
}
