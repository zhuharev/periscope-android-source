// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;
import java.util.Map;

// Referenced classes of package o:
//            zc, atv, atn

final class g.Object
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

    (zc zc1)
    {
        aWx = zc1;
        super();
    }
}
