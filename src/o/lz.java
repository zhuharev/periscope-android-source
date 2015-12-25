// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package o:
//            jd, ly, mq, mt

final class lz extends jd
{

    private jd Jh;
    private ly Ji;

    lz(ly ly, jd jd1)
    {
        Ji = ly;
        Jh = jd1;
        super();
    }

    public final Object read(mq mq)
    {
        mq = (Date)Jh.read(mq);
        if (mq != null)
        {
            return new Timestamp(mq.getTime());
        } else
        {
            return null;
        }
    }

    public final volatile void write(mt mt, Object obj)
    {
        obj = (Timestamp)obj;
        Jh.write(mt, obj);
    }
}
