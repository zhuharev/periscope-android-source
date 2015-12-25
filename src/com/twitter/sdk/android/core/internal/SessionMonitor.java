// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import o.qy;
import o.sc;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            SessionVerifier

public class SessionMonitor
{
    public static class MonitorState
    {

        private static final long TIME_THRESHOLD_IN_MILLIS = 0x1499700L;
        public long lastVerification;
        private final Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        public boolean verifying;

        private boolean isOnSameDate(long l, long l1)
        {
            utcCalendar.setTimeInMillis(l);
            int i = utcCalendar.get(6);
            int j = utcCalendar.get(1);
            utcCalendar.setTimeInMillis(l1);
            int k = utcCalendar.get(6);
            int i1 = utcCalendar.get(1);
            return i == k && j == i1;
        }

        public boolean beginVerification(long l)
        {
            this;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            boolean flag1;
            if (l - lastVerification > 0x1499700L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!isOnSameDate(l, lastVerification))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (verifying || !flag && !flag1)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            verifying = true;
            this;
            JVM INSTR monitorexit ;
            return true;
            this;
            JVM INSTR monitorexit ;
            return false;
            exception;
            throw exception;
        }

        public void endVerification(long l)
        {
            this;
            JVM INSTR monitorenter ;
            verifying = false;
            lastVerification = l;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public MonitorState()
        {
        }
    }


    private final ExecutorService executorService;
    protected final MonitorState monitorState;
    private final SessionManager sessionManager;
    private final SessionVerifier sessionVerifier;
    private final sc time$7caa7ea8;

    public SessionMonitor(SessionManager sessionmanager, ExecutorService executorservice, SessionVerifier sessionverifier)
    {
        this(sessionmanager, new sc(), executorservice, new MonitorState(), sessionverifier);
    }

    SessionMonitor(SessionManager sessionmanager, sc sc1, ExecutorService executorservice, MonitorState monitorstate, SessionVerifier sessionverifier)
    {
        time$7caa7ea8 = sc1;
        sessionManager = sessionmanager;
        executorService = executorservice;
        monitorState = monitorstate;
        sessionVerifier = sessionverifier;
    }

    public void monitorActivityLifecycle(qy qy1)
    {
        _cls1 _lcls1 = new _cls1();
        if (qy1.Qy != null)
        {
            if (!qy1.Qy._mth02CB(_lcls1));
        }
    }

    public void triggerVerificationIfNecessary()
    {
        Session session = sessionManager.getActiveSession();
        long l = time$7caa7ea8.getCurrentTimeMillis();
        boolean flag;
        if (session != null && monitorState.beginVerification(l))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            executorService.submit(new _cls2());
        }
    }

    protected void verifyAll()
    {
        Session session;
        for (Iterator iterator = sessionManager.getSessionMap().values().iterator(); iterator.hasNext(); sessionVerifier.verifySession(session))
        {
            session = (Session)iterator.next();
        }

        monitorState.endVerification(time$7caa7ea8.getCurrentTimeMillis());
    }

    private class _cls1 extends o.qy._cls02CA
    {

        final SessionMonitor this$0;

        public void onActivityStarted(Activity activity)
        {
            triggerVerificationIfNecessary();
        }

        _cls1()
        {
            this$0 = SessionMonitor.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final SessionMonitor this$0;

        public void run()
        {
            verifyAll();
        }

        _cls2()
        {
            this$0 = SessionMonitor.this;
            super();
        }
    }

}
