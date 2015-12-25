// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            OAuthController

class this._cls0 extends Callback
{

    final OAuthController this$0;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Failed to get access token", twitterexception);
        handleAuthError(1, new TwitterAuthException("Failed to get access token"));
    }

    public void success(Result result)
    {
        Intent intent = new Intent();
        result = (OAuthResponse)result.data;
        intent.putExtra("screen_name", ((OAuthResponse) (result)).userName);
        intent.putExtra("user_id", ((OAuthResponse) (result)).userId);
        intent.putExtra("tk", ((OAuthResponse) (result)).authToken.token);
        intent.putExtra("ts", ((OAuthResponse) (result)).authToken.secret);
        listener.onComplete(-1, intent);
    }

    stener()
    {
        this$0 = OAuthController.this;
        super();
    }
}
