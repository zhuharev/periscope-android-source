// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            WebViewException

class OAuthWebViewClient extends WebViewClient
{
    static interface Listener
    {

        public abstract void onError(WebViewException webviewexception);

        public abstract void onPageFinished(WebView webview, String s);

        public abstract void onSuccess(Bundle bundle);
    }


    private final String completeUrl;
    private final Listener listener;

    public OAuthWebViewClient(String s, Listener listener1)
    {
        completeUrl = s;
        listener = listener1;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        listener.onPageFinished(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        listener.onError(new WebViewException(i, s, s1));
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        listener.onError(new WebViewException(sslerror.getPrimaryError(), null, null));
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.startsWith(completeUrl))
        {
            s = o._cls141D.if._mth02CA(URI.create(s).getRawQuery(), false);
            webview = new Bundle(s.size());
            java.util.Map.Entry entry;
            for (s = s.entrySet().iterator(); s.hasNext(); webview.putString((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)s.next();
            }

            listener.onSuccess(webview);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }
}
