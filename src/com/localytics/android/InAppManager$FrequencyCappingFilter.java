// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            InAppManager

static final class  extends Enum
{

    private static final BLACKOUT $VALUES[];
    public static final BLACKOUT BLACKOUT;
    public static final BLACKOUT FREQUENCY;
    public static final BLACKOUT MAX_COUNT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/localytics/android/InAppManager$FrequencyCappingFilter, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FREQUENCY = new <init>("FREQUENCY", 0);
        MAX_COUNT = new <init>("MAX_COUNT", 1);
        BLACKOUT = new <init>("BLACKOUT", 2);
        $VALUES = (new .VALUES[] {
            FREQUENCY, MAX_COUNT, BLACKOUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
