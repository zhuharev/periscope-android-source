// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            _cls0579, _cls1EF4, _cls029D, rx, 
//            _cls02AD, ra, _cls050F, rl

final class _cls0534
{
    /* member class not found */
    class if {}


    private static final _cls0579 vK = new _cls0579();
    static final Map vL = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final short vM[] = {
        10, 20, 30, 60, 120, 300
    };
    private final Object vN = new Object();
    private final _cls02AD vO;
    private Thread vP;

    public _cls0534(_cls02AD _pcls02ad)
    {
        if (_pcls02ad == null)
        {
            throw new IllegalArgumentException("createReportCall must not be null.");
        } else
        {
            vO = _pcls02ad;
            return;
        }
    }

    static Thread _mth02CA(_cls0534 _pcls0534, Thread thread)
    {
        _pcls0534.vP = null;
        return null;
    }

    static short[] FF6D()
    {
        return vM;
    }

    public final void _mth02BF(float f)
    {
        this;
        JVM INSTR monitorenter ;
        if (vP == null)
        {
            vP = new Thread(new if(f), "Crashlytics Report Uploader");
            vP.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean _mth02CA(_cls050F _pcls050f)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        Object obj2 = vN;
        obj2;
        JVM INSTR monitorenter ;
        rl rl1;
        StringBuilder stringbuilder;
        boolean flag2;
        Object obj = _cls1EF4._mth1D3A().getContext();
        obj = new _cls029D((new rx())._mth06E5(((android.content.Context) (obj))), _pcls050f);
        flag2 = vO._mth02CA(((_cls029D) (obj)));
        rl1 = ra._mth0454();
        stringbuilder = new StringBuilder("Crashlytics report upload ");
        Object obj1;
        if (flag2)
        {
            obj1 = "complete: ";
        } else
        {
            obj1 = "FAILED: ";
        }
        rl1._mth02CB("CrashlyticsCore", stringbuilder.append(((String) (obj1))).append(_pcls050f.getFileName()).toString());
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        _pcls050f.FE80();
        flag = true;
        break MISSING_BLOCK_LABEL_148;
        obj1;
        ra._mth0454()._mth02CB("CrashlyticsCore", (new StringBuilder("Error occurred sending report ")).append(_pcls050f).toString(), ((Exception) (obj1)));
        flag = flag1;
        obj2;
        JVM INSTR monitorexit ;
        return flag;
        _pcls050f;
        throw _pcls050f;
    }

    final LinkedList FF4A()
    {
        ra._mth0454()._mth02BE("CrashlyticsCore", "Checking for crash reports...");
        Object obj1 = vN;
        obj1;
        JVM INSTR monitorenter ;
        Object obj = _cls1EF4._mth1D3A()._mth1E2E().listFiles(vK);
        obj1;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        LinkedList linkedlist = new LinkedList();
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            File file = obj[i];
            ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Found crash report ")).append(file.getPath()).toString());
            linkedlist.add(new _cls050F(file));
        }

        if (linkedlist.isEmpty())
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "No reports found.");
        }
        return linkedlist;
    }

}
