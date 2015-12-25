// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            asn, xd, zp, ahz, 
//            auf, adf, aug, aqd, 
//            aok, _cls1D3C, _cls1D5A, _cls1D27, 
//            aao, _cls1647

public final class ahy
    implements asn
{

    private final String bjT;
    private final boolean bmo;
    private final boolean bmp;
    private final String bmq = xd._mth1FEA().E();

    public ahy(String s, boolean flag, boolean flag1)
    {
        bmo = flag;
        bjT = (new StringBuilder("@")).append(s).toString();
        bmp = flag1;
    }

    public final volatile void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, PsUser psuser, int i)
    {
        _mth02CA((ahz)_pcls02cc, (auf)psuser);
    }

    public final void _mth02CA(ahz ahz1, auf auf1)
    {
        Context context = ahz1.fy.getContext();
        Resources resources = context.getResources();
        String s = auf1._mth1F35();
        int i;
        if (ahz1.bmD != null)
        {
            i = ahz1.bmD.FF86(s);
        } else
        {
            i = 0;
        }
        if (bmp && i > 0)
        {
            ahz1.bmy.setVisibility(0);
            ahz1.bmz.setVisibility(0);
            ahz1.bmz.setText(String.valueOf(i));
        } else
        {
            ahz1.bmy.setVisibility(8);
            ahz1.bmz.setVisibility(8);
        }
        ahz1.bms.setText(resources.getString(0x7f060171, new Object[] {
            auf1.gj()
        }));
        if (auf1.go() == aug.bEK)
        {
            ahz1.bmt.setText(auf1.gy());
            s = bmq;
        } else
        {
            ahz1.bmt.setText(auf1.eI());
            s = auf1.fi();
        }
        if (bjT != null && auf1.eI().contains(bjT))
        {
            ahz1.bmv.setVisibility(0);
        } else
        {
            ahz1.bmv.setVisibility(8);
        }
        i = resources.getColor(0x7f0c0056);
        if (ahz1.FE76(auf1._mth1F35(), auf1.fd()))
        {
            ahz1.bmw.setVisibility(0);
            ahz1.bmx.setBackgroundResource(0x7f020060);
            ahz1.bms.setTextColor(resources.getColor(0x7f0c00a4));
            ahz1.bmt.setTextColor(resources.getColor(0x7f0c00a5));
        } else
        {
            ahz1.bmw.setVisibility(8);
            ahz1.bmx.setBackgroundResource(0x7f02005e);
            ahz1.bms.setTextColor(i);
            ahz1.bmt.setTextColor(resources.getColor(0x7f0c0037));
        }
        i = auf1.gp().intValue();
        ahz1.bmu.setImageDrawable(null);
        ahz1.bmu.getBackground().setColorFilter(aok._mth02CA(resources, i), android.graphics.PorterDuff.Mode.SRC_ATOP);
        if (ahz1.FE76(auf1._mth1F35(), auf1.fd()))
        {
            ahz1.bmC = Integer.valueOf(resources.getColor(0x7f0c0058));
            ahz1.bmu.setColorFilter(ahz1.bmC.intValue());
        } else
        if (bmo)
        {
            ahz1.bmC = Integer.valueOf(aok._mth02CB(resources, i));
        } else
        {
            ahz1.bmC = null;
        }
        ((_cls1D27)_cls1D3C._mth1427(context)._mth02CA(java/lang/String).FF70(s))._mth02CB(aao.baq)._mth0197()._mth02CA(ahz1.bmA);
    }
}
