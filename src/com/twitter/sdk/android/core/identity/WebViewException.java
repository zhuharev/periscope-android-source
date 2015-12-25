// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;


class WebViewException extends Exception
{

    private static final long serialVersionUID = 0x99576634813adebdL;
    private final int errorCode;
    private final String failingUrl;

    public WebViewException(int i, String s, String s1)
    {
        super(s);
        errorCode = i;
        failingUrl = s1;
    }

    public String getDescription()
    {
        return getMessage();
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getFailingUrl()
    {
        return failingUrl;
    }
}
