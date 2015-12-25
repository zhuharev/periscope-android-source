// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import o.up;
import o.uq;
import o.ur;

// Referenced classes of package com.twitter.sdk.android.core:
//            SessionManager, Session

public class PersistedSessionManager
    implements SessionManager
{

    private static final int NUM_SESSIONS = 1;
    private final AtomicReference activeSessionRef;
    private final uq activeSessionStorage;
    private final String prefKeySession;
    private final up preferenceStore;
    private volatile boolean restorePending;
    private final ur serializer;
    private final ConcurrentHashMap sessionMap;
    private final ConcurrentHashMap storageMap;

    public PersistedSessionManager(up up1, ur ur1, String s, String s1)
    {
        this(up1, ur1, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new uq(up1, ur1, s), s1);
    }

    PersistedSessionManager(up up1, ur ur1, ConcurrentHashMap concurrenthashmap, ConcurrentHashMap concurrenthashmap1, uq uq1, String s)
    {
        restorePending = true;
        preferenceStore = up1;
        serializer = ur1;
        sessionMap = concurrenthashmap;
        storageMap = concurrenthashmap1;
        activeSessionStorage = uq1;
        activeSessionRef = new AtomicReference();
        prefKeySession = s;
    }

    private void internalSetSession(long l, Session session, boolean flag)
    {
        Object obj;
        sessionMap.put(Long.valueOf(l), session);
        uq uq1 = (uq)storageMap.get(Long.valueOf(l));
        obj = uq1;
        if (uq1 == null)
        {
            obj = new uq(preferenceStore, serializer, getPrefKey(l));
            storageMap.putIfAbsent(Long.valueOf(l), obj);
        }
        ((uq) (obj))._mth02CA(session);
        obj = (Session)activeSessionRef.get();
        if (obj != null && ((Session) (obj)).getId() != l && !flag)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        this;
        JVM INSTR monitorenter ;
        activeSessionRef.compareAndSet(obj, session);
        activeSessionStorage._mth02CA(session);
        this;
        JVM INSTR monitorexit ;
        return;
        session;
        throw session;
    }

    private void restoreActiveSession()
    {
        Object obj = activeSessionStorage;
        SharedPreferences sharedpreferences = ((uq) (obj)).TV._mth1E97();
        obj = (Session)((uq) (obj)).serializer.deserialize(sharedpreferences.getString(((uq) (obj)).key, null));
        if (obj != null)
        {
            internalSetSession(((Session) (obj)).getId(), ((Session) (obj)), false);
        }
    }

    private void restoreAllSessions()
    {
        this;
        JVM INSTR monitorenter ;
        if (restorePending)
        {
            restoreActiveSession();
            restoreSessions();
            restorePending = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void restoreSessions()
    {
        Iterator iterator = preferenceStore._mth1E97().getAll().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            if (isSessionPreferenceKey((String)((java.util.Map.Entry) (obj)).getKey()))
            {
                obj = (Session)serializer.deserialize((String)((java.util.Map.Entry) (obj)).getValue());
                if (obj != null)
                {
                    internalSetSession(((Session) (obj)).getId(), ((Session) (obj)), false);
                }
            }
        } while (true);
    }

    public void clearActiveSession()
    {
        restoreAllSessionsIfNecessary();
        if (activeSessionRef.get() != null)
        {
            clearSession(((Session)activeSessionRef.get()).getId());
        }
    }

    public void clearSession(long l)
    {
        restoreAllSessionsIfNecessary();
        if (activeSessionRef.get() == null || ((Session)activeSessionRef.get()).getId() != l)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        this;
        JVM INSTR monitorenter ;
        activeSessionRef.set(null);
        uq uq1 = activeSessionStorage;
        uq1.TV.edit().remove(uq1.key).commit();
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_79;
        Exception exception;
        exception;
        throw exception;
        sessionMap.remove(Long.valueOf(l));
        uq uq2 = (uq)storageMap.remove(Long.valueOf(l));
        if (uq2 != null)
        {
            uq2.TV.edit().remove(uq2.key).commit();
        }
        return;
    }

    public Session getActiveSession()
    {
        restoreAllSessionsIfNecessary();
        return (Session)activeSessionRef.get();
    }

    String getPrefKey(long l)
    {
        return (new StringBuilder()).append(prefKeySession).append("_").append(l).toString();
    }

    public Session getSession(long l)
    {
        restoreAllSessionsIfNecessary();
        return (Session)sessionMap.get(Long.valueOf(l));
    }

    public Map getSessionMap()
    {
        restoreAllSessionsIfNecessary();
        return Collections.unmodifiableMap(sessionMap);
    }

    boolean isSessionPreferenceKey(String s)
    {
        return s.startsWith(prefKeySession);
    }

    void restoreAllSessionsIfNecessary()
    {
        if (restorePending)
        {
            restoreAllSessions();
        }
    }

    public void setActiveSession(Session session)
    {
        if (session == null)
        {
            throw new IllegalArgumentException("Session must not be null!");
        } else
        {
            restoreAllSessionsIfNecessary();
            internalSetSession(session.getId(), session, true);
            return;
        }
    }

    public void setSession(long l, Session session)
    {
        if (session == null)
        {
            throw new IllegalArgumentException("Session must not be null!");
        } else
        {
            restoreAllSessionsIfNecessary();
            internalSetSession(l, session, false);
            return;
        }
    }
}
