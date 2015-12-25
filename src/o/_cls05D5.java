// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls1424, _cls14A1

class _cls05D5
{

    _cls05D5()
    {
    }

    public static void _mth02CA(Drawable drawable, int i)
    {
        if (drawable instanceof _cls1424)
        {
            ((_cls1424)drawable).setTint(i);
        }
    }

    public static void _mth02CA(Drawable drawable, ColorStateList colorstatelist)
    {
        if (drawable instanceof _cls1424)
        {
            ((_cls1424)drawable).setTintList(colorstatelist);
        }
    }

    public static void _mth02CA(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        if (drawable instanceof _cls1424)
        {
            ((_cls1424)drawable).setTintMode(mode);
        }
    }

    public static Drawable _mth141D(Drawable drawable)
    {
        if (!(drawable instanceof _cls14A1))
        {
            return new _cls14A1(drawable);
        } else
        {
            return drawable;
        }
    }
}
