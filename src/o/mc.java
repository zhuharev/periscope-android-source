// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package o:
//            jd, is, mt, iw, 
//            io, iq, it, kd, 
//            mq, ms, kc

final class mc extends jd
{

    mc()
    {
    }

    private void _mth02CA(mt mt1, iq iq1)
    {
        if (iq1 == null || (iq1 instanceof is))
        {
            mt1._mth14F7();
            return;
        }
        if (iq1 instanceof iw)
        {
            if (iq1 instanceof iw)
            {
                iq1 = (iw)iq1;
            } else
            {
                throw new IllegalStateException("This is not a JSON Primitive.");
            }
            if (((iw) (iq1)).value instanceof Number)
            {
                mt1._mth02CA(iq1._mth04AD());
                return;
            }
            if (((iw) (iq1)).value instanceof Boolean)
            {
                mt1.FF9F(iq1._mth0672());
                return;
            } else
            {
                mt1._mth1421(iq1._mth04AE());
                return;
            }
        }
        if (iq1 instanceof io)
        {
            mt1._mth13D0();
            if (iq1 instanceof io)
            {
                iq1 = (io)iq1;
            } else
            {
                throw new IllegalStateException("This is not a JSON Array.");
            }
            for (iq1 = iq1.iterator(); iq1.hasNext(); _mth02CA(mt1, (iq)iq1.next())) { }
            mt1._mth141C();
            return;
        }
        if (iq1 instanceof it)
        {
            mt1._mth14A9();
            java.util.Map.Entry entry;
            for (iq1 = iq1._mth0673().GC.entrySet().iterator(); iq1.hasNext(); _mth02CA(mt1, (iq)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iq1.next();
                mt1._mth141F((String)entry.getKey());
            }

            mt1._mth14F6();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Couldn't write ")).append(iq1.getClass()).toString());
        }
    }

    private iq _mth037A(mq mq1)
    {
        switch (lj._cls1.HZ[mq1._mth13A2().ordinal()])
        {
        case 3: // '\003'
            return new iw(mq1.nextString());

        case 1: // '\001'
            return new iw(new kc(mq1.nextString()));

        case 2: // '\002'
            return new iw(Boolean.valueOf(mq1.nextBoolean()));

        case 4: // '\004'
            mq1.nextNull();
            return is.GB;

        case 5: // '\005'
            io io1 = new io();
            mq1.beginArray();
            Object obj;
            for (; mq1.hasNext(); io1.GA.add(obj))
            {
                iq iq1 = _mth037A(mq1);
                obj = iq1;
                if (iq1 == null)
                {
                    obj = is.GB;
                }
            }

            mq1.endArray();
            return io1;

        case 6: // '\006'
            it it1 = new it();
            mq1.beginObject();
            Object obj1;
            String s;
            for (; mq1.hasNext(); it1.GC.put(s, obj1))
            {
                s = mq1.nextName();
                iq iq2 = _mth037A(mq1);
                obj1 = iq2;
                if (iq2 == null)
                {
                    obj1 = is.GB;
                }
            }

            mq1.endObject();
            return it1;
        }
        throw new IllegalArgumentException();
    }

    public final Object read(mq mq1)
    {
        return _mth037A(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        _mth02CA(mt1, (iq)obj);
    }
}
