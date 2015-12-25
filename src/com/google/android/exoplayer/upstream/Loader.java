// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader
{
    public static interface Callback
    {

        public abstract void onLoadCanceled(Loadable loadable);

        public abstract void onLoadCompleted(Loadable loadable);

        public abstract void onLoadError(Loadable loadable, IOException ioexception);
    }

    final class LoadTask extends Handler
        implements Runnable
    {

        private static final String TAG = "LoadTask";
        private final Callback callback;
        private volatile Thread executorThread;
        private final Loadable loadable;
        final Loader this$0;

        private void onFinished()
        {
            loading = false;
            currentTask = null;
        }

        public final void handleMessage(Message message)
        {
            if (message.what == 2)
            {
                throw (Error)message.obj;
            }
            onFinished();
            if (loadable.isLoadCanceled())
            {
                callback.onLoadCanceled(loadable);
                return;
            }
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                callback.onLoadCompleted(loadable);
                return;

            case 1: // '\001'
                callback.onLoadError(loadable, (IOException)message.obj);
                break;
            }
        }

        public final void quit()
        {
            loadable.cancelLoad();
            if (executorThread != null)
            {
                executorThread.interrupt();
            }
        }

        public final void run()
        {
            InterruptedException interruptedexception;
            try
            {
                executorThread = Thread.currentThread();
                if (!loadable.isLoadCanceled())
                {
                    TraceUtil.beginSection((new StringBuilder()).append(loadable.getClass().getSimpleName()).append(".load()").toString());
                    loadable.load();
                    TraceUtil.endSection();
                }
                sendEmptyMessage(0);
                return;
            }
            catch (IOException ioexception)
            {
                obtainMessage(1, ioexception).sendToTarget();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InterruptedException interruptedexception)
            {
                Assertions.checkState(loadable.isLoadCanceled());
                sendEmptyMessage(0);
                return;
            }
            catch (Exception exception)
            {
                Log.e("LoadTask", "Unexpected exception loading stream", exception);
                obtainMessage(1, new UnexpectedLoaderException(exception)).sendToTarget();
                return;
            }
            catch (Error error)
            {
                Log.e("LoadTask", "Unexpected error loading stream", error);
                obtainMessage(2, error).sendToTarget();
                throw error;
            }
        }

        public LoadTask(Looper looper, Loadable loadable1, Callback callback1)
        {
            this$0 = Loader.this;
            super(looper);
            loadable = loadable1;
            callback = callback1;
        }
    }

    public static interface Loadable
    {

        public abstract void cancelLoad();

        public abstract boolean isLoadCanceled();

        public abstract void load();
    }

    public static final class UnexpectedLoaderException extends IOException
    {

        public UnexpectedLoaderException(Exception exception)
        {
            super((new StringBuilder("Unexpected ")).append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage()).toString(), exception);
        }
    }


    private static final int MSG_END_OF_SOURCE = 0;
    private static final int MSG_FATAL_ERROR = 2;
    private static final int MSG_IO_EXCEPTION = 1;
    private LoadTask currentTask;
    private final ExecutorService downloadExecutorService;
    private boolean loading;

    public Loader(String s)
    {
        downloadExecutorService = Util.newSingleThreadExecutor(s);
    }

    public final void cancelLoading()
    {
        Assertions.checkState(loading);
        currentTask.quit();
    }

    public final boolean isLoading()
    {
        return loading;
    }

    public final void release()
    {
        if (loading)
        {
            cancelLoading();
        }
        downloadExecutorService.shutdown();
    }

    public final void startLoading(Looper looper, Loadable loadable, Callback callback)
    {
        boolean flag;
        if (!loading)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        loading = true;
        currentTask = new LoadTask(looper, loadable, callback);
        downloadExecutorService.submit(currentTask);
    }

    public final void startLoading(Loadable loadable, Callback callback)
    {
        Looper looper = Looper.myLooper();
        boolean flag;
        if (looper != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        startLoading(looper, loadable, callback);
    }


/*
    static boolean access$002(Loader loader, boolean flag)
    {
        loader.loading = flag;
        return flag;
    }

*/


/*
    static LoadTask access$102(Loader loader, LoadTask loadtask)
    {
        loader.currentTask = loadtask;
        return loadtask;
    }

*/
}
