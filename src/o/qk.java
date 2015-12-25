// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            qs, qr, qw, ql

final class qk
    implements Runnable
{

    private final ql PA;
    private volatile boolean PB;
    private final qs Pz = new qs();

    qk(ql ql1)
    {
        PA = ql1;
    }

    public final void run()
    {
_L2:
        qr qr1 = Pz._mth1D67(1000);
        Object obj;
        obj = qr1;
        if (qr1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        this;
        JVM INSTR monitorenter ;
        obj = Pz._mth0443();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        PB = false;
        this;
        JVM INSTR monitorexit ;
        PB = false;
        return;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_54;
        obj;
        throw obj;
        ql ql1 = PA;
        Object obj2 = ((qr) (obj)).PY;
        qw qw1 = ((qr) (obj)).PX;
        qr._mth02CA(((qr) (obj)));
        if (qw1.Qr)
        {
            ql1._mth02CB(qw1, obj2);
        }
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1;
        Log.w("Event", (new StringBuilder()).append(Thread.currentThread().getName()).append(" was interruppted").toString(), ((Throwable) (obj1)));
        PB = false;
        return;
        obj1;
        PB = false;
        throw obj1;
    }

    public final void _mth02CA(qw qw1, Object obj)
    {
        qw1 = qr._mth02CE(qw1, obj);
        this;
        JVM INSTR monitorenter ;
        Pz._mth02CB(qw1);
        if (!PB)
        {
            PB = true;
            PA.executorService.execute(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        qw1;
        throw qw1;
    }
}
