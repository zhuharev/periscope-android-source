// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            wp

public class wo
{

    public static final wo NONE = new wp();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public wo()
    {
    }

    public wo clearDeadline()
    {
        hasDeadline = false;
        return this;
    }

    public wo clearTimeout()
    {
        timeoutNanos = 0L;
        return this;
    }

    public final wo deadline(long l, TimeUnit timeunit)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("duration <= 0: ")).append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            return deadlineNanoTime(System.nanoTime() + timeunit.toNanos(l));
        }
    }

    public long deadlineNanoTime()
    {
        if (!hasDeadline)
        {
            throw new IllegalStateException("No deadline");
        } else
        {
            return deadlineNanoTime;
        }
    }

    public wo deadlineNanoTime(long l)
    {
        hasDeadline = true;
        deadlineNanoTime = l;
        return this;
    }

    public boolean hasDeadline()
    {
        return hasDeadline;
    }

    public void throwIfReached()
    {
        if (Thread.interrupted())
        {
            throw new InterruptedIOException();
        }
        if (hasDeadline && System.nanoTime() > deadlineNanoTime)
        {
            throw new IOException("deadline reached");
        } else
        {
            return;
        }
    }

    public wo timeout(long l, TimeUnit timeunit)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("timeout < 0: ")).append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            timeoutNanos = timeunit.toNanos(l);
            return this;
        }
    }

    public long timeoutNanos()
    {
        return timeoutNanos;
    }

}
