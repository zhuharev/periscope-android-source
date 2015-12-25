// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            ShareEmailController

class this._cls0 extends Callback
{

    final ShareEmailController this$0;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Failed to get email address.", twitterexception);
        sendResultCodeError(new TwitterException("Failed to get email address."));
    }

    public void success(Result result)
    {
        handleSuccess((User)result.data);
    }

    ()
    {
        this$0 = ShareEmailController.this;
        super();
    }
}
