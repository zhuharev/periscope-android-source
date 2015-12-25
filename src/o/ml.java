// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class ml extends jd
{

    ml()
    {
    }

    private static Short _mth02BE(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        short word0;
        try
        {
            word0 = (short)mq1.nextInt();
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new iy(mq1);
        }
        return Short.valueOf(word0);
    }

    public final Object read(mq mq1)
    {
        return _mth02BE(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth02CA((Number)obj);
    }
}
