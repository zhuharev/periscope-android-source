// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.localytics.android:
//            InAppDialogFragment, MarketingMessage, JavaScriptClient

final class mActivity extends WebViewClient
{

    private final Activity mActivity;
    final mActivity this$2;

    public final void onPageFinished(WebView webview, String s)
    {
        int i;
        if (((String)InAppDialogFragment.access$200(this._cls2.this.mActivity.mActivity).get("location")).equals("center"))
        {
            i = (int)(this._mth2(_fld2).density * 10F + 0.5F) << 1;
        } else
        {
            i = 0;
        }
        int j = Math.min(this._mth2(_fld2).widthPixels, this._mth2(_fld2).heightPixels);
        int k = Math.max(this._mth2(_fld2).widthPixels, this._mth2(_fld2).heightPixels);
        webview.loadUrl(String.format("javascript:(function() {  var viewportNode = document.createElement('meta');  viewportNode.name    = 'viewport';  viewportNode.content = 'width=%f, height=%f, user-scalable=no, minimum-scale=.25, maximum-scale=1';  viewportNode.id      = 'metatag';  document.getElementsByTagName('head')[0].appendChild(viewportNode);})()", new Object[] {
            Float.valueOf((float)Math.min(j - i, (int)(this._mth2(_fld2) * this._mth2(_fld2).density + 0.5F)) / this._mth2(_fld2).density), Float.valueOf((float)Math.min(k - i, (int)(this._mth2(_fld2) * this._mth2(_fld2).density + 0.5F)) / this._mth2(_fld2).density)
        }));
        webview.loadUrl(InAppDialogFragment.access$1100(_fld2).getJsGlueCode());
        this._mth2(_fld2).setVisibility(0);
        if (InAppDialogFragment.access$1500(_fld2).getAndSet(false))
        {
            _mth2();
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        int i;
        Object obj = new URL(s);
        obj = InAppDialogFragment.access$1600(_fld2, ((URL) (obj)));
        i = ProtocolHandleAction[((ProtocolHandleAction) (obj)).ProtocolHandleAction()];
        boolean flag;
        switch (i)
        {
        case 1: // '\001'
        case 2: // '\002'
            flag = false;
            break;

        default:
            flag = true;
            break;
        }
          goto _L1
_L3:
        flag = true;
_L1:
        if (flag)
        {
            return new WebResourceResponse("text/plain", "UTF-8", null);
        } else
        {
            return super.shouldInterceptRequest(webview, s);
        }
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return handleUrl(s, mActivity) != mActivity;
    }

    (Activity activity)
    {
        this$2 = this._cls2.this;
        super();
        mActivity = activity;
    }
}
