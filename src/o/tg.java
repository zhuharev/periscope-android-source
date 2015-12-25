// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class tg
    implements Future
{
    static final class if extends AbstractQueuedSynchronizer
    {

        private Throwable Tb;
        private Object value;

        Object getValue()
        {
            int i = getState();
            switch (i)
            {
            case 2: // '\002'
                if (Tb != null)
                {
                    throw new ExecutionException(Tb);
                } else
                {
                    return value;
                }

            case 4: // '\004'
            case 8: // '\b'
                Throwable throwable = Tb;
                CancellationException cancellationexception = new CancellationException("Task was cancelled.");
                cancellationexception.initCause(throwable);
                throw cancellationexception;
            }
            throw new IllegalStateException((new StringBuilder("Error, synchronizer in invalid state: ")).append(i).toString());
        }

        final boolean isCancelled()
        {
            return (getState() & 0xc) != 0;
        }

        final boolean isDone()
        {
            return (getState() & 0xe) != 0;
        }

        protected final int tryAcquireShared(int i)
        {
            if ((getState() & 0xe) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i == 0 ? -1 : 1;
        }

        protected final boolean tryReleaseShared(int i)
        {
            setState(i);
            return true;
        }

        boolean _mth02CA(Object obj, Throwable throwable, int i)
        {
            boolean flag = compareAndSetState(0, 1);
            if (flag)
            {
                value = obj;
                if ((i & 0xc) != 0)
                {
                    throwable = new CancellationException("Future.cancel() was called.");
                }
                Tb = throwable;
                releaseShared(i);
                return flag;
            }
            if (getState() == 1)
            {
                acquireShared(-1);
            }
            return flag;
        }

        if()
        {
        }
    }


    private final if Ta = new if();

    protected tg()
    {
    }

    public boolean cancel(boolean flag)
    {
        if if1 = Ta;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 4;
        }
        if (!if1._mth02CA(null, null, byte0))
        {
            return false;
        }
        if (flag)
        {
            _mth1526();
        }
        return true;
    }

    public Object get()
    {
        if if1 = Ta;
        if1.acquireSharedInterruptibly(-1);
        return if1.getValue();
    }

    public Object get(long l, TimeUnit timeunit)
    {
        if if1 = Ta;
        if (!if1.tryAcquireSharedNanos(-1, timeunit.toNanos(l)))
        {
            throw new TimeoutException("Timeout waiting for task.");
        } else
        {
            return if1.getValue();
        }
    }

    public boolean isCancelled()
    {
        return Ta.isCancelled();
    }

    public boolean isDone()
    {
        return Ta.isDone();
    }

    protected final boolean _mth02CF(Throwable throwable)
    {
        return Ta._mth02CA(null, throwable, 2);
    }

    protected void _mth1526()
    {
    }

    protected final boolean _mth1D55(Object obj)
    {
        return Ta._mth02CA(obj, null, 2);
    }
}
