// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


class DigitsUserAgent
{

    private final String androidVersion;
    private final String digitsVersion;

    DigitsUserAgent(String s, String s1)
    {
        digitsVersion = s;
        androidVersion = s1;
    }

    public String toString()
    {
        return (new StringBuilder("Digits/")).append(digitsVersion).append(" (Android ").append(androidVersion).append(")").toString();
    }
}
