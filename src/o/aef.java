// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Semaphore;

// Referenced classes of package o:
//            aed, xl

final class aef extends Thread
{

    private aed bhH;
    private int bhI;

    aef(aed aed1, int i)
    {
        bhH = aed1;
        bhI = i;
        super();
    }

    public final void run()
    {
        aed._mth0674(bhH).acquire();
        xl xl1;
        Object obj;
        int i;
        if (aed.FF9E(bhH).FB24() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            aed.FF9E(bhH).setZoom(0);
            xl1 = aed.FF9E(bhH);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aed._mth0674(bhH).release();
            return;
        }
        finally
        {
            aed._mth0674(bhH).release();
        }
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        xl1._mth1D41(i);
        aed._mth02CB(bhH, bhI);
        aed._mth0674(bhH).release();
        return;
        throw obj;
    }
}
