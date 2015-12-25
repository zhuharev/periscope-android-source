// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.text.TextUtils;

public class PhoneNumber
{

    private static final PhoneNumber EMPTY_PHONE_NUMBER = new PhoneNumber("", "", "");
    private final String countryCode;
    private final String countryIso;
    private final String phoneNumber;

    public PhoneNumber(String s, String s1, String s2)
    {
        phoneNumber = s;
        countryIso = s1;
        countryCode = s2;
    }

    public static PhoneNumber emptyPhone()
    {
        return EMPTY_PHONE_NUMBER;
    }

    protected static boolean isCountryValid(PhoneNumber phonenumber)
    {
        return phonenumber != null && !EMPTY_PHONE_NUMBER.equals(phonenumber) && !TextUtils.isEmpty(phonenumber.getCountryCode()) && !TextUtils.isEmpty(phonenumber.getCountryIso());
    }

    protected static boolean isValid(PhoneNumber phonenumber)
    {
        return phonenumber != null && !EMPTY_PHONE_NUMBER.equals(phonenumber) && !TextUtils.isEmpty(phonenumber.getPhoneNumber()) && !TextUtils.isEmpty(phonenumber.getCountryCode()) && !TextUtils.isEmpty(phonenumber.getCountryIso());
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getCountryIso()
    {
        return countryIso;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

}
