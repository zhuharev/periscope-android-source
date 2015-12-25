// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterException;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            TwitterAuthClient

static class callback extends Callback
{

    private final Callback callback;
    private final SessionManager sessionManager;

    public void failure(TwitterException twitterexception)
    {
        ra._mth0454()._mth02CB("Twitter", "Authorization completed with an error", twitterexception);
        callback.failure(twitterexception);
    }

    public void success(Result result)
    {
        ra._mth0454()._mth02BE("Twitter", "Authorization completed successfully");
        sessionManager.setActiveSession((Session)result.data);
        callback.success(result);
    }

    public (SessionManager sessionmanager, Callback callback1)
    {
        sessionManager = sessionmanager;
        callback = callback1;
    }
}
