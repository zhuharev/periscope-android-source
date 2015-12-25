// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.webkit.WebView;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            OAuthWebViewClient, WebViewException

static interface 
{

    public abstract void onError(WebViewException webviewexception);

    public abstract void onPageFinished(WebView webview, String s);

    public abstract void onSuccess(Bundle bundle);
}
