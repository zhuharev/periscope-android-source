// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            qw

final class qr
{

    private static final ArrayList Qd = new ArrayList();
    qw PX;
    Object PY;
    qr Qe;

    private qr(Object obj, qw qw)
    {
        PY = obj;
        PX = qw;
    }

    static void _mth02CA(qr qr1)
    {
        qr1.PY = null;
        qr1.PX = null;
        qr1.Qe = null;
        ArrayList arraylist = Qd;
        arraylist;
        JVM INSTR monitorenter ;
        if (Qd.size() < 10000)
        {
            Qd.add(qr1);
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        qr1;
        throw qr1;
    }

    static qr _mth02CE(qw qw, Object obj)
    {
        ArrayList arraylist = Qd;
        arraylist;
        JVM INSTR monitorenter ;
        int i = Qd.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        qr qr1;
        qr1 = (qr)Qd.remove(i - 1);
        qr1.PY = obj;
        qr1.PX = qw;
        qr1.Qe = null;
        arraylist;
        JVM INSTR monitorexit ;
        return qr1;
        arraylist;
        JVM INSTR monitorexit ;
          goto _L1
        qw;
        throw qw;
_L1:
        return new qr(obj, qw);
    }

}
