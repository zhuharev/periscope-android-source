// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            zd, zs

final class zi extends zd
{

    public zi(String s, zs zs, Map map)
    {
        super(s, zs, map);
    }

    public final void _mth037A(List list)
    {
        if (aWA.isEmpty())
        {
            return;
        } else
        {
            list.add(new zp.if(aWz));
            list.addAll(aWA.subList(0, Math.min(100, aWA.size())));
            return;
        }
    }
}
