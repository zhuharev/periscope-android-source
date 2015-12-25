// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package o:
//            ri, ve, ra, rl, 
//            vh, va, rz, _cls148C, 
//            _cls0695, _cls0692, qy, _cls06B9, 
//            _cls0930, up, _cls14AE, _cls072A, 
//            uo, uj, _cls06CA, _cls072C, 
//            _cls071A

public class _cls068B extends ri
{

    private String st;
    private long su;
    private _cls0930 sv;
    public _cls148C sw;
    private qy sx;
    private String versionName;

    public _cls068B()
    {
    }

    private Boolean doInBackground()
    {
        Object obj;
        Exception exception;
        Object obj1;
        Object obj2;
        try
        {
            obj1 = ve.if._mth2148()._mth1F3B();
        }
        catch (Exception exception1)
        {
            ra._mth0454()._mth02CB("Answers", "Error dealing with settings", exception1);
            return Boolean.valueOf(false);
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        ra._mth0454()._mth02CA("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
        if (!((vh) (obj1)).UV.Uu)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        ra._mth0454()._mth02BE("Answers", "Analytics collection enabled");
        obj = sw;
        obj1 = ((vh) (obj1)).sW;
        obj2 = rz._mth1FBE(getContext(), "com.crashlytics.ApiEndpoint");
        obj = ((_cls148C) (obj)).sY;
        obj1 = new _cls0695(((_cls0692) (obj)), ((ut) (obj1)), ((String) (obj2)));
        ((_cls0692) (obj)).executor.submit(((Runnable) (obj1)));
        break MISSING_BLOCK_LABEL_108;
        exception;
        ra._mth0454()._mth02CB("Answers", "Failed to submit events task", exception);
        return Boolean.valueOf(true);
        ra._mth0454()._mth02BE("Answers", "Analytics collection disabled");
        exception = sx;
        if (((qy) (exception)).Qy != null)
        {
            exception = ((qy) (exception)).Qy;
            for (obj1 = ((qy.if) (exception)).Qz.iterator(); ((Iterator) (obj1)).hasNext(); ((qy.if) (exception)).Qx.unregisterActivityLifecycleCallbacks(((android.app.Application.ActivityLifecycleCallbacks) (obj2))))
            {
                obj2 = (android.app.Application.ActivityLifecycleCallbacks)((Iterator) (obj1)).next();
            }

        }
        exception = sw.sY;
        obj1 = new _cls06B9(exception);
        ((_cls0692) (exception)).executor.submit(((Runnable) (obj1)));
        break MISSING_BLOCK_LABEL_223;
        exception;
        ra._mth0454()._mth02CB("Answers", "Failed to submit events task", exception);
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android:answers";
    }

    public String getVersion()
    {
        return "1.3.2.79";
    }

    protected boolean onPreExecute()
    {
        Object obj1;
        PackageInfo packageinfo;
        obj1 = getContext();
        sv = new _cls0930(new up(((Context) (obj1)), "settings"));
        sx = new qy(((Context) (obj1)));
        packageinfo = ((Context) (obj1)).getPackageManager().getPackageInfo(((Context) (obj1)).getPackageName(), 0);
        st = Integer.toString(packageinfo.versionCode);
        Object obj;
        if (packageinfo.versionName == null)
        {
            obj = "0.0";
            break MISSING_BLOCK_LABEL_80;
        }
        obj = packageinfo.versionName;
        versionName = ((String) (obj));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            su = packageinfo.firstInstallTime;
            break MISSING_BLOCK_LABEL_133;
        }
        Exception exception;
        Exception exception2;
        long l;
        try
        {
            su = (new File(((Context) (obj1)).getPackageManager().getApplicationInfo(((Context) (obj1)).getPackageName(), 0).sourceDir)).lastModified();
        }
        catch (Exception exception1)
        {
            ra._mth0454()._mth02CB("Answers", "Error retrieving app properties", exception1);
            return false;
        }
        obj = new _cls14AE(((Context) (obj1)), getIdManager(), st, versionName);
        obj = new _cls0692(this, ((Context) (obj1)), new _cls072A(((Context) (obj1)), new uo(this)), ((_cls14AE) (obj)), new uj(ra._mth0454()));
        obj1 = new _cls06CA(((_cls0692) (obj)));
        ((_cls0692) (obj)).executor.submit(((Runnable) (obj1)));
        break MISSING_BLOCK_LABEL_226;
        exception2;
        ra._mth0454()._mth02CB("Answers", "Failed to submit events task", exception2);
        sw = new _cls148C(((_cls0692) (obj)));
        obj = sx;
        exception2 = new _cls072C(sw);
        if (((qy) (obj)).Qy != null)
        {
            if (!((qy) (obj)).Qy._mth02CB(exception2));
        }
        l = su;
        break MISSING_BLOCK_LABEL_279;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        ra._mth0454()._mth02BE("Answers", "New app install detected");
        obj = sw;
        ra._mth0454()._mth02BE("Answers", "Logged install");
        obj = ((_cls148C) (obj)).sY;
        ((_cls0692) (obj)).executeAsync(new _cls071A(((_cls0692) (obj)), new _cls1491.if(_cls1491._cls02CA.tq), true));
        obj = sv;
        ((_cls0930) (obj)).prefStore._mth02CA(((_cls0930) (obj)).prefStore.edit().putBoolean("analytics_launched", true));
        break MISSING_BLOCK_LABEL_425;
        exception;
        ra._mth0454()._mth02CB("Answers", "Failed to initialize", exception);
        return true;
        boolean flag;
        if (!sv.prefStore._mth1E97().getBoolean("analytics_launched", false))
        {
            if (System.currentTimeMillis() - l < 0x36ee80L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
