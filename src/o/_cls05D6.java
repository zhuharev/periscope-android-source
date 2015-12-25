// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.view.View;

// Referenced classes of package o:
//            _cls0208, _cls05DF, FF68, _cls4E36

class _cls05D6
{

    _cls05D6()
    {
    }

    public static void _mth02B9(View view)
    {
        view.requestApplyInsets();
    }

    public static void _mth02BB(View view, float f)
    {
        view.setElevation(f);
    }

    public static FF68 _mth02CA(View view, FF68 ff68)
    {
        Object obj = ff68;
        if (ff68 instanceof _cls0208)
        {
            android.view.WindowInsets windowinsets = ((_cls0208)ff68)._mth0131();
            view = view.onApplyWindowInsets(windowinsets);
            obj = ff68;
            if (view != windowinsets)
            {
                obj = new _cls0208(view);
            }
        }
        return ((FF68) (obj));
    }

    static void _mth02CA(View view, ColorStateList colorstatelist)
    {
        view.setBackgroundTintList(colorstatelist);
    }

    static void _mth02CA(View view, android.graphics.PorterDuff.Mode mode)
    {
        view.setBackgroundTintMode(mode);
    }

    public static void _mth02CA(View view, _cls4E36 _pcls4e36)
    {
        view.setOnApplyWindowInsetsListener(new _cls05DF(_pcls4e36));
    }

    public static boolean _mth0674(View view)
    {
        return view.isNestedScrollingEnabled();
    }

    public static void _mth1D35(View view)
    {
        view.stopNestedScroll();
    }
}
