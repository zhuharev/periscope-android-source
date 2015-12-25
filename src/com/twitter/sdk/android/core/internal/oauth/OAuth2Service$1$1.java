// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            GuestAuthToken, OAuth2Token, GuestTokenResponse

class val.appAuthToken extends Callback
{

    final l.callback this$1;
    final OAuth2Token val$appAuthToken;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterexception);
        callback.failure(twitterexception);
    }

    public void success(Result result)
    {
        result = new GuestAuthToken(val$appAuthToken.getTokenType(), val$appAuthToken.getAccessToken(), ((GuestTokenResponse)result.data).guestToken);
        callback.success(new Result(result, null));
    }

    ()
    {
        this$1 = final_;
        val$appAuthToken = OAuth2Token.this;
        super();
    }
}
