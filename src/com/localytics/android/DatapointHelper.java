// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.localytics.android:
//            ReflectionUtils, Constants

final class DatapointHelper
{
    static class AdvertisingInfo
    {

        public String id;
        public boolean limitAdTracking;

        public AdvertisingInfo(String s, boolean flag)
        {
            id = s;
            limitAdTracking = flag;
        }
    }


    private static final Object HARDWARE_TELEPHONY[] = {
        "android.hardware.telephony"
    };
    private static final String INVALID_ANDROID_ID = "9774d56d682e549c";
    private static final String LEGACY_DEVICE_ID_FILE = "/localytics/device_id";
    private static final Class STRING_CLASS_ARRAY[] = {
        java/lang/String
    };

    private DatapointHelper()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    static AdvertisingInfo getAdvertisingInfo(Context context)
    {
        Object obj = ReflectionUtils.tryInvokeStatic("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }, new Object[] {
            context
        });
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        context = (String)ReflectionUtils.tryInvokeInstance(obj, "getId", null, null);
        flag = ((Boolean)ReflectionUtils.tryInvokeInstance(obj, "isLimitAdTrackingEnabled", null, null)).booleanValue();
        if (TextUtils.isEmpty(context))
        {
            context = null;
        }
        context = new AdvertisingInfo(context, flag);
        return context;
_L4:
        Localytics.Log.w("Device doesn't have Google Play Services installed");
_L2:
        return null;
        context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String getAndroidIdHashOrNull(Context context)
    {
        context = getAndroidIdOrNull(context);
        if (context == null)
        {
            return null;
        } else
        {
            return getSha256_buggy(context);
        }
    }

    static String getAndroidIdOrNull(Context context)
    {
        BufferedReader bufferedreader;
        BufferedReader bufferedreader1;
        BufferedReader bufferedreader2;
        Object obj;
        File file;
        file = new File((new StringBuilder()).append(context.getFilesDir()).append("/localytics/device_id").toString());
        if (!file.exists() || file.length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = null;
        bufferedreader2 = null;
        bufferedreader1 = bufferedreader2;
        bufferedreader = ((BufferedReader) (obj));
        char ac[] = new char[100];
        bufferedreader1 = bufferedreader2;
        bufferedreader = ((BufferedReader) (obj));
        obj = new BufferedReader(new FileReader(file), 128);
        bufferedreader2 = ((BufferedReader) (obj));
        bufferedreader1 = bufferedreader2;
        bufferedreader = bufferedreader2;
        obj = String.copyValueOf(ac, 0, ((BufferedReader) (obj)).read(ac));
        bufferedreader1 = bufferedreader2;
        bufferedreader = bufferedreader2;
        bufferedreader2.close();
        bufferedreader2.close();
        return ((String) (obj));
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        bufferedreader = bufferedreader1;
        Localytics.Log.w("Caught exception", filenotfoundexception);
        Exception exception;
        if (bufferedreader1 != null)
        {
            try
            {
                bufferedreader1.close();
            }
            catch (IOException ioexception)
            {
                Localytics.Log.w("Caught exception", ioexception);
            }
        }
        break MISSING_BLOCK_LABEL_171;
        exception;
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        bufferedreader.close();
        throw exception;
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (context == null || context.toLowerCase().equals("9774d56d682e549c"))
        {
            return null;
        } else
        {
            return context;
        }
    }

    static int getApiLevel()
    {
        int i;
        try
        {
            i = Integer.parseInt((String)android/os/Build$VERSION.getField("SDK").get(null));
        }
        catch (Exception exception)
        {
            Localytics.Log.w("Caught exception", exception);
            int j;
            try
            {
                j = android/os/Build$VERSION.getField("SDK_INT").getInt(null);
            }
            catch (Exception exception1)
            {
                Localytics.Log.w("Caught exception", exception1);
                return 3;
            }
            return j;
        }
        return i;
    }

    static String getAppVersion(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        Localytics.Log.w("versionName was null--is a versionName attribute set in the Android Manifest?");
        return "unknown";
        return context;
    }

    static String getFBAttribution(Context context)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj4 = null;
        obj1 = context.getContentResolver();
        obj2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        obj = null;
        context = null;
        obj2 = ((ContentResolver) (obj1)).query(((Uri) (obj2)), new String[] {
            "aid"
        }, null, null, null);
        obj1 = obj4;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj1 = obj4;
        context = ((Context) (obj2));
        obj = obj2;
        if (!((Cursor) (obj2)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        context = ((Context) (obj2));
        obj = obj2;
        obj1 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("aid"));
        obj = obj1;
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
            return ((String) (obj1));
        }
        break MISSING_BLOCK_LABEL_134;
        Exception exception;
        exception;
        obj = context;
        Localytics.Log.w("Error reading FB attribution", exception);
        obj = obj3;
        if (context != null)
        {
            context.close();
            return null;
        }
        break MISSING_BLOCK_LABEL_134;
        context;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        return ((String) (obj));
    }

    static String getLocalyticsAppKeyOrNull(Context context)
    {
label0:
        {
            if (context == null)
            {
                Localytics.Log.w("Context passed to getLocalyticsAppKeyOrNull() is NULL. Please pass a valid context.");
                return null;
            }
            try
            {
                context = context.getApplicationContext();
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (((ApplicationInfo) (context)).metaData == null)
                {
                    break label0;
                }
                context = ((Context) (((ApplicationInfo) (context)).metaData.get("LOCALYTICS_APP_KEY")));
                if (!(context instanceof String))
                {
                    break label0;
                }
                context = (String)context;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException(context);
            }
            return context;
        }
        return null;
    }

    static int getLocalyticsNotificationIcon(Context context)
    {
        Object obj;
        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (((ApplicationInfo) (obj)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        obj = (String)((ApplicationInfo) (obj)).metaData.get("LOCALYTICS_NOTIFICATION_ICON");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        int i;
        boolean flag;
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf('/') + 1, ((String) (obj)).lastIndexOf('.'));
        i = context.getResources().getIdentifier(((String) (obj)), "drawable", context.getPackageName());
        flag = isValidResourceId(context, i);
        if (flag)
        {
            return i;
        }
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        if (applicationinfo.icon == 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        i = applicationinfo.icon;
        flag = isValidResourceId(context, i);
        if (flag)
        {
            return i;
        }
_L2:
        return 0x1080093;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String getLocalyticsRollupKeyOrNull(Context context)
    {
        Object obj = null;
        Object obj1;
        try
        {
            obj1 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        context = obj;
        if (((ApplicationInfo) (obj1)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj1 = ((ApplicationInfo) (obj1)).metaData.get("LOCALYTICS_ROLLUP_KEY");
        context = obj;
        if (obj1 instanceof String)
        {
            context = (String)obj1;
        }
        return context;
    }

    static String getManufacturer()
    {
        if (Constants.CURRENT_API_LEVEL <= 3)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        String s = (String)android/os/Build.getField("MANUFACTURER").get(null);
        return s;
        Exception exception;
        exception;
        Localytics.Log.w("Caught exception", exception);
        return "unknown";
    }

    static String getNetworkType(TelephonyManager telephonymanager, Context context)
    {
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        boolean flag = context.isConnectedOrConnecting();
        if (flag)
        {
            return "wifi";
        }
        break MISSING_BLOCK_LABEL_83;
        try
        {
            Localytics.Log.w("Application does not have one more more of the following permissions: ACCESS_WIFI_STATE. Determining Wi-Fi connectivity is unavailable");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("Application does not have the permission ACCESS_NETWORK_STATE. Determining Wi-Fi connectivity is unavailable", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("NullPointerException in getNetworkType()", context);
        }
        return (new StringBuilder("android_network_type_")).append(telephonymanager.getNetworkType()).toString();
    }

    static String getSerialNumberHashOrNull()
    {
        Object obj = null;
        if (Constants.CURRENT_API_LEVEL >= 9)
        {
            try
            {
                obj = (String)android/os/Build.getField("SERIAL").get(null);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        }
        if (obj == null)
        {
            return null;
        } else
        {
            return getSha256_buggy(((String) (obj)));
        }
    }

    static String getSha256_buggy(String s)
    {
        try
        {
            s = (new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(s.getBytes("UTF-8")))).toString(16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    static String getTelephonyDeviceIdOrNull(Context context)
    {
        if (Constants.CURRENT_API_LEVEL >= 7 && !((Boolean)ReflectionUtils.tryInvokeInstance(context.getPackageManager(), "hasSystemFeature", STRING_CLASS_ARRAY, HARDWARE_TELEPHONY)).booleanValue())
        {
            Localytics.Log.i("Device does not have telephony; cannot read telephony id");
            return null;
        }
        if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0)
        {
            return ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        } else
        {
            Localytics.Log.w("Application does not have permission READ_PHONE_STATE; determining device id is not possible.  Please consider requesting READ_PHONE_STATE in the AndroidManifest");
            return null;
        }
    }

    static boolean isValidResourceId(Context context, int i)
    {
        try
        {
            context.getResources().getResourceName(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

}
