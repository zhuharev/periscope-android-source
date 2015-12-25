// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package o:
//            _cls1504, _cls1528

public static final class om
    implements ThreadFactory
{

    private int om;

    public final Thread newThread(Runnable runnable)
    {
        runnable = new _cls1528(this, runnable, (new StringBuilder("fifo-pool-thread-")).append(om).toString());
        om = om + 1;
        return runnable;
    }

    public Thread()
    {
        om = 0;
    }
}
