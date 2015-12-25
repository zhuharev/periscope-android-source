// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ajb, aji, aih, aco, 
//            aig, aje, ajh, aii, 
//            xf, aed, adc, asm, 
//            ql, akt, akb, ajk

abstract class ajg extends ajb
    implements aji, aig.aux
{

    public static final long bpd;
    private final aig bnf;
    private final aje bpe;
    private final aih bpf;
    private ajh bpg;
    private aka.if._cls02CA bph;
    private aka.if.if bpi;

    ajg(Activity activity, ql ql, ApiManager apimanager, aig aig1, aje aje1, String s, asm asm1, 
            akt akt, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2)
    {
        super(s, asm1, akt, i, j, k, l, i1, j1, k1, l1, i2, j2);
        bpf = new aih(activity.getResources().getDimensionPixelOffset(0x7f09005b));
        bnf = aig1;
        bnf.bmX = new aco(activity);
        bnf.bmV = this;
        bpe = aje1;
        bpe._mth02CA(this);
        bpg = new ajh(this, apimanager, ql, new aii(bnf));
    }

    static aje _mth02CA(ajg ajg1)
    {
        return ajg1.bpe;
    }

    static aka.if.if _mth02CA(ajg ajg1, aka.if.if if1)
    {
        ajg1.bpi = if1;
        return if1;
    }

    static aka.if._cls02CA _mth02CA(ajg ajg1, aka.if._cls02CA _pcls02ca)
    {
        ajg1.bph = _pcls02ca;
        return _pcls02ca;
    }

    static aig _mth02CB(ajg ajg1)
    {
        return ajg1.bnf;
    }

    public final android.support.v7.widget.RecyclerView.if cO()
    {
        return bnf;
    }

    public final aka.if cP()
    {
        return bpg;
    }

    public final akb cQ()
    {
        return bpf;
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
        if (bph != null)
        {
            bph._mth1D65();
        }
    }

    public final Intent _mth02CA(ajk ajk)
    {
        xf._mth02CA(xf.if.aSx);
        return aed._mth1FBE((Activity)ajk);
    }

    public final Intent _mth02CB(ajk ajk)
    {
        return null;
    }

    public final void _mth14D2(String s)
    {
        super.boI._mth1D65(new adc(s, null));
    }

    static 
    {
        bpd = TimeUnit.SECONDS.toMillis(5L);
    }
}
