// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            jd, lb, mq, ms, 
//            kd, mt, mp, ig

public final class la extends jd
{

    public static final lb HY = new lb();
    private final ig gson;

    private la(ig ig1)
    {
        gson = ig1;
    }

    la(ig ig1, byte byte0)
    {
        this(ig1);
    }

    public final Object read(mq mq1)
    {
        ms ms1 = mq1._mth13A2();
        static final class _cls1
        {

            static final int HZ[];

            static 
            {
                HZ = new int[ms.values().length];
                try
                {
                    HZ[ms.JG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    HZ[ms.JI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    HZ[ms.JL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    HZ[ms.JM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    HZ[ms.JN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    HZ[ms.JO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
            }
        }

        switch (_cls1.HZ[ms1.ordinal()])
        {
        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            mq1.beginArray();
            for (; mq1.hasNext(); arraylist.add(read(mq1))) { }
            mq1.endArray();
            return arraylist;

        case 2: // '\002'
            kd kd1 = new kd();
            mq1.beginObject();
            for (; mq1.hasNext(); kd1.put(mq1.nextName(), read(mq1))) { }
            mq1.endObject();
            return kd1;

        case 3: // '\003'
            return mq1.nextString();

        case 4: // '\004'
            return Double.valueOf(mq1.nextDouble());

        case 5: // '\005'
            return Boolean.valueOf(mq1.nextBoolean());

        case 6: // '\006'
            mq1.nextNull();
            return null;
        }
        throw new IllegalStateException();
    }

    public final void write(mt mt1, Object obj)
    {
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        }
        jd jd1 = gson._mth02CA(new mp(obj.getClass()));
        if (jd1 instanceof la)
        {
            mt1._mth14A9();
            mt1._mth14F6();
            return;
        } else
        {
            jd1.write(mt1, obj);
            return;
        }
    }

}
