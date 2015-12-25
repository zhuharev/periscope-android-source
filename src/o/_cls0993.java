// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            _cls072B, az, _cls10C1, _cls02C9, 
//            _cls099A, _cls0710, _cls1623, _cls0E42, 
//            cl

public final class _cls0993
{

    public static final int wF = 0x7bd338;
    private static boolean wH = false;
    private static boolean wI = false;
    private static int wJ = -1;
    private static final Object wK = new Object();
    private static String wL = null;
    private static Integer wM = null;
    private static AtomicBoolean wN = new AtomicBoolean();
    private static final AtomicBoolean wO = new AtomicBoolean();

    private _cls0993()
    {
    }

    public static String _mth02B5(int i)
    {
        return ConnectionResult.FE7E(i);
    }

    public static Intent _mth02B8(int i)
    {
        return _cls072B._mth026D()._mth02CA(null, i, null);
    }

    static boolean _mth02BB(Context context, String s)
    {
label0:
        {
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break label0;
            }
            Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!s.equals(((android.content.pm.PackageInstaller.SessionInfo)iterator.next()).getAppPackageName()));
            return true;
        }
        boolean flag1;
label1:
        {
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                Bundle bundle = ((UserManager)context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
                if (bundle != null && "true".equals(bundle.getString("restricted_profile")))
                {
                    flag1 = true;
                    break label1;
                }
            }
            flag1 = false;
        }
        if (flag1)
        {
            return false;
        }
        context = context.getPackageManager();
        boolean flag2;
        try
        {
            flag2 = context.getApplicationInfo(s, 8192).enabled;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag2;
    }

    public static boolean _mth02BE(Context context, int i)
    {
        if (_mth02CB(context, i, "com.google.android.gms"))
        {
            context = context.getPackageManager();
            if (az._mth14F3()._mth02CA(context, "com.google.android.gms"))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean _mth02C0(int i)
    {
        switch (i)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 9: // '\t'
            return true;
        }
        return false;
    }

    private static AlertDialog _mth02CA(int i, Activity activity, Fragment fragment, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (i == 0)
        {
            return null;
        }
        int k = i;
        if (activity.getPackageManager().hasSystemFeature("android.hardware.type.watch"))
        {
            k = i;
            if (i == 2)
            {
                k = 42;
            }
        }
        android.app.AlertDialog.Builder builder1 = null;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        android.app.AlertDialog.Builder builder = builder1;
        if (i != 0)
        {
            TypedValue typedvalue = new TypedValue();
            activity.getTheme().resolveAttribute(0x1010309, typedvalue, true);
            builder = builder1;
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedvalue.resourceId)))
            {
                builder = new android.app.AlertDialog.Builder(activity, 5);
            }
        }
        builder1 = builder;
        if (builder == null)
        {
            builder1 = new android.app.AlertDialog.Builder(activity);
        }
        builder1.setMessage(_cls141D.if._mth02CA(activity, k, _mth2071(activity)));
        if (oncancellistener != null)
        {
            builder1.setOnCancelListener(oncancellistener);
        }
        oncancellistener = _cls072B._mth026D()._mth02CA(activity, k, "d");
        if (fragment == null)
        {
            fragment = new _cls10C1(activity, oncancellistener, j);
        } else
        {
            fragment = new _cls10C1(fragment, oncancellistener, j);
        }
        oncancellistener = _cls141D.if._mth02CA(activity, k);
        if (oncancellistener != null)
        {
            builder1.setPositiveButton(oncancellistener, fragment);
        }
        activity = _cls141D.if._mth02CA(activity, k);
        if (activity != null)
        {
            builder1.setTitle(activity);
        }
        return builder1.create();
    }

    public static Dialog _mth02CA(int i, Activity activity, int j)
    {
        return _mth02CA(i, activity, ((Fragment) (null)), j, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    public static void _mth02CA(Activity activity, android.content.DialogInterface.OnCancelListener oncancellistener, String s, Dialog dialog)
    {
        if (activity instanceof _cls02C9)
        {
            activity = ((_cls02C9)activity).getSupportFragmentManager();
            _cls099A._mth02CB(dialog, oncancellistener).show(activity, s);
            return;
        }
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            activity = activity.getFragmentManager();
            _cls0710._mth02CA(dialog, oncancellistener).show(activity, s);
            return;
        } else
        {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public static boolean _mth02CA(int i, _cls02C9 _pcls02c9, cl cl, int j, cl cl1)
    {
        cl = _mth02CA(i, ((Activity) (_pcls02c9)), ((Fragment) (cl)), 2, ((android.content.DialogInterface.OnCancelListener) (cl1)));
        if (cl == null)
        {
            return false;
        } else
        {
            _mth02CA(((Activity) (_pcls02c9)), ((android.content.DialogInterface.OnCancelListener) (cl1)), "GooglePlayServicesErrorDialog", ((Dialog) (cl)));
            return true;
        }
    }

    private static boolean _mth02CA(PackageManager packagemanager)
    {
        Object obj = wK;
        obj;
        JVM INSTR monitorenter ;
        int i = wJ;
        if (i != -1) goto _L2; else goto _L1
_L1:
        packagemanager = packagemanager.getPackageInfo("com.google.android.gms", 64);
        az._mth14F3();
        if (az._mth02CA(packagemanager, new _cls1623.if[] {
            _cls1623.zn[1]
        }) == null) goto _L4; else goto _L3
_L3:
        wJ = 1;
          goto _L2
_L4:
        wJ = 0;
          goto _L2
_L6:
        wJ = 0;
_L2:
        i = wJ;
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        packagemanager;
        throw packagemanager;
        packagemanager;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static boolean _mth02CB(Context context, int i, String s)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            context = (AppOpsManager)context.getSystemService("appops");
            try
            {
                context.checkPackage(i, s);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return true;
        }
        context = context.getPackageManager().getPackagesForUid(i);
        if (context != null)
        {
            for (i = 0; i < context.length; i++)
            {
                if (s.equals(context[i]))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean _mth02CB(PackageManager packagemanager)
    {
        return _mth02CA(packagemanager) || !"user".equals(Build.TYPE);
    }

    public static int _mth1D4E(Context context)
    {
        PackageManager packagemanager;
        if (_cls0E42.xF)
        {
            return 0;
        }
        packagemanager = context.getPackageManager();
        try
        {
            context.getResources().getString(FE7D._cls02CA.common_google_play_services_unknown_issue);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if ("com.google.android.gms".equals(context.getPackageName()) || wO.get())
        {
            break MISSING_BLOCK_LABEL_290;
        }
        Object obj = wK;
        obj;
        JVM INSTR monitorenter ;
        if (wL != null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        wL = context.getPackageName();
        Object obj1 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        wM = Integer.valueOf(((Bundle) (obj1)).getInt("com.google.android.gms.version"));
        break MISSING_BLOCK_LABEL_196;
        wM = null;
        break MISSING_BLOCK_LABEL_196;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", namenotfoundexception);
        break MISSING_BLOCK_LABEL_196;
        if (!wL.equals(context.getPackageName()))
        {
            throw new IllegalArgumentException((new StringBuilder("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '")).append(wL).append("' and this call used package '").append(context.getPackageName()).append("'.").toString());
        }
        namenotfoundexception = wM;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        context;
        throw context;
_L1:
        if (namenotfoundexception == null)
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (namenotfoundexception.intValue() != wF)
        {
            throw new IllegalStateException((new StringBuilder("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ")).append(wF).append(" but found ").append(namenotfoundexception).append(".  You must have the following declaration within the <application> element: ").append("    <meta-data android:name=\"com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
        }
        try
        {
            obj = packagemanager.getPackageInfo("com.google.android.gms", 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
        az._mth14F3();
        int i = ((PackageInfo) (obj)).versionCode;
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch"))
        {
            if (az._mth02CA(((PackageInfo) (obj)), _cls1623._cls141F.zr) == null)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_437;
        }
        try
        {
            context = az._mth02CA(packagemanager.getPackageInfo("com.android.vending", 8256), _cls1623._cls141F.zr);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
            return 9;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
        if (az._mth02CA(((PackageInfo) (obj)), new _cls1623.if[] {
    context
}) != null)
        {
            break MISSING_BLOCK_LABEL_437;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
        Throwable throwable;
        int j = wF / 1000;
        if (((PackageInfo) (obj)).versionCode / 1000 < j)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder("Google Play services out of date.  Requires ")).append(wF).append(" but found ").append(((PackageInfo) (obj)).versionCode).toString());
            return 2;
        }
        obj = ((PackageInfo) (obj)).applicationInfo;
        context = ((Context) (obj));
        if (obj == null)
        {
            try
            {
                context = packagemanager.getApplicationInfo("com.google.android.gms", 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", context);
                return 1;
            }
        }
        return ((ApplicationInfo) (context)).enabled ? 0 : 3;
    }

    public static void _mth1D54(Context context)
    {
        if (wN.getAndSet(true))
        {
            return;
        }
        try
        {
            ((NotificationManager)context.getSystemService("notification")).cancel(10436);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static Context _mth1D62(Context context)
    {
        try
        {
            context = context.createPackageContext("com.google.android.gms", 3);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static boolean _mth1FBE(Context context, int i)
    {
        if (i == 18)
        {
            return true;
        }
        if (i == 1)
        {
            return _mth02BB(context, "com.google.android.gms");
        } else
        {
            return false;
        }
    }

    public static String _mth2071(Context context)
    {
        String s1 = context.getApplicationInfo().name;
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = context.getPackageName();
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            try
            {
                context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
            if (context != null)
            {
                s = packagemanager.getApplicationLabel(context).toString();
            }
        }
        return s;
    }

}
