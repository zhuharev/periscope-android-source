// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            qf, qh, qc, qd

public final class qb extends Enum
    implements qi.if
{

    private static qb Pi;
    private static final qb Pm[];
    public qf Pj;
    public qc Pk;
    private String Pl;

    private qb(String s, int i)
    {
        super(s, 0);
        Pj = new qf();
    }

    public static qb valueOf(String s)
    {
        return (qb)Enum.valueOf(o/qb, s);
    }

    public static qb[] values()
    {
        return (qb[])Pm.clone();
    }

    public static qb _mth01AC()
    {
        return Pi;
    }

    private void _mth02BB(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); _mth02CA((qh)arraylist.next())) { }
    }

    public final void _mth0211()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = Pj.values().iterator(); iterator.hasNext();)
        {
            qh qh1 = (qh)iterator.next();
            if (qh1._mth03C5())
            {
                arraylist.add(qh1);
            } else
            {
                qh1._mth0264();
            }
        }

        _mth02BB(arraylist);
        Pl = null;
    }

    public final void _mth021B()
    {
        for (Iterator iterator = Pj.values().iterator(); iterator.hasNext(); ((qh)iterator.next())._mth026C()) { }
    }

    public final String _mth02B2(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s1 = Pl;
            Pl = s;
            if (TextUtils.isEmpty(s1))
            {
                s1 = "None";
            }
            HashMap hashmap = new HashMap();
            hashmap.put("Screen", s);
            hashmap.put("Previous Screen", s1);
            Pk._mth02D0(s);
            Pk.tagEvent("Viewed Screen", hashmap);
            return s1;
        }
        if (TextUtils.isEmpty(Pl))
        {
            return "None";
        } else
        {
            return Pl;
        }
    }

    public final qh _mth02CA(qd qd, boolean flag)
    {
        String s = qd.getIdentifier();
        qh qh1 = (qh)Pj.get(s);
        if (qh1 == null)
        {
            Pj._mth02CA(s, qd);
            return qd;
        } else
        {
            return qh1;
        }
    }

    public final void _mth02CA(qh qh1)
    {
        if (!qh1._mth03BF())
        {
            HashMap hashmap = qh1._mth03A4();
            String s = qh1.getName();
            Pk.tagEvent(s, hashmap);
            Pj.remove(qh1.getIdentifier());
            Log.d("Analytics", (new StringBuilder("Reported '")).append(s).append("': ").append(hashmap).toString());
        }
    }

    static 
    {
        Pi = new qb("INSTANCE", 0);
        Pm = (new qb[] {
            Pi
        });
    }
}
