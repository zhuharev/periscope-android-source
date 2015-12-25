// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.localytics.android:
//            PushManager, LocalyticsDao, BaseUploadThread, DatapointHelper, 
//            Localytics

class val.pushRegID extends AsyncTask
{

    final l.appContext this$1;
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
        if (TextUtils.isEmpty(val$pushRegID))
        {
            break MISSING_BLOCK_LABEL_381;
        }
        s = mLocalyticsDao.getInstallationId();
        s1 = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s", new Object[] {
            campaign, creative, val$pushRegID, s, Long.toString(Math.round((double)mLocalyticsDao.getCurrentTimeMillis() / 1000D))
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
        ("Activating push test has failed", exception1);
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
        if (!TextUtils.isEmpty(val$pushRegID))
        {
            Toast.makeText(appContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
            return;
        } else
        {
            Toast.makeText(appContext, "App isn't registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called.", 1).show();
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$pushRegID = String.this;
        super();
    }
}
