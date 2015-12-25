// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ProgressBar;

// Referenced classes of package o:
//            _cls0993, _cls14B1, _cls02C9, cl

public final class _cls072B
{

    public static final int wF;
    private static final _cls072B wG = new _cls072B();

    _cls072B()
    {
    }

    public static boolean _mth0269(int i)
    {
        return _cls0993._mth02C0(i);
    }

    public static _cls072B _mth026D()
    {
        return wG;
    }

    public static boolean _mth02BB(Context context, String s)
    {
        return _cls0993._mth02BB(context, s);
    }

    private static String _mth02BC(Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("gcore_");
        stringbuilder.append(wF);
        stringbuilder.append("-");
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        stringbuilder.append("-");
        if (context != null)
        {
            stringbuilder.append(context.getPackageName());
        }
        stringbuilder.append("-");
        if (context != null)
        {
            try
            {
                stringbuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return stringbuilder.toString();
    }

    public static AlertDialog _mth02CA(_cls02C9 _pcls02c9, cl cl)
    {
        Object obj1 = new ProgressBar(_pcls02c9, null, 0x101007a);
        ((ProgressBar) (obj1)).setIndeterminate(true);
        ((ProgressBar) (obj1)).setVisibility(0);
        Object obj = new android.app.AlertDialog.Builder(_pcls02c9);
        ((android.app.AlertDialog.Builder) (obj)).setView(((android.view.View) (obj1)));
        obj1 = _cls0993._mth2071(_pcls02c9);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(_pcls02c9.getResources().getString(FE7D._cls02CA.common_google_play_services_updating_text, new Object[] {
            obj1
        }));
        ((android.app.AlertDialog.Builder) (obj)).setTitle(FE7D._cls02CA.common_google_play_services_updating_title);
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("", null);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        _cls0993._mth02CA(_pcls02c9, cl, "GooglePlayServicesUpdatingDialog", ((android.app.Dialog) (obj)));
        return ((AlertDialog) (obj));
    }

    public static int _mth1D4E(Context context)
    {
        int j = _cls0993._mth1D4E(context);
        int i = j;
        if (_cls0993._mth1FBE(context, j))
        {
            i = 18;
        }
        return i;
    }

    public static void _mth1D54(Context context)
    {
        _cls0993._mth1D54(context);
    }

    public static boolean _mth1FBE(Context context, int i)
    {
        return _cls0993._mth1FBE(context, i);
    }

    public final Intent _mth02CA(Activity activity, int i, String s)
    {
        switch (i)
        {
        case 1: // '\001'
        case 2: // '\002'
            return _cls14B1._mth141D("com.google.android.gms", _mth02BC(activity, s));

        case 42: // '*'
            return _cls14B1._mth0722();

        case 3: // '\003'
            return _cls14B1.FF70("com.google.android.gms");
        }
        return null;
    }

    static 
    {
        wF = _cls0993.wF;
    }
}
