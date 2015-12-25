// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package o:
//            _cls067A, _cls05E3, _cls062A, _cls043A, 
//            _cls03DC, ra, rl, _cls067B, 
//            _cls1EF2

final class _cls04E7
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}

    /* member class not found */
    class _cls1FBE {}


    private static final _cls067A vf = new _cls067A("", "", 0L);
    private static final _cls02BC vg[] = new _cls02BC[0];
    private static final _cls1FBE vh[] = new _cls1FBE[0];
    private static final aux vi[] = new aux[0];
    private static final _cls02CA vj[] = new _cls02CA[0];
    private static final _cls02CB vk[] = new _cls02CB[0];

    _cls04E7()
    {
    }

    private static _cls02BD _mth02CA(_cls062A a_pcls062a[])
    {
        _cls02CB a_lcls02cb[];
        if (a_pcls062a != null)
        {
            a_lcls02cb = new _cls02CB[a_pcls062a.length];
        } else
        {
            a_lcls02cb = vk;
        }
        for (int i = 0; i < a_lcls02cb.length; i++)
        {
            a_lcls02cb[i] = new _cls02CB(a_pcls062a[i]);
        }

        return new _cls02BD(a_lcls02cb);
    }

    private static _cls02BD _mth02CA(_cls067B a_pcls067b[])
    {
        aux aaux[];
        if (a_pcls067b != null)
        {
            aaux = new aux[a_pcls067b.length];
        } else
        {
            aaux = vi;
        }
        for (int i = 0; i < aaux.length; i++)
        {
            aaux[i] = new aux(a_pcls067b[i]);
        }

        return new _cls02BD(aaux);
    }

    public static void _mth02CA(_cls05E3 _pcls05e3, _cls043A _pcls043a, Map map, _cls1EF2 _pcls1ef2)
    {
        Object obj;
        if (_pcls05e3.wi != null)
        {
            obj = _pcls05e3.wi;
        } else
        {
            obj = vf;
        }
        Object obj1 = new _cls037A(((_cls067A) (obj)));
        _cls05E3 a_lcls05e3[] = _pcls05e3.wj;
        Object aobj[];
        if (a_lcls05e3 != null)
        {
            aobj = new _cls1FBE[a_lcls05e3.length];
        } else
        {
            aobj = vh;
        }
        for (int i = 0; i < aobj.length; i++)
        {
            _cls05E3 _lcls05e3 = a_lcls05e3[i];
            aobj[i] = new _cls1FBE(_lcls05e3, _mth02CA(_lcls05e3.wn));
        }

        _cls02BD _lcls02bd = new _cls02BD(((_cls02BC []) (aobj)));
        _cls05E3 a_lcls05e3_1[] = _pcls05e3.wk;
        if (a_lcls05e3_1 != null)
        {
            aobj = new _cls02CA[a_lcls05e3_1.length];
        } else
        {
            aobj = vj;
        }
        for (int j = 0; j < aobj.length; j++)
        {
            aobj[j] = new _cls02CA(a_lcls05e3_1[j]);
        }

        aobj = new if(((_cls037A) (obj1)), _lcls02bd, new _cls02BD(((_cls02BC []) (aobj))));
        _cls062A a_lcls062a[] = _pcls05e3.wl;
        map = new TreeMap(map);
        if (a_lcls062a != null)
        {
            int i1 = a_lcls062a.length;
            for (int k = 0; k < i1; k++)
            {
                _cls062A _lcls062a = a_lcls062a[k];
                map.put(_lcls062a.key, _lcls062a.value);
            }

        }
        map = (java.util.Map.Entry[])map.entrySet().toArray(new java.util.Map.Entry[map.size()]);
        a_lcls062a = new _cls062A[map.length];
        for (int l = 0; l < a_lcls062a.length; l++)
        {
            a_lcls062a[l] = new _cls062A((String)map[l].getKey(), (String)map[l].getValue());
        }

        map = new if(((if) (aobj)), _mth02CA(a_lcls062a));
        aobj = _pcls05e3.wm;
        aobj = new _cls02CE((float)((_cls05E3) (aobj)).wg / 100F, ((_cls05E3) (aobj)).vp, ((_cls05E3) (aobj)).wh, ((_cls05E3) (aobj)).orientation, ((_cls05E3) (aobj)).wc - ((_cls05E3) (aobj)).we, ((_cls05E3) (aobj)).wd - ((_cls05E3) (aobj)).wf);
        a_lcls062a = _pcls043a.ve.FB1F();
        if (a_lcls062a == null)
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "No log data to include with this event.");
        }
        _pcls043a.ve.FB33();
        if (a_lcls062a != null)
        {
            _pcls043a = new _cls141D(a_lcls062a);
        } else
        {
            _pcls043a = new _cls02BB();
        }
        (new _cls02CF(_pcls05e3.timestamp, "ndk-crash", new _cls02BC[] {
            map, aobj, _pcls043a
        }))._mth02CB(_pcls1ef2);
    }

    static _cls02BC[] FB5D()
    {
        return vg;
    }

}
