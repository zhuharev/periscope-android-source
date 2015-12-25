// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.FutureTask;

// Referenced classes of package o:
//            _cls1504, _cls1606

static final class order extends FutureTask
    implements Comparable
{

    private final int order;
    private final int priority;

    public final volatile int compareTo(Object obj)
    {
        obj = (ject)obj;
        int j = priority - ((priority) (obj)).priority;
        int i = j;
        if (j == 0)
        {
            i = order - ((order) (obj)).order;
        }
        return i;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof ject)
        {
            obj = (ject)obj;
            return order == ((order) (obj)).order && priority == ((priority) (obj)).priority;
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return priority * 31 + order;
    }

    public ring(Runnable runnable, Object obj, int i)
    {
        super(runnable, obj);
        if (!(runnable instanceof _cls1606))
        {
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        } else
        {
            priority = ((_cls1606)runnable).getPriority();
            order = i;
            return;
        }
    }
}
