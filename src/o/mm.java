// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class mm extends jd
{

    mm()
    {
    }

    private static Integer _mth02BF(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        int i;
        try
        {
            i = mq1.nextInt();
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new iy(mq1);
        }
        return Integer.valueOf(i);
    }

    public final Object read(mq mq1)
    {
        return _mth02BF(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth02CA((Number)obj);
    }
}
