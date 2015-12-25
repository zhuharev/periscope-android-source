// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package o:
//            tz, _cls0997, ra, rl, 
//            _cls06C2, _cls071A, ri, uj, 
//            _cls148E, _cls072A, _cls14AE, _cls068B

public final class _cls0692
    implements tz
{

    final Context context;
    final ScheduledExecutorService executor;
    final ri kit;
    final uj sA;
    _cls148E sB;
    final _cls072A sy;
    final _cls14AE sz;

    private _cls0692(ri ri, Context context1, _cls072A _pcls072a, _cls14AE _pcls14ae, uj uj, ScheduledExecutorService scheduledexecutorservice)
    {
        sB = new _cls0997();
        kit = ri;
        context = context1;
        sy = _pcls072a;
        sz = _pcls14ae;
        sA = uj;
        executor = scheduledexecutorservice;
    }

    public _cls0692(_cls068B _pcls068b, Context context1, _cls072A _pcls072a, _cls14AE _pcls14ae, uj uj)
    {
        this(((ri) (_pcls068b)), context1, _pcls072a, _pcls14ae, uj, _cls141D.if._mth02CA("Answers Events Handler"));
    }

    void executeAsync(Runnable runnable)
    {
        try
        {
            executor.submit(runnable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to submit events task", runnable);
        }
    }

    public final void onRollOver(String s)
    {
        s = new _cls06C2(this);
        try
        {
            executor.submit(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to submit events task", s);
        }
    }

    void _mth02CA(_cls071A _pcls071a)
    {
        try
        {
            executor.submit(_pcls071a).get();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls071A _pcls071a)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to run events task", _pcls071a);
        }
    }

    public final void _mth02CA(_cls1491.if if1)
    {
        executeAsync(new _cls071A(this, if1, false));
    }

    public final void _mth02CA(_cls1491.if if1, boolean flag, boolean flag1)
    {
        if1 = new _cls071A(this, if1, flag1);
        if (flag)
        {
            _mth02CA(((_cls071A) (if1)));
            return;
        }
        try
        {
            executor.submit(if1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls1491.if if1)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to submit events task", if1);
        }
    }
}
