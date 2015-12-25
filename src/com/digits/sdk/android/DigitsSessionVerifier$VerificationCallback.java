// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.digits.sdk.android:
//            DigitsSessionVerifier, VerifyAccountResponse, DigitsSession, SessionListener

static class sessionManager extends Callback
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

    (ConcurrentHashMap concurrenthashmap, SessionManager sessionmanager)
    {
        sessionListenerMap = concurrenthashmap;
        sessionManager = sessionmanager;
    }
}
