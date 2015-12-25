// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// Referenced classes of package o:
//            ri, se, rn, _cls14DB, 
//            _cls14B7, ra, rl, si, 
//            sj, ve, vh, ux, 
//            up, sc, uj, _cls1602, 
//            _cls14AF, _cls152B

public final class _cls14B6 extends ri
    implements se
{

    private final rn tI = new rn();
    private final _cls14DB tJ = new _cls14DB();
    private _cls1602 tK;

    public _cls14B6()
    {
    }

    private static _cls14B7 _mth0559(Context context)
    {
        _cls14B7 _lcls14b7;
        Context context1;
        Object obj;
        _cls14B7 _lcls14b7_1;
        Properties properties;
        obj = null;
        context1 = null;
        _lcls14b7_1 = null;
        properties = null;
        _lcls14b7 = _lcls14b7_1;
        InputStream inputstream = context.getAssets().open("crashlytics-build.properties");
        context = inputstream;
        _lcls14b7 = properties;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        context1 = context;
        _lcls14b7 = _lcls14b7_1;
        obj = context;
        properties = new Properties();
        context1 = context;
        _lcls14b7 = _lcls14b7_1;
        obj = context;
        properties.load(context);
        context1 = context;
        _lcls14b7 = _lcls14b7_1;
        obj = context;
        _lcls14b7_1 = new _cls14B7(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
        context1 = context;
        _lcls14b7 = _lcls14b7_1;
        obj = context;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder()).append(_lcls14b7_1.packageName).append(" build properties: ").append(_lcls14b7_1.versionName).append(" (").append(_lcls14b7_1.st).append(") - ").append(_lcls14b7_1.tA).toString());
        _lcls14b7 = _lcls14b7_1;
        obj = _lcls14b7;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ra._mth0454()._mth02CB("Beta", "Error closing Beta build properties asset", context);
                return _lcls14b7;
            }
            return _lcls14b7;
        }
        break MISSING_BLOCK_LABEL_275;
        context;
        obj = context1;
        ra._mth0454()._mth02CB("Beta", "Error reading Beta build properties", context);
        obj = _lcls14b7;
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ra._mth0454()._mth02CB("Beta", "Error closing Beta build properties asset", context);
                return _lcls14b7;
            }
            return _lcls14b7;
        }
        break MISSING_BLOCK_LABEL_275;
        context;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ra._mth0454()._mth02CB("Beta", "Error closing Beta build properties asset", ioexception);
            }
        }
        throw context;
        return ((_cls14B7) (obj));
    }

    private String _mth141D(Context context, String s)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            if (s == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = "io.crash.air".equals(s);
        }
        if (flag)
        {
            ra._mth0454()._mth02BE("Beta", "App was possibly installed by Beta. Getting device token");
            boolean flag1;
            try
            {
                context = (String)tI._mth02CA(context, tJ);
                flag1 = "".equals(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ra._mth0454()._mth02CB("Beta", "Failed to load the Beta device token", context);
                return null;
            }
            if (flag1)
            {
                context = null;
            }
            return context;
        } else
        {
            ra._mth0454()._mth02BE("Beta", "App was not installed by Beta. Skipping device token");
            return null;
        }
    }

    protected final Object doInBackground()
    {
        ra._mth0454()._mth02BE("Beta", "Beta kit initializing...");
        Context context = getContext();
        si si1 = getIdManager();
        if (TextUtils.isEmpty(_mth141D(context, si1.RV._mth1507(si1.appContext))))
        {
            ra._mth0454()._mth02BE("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        ra._mth0454()._mth02BE("Beta", "Beta device token is present, checking for app updates.");
        Object obj = ve.if._mth2148()._mth1F3B();
        if (obj != null)
        {
            obj = ((vh) (obj)).UW;
        } else
        {
            obj = null;
        }
        _cls14B7 _lcls14b7 = _mth0559(context);
        boolean flag;
        if (obj != null && !TextUtils.isEmpty(((ux) (obj)).Up) && _lcls14b7 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            tK._mth02CA(context, this, si1, ((ux) (obj)), _lcls14b7, new up(this), new sc(), new uj(ra._mth0454()));
        }
        return Boolean.valueOf(true);
    }

    public final String getIdentifier()
    {
        return "com.crashlytics.sdk.android:beta";
    }

    public final String getVersion()
    {
        return "1.1.3.61";
    }

    protected final boolean onPreExecute()
    {
        getContext().getApplicationContext();
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            obj = new _cls14AF(getFabric().QH, getFabric().QF);
        } else
        {
            obj = new _cls152B();
        }
        tK = ((_cls1602) (obj));
        return true;
    }

    public final HashMap _mth14F0()
    {
        Object obj = getIdManager();
        obj = ((si) (obj)).RV._mth1507(((si) (obj)).appContext);
        obj = _mth141D(getContext(), ((String) (obj)));
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            hashmap.put(si.if.Se, obj);
        }
        return hashmap;
    }
}
