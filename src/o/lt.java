// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.URL;

// Referenced classes of package o:
//            jd, mq, ms, mt

final class lt extends jd
{

    lt()
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
        if ("null".equals(mq1))
        {
            return null;
        } else
        {
            return new URL(mq1);
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (URL)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((URL) (obj)).toExternalForm();
        }
        mt1._mth1421(((String) (obj)));
    }
}
