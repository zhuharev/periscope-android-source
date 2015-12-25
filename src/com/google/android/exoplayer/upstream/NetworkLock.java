// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import java.io.IOException;
import java.util.PriorityQueue;

public final class NetworkLock
{
    public static class PriorityTooLowException extends IOException
    {

        public PriorityTooLowException(int i, int j)
        {
            super((new StringBuilder("Priority too low [priority=")).append(i).append(", highest=").append(j).append("]").toString());
        }
    }


    public static final int DOWNLOAD_PRIORITY = 10;
    public static final int STREAMING_PRIORITY = 0;
    public static final NetworkLock instance = new NetworkLock();
    private int highestPriority;
    private final Object lock = new Object();
    private final PriorityQueue queue = new PriorityQueue();

    private NetworkLock()
    {
        highestPriority = 0x7fffffff;
    }

    public final void add(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        queue.add(Integer.valueOf(i));
        highestPriority = Math.min(highestPriority, i);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void proceed(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        while (highestPriority < i) 
        {
            lock.wait();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean proceedNonBlocking(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        int j = highestPriority;
        boolean flag;
        if (j >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void proceedOrThrow(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (highestPriority < i)
        {
            throw new PriorityTooLowException(i, highestPriority);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void remove(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        queue.remove(Integer.valueOf(i));
        if (queue.isEmpty())
        {
            i = 0x7fffffff;
            break MISSING_BLOCK_LABEL_49;
        }
        i = ((Integer)queue.peek()).intValue();
        highestPriority = i;
        lock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
