// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            zc, yv, ati, atv, 
//            atn, ato

static final class Map extends zc
{

    public final String id()
    {
        return "main_provider";
    }

    protected final void u()
    {
        ArrayList arraylist = super.FF89;
        if (arraylist.isEmpty())
        {
            arraylist.add(new ati(Ek, null));
            return;
        }
        if (((atv)arraylist.get(0)).fZ() != Ei)
        {
            arraylist.add(0, new ati(Ek, null));
            arraylist.add(1, new ati(El, null));
        } else
        {
            int l = arraylist.size();
            int i = 0;
            do
            {
                if (i >= l)
                {
                    break;
                }
                boolean flag;
                if (_mth144B(((atv)super.FF89.get(i)).ga()).bDW == ato.bEd)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    ati ati2 = new ati(El, null);
                    int k = i - 1;
                    ati ati1 = ati2;
                    if (k > 0)
                    {
                        ati1 = ati2;
                        if (((atv)arraylist.get(k)).fZ() != Ei)
                        {
                            ati1 = new ati(Em, null);
                        }
                    }
                    arraylist.add(i, ati1);
                    break;
                }
                i++;
            } while (true);
        }
        aWw = 0;
        int i1 = arraylist.size();
        for (int j = 0; j < i1; j++)
        {
            if (((atv)arraylist.get(j)).fZ() != Ej)
            {
                continue;
            }
            boolean flag1;
            if (_mth144B(((atv)super.FF89.get(j)).ga()).bDW == ato.bEd)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                aWw = aWw + 1;
            }
        }

    }

    protected final boolean _mth02CF(atn atn1)
    {
        return true;
    }

    public Map(Map map)
    {
        super(map, 1);
    }
}
