// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            kb, kv, ms, iw, 
//            mq

public final class mr extends kb
{

    mr()
    {
    }

    public final void _mth02CB(mq mq1)
    {
        if (mq1 instanceof kv)
        {
            mq1 = (kv)mq1;
            mq1._mth02CA(ms.JK);
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)((kv) (mq1)).HP.get(((kv) (mq1)).HP.size() - 1)).next();
            ((kv) (mq1)).HP.add(entry.getValue());
            ((kv) (mq1)).HP.add(new iw((String)entry.getKey()));
            return;
        }
        int j = mq._mth02C9(mq1);
        int i = j;
        if (j == 0)
        {
            i = mq._mth02CC(mq1);
        }
        if (i == 13)
        {
            mq._mth02CA(mq1, 9);
            return;
        }
        if (i == 12)
        {
            mq._mth02CA(mq1, 8);
            return;
        }
        if (i == 14)
        {
            mq._mth02CA(mq1, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(mq1._mth13A2()).append("  at line ").append(mq._mth02CD(mq1)).append(" column ").append(mq._mth02D1(mq1)).append(" path ").append(mq1.getPath()).toString());
        }
    }
}
