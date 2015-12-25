// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

// Referenced classes of package o:
//            qs, qr, qw, ql, 
//            qo

final class qp extends Handler
{

    private final ql PA;
    private final qs Pz = new qs();
    private final int Qa = 10;
    private boolean Qb;

    qp(ql ql1, Looper looper, int i)
    {
        super(looper);
        PA = ql1;
    }

    public final void handleMessage(Message message)
    {
        long l = SystemClock.uptimeMillis();
_L2:
        qr qr1 = Pz._mth0443();
        message = qr1;
        if (qr1 != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        this;
        JVM INSTR monitorenter ;
        message = Pz._mth0443();
        if (message != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        Qb = false;
        this;
        JVM INSTR monitorexit ;
        Qb = false;
        return;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_56;
        message;
        throw message;
        ql ql1 = PA;
        Object obj = ((qr) (message)).PY;
        qw qw1 = ((qr) (message)).PX;
        qr._mth02CA(message);
        if (qw1.Qr)
        {
            ql1._mth02CB(qw1, obj);
        }
        if (SystemClock.uptimeMillis() - l < (long)Qa) goto _L2; else goto _L1
_L1:
        if (!sendMessage(obtainMessage()))
        {
            throw new qo("Could not send handler message");
        }
        Qb = true;
        return;
        message;
        Qb = false;
        throw message;
    }

    final void _mth02CA(qw qw1, Object obj)
    {
        qw1 = qr._mth02CE(qw1, obj);
        this;
        JVM INSTR monitorenter ;
        Pz._mth02CB(qw1);
        if (!Qb)
        {
            Qb = true;
            if (!sendMessage(obtainMessage()))
            {
                throw new qo("Could not send handler message");
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        qw1;
        throw qw1;
    }
}
