// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package o:
//            zt

public final class xy
{

    private final zt mWordManager;

    public xy(zt zt1)
    {
        mWordManager = zt1;
    }

    public final boolean _mth0406(String s)
    {
label0:
        {
            s = s.toLowerCase(Locale.getDefault());
            List list = Arrays.asList(s.split("[[^\\P{P}@] \\t\\n\\r]"));
            Iterator iterator = Collections.unmodifiableSet(mWordManager.aXj).iterator();
            String s1;
label1:
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    s1 = (String)iterator.next();
                    boolean flag;
                    if (!s1.contains(" "))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        continue label1;
                    }
                } while (!list.contains(s1));
                return true;
            } while (!s.contains(s1));
            return true;
        }
        return false;
    }
}
