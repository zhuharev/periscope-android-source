// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1646, ahn, FE70

final class ahq extends ahn._cls02CB
{

    private android.support.v7.widget.RecyclerView._cls02CC bh;
    private _cls1646 bi;
    private int bj;
    private int bk;
    private ahn blV;
    private ahn._cls02CA blW;

    ahq(ahn ahn1, ahn._cls02CA _pcls02ca, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i, int j, _cls1646 _pcls1646)
    {
        blV = ahn1;
        blW = _pcls02ca;
        bh = _pcls02cc;
        bj = i;
        bk = j;
        bi = _pcls1646;
        super((byte)0);
    }

    public final void _mth02B3(View view)
    {
        bi._mth02CA(null);
        if (blW.bma)
        {
            view = blV;
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = bh;
            if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
            {
                ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth02BC(_lcls02cc);
            }
            blV.aZ.remove(bh);
        } else
        {
            view = blV;
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = bh;
            if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
            {
                ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth02BD(_lcls02cc1);
            }
            blV.ba.remove(bh);
        }
        view = blV;
        if (!view.isRunning())
        {
            view._mth30FD();
        }
    }

    public final void _mth02B4(View view)
    {
        if (bj != 0)
        {
            FE70._mth02CA(view, 0.0F);
        }
        if (bk != 0)
        {
            FE70._mth02CB(view, 0.0F);
        }
    }

    public final void FF70(View view)
    {
    }
}
