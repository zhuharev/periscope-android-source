// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// Referenced classes of package o:
//            zg, atv, ze, yw, 
//            atn, ato, ati, aui

public abstract class zc
    implements zg
{
    final class if
        implements Comparator
    {

        private zc aWx;

        public final int compare(Object obj, Object obj1)
        {
            obj = (atv)obj;
            obj1 = (atv)obj1;
            obj = (atn)aWx.aWs.get(((atv) (obj)).ga());
            obj1 = (atn)aWx.aWs.get(((atv) (obj1)).ga());
            if (obj != null && obj1 != null)
            {
                return Boolean.valueOf(aWx._mth02CF(((atn) (obj)))).compareTo(Boolean.valueOf(aWx._mth02CF(((atn) (obj1))))) * -1;
            }
            return obj == null ? 1 : -1;
        }

        if()
        {
            aWx = zc.this;
            super();
        }
    }


    protected final Map aWs;
    private final int aWt;
    public final HashSet aWu = new HashSet();
    private final if aWv = new if();
    protected int aWw;
    public ArrayList FF89;

    public zc(Map map, int i)
    {
        FF89 = new ArrayList();
        aWs = map;
        aWt = i;
    }

    public final void remove(String s)
    {
        for (int i = FF89.size() - 1; i >= 0; i--)
        {
            if (Objects.equals(((atv)FF89.get(i)).ga(), s))
            {
                FF89.remove(i);
                for (s = aWu.iterator(); s.hasNext(); ((zg.if)s.next()).FE7A(i, 1)) { }
                return;
            }
        }

    }

    public abstract void u();

    public final int v()
    {
        return FF89.size();
    }

    public final int w()
    {
        return aWw;
    }

    public final void _mth02CB(Collection collection)
    {
        int i1 = FF89.size();
        FF89.clear();
        FF89.addAll(collection);
        collection = new ze(aWs);
        yw ayw[] = yw.aWq;
        int l = ayw.length;
        for (int i = 0; i < l; i++)
        {
            yw yw1 = ayw[i];
            ArrayList arraylist = FF89;
            collection.aWC = yw1;
            Collections.sort(arraylist, collection);
        }

        Collections.sort(FF89, aWv);
        if (aWt > 0)
        {
            int j1 = Math.min(FF89.size(), aWt);
            for (int j = 0; j < j1; j++)
            {
                collection = _mth1D49(j);
                if (collection == null)
                {
                    continue;
                }
                boolean flag;
                if (((atn) (collection)).bDW == ato.bEd)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && _mth02CF(collection))
                {
                    FF89.set(j, new ati(atv.if.bEi, collection.id()));
                }
            }

        }
        u();
        int k = FF89.size();
        for (collection = aWu.iterator(); collection.hasNext();)
        {
            zg.if if1 = (zg.if)collection.next();
            if (i1 == 0)
            {
                if1.FE76(0, k);
            } else
            {
                if1.onDataSetChanged();
            }
        }

    }

    protected boolean _mth02CF(atn atn1)
    {
        return atn1.bDY;
    }

    public final atn _mth144B(String s)
    {
        if (aui._mth02BF(s))
        {
            return (atn)aWs.get(s);
        } else
        {
            return null;
        }
    }

    public final atn _mth1D49(int i)
    {
        String s = ((atv)FF89.get(i)).ga();
        if (aui._mth02BF(s))
        {
            return (atn)aWs.get(s);
        } else
        {
            return null;
        }
    }

    public final Object _mth1D4A(int i)
    {
        return (atv)FF89.get(i);
    }
}
