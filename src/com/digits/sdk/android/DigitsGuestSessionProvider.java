// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.SessionProvider;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.util.List;

// Referenced classes of package com.digits.sdk.android:
//            DigitsApi, DigitsSession

class DigitsGuestSessionProvider extends SessionProvider
{
    static class GuestAuthCallback extends Callback
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

        GuestAuthCallback(SessionManager sessionmanager, Callback callback1)
        {
            sessionManager = sessionmanager;
            callback = callback1;
        }
    }


    final SessionManager defaultSessionManager;
    final OAuth2Service oAuth2Service;

    DigitsGuestSessionProvider(SessionManager sessionmanager, List list)
    {
        this(sessionmanager, list, new OAuth2Service(TwitterCore.getInstance(), null, new DigitsApi()));
    }

    DigitsGuestSessionProvider(SessionManager sessionmanager, List list, OAuth2Service oauth2service)
    {
        super(list);
        defaultSessionManager = sessionmanager;
        oAuth2Service = oauth2service;
    }

    public void requestAuth(Callback callback)
    {
        oAuth2Service.requestGuestAuthToken(new GuestAuthCallback(defaultSessionManager, callback));
    }
}
