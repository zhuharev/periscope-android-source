// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.media.MediaCodec;

// Referenced classes of package o:
//            xm, aax, xs, aar

final class <init> extends <init>
{

    final xm aTI;

    public final void run()
    {
        xm._mth0640(aTI).start();
        Long long1 = super.aTT;
        long1;
        JVM INSTR monitorenter ;
        super.FE7B = true;
        super.aTT.notifyAll();
        long1;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        do
        {
            boolean flag;
            if (!super.aTS)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break;
            }
            aax aax1 = xm._mth141D(aTI);
            if (aax1 != null && aax1.ae())
            {
                xm.FE73(aTI)._mth02CA(new xs(this));
            }
        } while (true);
        xm._mth0640(aTI).stop();
        return;
    }

    private Object(xm xm1)
    {
        aTI = xm1;
        super();
    }

    <init>(xm xm1, byte byte0)
    {
        this(xm1);
    }
}
