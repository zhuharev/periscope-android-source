// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt

final class mg extends jd
{

    mg()
    {
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        if (mq1._mth13A2() == ms.JL)
        {
            return Boolean.valueOf(Boolean.parseBoolean(mq1.nextString()));
        } else
        {
            return Boolean.valueOf(mq1.nextBoolean());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Boolean)obj;
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        } else
        {
            mt1.FF9F(((Boolean) (obj)).booleanValue());
            return;
        }
    }
}
