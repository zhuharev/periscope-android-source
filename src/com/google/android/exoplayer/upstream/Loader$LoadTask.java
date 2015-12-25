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
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            Loader

final class callback extends Handler
    implements Runnable
{

    private static final String TAG = "LoadTask";
    private final obtainMessage callback;
    private volatile Thread executorThread;
    private final obtainMessage loadable;
    final Loader this$0;

    private void onFinished()
    {
        Loader.access$002(Loader.this, false);
        Loader.access$102(Loader.this, null);
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
            obtainMessage(1, new dLoaderException(exception)).sendToTarget();
            return;
        }
        catch (Error error)
        {
            Log.e("LoadTask", "Unexpected error loading stream", error);
            obtainMessage(2, error).sendToTarget();
            throw error;
        }
    }

    public dLoaderException(Looper looper, dLoaderException dloaderexception, dLoaderException dloaderexception1)
    {
        this$0 = Loader.this;
        super(looper);
        loadable = dloaderexception;
        callback = dloaderexception1;
    }
}
