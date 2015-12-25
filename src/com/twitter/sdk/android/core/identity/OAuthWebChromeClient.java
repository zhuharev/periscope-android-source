// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

class OAuthWebChromeClient extends WebChromeClient
{

    OAuthWebChromeClient()
    {
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        return true;
    }
}
