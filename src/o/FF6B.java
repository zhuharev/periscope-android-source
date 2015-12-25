// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package o:
//            FF6E, _cls0176, _cls017C, _cls01A8, 
//            _cls1EF4, _cls043A, ra, rl, 
//            _cls01AB, _cls01B3, _cls1D12, _cls1EF2, 
//            si, rz, _cls05D8, vd, 
//            _cls03DC, _cls1681, _cls0455, _cls04E7, 
//            _cls05E1, _cls1686, _cls010D, FE94, 
//            sd, _cls022F, _cls05E3

public final class FF6B
    implements Thread.UncaughtExceptionHandler
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private static _cls0176 uA = new _cls0176();
    private static _cls017C uB = new _cls017C();
    private static final Pattern uC = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map uD = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    static final FF6E uz = new FF6E();
    private final si idManager;
    private final AtomicInteger uE = new AtomicInteger(0);
    private final AtomicBoolean uF = new AtomicBoolean(false);
    private final Thread.UncaughtExceptionHandler uG;
    final File uH;
    final AtomicBoolean uI = new AtomicBoolean(false);
    private final _cls01B3 uJ = new _cls01B3(this);
    private final _cls01AB uK = new _cls01AB(this);
    private boolean uL;
    final _cls1EF4 uM;
    private final _cls043A uN;
    private final _cls05D8 uO;
    public final FE94 uo;

    FF6B(Thread.UncaughtExceptionHandler uncaughtexceptionhandler, _cls1427.if if1, FE94 fe94, si si1, _cls05D8 _pcls05d8, _cls1EF4 _pcls1ef4)
    {
        uG = uncaughtexceptionhandler;
        uo = fe94;
        idManager = si1;
        uM = _pcls1ef4;
        uO = _pcls05d8;
        uH = _pcls1ef4._mth1E2E();
        uN = new _cls043A(_pcls1ef4.getContext(), uH);
        ra._mth0454()._mth02BE("CrashlyticsCore", "Checking for previous crash marker.");
        uncaughtexceptionhandler = new File(uM._mth1E2E(), "crash_marker");
        if (uncaughtexceptionhandler.exists())
        {
            uncaughtexceptionhandler.delete();
            if (if1 == null);
        }
        uncaughtexceptionhandler = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        if1 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        fe94 = _pcls1ef4.getContext();
        fe94.registerReceiver(uK, uncaughtexceptionhandler);
        fe94.registerReceiver(uJ, if1);
        uF.set(true);
    }

    private void _mth02B9(String s)
    {
        String s1;
        _cls1EF2 _lcls1ef2;
        String s2;
        _cls1EF2 _lcls1ef2_1;
        _cls1EF2 _lcls1ef2_2;
        Context context;
        s2 = null;
        s1 = null;
        context = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = context;
        Object obj = new _cls1D12(uH, (new StringBuilder()).append(s).append("SessionDevice").toString());
        s = ((String) (obj));
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = context;
        _lcls1ef2_2 = new _cls1EF2(((java.io.OutputStream) (obj)), new byte[4096]);
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        context = uM.getContext();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        Object obj1 = new StatFs(Environment.getDataDirectory().getPath());
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        obj = idManager._mth0E30();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        int i = rz._mth0699();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        int j = Runtime.getRuntime().availableProcessors();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        long l = rz._mth093D();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        long l1 = ((StatFs) (obj1)).getBlockCount();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        long l2 = ((StatFs) (obj1)).getBlockSize();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        boolean flag = rz._mth1D55(context);
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        obj1 = idManager._mth0EB2();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        int k = rz.FB1D(context);
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        uO._mth02CA(_lcls1ef2_2, ((String) (obj)), i, Build.MODEL, j, l, l1 * l2, flag, ((Map) (obj1)), k, Build.MANUFACTURER, Build.PRODUCT);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush session device info.");
        rz._mth02CA(s, "Failed to close session device file.");
        return;
        s;
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(s, s1);
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        throw s;
        s;
        rz._mth02CB(_lcls1ef2_1, "Failed to flush session device info.");
        rz._mth02CA(s2, "Failed to close session device file.");
        throw s;
    }

    static _cls1EF4 _mth02BB(FF6B ff6b)
    {
        return ff6b.uM;
    }

    private void _mth02C7(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        FE78(i + 8);
        _cls02CA _lcls02ca = new _cls02CA("BeginSession");
        File afile[] = uH.listFiles(_lcls02ca);
        if (afile == null)
        {
            afile = new File[0];
        }
        Arrays.sort(afile, uA);
        if (afile.length > i)
        {
            _mth0559(afile[i].getName().substring(0, 35));
            vd vd1 = _cls1EF4._mth1F39();
            if (vd1 != null)
            {
                int j = vd1.UD;
                ra._mth0454()._mth02BE("CrashlyticsCore", "Closing open sessions.");
                for (; i < afile.length; i++)
                {
                    File file = afile[i];
                    String s = file.getName().substring(0, 35);
                    ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Closing session: ")).append(s).toString());
                    _mth02CA(file, s, j);
                }

                return;
            } else
            {
                ra._mth0454()._mth02BE("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
                return;
            }
        } else
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
    }

    static AtomicBoolean _mth02CA(FF6B ff6b)
    {
        return ff6b.uI;
    }

    private void _mth02CA(File file, String s, int i)
    {
        Object obj;
        _cls1EF2 _lcls1ef2;
        _cls1D12 _lcls1d12;
        _cls1EF2 _lcls1ef2_1;
        File afile[];
        File afile1[];
        _cls1EF2 _lcls1ef2_2;
        Object obj1;
        boolean flag;
        boolean flag1;
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Collecting session parts for ID ")).append(s).toString());
        obj = new _cls02CA((new StringBuilder()).append(s).append("SessionCrash").toString());
        afile1 = uH.listFiles(((FilenameFilter) (obj)));
        if (afile1 == null)
        {
            afile1 = new File[0];
        }
        if (afile1 != null && afile1.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ra._mth0454()._mth02BE("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[] {
            s, Boolean.valueOf(flag)
        }));
        obj = new _cls02CA((new StringBuilder()).append(s).append("SessionEvent").toString());
        afile = uH.listFiles(((FilenameFilter) (obj)));
        if (afile == null)
        {
            afile = new File[0];
        }
        if (afile != null && afile.length > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ra._mth0454()._mth02BE("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[] {
            s, Boolean.valueOf(flag1)
        }));
        if (!flag && !flag1)
        {
            break MISSING_BLOCK_LABEL_888;
        }
        _lcls1d12 = null;
        obj = null;
        obj1 = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = obj1;
        _cls1D12 _lcls1d12_2 = new _cls1D12(uH, s);
        _cls1D12 _lcls1d12_1;
        _lcls1d12_1 = _lcls1d12_2;
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = obj1;
        _lcls1ef2_2 = new _cls1EF2(_lcls1d12_2, new byte[4096]);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Collecting SessionStart data for session ID ")).append(s).toString());
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _mth02CA(_lcls1ef2_2, file);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1ef2_2._mth02CB(4, (new Date()).getTime() / 1000L);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1ef2_2._mth037A(5, flag);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _mth02CA(_lcls1ef2_2, s);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_683;
        }
        file = afile;
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        if (afile.length <= i)
        {
            break MISSING_BLOCK_LABEL_659;
        }
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        ra._mth0454()._mth02BE("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[] {
            Integer.valueOf(i)
        }));
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _mth02CA(s, i);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        file = new _cls02CA((new StringBuilder()).append(s).append("SessionEvent").toString());
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        file = uH.listFiles(file);
        if (file != null)
        {
            break MISSING_BLOCK_LABEL_659;
        }
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        file = new File[0];
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _mth02CA(_lcls1ef2_2, ((File []) (file)), s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_713;
        }
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _mth02CA(_lcls1ef2_2, afile1[0]);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1ef2_2._mth02EE(11, 1);
        obj = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1ef2_2._mth06E5(12, 3);
        rz._mth02CB(_lcls1ef2_2, "Error flushing session file stream");
        rz._mth02CA(_lcls1d12_1, "Failed to close CLS file");
        break MISSING_BLOCK_LABEL_913;
        file;
        _lcls1d12 = ((_cls1D12) (obj));
        _lcls1ef2_1 = _lcls1ef2;
        ra._mth0454()._mth02CB("CrashlyticsCore", (new StringBuilder("Failed to write session file for session ID: ")).append(s).toString(), file);
        _lcls1d12 = ((_cls1D12) (obj));
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(file, ((_cls1D12) (obj)));
        rz._mth02CB(_lcls1ef2, "Error flushing session file stream");
        if (obj != null)
        {
            try
            {
                ((_cls1D12) (obj))._mth1D10();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                ra._mth0454()._mth02CB("CrashlyticsCore", "Error closing session file stream in the presence of an exception", file);
            }
        }
        break MISSING_BLOCK_LABEL_913;
        file;
        rz._mth02CB(_lcls1ef2_1, "Error flushing session file stream");
        rz._mth02CA(_lcls1d12, "Failed to close CLS file");
        throw file;
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("No events present for session ID ")).append(s).toString());
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Removing session part files for ID ")).append(s).toString());
        _mth1428(s);
        return;
    }

    private void _mth02CA(String s, int i)
    {
        _cls141D.if._mth02CA(uH, new _cls02CA((new StringBuilder()).append(s).append("SessionEvent").toString()), i, uB);
    }

    private void _mth02CA(String s, Date date)
    {
        _cls1D12 _lcls1d12;
        _cls1EF2 _lcls1ef2;
        _cls1D12 _lcls1d12_1;
        _cls1EF2 _lcls1ef2_1;
        _cls1EF2 _lcls1ef2_2;
        Object obj;
        _lcls1d12_1 = null;
        _lcls1d12 = null;
        obj = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = obj;
        _cls1D12 _lcls1d12_3 = new _cls1D12(uH, (new StringBuilder()).append(s).append("BeginSession").toString());
        _cls1D12 _lcls1d12_2;
        _lcls1d12_2 = _lcls1d12_3;
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = obj;
        _lcls1ef2_2 = new _cls1EF2(_lcls1d12_3, new byte[4096]);
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _cls05D8._mth02CA(_lcls1ef2_2, s, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[] {
            uM.getVersion()
        }), date.getTime() / 1000L);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12_2, "Failed to close begin session file.");
        return;
        s;
        _lcls1d12_1 = _lcls1d12;
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(s, _lcls1d12);
        _lcls1d12_1 = _lcls1d12;
        _lcls1ef2_1 = _lcls1ef2;
        throw s;
        s;
        rz._mth02CB(_lcls1ef2_1, "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12_1, "Failed to close begin session file.");
        throw s;
    }

    private static void _mth02CA(_cls1EF2 _pcls1ef2, File file)
    {
        File file1;
        byte abyte0[];
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        abyte0 = new byte[(int)file.length()];
        file1 = null;
        file = new FileInputStream(file);
        int i = 0;
_L2:
        file1 = file;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        file1 = file;
        int j = file.read(abyte0, i, abyte0.length - i);
        if (j < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        rz._mth02CA(file, "Failed to close file input stream.");
        break MISSING_BLOCK_LABEL_89;
        _pcls1ef2;
        rz._mth02CA(file1, "Failed to close file input stream.");
        throw _pcls1ef2;
        _pcls1ef2._mth02CB(abyte0, 0, abyte0.length);
        return;
        ra._mth0454()._mth02CB("CrashlyticsCore", (new StringBuilder("Tried to include a file that doesn't exist: ")).append(file.getName()).toString(), null);
        return;
    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, String s)
    {
        for (int i = 0; i < 4; i++)
        {
            String s1 = (new String[] {
                "SessionUser", "SessionApp", "SessionOS", "SessionDevice"
            })[i];
            _cls02CA _lcls02ca = new _cls02CA((new StringBuilder()).append(s).append(s1).toString());
            File afile[] = uH.listFiles(_lcls02ca);
            if (afile == null)
            {
                afile = new File[0];
            }
            if (afile.length == 0)
            {
                ra._mth0454()._mth02CB("CrashlyticsCore", (new StringBuilder("Can't find ")).append(s1).append(" data for session ID ").append(s).toString(), null);
            } else
            {
                ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Collecting ")).append(s1).append(" data for session ID ").append(s).toString());
                _mth02CA(_pcls1ef2, afile[0]);
            }
        }

    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, Date date, Thread thread, Throwable throwable, String s, boolean flag)
    {
        Object obj = uM.getContext();
        long l2 = date.getTime() / 1000L;
        float f = rz._mth144A(((Context) (obj)));
        int l = rz._mth02CA(((Context) (obj)), uL);
        boolean flag1 = rz._mth1540(((Context) (obj)));
        int i1 = ((Context) (obj)).getResources().getConfiguration().orientation;
        long l3 = rz._mth093D() - rz._mth1429(((Context) (obj)));
        long l4 = rz._mth14A1(Environment.getDataDirectory().getPath());
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = rz._mth02CA(((Context) (obj)).getPackageName(), ((Context) (obj)));
        LinkedList linkedlist = new LinkedList();
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        Thread athread[];
        if (flag)
        {
            date = Thread.getAllStackTraces();
            athread = new Thread[date.size()];
            int i = 0;
            for (date = date.entrySet().iterator(); date.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)date.next();
                athread[i] = (Thread)entry.getKey();
                linkedlist.add(entry.getValue());
                i++;
            }

        } else
        {
            athread = new Thread[0];
        }
        if (!rz._mth02CA(((Context) (obj)), "com.crashlytics.CollectCustomKeys", true))
        {
            date = new TreeMap();
        } else
        {
            obj = Collections.unmodifiableMap(uM.ue);
            date = ((Date) (obj));
            if (obj != null)
            {
                date = ((Date) (obj));
                if (((Map) (obj)).size() > 1)
                {
                    date = new TreeMap(((Map) (obj)));
                }
            }
        }
        obj = uO;
        _cls043A _lcls043a = uN;
        obj.vS = runningappprocessinfo;
        obj.vU = linkedlist;
        obj.vV = astacktraceelement;
        obj.vT = athread;
        _cls1681 _lcls1681 = _lcls043a.ve.FB1F();
        if (_lcls1681 == null)
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "No log data to include with this event.");
        }
        _lcls043a.ve.FB33();
        _pcls1ef2._mth144A(10, 2);
        int j = _cls1EF2._mth02CE(1, l2);
        int k = _cls1EF2._mth02CB(2, _cls1681._mth02CD(s));
        int j1 = ((_cls05D8) (obj))._mth02CA(thread, throwable, i1, date);
        int k1 = _cls1EF2.FE74(24);
        int l1 = _cls1EF2.FE74(j1);
        int i2 = _cls05D8._mth02CA(f, l, flag1, i1, l3, l4);
        k = _cls1EF2.FE74(40) + _cls1EF2.FE74(i2) + i2 + (k1 + l1 + j1 + (j + 0 + k));
        j = k;
        if (_lcls1681 != null)
        {
            j = _cls05D8._mth02CA(_lcls1681);
            j = _cls1EF2.FE74(48) + _cls1EF2.FE74(j) + j + k;
        }
        _pcls1ef2.FBE8(j);
        _pcls1ef2._mth02CB(1, l2);
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(s));
        _pcls1ef2._mth144A(3, 2);
        _pcls1ef2.FBE8(((_cls05D8) (obj))._mth02CA(thread, throwable, i1, date));
        ((_cls05D8) (obj))._mth02CA(_pcls1ef2, thread, throwable);
        if (date != null && !date.isEmpty())
        {
            ((_cls05D8) (obj))._mth02CA(_pcls1ef2, date);
        }
        if (((_cls05D8) (obj)).vS != null)
        {
            if (((_cls05D8) (obj)).vS.importance != 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _pcls1ef2._mth037A(3, flag);
        }
        _pcls1ef2._mth02EE(4, i1);
        _pcls1ef2._mth144A(5, 2);
        _pcls1ef2.FBE8(_cls05D8._mth02CA(f, l, flag1, i1, l3, l4));
        _pcls1ef2._mth02CA(1, f);
        _pcls1ef2._mth1420(2, l);
        _pcls1ef2._mth037A(3, flag1);
        _pcls1ef2._mth02EE(4, i1);
        _pcls1ef2._mth02CB(5, l3);
        _pcls1ef2._mth02CB(6, l4);
        if (_lcls1681 != null)
        {
            _pcls1ef2._mth144A(6, 2);
            _pcls1ef2.FBE8(_cls05D8._mth02CA(_lcls1681));
            _pcls1ef2._mth02CA(1, _lcls1681);
        }
    }

    private void _mth02CA(_cls1EF2 _pcls1ef2, File afile[], String s)
    {
        Arrays.sort(afile, rz.Rt);
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            try
            {
                ra._mth0454()._mth02BE("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[] {
                    s, file.getName()
                }));
                _mth02CA(_pcls1ef2, file);
            }
            catch (Exception exception)
            {
                ra._mth0454()._mth02CB("CrashlyticsCore", "Error writting non-fatal to session.", exception);
            }
        }

    }

    static void _mth02CA(FF6B ff6b, Date date, Thread thread, Throwable throwable)
    {
        _cls1D12 _lcls1d12;
        _cls1D12 _lcls1d12_1;
        Object obj;
        _cls1D12 _lcls1d12_2;
        Object obj1;
        Object obj2;
        Object obj3;
        _cls1D12 _lcls1d12_3;
        Object obj4;
        Object obj5;
        obj4 = null;
        obj5 = null;
        _lcls1d12 = null;
        obj2 = null;
        obj3 = null;
        _lcls1d12_3 = null;
        _lcls1d12_2 = obj4;
        obj1 = obj2;
        _lcls1d12_1 = obj5;
        obj = obj3;
        (new File(ff6b.uH, "crash_marker")).createNewFile();
        _lcls1d12_2 = obj4;
        obj1 = obj2;
        _lcls1d12_1 = obj5;
        obj = obj3;
        String s = ff6b._mth1FD9();
        if (s == null) goto _L2; else goto _L1
_L1:
        _lcls1d12_2 = obj4;
        obj1 = obj2;
        _lcls1d12_1 = obj5;
        obj = obj3;
        _cls1EF4._mth0640(s);
        _lcls1d12_2 = obj4;
        obj1 = obj2;
        _lcls1d12_1 = obj5;
        obj = obj3;
        _lcls1d12_3 = new _cls1D12(ff6b.uH, (new StringBuilder()).append(s).append("SessionCrash").toString());
        _lcls1d12 = _lcls1d12_3;
        _lcls1d12_2 = _lcls1d12;
        obj1 = obj2;
        _lcls1d12_1 = _lcls1d12;
        obj = obj3;
        obj2 = new _cls1EF2(_lcls1d12_3, new byte[4096]);
        {
            _lcls1d12_2 = _lcls1d12;
            obj1 = obj2;
            _lcls1d12_1 = _lcls1d12;
            obj = obj2;
            try
            {
                ff6b._mth02CA(((_cls1EF2) (obj2)), date, thread, throwable, "crash", true);
                break MISSING_BLOCK_LABEL_249;
            }
            // Misplaced declaration of an exception variable
            catch (Date date)
            {
                _lcls1d12_1 = _lcls1d12_2;
                obj = obj1;
            }
            finally
            {
                rz._mth02CB(((_cls1EF2) (obj)), "Failed to flush to session begin file.");
                rz._mth02CA(_lcls1d12_1, "Failed to close fatal exception file output stream.");
                throw ff6b;
            }
        }
          goto _L3
_L2:
        _lcls1d12_2 = obj4;
        obj1 = obj2;
        _lcls1d12_1 = obj5;
        obj = obj3;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
        obj2 = _lcls1d12_3;
        rz._mth02CB(((_cls1EF2) (obj2)), "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12, "Failed to close fatal exception file output stream.");
        break MISSING_BLOCK_LABEL_341;
_L3:
        ra._mth0454()._mth02CB("CrashlyticsCore", "An error occurred in the fatal exception logger", date);
        _lcls1d12_1 = _lcls1d12_2;
        obj = obj1;
        _cls141D.if._mth02CA(date, _lcls1d12_2);
        rz._mth02CB(((_cls1EF2) (obj1)), "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12_2, "Failed to close fatal exception file output stream.");
        break MISSING_BLOCK_LABEL_341;
        ff6b._mth02C7(false);
        ff6b._mth1FDA();
        _cls141D.if._mth02CA(ff6b.uH, uz, 4, uB);
        if (!ff6b.uM._mth1F38())
        {
            ff6b._mth2134();
        }
        return;
    }

    static void _mth02CA(FF6B ff6b, _cls05E3 _pcls05e3)
    {
        _cls1D12 _lcls1d12;
        _cls1D12 _lcls1d12_1;
        Object obj;
        _cls1D12 _lcls1d12_2;
        Object obj1;
        Object obj2;
        Map map;
        _cls1D12 _lcls1d12_3;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj4 = null;
        _lcls1d12 = null;
        obj2 = null;
        map = null;
        _lcls1d12_3 = null;
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        File afile[] = ff6b._mth1FDB();
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        Arrays.sort(afile, uA);
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        if (afile.length <= 1) goto _L2; else goto _L1
_L1:
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        String s = afile[1].getName().substring(0, 35);
_L7:
        if (s == null) goto _L4; else goto _L3
_L3:
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        _cls1EF4._mth0640(s);
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        _lcls1d12_3 = new _cls1D12(ff6b.uH, (new StringBuilder()).append(s).append("SessionCrash").toString());
        _lcls1d12 = _lcls1d12_3;
        _lcls1d12_2 = _lcls1d12;
        obj1 = obj2;
        _lcls1d12_1 = _lcls1d12;
        obj = map;
        obj2 = new _cls1EF2(_lcls1d12_3, new byte[4096]);
        _lcls1d12_2 = _lcls1d12;
        obj1 = obj2;
        _lcls1d12_1 = _lcls1d12;
        obj = obj2;
        map = (new _cls0455(ff6b.uH))._mth1D62(s);
        _lcls1d12_2 = _lcls1d12;
        obj1 = obj2;
        _lcls1d12_1 = _lcls1d12;
        obj = obj2;
        try
        {
            _cls04E7._mth02CA(_pcls05e3, new _cls043A(ff6b.uM.getContext(), ff6b.uH, s), map, ((_cls1EF2) (obj2)));
            break MISSING_BLOCK_LABEL_328;
        }
        // Misplaced declaration of an exception variable
        catch (FF6B ff6b)
        {
            _lcls1d12_1 = _lcls1d12_2;
            obj = obj1;
        }
        finally
        {
            rz._mth02CB(((_cls1EF2) (obj)), "Failed to flush to session begin file.");
            rz._mth02CA(_lcls1d12_1, "Failed to close fatal exception file output stream.");
            throw ff6b;
        }
          goto _L5
_L4:
        _lcls1d12_2 = obj3;
        obj1 = obj2;
        _lcls1d12_1 = obj4;
        obj = map;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
        obj2 = _lcls1d12_3;
        rz._mth02CB(((_cls1EF2) (obj2)), "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12, "Failed to close fatal exception file output stream.");
        return;
_L5:
        ra._mth0454()._mth02CB("CrashlyticsCore", "An error occurred in the native crash logger", ff6b);
        _lcls1d12_1 = _lcls1d12_2;
        obj = obj1;
        _cls141D.if._mth02CA(ff6b, _lcls1d12_2);
        rz._mth02CB(((_cls1EF2) (obj1)), "Failed to flush to session begin file.");
        rz._mth02CA(_lcls1d12_2, "Failed to close fatal exception file output stream.");
        return;
_L2:
        s = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static boolean _mth02CA(FF6B ff6b, boolean flag)
    {
        ff6b.uL = flag;
        return flag;
    }

    static File[] _mth02CA(FF6B ff6b, FilenameFilter filenamefilter)
    {
        ff6b = ff6b.uH.listFiles(filenamefilter);
        if (ff6b == null)
        {
            return new File[0];
        } else
        {
            return ff6b;
        }
    }

    static _cls043A _mth02CB(FF6B ff6b)
    {
        return ff6b.uN;
    }

    static void _mth02CB(FF6B ff6b, Date date, Thread thread, Throwable throwable)
    {
        _cls1D12 _lcls1d12;
        _cls1EF2 _lcls1ef2;
        _cls1D12 _lcls1d12_1;
        _cls1EF2 _lcls1ef2_1;
        _cls1D12 _lcls1d12_2;
        _cls1EF2 _lcls1ef2_2;
        Object obj;
        _cls1D12 _lcls1d12_3;
        String s;
        s = ff6b._mth1FD9();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        _cls1EF4._mth02D1(s);
        _lcls1d12_3 = null;
        _lcls1d12_2 = null;
        obj = null;
        _lcls1ef2_2 = null;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_3;
        _lcls1ef2 = obj;
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Crashlytics is logging non-fatal exception \"")).append(throwable).append("\" from thread ").append(thread.getName()).toString());
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_3;
        _lcls1ef2 = obj;
        String s1 = rz.FB4B(ff6b.uE.getAndIncrement());
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_3;
        _lcls1ef2 = obj;
        s1 = (new StringBuilder()).append(s).append("SessionEvent").append(s1).toString();
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_3;
        _lcls1ef2 = obj;
        _lcls1d12_3 = new _cls1D12(ff6b.uH, s1);
        _lcls1d12_2 = _lcls1d12_3;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = obj;
        _lcls1ef2_2 = new _cls1EF2(_lcls1d12_3, new byte[4096]);
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        ff6b._mth02CA(_lcls1ef2_2, date, thread, throwable, "error", false);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush to non-fatal file.");
        rz._mth02CA(_lcls1d12_2, "Failed to close non-fatal file output stream.");
        break MISSING_BLOCK_LABEL_342;
        date;
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_1;
        ra._mth0454()._mth02CB("CrashlyticsCore", "An error occurred in the non-fatal exception logger", date);
        _lcls1d12 = _lcls1d12_1;
        _lcls1ef2 = _lcls1ef2_1;
        _cls141D.if._mth02CA(date, _lcls1d12_1);
        rz._mth02CB(_lcls1ef2_1, "Failed to flush to non-fatal file.");
        rz._mth02CA(_lcls1d12_1, "Failed to close non-fatal file output stream.");
        break MISSING_BLOCK_LABEL_342;
        ff6b;
        rz._mth02CB(_lcls1ef2, "Failed to flush to non-fatal file.");
        rz._mth02CA(_lcls1d12, "Failed to close non-fatal file output stream.");
        throw ff6b;
        try
        {
            ff6b._mth02CA(s, 64);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FF6B ff6b)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "An error occurred when trimming non-fatal files.", ff6b);
        }
        return;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
        return;
    }

    static void _mth02CB(FF6B ff6b, boolean flag)
    {
        ff6b._mth02C7(true);
    }

    static String _mth02CE(FF6B ff6b)
    {
        return ff6b._mth1FD9();
    }

    static File _mth02CF(FF6B ff6b)
    {
        return ff6b.uH;
    }

    private void _mth0559(String s)
    {
        _cls1D12 _lcls1d12;
        _cls1EF2 _lcls1ef2;
        _cls1D12 _lcls1d12_1;
        _cls1EF2 _lcls1ef2_1;
        _cls1EF2 _lcls1ef2_2;
        String s1;
        _lcls1d12_1 = null;
        _lcls1d12 = null;
        s1 = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = s1;
        _cls1D12 _lcls1d12_3 = new _cls1D12(uH, (new StringBuilder()).append(s).append("SessionUser").toString());
        _cls1D12 _lcls1d12_2;
        _lcls1d12_2 = _lcls1d12_3;
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = s1;
        _lcls1ef2_2 = new _cls1EF2(_lcls1d12_3, new byte[4096]);
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        s = _mth05D9(s);
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        if (((_cls05E1) (s)).id != null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        if (((_cls05E1) (s)).name != null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        s1 = ((_cls05E1) (s)).email;
        boolean flag;
        if (s1 == null)
        {
            flag = true;
            break MISSING_BLOCK_LABEL_181;
        }
        flag = false;
        if (flag)
        {
            rz._mth02CB(_lcls1ef2_2, "Failed to flush session user file.");
            rz._mth02CA(_lcls1d12_2, "Failed to close session user file.");
            return;
        }
        _lcls1d12 = _lcls1d12_2;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1d12_1 = _lcls1d12_2;
        _lcls1ef2_1 = _lcls1ef2_2;
        uO._mth02CA(_lcls1ef2_2, ((_cls05E1) (s)).id, ((_cls05E1) (s)).name, ((_cls05E1) (s)).email);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush session user file.");
        rz._mth02CA(_lcls1d12_2, "Failed to close session user file.");
        return;
        s;
        _lcls1d12_1 = _lcls1d12;
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(s, _lcls1d12);
        _lcls1d12_1 = _lcls1d12;
        _lcls1ef2_1 = _lcls1ef2;
        throw s;
        s;
        rz._mth02CB(_lcls1ef2_1, "Failed to flush session user file.");
        rz._mth02CA(_lcls1d12_1, "Failed to close session user file.");
        throw s;
    }

    private _cls05E1 _mth05D9(String s)
    {
        if (uI.get())
        {
            return new _cls05E1(uM._mth1D51(), uM.getUserName(), uM._mth1D68());
        } else
        {
            return (new _cls0455(uH))._mth1D54(s);
        }
    }

    static String _mth141D(File file)
    {
        return file.getName().substring(0, 35);
    }

    static void _mth141D(FF6B ff6b)
    {
        ff6b._mth1FDA();
    }

    private void _mth1428(String s)
    {
        s = new _cls02CB(s);
        s = uH.listFiles(s);
        if (s == null)
        {
            s = new File[0];
        }
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            s[i].delete();
        }

    }

    private String _mth1FD9()
    {
        _cls02CA _lcls02ca = new _cls02CA("BeginSession");
        File afile[] = uH.listFiles(_lcls02ca);
        if (afile == null)
        {
            afile = new File[0];
        }
        Arrays.sort(afile, uA);
        if (afile.length > 0)
        {
            return afile[0].getName().substring(0, 35);
        } else
        {
            return null;
        }
    }

    private void _mth1FDA()
    {
        Date date = new Date();
        String s = (new _cls1686(idManager)).toString();
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Opening an new session with ID ")).append(s).toString());
        _mth02CA(s, date);
        FE73(s);
        FF9E(s);
        _mth02B9(s);
        uN._mth1D35(s);
    }

    private File[] _mth1FDB()
    {
        _cls02CA _lcls02ca = new _cls02CA("BeginSession");
        File afile[] = uH.listFiles(_lcls02ca);
        if (afile == null)
        {
            return new File[0];
        } else
        {
            return afile;
        }
    }

    private void _mth2134()
    {
        FF6E ff6e = uz;
        File afile[] = uH.listFiles(ff6e);
        if (afile == null)
        {
            afile = new File[0];
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            uo._mth02CA(new _cls010D(this, file));
        }

    }

    static Pattern _mth2179()
    {
        return uC;
    }

    static Map _mth217D()
    {
        return uD;
    }

    private void FE73(String s)
    {
        String s1;
        _cls1EF2 _lcls1ef2;
        String s2;
        _cls1EF2 _lcls1ef2_1;
        _cls1EF2 _lcls1ef2_2;
        String s3;
        s2 = null;
        s1 = null;
        s3 = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = s3;
        Object obj = new _cls1D12(uH, (new StringBuilder()).append(s).append("SessionApp").toString());
        s = ((String) (obj));
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = s3;
        _lcls1ef2_2 = new _cls1EF2(((java.io.OutputStream) (obj)), new byte[4096]);
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        s3 = uM.packageName;
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        obj = uM.st;
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        String s4 = uM.versionName;
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        String s5 = idManager._mth0E22();
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        int i = sd._mth15AE(uM.installerPackageName).id;
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        uO._mth02CA(_lcls1ef2_2, s3, ((String) (obj)), s4, s5, i);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush to session app file.");
        rz._mth02CA(s, "Failed to close session app file.");
        return;
        s;
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(s, s1);
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        throw s;
        s;
        rz._mth02CB(_lcls1ef2_1, "Failed to flush to session app file.");
        rz._mth02CA(s2, "Failed to close session app file.");
        throw s;
    }

    private void FE78(int i)
    {
        HashSet hashset = new HashSet();
        File afile[] = _mth1FDB();
        Arrays.sort(afile, uA);
        int j = Math.min(i, afile.length);
        for (i = 0; i < j; i++)
        {
            hashset.add(afile[i].getName().substring(0, 35));
        }

        uN._mth02CA(hashset);
        if if1 = new if((byte)0);
        if1 = uH.listFiles(if1);
        if (if1 == null)
        {
            if1 = new File[0];
        }
        j = if1.length;
        for (i = 0; i < j; i++)
        {
            File file = if1[i];
            String s = file.getName();
            Matcher matcher = uC.matcher(s);
            matcher.matches();
            if (!hashset.contains(matcher.group(1)))
            {
                ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Trimming open session file: ")).append(s).toString());
                file.delete();
            }
        }

    }

    private void FF9E(String s)
    {
        String s1;
        _cls1EF2 _lcls1ef2;
        String s2;
        _cls1EF2 _lcls1ef2_1;
        _cls1EF2 _lcls1ef2_2;
        Object obj;
        s2 = null;
        s1 = null;
        obj = null;
        _lcls1ef2_2 = null;
        _lcls1ef2 = _lcls1ef2_2;
        _lcls1ef2_1 = obj;
        _cls1D12 _lcls1d12 = new _cls1D12(uH, (new StringBuilder()).append(s).append("SessionOS").toString());
        s = _lcls1d12;
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = obj;
        _lcls1ef2_2 = new _cls1EF2(_lcls1d12, new byte[4096]);
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        boolean flag = rz._mth1D63(uM.getContext());
        s1 = s;
        _lcls1ef2 = _lcls1ef2_2;
        s2 = s;
        _lcls1ef2_1 = _lcls1ef2_2;
        uO._mth02CA(_lcls1ef2_2, flag);
        rz._mth02CB(_lcls1ef2_2, "Failed to flush to session OS file.");
        rz._mth02CA(s, "Failed to close session OS file.");
        return;
        s;
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        _cls141D.if._mth02CA(s, s1);
        s2 = s1;
        _lcls1ef2_1 = _lcls1ef2;
        throw s;
        s;
        rz._mth02CB(_lcls1ef2_1, "Failed to flush to session OS file.");
        rz._mth02CA(s2, "Failed to close session OS file.");
        throw s;
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        uI.set(true);
        ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Crashlytics is handling uncaught exception \"")).append(throwable).append("\" from thread ").append(thread.getName()).toString());
        if (!uF.getAndSet(true))
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Unregistering power receivers.");
            Context context = uM.getContext();
            context.unregisterReceiver(uK);
            context.unregisterReceiver(uJ);
        }
        Date date = new Date();
        uo._mth02CA(new _cls022F(this, date, thread, throwable));
        ra._mth0454()._mth02BE("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        uG.uncaughtException(thread, throwable);
        uI.set(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        ra._mth0454()._mth02CB("CrashlyticsCore", "An error occurred in the uncaught exception handler", ((Exception) (obj)));
        ra._mth0454()._mth02BE("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        uG.uncaughtException(thread, throwable);
        uI.set(false);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        ra._mth0454()._mth02BE("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        uG.uncaughtException(thread, throwable);
        uI.set(false);
        throw obj;
        thread;
        this;
        JVM INSTR monitorexit ;
        throw thread;
    }

    static 
    {
        new _cls01A8();
    }
}
