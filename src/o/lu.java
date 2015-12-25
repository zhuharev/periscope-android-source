// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package o:
//            jd, mq, ms, ir, 
//            mt

final class lu extends jd
{

    lu()
    {
    }

    private static URI _mth02BC(mq mq1)
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
        }
        try
        {
            mq1 = new URI(mq1);
        }
        // Misplaced declaration of an exception variable
        catch (mq mq1)
        {
            throw new ir(mq1);
        }
        return mq1;
    }

    public final Object read(mq mq1)
    {
        return _mth02BC(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (URI)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((URI) (obj)).toASCIIString();
        }
        mt1._mth1421(((String) (obj)));
    }
}
