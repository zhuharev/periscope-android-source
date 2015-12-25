// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public class _cls02D0
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    static final _cls02CA _fld0268;

    public _cls02D0()
    {
    }

    public static void _mth02CA(Drawable drawable, float f, float f1)
    {
        _fld0268._mth02CA(drawable, f, f1);
    }

    public static void _mth02CA(Drawable drawable, int i)
    {
        _fld0268._mth02CA(drawable, i);
    }

    public static void _mth02CA(Drawable drawable, int i, int j, int k, int l)
    {
        _fld0268._mth02CA(drawable, i, j, k, l);
    }

    public static void _mth02CA(Drawable drawable, ColorStateList colorstatelist)
    {
        _fld0268._mth02CA(drawable, colorstatelist);
    }

    public static void _mth02CA(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        _fld0268._mth02CA(drawable, mode);
    }

    public static void _mth02CA(Drawable drawable, boolean flag)
    {
        _fld0268._mth02CA(drawable, flag);
    }

    public static void _mth02CB(Drawable drawable)
    {
        _fld0268._mth02CB(drawable);
    }

    public static boolean _mth02CE(Drawable drawable)
    {
        return _fld0268._mth02CE(drawable);
    }

    public static Drawable _mth02CF(Drawable drawable)
    {
        return _fld0268._mth02CF(drawable);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 23)
        {
            _fld0268 = new _cls02BB();
        } else
        if (i >= 22)
        {
            _fld0268 = new _cls141D();
        } else
        if (i >= 21)
        {
            _fld0268 = new aux();
        } else
        if (i >= 19)
        {
            _fld0268 = new _cls02CF();
        } else
        if (i >= 17)
        {
            _fld0268 = new _cls02CE();
        } else
        if (i >= 11)
        {
            _fld0268 = new _cls02CB();
        } else
        {
            _fld0268 = new if();
        }
    }
}
