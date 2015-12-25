// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import o.02B8;
import o.0690;
import o.1D4A;
import o.FB61;
import o.FE70;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

final class ntext
    implements Runnable
{

    final RecyclerView ex;
    int fu;
    int fv;
    private boolean fw;
    private boolean fx;
    Interpolator mInterpolator;
    FB61 FEAE;

    public final void run()
    {
        fx = false;
        fw = true;
        RecyclerView._mth141D(ex);
        FB61 fb61 = FEAE;
        RecyclerView._mth02CF(ex);
        if (fb61.computeScrollOffset())
        {
            int i3 = fb61.getCurrX();
            int j3 = fb61.getCurrY();
            int k2 = i3 - fu;
            int l2 = j3 - fv;
            int l = 0;
            int i = 0;
            int i1 = 0;
            boolean flag3 = false;
            fu = i3;
            fv = j3;
            int j1 = 0;
            int j = 0;
            int k1 = 0;
            boolean flag2 = false;
            if (RecyclerView._mth02BB(ex) != null)
            {
                RecyclerView recyclerview = ex;
                if (!recyclerview.dO)
                {
                    recyclerview.dO = true;
                    recyclerview.dP = false;
                }
                RecyclerView._mth02BC(ex);
                _cls02B8.beginSection("RV Scroll");
                if (k2 != 0)
                {
                    i = RecyclerView._mth02CF(ex)._mth02CA(k2, ex.dz, ex.ek);
                    j = k2 - i;
                }
                l = ((flag3) ? 1 : 0);
                i1 = ((flag2) ? 1 : 0);
                if (l2 != 0)
                {
                    l = RecyclerView._mth02CF(ex)._mth02CB(l2, ex.dz, ex.ek);
                    i1 = l2 - l;
                }
                _cls02B8.endSection();
                if (RecyclerView._mth02BD(ex))
                {
                    _cls0690 _lcls0690 = ex.dC;
                    k1 = _lcls0690.aF.Count();
                    int l1 = _lcls0690.aH.size();
                    for (j1 = 0; j1 < k1 - l1; j1++)
                    {
                        Object obj = ex.dC;
                        int j2 = ((_cls0690) (obj)).FB1D(j1);
                        obj = ((_cls0690) (obj)).aF.At(j2);
                        Object obj1 = ex._mth1D63(((View) (obj)));
                        if (obj1 == null || ((ex) (obj1)).fE == null)
                        {
                            continue;
                        }
                        obj1 = ((fE) (obj1)).fE.fy;
                        j2 = ((View) (obj)).getLeft();
                        int k3 = ((View) (obj)).getTop();
                        if (j2 != ((View) (obj1)).getLeft() || k3 != ((View) (obj1)).getTop())
                        {
                            ((View) (obj1)).layout(j2, k3, ((View) (obj1)).getWidth() + j2, ((View) (obj1)).getHeight() + k3);
                        }
                    }

                }
                RecyclerView._mth037A(ex);
                ex._mth2071(false);
                k1 = i1;
                j1 = j;
                i1 = l;
                l = i;
            }
            if (!RecyclerView._mth1FBE(ex).isEmpty())
            {
                ex.invalidate();
            }
            if (FE70._mth02BC(ex) != 2)
            {
                RecyclerView._mth02CA(ex, k2, l2);
            }
            if (j1 != 0 || k1 != 0)
            {
                int i2 = (int)fb61.getCurrVelocity();
                i = 0;
                if (j1 != i3)
                {
                    if (j1 < 0)
                    {
                        i = -i2;
                    } else
                    if (j1 > 0)
                    {
                        i = i2;
                    } else
                    {
                        i = 0;
                    }
                }
                int k = 0;
                if (k1 != j3)
                {
                    if (k1 < 0)
                    {
                        k = -i2;
                    } else
                    if (k1 > 0)
                    {
                        k = i2;
                    } else
                    {
                        k = 0;
                    }
                }
                if (FE70._mth02BC(ex) != 2)
                {
                    RecyclerView recyclerview1 = ex;
                    if (i < 0)
                    {
                        recyclerview1._mth1D32();
                        recyclerview1.dW._mth1D35(-i);
                    } else
                    if (i > 0)
                    {
                        recyclerview1._mth1D3E();
                        recyclerview1.dY._mth1D35(i);
                    }
                    if (k < 0)
                    {
                        recyclerview1._mth1D41();
                        recyclerview1.dX._mth1D35(-k);
                    } else
                    if (k > 0)
                    {
                        recyclerview1._mth1D43();
                        recyclerview1.dZ._mth1D35(k);
                    }
                    if (i != 0 || k != 0)
                    {
                        FE70._mth1FBE(recyclerview1);
                    }
                }
                if ((i != 0 || j1 == i3 || fb61.getFinalX() == 0) && (k != 0 || k1 == j3 || fb61.getFinalY() == 0))
                {
                    fb61.abortAnimation();
                }
            }
            if (l != 0 || i1 != 0)
            {
                ex._mth1D35(l, i1);
            }
            if (!RecyclerView._mth02BE(ex))
            {
                ex.invalidate();
            }
            if (l2 != 0 && RecyclerView._mth02CF(ex)._mth027E() && i1 == l2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            boolean flag1;
            if (k2 != 0 && RecyclerView._mth02CF(ex)._mth026A() && l == k2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            boolean flag;
            if (k2 == 0 && l2 == 0 || flag1 || i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (fb61.isFinished() || !flag)
            {
                RecyclerView._mth02CB(ex, 0);
            } else
            {
                FB40();
            }
        }
        fw = false;
        if (fx)
        {
            FB40();
        }
    }

    final void FB40()
    {
        if (fw)
        {
            fx = true;
            return;
        } else
        {
            ex.removeCallbacks(this);
            FE70._mth02CA(ex, this);
            return;
        }
    }

    public (RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
        mInterpolator = RecyclerView._mth1ECB();
        fw = false;
        fx = false;
        FEAE = FB61._mth02CA(recyclerview.getContext(), RecyclerView._mth1ECB());
    }
}
