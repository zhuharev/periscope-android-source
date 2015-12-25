// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package o:
//            FEAE

public class _cls05D7
{

    private final int nE;
    public int nG;
    public final LinkedHashMap si = new LinkedHashMap(100, 0.75F, true);
    private int _fld1D31;

    public _cls05D7(int i)
    {
        nG = 0;
        nE = i;
        _fld1D31 = i;
    }

    public final Object put(Object obj, Object obj1)
    {
        if (_mth02B4(obj1) >= _fld1D31)
        {
            _mth02CF(obj, obj1);
            return null;
        }
        obj = si.put(obj, obj1);
        if (obj1 != null)
        {
            nG = nG + _mth02B4(obj1);
        }
        if (obj != null)
        {
            nG = nG - _mth02B4(obj);
        }
        trimToSize(_fld1D31);
        return obj;
    }

    public final void trimToSize(int i)
    {
        while (nG > i) 
        {
            Object obj1 = (java.util.Map.Entry)si.entrySet().iterator().next();
            Object obj = ((java.util.Map.Entry) (obj1)).getValue();
            nG = nG - _mth02B4(obj);
            obj1 = ((java.util.Map.Entry) (obj1)).getKey();
            si.remove(obj1);
            _mth02CF(obj1, obj);
        }
    }

    public int _mth02B4(Object obj)
    {
        return 1;
    }

    public void _mth02CF(Object obj, Object obj1)
    {
    }

    public final Object _mth037A(FEAE feae)
    {
        feae = ((FEAE) (si.remove(feae)));
        if (feae != null)
        {
            nG = nG - _mth02B4(feae);
        }
        return feae;
    }

    public final void _mth1E59()
    {
        trimToSize(0);
    }
}
