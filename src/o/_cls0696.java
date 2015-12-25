// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

final class _cls0696
{

    static final int EMPTY_STATE_SET[] = new int[0];
    static final int FOCUSED_STATE_SET[] = {
        0x101009c
    };
    static final int PRESSED_STATE_SET[] = {
        0x10100a7
    };
    static final int SELECTED_STATE_SET[] = {
        0x10100a1
    };
    static final int hA[] = {
        0xfefeff62
    };
    static final int hB[] = {
        0x10102fe
    };
    static final int hC[] = {
        0x10100a0
    };
    static final int hD[] = {
        0xfefeff59, 0xfefeff64
    };
    private static final int hE[] = new int[1];
    private static final ThreadLocal hz = new ThreadLocal();

    _cls0696()
    {
    }

    public static int _mth02BB(Context context, int i)
    {
        hE[0] = i;
        context = context.obtainStyledAttributes(null, hE);
        i = context.getColor(0, 0);
        context.recycle();
        return i;
        Exception exception;
        exception;
        context.recycle();
        throw exception;
    }

    public static ColorStateList _mth02BC(Context context, int i)
    {
        hE[0] = i;
        context = context.obtainStyledAttributes(null, hE);
        ColorStateList colorstatelist = context.getColorStateList(0);
        context.recycle();
        return colorstatelist;
        Exception exception;
        exception;
        context.recycle();
        throw exception;
    }

    public static int _mth02BD(Context context, int i)
    {
        Object obj = _mth02BC(context, i);
        if (obj != null && ((ColorStateList) (obj)).isStateful())
        {
            return ((ColorStateList) (obj)).getColorForState(hA, ((ColorStateList) (obj)).getDefaultColor());
        }
        TypedValue typedvalue = (TypedValue)hz.get();
        obj = typedvalue;
        if (typedvalue == null)
        {
            obj = new TypedValue();
            hz.set(obj);
        }
        context.getTheme().resolveAttribute(0x1010033, ((TypedValue) (obj)), true);
        float f = ((TypedValue) (obj)).getFloat();
        i = _mth02BB(context, i);
        int j = Math.round((float)Color.alpha(i) * f);
        if (j < 0 || j > 255)
        {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        } else
        {
            return 0xffffff & i | j << 24;
        }
    }

    static int _mth02CA(Context context, int i, float f)
    {
        i = _mth02BB(context, i);
        int j = Math.round((float)Color.alpha(i) * f);
        if (j < 0 || j > 255)
        {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        } else
        {
            return 0xffffff & i | j << 24;
        }
    }

}
