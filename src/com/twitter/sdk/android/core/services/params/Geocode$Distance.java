// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services.params;


// Referenced classes of package com.twitter.sdk.android.core.services.params:
//            Geocode

public static final class identifier extends Enum
{

    private static final KILOMETERS $VALUES[];
    public static final KILOMETERS KILOMETERS;
    public static final KILOMETERS MILES;
    public final String identifier;

    public static identifier valueOf(String s)
    {
        return (identifier)Enum.valueOf(com/twitter/sdk/android/core/services/params/Geocode$Distance, s);
    }

    public static identifier[] values()
    {
        return (identifier[])$VALUES.clone();
    }

    static 
    {
        MILES = new <init>("MILES", 0, "mi");
        KILOMETERS = new <init>("KILOMETERS", 1, "km");
        $VALUES = (new .VALUES[] {
            MILES, KILOMETERS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        identifier = s1;
    }
}
