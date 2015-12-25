// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, LocalyticsDao, BaseProvider, ReflectionUtils

abstract class BaseHandler extends Handler
{
    public static interface BaseListener
    {
    }

    abstract class ListenersSet extends HashSet
    {

        final BaseHandler this$0;

        void callListeners(String s, Class aclass[], Object aobj[])
        {
            this;
            JVM INSTR monitorenter ;
            BaseHandler basehandler = BaseHandler.this;
            basehandler;
            JVM INSTR monitorenter ;
            Iterator iterator;
            queuePriorityMessages = true;
            iterator = iterator();
_L1:
            Object obj;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_60;
            }
            obj = iterator.next();
            try
            {
                ReflectionUtils.tryInvokeInstance(obj, s, aclass, aobj);
            }
            catch (Exception exception) { }
              goto _L1
            queuePriorityMessages = false;
            basehandler;
            JVM INSTR monitorexit ;
            return;
            s;
            throw s;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        ListenersSet()
        {
            this$0 = BaseHandler.this;
            super();
        }
    }


    private static final int MESSAGE_GET_VALUE = 2;
    static final int MESSAGE_INIT = 1;
    private static final int MESSAGE_UPLOAD = 3;
    static final int MESSAGE_UPLOAD_CALLBACK = 4;
    private static final String UPLOAD_WAKE_LOCK = "UPLOAD_WAKE_LOCK";
    protected boolean doesRetry;
    ListenersSet listeners;
    LocalyticsDao mLocalyticsDao;
    BaseProvider mProvider;
    private android.os.PowerManager.WakeLock mWakeLock;
    private int maxRowToUpload;
    private int numberOfRetries;
    private boolean queuePriorityMessages;
    protected boolean shouldProcessPendingUploadMessage;
    String siloName;
    private BaseUploadThread uploadThread;

    BaseHandler(LocalyticsDao localyticsdao, Looper looper)
    {
        super(looper);
        maxRowToUpload = 0;
        numberOfRetries = 0;
        queuePriorityMessages = false;
        uploadThread = null;
        shouldProcessPendingUploadMessage = false;
        doesRetry = true;
        mLocalyticsDao = localyticsdao;
    }

    private FutureTask getFuture(Callable callable)
    {
        callable = new FutureTask(callable);
        queueMessage(obtainMessage(2, callable));
        return callable;
    }

    private Object getType(Callable callable, Object obj)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new RuntimeException("Cannot be called on the main thread.");
        } else
        {
            return getFutureTaskValue(getFuture(callable), obj);
        }
    }

    protected abstract void _deleteUploadedData(int i);

    protected abstract TreeMap _getDataToUpload();

    protected abstract int _getMaxRowToUpload();

    abstract void _init();

    protected abstract void _onUploadCompleted(String s);

    void _upload(boolean flag, String s)
    {
        if (maxRowToUpload != 0 && uploadThread != null && !uploadThread.isAlive())
        {
            maxRowToUpload = 0;
            uploadThread = null;
        }
        int i = _getMaxRowToUpload();
        if (flag && maxRowToUpload != 0 && !shouldProcessPendingUploadMessage)
        {
            maxRowToUpload = i;
            Localytics.Log.d(String.format("Already uploading %s", new Object[] {
                siloName.toLowerCase()
            }));
            return;
        }
        TreeMap treemap;
        try
        {
            treemap = _getDataToUpload();
            if (treemap.size() == 0)
            {
                maxRowToUpload = 0;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Localytics.Log.w("Error occurred during upload", s);
            maxRowToUpload = 0;
            return;
        }
        shouldProcessPendingUploadMessage = false;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        maxRowToUpload = i;
        enterWakeLock();
        s = getUploadThread(treemap, s);
        uploadThread = s;
        s.start();
        return;
    }

    protected void _uploadCallback(int i, String s)
    {
        String s1 = uploadThread.customerID;
        uploadThread = null;
        if (i > 0)
        {
            _deleteUploadedData(i);
            numberOfRetries = 0;
        } else
        {
            numberOfRetries = numberOfRetries + 1;
        }
        if (!doesRetry || i == maxRowToUpload || numberOfRetries > 3)
        {
            if (i == maxRowToUpload)
            {
                _onUploadCompleted(s);
            }
            numberOfRetries = 0;
            maxRowToUpload = 0;
            exitWakeLock();
            return;
        } else
        {
            shouldProcessPendingUploadMessage = true;
            upload(false, 10000L, s1);
            return;
        }
    }

    void addListener(BaseListener baselistener)
    {
        ListenersSet listenersset = listeners;
        listenersset;
        JVM INSTR monitorenter ;
        listeners.add(baselistener);
        listenersset;
        JVM INSTR monitorexit ;
        return;
        baselistener;
        throw baselistener;
    }

    protected void enterWakeLock()
    {
        Context context = mLocalyticsDao.getAppContext();
        if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) == 0)
        {
            if (mWakeLock == null)
            {
                mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "UPLOAD_WAKE_LOCK");
                if (mWakeLock.isHeld())
                {
                    Localytics.Log.w("Wake lock will be acquired but is held when shouldn't be.");
                }
                mWakeLock.acquire();
                if (mWakeLock.isHeld())
                {
                    Localytics.Log.v("Wake lock acquired.");
                    return;
                } else
                {
                    Localytics.Log.w("Localytics library failed to get wake lock");
                    return;
                }
            }
        } else
        {
            Localytics.Log.v("android.permission.WAKE_LOCK is missing from the Manifest file.");
        }
    }

    protected void exitWakeLock()
    {
        Context context = mLocalyticsDao.getAppContext();
        if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) == 0)
        {
            if (mWakeLock != null)
            {
                if (!mWakeLock.isHeld())
                {
                    Localytics.Log.w("Wake lock will be released but not held when should be.");
                }
                mWakeLock.release();
                if (mWakeLock.isHeld())
                {
                    Localytics.Log.w("Wake lock was not released when it should have been.");
                } else
                {
                    Localytics.Log.v("Wake lock released.");
                }
                mWakeLock = null;
                return;
            }
        } else
        {
            Localytics.Log.v("android.permission.WAKE_LOCK is missing from the Manifest file.");
        }
    }

    boolean getBool(Callable callable)
    {
        return ((Boolean)getType(callable, Boolean.valueOf(false))).booleanValue();
    }

    Object getFutureTaskValue(FutureTask futuretask, Object obj)
    {
        try
        {
            futuretask = ((FutureTask) (futuretask.get()));
        }
        // Misplaced declaration of an exception variable
        catch (FutureTask futuretask)
        {
            return obj;
        }
        finally
        {
            return obj;
        }
        return futuretask;
    }

    List getList(Callable callable)
    {
        return (List)getType(callable, null);
    }

    Map getMap(Callable callable)
    {
        return (Map)getType(callable, null);
    }

    String getString(Callable callable)
    {
        return (String)getType(callable, null);
    }

    protected abstract BaseUploadThread getUploadThread(TreeMap treemap, String s);

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        Localytics.Log.v(String.format("%s handler received %s", new Object[] {
            siloName, message
        }));
        message.what;
        JVM INSTR tableswitch 1 4: default 288
    //                   1 64
    //                   2 69
    //                   3 94
    //                   4 182;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        _init();
        return;
_L3:
        final Boolean adjustMaxRowToUpload;
        Object aobj[];
        final String responseString;
        final String customerId;
        Object aobj1[];
        Boolean boolean1;
        final int rowsToDelete;
        try
        {
            final FutureTask fTask = (FutureTask)message.obj;
            mProvider.runBatchTransaction(new _cls1());
            return;
        }
        catch (Exception exception)
        {
            Localytics.Log.e(String.format("%s handler can't handle message %s", new Object[] {
                siloName, String.valueOf(message.what)
            }), exception);
        }
        break MISSING_BLOCK_LABEL_287;
_L4:
        Localytics.Log.d(String.format("%s handler received MESSAGE_UPLOAD", new Object[] {
            siloName
        }));
        aobj1 = (Object[])message.obj;
        adjustMaxRowToUpload = (Boolean)aobj1[0];
        customerId = (String)aobj1[1];
        boolean1 = (Boolean)aobj1[2];
        if (shouldProcessPendingUploadMessage || !boolean1.booleanValue())
        {
            mProvider.runBatchTransaction(new _cls2());
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        Localytics.Log.d(String.format("%s handler received MESSAGE_UPLOAD_CALLBACK", new Object[] {
            siloName
        }));
        aobj = (Object[])message.obj;
        rowsToDelete = ((Integer)aobj[0]).intValue();
        responseString = (String)aobj[1];
        mProvider.runBatchTransaction(new _cls3());
        return;
_L1:
        handleMessageExtended(message);
        return;
    }

    void handleMessageExtended(Message message)
    {
        throw new Exception("Fell through switch statement");
    }

    boolean queueMessage(Message message)
    {
        if (queuePriorityMessages && getLooper().getThread() == Thread.currentThread())
        {
            handleMessage(message);
            return true;
        } else
        {
            return sendMessage(message);
        }
    }

    final boolean queueMessageDelayed(Message message, long l)
    {
        if (l == 0L)
        {
            return queueMessage(message);
        } else
        {
            return sendMessageDelayed(message, l);
        }
    }

    void removeListener(BaseListener baselistener)
    {
        ListenersSet listenersset = listeners;
        listenersset;
        JVM INSTR monitorenter ;
        listeners.remove(baselistener);
        listenersset;
        JVM INSTR monitorexit ;
        return;
        baselistener;
        throw baselistener;
    }

    void upload(String s)
    {
        upload(true, 0L, s);
    }

    void upload(boolean flag, long l, String s)
    {
        if (l == 0L)
        {
            queueMessage(obtainMessage(3, ((Object) (new Object[] {
                Boolean.valueOf(flag), s, Boolean.valueOf(false)
            }))));
            return;
        } else
        {
            queueMessageDelayed(obtainMessage(3, ((Object) (new Object[] {
                Boolean.valueOf(flag), s, Boolean.valueOf(true)
            }))), l);
            return;
        }
    }


/*
    static boolean access$002(BaseHandler basehandler, boolean flag)
    {
        basehandler.queuePriorityMessages = flag;
        return flag;
    }

*/

    private class _cls1
        implements Runnable
    {

        final BaseHandler this$0;
        final FutureTask val$fTask;

        public void run()
        {
            fTask.run();
        }

        _cls1()
        {
            this$0 = BaseHandler.this;
            fTask = futuretask;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final BaseHandler this$0;
        final Boolean val$adjustMaxRowToUpload;
        final String val$customerId;

        public void run()
        {
            _upload(adjustMaxRowToUpload.booleanValue(), customerId);
        }

        _cls2()
        {
            this$0 = BaseHandler.this;
            adjustMaxRowToUpload = boolean1;
            customerId = s;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final BaseHandler this$0;
        final String val$responseString;
        final int val$rowsToDelete;

        public void run()
        {
            _uploadCallback(rowsToDelete, responseString);
        }

        _cls3()
        {
            this$0 = BaseHandler.this;
            rowsToDelete = i;
            responseString = s;
            super();
        }
    }

}
