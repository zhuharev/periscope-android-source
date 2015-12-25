// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1646, FE70, _cls10D0

final class _cls14A3 extends _cls10D0._cls02CB
{

    private _cls10D0 be;
    private android.support.v7.widget.RecyclerView._cls02CC bh;
    private _cls1646 bi;

    _cls14A3(_cls10D0 _pcls10d0, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, _cls1646 _pcls1646)
    {
        be = _pcls10d0;
        bh = _pcls02cc;
        bi = _pcls1646;
        super((byte)0);
    }

    public final void _mth02B3(View view)
    {
        bi._mth02CA(null);
        FE70._mth02CE(view, 1.0F);
        view = be;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = bh;
        if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
        {
            ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth02BB(_lcls02cc);
        }
        be.bb.remove(bh);
        view = be;
        if (!view.isRunning())
        {
            view._mth30FD();
        }
    }

    public final void FF70(View view)
    {
    }
}
