// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            Localytics

public static final class scope extends Enum
{

    private static final APPLICATION $VALUES[];
    public static final APPLICATION APPLICATION;
    public static final APPLICATION ORGANIZATION;
    private final String scope;

    public static scope valueOf(String s)
    {
        return (scope)Enum.valueOf(com/localytics/android/Localytics$ProfileScope, s);
    }

    public static scope[] values()
    {
        return (scope[])$VALUES.clone();
    }

    public final String getScope()
    {
        return scope;
    }

    static 
    {
        ORGANIZATION = new <init>("ORGANIZATION", 0, "org");
        APPLICATION = new <init>("APPLICATION", 1, "app");
        $VALUES = (new .VALUES[] {
            ORGANIZATION, APPLICATION
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        scope = s1;
    }
}
