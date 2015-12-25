// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Comparator;

// Referenced classes of package com.codahale.metrics:
//            WeightedSnapshot

class this._cls0
    implements Comparator
{

    final WeightedSnapshot this$0;

    public int compare(ightedSample ightedsample, ightedSample ightedsample1)
    {
        if (ightedsample.value > ightedsample1.value)
        {
            return 1;
        }
        return ightedsample.value >= ightedsample1.value ? 0 : -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ightedSample)obj, (ightedSample)obj1);
    }

    ightedSample()
    {
        this$0 = WeightedSnapshot.this;
        super();
    }
}
