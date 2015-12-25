// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.res.TypedArray;
import java.lang.reflect.Field;

// Referenced classes of package com.digits.sdk.android:
//            AppCompatClassManagerImp, ActivityClassManagerImp, ActivityClassManager

class ActivityClassManagerFactory
{
    static class ThemeAttributes
    {

        private static final String CLASS_NAME = "o.\u1FD1";
        private final int styleableTheme[];
        private final int styleableThemeWindowActionBar;



        public ThemeAttributes()
        {
            Object obj = Class.forName("o.\u1FD1");
            Field field = ((Class) (obj)).getField("Theme");
            styleableTheme = (int[])field.get(field.getType());
            obj = ((Class) (obj)).getField("Theme_windowActionBar");
            styleableThemeWindowActionBar = ((Integer)((Field) (obj)).get(((Field) (obj)).getType())).intValue();
        }
    }


    ActivityClassManagerFactory()
    {
    }

    private boolean isAppCompatTheme(Context context, int i, ThemeAttributes themeattributes)
    {
        context = context.obtainStyledAttributes(i, themeattributes.styleableTheme);
        boolean flag = context.hasValue(themeattributes.styleableThemeWindowActionBar);
        context.recycle();
        return flag;
    }

    ActivityClassManager createActivityClassManager(Context context, int i)
    {
        Class.forName("o.\u01CF");
        if (!isAppCompatTheme(context, i, new ThemeAttributes()))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        context = new AppCompatClassManagerImp();
        return context;
        try
        {
            context = new ActivityClassManagerImp();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new ActivityClassManagerImp();
        }
        return context;
    }
}
