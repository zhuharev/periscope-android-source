// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            FE70, _cls1646, _cls10D0, _cls14A7

final class _cls10D8
    implements Runnable
{

    private ArrayList bd;
    private _cls10D0 be;

    _cls10D8(_cls10D0 _pcls10d0, ArrayList arraylist)
    {
        be = _pcls10d0;
        bd = arraylist;
        super();
    }

    public final void run()
    {
        _cls10D0 _lcls10d0;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc;
        Object obj;
        int i;
        int k;
        for (Iterator iterator = bd.iterator(); iterator.hasNext(); ((_cls1646) (obj))._mth02CB(((android.support.v7.widget.RecyclerView._cls02CE) (_lcls10d0)).eE)._mth02CA(new _cls14A7(_lcls10d0, _lcls02cc, k, i, ((_cls1646) (obj)))).start())
        {
            obj = (_cls10D0._cls02CA)iterator.next();
            _lcls10d0 = be;
            _lcls02cc = ((_cls10D0._cls02CA) (obj)).bv;
            k = ((_cls10D0._cls02CA) (obj)).br;
            i = ((_cls10D0._cls02CA) (obj)).bs;
            int l = ((_cls10D0._cls02CA) (obj)).bt;
            int j = ((_cls10D0._cls02CA) (obj)).bu;
            obj = _lcls02cc.fy;
            k = l - k;
            i = j - i;
            if (k != 0)
            {
                FE70._mth1428(((android.view.View) (obj)))._mth02CF(0.0F);
            }
            if (i != 0)
            {
                FE70._mth1428(((android.view.View) (obj)))._mth141D(0.0F);
            }
            obj = FE70._mth1428(((android.view.View) (obj)));
            _lcls10d0.ba.add(_lcls02cc);
        }

        bd.clear();
        be.aX.remove(bd);
    }
}
