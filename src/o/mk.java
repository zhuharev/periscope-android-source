// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class mk extends jd
{

    mk()
    {
    }

    private static Byte _mth1FBE(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        byte byte0;
        try
        {
            byte0 = (byte)mq1.nextInt();
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new iy(mq1);
        }
        return Byte.valueOf(byte0);
    }

    public final Object read(mq mq1)
    {
        return _mth1FBE(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth02CA((Number)obj);
    }
}
