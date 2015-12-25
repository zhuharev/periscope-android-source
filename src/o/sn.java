// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import android.util.Log;

public final class sn
{

    private final String Sx;
    private long duration;
    private long start;
    private final String tag;
    private final boolean ul;

    public sn(String s, String s1)
    {
        Sx = s;
        tag = s1;
        boolean flag;
        if (!Log.isLoggable(s1, 2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ul = flag;
    }

    public final void _mth1490()
    {
        this;
        JVM INSTR monitorenter ;
        if (!ul)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        start = SystemClock.elapsedRealtime();
        duration = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth14D3()
    {
        this;
        JVM INSTR monitorenter ;
        if (!ul)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (duration == 0L)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        duration = SystemClock.elapsedRealtime() - start;
        Log.v(tag, (new StringBuilder()).append(Sx).append(": ").append(duration).append("ms").toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
