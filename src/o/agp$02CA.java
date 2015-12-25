// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.ImageView;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            agp, adu, aib, ahw, 
//            atn, xw, adx

final class <init>
    implements bject
{

    private agp ble;

    public final void _mth02BF(View view, float f)
    {
        if (view.getId() == 0x7f0d00a6)
        {
            agp.FE76(ble).setTitleAlpha(f);
            agp.FE7A(ble).setAlpha(1.0F - f);
            agp._mth1D35(ble).setAlpha(1.0F - f);
            agp._mth0674(ble).setAlpha(1.0F - f);
        }
    }

    public final void _mth037A(View view, int i)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558569: 
            agp._mth02CB(ble, i);
            break;
        }
    }

    public final void _mth05D5(View view)
    {
        agp.FF70(ble);
        switch (view.getId())
        {
        default:
            return;

        case 2131558566: 
            break;
        }
        if ((agp._mth02BB(ble) == v || agp._mth02BB(ble) == w) && agp._mth141D(ble) != null)
        {
            agp._mth02B3(ble).getBroadcastViewers(agp._mth141D(ble).fd(), agp._mth037A(ble));
            return;
        }
        if (agp._mth02B4(ble))
        {
            agp.FF9E(ble)._mth02CB(agp._mth02C6(ble));
        }
    }

    public final void _mth06E6(View view)
    {
        agp._mth02CB(ble);
        switch (view.getId())
        {
        default:
            return;

        case 2131558566: 
            break;
        }
        if (agp._mth02BB(ble) == null || !agp._mth02BB(ble).y || agp._mth141D(ble) == null || !agp._mth141D(ble).bDX || agp._mth02CF(ble) == null)
        {
            return;
        }
        if (agp._mth02CF(ble).aVj)
        {
            agp._mth02C7(ble);
            agp._mth02CB(ble, true);
            agp._mth02E1(ble);
            return;
        }
        if (!agp._mth02CF(ble).bfL)
        {
            agp._mth02CB(ble, true);
            agp._mth02EE(ble);
        }
    }

    private w.View(agp agp1)
    {
        ble = agp1;
        super();
    }

    bject(agp agp1, byte byte0)
    {
        this(agp1);
    }
}
