// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            Localytics

public static final class I extends Enum
{

    private static final RIGHT $VALUES[];
    public static final RIGHT LEFT;
    public static final RIGHT RIGHT;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/localytics/android/Localytics$InAppMessageDismissButtonLocation, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        LEFT = new <init>("LEFT", 0);
        RIGHT = new <init>("RIGHT", 1);
        $VALUES = (new .VALUES[] {
            LEFT, RIGHT
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
