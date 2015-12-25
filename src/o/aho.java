// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            FE70, _cls1646, ahn, ahq

final class aho
    implements Runnable
{

    private ArrayList bd;
    private ArrayList bg;
    private ArrayList blU;
    private ahn blV;

    aho(ahn ahn1, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2)
    {
        blV = ahn1;
        blU = arraylist;
        bd = arraylist1;
        bg = arraylist2;
        super();
    }

    public final void run()
    {
        ahn._cls02CA _lcls02ca;
        ahn ahn1;
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc;
        Object obj;
        int i;
        int k;
        for (Iterator iterator = blU.iterator(); iterator.hasNext(); ((_cls1646) (obj))._mth02CB(((android.support.v7.widget.RecyclerView._cls02CE) (ahn1)).eE)._mth02CA(new ahq(ahn1, _lcls02ca, _lcls02cc, k, i, ((_cls1646) (obj)))).start())
        {
            _lcls02ca = (ahn._cls02CA)iterator.next();
            ahn1 = blV;
            _lcls02cc = _lcls02ca.bv;
            k = _lcls02ca.br;
            i = _lcls02ca.bs;
            int l = _lcls02ca.bt;
            int j = _lcls02ca.bu;
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
            if (_lcls02ca.bma)
            {
                ahn1.aZ.add(_lcls02cc);
            } else
            {
                ahn1.ba.add(_lcls02cc);
            }
            obj = FE70._mth1428(((android.view.View) (obj)));
        }

        bd.clear();
        blV.aX.remove(bd);
        bg.clear();
        blV.aW.remove(bg);
    }
}
