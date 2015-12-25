// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package o:
//            sc, ty, rz, tz, 
//            tr, tp

public abstract class tq
{
    static final class if
    {

        final File file;
        final long timestamp;

        public if(File file1, long l)
        {
            file = file1;
            timestamp = l;
        }
    }


    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    public final sc currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final ty eventStorage;
    protected volatile long lastRollOverTime;
    protected final List rollOverListeners = new CopyOnWriteArrayList();
    protected final tp transform;

    public tq(Context context1, tp tp1, sc sc1, ty ty1, int i)
    {
        context = context1.getApplicationContext();
        transform = tp1;
        eventStorage = ty1;
        currentTimeProvider = sc1;
        lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
        defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i)
    {
        if (!eventStorage._mth1D55(i, getMaxByteSizePerFile()))
        {
            String s = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] {
                Integer.valueOf(eventStorage._mth1529()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())
            });
            rz._mth02CE(context, 4, s);
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String s)
    {
        Exception exception;
        for (Iterator iterator = rollOverListeners.iterator(); iterator.hasNext();)
        {
            tz tz1 = (tz)iterator.next();
            try
            {
                tz1.onRollOver(s);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                rz._mth037A(context, "One of the roll over listeners threw an exception");
            }
        }

    }

    public void deleteAllEventsFiles()
    {
        eventStorage._mth02CE(eventStorage._mth152E());
        eventStorage._mth1624();
    }

    public void deleteOldestInRollOverIfOverMax()
    {
        Object obj1 = eventStorage._mth152E();
        int i = getMaxFilesToKeep();
        if (((List) (obj1)).size() <= i)
        {
            return;
        }
        int j = ((List) (obj1)).size() - i;
        rz._mth02BD(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] {
            Integer.valueOf(((List) (obj1)).size()), Integer.valueOf(i), Integer.valueOf(j)
        }));
        Object obj = new TreeSet(new tr(this));
        File file;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((TreeSet) (obj)).add(new if(file, parseCreationTimestampFromFileName(file.getName()))))
        {
            file = (File)((Iterator) (obj1)).next();
        }

        obj1 = new ArrayList();
        obj = ((TreeSet) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ((ArrayList) (obj1)).add(((if)((Iterator) (obj)).next()).file);
        } while (((ArrayList) (obj1)).size() != j);
        eventStorage._mth02CE(((List) (obj1)));
    }

    public void deleteSentFiles(List list)
    {
        eventStorage._mth02CE(list);
    }

    public abstract String generateUniqueRollOverFileName();

    public List getBatchOfFilesToSend()
    {
        return eventStorage.FE91(1);
    }

    public long getLastRollOverTime()
    {
        return lastRollOverTime;
    }

    public int getMaxByteSizePerFile()
    {
        return 8000;
    }

    public int getMaxFilesToKeep()
    {
        return defaultMaxFilesToKeep;
    }

    public long parseCreationTimestampFromFileName(String s)
    {
        s = s.split("_");
        if (s.length != 3)
        {
            return 0L;
        }
        long l;
        try
        {
            l = Long.valueOf(s[2]).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l;
    }

    public void registerRollOverListener(tz tz1)
    {
        if (tz1 != null)
        {
            rollOverListeners.add(tz1);
        }
    }

    public boolean rollFileOver()
    {
        boolean flag = false;
        String s = null;
        if (!eventStorage._mth152A())
        {
            s = generateUniqueRollOverFileName();
            eventStorage._mth1D53(s);
            rz._mth02CE(context, 4, String.format(Locale.US, "generated new file %s", new Object[] {
                s
            }));
            lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
            flag = true;
        }
        triggerRollOverOnListeners(s);
        return flag;
    }

    public void writeEvent(Object obj)
    {
        obj = transform.toBytes(obj);
        rollFileOverIfNeeded(obj.length);
        eventStorage._mth02BE(((byte []) (obj)));
    }
}
