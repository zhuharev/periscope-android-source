// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class _cls1504 extends ThreadPoolExecutor
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private final AtomicInteger ok;
    private final _cls02CB ol;

    public _cls1504(int i)
    {
        this(i, ((_cls02CB) (_cls02CB.op)));
    }

    private _cls1504(int i, int j, long l, TimeUnit timeunit, if if1, _cls02CB _pcls02cb)
    {
        super(i, j, 0L, timeunit, new PriorityBlockingQueue(), if1);
        ok = new AtomicInteger();
        ol = _pcls02cb;
    }

    private _cls1504(int i, _cls02CB _pcls02cb)
    {
        this(i, i, 0L, TimeUnit.MILLISECONDS, new if(), _pcls02cb);
    }

    protected final void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        if (throwable == null && (runnable instanceof Future))
        {
            runnable = (Future)runnable;
            if (runnable.isDone() && !runnable.isCancelled())
            {
                try
                {
                    runnable.get();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Runnable runnable)
                {
                    ol._mth02CA(runnable);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Runnable runnable)
                {
                    ol._mth02CA(runnable);
                }
            }
        }
    }

    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return new _cls02CA(runnable, obj, ok.getAndIncrement());
    }
}
