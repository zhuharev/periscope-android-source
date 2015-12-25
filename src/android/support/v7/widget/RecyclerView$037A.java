// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static final class eP
{

    SparseArray eN;
    private SparseIntArray eO;
    int eP;

    public final eP _mth1D36(int i)
    {
        ArrayList arraylist = (ArrayList)eN.get(i);
        if (arraylist != null && !arraylist.isEmpty())
        {
            i = arraylist.size() - 1;
            eP ep = (eN)arraylist.get(i);
            arraylist.remove(i);
            return ep;
        } else
        {
            return null;
        }
    }

    public final void _mth1FBE(eN en)
    {
        int i = en.getItemViewType();
        ArrayList arraylist1 = (ArrayList)eN.get(i);
        ArrayList arraylist = arraylist1;
        if (arraylist1 == null)
        {
            ArrayList arraylist2 = new ArrayList();
            eN.put(i, arraylist2);
            arraylist = arraylist2;
            if (eO.indexOfKey(i) < 0)
            {
                eO.put(i, 5);
                arraylist = arraylist2;
            }
        }
        if (eO.get(i) <= arraylist.size())
        {
            return;
        } else
        {
            en.resetInternal();
            arraylist.add(en);
            return;
        }
    }

    public ()
    {
        eN = new SparseArray();
        eO = new SparseIntArray();
        eP = 0;
    }
}
