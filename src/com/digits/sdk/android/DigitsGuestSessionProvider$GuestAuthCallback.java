// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;

// Referenced classes of package com.digits.sdk.android:
//            DigitsGuestSessionProvider, DigitsSession

static class callback extends Callback
{

    final Callback callback;
    final SessionManager sessionManager;

    public void failure(TwitterException twitterexception)
    {
        if (callback != null)
        {
            callback.failure(twitterexception);
        }
    }

    public void success(Result result)
    {
        DigitsSession digitssession = new DigitsSession((OAuth2Token)result.data);
        sessionManager.setSession(digitssession.getId(), digitssession);
        if (callback != null)
        {
            callback.success(new Result(digitssession, result.response));
        }
    }

    I(SessionManager sessionmanager, Callback callback1)
    {
        sessionManager = sessionmanager;
        callback = callback1;
    }
}
