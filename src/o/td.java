// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            su, te, tc, ta

public final class td extends ThreadPoolExecutor
{
    public static final class if
        implements ThreadFactory
    {

        private final int SZ = 10;

        public final Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable);
            runnable.setPriority(SZ);
            runnable.setName("Queue");
            return runnable;
        }

        public if(int i)
        {
        }
    }


    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int MAXIMUM_POOL_SIZE;

    private td(int i, int j, long l, TimeUnit timeunit, su su1, if if1)
    {
        super(i, j, 1L, timeunit, su1, if1);
        prestartAllCoreThreads();
    }

    public static td _mth1503()
    {
        return new td(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, new su(), new if(10));
    }

    protected final void afterExecute(Runnable runnable, Throwable throwable)
    {
        te te1 = (te)runnable;
        te1._mth02B2(true);
        te1._mth02CE(throwable);
        ((su)super.getQueue())._mth14FE();
        super.afterExecute(runnable, throwable);
    }

    public final void execute(Runnable runnable)
    {
        if (tc._mth1540(runnable))
        {
            super.execute(runnable);
            return;
        } else
        {
            super.execute(newTaskFor(runnable, null));
            return;
        }
    }

    public final volatile BlockingQueue getQueue()
    {
        return (su)super.getQueue();
    }

    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return new ta(runnable, obj);
    }

    protected final RunnableFuture newTaskFor(Callable callable)
    {
        return new ta(callable);
    }

    static 
    {
        int i = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = i;
        CORE_POOL_SIZE = i + 1;
        MAXIMUM_POOL_SIZE = (CPU_COUNT << 1) + 1;
    }
}
