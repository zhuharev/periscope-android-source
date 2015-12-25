// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1646, FE70, ahn

final class ahr extends ahn._cls02CB
{

    private ahn blV;
    private ahn.if blX;
    private _cls1646 bm;

    ahr(ahn ahn1, ahn.if if1, _cls1646 _pcls1646)
    {
        blV = ahn1;
        blX = if1;
        bm = _pcls1646;
        super((byte)0);
    }

    public final void _mth02B3(View view)
    {
        bm._mth02CA(null);
        FE70._mth02CE(view, 1.0F);
        FE70._mth02CA(view, 0.0F);
        FE70._mth02CB(view, 0.0F);
        FE70._mth02CF(view, 1.0F);
        view = blV;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = blX.bp;
        if (((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA != null)
        {
            ((android.support.v7.widget.RecyclerView._cls02CE) (view)).eA._mth037A(_lcls02cc);
        }
        blV.bc.remove(blX.bp);
        view = blV;
        if (!view.isRunning())
        {
            view._mth30FD();
        }
    }

    public final void FF70(View view)
    {
    }
}
