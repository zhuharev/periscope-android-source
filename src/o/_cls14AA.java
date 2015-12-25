// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1646, FE70, _cls10D0

final class _cls14AA extends _cls10D0._cls02CB
{

    private _cls10D0 be;
    private _cls10D0.if bl;
    private _cls1646 bm;

    _cls14AA(_cls10D0 _pcls10d0, _cls10D0.if if1, _cls1646 _pcls1646)
    {
        be = _pcls10d0;
        bl = if1;
        bm = _pcls1646;
        super((byte)0);
    }

    public final void _mth02B3(View view)
    {
        bm._mth02CA(null);
        FE70._mth02CE(view, 1.0F);
        FE70._mth02CA(view, 0.0F);
        FE70._mth02CB(view, 0.0F);
        view = be;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = bl.bp;
        if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
        {
            ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth037A(_lcls02cc);
        }
        be.bc.remove(bl.bp);
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
