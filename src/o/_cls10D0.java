// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            FE70, _cls1646, _cls14A3, _cls10D8, 
//            _cls13B0, _cls13DE

public final class _cls10D0 extends android.support.v7.widget.RecyclerView._cls02CE
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private ArrayList aS;
    private ArrayList aT;
    private ArrayList aU;
    private ArrayList aV;
    ArrayList aW;
    ArrayList aX;
    ArrayList aY;
    ArrayList aZ;
    ArrayList ba;
    ArrayList bb;
    ArrayList bc;

    public _cls10D0()
    {
        aS = new ArrayList();
        aT = new ArrayList();
        aU = new ArrayList();
        aV = new ArrayList();
        aW = new ArrayList();
        aX = new ArrayList();
        aY = new ArrayList();
        aZ = new ArrayList();
        ba = new ArrayList();
        bb = new ArrayList();
        bc = new ArrayList();
    }

    private void _mth02CA(ArrayList arraylist, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            if if1 = (if)arraylist.get(i);
            if (_mth02CA(if1, _pcls02cc) && if1.bp == null && if1.bq == null)
            {
                arraylist.remove(if1);
            }
        }

    }

    private void _mth02CA(if if1)
    {
        if (if1.bp != null)
        {
            _mth02CA(if1, if1.bp);
        }
        if (if1.bq != null)
        {
            _mth02CA(if1, if1.bq);
        }
    }

    private boolean _mth02CA(if if1, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        boolean flag = false;
        if (if1.bq == _pcls02cc)
        {
            if1.bq = null;
        } else
        if (if1.bp == _pcls02cc)
        {
            if1.bp = null;
            boolean flag1 = true;
        } else
        {
            return false;
        }
        FE70._mth02CE(_pcls02cc.fy, 1.0F);
        FE70._mth02CA(_pcls02cc.fy, 0.0F);
        FE70._mth02CB(_pcls02cc.fy, 0.0F);
        if (super.eA != null)
        {
            super.eA._mth037A(_pcls02cc);
        }
        return true;
    }

    private static void _mth02CE(ArrayList arraylist)
    {
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            FE70._mth1428(((android.support.v7.widget.RecyclerView._cls02CC)arraylist.get(i)).fy).cancel();
        }

    }

    public final boolean isRunning()
    {
        return !aT.isEmpty() || !aV.isEmpty() || !aU.isEmpty() || !aS.isEmpty() || !ba.isEmpty() || !bb.isEmpty() || !aZ.isEmpty() || !bc.isEmpty() || !aX.isEmpty() || !aW.isEmpty() || !aY.isEmpty();
    }

    public final boolean _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        _mth02CE(_pcls02cc);
        aS.add(_pcls02cc);
        return true;
    }

    public final boolean _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i, int j, int k, int l)
    {
        android.view.View view = _pcls02cc.fy;
        i = (int)((float)i + FE70._mth02CD(_pcls02cc.fy));
        j = (int)((float)j + FE70._mth02D1(_pcls02cc.fy));
        _mth02CE(_pcls02cc);
        int i1 = k - i;
        int j1 = l - j;
        if (i1 == 0 && j1 == 0)
        {
            if (super.eA != null)
            {
                super.eA._mth02BD(_pcls02cc);
            }
            return false;
        }
        if (i1 != 0)
        {
            FE70._mth02CA(view, -i1);
        }
        if (j1 != 0)
        {
            FE70._mth02CB(view, -j1);
        }
        aU.add(new _cls02CA(_pcls02cc, i, j, k, l, (byte)0));
        return true;
    }

    public final boolean _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc1, int i, int j, int k, int l)
    {
        float f = FE70._mth02CD(_pcls02cc.fy);
        float f1 = FE70._mth02D1(_pcls02cc.fy);
        float f2 = FE70._mth02BF(_pcls02cc.fy);
        _mth02CE(_pcls02cc);
        int i1 = (int)((float)(k - i) - f);
        int j1 = (int)((float)(l - j) - f1);
        FE70._mth02CA(_pcls02cc.fy, f);
        FE70._mth02CB(_pcls02cc.fy, f1);
        FE70._mth02CE(_pcls02cc.fy, f2);
        if (_pcls02cc1 != null && _pcls02cc1.fy != null)
        {
            _mth02CE(_pcls02cc1);
            FE70._mth02CA(_pcls02cc1.fy, -i1);
            FE70._mth02CB(_pcls02cc1.fy, -j1);
            FE70._mth02CE(_pcls02cc1.fy, 0.0F);
        }
        aV.add(new if(_pcls02cc, _pcls02cc1, i, j, k, l, (byte)0));
        return true;
    }

    public final boolean _mth02CB(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        _mth02CE(_pcls02cc);
        FE70._mth02CE(_pcls02cc.fy, 0.0F);
        aT.add(_pcls02cc);
        return true;
    }

    public final void _mth02CE(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        android.view.View view = _pcls02cc.fy;
        FE70._mth1428(view).cancel();
        for (int i = aU.size() - 1; i >= 0; i--)
        {
            if (((_cls02CA)aU.get(i)).bv != _pcls02cc)
            {
                continue;
            }
            FE70._mth02CB(view, 0.0F);
            FE70._mth02CA(view, 0.0F);
            if (super.eA != null)
            {
                super.eA._mth02BD(_pcls02cc);
            }
            aU.remove(i);
        }

        _mth02CA(aV, _pcls02cc);
        if (aS.remove(_pcls02cc))
        {
            FE70._mth02CE(view, 1.0F);
            if (super.eA != null)
            {
                super.eA._mth02BB(_pcls02cc);
            }
        }
        if (aT.remove(_pcls02cc))
        {
            FE70._mth02CE(view, 1.0F);
            if (super.eA != null)
            {
                super.eA._mth02BC(_pcls02cc);
            }
        }
        for (int j = aY.size() - 1; j >= 0; j--)
        {
            ArrayList arraylist = (ArrayList)aY.get(j);
            _mth02CA(arraylist, _pcls02cc);
            if (arraylist.isEmpty())
            {
                aY.remove(j);
            }
        }

label0:
        for (int k = aX.size() - 1; k >= 0; k--)
        {
            ArrayList arraylist1 = (ArrayList)aX.get(k);
            int i1 = arraylist1.size() - 1;
            do
            {
                if (i1 < 0)
                {
                    continue label0;
                }
                if (((_cls02CA)arraylist1.get(i1)).bv == _pcls02cc)
                {
                    FE70._mth02CB(view, 0.0F);
                    FE70._mth02CA(view, 0.0F);
                    if (super.eA != null)
                    {
                        super.eA._mth02BD(_pcls02cc);
                    }
                    arraylist1.remove(i1);
                    if (arraylist1.isEmpty())
                    {
                        aX.remove(k);
                    }
                    continue label0;
                }
                i1--;
            } while (true);
        }

        for (int l = aW.size() - 1; l >= 0; l--)
        {
            ArrayList arraylist2 = (ArrayList)aW.get(l);
            if (!arraylist2.remove(_pcls02cc))
            {
                continue;
            }
            FE70._mth02CE(view, 1.0F);
            if (super.eA != null)
            {
                super.eA._mth02BC(_pcls02cc);
            }
            if (arraylist2.isEmpty())
            {
                aW.remove(l);
            }
        }

        bb.remove(_pcls02cc);
        aZ.remove(_pcls02cc);
        bc.remove(_pcls02cc);
        ba.remove(_pcls02cc);
        if (!isRunning())
        {
            _mth30FD();
        }
    }

    public final void FEE8()
    {
        boolean flag;
        if (!aS.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (!aU.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2;
        if (!aV.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        boolean flag3;
        if (!aT.isEmpty())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (!flag && !flag1 && !flag3 && !flag2)
        {
            return;
        }
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc;
        _cls1646 _lcls1646;
        for (Iterator iterator = aS.iterator(); iterator.hasNext(); _lcls1646._mth02CB(super.eD)._mth02CE(0.0F)._mth02CA(new _cls14A3(this, _lcls02cc, _lcls1646)).start())
        {
            _lcls02cc = (android.support.v7.widget.RecyclerView._cls02CC)iterator.next();
            _lcls1646 = FE70._mth1428(_lcls02cc.fy);
            bb.add(_lcls02cc);
        }

        aS.clear();
        if (flag1)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(aU);
            aX.add(arraylist);
            aU.clear();
            _cls10D8 _lcls10d8 = new _cls10D8(this, arraylist);
            if (flag)
            {
                FE70._mth02CA(((_cls02CA)arraylist.get(0)).bv.fy, _lcls10d8, super.eD);
            } else
            {
                _lcls10d8.run();
            }
        }
        if (flag2)
        {
            ArrayList arraylist1 = new ArrayList();
            arraylist1.addAll(aV);
            aY.add(arraylist1);
            aV.clear();
            _cls13B0 _lcls13b0 = new _cls13B0(this, arraylist1);
            if (flag)
            {
                FE70._mth02CA(((if)arraylist1.get(0)).bp.fy, _lcls13b0, super.eD);
            } else
            {
                _lcls13b0.run();
            }
        }
        if (flag3)
        {
            ArrayList arraylist2 = new ArrayList();
            arraylist2.addAll(aT);
            aW.add(arraylist2);
            aT.clear();
            _cls13DE _lcls13de = new _cls13DE(this, arraylist2);
            if (flag || flag1 || flag2)
            {
                long l;
                if (flag)
                {
                    l = super.eD;
                } else
                {
                    l = 0L;
                }
                long l1;
                if (flag1)
                {
                    l1 = super.eE;
                } else
                {
                    l1 = 0L;
                }
                long l2;
                if (flag2)
                {
                    l2 = super.eF;
                } else
                {
                    l2 = 0L;
                }
                l1 = Math.max(l1, l2);
                FE70._mth02CA(((android.support.v7.widget.RecyclerView._cls02CC)arraylist2.get(0)).fy, _lcls13de, l + l1);
                return;
            }
            _lcls13de.run();
        }
    }

    public final void FF68()
    {
        for (int i = aU.size() - 1; i >= 0; i--)
        {
            Object obj = (_cls02CA)aU.get(i);
            android.view.View view = ((_cls02CA) (obj)).bv.fy;
            FE70._mth02CB(view, 0.0F);
            FE70._mth02CA(view, 0.0F);
            obj = ((_cls02CA) (obj)).bv;
            if (super.eA != null)
            {
                super.eA._mth02BD(((android.support.v7.widget.RecyclerView._cls02CC) (obj)));
            }
            aU.remove(i);
        }

        for (int j = aS.size() - 1; j >= 0; j--)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = (android.support.v7.widget.RecyclerView._cls02CC)aS.get(j);
            if (super.eA != null)
            {
                super.eA._mth02BB(_lcls02cc);
            }
            aS.remove(j);
        }

        for (int k = aT.size() - 1; k >= 0; k--)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = (android.support.v7.widget.RecyclerView._cls02CC)aT.get(k);
            FE70._mth02CE(_lcls02cc1.fy, 1.0F);
            if (super.eA != null)
            {
                super.eA._mth02BC(_lcls02cc1);
            }
            aT.remove(k);
        }

        for (int l = aV.size() - 1; l >= 0; l--)
        {
            _mth02CA((if)aV.get(l));
        }

        aV.clear();
        if (!isRunning())
        {
            return;
        }
        for (int i1 = aX.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist = (ArrayList)aX.get(i1);
            for (int l1 = arraylist.size() - 1; l1 >= 0; l1--)
            {
                Object obj1 = (_cls02CA)arraylist.get(l1);
                android.view.View view1 = ((_cls02CA) (obj1)).bv.fy;
                FE70._mth02CB(view1, 0.0F);
                FE70._mth02CA(view1, 0.0F);
                obj1 = ((_cls02CA) (obj1)).bv;
                if (super.eA != null)
                {
                    super.eA._mth02BD(((android.support.v7.widget.RecyclerView._cls02CC) (obj1)));
                }
                arraylist.remove(l1);
                if (arraylist.isEmpty())
                {
                    aX.remove(arraylist);
                }
            }

        }

        for (int j1 = aW.size() - 1; j1 >= 0; j1--)
        {
            ArrayList arraylist1 = (ArrayList)aW.get(j1);
            for (int i2 = arraylist1.size() - 1; i2 >= 0; i2--)
            {
                android.support.v7.widget.RecyclerView._cls02CC _lcls02cc2 = (android.support.v7.widget.RecyclerView._cls02CC)arraylist1.get(i2);
                FE70._mth02CE(_lcls02cc2.fy, 1.0F);
                if (super.eA != null)
                {
                    super.eA._mth02BC(_lcls02cc2);
                }
                arraylist1.remove(i2);
                if (arraylist1.isEmpty())
                {
                    aW.remove(arraylist1);
                }
            }

        }

        for (int k1 = aY.size() - 1; k1 >= 0; k1--)
        {
            ArrayList arraylist2 = (ArrayList)aY.get(k1);
            for (int j2 = arraylist2.size() - 1; j2 >= 0; j2--)
            {
                _mth02CA((if)arraylist2.get(j2));
                if (arraylist2.isEmpty())
                {
                    aY.remove(arraylist2);
                }
            }

        }

        _mth02CE(bb);
        _mth02CE(ba);
        _mth02CE(aZ);
        _mth02CE(bc);
        _mth30FD();
    }
}
