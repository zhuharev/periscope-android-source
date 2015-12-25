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
//            OAuth2Token, OAuth2Service

class val.callback extends Callback
{

    final OAuth2Service this$0;
    final Callback val$callback;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Failed to get app auth token", twitterexception);
        if (val$callback != null)
        {
            val$callback.failure(twitterexception);
        }
    }

    public void success(final Result appAuthToken)
    {
        appAuthToken = (OAuth2Token)appAuthToken.data;
        class _cls1 extends Callback
        {

            final OAuth2Service._cls1 this$1;
            final OAuth2Token val$appAuthToken;

            public void failure(TwitterException twitterexception)
            {
                ra._mth0454()._mth02CB("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterexception);
                callback.failure(twitterexception);
            }

            public void success(Result result)
            {
                result = new GuestAuthToken(appAuthToken.getTokenType(), appAuthToken.getAccessToken(), ((GuestTokenResponse)result.data).guestToken);
                callback.success(new Result(result, null));
            }

            _cls1()
            {
                this$1 = OAuth2Service._cls1.this;
                appAuthToken = oauth2token;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        requestGuestToken(_lcls1, appAuthToken);
    }

    _cls1()
    {
        this$0 = final_oauth2service;
        val$callback = Callback.this;
        super();
    }
}
