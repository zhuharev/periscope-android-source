// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package o:
//            bx, cd

final class AY extends 
{

    private bx AM;
    private final ArrayList AY;

    public final void _mth216C()
    {
        Set set = AM.Au.Bk;
        Object obj = set;
        if (set.isEmpty())
        {
            obj = AM.FEAC();
        }
        for (Iterator iterator = AY.iterator(); iterator.hasNext(); ((CA)iterator.next())._mth02CA(AM.AI, ((Set) (obj)))) { }
    }

    public .ArrayList(bx bx1, ArrayList arraylist)
    {
        AM = bx1;
        super(bx1, (byte)0);
        AY = arraylist;
    }
}
