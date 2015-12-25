// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.internal.TwitterApi;

public class DigitsApi extends TwitterApi
{

    public static final String BASE_HOST = "api.digits.com";
    public static final String BASE_HOST_URL = "https://api.digits.com";

    public DigitsApi()
    {
        super("https://api.digits.com");
    }
}
