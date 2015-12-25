// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            ahn, FE70, _cls1646, ahr, 
//            ahs

final class ahp
    implements Runnable
{

    private ArrayList bf;
    private ahn blV;

    ahp(ahn ahn1, ArrayList arraylist)
    {
        blV = ahn1;
        bf = arraylist;
        super();
    }

    public final void run()
    {
        Iterator iterator = bf.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ahn.if if1 = (ahn.if)iterator.next();
            ahn ahn1 = blV;
            View view = if1.bp.fy;
            Object obj = if1.bq;
            if (obj != null)
            {
                obj = ((android.support.v7.widget.RecyclerView._cls02CC) (obj)).fy;
            } else
            {
                obj = null;
            }
            ahn1.bc.add(if1.bp);
            _cls1646 _lcls1646_1 = FE70._mth1428(view)._mth02CB(((android.support.v7.widget.RecyclerView._cls02CE) (ahn1)).eF);
            _lcls1646_1._mth02CF(if1.bt - if1.br);
            _lcls1646_1._mth141D(if1.bu - if1.bs);
            if (if1.blZ != if1.blY)
            {
                view.setPivotX(0.0F);
                view.setPivotY(0.0F);
                _lcls1646_1._mth02BB((float)if1.blZ / (float)if1.blY);
            }
            _lcls1646_1._mth02CE(0.0F)._mth02CA(new ahr(ahn1, if1, _lcls1646_1)).start();
            if (obj != null)
            {
                ahn1.bc.add(if1.bq);
                _cls1646 _lcls1646 = FE70._mth1428(((View) (obj)));
                _lcls1646._mth02CF(0.0F)._mth141D(0.0F)._mth02CB(((android.support.v7.widget.RecyclerView._cls02CE) (ahn1)).eF)._mth02CE(1.0F)._mth02CA(new ahs(ahn1, if1, _lcls1646, ((View) (obj)))).start();
            }
        } while (true);
        bf.clear();
        blV.aY.remove(bf);
    }
}
