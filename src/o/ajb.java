// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import java.util.List;

// Referenced classes of package o:
//            aka, aji, akt, akm, 
//            aok, ako, aqe, ajc, 
//            asm

public abstract class ajb
    implements aka, aji
{

    private int bX;
    protected ViewGroup boF;
    protected boolean boG;
    private boolean boH;
    final asm boI;
    private final akt boJ;
    private final int boK;
    private final int boL;
    private final int boM;
    private final int boN;
    private final int boO;
    private final int boP;
    private final int boQ;
    private final int boR;
    private final int boS;
    private final String name;
    private final int statusBarColor;

    ajb(String s, asm asm, akt akt1, int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2, int j2)
    {
        name = s;
        boI = asm;
        boJ = akt1;
        s = akt1.getContext().getResources();
        boL = s.getColor(i);
        boM = s.getColor(j);
        boK = s.getColor(k);
        statusBarColor = s.getColor(l);
        boN = j1;
        boO = k1;
        boP = l1;
        boQ = i2;
        boR = j2;
        boS = i1;
    }

    public int cA()
    {
        return boN;
    }

    public int cB()
    {
        return boO;
    }

    public int cC()
    {
        return boP;
    }

    public final int cD()
    {
        return boQ;
    }

    public final int cE()
    {
        return boR;
    }

    protected void cF()
    {
        if (boH)
        {
            boH = false;
            cO().ey.notifyChanged();
        }
    }

    public final void cG()
    {
        if (boG)
        {
            boH = false;
            cO().ey.notifyChanged();
            return;
        } else
        {
            boH = true;
            return;
        }
    }

    public final void cH()
    {
        if (boG)
        {
            boH = false;
            cO().ey.notifyChanged();
            return;
        } else
        {
            boH = true;
            return;
        }
    }

    public final void cI()
    {
        if (boG)
        {
            boH = false;
            cO().ey.notifyChanged();
            return;
        } else
        {
            boH = true;
            return;
        }
    }

    public final akt cv()
    {
        return boJ;
    }

    public final int cw()
    {
        return boK;
    }

    public final int cx()
    {
        return statusBarColor;
    }

    public final int cy()
    {
        return boL;
    }

    public final int cz()
    {
        return boM;
    }

    public final String name()
    {
        return name;
    }

    public final void _mth02CA(int i, float f, int j)
    {
    }

    public boolean _mth02CA(ViewGroup viewgroup, int i, aqe aqe1)
    {
        Object obj1 = viewgroup.getContext();
        akm akm1 = (akm)LayoutInflater.from(((Context) (obj1))).inflate(0x7f030057, viewgroup, false);
        akm1.setId(i);
        akm1.setOnRefreshListener(new FE79.if(this, akm1));
        akm1.setColorSchemeResources(aok.bva);
        Object obj = (RecyclerView)akm1.findViewById(0x7f0d0067);
        ((RecyclerView) (obj)).setAdapter(cO());
        ((RecyclerView) (obj)).setLayoutManager(new LinearLayoutManager(((Context) (obj1))));
        ((RecyclerView) (obj)).setBackgroundResource(boS);
        ((RecyclerView) (obj)).setItemAnimator(null);
        obj1 = cQ();
        if (obj1 != null)
        {
            ((RecyclerView) (obj))._mth02CA(((android.support.v7.widget.RecyclerView.aux) (obj1)));
        }
        obj = (ProgressBar)akm1.findViewById(0x7f0d011b);
        ((ProgressBar) (obj)).setVisibility(0);
        obj1 = new ako(akm1);
        aqe1.bzU.add(obj1);
        aqe1.bzU.add(this);
        viewgroup.addView(akm1, 0);
        boF = akm1;
        bX = i;
        viewgroup = cP();
        viewgroup.init();
        viewgroup._mth02CA(new ajc(this, ((ProgressBar) (obj))));
        return true;
    }

    public void _mth0640(int i)
    {
        boolean flag;
        if (bX == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boG = flag;
        if (boG)
        {
            cF();
        }
    }

    public final void _mth1427(int i)
    {
    }
}
