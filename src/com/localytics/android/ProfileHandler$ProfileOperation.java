// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            ProfileHandler

static final class operation extends Enum
{

    private static final INCREMENT $VALUES[];
    public static final INCREMENT ASSIGN;
    public static final INCREMENT DELETE;
    public static final INCREMENT INCREMENT;
    public static final INCREMENT SETADD;
    public static final INCREMENT SETREMOVE;
    private final String operation;

    public static operation valueOf(String s)
    {
        return (operation)Enum.valueOf(com/localytics/android/ProfileHandler$ProfileOperation, s);
    }

    public static operation[] values()
    {
        return (operation[])$VALUES.clone();
    }

    public final String getOperationString()
    {
        return operation;
    }

    static 
    {
        ASSIGN = new <init>("ASSIGN", 0, "assign");
        DELETE = new <init>("DELETE", 1, "delete");
        SETADD = new <init>("SETADD", 2, "set-add");
        SETREMOVE = new <init>("SETREMOVE", 3, "set-remove");
        INCREMENT = new <init>("INCREMENT", 4, "increment");
        $VALUES = (new .VALUES[] {
            ASSIGN, DELETE, SETADD, SETREMOVE, INCREMENT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        operation = s1;
    }
}
