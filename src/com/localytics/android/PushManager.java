// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseMarketingManager, LocalyticsDao, PushNotificationOptions, DatapointHelper, 
//            PushTrackingActivity

class PushManager extends BaseMarketingManager
{

    private static final String ACTION_ATTRIBUTE = "Action";
    private static final String APP_CONTEXT_ATTRIBUTE = "App Context";
    private static final String CAMPAIGN_ID_ATTRIBUTE = "Campaign ID";
    private static final String CREATIVE_DISPLAYED_ATTRIBUTE = "Creative Displayed";
    private static final String CREATIVE_ID_ATTRIBUTE = "Creative ID";
    private static final String CREATIVE_TYPE_ATTRIBUTE = "Creative Type";
    private static final String PUSH_API_URL_TEMPLATE = "http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s";
    private static final String PUSH_NOTIFICATIONS_ENABLED_ATTRIBUTE = "Push Notifications Enabled";
    private static final String PUSH_OPENED_EVENT = "Localytics Push Opened";
    private static final String PUSH_RECEIVED_EVENT = "Localytics Push Received";
    private PushNotificationOptions mPushNotificationOptions;

    PushManager(LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
        mPushNotificationOptions = (new PushNotificationOptions.Builder()).build();
    }

    void _showPushNotification(Intent intent)
    {
        Object obj;
        String s;
        Context context;
        int i;
        int l;
        s = intent.getExtras().getString("message");
        try
        {
            l = (new JSONObject(intent.getExtras().getString("ll"))).getInt("ca");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Localytics.Log.w("Failed to get campaign id from payload, ignoring message");
            return;
        }
        context = mLocalyticsDao.getAppContext();
        obj = "";
        int j = mPushNotificationOptions.getSmallIcon();
        i = j;
        if (!DatapointHelper.isValidResourceId(context, j))
        {
            i = DatapointHelper.getLocalyticsNotificationIcon(context);
        }
        Object obj1;
        obj1 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        obj1 = context.getPackageManager().getApplicationLabel(((android.content.pm.ApplicationInfo) (obj1)));
        obj = obj1;
          goto _L1
_L3:
        Localytics.Log.w("Failed to get application name, icon, or launch intent");
_L1:
        Object obj2 = new Intent(context, com/localytics/android/PushTrackingActivity);
        ((Intent) (obj2)).putExtras(intent);
        Object obj3 = mPushNotificationOptions.getLaunchIntent();
        if (obj3 != null)
        {
            ((Intent) (obj2)).putExtra("ll_launch_intent", ((android.os.Parcelable) (obj3)));
        }
        obj3 = PendingIntent.getActivity(context, l, ((Intent) (obj2)), 0x8000000);
        obj2 = mPushNotificationOptions.getTitle();
        if (obj2 != null)
        {
            obj = obj2;
        }
        obj = (new o._cls06E5._cls02CE(context))._mth141D(i)._mth02CB(((CharSequence) (obj)))._mth02CA(((PendingIntent) (obj3)))._mth02CE(true)._mth02CB(mPushNotificationOptions.getLargeIcon())._mth02CB(mPushNotificationOptions.getOnlyAlertOnce())._mth02BC(mPushNotificationOptions.getPriority())._mth02BD(mPushNotificationOptions.getAccentColor())._mth02BC(mPushNotificationOptions.getCategory())._mth037A(mPushNotificationOptions.getVisibility());
        i = 0;
        int k = mPushNotificationOptions.getLedLightColor();
        if (k != -1)
        {
            ((o._cls06E5._cls02CE) (obj))._mth02CA(k, mPushNotificationOptions.getLedLightOnMillis(), mPushNotificationOptions.getLedLightOffMillis());
        } else
        {
            i = 4;
        }
        obj2 = mPushNotificationOptions.getSoundUri();
        if (obj2 != null)
        {
            ((o._cls06E5._cls02CE) (obj))._mth02CA(((android.net.Uri) (obj2)));
        } else
        {
            i |= 1;
        }
        long al[] = mPushNotificationOptions.getVibrationPattern();
        if (al != null)
        {
            ((o._cls06E5._cls02CE) (obj))._mth02CA(al);
        } else
        {
            i |= 2;
        }
        obj = ((o._cls06E5._cls02CE) (obj))._mth02BB(i);
        intent = intent.getExtras().getString("ll_public_message");
        if (intent != null)
        {
            ((o._cls06E5._cls02CE) (obj))._mth02CA(((o._cls06E5._cls02CE) (obj))._mth02CE(intent)._mth02CA((new o._cls06E5._cls02CB())._mth02CA(intent)).build());
        }
        ((o._cls06E5._cls02CE) (obj))._mth02CE(s)._mth02CA((new o._cls06E5._cls02CB())._mth02CA(s));
        ((NotificationManager)context.getSystemService("notification")).notify(l, ((o._cls06E5._cls02CE) (obj)).build());
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    boolean _tagPushReceivedEvent(Intent intent)
    {
        JSONObject jsonobject;
        boolean flag;
        boolean flag1;
        int i;
        boolean flag2;
        String s = intent.getStringExtra("ll");
        if (TextUtils.isEmpty(s))
        {
            Localytics.Log.w("Ignoring message that isn't from Localytics.");
            return false;
        }
        try
        {
            jsonobject = new JSONObject(s);
            i = jsonobject.getInt("ca");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Localytics.Log.w("Failed to get campaign id from payload, ignoring message");
            return false;
        }
        intent = intent.getExtras().getString("message");
        flag2 = mLocalyticsDao.isPushDisabled();
        if (!TextUtils.isEmpty(intent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag2 && flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        String s1;
        String s3;
        String s4;
        s4 = jsonobject.getString("cr");
        s3 = jsonobject.optString("v", "1");
        s1 = jsonobject.optString("t", null);
        intent = s1;
        HashMap hashmap;
        if (TextUtils.isEmpty(s1))
        {
            if (flag)
            {
                intent = "Alert";
            } else
            {
                intent = "Silent";
            }
        }
        s1 = "Not Available";
        break MISSING_BLOCK_LABEL_167;
_L2:
        hashmap = new HashMap();
        hashmap.put("Campaign ID", String.valueOf(i));
        hashmap.put("Creative ID", s4);
        hashmap.put("Creative Type", intent);
        hashmap.put("Creative Displayed", s2);
        if (flag2)
        {
            intent = "No";
        } else
        {
            intent = "Yes";
        }
        try
        {
            hashmap.put("Push Notifications Enabled", intent);
            hashmap.put("App Context", s1);
            hashmap.put("Schema Version - Client", "3");
            hashmap.put("Schema Version - Server", s3);
            if (jsonobject.optInt("x", 0) == 0)
            {
                mLocalyticsDao.tagEvent("Localytics Push Received", hashmap);
                mLocalyticsDao.upload();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Localytics.Log.w("Failed to get campaign id or creative id from payload");
        }
        if (!flag1)
        {
            if (flag2)
            {
                Localytics.Log.w("Got push notification while push is disabled.");
            }
            if (!flag)
            {
                Localytics.Log.w("Got push notification without a message.");
            }
            return false;
        } else
        {
            return true;
        }
        String s2;
        if (mLocalyticsDao.isAutoIntegrate())
        {
            if (mLocalyticsDao.isAppInForeground())
            {
                s1 = "Foreground";
            } else
            {
                s1 = "Background";
            }
        }
        if (flag)
        {
            if (flag2)
            {
                s2 = "No";
            } else
            {
                s2 = "Yes";
            }
        } else
        {
            s2 = "Not Applicable";
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    void handlePushNotificationOpened(Intent intent)
    {
        Object obj;
        if (intent == null || intent.getExtras() == null)
        {
            return;
        }
        obj = intent.getExtras().getString("ll");
        if (obj == null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        String s2;
        String s3;
        obj = new JSONObject(((String) (obj)));
        s1 = ((JSONObject) (obj)).getString("ca");
        s2 = ((JSONObject) (obj)).getString("cr");
        s3 = ((JSONObject) (obj)).optString("v", "1");
        s = ((JSONObject) (obj)).optString("t", null);
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = "Alert";
        }
        if (s1 == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("Campaign ID", s1);
        hashmap.put("Creative ID", s2);
        hashmap.put("Creative Type", obj);
        hashmap.put("Action", "Click");
        hashmap.put("Schema Version - Client", "3");
        hashmap.put("Schema Version - Server", s3);
        mLocalyticsDao.tagEvent("Localytics Push Opened", hashmap);
        intent.removeExtra("ll");
        return;
_L4:
        Localytics.Log.w("Failed to get campaign id or creative id from payload");
_L2:
        return;
        intent;
        if (true) goto _L4; else goto _L3
_L3:
    }

    void handlePushTestMode(final String creative[])
    {
        final String campaign = creative[2];
        creative = creative[3];
        final String customerID = mLocalyticsDao.getCustomerIdInMemory();
        final Context appContext = mLocalyticsDao.getAppContext();
        if (!TextUtils.isEmpty(campaign) && !TextUtils.isEmpty(creative))
        {
            (new _cls1()).execute(new Void[0]);
        }
    }

    void setPushNotificationOptions(PushNotificationOptions pushnotificationoptions)
    {
        if (pushnotificationoptions != null)
        {
            mPushNotificationOptions = pushnotificationoptions;
        }
    }

    private class _cls1 extends AsyncTask
    {

        final PushManager this$0;
        final Context val$appContext;
        final String val$campaign;
        final String val$creative;
        final String val$customerID;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return mLocalyticsDao.getPushRegistrationId();
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(final String pushRegID)
        {
            class _cls1 extends AsyncTask
            {

                final _cls1 this$1;
                final String val$pushRegID;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    HttpURLConnection httpurlconnection;
                    Object obj;
                    Object obj1;
                    String s;
                    String s1;
                    if (TextUtils.isEmpty(pushRegID))
                    {
                        break MISSING_BLOCK_LABEL_381;
                    }
                    s = mLocalyticsDao.getInstallationId();
                    s1 = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s", new Object[] {
                        campaign, creative, pushRegID, s, Long.toString(Math.round((double)mLocalyticsDao.getCurrentTimeMillis() / 1000D))
                    });
                    obj1 = null;
                    obj = null;
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj1));
                    java.net.Proxy proxy = mLocalyticsDao.getProxy();
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj1));
                    obj1 = (HttpURLConnection)BaseUploadThread.createURLConnection(new URL(s1), proxy);
                    obj = obj1;
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj1)).setConnectTimeout(5000);
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setReadTimeout(5000);
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setDoOutput(false);
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-install-id", s);
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-app-id", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-client-version", "androida_3.5.0");
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-app-version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-customer-id", customerID);
                    httpurlconnection = ((HttpURLConnection) (obj));
                    avoid = ((Void []) (obj));
                    ((HttpURLConnection) (obj)).getInputStream();
                    if (obj != null)
                    {
                        ((HttpURLConnection) (obj)).disconnect();
                    }
                    break MISSING_BLOCK_LABEL_381;
                    Exception exception1;
                    exception1;
                    avoid = httpurlconnection;
                    obj1 = new StringBuilder("Unfortunately, something went wrong. Push test activation was unsuccessful.");
                    avoid = httpurlconnection;
                    if (!Localytics.isLoggingEnabled())
                    {
                        break MISSING_BLOCK_LABEL_352;
                    }
                    avoid = httpurlconnection;
                    if (!(exception1 instanceof FileNotFoundException))
                    {
                        break MISSING_BLOCK_LABEL_352;
                    }
                    avoid = httpurlconnection;
                    ((StringBuilder) (obj1)).append("\n\nCause:\nPush registration token has not yet been processed. Please wait a few minutes and try again.");
                    avoid = httpurlconnection;
                    Localytics.Log.e("Activating push test has failed", exception1);
                    avoid = httpurlconnection;
                    exception1 = ((StringBuilder) (obj1)).toString();
                    if (httpurlconnection != null)
                    {
                        httpurlconnection.disconnect();
                    }
                    return exception1;
                    Exception exception;
                    exception;
                    if (avoid != null)
                    {
                        avoid.disconnect();
                    }
                    throw exception;
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    if (s != null)
                    {
                        Toast.makeText(appContext, s, 1).show();
                    }
                }

                protected void onPreExecute()
                {
                    if (!TextUtils.isEmpty(pushRegID))
                    {
                        Toast.makeText(appContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
                        return;
                    } else
                    {
                        Toast.makeText(appContext, "App isn't registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called.", 1).show();
                        return;
                    }
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    pushRegID = s;
                    super();
                }
            }

            (new _cls1()).execute(new Void[0]);
        }

        _cls1()
        {
            this$0 = PushManager.this;
            appContext = context;
            campaign = s;
            creative = s1;
            customerID = s2;
            super();
        }
    }

}
