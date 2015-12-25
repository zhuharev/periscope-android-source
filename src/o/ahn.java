// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            FE70, _cls1646, aho, ahp

public final class ahn extends android.support.v7.widget.RecyclerView._cls02CE
{
    static final class if
    {

        public int blY;
        public int blZ;
        public android.support.v7.widget.RecyclerView._cls02CC bp;
        public android.support.v7.widget.RecyclerView._cls02CC bq;
        public int br;
        public int bs;
        public int bt;
        public int bu;

        public final String toString()
        {
            return (new StringBuilder("ChangeInfo{oldHolder=")).append(bp).append(", newHolder=").append(bq).append(", fromX=").append(br).append(", fromY=").append(bs).append(", fromWidth=").append(blY).append(", toX=").append(bt).append(", toY=").append(bu).append(", toWidth=").append(blZ).append('}').toString();
        }

        private if(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc1)
        {
            bp = _pcls02cc;
            bq = _pcls02cc1;
        }

        private if(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc1, int i, int j, int k, int l, int i1, 
                int j1)
        {
            this(_pcls02cc, _pcls02cc1);
            br = i;
            bs = j;
            bt = k;
            bu = l;
            blY = i1;
            blZ = j1;
        }

        if(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, android.support.v7.widget.RecyclerView._cls02CC _pcls02cc1, int i, int j, int k, int l, int i1, 
                int j1, byte byte0)
        {
            this(_pcls02cc, _pcls02cc1, i, j, k, l, i1, j1);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private ArrayList aT;
    private ArrayList aU;
    private ArrayList aV;
    ArrayList aW;
    ArrayList aX;
    ArrayList aY;
    ArrayList aZ;
    ArrayList ba;
    ArrayList bc;

    public ahn()
    {
        aT = new ArrayList();
        aU = new ArrayList();
        aV = new ArrayList();
        aW = new ArrayList();
        aX = new ArrayList();
        aY = new ArrayList();
        aZ = new ArrayList();
        ba = new ArrayList();
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
        return !aT.isEmpty() || !aV.isEmpty() || !aU.isEmpty() || !ba.isEmpty() || !aZ.isEmpty() || !bc.isEmpty() || !aX.isEmpty() || !aW.isEmpty() || !aY.isEmpty();
    }

    public final boolean _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        if (super.eA != null)
        {
            super.eA._mth02BB(_pcls02cc);
        }
        return false;
    }

    public final boolean _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i, int j, int k, int l)
    {
        View view = _pcls02cc.fy;
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
            i1 = _pcls02cc.fy.getWidth();
            j1 = _pcls02cc1.fy.getWidth();
            aV.add(new if(_pcls02cc, _pcls02cc1, i, j, k, l, i1, j1, (byte)0));
            return true;
        }
        if (super.eA != null)
        {
            super.eA._mth037A(_pcls02cc);
        }
        return false;
    }

    public final boolean _mth02CB(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        _mth02CE(_pcls02cc);
        float f = FE70._mth02D1(_pcls02cc.fy);
        int i = _pcls02cc.fy.getHeight();
        int j = (int)f;
        int k = (int)f;
        FE70._mth02CB(_pcls02cc.fy, i);
        _pcls02cc = new _cls02CA(_pcls02cc, 0, j + i, 0, k, (byte)0);
        _pcls02cc.bma = true;
        aT.add(_pcls02cc);
        return true;
    }

    public final void _mth02CE(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc)
    {
        View view = _pcls02cc.fy;
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
        for (int j = aT.size() - 1; j >= 0; j--)
        {
            if (((_cls02CA)aT.get(j)).bv != _pcls02cc)
            {
                continue;
            }
            aT.remove(j);
            FE70._mth02CB(view, 0.0F);
            if (super.eA != null)
            {
                super.eA._mth02BC(_pcls02cc);
            }
        }

        for (int k = aY.size() - 1; k >= 0; k--)
        {
            ArrayList arraylist = (ArrayList)aY.get(k);
            _mth02CA(arraylist, _pcls02cc);
            if (arraylist.isEmpty())
            {
                aY.remove(arraylist);
            }
        }

label0:
        for (int l = aX.size() - 1; l >= 0; l--)
        {
            ArrayList arraylist1 = (ArrayList)aX.get(l);
            int j1 = arraylist1.size() - 1;
            do
            {
                if (j1 < 0)
                {
                    continue label0;
                }
                if (((_cls02CA)arraylist1.get(j1)).bv == _pcls02cc)
                {
                    FE70._mth02CB(view, 0.0F);
                    FE70._mth02CA(view, 0.0F);
                    if (super.eA != null)
                    {
                        super.eA._mth02BD(_pcls02cc);
                    }
                    arraylist1.remove(j1);
                    if (arraylist1.isEmpty())
                    {
                        aX.remove(arraylist1);
                    }
                    continue label0;
                }
                j1--;
            } while (true);
        }

        for (int i1 = aW.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist2 = (ArrayList)aW.get(i1);
            for (int k1 = arraylist2.size() - 1; k1 >= 0; k1--)
            {
                if (((_cls02CA)arraylist2.get(k1)).bv != _pcls02cc)
                {
                    continue;
                }
                arraylist2.remove(k1);
                FE70._mth02CB(view, 0.0F);
                if (super.eA != null)
                {
                    super.eA._mth02BC(_pcls02cc);
                }
                if (arraylist2.isEmpty())
                {
                    aW.remove(arraylist2);
                }
            }

        }

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
        if (!aU.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (!aV.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2;
        if (!aT.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag && !flag2 && !flag1)
        {
            return;
        }
        if (flag2 || flag)
        {
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist2 = new ArrayList();
            ArrayList arraylist3 = new ArrayList();
            if (flag)
            {
                arraylist3.addAll(aU);
                arraylist.addAll(arraylist3);
                aX.add(arraylist3);
                aU.clear();
            }
            if (flag2)
            {
                arraylist2.addAll(aT);
                arraylist.addAll(arraylist2);
                aW.add(arraylist2);
                aT.clear();
            }
            (new aho(this, arraylist, arraylist3, arraylist2)).run();
        }
        if (flag1)
        {
            ArrayList arraylist1 = new ArrayList();
            arraylist1.addAll(aV);
            aY.add(arraylist1);
            aV.clear();
            (new ahp(this, arraylist1)).run();
        }
    }

    public final void FF68()
    {
        for (int i = aU.size() - 1; i >= 0; i--)
        {
            Object obj = (_cls02CA)aU.get(i);
            View view = ((_cls02CA) (obj)).bv.fy;
            FE70._mth02CB(view, 0.0F);
            FE70._mth02CA(view, 0.0F);
            obj = ((_cls02CA) (obj)).bv;
            if (super.eA != null)
            {
                super.eA._mth02BD(((android.support.v7.widget.RecyclerView._cls02CC) (obj)));
            }
            aU.remove(i);
        }

        for (int j = aT.size() - 1; j >= 0; j--)
        {
            android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = ((_cls02CA)aT.get(j)).bv;
            FE70._mth02CE(_lcls02cc.fy, 1.0F);
            if (super.eA != null)
            {
                super.eA._mth02BC(_lcls02cc);
            }
            aT.remove(j);
        }

        for (int k = aV.size() - 1; k >= 0; k--)
        {
            _mth02CA((if)aV.get(k));
        }

        aV.clear();
        if (!isRunning())
        {
            return;
        }
        for (int l = aX.size() - 1; l >= 0; l--)
        {
            ArrayList arraylist = (ArrayList)aX.get(l);
            for (int k1 = arraylist.size() - 1; k1 >= 0; k1--)
            {
                Object obj1 = (_cls02CA)arraylist.get(k1);
                View view1 = ((_cls02CA) (obj1)).bv.fy;
                FE70._mth02CB(view1, 0.0F);
                FE70._mth02CA(view1, 0.0F);
                obj1 = ((_cls02CA) (obj1)).bv;
                if (super.eA != null)
                {
                    super.eA._mth02BD(((android.support.v7.widget.RecyclerView._cls02CC) (obj1)));
                }
                arraylist.remove(k1);
                if (arraylist.isEmpty())
                {
                    aX.remove(arraylist);
                }
            }

        }

        for (int i1 = aW.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist1 = (ArrayList)aW.get(i1);
            for (int l1 = arraylist1.size() - 1; l1 >= 0; l1--)
            {
                android.support.v7.widget.RecyclerView._cls02CC _lcls02cc1 = ((_cls02CA)arraylist1.get(l1)).bv;
                FE70._mth02CE(_lcls02cc1.fy, 1.0F);
                if (super.eA != null)
                {
                    super.eA._mth02BC(_lcls02cc1);
                }
                arraylist1.remove(l1);
                if (arraylist1.isEmpty())
                {
                    aW.remove(arraylist1);
                }
            }

        }

        for (int j1 = aY.size() - 1; j1 >= 0; j1--)
        {
            ArrayList arraylist2 = (ArrayList)aY.get(j1);
            for (int i2 = arraylist2.size() - 1; i2 >= 0; i2--)
            {
                _mth02CA((if)arraylist2.get(i2));
                if (arraylist2.isEmpty())
                {
                    aY.remove(arraylist2);
                }
            }

        }

        _mth02CE(ba);
        _mth02CE(aZ);
        _mth02CE(bc);
        _mth30FD();
    }
}
