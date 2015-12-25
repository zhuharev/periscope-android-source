// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.SessionVerifier;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.digits.sdk.android:
//            Digits, DigitsApiClient, DigitsSession, SessionListener, 
//            VerifyAccountResponse

class DigitsSessionVerifier
    implements SessionVerifier
{
    static class VerificationCallback extends Callback
    {

        private final ConcurrentHashMap sessionListenerMap;
        private final SessionManager sessionManager;

        void addSessionListener(SessionListener sessionlistener)
        {
            if (sessionlistener == null)
            {
                throw new NullPointerException("sessionListener must not be null");
            } else
            {
                sessionListenerMap.put(sessionlistener, Boolean.TRUE);
                return;
            }
        }

        public void failure(TwitterException twitterexception)
        {
        }

        public void removeSession(SessionListener sessionlistener)
        {
            if (sessionlistener == null)
            {
                throw new NullPointerException("sessionListener must not be null");
            } else
            {
                sessionListenerMap.remove(sessionlistener);
                return;
            }
        }

        public void success(Result result)
        {
            if (result.data != null)
            {
                result = DigitsSession.create((VerifyAccountResponse)result.data);
                if (result.isValidUser() && !result.equals(sessionManager.getSession(result.getId())))
                {
                    sessionManager.setSession(result.getId(), result);
                    Iterator iterator = sessionListenerMap.keySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        SessionListener sessionlistener = (SessionListener)iterator.next();
                        if (sessionlistener != null)
                        {
                            sessionlistener.changed(result);
                        }
                    } while (true);
                }
            }
        }

        VerificationCallback(ConcurrentHashMap concurrenthashmap, SessionManager sessionmanager)
        {
            sessionListenerMap = concurrenthashmap;
            sessionManager = sessionmanager;
        }
    }


    private final VerificationCallback verificationCallback;

    DigitsSessionVerifier()
    {
        this(new VerificationCallback(new ConcurrentHashMap(), Digits.getSessionManager()));
    }

    DigitsSessionVerifier(VerificationCallback verificationcallback)
    {
        verificationCallback = verificationcallback;
    }

    public void addSessionListener(SessionListener sessionlistener)
    {
        verificationCallback.addSessionListener(sessionlistener);
    }

    DigitsApiClient.AccountService getAccountService(Session session)
    {
        return (new DigitsApiClient(session)).getAccountService();
    }

    public void removeSessionListener(SessionListener sessionlistener)
    {
        verificationCallback.removeSession(sessionlistener);
    }

    public void verifySession(Session session)
    {
        if ((session instanceof DigitsSession) && !((DigitsSession)session).isLoggedOutUser())
        {
            getAccountService(session).verifyAccount(verificationCallback);
        }
    }
}
