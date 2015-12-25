// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import java.util.Iterator;
import java.util.List;

public abstract class SessionProvider
{

    private final List sessionManagers;

    public SessionProvider(List list)
    {
        sessionManagers = list;
    }

    public Session getActiveSession()
    {
        Session session = null;
        Iterator iterator = sessionManagers.iterator();
        Session session1;
        do
        {
            session1 = session;
            if (!iterator.hasNext())
            {
                break;
            }
            session = ((SessionManager)iterator.next()).getActiveSession();
            session1 = session;
        } while (session == null);
        return session1;
    }

    public abstract void requestAuth(Callback callback);
}
