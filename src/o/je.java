// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt

final class je extends jd
{

    private jd GO;

    je(jd jd1)
    {
        GO = jd1;
        super();
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        } else
        {
            return GO.read(mq1);
        }
    }

    public final void write(mt mt1, Object obj)
    {
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        } else
        {
            GO.write(mt1, obj);
            return;
        }
    }
}
