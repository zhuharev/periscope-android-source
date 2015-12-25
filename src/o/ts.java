// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package o:
//            tz, tq, tw, rz, 
//            tv, tt, tu, tx

public abstract class ts
    implements tz
{

    protected final Context context;
    protected final ScheduledExecutorService executor;
    protected tx strategy$3c51a58;

    public ts(Context context1, tx tx, tq tq1, ScheduledExecutorService scheduledexecutorservice)
    {
        context = context1.getApplicationContext();
        executor = scheduledexecutorservice;
        strategy$3c51a58 = tx;
        tq1.registerRollOverListener(this);
    }

    public void disable()
    {
        executeAsync(new tw(this));
    }

    protected void executeAsync(Runnable runnable)
    {
        try
        {
            executor.submit(runnable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            rz._mth037A(context, "Failed to submit events task");
        }
    }

    protected void executeSync(Runnable runnable)
    {
        try
        {
            executor.submit(runnable).get();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            rz._mth037A(context, "Failed to run events task");
        }
    }

    public abstract tx getDisabledEventsStrategy$34c68017();

    public void onRollOver(String s)
    {
        executeAsync(new tv(this));
    }

    public void recordEventAsync(Object obj, boolean flag)
    {
        executeAsync(new tt(this, obj, flag));
    }

    public void recordEventSync(Object obj)
    {
        executeSync(new tu(this, obj));
    }
}
