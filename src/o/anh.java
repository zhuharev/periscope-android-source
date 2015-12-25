// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.LayoutInflater;
import android.view.ViewGroup;

// Referenced classes of package o:
//            ani, anx, zr, any, 
//            anz, aqo

public final class anh extends android.support.v7.widget.RecyclerView.if
{

    public final zr btU;
    private final anz btV;
    private final anx btW;

    private anh(zr zr1, anz anz, anx anx1)
    {
        btU = zr1;
        btV = anz;
        btW = anx1;
    }

    public anh(zr zr1, aqo aqo)
    {
        this(zr1, ((anz) (new ani(aqo))), new anx());
    }

    public final int getItemCount()
    {
        return btU.v();
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        _pcls02cc = (any)_pcls02cc;
        tv.periscope.android.api.PsUser psuser = btU._mth1E2F(i);
        btW._mth02CA(_pcls02cc, psuser, i);
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        return new any(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030093, viewgroup, false), btV, 0x7f0d019b);
    }
}
