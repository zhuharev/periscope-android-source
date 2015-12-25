// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            atn, ato, zw, ql, 
//            ati, zc, atv

public final class yv
{
    public static final class if extends zc
    {

        public final String id()
        {
            return null;
        }

        protected final void u()
        {
        }

        public if(Map map)
        {
            super(map, -1);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    public _cls02CB aWd;
    public _cls02CA aWe;
    public _cls02CE aWf;
    public final HashMap aWg = new HashMap();
    public final HashMap aWh = new HashMap();
    public final HashMap aWi = new HashMap();
    public final HashMap aWj = new HashMap();
    public final ql mEventBus;

    public yv(ql ql1)
    {
        mEventBus = ql1;
        aWe = new _cls02CA(aWg);
        aWd = new _cls02CB(aWg);
        aWf = new _cls02CE(aWg);
    }

    private void _mth02CA(atn atn1)
    {
        atn atn2 = (atn)aWg.get(atn1.id());
        if (atn2 != null && atn2.bDY)
        {
            atn1.bDY = true;
        }
        if (atn1.fl() != null)
        {
            aWj.put(atn1.id(), atn1.fl());
        }
        _mth02CB(atn1);
    }

    private void _mth02CB(atn atn1)
    {
        if (aWg.containsKey(atn1.id()))
        {
            atn1.bEa = ((atn)aWg.get(atn1.id())).bEa;
        } else
        {
            atn1.bEa = atn1.bEa;
        }
        aWg.put(atn1.id(), atn1);
    }

    private void _mth02CE(atn atn1)
    {
        atn atn2 = (atn)aWg.get(atn1.id());
        if (atn2 != null)
        {
            boolean flag;
            if (atn2.bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || atn2.bDU)
            {
                boolean flag1;
                if (atn1.bDW == ato.bEd)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    atn1.bDU = true;
                }
            }
        }
    }

    public final void r()
    {
        mEventBus._mth1429(zw.aYM);
    }

    public final void s()
    {
        mEventBus._mth1429(zw.aYL);
    }

    public final void t()
    {
        mEventBus._mth1429(zw.aYH);
    }

    public final void _mth02BB(List list)
    {
        HashMap hashmap = new HashMap();
        atn atn1;
        for (list = list.iterator(); list.hasNext(); _mth02CB(atn1))
        {
            atn1 = (atn)list.next();
            String s1 = atn1.id();
            String s2 = atn1.id();
            hashmap.put(s1, new ati(atv.if.bEj, s2));
        }

        long l = System.currentTimeMillis();
        long l1 = TimeUnit.DAYS.toMillis(1L);
        int i = 0;
        list = ((zc) (aWf)).FF89.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            atv atv1 = (atv)list.next();
            int k = i;
            if (!hashmap.containsKey(atv1.ga()))
            {
                Object obj = atv1.ga();
                obj = (atn)aWg.get(obj);
                k = i;
                if (obj != null)
                {
                    k = i;
                    if (((atn) (obj)).bDX)
                    {
                        int j = ((atn) (obj)).bDW;
                        boolean flag;
                        if (j == ato.bEf || j == ato.bEe)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        k = i;
                        if (flag)
                        {
                            k = i;
                            if (l - ((atn) (obj)).bDV < l1)
                            {
                                hashmap.put(atv1.ga(), atv1);
                                k = i + 1;
                            }
                        }
                    }
                }
            }
            if (k > 100)
            {
                break;
            }
            i = k;
        } while (true);
        aWf._mth02CB(hashmap.values());
        r();
    }

    public final void _mth02BC(List list)
    {
        long l = System.currentTimeMillis();
        atn atn1;
        for (list = list.iterator(); list.hasNext(); aWg.put(atn1.id(), atn1))
        {
            atn1 = (atn)list.next();
            _mth02CE(atn1);
            atn atn2 = (atn)aWg.get(atn1.id());
            if (atn2 != null && atn2.bDY)
            {
                atn1.bDY = true;
            }
            atn1.bDZ = l;
        }

        mEventBus._mth1429(zw.aYI);
    }

    public final void _mth02CA(String s1, List list)
    {
        HashSet hashset = new HashSet();
        Object obj;
        for (list = list.iterator(); list.hasNext(); hashset.add(new ati(atv.if.bEj, ((String) (obj)))))
        {
            obj = (atn)list.next();
            _mth02CA(((atn) (obj)));
            obj = ((atn) (obj)).id();
        }

        list = new _cls02CF(s1, aWg);
        list._mth02CB(hashset);
        aWh.put(s1, list);
        mEventBus._mth1429(zw.aYI);
    }

    public final void _mth02CA(List list, List list1, List list2)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        HashSet hashset2 = new HashSet();
        for (list2 = list2.iterator(); list2.hasNext(); _mth02CA((atn)list2.next())) { }
        for (list = list.iterator(); list.hasNext(); _mth02CA(((atn) (list2))))
        {
            list2 = (atn)list.next();
            if (list2.eV())
            {
                String s1 = list2.id();
                hashset1.add(new ati(atv.if.bEj, s1));
            }
        }

        for (list = list1.iterator(); list.hasNext(); _mth02CA(((atn) (list1))))
        {
            list1 = (atn)list.next();
            boolean flag;
            if (((atn) (list1)).bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                list2 = list1.id();
                hashset.add(new ati(atv.if.bEj, list2));
                continue;
            }
            if (list1.eV())
            {
                list2 = list1.id();
                hashset1.add(new ati(atv.if.bEj, list2));
            } else
            {
                list2 = list1.id();
                hashset2.add(new ati(atv.if.bEj, list2));
            }
        }

        list = new HashSet();
        list.addAll(hashset);
        list.addAll(hashset1);
        list.addAll(hashset2);
        aWd._mth02CB(list);
        t();
    }

    public final void _mth02CB(HashSet hashset)
    {
        hashset = hashset.iterator();
        do
        {
            if (!hashset.hasNext())
            {
                break;
            }
            Object obj = (String)hashset.next();
            obj = (atn)aWg.get(obj);
            if (obj != null)
            {
                obj.bDW = ato.bEf;
                obj.bDV = System.currentTimeMillis();
                _mth02CE(((atn) (obj)));
            }
        } while (true);
    }

    public final String _mth05F2(String s1)
    {
        s1 = (ArrayList)aWj.get(s1);
        if (s1 == null || s1.isEmpty())
        {
            return null;
        } else
        {
            return (String)s1.get(0);
        }
    }

    public final void _mth141D(List list)
    {
        HashSet hashset = new HashSet();
        atn atn1;
        for (list = list.iterator(); list.hasNext(); _mth02CB(atn1))
        {
            atn1 = (atn)list.next();
            String s1 = atn1.id();
            hashset.add(new ati(atv.if.bEj, s1));
        }

        aWe._mth02CB(hashset);
        s();
    }

    public final void _mth1449(String s1)
    {
        aWg.remove(s1);
        aWd.remove(s1);
        aWe.remove(s1);
        aWf.remove(s1);
        aWj.remove(s1);
        for (Iterator iterator = aWh.values().iterator(); iterator.hasNext(); ((zc)iterator.next()).remove(s1)) { }
    }
}
