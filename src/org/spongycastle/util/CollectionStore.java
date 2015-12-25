// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.spongycastle.util:
//            Store, Selector

public class CollectionStore
    implements Store
{

    private ArrayList aPt;

    public CollectionStore(Collection collection)
    {
        aPt = new ArrayList(collection);
    }

    public final ArrayList _mth02CB(Selector selector)
    {
        if (selector == null)
        {
            return new ArrayList(aPt);
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = aPt.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (selector._mth1D59(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        return arraylist;
    }
}
