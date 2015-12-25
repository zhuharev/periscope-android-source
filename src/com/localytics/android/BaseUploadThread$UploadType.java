// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            BaseUploadThread

public static final class  extends Enum
{

    private static final MARKETING $VALUES[];
    public static final MARKETING ANALYTICS;
    public static final MARKETING MARKETING;
    public static final MARKETING PROFILES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/localytics/android/BaseUploadThread$UploadType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ANALYTICS = new <init>("ANALYTICS", 0);
        PROFILES = new <init>("PROFILES", 1);
        MARKETING = new <init>("MARKETING", 2);
        $VALUES = (new .VALUES[] {
            ANALYTICS, PROFILES, MARKETING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
