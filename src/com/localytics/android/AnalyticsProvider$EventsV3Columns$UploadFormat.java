// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            AnalyticsProvider

static final class value extends Enum
{

    private static final V3 $VALUES[];
    public static final V3 V2;
    public static final V3 V3;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        V2 = new <init>("V2", 0, 2);
        V3 = new <init>("V3", 1, 3);
        $VALUES = (new .VALUES[] {
            V2, V3
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
