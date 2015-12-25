// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.UUID;

// Referenced classes of package o:
//            jd, mq, ms, mt

final class lx extends jd
{

    lx()
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
            return UUID.fromString(mq1.nextString());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (UUID)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((UUID) (obj)).toString();
        }
        mt1._mth1421(((String) (obj)));
    }
}
