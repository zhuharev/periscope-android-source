// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            yu, aon, aui, zp, 
//            zd, zs

public class zr extends yu
{

    protected String aUN;
    private aon aWW;
    protected zs aWz;

    public zr(zp zp1)
    {
        super(zp1);
        aWW = new aon();
    }

    public void A()
    {
        if (aWz == null)
        {
            aWW.clear();
            return;
        }
        Object obj1 = mUserManager;
        String s1 = aUN;
        Object obj = aWz;
        if (aui.isEmpty(s1) || s1.equals(((zp) (obj1)).H().id))
        {
            obj = ((zd)((zp) (obj1)).aWI.get(obj)).y();
        } else
        {
            obj1 = (Map)((zp) (obj1)).aWK.get(s1);
            if (obj1 == null || ((Map) (obj1)).get(obj) == null)
            {
                obj = Collections.emptyList();
            } else
            {
                obj = ((zd)((Map) (obj1)).get(obj)).y();
            }
        }
        aWW.keySet().retainAll(((java.util.Collection) (obj)));
        int i = 0;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s = (String)((Iterator) (obj)).next();
            aWW.put(s, Integer.valueOf(i));
            i++;
        }

    }

    public String id()
    {
        return null;
    }

    public int v()
    {
        return aWW.size();
    }

    public final void _mth02CA(zs zs1)
    {
        if (aWz == null || !aWz.equals(zs1))
        {
            aWz = zs1;
            aWW.clear();
            A();
        }
    }

    public final zs _mth04C0(String s)
    {
        return mUserManager._mth153E(s);
    }

    public final void _mth1550(String s)
    {
        if (aUN == null || !aUN.equals(s))
        {
            aUN = s;
            aWW.clear();
            A();
        }
    }

    public Object _mth1D4A(int i)
    {
        return _mth1E2F(i);
    }

    public PsUser _mth1E2F(int i)
    {
        Object obj;
label0:
        {
            obj = aWW;
            if (i >= 0)
            {
                obj = ((aon) (obj)).entrySet();
                int j = 0;
                for (Iterator iterator = ((Set) (obj)).iterator(); iterator.hasNext();)
                {
                    obj = (java.util.Map.Entry)iterator.next();
                    if (j == i)
                    {
                        break label0;
                    }
                    j++;
                }

            }
            obj = null;
        }
        return mUserManager._mth02CA(aWz, aUN, ((Integer)((java.util.Map.Entry) (obj)).getValue()).intValue());
    }
}
