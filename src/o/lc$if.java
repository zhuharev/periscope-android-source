// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package o:
//            jd, lc, mq, ms, 
//            kh, iy, mt

public static final class l.Map extends jd
{

    private final kh HK;
    private final Map Ih;

    public final Object read(mq mq1)
    {
        Object obj;
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        obj = HK._mth0725();
        mq1.beginObject();
_L1:
        Object obj1;
        if (!mq1.hasNext())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj1 = mq1.nextName();
        obj1 = (A)Ih.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((A) (obj1)).Ij)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        mq1.skipValue();
          goto _L1
        try
        {
            ((A) (obj1))._mth02CA(mq1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new iy(mq1);
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new AssertionError(mq1);
        }
          goto _L1
        mq1.endObject();
        return obj;
    }

    public final void write(mt mt1, Object obj)
    {
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        }
        mt1._mth14A9();
        try
        {
            Iterator iterator = Ih.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                A a = (A)iterator.next();
                if (a._mth1423(obj))
                {
                    mt1._mth141F(a.name);
                    a.write(mt1, obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (mt mt1)
        {
            throw new AssertionError();
        }
        mt1._mth14F6();
    }

    private l.Map(kh kh1, Map map)
    {
        HK = kh1;
        Ih = map;
    }

    l.Map(kh kh1, Map map, byte byte0)
    {
        this(kh1, map);
    }
}
