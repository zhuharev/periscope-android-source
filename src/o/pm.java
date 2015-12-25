// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package o:
//            pl, ph, pq

final class pm
    implements Runnable
{

    private CountDownLatch NY;
    private pl NZ;

    pm(pl pl1, CountDownLatch countdownlatch)
    {
        NZ = pl1;
        NY = countdownlatch;
        super();
    }

    public final void run()
    {
        if (ph._mth02CB(NZ.NX).getScale() == 1.0F)
        {
            ph._mth02CB(NZ.NX)._mth02BB(true, true);
        }
        NY.countDown();
    }
}
