// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Locale;
import java.util.StringTokenizer;

// Referenced classes of package o:
//            jd, mq, ms, mt

final class mb extends jd
{

    mb()
    {
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        StringTokenizer stringtokenizer = new StringTokenizer(mq1.nextString(), "_");
        mq1 = null;
        String s = null;
        String s1 = null;
        if (stringtokenizer.hasMoreElements())
        {
            mq1 = stringtokenizer.nextToken();
        }
        if (stringtokenizer.hasMoreElements())
        {
            s = stringtokenizer.nextToken();
        }
        if (stringtokenizer.hasMoreElements())
        {
            s1 = stringtokenizer.nextToken();
        }
        if (s == null && s1 == null)
        {
            return new Locale(mq1);
        }
        if (s1 == null)
        {
            return new Locale(mq1, s);
        } else
        {
            return new Locale(mq1, s, s1);
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Locale)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((Locale) (obj)).toString();
        }
        mt1._mth1421(((String) (obj)));
    }
}
