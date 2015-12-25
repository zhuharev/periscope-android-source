// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;
import java.util.Map;

// Referenced classes of package o:
//            yw, atv, atn

final class ze
    implements Comparator
{

    yw aWC;
    private final Map aWs;

    ze(Map map)
    {
        aWs = map;
        aWC = yw.aWl;
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (atv)obj;
        obj1 = (atv)obj1;
        obj = (atn)aWs.get(((atv) (obj)).ga());
        obj1 = (atn)aWs.get(((atv) (obj1)).ga());
        if (obj != null && obj1 != null)
        {
            return aWC.compare(obj, obj1);
        }
        return obj == null ? 1 : -1;
    }
}
