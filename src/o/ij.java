// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt, 
//            ig

final class ij extends jd
{

    private ig Gp;

    ij(ig ig1)
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
            return Double.valueOf(mq1.nextDouble());
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
            double d = ((Number) (obj)).doubleValue();
            ig._mth02CA(Gp, d);
            mt1._mth02CA(((Number) (obj)));
            return;
        }
    }
}
