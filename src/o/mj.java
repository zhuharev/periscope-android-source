// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt

final class mj extends jd
{

    mj()
    {
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        } else
        {
            return Boolean.valueOf(mq1.nextString());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Boolean)obj;
        if (obj == null)
        {
            obj = "null";
        } else
        {
            obj = ((Boolean) (obj)).toString();
        }
        mt1._mth1421(((String) (obj)));
    }
}
