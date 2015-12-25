// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            qr

final class qs
{

    private qr Qf;
    private qr Qg;

    qs()
    {
    }

    final void _mth02CB(qr qr1)
    {
        this;
        JVM INSTR monitorenter ;
        if (qr1 != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        throw new NullPointerException("null cannot be enqueued");
        if (Qg != null)
        {
            Qg.Qe = qr1;
            Qg = qr1;
            break MISSING_BLOCK_LABEL_69;
        }
        if (Qf == null)
        {
            Qg = qr1;
            Qf = qr1;
            break MISSING_BLOCK_LABEL_69;
        }
        throw new IllegalStateException("Head present, but no tail");
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        qr1;
        throw qr1;
    }

    final qr _mth0443()
    {
        this;
        JVM INSTR monitorenter ;
        qr qr1;
        qr1 = Qf;
        if (Qf != null)
        {
            Qf = Qf.Qe;
            if (Qf == null)
            {
                Qg = null;
            }
        }
        this;
        JVM INSTR monitorexit ;
        return qr1;
        Exception exception;
        exception;
        throw exception;
    }

    final qr _mth1D67(int i)
    {
        this;
        JVM INSTR monitorenter ;
        qr qr1;
        if (Qf == null)
        {
            wait(1000L);
        }
        qr1 = _mth0443();
        this;
        JVM INSTR monitorexit ;
        return qr1;
        Exception exception;
        exception;
        throw exception;
    }
}
