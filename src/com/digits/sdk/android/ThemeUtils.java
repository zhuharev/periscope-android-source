// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import java.lang.reflect.Field;

class ThemeUtils
{

    public static final int DEFAULT_THEME = 0;
    public static final String THEME_RESOURCE_ID = "THEME_RESOURCE_ID";

    private ThemeUtils()
    {
    }

    static int calculateOpacityTransform(double d, int i, int j)
    {
        int k = Color.red(j);
        int l = Color.red(i);
        int i1 = Color.green(j);
        int j1 = Color.green(i);
        j = Color.blue(j);
        i = Color.blue(i);
        return Color.rgb((int)((1.0D - d) * (double)k + (double)l * d), (int)((1.0D - d) * (double)i1 + (double)j1 * d), (int)((1.0D - d) * (double)j + (double)i * d));
    }

    static int getAccentColor(Resources resources, android.content.res.Resources.Theme theme)
    {
        TypedValue typedvalue = getTypedValueColor(theme, R.attr.dgts__accentColor);
        if (typedvalue != null)
        {
            return typedvalue.data;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            TypedValue typedvalue1 = getTypedValueColor(theme, 0x1010435);
            if (typedvalue1 != null)
            {
                return typedvalue1.data;
            }
        }
        Field field = com/digits/sdk/android/R$attr.getDeclaredField("colorAccent");
        theme = getTypedValueColor(theme, field.getInt(field.getType()));
        if (theme == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        int i = ((TypedValue) (theme)).data;
        return i;
_L2:
        return resources.getColor(R.color.dgts__default_accent);
        theme;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static Drawable getLogoDrawable(android.content.res.Resources.Theme theme)
    {
        TypedValue typedvalue = new TypedValue();
        int i = R.attr.dgts__logoDrawable;
        return theme.obtainStyledAttributes(typedvalue.data, new int[] {
            i
        }).getDrawable(0);
    }

    static TypedValue getTypedValueColor(android.content.res.Resources.Theme theme, int i)
    {
        TypedValue typedvalue = new TypedValue();
        theme.resolveAttribute(i, typedvalue, true);
        if (typedvalue.type >= 28 && typedvalue.type <= 31)
        {
            return typedvalue;
        } else
        {
            return null;
        }
    }

    static boolean isLightColor(int i)
    {
        int j = Color.red(i);
        int k = Color.green(i);
        i = Color.blue(i);
        return (double)j * 0.20999999999999999D + (double)k * 0.71999999999999997D + (double)i * 0.070000000000000007D > 170D;
    }
}
