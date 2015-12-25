// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            InAppDialogFragment

static final class  extends Enum
{

    private static final DO_NOT_OPEN $VALUES[];
    public static final DO_NOT_OPEN DO_NOT_OPEN;
    public static final DO_NOT_OPEN OPENING_EXTERNAL;
    public static final DO_NOT_OPEN OPENING_INTERNAL;
    public static final DO_NOT_OPEN PROTOCOL_UNMATCHED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/localytics/android/InAppDialogFragment$ProtocolHandleAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROTOCOL_UNMATCHED = new <init>("PROTOCOL_UNMATCHED", 0);
        OPENING_INTERNAL = new <init>("OPENING_INTERNAL", 1);
        OPENING_EXTERNAL = new <init>("OPENING_EXTERNAL", 2);
        DO_NOT_OPEN = new <init>("DO_NOT_OPEN", 3);
        $VALUES = (new .VALUES[] {
            PROTOCOL_UNMATCHED, OPENING_INTERNAL, OPENING_EXTERNAL, DO_NOT_OPEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
