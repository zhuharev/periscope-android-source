// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            sp, sq, sr

public abstract class so
{
    static final class if
    {

        final so SB;
        final Object SC[];

        transient if(so so1, Object aobj[])
        {
            SB = so1;
            SC = aobj;
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor defaultExecutor;
    private static final _cls02CA handler = new _cls02CA();
    private static final BlockingQueue poolWorkQueue;
    private static final ThreadFactory threadFactory;
    private final AtomicBoolean cancelled = new AtomicBoolean();
    private final FutureTask future;
    private volatile int status$13d31845;
    private final AtomicBoolean taskInvoked = new AtomicBoolean();
    private final _cls02CF worker = new sq(this);

    public so()
    {
        status$13d31845 = _cls02CE.SG;
        future = new sr(this, worker);
    }

    public static void execute(Runnable runnable)
    {
        defaultExecutor.execute(runnable);
    }

    private void finish(Object obj)
    {
        if (isCancelled())
        {
            onCancelled(obj);
        } else
        {
            onPostExecute(obj);
        }
        status$13d31845 = _cls02CE.SI;
    }

    public static void init()
    {
        handler.getLooper();
    }

    private Object postResult(Object obj)
    {
        handler.obtainMessage(1, new if(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj)
    {
        if (!taskInvoked.get())
        {
            postResult(obj);
        }
    }

    public static void setDefaultExecutor(Executor executor)
    {
        defaultExecutor = executor;
    }

    public final boolean cancel(boolean flag)
    {
        cancelled.set(true);
        return future.cancel(flag);
    }

    public transient abstract Object doInBackground(Object aobj[]);

    public final transient so execute(Object aobj[])
    {
        return executeOnExecutor(defaultExecutor, aobj);
    }

    public final transient so executeOnExecutor(Executor executor, Object aobj[])
    {
        static final class _cls1
        {

            static final int SA[];

            static 
            {
                SA = new int[_cls02CE._mth14D7().length];
                int ai[];
                ai = SA;
                int i = _cls02CE.SH;
                ai[1] = 1;
_L2:
                ai = SA;
                int j = _cls02CE.SI;
                ai[2] = 2;
                break MISSING_BLOCK_LABEL_39;
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                if (true) goto _L2; else goto _L1
_L1:
                nosuchfielderror;
            }
        }

        if (status$13d31845 != _cls02CE.SG)
        {
            switch (_cls1.SA[status$13d31845 - 1])
            {
            case 1: // '\001'
                throw new IllegalStateException("Cannot execute task: the task is already running.");

            case 2: // '\002'
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        status$13d31845 = _cls02CE.SH;
        onPreExecute();
        worker.SK = aobj;
        executor.execute(future);
        return this;
    }

    public final Object get()
    {
        return future.get();
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return future.get(l, timeunit);
    }

    public final int getStatus$47668da6()
    {
        return status$13d31845;
    }

    public final boolean isCancelled()
    {
        return cancelled.get();
    }

    protected void onCancelled()
    {
    }

    public void onCancelled(Object obj)
    {
        onCancelled();
    }

    public void onPostExecute(Object obj)
    {
    }

    public void onPreExecute()
    {
    }

    protected transient void onProgressUpdate(Object aobj[])
    {
    }

    protected final transient void publishProgress(Object aobj[])
    {
        if (!isCancelled())
        {
            handler.obtainMessage(2, new if(this, aobj)).sendToTarget();
        }
    }

    static 
    {
        int i = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = i;
        CORE_POOL_SIZE = i + 1;
        MAXIMUM_POOL_SIZE = (CPU_COUNT << 1) + 1;
        threadFactory = new sp();
        poolWorkQueue = new LinkedBlockingQueue(128);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, poolWorkQueue, threadFactory);
        SERIAL_EXECUTOR = new _cls02CB((byte)0);
        defaultExecutor = SERIAL_EXECUTOR;
    }




}
