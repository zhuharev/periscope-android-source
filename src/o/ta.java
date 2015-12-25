// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package o:
//            st, tb, te, tc

public class ta extends FutureTask
    implements st, tb, te
{

    private st SV;

    public ta(Runnable runnable, Object obj)
    {
        super(runnable, obj);
        if (tc._mth1540(runnable))
        {
            runnable = (st)runnable;
        } else
        {
            runnable = new tc();
        }
        SV = runnable;
    }

    public ta(Callable callable)
    {
        super(callable);
        if (tc._mth1540(callable))
        {
            callable = (st)callable;
        } else
        {
            callable = new tc();
        }
        SV = callable;
    }

    public int compareTo(Object obj)
    {
        return ((tb)_mth1502()).compareTo(obj);
    }

    public final Collection getDependencies()
    {
        return ((st)(tb)_mth1502()).getDependencies();
    }

    public final boolean isFinished()
    {
        return ((te)(tb)_mth1502()).isFinished();
    }

    public final void _mth02B2(boolean flag)
    {
        ((te)(tb)_mth1502())._mth02B2(flag);
    }

    public final void _mth02CA(te te1)
    {
        te1 = (te)te1;
        ((st)(tb)_mth1502())._mth02CA(te1);
    }

    public final void _mth02CE(Throwable throwable)
    {
        ((te)(tb)_mth1502())._mth02CE(throwable);
    }

    public final boolean _mth14DA()
    {
        return ((st)(tb)_mth1502())._mth14DA();
    }

    public st _mth1502()
    {
        return (st)SV;
    }

    public final int _mth1FD8()
    {
        return ((tb)_mth1502())._mth1FD8();
    }
}
