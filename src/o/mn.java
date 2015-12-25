// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class mn extends jd
{

    mn()
    {
    }

    private static Long _mth02C8(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        long l;
        try
        {
            l = mq1.nextLong();
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new iy(mq1);
        }
        return Long.valueOf(l);
    }

    public final Object read(mq mq1)
    {
        return _mth02C8(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth02CA((Number)obj);
    }
}
