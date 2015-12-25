// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class cj
{
    static final class if
        implements ThreadFactory
    {

        private final ThreadFactory BD;
        private AtomicInteger BE;

        public final Thread newThread(Runnable runnable)
        {
            runnable = BD.newThread(runnable);
            runnable.setName((new StringBuilder("GAC_Executor[")).append(BE.getAndIncrement()).append("]").toString());
            return runnable;
        }

        private if()
        {
            BD = Executors.defaultThreadFactory();
            BE = new AtomicInteger(0);
        }

        if(byte byte0)
        {
            this();
        }
    }


    private static final ExecutorService BB = Executors.newFixedThreadPool(2, new if((byte)0));

    public static ExecutorService FF72()
    {
        return BB;
    }

}
