// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            mz, nn, no, mx, 
//            nk, nl, nc, mw, 
//            nm

public final class aku
    implements mz
{
    static final class if
        implements no.if, mw
    {

        final mx Ks;
        final nm Kt;
        final LatLng Ku;
        private Set Kv;

        public final int getSize()
        {
            return 1;
        }

        public final volatile Collection _mth1595()
        {
            return Kv;
        }

        public final nl _mth1D3D()
        {
            return Kt;
        }

        public final LatLng FC60()
        {
            return Ku;
        }

        private if(mx mx1)
        {
            Ks = mx1;
            Ku = mx1.FC60();
            Kt = aku._mth1D39()._mth02BE(Ku);
            Kv = Collections.singleton(Ks);
        }

        if(mx mx1, byte byte0)
        {
            this(mx1);
        }
    }


    private static final nn Kr = new nn(1.0D);
    private final ArrayList Kp;
    private final no Kq;
    private final int bqR;

    public aku()
    {
        this(100);
    }

    private aku(int i)
    {
        Kp = new ArrayList();
        Kq = new no(0.0D, 1.0D, 0.0D, 1.0D);
        bqR = 100;
    }

    static nn _mth1D39()
    {
        return Kr;
    }

    public final void _mth02CA(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); _mth02CB((mx)collection.next())) { }
    }

    public final Set _mth02CB(double d)
    {
        double d2;
        HashSet hashset;
        HashSet hashset1;
        HashMap hashmap;
        HashMap hashmap1;
        int i = (int)d;
        d2 = (double)bqR / Math.pow(2D, i) / 256D;
        hashset = new HashSet();
        hashset1 = new HashSet();
        hashmap = new HashMap();
        hashmap1 = new HashMap();
        no no1 = Kq;
        no1;
        JVM INSTR monitorenter ;
        Iterator iterator = Kp.iterator();
_L3:
        if if1;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_562;
            }
            if1 = (if)iterator.next();
        } while (hashset.contains(if1));
        obj = if1.Kt;
        d = d2 / 2D;
        nk nk1 = new nk(((nl) (obj)).x - d, ((nl) (obj)).x + d, ((nl) (obj)).y - d, ((nl) (obj)).y + d);
        no no2 = Kq;
        obj = new ArrayList();
        no2._mth02CA(nk1, ((Collection) (obj)));
        if (((Collection) (obj)).size() != 1) goto _L2; else goto _L1
_L1:
        hashset1.add(if1);
        hashset.add(if1);
        hashmap.put(if1, Double.valueOf(0.0D));
          goto _L3
_L2:
        double d1;
        d1 = 0.0D;
        d = 0.0D;
        for (Iterator iterator1 = ((Collection) (obj)).iterator(); iterator1.hasNext();)
        {
            if if2 = (if)iterator1.next();
            d1 += if2.Ku.latitude;
            d += if2.Ku.longitude;
        }

        nc nc1;
        Iterator iterator2;
        nc1 = new nc(new LatLng(d1 / (double)((Collection) (obj)).size(), d / (double)((Collection) (obj)).size()));
        hashset1.add(nc1);
        iterator2 = ((Collection) (obj)).iterator();
_L5:
        if if3;
        Double double1;
        if (!iterator2.hasNext())
        {
            break MISSING_BLOCK_LABEL_549;
        }
        if3 = (if)iterator2.next();
        double1 = (Double)hashmap.get(if3);
        nm nm = if3.Kt;
        nm nm1 = if1.Kt;
        d = (((nl) (nm)).x - ((nl) (nm1)).x) * (((nl) (nm)).x - ((nl) (nm1)).x) + (((nl) (nm)).y - ((nl) (nm1)).y) * (((nl) (nm)).y - ((nl) (nm1)).y);
        if (double1 == null)
        {
            break MISSING_BLOCK_LABEL_500;
        }
        if (double1.doubleValue() < d) goto _L5; else goto _L4
_L4:
        nc nc2 = (nc)hashmap1.get(if3);
        mx mx2 = if3.Ks;
        nc2.KC.remove(mx2);
        hashmap.put(if3, Double.valueOf(d));
        mx mx1 = if3.Ks;
        nc1.KC.add(mx1);
        hashmap1.put(if3, nc1);
          goto _L5
        hashset.addAll(((Collection) (obj)));
          goto _L3
        no1;
        JVM INSTR monitorexit ;
        return hashset1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CB(mx mx1)
    {
        if if1 = new if(mx1, (byte)0);
        mx1 = Kq;
        mx1;
        JVM INSTR monitorenter ;
        Kp.add(if1);
        Kq._mth02CA(if1);
        mx1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final Collection _mth1595()
    {
        ArrayList arraylist = new ArrayList();
        no no1 = Kq;
        no1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = Kp.iterator(); iterator.hasNext(); arraylist.add(((if)iterator.next()).Ks)) { }
        no1;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth1606()
    {
        no no1 = Kq;
        no1;
        JVM INSTR monitorenter ;
        Kp.clear();
        no no2 = Kq;
        no2.LF = null;
        if (no2.KC != null)
        {
            no2.KC.clear();
        }
        no1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
