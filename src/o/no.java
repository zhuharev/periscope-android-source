// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            nk, nl

public final class no
{
    public static interface if
    {

        public abstract nl _mth1D3D();
    }


    public ArrayList KC;
    private final nk LD;
    private final int LE;
    public ArrayList LF;

    public no(double d, double d1, double d2, double d3)
    {
        this(new nk(0.0D, 1.0D, 0.0D, 1.0D));
    }

    private no(double d, double d1, double d2, double d3, int i)
    {
        this(new nk(d, d1, d2, d3), i);
    }

    private no(nk nk1)
    {
        this(nk1, 0);
    }

    private no(nk nk1, int i)
    {
        LF = null;
        LD = nk1;
        LE = i;
    }

    private void _mth02CA(double d, double d1, if if1)
    {
        no no1;
        for (no1 = this; no1.LF != null; no1 = (no)no1.LF.get(3))
        {
            if (d1 < no1.LD.LB)
            {
                if (d < no1.LD.LA)
                {
                    ((no)no1.LF.get(0))._mth02CA(d, d1, if1);
                    return;
                } else
                {
                    ((no)no1.LF.get(1))._mth02CA(d, d1, if1);
                    return;
                }
            }
            if (d < no1.LD.LA)
            {
                ((no)no1.LF.get(2))._mth02CA(d, d1, if1);
                return;
            }
        }

        if (no1.KC == null)
        {
            no1.KC = new ArrayList();
        }
        no1.KC.add(if1);
        if (no1.KC.size() > 50 && no1.LE < 40)
        {
            no1._mth1E7F();
        }
    }

    private void _mth1E7F()
    {
        LF = new ArrayList(4);
        LF.add(new no(LD.Lw, LD.LA, LD.Lx, LD.LB, LE + 1));
        LF.add(new no(LD.LA, LD.Ly, LD.Lx, LD.LB, LE + 1));
        LF.add(new no(LD.Lw, LD.LA, LD.LB, LD.Lz, LE + 1));
        LF.add(new no(LD.LA, LD.Ly, LD.LB, LD.Lz, LE + 1));
        Object obj = KC;
        KC = null;
        if if1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); _mth02CA(if1._mth1D3D().x, if1._mth1D3D().y, if1))
        {
            if1 = (if)((Iterator) (obj)).next();
        }

    }

    public void _mth02CA(nk nk1, Collection collection)
    {
        nk nk2 = LD;
        double d = nk1.Lw;
        double d1 = nk1.Ly;
        double d2 = nk1.Lx;
        double d3 = nk1.Lz;
        boolean flag;
        if (d < nk2.Ly && nk2.Lw < d1 && d2 < nk2.Lz && nk2.Lx < d3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return;
        }
        if (LF != null)
        {
            for (Iterator iterator = LF.iterator(); iterator.hasNext(); ((no)iterator.next())._mth02CA(nk1, collection)) { }
            return;
        }
        if (KC != null)
        {
            Object obj = LD;
            boolean flag1;
            if (((nk) (obj)).Lw >= nk1.Lw && ((nk) (obj)).Ly <= nk1.Ly && ((nk) (obj)).Lx >= nk1.Lx && ((nk) (obj)).Lz <= nk1.Lz)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                collection.addAll(KC);
                return;
            }
            obj = KC.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if if1 = (if)((Iterator) (obj)).next();
                nl nl1 = if1._mth1D3D();
                if (nk1._mth02CA(nl1.x, nl1.y))
                {
                    collection.add(if1);
                }
            } while (true);
        }
    }

    public final void _mth02CA(if if1)
    {
        nl nl1 = if1._mth1D3D();
        if (LD._mth02CA(nl1.x, nl1.y))
        {
            _mth02CA(nl1.x, nl1.y, if1);
        }
    }
}
