// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


public final class Verification extends Enum
{

    private static final Verification $VALUES[];
    public static final Verification sms;
    public static final Verification voicecall;

    private Verification(String s, int i)
    {
        super(s, i);
    }

    public static Verification valueOf(String s)
    {
        return (Verification)Enum.valueOf(com/digits/sdk/android/Verification, s);
    }

    public static Verification[] values()
    {
        return (Verification[])$VALUES.clone();
    }

    static 
    {
        voicecall = new Verification("voicecall", 0);
        sms = new Verification("sms", 1);
        $VALUES = (new Verification[] {
            voicecall, sms
        });
    }
}
