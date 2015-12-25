// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            ra, rl, FEA3, FEE1

public final class FE94
{

    private final ExecutorService executorService;

    public FE94(ExecutorService executorservice)
    {
        executorService = executorservice;
    }

    final Object _mth02CA(Callable callable)
    {
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        callable = ((Callable) (executorService.submit(callable).get(4L, TimeUnit.SECONDS)));
        return callable;
        try
        {
            callable = ((Callable) (executorService.submit(callable).get()));
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "Failed to execute task.", callable);
            return null;
        }
        return callable;
    }

    public final Future _mth02CA(Runnable runnable)
    {
        try
        {
            runnable = executorService.submit(new FEA3(this, runnable));
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
        return runnable;
    }

    public final Future _mth02CB(Callable callable)
    {
        try
        {
            callable = executorService.submit(new FEE1(this, callable));
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
        return callable;
    }
}
