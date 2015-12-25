// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            so, st, tb, te, 
//            tc, sw, sy

public abstract class sx extends so
    implements st, tb, te
{
    static final class if
        implements Executor
    {

        final sx ST;
        private final Executor executor;

        public final void execute(Runnable runnable)
        {
            executor.execute(new sy(this, runnable, null));
        }

        public if(ExecutorService executorservice, sx sx1)
        {
            executor = executorservice;
            ST = sx1;
        }
    }


    public final tc SS = new tc();

    public sx()
    {
    }

    public int compareTo(Object obj)
    {
        return sw._mth02CA(this, obj);
    }

    public final Collection getDependencies()
    {
        return ((st)(tb)SS).getDependencies();
    }

    public final boolean isFinished()
    {
        return ((te)(tb)SS).isFinished();
    }

    public final void _mth02B2(boolean flag)
    {
        ((te)(tb)SS)._mth02B2(flag);
    }

    public final transient void _mth02CA(ExecutorService executorservice, Void avoid[])
    {
        super.executeOnExecutor(new if(executorservice, this), avoid);
    }

    public final void _mth02CA(te te1)
    {
        _mth02CB((te)te1);
    }

    public final void _mth02CB(te te1)
    {
        if (getStatus$47668da6() != so._cls02CE.SG)
        {
            throw new IllegalStateException("Must not add Dependency after task is running");
        } else
        {
            ((st)(tb)SS)._mth02CA(te1);
            return;
        }
    }

    public final void _mth02CE(Throwable throwable)
    {
        ((te)(tb)SS)._mth02CE(throwable);
    }

    public final boolean _mth14DA()
    {
        return ((st)(tb)SS)._mth14DA();
    }

    public int _mth1FD8()
    {
        return ((tb)SS)._mth1FD8();
    }
}
