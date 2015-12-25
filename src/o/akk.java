// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            asc, arx, aio, akv, 
//            ati, yv, zc, aig, 
//            apq, akl

final class akk
    implements asc
{

    final arx bgt;
    final apq bpy;
    private final aig bqE;
    private final aio bqF;
    private final yv mBroadcastCacheManager;

    public akk(arx arx1, apq apq1, aig aig1, yv yv1)
    {
        bgt = arx1;
        bpy = apq1;
        bqE = aig1;
        mBroadcastCacheManager = yv1;
        arx1 = arx1.getResources();
        bqF = new aio(arx1.getDimensionPixelOffset(0x7f09005b), arx1.getDimensionPixelOffset(0x7f09008f), yv1);
    }

    public final void aN()
    {
        bgt._mth14A2(bpy);
    }

    public final boolean aO()
    {
        return arx._mth1424(bpy);
    }

    public final void _mth1D65(Object obj)
    {
        Object obj2 = (List)obj;
        obj = bqE;
        Object obj1 = mBroadcastCacheManager;
        ArrayList arraylist = new ArrayList(((Collection) (obj2)).size());
        String s;
        for (obj2 = ((Collection) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(new ati(atv.if.bEj, s)))
        {
            s = ((akv)((Iterator) (obj2)).next()).broadcastId;
        }

        obj1 = new yv.if(((yv) (obj1)).aWg);
        ((zc) (obj1))._mth02CB(arraylist);
        obj.bmU = ((zc) (obj1));
        ((android.support.v7.widget.RecyclerView.if) (bqE)).ey.notifyChanged();
        bpy.setItemDecoration(bqF);
        bpy.setAdapter(bqE);
        obj = bpy.getViewTreeObserver();
        ((ViewTreeObserver) (obj)).addOnPreDrawListener(new akl(this, ((ViewTreeObserver) (obj))));
        bpy.setVisibility(0);
    }
}
