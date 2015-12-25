// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            jd, kq, li, mq, 
//            ms, mt, ig

public final class kp extends jd
{

    public static final kq HG = new kq();
    private final Class HH;
    private final li HI;

    public kp(ig ig, jd jd1, Class class1)
    {
        HI = new li(ig, jd1, class1);
        HH = class1;
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        mq1.beginArray();
        for (; mq1.hasNext(); arraylist.add(HI.read(mq1))) { }
        mq1.endArray();
        mq1 = ((mq) (Array.newInstance(HH, arraylist.size())));
        for (int i = 0; i < arraylist.size(); i++)
        {
            Array.set(mq1, i, arraylist.get(i));
        }

        return mq1;
    }

    public final void write(mt mt1, Object obj)
    {
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        }
        mt1._mth13D0();
        int i = 0;
        for (int j = Array.getLength(obj); i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            HI.write(mt1, obj1);
        }

        mt1._mth141C();
    }

}
