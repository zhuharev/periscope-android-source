// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import java.util.Calendar;
import java.util.TimeZone;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            SessionMonitor

public static class 
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

    public ()
    {
    }
}
