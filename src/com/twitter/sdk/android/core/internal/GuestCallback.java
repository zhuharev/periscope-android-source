// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import o.ra;
import o.rl;

public class GuestCallback extends Callback
{

    protected SessionManager appSessionManager;
    protected Callback cb;

    public GuestCallback(Callback callback)
    {
        this(TwitterCore.getInstance(), callback);
    }

    GuestCallback(SessionManager sessionmanager, Callback callback)
    {
        appSessionManager = sessionmanager;
        cb = callback;
    }

    GuestCallback(TwitterCore twittercore, Callback callback)
    {
        this(twittercore.getAppSessionManager(), callback);
    }

    public void failure(TwitterException twitterexception)
    {
        if (twitterexception instanceof TwitterApiException)
        {
            TwitterApiException twitterapiexception = (TwitterApiException)twitterexception;
            int i = twitterapiexception.getErrorCode();
            ra._mth0454()._mth02CB("Twitter", "API call failure.", twitterapiexception);
            if ((i == 89 || i == 239) && appSessionManager != null)
            {
                appSessionManager.clearSession(0L);
            }
        }
        if (cb != null)
        {
            cb.failure(twitterexception);
        }
    }

    public void success(Result result)
    {
        if (cb != null)
        {
            cb.success(result);
        }
    }
}
