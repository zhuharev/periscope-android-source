// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            akp, ql, akr, ajc

final class akq
    implements aka.if
{

    private ApiManager bpj;
    private ql bpk;
    private akp bqP;

    akq(akp akp1, ApiManager apimanager, ql ql1)
    {
        bqP = akp1;
        bpj = apimanager;
        bpk = ql1;
        super();
    }

    public final void destroy()
    {
        bpk.unregister(bqP.bqK);
        bpj.unbind();
    }

    public final void init()
    {
        bpj.bind();
        bpk._mth02CA(bqP.bqK, false, 0);
    }

    public final void pause()
    {
    }

    public final void resume()
    {
    }

    public final void _mth02CA(ajc ajc)
    {
        bqP.bpi = ajc;
        bqP.bqK.bcW.getSuggestedPeople();
    }

    public final void _mth02CA(FE79.if if1)
    {
        bqP.bqO = if1;
        if1 = bqP.bqK;
        if1.bpa = true;
        ((akr) (if1)).bcW.getSuggestedPeople();
    }
}
