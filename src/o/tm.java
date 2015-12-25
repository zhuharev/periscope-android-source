// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package o:
//            tk, th, ti

public final class tm extends ScheduledThreadPoolExecutor
{

    public final tk Tg;
    public final th sR;

    private tm(int i, ThreadFactory threadfactory, tk tk, th th)
    {
        super(i, threadfactory);
        if (tk == null)
        {
            throw new NullPointerException("retry policy must not be null");
        }
        if (th == null)
        {
            throw new NullPointerException("backoff must not be null");
        } else
        {
            Tg = tk;
            sR = th;
            return;
        }
    }

    public tm(int i, tk tk, ti ti)
    {
        this(2, Executors.defaultThreadFactory(), tk, ((th) (ti)));
    }
}
