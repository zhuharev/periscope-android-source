// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;

public class TwitterApi
{

    public static final String BASE_HOST = "api.twitter.com";
    public static final String BASE_HOST_URL = "https://api.twitter.com";
    private final String baseHostUrl;

    public TwitterApi()
    {
        this("https://api.twitter.com");
    }

    public TwitterApi(String s)
    {
        baseHostUrl = s;
    }

    public static String buildUserAgent(String s, String s1)
    {
        return (new StringBuilder(s)).append('/').append(s1).append(' ').append(Build.MODEL).append('/').append(android.os.Build.VERSION.RELEASE).append(" (").append(Build.MANUFACTURER).append(';').append(Build.MODEL).append(';').append(Build.BRAND).append(';').append(Build.PRODUCT).append(')').toString();
    }

    public transient android.net.Uri.Builder buildUponBaseHostUrl(String as[])
    {
        android.net.Uri.Builder builder = Uri.parse(getBaseHostUrl()).buildUpon();
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                builder.appendPath(as[i]);
            }

        }
        return builder;
    }

    public String getBaseHostUrl()
    {
        return baseHostUrl;
    }
}
