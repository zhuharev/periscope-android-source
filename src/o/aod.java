// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            aop

public abstract class aod
    implements aop
{

    private final HashSet buR = new HashSet();

    public aod()
    {
    }

    public final void dj()
    {
        buR.clear();
    }

    public final boolean dk()
    {
        boolean flag = false;
        int i1 = getItemCount();
        int i = 0;
        int j = 0;
        int k;
        int l;
        do
        {
            k = ((flag) ? 1 : 0);
            l = i;
            if (j >= i1)
            {
                break;
            }
            k = i;
            if (FB61(j))
            {
                i++;
                k = i;
                if (!buR.contains(FB64(j)))
                {
                    k = 1;
                    l = i;
                    break;
                }
            }
            j++;
            i = k;
        } while (true);
        return l > 0 && k == 0;
    }

    public final Collection dl()
    {
        return buR;
    }

    public abstract int getItemCount();

    public final void selectAll()
    {
        int j = getItemCount();
        for (int i = 0; i < j; i++)
        {
            if (FB61(i))
            {
                buR.add(FB64(i));
            }
        }

    }

    public final void _mth1646(String s)
    {
        if (buR.contains(s))
        {
            buR.remove(s);
            return;
        } else
        {
            buR.add(s);
            return;
        }
    }

    public abstract boolean FB61(int i);

    public abstract String FB64(int i);
}
