// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt

final class lo extends jd
{

    lo()
    {
    }

    public final Object read(mq mq1)
    {
        ms ms1 = mq1._mth13A2();
        if (ms1 == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        if (ms1 == ms.JN)
        {
            return Boolean.toString(mq1.nextBoolean());
        } else
        {
            return mq1.nextString();
        }
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth1421((String)obj);
    }
}
