// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package o:
//            qh, qg

public abstract class qd
    implements qh
{

    private final String Pn;
    public final HashMap Po = new HashMap();
    private final HashMap Pp = new HashMap();
    public final HashMap Pq = new HashMap();
    public final HashMap Pr = new HashMap();
    private boolean Ps;

    public qd(String s)
    {
        Pn = s;
        s = new qg("Time Spent (Seconds)");
        if (((qg) (s)).Pt == 0L)
        {
            s.Pt = System.currentTimeMillis();
        }
        s.Pv = true;
        Pr.put("Time Spent (Seconds)", s);
        Pq.put("Previous Screen", "None");
    }

    public final String getIdentifier()
    {
        return Pn;
    }

    public final void setAttribute(String s, String s1)
    {
        Pq.put(s, s1);
    }

    public final void _mth0264()
    {
        for (Iterator iterator = Pr.entrySet().iterator(); iterator.hasNext(); ((qg)((java.util.Map.Entry)iterator.next()).getValue()).stop()) { }
    }

    public final void _mth026C()
    {
        for (Iterator iterator = Pr.entrySet().iterator(); iterator.hasNext();)
        {
            qg qg1 = (qg)((java.util.Map.Entry)iterator.next()).getValue();
            if (qg1.Pt == 0L)
            {
                qg1.Pt = System.currentTimeMillis();
            }
            qg1.Pv = true;
        }

    }

    public final transient void _mth02CB(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Po.put(s, Boolean.valueOf(false));
        }

    }

    public final transient void _mth02CE(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Pp.put(s, Long.valueOf(0L));
        }

    }

    public final void _mth02E3(String s)
    {
        Pq.put("Previous Screen", s);
    }

    public HashMap _mth03A4()
    {
        Ps = true;
        HashMap hashmap = new HashMap();
        Object obj;
        Object obj1;
        for (Iterator iterator2 = Po.entrySet().iterator(); iterator2.hasNext(); hashmap.put(obj1, obj))
        {
            obj = (java.util.Map.Entry)iterator2.next();
            obj1 = ((java.util.Map.Entry) (obj)).getKey();
            if (((Boolean)((java.util.Map.Entry) (obj)).getValue()).booleanValue())
            {
                obj = "Yes";
            } else
            {
                obj = "No";
            }
        }

        java.util.Map.Entry entry;
        for (Iterator iterator = Pp.entrySet().iterator(); iterator.hasNext(); hashmap.put(entry.getKey(), ((Long)entry.getValue()).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        Object obj2;
        long l;
        for (Iterator iterator1 = Pr.entrySet().iterator(); iterator1.hasNext(); hashmap.put(obj2, String.valueOf(l / 1000L)))
        {
            obj2 = (java.util.Map.Entry)iterator1.next();
            qg qg1 = (qg)((java.util.Map.Entry) (obj2)).getValue();
            qg1.stop();
            obj2 = ((java.util.Map.Entry) (obj2)).getKey();
            if (qg1.Pv)
            {
                l = qg1.Pw + (System.currentTimeMillis() - qg1.Pt);
            } else
            {
                l = qg1.Pw;
            }
        }

        hashmap.putAll(Pq);
        return hashmap;
    }

    public boolean _mth03BF()
    {
        return Ps;
    }

    public final void _mth05D5(String s)
    {
        Long long1 = (Long)Pp.get(s);
        if (long1 == null)
        {
            Pp.put(s, Long.valueOf(1L));
            return;
        } else
        {
            long l = long1.longValue();
            Pp.put(s, Long.valueOf(l + 1L));
            return;
        }
    }

    public final void _mth06E6(String s)
    {
        s = (qg)Pr.get(s);
        if (s != null)
        {
            if (((qg) (s)).Pt == 0L)
            {
                s.Pt = System.currentTimeMillis();
            }
            s.Pv = true;
        }
    }

    public final void _mth0E40(String s)
    {
        s = (qg)Pr.get(s);
        if (s != null)
        {
            s.stop();
        }
    }
}
