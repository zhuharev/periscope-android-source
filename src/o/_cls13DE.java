// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            FE70, _cls10D0, _cls1646, _cls14A5

final class _cls13DE
    implements Runnable
{

    private _cls10D0 be;
    private ArrayList bg;

    _cls13DE(_cls10D0 _pcls10d0, ArrayList arraylist)
    {
        be = _pcls10d0;
        bg = arraylist;
        super();
    }

    public final void run()
    {
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc;
        _cls10D0 _lcls10d0;
        _cls1646 _lcls1646;
        for (Iterator iterator = bg.iterator(); iterator.hasNext(); _lcls1646._mth02CE(1.0F)._mth02CB(((android.support.v7.widget.RecyclerView._cls02CE) (_lcls10d0)).eC)._mth02CA(new _cls14A5(_lcls10d0, _lcls02cc, _lcls1646)).start())
        {
            _lcls02cc = (android.support.v7.widget.RecyclerView._cls02CC)iterator.next();
            _lcls10d0 = be;
            _lcls1646 = FE70._mth1428(_lcls02cc.fy);
            _lcls10d0.aZ.add(_lcls02cc);
        }

        bg.clear();
        be.aW.remove(bg);
    }
}
