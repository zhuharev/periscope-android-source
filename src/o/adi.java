// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            apo, app, apj, auf, 
//            aui, _cls1D3C, _cls1D5A, _cls1D27, 
//            aao, _cls1647, apm

final class adi extends apo
{

    private adh._cls02CE ber;

    adi(adh._cls02CE _pcls02ce)
    {
        ber = _pcls02ce;
        super();
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((app)_pcls02cc, (apj)psuser, i);
    }

    public final void _mth02CA(app app1, apj apj1, int i)
    {
        super._mth02CA(app1, apj1, i);
        apj1 = ber.ben.fi();
        if (aui._mth02BF(apj1))
        {
            ((_cls1D27)_cls1D3C._mth1427(app1.fy.getContext())._mth02CA(java/lang/String).FF70(apj1))._mth05D5(0x7f020049)._mth02CB(aao.baq)._mth0197()._mth02CA(app1.byY.byT);
        }
    }
}
