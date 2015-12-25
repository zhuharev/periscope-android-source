// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package o:
//            _cls1D38, aux, _cls02CB, _cls02CE, 
//            _cls02CA, _cls1508

public class o.if extends _cls1D38
{
    public static interface if
    {

        public abstract void onRequestPermissionsResult(int i, String as[], int ai[]);
    }

    /* member class not found */
    class _cls02CA {}


    public o.if()
    {
    }

    private static _cls02CB.if _mth02CA(_cls1508 _pcls1508)
    {
        _cls02CA _lcls02ca = null;
        if (_pcls1508 != null)
        {
            _lcls02ca = new _cls02CA(_pcls1508);
        }
        return _lcls02ca;
    }

    public static void _mth02CA(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            aux._mth02CA(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void _mth02CA(Activity activity, _cls1508 _pcls1508)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _cls02CB._mth02CA(activity, _mth02CA(_pcls1508));
        }
    }

    public static void _mth02CA(Activity activity, String as[], int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            _cls02CE._mth02CA(activity, as, i);
            return;
        }
        if (activity instanceof if)
        {
            (new Handler(Looper.getMainLooper())).post(new o._cls02CA(as, activity, i));
        }
    }

    public static boolean _mth02CA(Activity activity, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            return _cls02CE._mth02CA(activity, s);
        } else
        {
            return false;
        }
    }

    public static void _mth02CB(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _cls02CB._mth02CB(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void _mth02CB(Activity activity, _cls1508 _pcls1508)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _cls02CB._mth02CB(activity, _mth02CA(_pcls1508));
        }
    }

    public static void _mth02CE(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _cls02CB._mth02CE(activity);
        }
    }

    public static void _mth02CF(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _cls02CB._mth02CF(activity);
        }
    }
}
