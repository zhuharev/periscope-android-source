// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            cv, cs, cu

public class cr extends cv
    implements Map
{

    private cs BZ;

    public cr()
    {
    }

    public Set entrySet()
    {
        if (BZ == null)
        {
            BZ = new cs(this);
        }
        cs cs1 = BZ;
        if (((cu) (cs1)).Cb == null)
        {
            cs1.Cb = new cu._cls02CA(cs1);
        }
        return ((cu) (cs1)).Cb;
    }

    public Set keySet()
    {
        if (BZ == null)
        {
            BZ = new cs(this);
        }
        cs cs1 = BZ;
        if (((cu) (cs1)).Cc == null)
        {
            cs1.Cc = new cu._cls02CB(cs1);
        }
        return ((cu) (cs1)).Cc;
    }

    public void putAll(Map map)
    {
        int i = _fld1D61 + map.size();
        if (super.FB40.length < i)
        {
            int ai[] = super.FB40;
            Object aobj[] = super.FB48;
            super._mth1422(i);
            if (super._fld1D61 > 0)
            {
                System.arraycopy(ai, 0, super.FB40, 0, super._fld1D61);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (super.FB48)), 0, super._fld1D61 << 1);
            }
            cv._mth02CB(ai, aobj, super._fld1D61);
        }
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        if (BZ == null)
        {
            BZ = new cs(this);
        }
        cs cs1 = BZ;
        if (((cu) (cs1)).Cd == null)
        {
            cs1.Cd = new cu._cls02CF(cs1);
        }
        return ((cu) (cs1)).Cd;
    }
}
