// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            tg, tl, tk, th, 
//            tm

public final class tj extends tg
    implements Runnable
{

    private final AtomicReference Te = new AtomicReference();
    private final tm executor;
    private tl sU;
    private final Callable task;

    public tj(Callable callable, tl tl1, tm tm1)
    {
        task = callable;
        sU = tl1;
        executor = tm1;
    }

    public final void run()
    {
        if (isDone() || !Te.compareAndSet(null, Thread.currentThread()))
        {
            return;
        }
        _mth1D55(task.call());
        Te.getAndSet(null);
        return;
        Object obj;
        obj;
        if (sU.Tg.FE7C(sU.Tf))
        {
            long l = sU.sR._mth1D65(sU.Tf);
            obj = sU;
            sU = new tl(((tl) (obj)).Tf + 1, ((tl) (obj)).sR, ((tl) (obj)).Tg);
            executor.schedule(this, l, TimeUnit.MILLISECONDS);
            break MISSING_BLOCK_LABEL_139;
        }
        _mth02CF(((Throwable) (obj)));
        Te.getAndSet(null);
        return;
        obj;
        Te.getAndSet(null);
        throw obj;
    }

    protected final void _mth1526()
    {
        Thread thread = (Thread)Te.getAndSet(null);
        if (thread != null)
        {
            thread.interrupt();
        }
    }
}
