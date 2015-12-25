// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ajb, aji, akr, ane, 
//            zk, akb, akq, xf, 
//            anb, amh, ajk, ql, 
//            zp, aqo, akt

final class akp extends ajb
    implements aji
{

    aka.if.if bpi;
    final akr bqK;
    private final ane bqL;
    private final akb bqM = new akb();
    private akq bqN;
    aka.if._cls02CA bqO;

    akp(ajk ajk, ql ql, ApiManager apimanager, zp zp, String s, aqo aqo, akt akt, 
            int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        super(s, aqo, akt, 0x7f0c005c, 0x7f0c005d, 0x7f0c005a, 0x7f0c005b, 0x7f0c0013, 0x7f02006b, 0x7f020020, 0, 0x7f0200fb, 0x7f06006d);
        bqK = new akr(this, apimanager);
        bqL = new ane(ajk, new zk(zp), aqo);
        bqN = new akq(this, apimanager, ql);
    }

    protected final void cF()
    {
        xf._mth02CA(xf.if.aSy);
        super.cF();
    }

    public final android.support.v7.widget.RecyclerView.if cO()
    {
        return bqL;
    }

    public final aka.if cP()
    {
        return bqN;
    }

    public final akb cQ()
    {
        return bqM;
    }

    public final void cR()
    {
        if (bpi != null)
        {
            bpi.cJ();
        }
    }

    public final void cS()
    {
        if (bqO != null)
        {
            bqO._mth1D65();
        }
    }

    public final Intent _mth02CA(ajk ajk)
    {
        xf._mth02CA(xf.if.aSz);
        return new Intent(ajk, o/anb);
    }

    public final Intent _mth02CB(ajk ajk)
    {
        xf._mth02CA(xf.if.aSA);
        return new Intent(ajk, o/amh);
    }
}
