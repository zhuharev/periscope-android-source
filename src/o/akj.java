// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aki, ake, ql, aqc, 
//            ev, aje, ajc

final class akj
    implements aka.if
{

    private ApiManager bpj;
    private ql bpk;
    private aki bqD;

    akj(aki aki1, ApiManager apimanager, ql ql1)
    {
        bqD = aki1;
        bpj = apimanager;
        bpk = ql1;
        super();
    }

    public final void destroy()
    {
        aki._mth02CA(bqD).cN();
        bpk.unregister(aki._mth02CA(bqD));
        bpj.unbind();
        if (aki._mth02CB(bqD) != null)
        {
            aqc aqc1 = aki._mth02CB(bqD);
            if (aqc1.mCreated)
            {
                aqc1.bzH.onDestroy();
            }
        }
    }

    public final void init()
    {
        bpj.bind();
        bpk._mth02CA(aki._mth02CA(bqD), false, 0);
    }

    public final void pause()
    {
        aki._mth02CA(bqD).cN();
        if (aki._mth02CB(bqD) != null)
        {
            aqc aqc1 = aki._mth02CB(bqD);
            if (aqc1.mCreated)
            {
                aqc1.bzH.onPause();
            }
        }
    }

    public final void resume()
    {
        aki._mth02CA(bqD).cM();
        aki._mth02CA(bqD)._mth02C6(aki.da());
        if (aki._mth02CB(bqD) != null)
        {
            aqc aqc1 = aki._mth02CB(bqD);
            if (aqc1.mCreated)
            {
                aqc1.bzH.onResume();
            }
        }
    }

    public final void _mth02CA(ajc ajc)
    {
        aki._mth02CA(bqD, ajc);
        aki._mth02CA(bqD)._mth02C6(aki.da());
    }

    public final void _mth02CA(FE79.if if1)
    {
        aki._mth02CA(bqD, if1);
        if1 = aki._mth02CA(bqD);
        if1.bpa = true;
        if1.cM();
    }
}
