// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import retrofit.RequestInterceptor;

// Referenced classes of package com.digits.sdk.android:
//            DigitsUserAgent

class DigitsRequestInterceptor
    implements RequestInterceptor
{

    static final String USER_AGENT_KEY = "User-Agent";
    private final DigitsUserAgent userAgent;

    public DigitsRequestInterceptor(DigitsUserAgent digitsuseragent)
    {
        userAgent = digitsuseragent;
    }

    public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
    {
        requestfacade.addHeader("User-Agent", userAgent.toString());
    }
}
