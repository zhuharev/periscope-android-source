// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            SessionProvider

public class AuthRequestQueue
{

    final AtomicBoolean awaitingSession = new AtomicBoolean(true);
    final Queue queue = new ConcurrentLinkedQueue();
    private final SessionProvider sessionProvider;

    public AuthRequestQueue(SessionProvider sessionprovider)
    {
        sessionProvider = sessionprovider;
    }

    public boolean addRequest(Callback callback)
    {
        this;
        JVM INSTR monitorenter ;
        if (callback == null)
        {
            return false;
        }
        Session session;
        if (awaitingSession.get())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        session = getValidSession();
        if (session == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        callback.success(new Result(session, null));
        break MISSING_BLOCK_LABEL_82;
        queue.add(callback);
        awaitingSession.set(true);
        requestAuth();
        break MISSING_BLOCK_LABEL_82;
        queue.add(callback);
        this;
        JVM INSTR monitorexit ;
        return true;
        callback;
        throw callback;
    }

    void flushQueueOnError(TwitterException twitterexception)
    {
        this;
        JVM INSTR monitorenter ;
        awaitingSession.set(false);
        for (; !queue.isEmpty(); ((Callback)queue.poll()).failure(twitterexception)) { }
        this;
        JVM INSTR monitorexit ;
        return;
        twitterexception;
        throw twitterexception;
    }

    void flushQueueOnSuccess(Session session)
    {
        this;
        JVM INSTR monitorenter ;
        awaitingSession.set(false);
        for (; !queue.isEmpty(); ((Callback)queue.poll()).success(new Result(session, null))) { }
        this;
        JVM INSTR monitorexit ;
        return;
        session;
        throw session;
    }

    Session getValidSession()
    {
        Session session = sessionProvider.getActiveSession();
        if (session != null && session.getAuthToken() != null && !session.getAuthToken().isExpired())
        {
            return session;
        } else
        {
            return null;
        }
    }

    void requestAuth()
    {
        sessionProvider.requestAuth(new _cls1());
    }

    public void sessionRestored(Session session)
    {
        this;
        JVM INSTR monitorenter ;
        if (session == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        flushQueueOnSuccess(session);
        this;
        JVM INSTR monitorexit ;
        return;
        if (queue.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        requestAuth();
        this;
        JVM INSTR monitorexit ;
        return;
        awaitingSession.set(false);
        this;
        JVM INSTR monitorexit ;
        return;
        session;
        throw session;
    }

    private class _cls1 extends Callback
    {

        final AuthRequestQueue this$0;

        public void failure(TwitterException twitterexception)
        {
            flushQueueOnError(twitterexception);
        }

        public void success(Result result)
        {
            flushQueueOnSuccess((Session)result.data);
        }

        _cls1()
        {
            this$0 = AuthRequestQueue.this;
            super();
        }
    }

}
