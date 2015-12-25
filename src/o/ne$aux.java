// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            ne, ez, mw, nn, 
//            my

final class .Set
    implements Runnable
{

    final ne KW;
    private Set Lo;
    Runnable Lp;
    ez Lq;
    nn Lr;
    float Ls;

    public final void run()
    {
        if (Lo.equals(ne._mth02BC(KW)))
        {
            Lp.run();
            return;
        }
          = new (KW, (byte)0);
        float f = Ls;
        boolean flag;
        if (f > ne._mth02BB(KW))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        float f1 = ne._mth02BB(KW);
        Set set1 = ne._mth02BD(KW);
        LatLngBounds latlngbounds = Lq._mth0689().FK;
        Object obj1 = null;
        Object obj = obj1;
        if (ne._mth02BC(KW) != null)
        {
            obj = obj1;
            if (ne._mth1E39())
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator2 = ne._mth02BC(KW).iterator();
                do
                {
                    obj = arraylist;
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    obj = (mw)iterator2.next();
                    if (KW._mth02CB(((mw) (obj))) && latlngbounds._mth02BD(((mw) (obj)).FC60()))
                    {
                        arraylist.add(Lr._mth02BE(((mw) (obj)).FC60()));
                    }
                } while (true);
            }
        }
        Set set = Collections.newSetFromMap(new ConcurrentHashMap());
        for (Iterator iterator = Lo.iterator(); iterator.hasNext();)
        {
            mw mw1 = (mw)iterator.next();
            boolean flag1 = latlngbounds._mth02BD(mw1.FC60());
            if (flag && flag1 && ne._mth1E39())
            {
                Object obj4 = ne._mth02CA(((ArrayList) (obj)), Lr._mth02BE(mw1.FC60()));
                if (obj4 != null)
                {
                    obj4 = Lr._mth02CA(((nl) (obj4)));
                    ._mth02CA(true, new (KW, mw1, set, ((com.google.android.gms.maps.model.LatLng) (obj4))));
                } else
                {
                    ._mth02CA(true, new (KW, mw1, set, null));
                }
            } else
            {
                ._mth02CA(flag1, new (KW, mw1, set, null));
            }
        }

        ._mth1E5D();
        set1.removeAll(set);
        obj = null;
        if (ne._mth1E39())
        {
            ArrayList arraylist1 = new ArrayList();
            Iterator iterator3 = Lo.iterator();
            do
            {
                obj = arraylist1;
                if (!iterator3.hasNext())
                {
                    break;
                }
                obj = (mw)iterator3.next();
                if (KW._mth02CB(((mw) (obj))) && latlngbounds._mth02BD(((mw) (obj)).FC60()))
                {
                    arraylist1.add(Lr._mth02BE(((mw) (obj)).FC60()));
                }
            } while (true);
        }
        for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();)
        {
            Object obj2 = ()iterator1.next();
            boolean flag2 = latlngbounds._mth02BD((() (obj2)).FA);
            if (!flag && f - f1 > -3F && flag2 && ne._mth1E39())
            {
                Object obj3 = ne._mth02CA(((ArrayList) (obj)), Lr._mth02BE((() (obj2)).FA));
                if (obj3 != null)
                {
                    obj3 = Lr._mth02CA(((nl) (obj3)));
                    com.google.android.gms.maps.model.LatLng latlng = (() (obj2)).FA;
                    .nX.lock();
                    obj2 = new init>(.KW, (() (obj2)), latlng, ((com.google.android.gms.maps.model.LatLng) (obj3)), (byte)0);
                    obj2.c = ne._mth037A(.KW).Kc;
                    obj2.b = true;
                    .Lm.add(obj2);
                    .nX.unlock();
                } else
                {
                    ._mth02CA(true, (() (obj2)).KY);
                }
            } else
            {
                ._mth02CA(flag2, (() (obj2)).KY);
            }
        }

        ._mth1E5D();
        ne._mth02CA(KW, set);
        ne._mth02CB(KW, Lo);
        ne._mth02CA(KW, f);
        Lp.run();
    }

    private .Set(ne ne1, Set set)
    {
        KW = ne1;
        super();
        Lo = set;
    }

    .Set(ne ne1, Set set, byte byte0)
    {
        this(ne1, set);
    }
}
