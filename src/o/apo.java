// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, app, apj, apm

public class apo
    implements asn
{

    public static apo byX = new apo();

    public apo()
    {
    }

    public volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((app)_pcls02cc, (apj)psuser, i);
    }

    public void _mth02CA(app app1, apj apj1, int i)
    {
        app1.byZ = apj1;
        app1.byY.setIcon(apj1.getIconResId(), apj1.getIconTint());
        app1.byY.setLabel(apj1._mth1D36(app1.fy.getContext()), apj1.aT());
    }

}
