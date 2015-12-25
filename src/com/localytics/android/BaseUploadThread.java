// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, DatapointHelper, BaseHandler, Constants

abstract class BaseUploadThread extends Thread
{
    public static final class UploadType extends Enum
    {

        private static final UploadType $VALUES[];
        public static final UploadType ANALYTICS;
        public static final UploadType MARKETING;
        public static final UploadType PROFILES;

        public static UploadType valueOf(String s)
        {
            return (UploadType)Enum.valueOf(com/localytics/android/BaseUploadThread$UploadType, s);
        }

        public static UploadType[] values()
        {
            return (UploadType[])$VALUES.clone();
        }

        static 
        {
            ANALYTICS = new UploadType("ANALYTICS", 0);
            PROFILES = new UploadType("PROFILES", 1);
            MARKETING = new UploadType("MARKETING", 2);
            $VALUES = (new UploadType[] {
                ANALYTICS, PROFILES, MARKETING
            });
        }

        private UploadType(String s, int i)
        {
            super(s, i);
        }
    }


    String customerID;
    final TreeMap mData;
    LocalyticsDao mLocalyticsDao;
    private final BaseHandler mSessionHandler;
    private String uploadResponseString;

    BaseUploadThread(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        uploadResponseString = null;
        mSessionHandler = basehandler;
        mData = treemap;
        customerID = s;
        mLocalyticsDao = localyticsdao;
    }

    static URLConnection createURLConnection(URL url, Proxy proxy)
    {
        if (proxy == null)
        {
            return url.openConnection();
        } else
        {
            return url.openConnection(proxy);
        }
    }

    private static String formatUploadBody(String s)
    {
        String s1;
        try
        {
            s1 = (new JSONObject(s)).toString(3);
        }
        catch (Exception exception)
        {
            return s;
        }
        return s1;
    }

    private void retrieveHttpResponse(InputStream inputstream)
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        Object obj = new StringBuilder();
        do
        {
            String s = inputstream.readLine();
            if (s == null)
            {
                break;
            }
            ((StringBuilder) (obj)).append(s);
        } while (true);
        obj = ((StringBuilder) (obj)).toString();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            onUploadResponded(((String) (obj)));
        }
        inputstream.close();
    }

    String getApiKey()
    {
        String s1 = mLocalyticsDao.getApiKey();
        String s2 = DatapointHelper.getLocalyticsRollupKeyOrNull(mLocalyticsDao.getAppContext());
        String s = s1;
        if (s2 != null)
        {
            s = s1;
            if (!TextUtils.isEmpty(s2))
            {
                s = s2;
            }
        }
        return s;
    }

    void onUploadResponded(String s)
    {
        Localytics.Log.w(String.format("%s upload response: \n%s", new Object[] {
            mSessionHandler.siloName, s
        }));
        uploadResponseString = s;
    }

    public void run()
    {
        int i = uploadData();
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(i), uploadResponseString
        }))));
        return;
        Object obj;
        obj;
        Localytics.Log.e("Exception", ((Throwable) (obj)));
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(0), uploadResponseString
        }))));
        return;
        obj;
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(0), uploadResponseString
        }))));
        throw obj;
    }

    boolean upload(UploadType uploadtype, String s, String s1, int i)
    {
        return upload(uploadtype, s, s1, i, false);
    }

    boolean upload(UploadType uploadtype, String s, String s1, int i, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        HttpURLConnection httpurlconnection1;
        Object obj5;
        Object obj7;
        if (s == null)
        {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("body cannot be null");
        }
        if (uploadtype == UploadType.ANALYTICS)
        {
            Localytics.Log.v(String.format("Analytics upload body before compression is: \n%s", new Object[] {
                s1
            }));
        } else
        if (uploadtype == UploadType.PROFILES)
        {
            Localytics.Log.v(String.format("Profile upload body is: \n%s", new Object[] {
                formatUploadBody(s1)
            }));
        }
        httpurlconnection1 = null;
        obj5 = null;
        obj7 = null;
        obj = null;
        obj2 = httpurlconnection1;
        obj3 = obj5;
        obj1 = obj7;
        byte abyte0[] = s1.getBytes("UTF-8");
        byte abyte1[];
        abyte1 = abyte0;
        obj2 = httpurlconnection1;
        obj3 = obj5;
        obj1 = obj7;
        if (uploadtype != UploadType.ANALYTICS)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj2 = httpurlconnection1;
        obj3 = obj5;
        obj1 = obj7;
        Object obj8 = new ByteArrayOutputStream(abyte0.length);
        obj2 = httpurlconnection1;
        obj3 = obj5;
        obj1 = obj7;
        abyte1 = new GZIPOutputStream(((OutputStream) (obj8)));
        obj = abyte1;
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        abyte1.write(abyte0);
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        ((GZIPOutputStream) (obj)).finish();
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        if (DatapointHelper.getApiLevel() >= 19)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        ((GZIPOutputStream) (obj)).flush();
        obj2 = obj;
        obj3 = obj;
        obj1 = obj;
        abyte1 = ((ByteArrayOutputStream) (obj8)).toByteArray();
        if (obj != null)
        {
            try
            {
                ((GZIPOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        break MISSING_BLOCK_LABEL_403;
        uploadtype;
        obj1 = obj2;
        Localytics.Log.w("UnsupportedEncodingException", uploadtype);
        if (obj2 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        return false;
        uploadtype;
        obj1 = obj3;
        Localytics.Log.w("IOException", uploadtype);
        if (obj3 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        return false;
        uploadtype;
        if (obj1 != null)
        {
            try
            {
                ((GZIPOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (UploadType uploadtype)
            {
                Localytics.Log.w("Caught exception", uploadtype);
                return false;
            }
        }
        throw uploadtype;
        HttpURLConnection httpurlconnection;
        httpurlconnection1 = null;
        obj5 = null;
        obj7 = null;
        obj1 = null;
        obj2 = obj1;
        obj3 = httpurlconnection1;
        httpurlconnection = obj5;
        obj = obj7;
        obj8 = mLocalyticsDao.getProxy();
        obj2 = obj1;
        obj3 = httpurlconnection1;
        httpurlconnection = obj5;
        obj = obj7;
        httpurlconnection1 = (HttpURLConnection)createURLConnection(new URL(s), ((Proxy) (obj8)));
        obj1 = httpurlconnection1;
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        httpurlconnection1.setConnectTimeout(60000);
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setReadTimeout(60000);
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        EOFException eofexception;
        Exception exception;
        Object obj4;
        Object obj6;
        int j;
        boolean flag1;
        if (uploadtype != UploadType.MARKETING)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setDoOutput(flag1);
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        if (uploadtype != UploadType.ANALYTICS)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/x-gzip");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Encoding", "gzip");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("X-DONT-SEND-AMP", "1");
        break MISSING_BLOCK_LABEL_712;
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Type", "application/json; charset=utf-8");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        if (uploadtype != UploadType.MARKETING)
        {
            break MISSING_BLOCK_LABEL_784;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        if (!Constants.isTestModeEnabled())
        {
            break MISSING_BLOCK_LABEL_784;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("AMP-Test-Mode", "1");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_816;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("X-NO-DELAY", "1");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("Accept-Encoding", "");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-upload-time", Long.toString(Math.round((double)System.currentTimeMillis() / 1000D)));
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-install-id", mLocalyticsDao.getInstallationId());
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-app-id", mLocalyticsDao.getApiKey());
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-client-version", "androida_3.5.0");
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-app-version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setRequestProperty("x-customer-id", customerID);
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        if (uploadtype == UploadType.MARKETING)
        {
            break MISSING_BLOCK_LABEL_1228;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setFixedLengthStreamingMode(abyte1.length);
        obj4 = null;
        obj = ((HttpURLConnection) (obj1)).getOutputStream();
        obj6 = obj;
        obj4 = obj6;
        ((OutputStream) (obj)).write(abyte1);
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_1228;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((OutputStream) (obj6)).flush();
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((OutputStream) (obj6)).close();
        break MISSING_BLOCK_LABEL_1228;
        exception;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_1209;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((OutputStream) (obj4)).flush();
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        ((OutputStream) (obj4)).close();
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        throw exception;
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        j = ((HttpURLConnection) (obj1)).getResponseCode();
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        Localytics.Log.v(String.format("%s upload complete with status %d", new Object[] {
            mSessionHandler.siloName, Integer.valueOf(j)
        }));
        if (j == 429)
        {
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
            return false;
        }
        if (j >= 400 && j <= 499)
        {
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
            return true;
        }
        if (j >= 500 && j <= 599)
        {
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
            return false;
        }
        obj2 = obj1;
        obj3 = obj1;
        httpurlconnection = ((HttpURLConnection) (obj1));
        obj = obj1;
        retrieveHttpResponse(((HttpURLConnection) (obj1)).getInputStream());
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        break MISSING_BLOCK_LABEL_1541;
        eofexception;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_1446;
        }
        obj = obj2;
        Localytics.Log.w("ClientProtocolException", eofexception);
        if (obj2 != null)
        {
            ((HttpURLConnection) (obj2)).disconnect();
        }
        return false;
        obj = obj2;
        flag = upload(uploadtype, s, s1, i + 1, flag);
        if (obj2 != null)
        {
            ((HttpURLConnection) (obj2)).disconnect();
        }
        return flag;
        uploadtype;
        obj = obj3;
        Localytics.Log.w("ClientProtocolException", uploadtype);
        if (obj3 != null)
        {
            ((HttpURLConnection) (obj3)).disconnect();
        }
        return false;
        uploadtype;
        obj = httpurlconnection;
        Localytics.Log.w("ClientProtocolException", uploadtype);
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return false;
        uploadtype;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw uploadtype;
        return true;
    }

    abstract int uploadData();
}
