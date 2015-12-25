// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, mt

final class ls extends jd
{

    ls()
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
            return new StringBuffer(mq1.nextString());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (StringBuffer)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((StringBuffer) (obj)).toString();
        }
        mt1._mth1421(((String) (obj)));
    }
}
