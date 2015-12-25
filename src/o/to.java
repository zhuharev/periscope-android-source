// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            tx, rz, tq, ud, 
//            ub

public abstract class to
    implements tx
{

    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    public final Context context;
    final ScheduledExecutorService executorService;
    public final tq filesManager;
    volatile int rolloverIntervalSeconds;
    final AtomicReference scheduledRolloverFutureRef = new AtomicReference();

    public to(Context context1, ScheduledExecutorService scheduledexecutorservice, tq tq1)
    {
        rolloverIntervalSeconds = -1;
        context = context1;
        executorService = scheduledexecutorservice;
        filesManager = tq1;
    }

    public void cancelTimeBasedFileRollOver()
    {
        if (scheduledRolloverFutureRef.get() != null)
        {
            rz._mth02BD(context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)scheduledRolloverFutureRef.get()).cancel(false);
            scheduledRolloverFutureRef.set(null);
        }
    }

    public void configureRollover(int i)
    {
        rolloverIntervalSeconds = i;
        scheduleTimeBasedFileRollOver(0L, rolloverIntervalSeconds);
    }

    public void deleteAllEvents()
    {
        filesManager.deleteAllEventsFiles();
    }

    public int getRollover()
    {
        return rolloverIntervalSeconds;
    }

    public void recordEvent(Object obj)
    {
        rz._mth02BD(context, obj.toString());
        try
        {
            filesManager.writeEvent(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            rz._mth037A(context, "Failed to write event.");
        }
        scheduleTimeBasedRollOverIfNeeded();
    }

    public boolean rollFileOver()
    {
        IOException ioexception;
        boolean flag;
        try
        {
            flag = filesManager.rollFileOver();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            rz._mth037A(context, "Failed to roll file over.");
            return false;
        }
        return flag;
    }

    void scheduleTimeBasedFileRollOver(long l, long l1)
    {
        RejectedExecutionException rejectedexecutionexception;
        boolean flag;
        if (scheduledRolloverFutureRef.get() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ud ud1 = new ud(context, this);
            rz._mth02BD(context, (new StringBuilder("Scheduling time based file roll over every ")).append(l1).append(" seconds").toString());
            try
            {
                scheduledRolloverFutureRef.set(executorService.scheduleAtFixedRate(ud1, l, l1, TimeUnit.SECONDS));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RejectedExecutionException rejectedexecutionexception)
            {
                rz._mth037A(context, "Failed to schedule time based file roll over");
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded()
    {
        boolean flag;
        if (rolloverIntervalSeconds != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            scheduleTimeBasedFileRollOver(rolloverIntervalSeconds, rolloverIntervalSeconds);
        }
    }

    void sendAndCleanUpIfSuccess()
    {
        List list;
        ub ub1;
        int j;
        ub1 = getFilesSender();
        if (ub1 == null)
        {
            rz._mth02BD(context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        rz._mth02BD(context, "Sending all files");
        j = 0;
        list = filesManager.getBatchOfFilesToSend();
_L2:
        int i;
        int l;
        l = j;
        i = j;
        if (list.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        rz._mth02BD(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] {
            Integer.valueOf(list.size())
        }));
        i = j;
        boolean flag = ub1.send(list);
        int k;
        k = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        i = j;
        k = list.size() + j;
        i = k;
        filesManager.deleteSentFiles(list);
        l = k;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = k;
        list = filesManager.getBatchOfFilesToSend();
        j = k;
        if (true) goto _L2; else goto _L1
_L1:
        i = l;
        break MISSING_BLOCK_LABEL_195;
        Exception exception;
        exception;
        rz._mth037A(context, (new StringBuilder("Failed to send batch of analytics files to server: ")).append(exception.getMessage()).toString());
        if (i == 0)
        {
            filesManager.deleteOldestInRollOverIfOverMax();
        }
        return;
    }

    public void sendEvents()
    {
        sendAndCleanUpIfSuccess();
    }
}
