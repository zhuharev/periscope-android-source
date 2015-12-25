// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, iy, 
//            mt

final class ln extends jd
{

    ln()
    {
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        mq1 = mq1.nextString();
        if (mq1.length() != 1)
        {
            throw new iy((new StringBuilder("Expecting character, got: ")).append(mq1).toString());
        } else
        {
            return Character.valueOf(mq1.charAt(0));
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Character)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = String.valueOf(obj);
        }
        mt1._mth1421(((String) (obj)));
    }
}
