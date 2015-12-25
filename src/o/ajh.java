// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Set;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ajg, aje, ql, aig, 
//            zc, aii, ajc

final class ajh
    implements aka.if
{

    private ApiManager bpj;
    private ql bpk;
    private zg.if bpl;
    private ajg bpm;

    ajh(ajg ajg1, ApiManager apimanager, ql ql1, aii aii)
    {
        bpm = ajg1;
        bpj = apimanager;
        bpk = ql1;
        bpl = aii;
        super();
    }

    public final void destroy()
    {
        ajg._mth02CA(bpm).cN();
        bpk.unregister(ajg._mth02CA(bpm));
        bpj.unbind();
        zc zc1 = ajg._mth02CB(bpm).bmU;
        zg.if if1 = bpl;
        zc1.aWu.remove(if1);
    }

    public final void init()
    {
        bpj.bind();
        bpk._mth02CA(ajg._mth02CA(bpm), false, 0);
        zc zc1 = ajg._mth02CB(bpm).bmU;
        zg.if if1 = bpl;
        zc1.aWu.add(if1);
    }

    public final void pause()
    {
        ajg._mth02CA(bpm).cN();
    }

    public final void resume()
    {
        ajg._mth02CA(bpm).cM();
        ajg._mth02CA(bpm)._mth02C6(ajg.bpd);
    }

    public final void _mth02CA(ajc ajc)
    {
        ajg._mth02CA(bpm, ajc);
        ajg._mth02CA(bpm)._mth02C6(ajg.bpd);
    }

    public final void _mth02CA(FE79.if if1)
    {
        ajg._mth02CA(bpm, if1);
        if1 = ajg._mth02CA(bpm);
        if1.bpa = true;
        if1.cM();
    }
}
