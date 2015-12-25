// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.SparseArray;
import com.codahale.metrics.Counter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package o:
//            auf

public final class yi
{

    final LinkedHashSet aUO = new LinkedHashSet();
    private final int aUP = 1000;
    private final int aUQ = 1;
    public final SparseArray aUR = new SparseArray();

    public yi()
    {
        aUR.append(2, new Counter());
        aUR.append(1, new Counter());
    }

    private void b()
    {
        int i = (aUO.size() + 1) - 1000;
        if (i > 0)
        {
            int k = Math.max(1, i);
            Iterator iterator = aUO.iterator();
            for (int j = 0; iterator.hasNext() && j < k; j++)
            {
                iterator.next();
                iterator.remove();
            }

            return;
        } else
        {
            return;
        }
    }

    public final boolean _mth02CB(auf auf1)
    {
        String s = auf1._mth1F35();
        if (aUO.remove(s))
        {
            ((Counter)aUR.get(auf1.gF())).inc();
            return true;
        } else
        {
            b();
            aUO.add(s);
            return false;
        }
    }
}
