// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package o:
//            ph, pm, pp

final class pl
    implements Runnable
{

    final ph NX;

    pl(ph ph1)
    {
        NX = ph1;
        super();
    }

    public final void run()
    {
        Object obj = new CountDownLatch(1);
        ph._mth02CE(NX).post(new pm(this, ((CountDownLatch) (obj))));
        try
        {
            ((CountDownLatch) (obj)).await();
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        interruptedexception = new ph.if(NX, (byte)0);
        ph._mth02CE(((ph.if) (interruptedexception)).NX).post(new pp(interruptedexception));
    }
}
