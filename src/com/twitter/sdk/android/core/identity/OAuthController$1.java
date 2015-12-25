// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            OAuthController, OAuthWebViewClient, OAuthWebChromeClient

class this._cls0 extends Callback
{

    final OAuthController this$0;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Failed to get request token", twitterexception);
        handleAuthError(1, new TwitterAuthException("Failed to get request token"));
    }

    public void success(Result result)
    {
        requestToken = ((OAuthResponse)result.data).authToken;
        result = OAuthController.access$000(OAuthController.this).getAuthorizeUrl(requestToken);
        ra._mth0454()._mth02BE("Twitter", "Redirecting user to web view to complete authorization flow");
        setUpWebView(OAuthController.access$100(OAuthController.this), new OAuthWebViewClient(OAuthController.access$000(OAuthController.this).buildCallbackUrl(OAuthController.access$200(OAuthController.this)), OAuthController.this), result, new OAuthWebChromeClient());
    }

    nt()
    {
        this$0 = OAuthController.this;
        super();
    }
}
