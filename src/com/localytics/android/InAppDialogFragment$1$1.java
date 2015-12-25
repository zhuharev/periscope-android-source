// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


class val.url
    implements Runnable
{

    final val.url this$1;
    final etingDialog.MarketingWebView val$mWebView;
    final String val$url;

    public void run()
    {
        val$mWebView.loadUrl(val$url);
    }

    etingDialog.MarketingWebView()
    {
        this$1 = final_marketingwebview;
        val$mWebView = marketingwebview1;
        val$url = String.this;
        super();
    }
}
