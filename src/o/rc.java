// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            rf, ra

final class rc
    implements rf
{

    private ra QL;
    private CountDownLatch QM;
    private int QN;

    rc(ra ra1, int i)
    {
        QL = ra1;
        QN = i;
        super();
        QM = new CountDownLatch(QN);
    }

    public final void _mth02CE(Exception exception)
    {
        ra._mth02CB(QL)._mth02CE(exception);
    }

    public final void _mth050D()
    {
        QM.countDown();
        if (QM.getCount() == 0L)
        {
            ra._mth02CA(QL).set(true);
            ra._mth02CB(QL)._mth050D();
        }
    }
}
