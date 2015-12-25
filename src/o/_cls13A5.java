// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;

// Referenced classes of package o:
//            _cls1D4C, _cls05D5

class _cls13A5
{

    _cls13A5()
    {
    }

    public static void _mth02CA(Drawable drawable, float f, float f1)
    {
        drawable.setHotspot(f, f1);
    }

    public static void _mth02CA(Drawable drawable, int i)
    {
        if (drawable instanceof _cls1D4C)
        {
            _cls05D5._mth02CA(drawable, i);
            return;
        } else
        {
            drawable.setTint(i);
            return;
        }
    }

    public static void _mth02CA(Drawable drawable, int i, int j, int k, int l)
    {
        drawable.setHotspotBounds(i, j, k, l);
    }

    public static void _mth02CA(Drawable drawable, ColorStateList colorstatelist)
    {
        if (drawable instanceof _cls1D4C)
        {
            _cls05D5._mth02CA(drawable, colorstatelist);
            return;
        } else
        {
            drawable.setTintList(colorstatelist);
            return;
        }
    }

    public static void _mth02CA(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        if (drawable instanceof _cls1D4C)
        {
            _cls05D5._mth02CA(drawable, mode);
            return;
        } else
        {
            drawable.setTintMode(mode);
            return;
        }
    }

    public static Drawable _mth141D(Drawable drawable)
    {
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer))
        {
            return new _cls1D4C(drawable);
        } else
        {
            return drawable;
        }
    }
}
