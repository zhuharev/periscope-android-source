// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Call

public final class Dispatcher
{

    private final Deque executedCalls;
    private ExecutorService executorService;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final Deque readyCalls;
    private final Deque runningCalls;

    public Dispatcher()
    {
        maxRequests = 64;
        maxRequestsPerHost = 5;
        readyCalls = new ArrayDeque();
        runningCalls = new ArrayDeque();
        executedCalls = new ArrayDeque();
    }

    public Dispatcher(ExecutorService executorservice)
    {
        maxRequests = 64;
        maxRequestsPerHost = 5;
        readyCalls = new ArrayDeque();
        runningCalls = new ArrayDeque();
        executedCalls = new ArrayDeque();
        executorService = executorservice;
    }

    private void promoteCalls()
    {
        if (runningCalls.size() >= maxRequests)
        {
            return;
        }
        if (readyCalls.isEmpty())
        {
            return;
        }
        for (Iterator iterator = readyCalls.iterator(); iterator.hasNext();)
        {
            Call.AsyncCall asynccall = (Call.AsyncCall)iterator.next();
            if (runningCallsForHost(asynccall) < maxRequestsPerHost)
            {
                iterator.remove();
                runningCalls.add(asynccall);
                getExecutorService().execute(asynccall);
            }
            if (runningCalls.size() >= maxRequests)
            {
                return;
            }
        }

    }

    private int runningCallsForHost(Call.AsyncCall asynccall)
    {
        int i = 0;
        for (Iterator iterator = runningCalls.iterator(); iterator.hasNext();)
        {
            int j = i;
            if (((Call.AsyncCall)iterator.next()).host().equals(asynccall.host()))
            {
                j = i + 1;
            }
            i = j;
        }

        return i;
    }

    public final void cancel(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = readyCalls.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Call.AsyncCall asynccall = (Call.AsyncCall)iterator.next();
            if (Util.equal(obj, asynccall.tag()))
            {
                asynccall.cancel();
            }
        } while (true);
        Iterator iterator1 = runningCalls.iterator();
_L2:
        Object obj1;
        do
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    break MISSING_BLOCK_LABEL_116;
                }
                obj1 = (Call.AsyncCall)iterator1.next();
            } while (!Util.equal(obj, ((Call.AsyncCall) (obj1)).tag()));
            ((Call.AsyncCall) (obj1)).get().canceled = true;
            obj1 = ((Call.AsyncCall) (obj1)).get().engine;
        } while (obj1 == null);
        ((HttpEngine) (obj1)).disconnect();
        if (true) goto _L2; else goto _L1
_L1:
        Iterator iterator2 = executedCalls.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            Call call = (Call)iterator2.next();
            if (Util.equal(obj, call.tag()))
            {
                call.cancel();
            }
        } while (true);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    final void enqueue(Call.AsyncCall asynccall)
    {
        this;
        JVM INSTR monitorenter ;
        if (runningCalls.size() >= maxRequests || runningCallsForHost(asynccall) >= maxRequestsPerHost)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        runningCalls.add(asynccall);
        getExecutorService().execute(asynccall);
        this;
        JVM INSTR monitorexit ;
        return;
        readyCalls.add(asynccall);
        this;
        JVM INSTR monitorexit ;
        return;
        asynccall;
        throw asynccall;
    }

    final void executed(Call call)
    {
        this;
        JVM INSTR monitorenter ;
        executedCalls.add(call);
        this;
        JVM INSTR monitorexit ;
        return;
        call;
        throw call;
    }

    final void finished(Call.AsyncCall asynccall)
    {
        this;
        JVM INSTR monitorenter ;
        if (!runningCalls.remove(asynccall))
        {
            throw new AssertionError("AsyncCall wasn't running!");
        }
        promoteCalls();
        this;
        JVM INSTR monitorexit ;
        return;
        asynccall;
        throw asynccall;
    }

    final void finished(Call call)
    {
        this;
        JVM INSTR monitorenter ;
        if (!executedCalls.remove(call))
        {
            throw new AssertionError("Call wasn't in-flight!");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        call;
        throw call;
    }

    public final ExecutorService getExecutorService()
    {
        this;
        JVM INSTR monitorenter ;
        ExecutorService executorservice;
        if (executorService == null)
        {
            executorService = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        executorservice = executorService;
        this;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getMaxRequests()
    {
        this;
        JVM INSTR monitorenter ;
        int i = maxRequests;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getMaxRequestsPerHost()
    {
        this;
        JVM INSTR monitorenter ;
        int i = maxRequestsPerHost;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final void setMaxRequests(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        throw new IllegalArgumentException((new StringBuilder("max < 1: ")).append(i).toString());
        maxRequests = i;
        promoteCalls();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void setMaxRequestsPerHost(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        throw new IllegalArgumentException((new StringBuilder("max < 1: ")).append(i).toString());
        maxRequestsPerHost = i;
        promoteCalls();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
