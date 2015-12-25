// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package o:
//            kd, kg

final class AbstractSet extends AbstractSet
{

    final kd Hp;

    public final void clear()
    {
        Hp.clear();
    }

    public final boolean contains(Object obj)
    {
        return Hp.containsKey(obj);
    }

    public final Iterator iterator()
    {
        return new kg(this);
    }

    public final boolean remove(Object obj)
    {
        kd kd1 = Hp;
        obj = kd1._mth1420(obj);
        if (obj != null)
        {
            kd1._mth02CA(((Object) (obj)), true);
        }
        return obj != null;
    }

    public final int size()
    {
        return Hp.size;
    }

    Object(kd kd1)
    {
        Hp = kd1;
        super();
    }
}
