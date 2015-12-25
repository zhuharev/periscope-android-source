// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.LinkedList;
import java.util.concurrent.Executor;

// Referenced classes of package o:
//            so, ss

static final class <init>
    implements Executor
{

    private LinkedList SD;
    private Runnable SE;

    public final void execute(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        SD.offer(new ss(this, runnable));
        if (SE == null)
        {
            _mth14D5();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    protected final void _mth14D5()
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable;
        runnable = (Runnable)SD.poll();
        SE = runnable;
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        so.THREAD_POOL_EXECUTOR.execute(SE);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private Runnable()
    {
        SD = new LinkedList();
    }

    (byte byte0)
    {
        this();
    }
}
