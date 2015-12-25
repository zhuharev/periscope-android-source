// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            jd, lj, ji, mq, 
//            ms, mt

static final class g.Object extends jd
{

    private final HashMap Jq;
    private final HashMap Jr;

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        } else
        {
            return (Enum)Jq.get(mq1.nextString());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Enum)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (String)Jr.get(obj);
        }
        mt1._mth1421(((String) (obj)));
    }

    public g.Object(Class class1)
    {
        Jq = new HashMap();
        Jr = new HashMap();
        String s;
        Enum aenum[];
        Enum enum;
        ji ji1;
        int i;
        int j;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            j = aenum.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError();
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[i];
        s = enum.name();
        ji1 = (ji)class1.getField(s).getAnnotation(o/ji);
        if (ji1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = ji1.value();
        Jq.put(s, enum);
        Jr.put(enum, s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_41;
_L1:
    }
}
