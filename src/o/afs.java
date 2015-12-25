// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ahi, yv, atn, zz, 
//            atr, ato, aui, acd, 
//            acb, agp, ql, ahl

final class afs extends ahi
{

    private static final long biP;
    private long biQ;
    private float biR;

    public afs(agp agp, ApiManager apimanager, ql ql, String s, yv yv1, ahl ahl)
    {
        super(agp, apimanager, ql, s, yv1, ahl, ahi.if.blv);
    }

    private void bP()
    {
        float f = biR;
        long l = biQ;
        if (l != 0L)
        {
            l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
        } else
        {
            l = 0L;
        }
        biR = f + (float)l;
        biQ = 0L;
    }

    public final void bM()
    {
        Object obj = mBroadcastCacheManager;
        String s = bei;
        obj = (atn)((yv) (obj)).aWg.get(s);
        if (obj != null)
        {
            _mth02BC(((atn) (obj)));
            if (((atn) (obj)).bDX)
            {
                _mth1483(((atn) (obj)).id());
            }
        }
    }

    final void bN()
    {
        biQ = 0L;
        biR = 0.0F;
    }

    final float bO()
    {
        if (biQ != 0L)
        {
            float f = biR;
            long l = biQ;
            if (l != 0L)
            {
                l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
            } else
            {
                l = 0L;
            }
            biR = f + (float)l;
            biQ = 0L;
        }
        return biR;
    }

    public final void bn()
    {
        float f = biR;
        long l = biQ;
        if (l != 0L)
        {
            l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
        } else
        {
            l = 0L;
        }
        biR = f + (float)l;
        biQ = 0L;
        biQ = System.currentTimeMillis();
    }

    public final void bo()
    {
        float f = biR;
        long l = biQ;
        if (l != 0L)
        {
            l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l);
        } else
        {
            l = 0L;
        }
        biR = f + (float)l;
        biQ = 0L;
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
        if (agp.K() - agp.J() < biP)
        {
            blq.cf();
        }
    }

    public final void _mth02CA(atr atr1)
    {
        atn atn1 = atr1.fo();
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
            boolean flag = atr1.fF();
            blq._mth02CA(acd1, Boolean.valueOf(flag), super.blr);
            bcW.replayThumbnailPlaylist(atn1.id());
        }
    }

    public final void FE7E(boolean flag)
    {
        if (flag)
        {
            if (biQ == 0L)
            {
                biQ = System.currentTimeMillis();
                return;
            }
        } else
        {
            bP();
        }
    }

    static 
    {
        biP = TimeUnit.SECONDS.toMillis(10L);
    }
}
