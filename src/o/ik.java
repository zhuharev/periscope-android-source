// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt, 
//            ig

final class ik extends jd
{

    private ig Gp;

    ik(ig ig1)
    {
        Gp = ig1;
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
            return Float.valueOf((float)mq1.nextDouble());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Number)obj;
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        } else
        {
            float f = ((Number) (obj)).floatValue();
            ig._mth02CA(Gp, f);
            mt1._mth02CA(((Number) (obj)));
            return;
        }
    }
}
