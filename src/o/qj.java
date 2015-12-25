// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            qs, qr, qw, ql

final class qj
    implements Runnable
{

    final ql PA;
    final qs Pz = new qs();

    qj(ql ql1)
    {
        PA = ql1;
    }

    public final void run()
    {
        qr qr1 = Pz._mth0443();
        if (qr1 == null)
        {
            throw new IllegalStateException("No pending post available");
        }
        ql ql1 = PA;
        Object obj = qr1.PY;
        qw qw1 = qr1.PX;
        qr._mth02CA(qr1);
        if (qw1.Qr)
        {
            ql1._mth02CB(qw1, obj);
        }
    }
}
