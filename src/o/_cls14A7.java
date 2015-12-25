// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1646, _cls10D0, FE70

final class _cls14A7 extends _cls10D0._cls02CB
{

    private _cls10D0 be;
    private android.support.v7.widget.RecyclerView._cls02CC bh;
    private _cls1646 bi;
    private int bj;
    private int bk;

    _cls14A7(_cls10D0 _pcls10d0, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i, int j, _cls1646 _pcls1646)
    {
        be = _pcls10d0;
        bh = _pcls02cc;
        bj = i;
        bk = j;
        bi = _pcls1646;
        super((byte)0);
    }

    public final void _mth02B3(View view)
    {
        bi._mth02CA(null);
        view = be;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = bh;
        if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
        {
            ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth02BD(_lcls02cc);
        }
        be.ba.remove(bh);
        view = be;
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
