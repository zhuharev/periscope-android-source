// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.lang.reflect.Field;

// Referenced classes of package com.digits.sdk.android:
//            ActivityClassManagerFactory

static class styleableThemeWindowActionBar
{

    private static final String CLASS_NAME = "o.\u1FD1";
    private final int styleableTheme[];
    private final int styleableThemeWindowActionBar;



    public ()
    {
        Object obj = Class.forName("o.\u1FD1");
        Field field = ((Class) (obj)).getField("Theme");
        styleableTheme = (int[])field.get(field.getType());
        obj = ((Class) (obj)).getField("Theme_windowActionBar");
        styleableThemeWindowActionBar = ((Integer)((Field) (obj)).get(((Field) (obj)).getType())).intValue();
    }
}
