// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ahi, yv, atn, atr, 
//            ato, aui, acd, acb, 
//            agp, ql, ahl

final class agg extends ahi
{

    private long biQ;
    private long bjI;

    public agg(agp agp, ApiManager apimanager, ql ql, String s, yv yv1, ahl ahl)
    {
        super(agp, apimanager, ql, s, yv1, ahl, ahi.if.blu);
    }

    public final void bM()
    {
        _mth1483(bei);
        Object obj = mBroadcastCacheManager;
        String s = bei;
        obj = (atn)((yv) (obj)).aWg.get(s);
        if (obj != null)
        {
            _mth02BC(((atn) (obj)));
        }
    }

    final void bN()
    {
        biQ = 0L;
        bjI = 0L;
    }

    final float bO()
    {
        if (bjI == 0L)
        {
            long l = biQ;
            if (l != 0L)
            {
                TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
            }
        }
        return (float)bjI;
    }

    public final void bn()
    {
        biQ = System.currentTimeMillis();
        bjI = 0L;
    }

    public final void bo()
    {
        long l = biQ;
        if (l != 0L)
        {
            l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
        } else
        {
            l = 0L;
        }
        bjI = l;
    }

    public final void bp()
    {
    }

    public final void bq()
    {
    }

    public final void onError(Exception exception)
    {
    }

    public final void _mth02B3(long l)
    {
    }

    final void _mth02CA(agp agp)
    {
        agp = new ArrayList(1);
        agp.add(bei);
        bcW.refreshLiveBroadcasts(agp);
    }

    public final void _mth02CA(atr atr1)
    {
        atn atn1 = atr1.fo();
        boolean flag;
        if (atn1.bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && atn1.bDX)
        {
            blq._mth02CB(ahi.if.blv);
            return;
        }
        int i = atn1.bDW;
        if (i == ato.bEf || i == ato.bEe)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i && !atn1.bDX)
        {
            blq.cf();
            return;
        }
        if (aui._mth02BF(atr1.fD()))
        {
            acd acd1 = new acd(new acb(atr1.fD()), "SHA256withECDSA", "SC");
            boolean flag1 = atr1.fF();
            blq._mth02CA(acd1, Boolean.valueOf(flag1), super.blr);
        }
    }

    public final void FE7E(boolean flag)
    {
    }
}
