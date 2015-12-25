// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import o.020B;
import o.0690;
import o.1484;
import o.1D69;
import o.1FD0;
import o.2174;
import o.FE70;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public class LinearLayoutManager extends RecyclerView._cls02BB
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1D69();
        int co;
        int cp;
        boolean cq;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(co);
            parcel.writeInt(cp);
            if (cq)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
        }


        public SavedState()
        {
        }

        public SavedState(Parcel parcel)
        {
            co = parcel.readInt();
            cp = parcel.readInt();
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cq = flag;
        }

        public SavedState(SavedState savedstate)
        {
            co = savedstate.co;
            cp = savedstate.cp;
            cq = savedstate.cq;
        }
    }

    final class if
    {

        int bX;
        int bY;
        boolean bZ;
        final LinearLayoutManager ca;

        public final String toString()
        {
            return (new StringBuilder("AnchorInfo{mPosition=")).append(bX).append(", mCoordinate=").append(bY).append(", mLayoutFromEnd=").append(bZ).append('}').toString();
        }

        final void _mth0433()
        {
            int i;
            if (bZ)
            {
                i = ca.bN._mth1506();
            } else
            {
                i = ca.bN._mth14D1();
            }
            bY = i;
        }

        public final void _mth141F(View view)
        {
            if (bZ)
            {
                int j = ca.bN._mth142A(view);
                _cls2174 _lcls2174 = ca.bN;
                int i;
                if (0x80000000 == _lcls2174.dv)
                {
                    i = 0;
                } else
                {
                    i = _lcls2174._mth1D16() - _lcls2174.dv;
                }
                bY = j + i;
            } else
            {
                bY = ca.bN._mth1421(view);
            }
            bX = LinearLayoutManager._mth1D38(view);
        }

        if()
        {
            ca = LinearLayoutManager.this;
            super();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private int bA;
    private _cls02CB bM;
    _cls2174 bN;
    private boolean bO;
    private boolean bP;
    private boolean bQ;
    private boolean bR;
    private boolean bS;
    private int bT;
    private int bU;
    private SavedState bV;
    private if bW;

    private LinearLayoutManager(int i, boolean flag)
    {
        bP = false;
        bQ = false;
        bR = false;
        bS = true;
        bT = -1;
        bU = 0x80000000;
        bV = null;
        bW = new if();
        if (false);
        if (bV == null)
        {
            super._mth1FBE(null);
        }
        if (1 != bA)
        {
            bA = 1;
            bN = null;
            if (super.eH != null)
            {
                super.eH.requestLayout();
            }
        }
        if (bV == null)
        {
            super._mth1FBE(null);
        }
        if (bP)
        {
            bP = false;
            if (super.eH != null)
            {
                super.eH.requestLayout();
            }
        }
    }

    public LinearLayoutManager(Context context)
    {
        this(1, false);
    }

    private void _mth027F()
    {
        boolean flag1;
label0:
        {
label1:
            {
                if (bA != 1)
                {
                    boolean flag;
                    if (FE70._mth02C9(super.eH) == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        break label1;
                    }
                }
                flag1 = bP;
                break label0;
            }
            if (!bP)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        bQ = flag1;
    }

    private void _mth029F()
    {
        if (bM == null)
        {
            bM = new _cls02CB();
        }
        if (bN == null)
        {
            bN = _cls2174._mth02CA(this, bA);
        }
    }

    private View _mth02B0()
    {
        int i;
        if (bQ)
        {
            if (super.dC != null)
            {
                _cls0690 _lcls0690 = super.dC;
                i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
            } else
            {
                i = 0;
            }
            i--;
        } else
        {
            i = 0;
        }
        if (super.dC != null)
        {
            _cls0690 _lcls0690_1 = super.dC;
            i = _lcls0690_1.FB1D(i);
            return _lcls0690_1.aF.getChildAt(i);
        } else
        {
            return null;
        }
    }

    private void _mth02B9(int i, int j)
    {
        bM.cf = j - bN._mth14D1();
        bM.cg = i;
        _cls02CB _lcls02cb = bM;
        if (bQ)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        _lcls02cb.ch = i;
        bM.ci = -1;
        bM._fld1D4A = j;
        bM.cj = 0x80000000;
    }

    private int _mth02BC(RecyclerView.con con)
    {
        int i;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return 0;
        }
        _mth029F();
        _cls2174 _lcls2174 = bN;
        boolean flag;
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        View view = _mth02CB(flag, true);
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return _cls1FD0._mth02CA(con, _lcls2174, view, _mth02CE(flag, true), this, bS, bQ);
    }

    private int _mth02BD(RecyclerView.con con)
    {
        int i;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return 0;
        }
        _mth029F();
        _cls2174 _lcls2174 = bN;
        boolean flag;
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        View view = _mth02CB(flag, true);
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return _cls1FD0._mth02CA(con, _lcls2174, view, _mth02CE(flag, true), this, bS);
    }

    private View _mth02BD(int i, int j, int k)
    {
        _mth029F();
        View view = null;
        View view1 = null;
        int j1 = bN._mth14D1();
        int k1 = bN._mth1506();
        byte byte0;
        if (j > i)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        while (i != j) 
        {
            Object obj;
            if (super.dC != null)
            {
                obj = super.dC;
                int l = ((_cls0690) (obj)).FB1D(i);
                obj = ((_cls0690) (obj)).aF.getChildAt(l);
            } else
            {
                obj = null;
            }
            int i1 = ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
            View view2 = view;
            View view3 = view1;
            if (i1 >= 0)
            {
                view2 = view;
                view3 = view1;
                if (i1 < k)
                {
                    boolean flag;
                    if ((((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ._fld0E20 & 8) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        view2 = view;
                        view3 = view1;
                        if (view == null)
                        {
                            view2 = ((View) (obj));
                            view3 = view1;
                        }
                    } else
                    if (bN._mth1421(((View) (obj))) >= k1 || bN._mth142A(((View) (obj))) < j1)
                    {
                        view2 = view;
                        view3 = view1;
                        if (view1 == null)
                        {
                            view2 = view;
                            view3 = ((View) (obj));
                        }
                    } else
                    {
                        return ((View) (obj));
                    }
                }
            }
            i += byte0;
            view = view2;
            view1 = view3;
        }
        if (view1 != null)
        {
            return view1;
        } else
        {
            return view;
        }
    }

    private View _mth02BE(RecyclerView.con con)
    {
        int i;
        int j;
        int k;
        if (bQ)
        {
            LinearLayoutManager linearlayoutmanager = this;
            if (con.fr)
            {
                i = con.fo - con.fp;
            } else
            {
                i = con.fn;
            }
            if (((RecyclerView._cls02BB) (linearlayoutmanager)).dC != null)
            {
                con = ((RecyclerView._cls02BB) (linearlayoutmanager)).dC;
                j = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
            } else
            {
                j = 0;
            }
            k = j - 1;
            j = -1;
        } else
        {
            LinearLayoutManager linearlayoutmanager1 = this;
            if (con.fr)
            {
                i = con.fo - con.fp;
            } else
            {
                i = con.fn;
            }
            k = 0;
            if (((RecyclerView._cls02BB) (linearlayoutmanager1)).dC != null)
            {
                con = ((RecyclerView._cls02BB) (linearlayoutmanager1)).dC;
                j = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
            } else
            {
                j = 0;
            }
        }
        return _mth02BD(k, j, i);
    }

    private int _mth02CA(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con, boolean flag)
    {
        int j = bN._mth1506() - i;
        if (j > 0)
        {
            j = -_mth02CE(-j, _pcls1fbe, con);
        } else
        {
            return 0;
        }
        if (flag)
        {
            i = bN._mth1506() - (i + j);
            if (i > 0)
            {
                bN._mth1508(i);
                return i + j;
            }
        }
        return j;
    }

    private int _mth02CA(RecyclerView._cls1FBE _pcls1fbe, _cls02CB _pcls02cb, RecyclerView.con con, boolean flag)
    {
        int k = _pcls02cb.cf;
        if (_pcls02cb.cj != 0x80000000)
        {
            if (_pcls02cb.cf < 0)
            {
                _pcls02cb.cj = _pcls02cb.cj + _pcls02cb.cf;
            }
            _mth02CA(_pcls1fbe, _pcls02cb);
        }
        int i = _pcls02cb.cf + _pcls02cb.ck;
        _cls02CA _lcls02ca = new _cls02CA();
label0:
        do
        {
            int j;
            do
            {
label1:
                {
                    if (i <= 0)
                    {
                        break label0;
                    }
                    if (_pcls02cb.cg >= 0)
                    {
                        int l = _pcls02cb.cg;
                        if (con.fr)
                        {
                            j = con.fo - con.fp;
                        } else
                        {
                            j = con.fn;
                        }
                        if (l < j)
                        {
                            j = 1;
                            break label1;
                        }
                    }
                    j = 0;
                }
label2:
                {
                    if (!j)
                    {
                        break label0;
                    }
                    _lcls02ca.cc = 0;
                    _lcls02ca.FF6B = false;
                    _lcls02ca.cd = false;
                    _lcls02ca.FF6E = false;
                    _mth02CA(_pcls1fbe, _pcls02cb, _lcls02ca);
                    if (_lcls02ca.FF6B)
                    {
                        break label0;
                    }
                    _pcls02cb._fld1D4A = _pcls02cb._fld1D4A + _lcls02ca.cc * _pcls02cb.ci;
                    if (_lcls02ca.cd && bM.cn == null)
                    {
                        j = i;
                        if (con.fr)
                        {
                            break label2;
                        }
                    }
                    _pcls02cb.cf = _pcls02cb.cf - _lcls02ca.cc;
                    j = i - _lcls02ca.cc;
                }
                if (_pcls02cb.cj != 0x80000000)
                {
                    _pcls02cb.cj = _pcls02cb.cj + _lcls02ca.cc;
                    if (_pcls02cb.cf < 0)
                    {
                        _pcls02cb.cj = _pcls02cb.cj + _pcls02cb.cf;
                    }
                    _mth02CA(_pcls1fbe, _pcls02cb);
                }
                i = j;
            } while (!flag);
            i = j;
        } while (!_lcls02ca.FF6E);
        return k - _pcls02cb.cf;
    }

    private void _mth02CA(int i, int j, boolean flag, RecyclerView.con con)
    {
        _cls02CB _lcls02cb = bM;
        boolean flag1;
        if (con.eZ != -1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        int k;
        if (flag1)
        {
            k = bN._mth1D16();
        } else
        {
            k = 0;
        }
        _lcls02cb.ck = k;
        bM.ci = i;
        if (i == 1)
        {
            con = bM;
            con.ck = ((_cls02CB) (con)).ck + bN.getEndPadding();
            if (bQ)
            {
                i = 0;
            } else
            {
                if (super.dC != null)
                {
                    con = super.dC;
                    i = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
                } else
                {
                    i = 0;
                }
                i--;
            }
            if (super.dC != null)
            {
                con = super.dC;
                i = con.FB1D(i);
                con = ((_cls0690) (con)).aF.getChildAt(i);
            } else
            {
                con = null;
            }
            _cls02CB _lcls02cb1 = bM;
            if (bQ)
            {
                i = -1;
            } else
            {
                i = 1;
            }
            _lcls02cb1.ch = i;
            bM.cg = ((RecyclerView._cls02BC)con.getLayoutParams()).eJ.getLayoutPosition() + bM.ch;
            bM._fld1D4A = bN._mth142A(con);
            i = bN._mth142A(con) - bN._mth1506();
        } else
        {
            if (bQ)
            {
                if (super.dC != null)
                {
                    con = super.dC;
                    i = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
                } else
                {
                    i = 0;
                }
                i--;
            } else
            {
                i = 0;
            }
            if (super.dC != null)
            {
                con = super.dC;
                i = con.FB1D(i);
                con = ((_cls0690) (con)).aF.getChildAt(i);
            } else
            {
                con = null;
            }
            _cls02CB _lcls02cb2 = bM;
            _lcls02cb2.ck = _lcls02cb2.ck + bN._mth14D1();
            _lcls02cb2 = bM;
            if (bQ)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            _lcls02cb2.ch = i;
            bM.cg = ((RecyclerView._cls02BC)con.getLayoutParams()).eJ.getLayoutPosition() + bM.ch;
            bM._fld1D4A = bN._mth1421(con);
            i = -bN._mth1421(con) + bN._mth14D1();
        }
        bM.cf = j;
        if (flag)
        {
            con = bM;
            con.cf = ((_cls02CB) (con)).cf - i;
        }
        bM.cj = i;
    }

    private void _mth02CA(RecyclerView._cls1FBE _pcls1fbe, int i, int j)
    {
        if (i == j)
        {
            return;
        }
        if (j > i)
        {
            for (j--; j >= i; j--)
            {
                Object obj;
                if (super.dC != null)
                {
                    obj = super.dC;
                    int k = ((_cls0690) (obj)).FB1D(j);
                    obj = ((_cls0690) (obj)).aF.getChildAt(k);
                } else
                {
                    obj = null;
                }
                Object obj2;
                if (super.dC != null)
                {
                    obj2 = super.dC;
                    int l = ((_cls0690) (obj2)).FB1D(j);
                    obj2 = ((_cls0690) (obj2)).aF.getChildAt(l);
                } else
                {
                    obj2 = null;
                }
                if (obj2 != null)
                {
                    super.dC.removeViewAt(j);
                }
                _pcls1fbe._mth02D0(((View) (obj)));
            }

            return;
        }
        for (; i > j; i--)
        {
            Object obj1;
            if (super.dC != null)
            {
                obj1 = super.dC;
                int i1 = ((_cls0690) (obj1)).FB1D(i);
                obj1 = ((_cls0690) (obj1)).aF.getChildAt(i1);
            } else
            {
                obj1 = null;
            }
            Object obj3;
            if (super.dC != null)
            {
                obj3 = super.dC;
                int j1 = ((_cls0690) (obj3)).FB1D(i);
                obj3 = ((_cls0690) (obj3)).aF.getChildAt(j1);
            } else
            {
                obj3 = null;
            }
            if (obj3 != null)
            {
                super.dC.removeViewAt(i);
            }
            _pcls1fbe._mth02D0(((View) (obj1)));
        }

    }

    private void _mth02CA(RecyclerView._cls1FBE _pcls1fbe, _cls02CB _pcls02cb)
    {
        if (!_pcls02cb.ce)
        {
            return;
        }
        if (_pcls02cb.ci == -1)
        {
            int k = _pcls02cb.cj;
            int i;
            if (super.dC != null)
            {
                _pcls02cb = super.dC;
                i = ((_cls0690) (_pcls02cb)).aF.getChildCount() - ((_cls0690) (_pcls02cb)).aH.size();
            } else
            {
                i = 0;
            }
            if (k >= 0)
            {
                int l1 = bN.getEnd() - k;
                if (bQ)
                {
                    for (int l = 0; l < i; l++)
                    {
                        if (super.dC != null)
                        {
                            _pcls02cb = super.dC;
                            int j2 = _pcls02cb.FB1D(l);
                            _pcls02cb = ((_cls0690) (_pcls02cb)).aF.getChildAt(j2);
                        } else
                        {
                            _pcls02cb = null;
                        }
                        if (bN._mth1421(_pcls02cb) < l1)
                        {
                            _mth02CA(_pcls1fbe, 0, l);
                            return;
                        }
                    }

                    return;
                }
                for (int i1 = i - 1; i1 >= 0; i1--)
                {
                    if (super.dC != null)
                    {
                        _pcls02cb = super.dC;
                        int k2 = _pcls02cb.FB1D(i1);
                        _pcls02cb = ((_cls0690) (_pcls02cb)).aF.getChildAt(k2);
                    } else
                    {
                        _pcls02cb = null;
                    }
                    if (bN._mth1421(_pcls02cb) < l1)
                    {
                        _mth02CA(_pcls1fbe, i - 1, i1);
                        return;
                    }
                }

            }
            return;
        }
        int i2 = _pcls02cb.cj;
        if (i2 >= 0)
        {
            int j;
            if (super.dC != null)
            {
                _pcls02cb = super.dC;
                j = ((_cls0690) (_pcls02cb)).aF.getChildCount() - ((_cls0690) (_pcls02cb)).aH.size();
            } else
            {
                j = 0;
            }
            if (bQ)
            {
                for (int j1 = j - 1; j1 >= 0; j1--)
                {
                    if (super.dC != null)
                    {
                        _pcls02cb = super.dC;
                        int l2 = _pcls02cb.FB1D(j1);
                        _pcls02cb = ((_cls0690) (_pcls02cb)).aF.getChildAt(l2);
                    } else
                    {
                        _pcls02cb = null;
                    }
                    if (bN._mth142A(_pcls02cb) > i2)
                    {
                        _mth02CA(_pcls1fbe, j - 1, j1);
                        return;
                    }
                }

                return;
            }
            for (int k1 = 0; k1 < j; k1++)
            {
                if (super.dC != null)
                {
                    _pcls02cb = super.dC;
                    int i3 = _pcls02cb.FB1D(k1);
                    _pcls02cb = ((_cls0690) (_pcls02cb)).aF.getChildAt(i3);
                } else
                {
                    _pcls02cb = null;
                }
                if (bN._mth142A(_pcls02cb) > i2)
                {
                    _mth02CA(_pcls1fbe, 0, k1);
                    return;
                }
            }

        }
    }

    private void _mth02CA(RecyclerView._cls1FBE _pcls1fbe, _cls02CB _pcls02cb, _cls02CA _pcls02ca)
    {
label0:
        {
            _pcls1fbe = _pcls02cb._mth02CA(_pcls1fbe);
            if (_pcls1fbe == null)
            {
                _pcls02ca.FF6B = true;
                return;
            }
            RecyclerView._cls02BC _lcls02bc = (RecyclerView._cls02BC)_pcls1fbe.getLayoutParams();
            if (_pcls02cb.cn == null)
            {
                boolean flag5 = bQ;
                boolean flag3;
                if (_pcls02cb.ci == -1)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (flag5 == flag3)
                {
                    super._mth02CE(_pcls1fbe, -1, false);
                } else
                {
                    super._mth02CE(_pcls1fbe, 0, false);
                }
            } else
            {
                boolean flag6 = bQ;
                boolean flag4;
                if (_pcls02cb.ci == -1)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                if (flag6 == flag4)
                {
                    super._mth02CE(_pcls1fbe, -1, true);
                } else
                {
                    super._mth02CE(_pcls1fbe, 0, true);
                }
            }
            _mth141D(_pcls1fbe, 0, 0);
            _pcls02ca.cc = bN._mth14BD(_pcls1fbe);
            int i;
            int l;
            int i1;
            int j1;
            if (bA == 1)
            {
                boolean flag;
                if (FE70._mth02C9(super.eH) == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    if (super.eH != null)
                    {
                        i = super.eH.getWidth();
                    } else
                    {
                        i = 0;
                    }
                    int j;
                    if (super.eH != null)
                    {
                        j = super.eH.getPaddingRight();
                    } else
                    {
                        j = 0;
                    }
                    i -= j;
                    i1 = i;
                    i -= bN._mth1507(_pcls1fbe);
                } else
                {
                    if (super.eH != null)
                    {
                        i = super.eH.getPaddingLeft();
                    } else
                    {
                        i = 0;
                    }
                    int k = i;
                    i1 = i + bN._mth1507(_pcls1fbe);
                    i = k;
                }
                if (_pcls02cb.ci == -1)
                {
                    j1 = _pcls02cb._fld1D4A;
                    l = _pcls02cb._fld1D4A - _pcls02ca.cc;
                } else
                {
                    l = _pcls02cb._fld1D4A;
                    j1 = _pcls02cb._fld1D4A + _pcls02ca.cc;
                }
            } else
            {
                if (super.eH != null)
                {
                    i = super.eH.getPaddingTop();
                } else
                {
                    i = 0;
                }
                l = i;
                j1 = i + bN._mth1507(_pcls1fbe);
                if (_pcls02cb.ci == -1)
                {
                    i1 = _pcls02cb._fld1D4A;
                    i = _pcls02cb._fld1D4A - _pcls02ca.cc;
                } else
                {
                    i = _pcls02cb._fld1D4A;
                    i1 = _pcls02cb._fld1D4A + _pcls02ca.cc;
                }
            }
            _mth02CF(_pcls1fbe, _lcls02bc.leftMargin + i, _lcls02bc.topMargin + l, i1 - _lcls02bc.rightMargin, j1 - _lcls02bc.bottomMargin);
            boolean flag1;
            if ((_lcls02bc.eJ._fld0E20 & 8) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                boolean flag2;
                if ((_lcls02bc.eJ._fld0E20 & 0x40) != 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag2)
                {
                    break label0;
                }
            }
            _pcls02ca.cd = true;
        }
        _pcls02ca.FF6E = _pcls1fbe.isFocusable();
    }

    private void _mth02CA(RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con, int i, int j)
    {
label0:
        {
            if (con.ft)
            {
                int k;
                if (super.dC != null)
                {
                    _cls0690 _lcls0690 = super.dC;
                    k = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
                } else
                {
                    k = 0;
                }
                if (k != 0 && !con.fr)
                {
                    boolean flag;
                    if (bV == null && bO == bR)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        break label0;
                    }
                }
            }
            return;
        }
        int i1 = 0;
        int l = 0;
        List list = _pcls1fbe.eT;
        int k2 = list.size();
        Object obj;
        if (super.dC != null)
        {
            obj = super.dC;
            int j1 = ((_cls0690) (obj)).FB1D(0);
            obj = ((_cls0690) (obj)).aF.getChildAt(j1);
        } else
        {
            obj = null;
        }
        int l2 = ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
        for (int k1 = 0; k1 < k2;)
        {
            RecyclerView._cls02CC _lcls02cc = (RecyclerView._cls02CC)list.get(k1);
            boolean flag1;
            if ((_lcls02cc._fld0E20 & 8) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            int i2 = i1;
            int j2 = l;
            if (!flag1)
            {
                boolean flag2;
                if (_lcls02cc.getLayoutPosition() < l2)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2 != bQ)
                {
                    i2 = -1;
                } else
                {
                    i2 = 1;
                }
                if (i2 == -1)
                {
                    i2 = i1 + bN._mth14BD(_lcls02cc.fy);
                    j2 = l;
                } else
                {
                    j2 = l + bN._mth14BD(_lcls02cc.fy);
                    i2 = i1;
                }
            }
            k1++;
            i1 = i2;
            l = j2;
        }

        bM.cn = list;
        if (i1 > 0)
        {
            int l1;
            if (bQ)
            {
                if (super.dC != null)
                {
                    _cls0690 _lcls0690_1 = super.dC;
                    l1 = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
                } else
                {
                    l1 = 0;
                }
                l1--;
            } else
            {
                l1 = 0;
            }
            Object obj1;
            if (super.dC != null)
            {
                obj1 = super.dC;
                l1 = ((_cls0690) (obj1)).FB1D(l1);
                obj1 = ((_cls0690) (obj1)).aF.getChildAt(l1);
            } else
            {
                obj1 = null;
            }
            _mth02B9(((RecyclerView._cls02BC)((View) (obj1)).getLayoutParams()).eJ.getLayoutPosition(), i);
            bM.ck = i1;
            bM.cf = 0;
            obj1 = bM;
            RecyclerView._cls02CC _lcls02cc1 = ((_cls02CB) (obj1))._mth02CF(null);
            if (_lcls02cc1 == null)
            {
                i = -1;
            } else
            {
                i = _lcls02cc1.getLayoutPosition();
            }
            obj1.cg = i;
            _mth02CA(_pcls1fbe, bM, con, false);
        }
        if (l > 0)
        {
            if (bQ)
            {
                i = 0;
            } else
            {
                if (super.dC != null)
                {
                    _cls0690 _lcls0690_2 = super.dC;
                    i = _lcls0690_2.aF.getChildCount() - _lcls0690_2.aH.size();
                } else
                {
                    i = 0;
                }
                i--;
            }
            Object obj2;
            if (super.dC != null)
            {
                obj2 = super.dC;
                i = ((_cls0690) (obj2)).FB1D(i);
                obj2 = ((_cls0690) (obj2)).aF.getChildAt(i);
            } else
            {
                obj2 = null;
            }
            FF9E(((RecyclerView._cls02BC)((View) (obj2)).getLayoutParams()).eJ.getLayoutPosition(), j);
            bM.ck = l;
            bM.cf = 0;
            obj2 = bM;
            RecyclerView._cls02CC _lcls02cc2 = ((_cls02CB) (obj2))._mth02CF(null);
            if (_lcls02cc2 == null)
            {
                i = -1;
            } else
            {
                i = _lcls02cc2.getLayoutPosition();
            }
            obj2.cg = i;
            _mth02CA(_pcls1fbe, bM, con, false);
        }
        bM.cn = null;
    }

    private int _mth02CB(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con, boolean flag)
    {
        int j = i - bN._mth14D1();
        if (j > 0)
        {
            j = -_mth02CE(j, _pcls1fbe, con);
        } else
        {
            return 0;
        }
        if (flag)
        {
            i = (i + j) - bN._mth14D1();
            if (i > 0)
            {
                bN._mth1508(-i);
                return j - i;
            }
        }
        return j;
    }

    private View _mth02CB(boolean flag, boolean flag1)
    {
        if (bQ)
        {
            int i;
            if (super.dC != null)
            {
                _cls0690 _lcls0690 = super.dC;
                i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
            } else
            {
                i = 0;
            }
            return _mth02CA(i - 1, -1, flag, true);
        }
        int j;
        if (super.dC != null)
        {
            _cls0690 _lcls0690_1 = super.dC;
            j = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
        } else
        {
            j = 0;
        }
        return _mth02CA(0, j, flag, true);
    }

    private int _mth02CE(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con)
    {
        int j;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            j = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            j = 0;
        }
        if (j == 0 || i == 0)
        {
            return 0;
        }
        bM.ce = true;
        _mth029F();
        if (i > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        int k = Math.abs(i);
        _mth02CA(j, k, true, con);
        int l = bM.cj + _mth02CA(_pcls1fbe, bM, con, false);
        if (l < 0)
        {
            return 0;
        }
        if (k > l)
        {
            i = j * l;
        }
        bN._mth1508(-i);
        bM.cm = i;
        return i;
    }

    private View _mth02CE(boolean flag, boolean flag1)
    {
        if (bQ)
        {
            int i;
            if (super.dC != null)
            {
                _cls0690 _lcls0690 = super.dC;
                i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
            } else
            {
                i = 0;
            }
            return _mth02CA(0, i, flag, true);
        }
        int j;
        if (super.dC != null)
        {
            _cls0690 _lcls0690_1 = super.dC;
            j = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
        } else
        {
            j = 0;
        }
        return _mth02CA(j - 1, -1, flag, true);
    }

    private int _mth037A(RecyclerView.con con)
    {
        int i;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return 0;
        }
        _mth029F();
        _cls2174 _lcls2174 = bN;
        boolean flag;
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        View view = _mth02CB(flag, true);
        if (!bS)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return _cls1FD0._mth02CB(con, _lcls2174, view, _mth02CE(flag, true), this, bS);
    }

    private View _mth03AA()
    {
        int i;
        if (bQ)
        {
            i = 0;
        } else
        {
            if (super.dC != null)
            {
                _cls0690 _lcls0690 = super.dC;
                i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
            } else
            {
                i = 0;
            }
            i--;
        }
        if (super.dC != null)
        {
            _cls0690 _lcls0690_1 = super.dC;
            i = _lcls0690_1.FB1D(i);
            return _lcls0690_1.aF.getChildAt(i);
        } else
        {
            return null;
        }
    }

    private View _mth1FBE(RecyclerView.con con)
    {
        if (bQ)
        {
            int i;
            if (con.fr)
            {
                i = con.fo - con.fp;
            } else
            {
                i = con.fn;
            }
            int k;
            if (super.dC != null)
            {
                con = super.dC;
                k = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
            } else
            {
                k = 0;
            }
            return _mth02BD(0, k, i);
        }
        int j;
        if (con.fr)
        {
            j = con.fo - con.fp;
        } else
        {
            j = con.fn;
        }
        int l;
        if (super.dC != null)
        {
            con = super.dC;
            l = ((_cls0690) (con)).aF.getChildCount() - ((_cls0690) (con)).aH.size();
        } else
        {
            l = 0;
        }
        return _mth02BD(l - 1, -1, j);
    }

    private void FF9E(int i, int j)
    {
        bM.cf = bN._mth1506() - j;
        _cls02CB _lcls02cb = bM;
        int k;
        if (bQ)
        {
            k = -1;
        } else
        {
            k = 1;
        }
        _lcls02cb.ch = k;
        bM.cg = i;
        bM.ci = 1;
        bM._fld1D4A = j;
        bM.cj = 0x80000000;
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        int i;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            i = 0;
        }
        if (i > 0)
        {
            accessibilityevent = _cls020B._mth02CA(accessibilityevent);
            int j;
            if (super.dC != null)
            {
                _cls0690 _lcls0690_1 = super.dC;
                j = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
            } else
            {
                j = 0;
            }
            Object obj = _mth02CA(0, j, false, true);
            if (obj == null)
            {
                j = -1;
            } else
            {
                j = ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
            }
            accessibilityevent.setFromIndex(j);
            if (super.dC != null)
            {
                obj = super.dC;
                j = ((_cls0690) (obj)).aF.getChildCount() - ((_cls0690) (obj)).aH.size();
            } else
            {
                j = 0;
            }
            obj = _mth02CA(j - 1, -1, false, true);
            if (obj == null)
            {
                j = -1;
            } else
            {
                j = ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
            }
            accessibilityevent.setToIndex(j);
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            bV = (SavedState)parcelable;
            if (super.eH != null)
            {
                super.eH.requestLayout();
            }
        }
    }

    public final RecyclerView._cls02BC _mth020B()
    {
        return new RecyclerView._cls02BC(-2, -2);
    }

    public final SavedState _mth0268()
    {
        if (bV != null)
        {
            return new SavedState(bV);
        }
        SavedState savedstate = new SavedState();
        int i;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            i = 0;
        }
        if (i > 0)
        {
            _mth029F();
            boolean flag = bO ^ bQ;
            savedstate.cq = flag;
            if (flag)
            {
                int j;
                if (bQ)
                {
                    j = 0;
                } else
                {
                    if (super.dC != null)
                    {
                        _cls0690 _lcls0690_1 = super.dC;
                        j = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
                    } else
                    {
                        j = 0;
                    }
                    j--;
                }
                Object obj;
                if (super.dC != null)
                {
                    obj = super.dC;
                    j = ((_cls0690) (obj)).FB1D(j);
                    obj = ((_cls0690) (obj)).aF.getChildAt(j);
                } else
                {
                    obj = null;
                }
                savedstate.cp = bN._mth1506() - bN._mth142A(((View) (obj)));
                savedstate.co = ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
                return savedstate;
            }
            int k;
            if (bQ)
            {
                if (super.dC != null)
                {
                    _cls0690 _lcls0690_2 = super.dC;
                    k = _lcls0690_2.aF.getChildCount() - _lcls0690_2.aH.size();
                } else
                {
                    k = 0;
                }
                k--;
            } else
            {
                k = 0;
            }
            Object obj1;
            if (super.dC != null)
            {
                obj1 = super.dC;
                k = ((_cls0690) (obj1)).FB1D(k);
                obj1 = ((_cls0690) (obj1)).aF.getChildAt(k);
            } else
            {
                obj1 = null;
            }
            savedstate.co = ((RecyclerView._cls02BC)((View) (obj1)).getLayoutParams()).eJ.getLayoutPosition();
            savedstate.cp = bN._mth1421(((View) (obj1))) - bN._mth14D1();
            return savedstate;
        } else
        {
            savedstate.co = -1;
            return savedstate;
        }
    }

    public final boolean _mth026A()
    {
        return bA == 0;
    }

    public boolean _mth027E()
    {
        return bA == 1;
    }

    public final int _mth02BB(RecyclerView.con con)
    {
        return _mth037A(con);
    }

    public final int _mth02CA(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con)
    {
        if (bA == 1)
        {
            return 0;
        } else
        {
            return _mth02CE(i, _pcls1fbe, con);
        }
    }

    public final int _mth02CA(RecyclerView.con con)
    {
        return _mth02BC(con);
    }

    public final View _mth02CA(int i, int j, boolean flag, boolean flag1)
    {
        _mth029F();
        int k = bN._mth14D1();
        int l = bN._mth1506();
        byte byte0;
        if (j > i)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        View view;
        View view1;
        for (view = null; i != j; view = view1)
        {
            Object obj;
            if (super.dC != null)
            {
                obj = super.dC;
                int i1 = ((_cls0690) (obj)).FB1D(i);
                obj = ((_cls0690) (obj)).aF.getChildAt(i1);
            } else
            {
                obj = null;
            }
            int j1 = bN._mth1421(((View) (obj)));
            int k1 = bN._mth142A(((View) (obj)));
            view1 = view;
            if (j1 < l)
            {
                view1 = view;
                if (k1 > k)
                {
                    if (flag)
                    {
                        if (j1 >= k && k1 <= l)
                        {
                            return ((View) (obj));
                        }
                        view1 = view;
                        if (flag1)
                        {
                            view1 = view;
                            if (view == null)
                            {
                                view1 = ((View) (obj));
                            }
                        }
                    } else
                    {
                        return ((View) (obj));
                    }
                }
            }
            i += byte0;
        }

        return view;
    }

    public final void _mth02CA(RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con)
    {
        if if2;
        int i;
label0:
        {
label1:
            {
                if (bV != null)
                {
                    boolean flag;
                    if (bV.co >= 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        bT = bV.co;
                    }
                }
                _mth029F();
                bM.ce = false;
                _mth027F();
                if if1 = bW;
                if1.bX = -1;
                if1.bY = 0x80000000;
                if1.bZ = false;
                bW.bZ = bQ ^ bR;
                if2 = bW;
                if (con.fr || bT == -1)
                {
                    i = 0;
                    break label0;
                }
                if (bT >= 0)
                {
                    int j = bT;
                    if (con.fr)
                    {
                        i = con.fo - con.fp;
                    } else
                    {
                        i = con.fn;
                    }
                    if (j < i)
                    {
                        break label1;
                    }
                }
                bT = -1;
                bU = 0x80000000;
                i = 0;
                break label0;
            }
label2:
            {
                if2.bX = bT;
                if (bV != null)
                {
                    if (bV.co >= 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        if2.bZ = bV.cq;
                        if (if2.bZ)
                        {
                            if2.bY = bN._mth1506() - bV.cp;
                        } else
                        {
                            if2.bY = bN._mth14D1() + bV.cp;
                        }
                        i = 1;
                        break label0;
                    }
                }
                if (bU == 0x80000000)
                {
                    Object obj = _mth14BD(bT);
                    if (obj != null)
                    {
                        if (bN._mth14BD(((View) (obj))) > bN._mth1D16())
                        {
                            if2._mth0433();
                            break label2;
                        }
                        if (bN._mth1421(((View) (obj))) - bN._mth14D1() < 0)
                        {
                            if2.bY = bN._mth14D1();
                            if2.bZ = false;
                            break label2;
                        }
                        if (bN._mth1506() - bN._mth142A(((View) (obj))) < 0)
                        {
                            if2.bY = bN._mth1506();
                            if2.bZ = true;
                            break label2;
                        }
                        if (if2.bZ)
                        {
                            int k = bN._mth142A(((View) (obj)));
                            obj = bN;
                            if (0x80000000 == ((_cls2174) (obj)).dv)
                            {
                                i = 0;
                            } else
                            {
                                i = ((_cls2174) (obj))._mth1D16() - ((_cls2174) (obj)).dv;
                            }
                            i = k + i;
                        } else
                        {
                            i = bN._mth1421(((View) (obj)));
                        }
                        if2.bY = i;
                    } else
                    {
                        if (super.dC != null)
                        {
                            _cls0690 _lcls0690 = super.dC;
                            i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
                        } else
                        {
                            i = 0;
                        }
                        if (i > 0)
                        {
                            Object obj1;
                            if (super.dC != null)
                            {
                                obj1 = super.dC;
                                i = ((_cls0690) (obj1)).FB1D(0);
                                obj1 = ((_cls0690) (obj1)).aF.getChildAt(i);
                            } else
                            {
                                obj1 = null;
                            }
                            i = ((RecyclerView._cls02BC)((View) (obj1)).getLayoutParams()).eJ.getLayoutPosition();
                            boolean flag8;
                            if (bT < i)
                            {
                                flag8 = true;
                            } else
                            {
                                flag8 = false;
                            }
                            if (flag8 == bQ)
                            {
                                flag8 = true;
                            } else
                            {
                                flag8 = false;
                            }
                            if2.bZ = flag8;
                        }
                        if2._mth0433();
                    }
                    i = 1;
                    break label0;
                }
                if2.bZ = bQ;
                if (bQ)
                {
                    if2.bY = bN._mth1506() - bU;
                } else
                {
                    if2.bY = bN._mth14D1() + bU;
                }
            }
            i = 1;
        }
label3:
        {
label4:
            {
label5:
                {
label6:
                    {
                        View view;
                        boolean flag1;
label7:
                        {
                            if (i != 0)
                            {
                                break label3;
                            }
                            if (super.dC != null)
                            {
                                _cls0690 _lcls0690_1 = super.dC;
                                i = _lcls0690_1.aF.getChildCount() - _lcls0690_1.aH.size();
                            } else
                            {
                                i = 0;
                            }
                            if (i == 0)
                            {
                                break label5;
                            }
                            if (super.eH == null)
                            {
                                view = null;
                            } else
                            {
                                view = super.eH.getFocusedChild();
                                if (view == null || super.dC.aH.contains(view))
                                {
                                    view = null;
                                }
                            }
                            if (view == null)
                            {
                                break label6;
                            }
                            RecyclerView._cls02BC _lcls02bc = (RecyclerView._cls02BC)view.getLayoutParams();
                            if ((_lcls02bc.eJ._fld0E20 & 8) != 0)
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag1 && _lcls02bc.eJ.getLayoutPosition() >= 0)
                            {
                                int l = _lcls02bc.eJ.getLayoutPosition();
                                if (con.fr)
                                {
                                    flag1 = con.fo - con.fp;
                                } else
                                {
                                    flag1 = con.fn;
                                }
                                if (l < flag1)
                                {
                                    flag1 = true;
                                    break label7;
                                }
                            }
                            flag1 = false;
                        }
                        if (flag1)
                        {
                            _cls2174 _lcls2174 = if2.ca.bN;
                            if (0x80000000 == _lcls2174.dv)
                            {
                                flag1 = false;
                            } else
                            {
                                flag1 = _lcls2174._mth1D16() - _lcls2174.dv;
                            }
                            if (flag1 >= 0)
                            {
                                if2._mth141F(view);
                            } else
                            {
                                if2.bX = ((RecyclerView._cls02BC)view.getLayoutParams()).eJ.getLayoutPosition();
                                if (if2.bZ)
                                {
                                    flag1 = if2.ca.bN._mth1506() - flag1 - if2.ca.bN._mth142A(view);
                                    if2.bY = if2.ca.bN._mth1506() - flag1;
                                    if (flag1 > 0)
                                    {
                                        int i1 = if2.ca.bN._mth14BD(view);
                                        int k2 = if2.bY;
                                        int k3 = if2.ca.bN._mth14D1();
                                        i1 = k2 - i1 - (k3 + Math.min(if2.ca.bN._mth1421(view) - k3, 0));
                                        if (i1 < 0)
                                        {
                                            if2.bY = if2.bY + Math.min(flag1, -i1);
                                        }
                                    }
                                } else
                                {
                                    int l2 = if2.ca.bN._mth1421(view);
                                    int j1 = l2 - if2.ca.bN._mth14D1();
                                    if2.bY = l2;
                                    if (j1 > 0)
                                    {
                                        int l3 = if2.ca.bN._mth14BD(view);
                                        int j4 = if2.ca.bN._mth1506();
                                        int i5 = if2.ca.bN._mth142A(view);
                                        flag1 = if2.ca.bN._mth1506() - Math.min(0, j4 - flag1 - i5) - (l2 + l3);
                                        if (flag1 < 0)
                                        {
                                            if2.bY = if2.bY - Math.min(j1, -flag1);
                                        }
                                    }
                                }
                            }
                            flag1 = true;
                            break label4;
                        }
                    }
                    if (bO == bR)
                    {
                        Object obj2;
                        if (if2.bZ)
                        {
                            if (bQ)
                            {
                                if (con.fr)
                                {
                                    flag1 = con.fo - con.fp;
                                } else
                                {
                                    flag1 = con.fn;
                                }
                                int k1;
                                if (super.dC != null)
                                {
                                    _cls0690 _lcls0690_2 = super.dC;
                                    k1 = _lcls0690_2.aF.getChildCount() - _lcls0690_2.aH.size();
                                } else
                                {
                                    k1 = 0;
                                }
                                obj2 = _mth02BD(0, k1, flag1);
                            } else
                            {
                                if (con.fr)
                                {
                                    flag1 = con.fo - con.fp;
                                } else
                                {
                                    flag1 = con.fn;
                                }
                                int l1;
                                if (super.dC != null)
                                {
                                    obj2 = super.dC;
                                    l1 = ((_cls0690) (obj2)).aF.getChildCount() - ((_cls0690) (obj2)).aH.size();
                                } else
                                {
                                    l1 = 0;
                                }
                                obj2 = _mth02BD(l1 - 1, -1, flag1);
                            }
                        } else
                        {
                            int i2;
                            int i3;
                            if (bQ)
                            {
                                obj2 = this;
                                if (con.fr)
                                {
                                    flag1 = con.fo - con.fp;
                                } else
                                {
                                    flag1 = con.fn;
                                }
                                if (((RecyclerView._cls02BB) (obj2)).dC != null)
                                {
                                    obj2 = ((RecyclerView._cls02BB) (obj2)).dC;
                                    i2 = ((_cls0690) (obj2)).aF.getChildCount() - ((_cls0690) (obj2)).aH.size();
                                } else
                                {
                                    i2 = 0;
                                }
                                i3 = i2 - 1;
                                i2 = -1;
                            } else
                            {
                                obj2 = this;
                                if (con.fr)
                                {
                                    flag1 = con.fo - con.fp;
                                } else
                                {
                                    flag1 = con.fn;
                                }
                                i3 = 0;
                                if (((RecyclerView._cls02BB) (obj2)).dC != null)
                                {
                                    obj2 = ((RecyclerView._cls02BB) (obj2)).dC;
                                    i2 = ((_cls0690) (obj2)).aF.getChildCount() - ((_cls0690) (obj2)).aH.size();
                                } else
                                {
                                    i2 = 0;
                                }
                            }
                            obj2 = _mth02BD(i3, i2, flag1);
                        }
                        if (obj2 != null)
                        {
                            if2._mth141F(((View) (obj2)));
                            if (!con.fr)
                            {
                                if (bV == null && bO == bR)
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (flag1 != 0)
                                {
                                    if (bN._mth1421(((View) (obj2))) >= bN._mth1506() || bN._mth142A(((View) (obj2))) < bN._mth14D1())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (flag1 != 0)
                                    {
                                        if (if2.bZ)
                                        {
                                            flag1 = bN._mth1506();
                                        } else
                                        {
                                            flag1 = bN._mth14D1();
                                        }
                                        if2.bY = ((flag1) ? 1 : 0);
                                    }
                                }
                            }
                            flag1 = true;
                            break label4;
                        }
                    }
                }
                flag1 = false;
            }
            if (flag1 == 0)
            {
                if2._mth0433();
                if (bR)
                {
                    if (con.fr)
                    {
                        flag1 = con.fo - con.fp;
                    } else
                    {
                        flag1 = con.fn;
                    }
                    flag1--;
                } else
                {
                    flag1 = false;
                }
                if2.bX = ((flag1) ? 1 : 0);
            }
        }
        boolean flag2;
        if (con.eZ != -1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            flag2 = bN._mth1D16();
        } else
        {
            flag2 = false;
        }
        int j2;
        int j3;
        if (bM.cm >= 0)
        {
            j3 = 0;
            j2 = ((flag2) ? 1 : 0);
        } else
        {
            j2 = 0;
            j3 = ((flag2) ? 1 : 0);
        }
        j3 += bN._mth14D1();
        int i4 = j2 + bN.getEndPadding();
        flag2 = j3;
        j2 = i4;
        if (con.fr)
        {
            flag2 = j3;
            j2 = i4;
            if (bT != -1)
            {
                flag2 = j3;
                j2 = i4;
                if (bU != 0x80000000)
                {
                    View view1 = _mth14BD(bT);
                    flag2 = j3;
                    j2 = i4;
                    if (view1 != null)
                    {
                        if (bQ)
                        {
                            flag2 = bN._mth1506() - bN._mth142A(view1) - bU;
                        } else
                        {
                            flag2 = bN._mth1421(view1);
                            j2 = bN._mth14D1();
                            flag2 = bU - (flag2 - j2);
                        }
                        if (flag2 > 0)
                        {
                            flag2 = j3 + flag2;
                            j2 = i4;
                        } else
                        {
                            j2 = i4 - flag2;
                            flag2 = j3;
                        }
                    }
                }
            }
        }
        if (super.dC != null)
        {
            _cls0690 _lcls0690_3 = super.dC;
            j3 = _lcls0690_3.aF.getChildCount() - _lcls0690_3.aH.size();
        } else
        {
            j3 = 0;
        }
        for (j3--; j3 >= 0; j3--)
        {
            Object obj3;
            if (super.dC != null)
            {
                obj3 = super.dC;
                i4 = ((_cls0690) (obj3)).FB1D(j3);
                obj3 = ((_cls0690) (obj3)).aF.getChildAt(i4);
            } else
            {
                obj3 = null;
            }
            Object obj6 = RecyclerView._mth1508(((View) (obj3)));
            boolean flag3;
            if ((((RecyclerView._cls02CC) (obj6))._fld0E20 & 0x80) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3)
            {
                continue;
            }
            if ((((RecyclerView._cls02CC) (obj6))._fld0E20 & 4) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3)
            {
                boolean flag4;
                if ((((RecyclerView._cls02CC) (obj6))._fld0E20 & 8) != 0)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                if (!flag4)
                {
                    boolean flag5;
                    if ((((RecyclerView._cls02CC) (obj6))._fld0E20 & 0x40) != 0)
                    {
                        flag5 = true;
                    } else
                    {
                        flag5 = false;
                    }
                    if (!flag5 && !RecyclerView._mth02BB(super.eH).ez)
                    {
                        if (super.dC != null)
                        {
                            obj3 = super.dC;
                            flag5 = ((_cls0690) (obj3)).FB1D(j3);
                            obj3 = ((_cls0690) (obj3)).aF.getChildAt(flag5);
                        } else
                        {
                            obj3 = null;
                        }
                        if (obj3 != null)
                        {
                            super.dC.removeViewAt(j3);
                        }
                        _pcls1fbe._mth02C8(((RecyclerView._cls02CC) (obj6)));
                        continue;
                    }
                }
            }
            if (super.dC != null)
            {
                obj6 = super.dC;
                flag5 = ((_cls0690) (obj6)).FB1D(j3);
                ((_cls0690) (obj6)).aF.getChildAt(flag5);
            }
            obj6 = super.dC;
            flag5 = ((_cls0690) (obj6)).FB1D(j3);
            ((_cls0690) (obj6)).aG.FB39(flag5);
            ((_cls0690) (obj6)).aF.detachViewFromParent(flag5);
            obj3 = RecyclerView._mth1508(((View) (obj3)));
            obj3.fG = _pcls1fbe;
            if ((((RecyclerView._cls02CC) (obj3))._fld0E20 & 0x40) != 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            if (!flag5 || !RecyclerView._mth02BD(_pcls1fbe.ex))
            {
                boolean flag6;
                if ((((RecyclerView._cls02CC) (obj3))._fld0E20 & 4) != 0)
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
                if (flag6)
                {
                    boolean flag7;
                    if ((((RecyclerView._cls02CC) (obj3))._fld0E20 & 8) != 0)
                    {
                        flag7 = true;
                    } else
                    {
                        flag7 = false;
                    }
                    if (!flag7 && !RecyclerView._mth02BB(_pcls1fbe.ex).ez)
                    {
                        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                    }
                }
                _pcls1fbe.eQ.add(obj3);
                continue;
            }
            if (_pcls1fbe.eR == null)
            {
                _pcls1fbe.eR = new ArrayList();
            }
            _pcls1fbe.eR.add(obj3);
        }

        bM.cl = con.fr;
        if (bW.bZ)
        {
            Object obj4 = bW;
            _mth02B9(((if) (obj4)).bX, ((if) (obj4)).bY);
            bM.ck = ((flag2) ? 1 : 0);
            _mth02CA(_pcls1fbe, bM, con, false);
            j3 = bM._fld1D4A;
            flag7 = bM.cg;
            flag2 = j2;
            if (bM.cf > 0)
            {
                flag2 = j2 + bM.cf;
            }
            obj4 = bW;
            FF9E(((if) (obj4)).bX, ((if) (obj4)).bY);
            bM.ck = ((flag2) ? 1 : 0);
            obj4 = bM;
            obj4.cg = ((_cls02CB) (obj4)).cg + bM.ch;
            _mth02CA(_pcls1fbe, bM, con, false);
            flag2 = bM._fld1D4A;
            j2 = j3;
            if (bM.cf > 0)
            {
                j2 = bM.cf;
                _mth02B9(flag7, j3);
                bM.ck = j2;
                _mth02CA(_pcls1fbe, bM, con, false);
                j2 = bM._fld1D4A;
            }
        } else
        {
            Object obj5 = bW;
            FF9E(((if) (obj5)).bX, ((if) (obj5)).bY);
            bM.ck = j2;
            _mth02CA(_pcls1fbe, bM, con, false);
            j3 = bM._fld1D4A;
            int k4 = bM.cg;
            j2 = ((flag2) ? 1 : 0);
            if (bM.cf > 0)
            {
                j2 = flag2 + bM.cf;
            }
            obj5 = bW;
            _mth02B9(((if) (obj5)).bX, ((if) (obj5)).bY);
            bM.ck = j2;
            obj5 = bM;
            obj5.cg = ((_cls02CB) (obj5)).cg + bM.ch;
            _mth02CA(_pcls1fbe, bM, con, false);
            flag7 = bM._fld1D4A;
            j2 = ((flag7) ? 1 : 0);
            flag2 = j3;
            if (bM.cf > 0)
            {
                flag2 = bM.cf;
                FF9E(k4, j3);
                bM.ck = ((flag2) ? 1 : 0);
                _mth02CA(_pcls1fbe, bM, con, false);
                flag2 = bM._fld1D4A;
                j2 = ((flag7) ? 1 : 0);
            }
        }
        int l4;
        if (super.dC != null)
        {
            _cls0690 _lcls0690_4 = super.dC;
            l4 = _lcls0690_4.aF.getChildCount() - _lcls0690_4.aH.size();
        } else
        {
            l4 = 0;
        }
        j3 = j2;
        flag7 = flag2;
        if (l4 > 0)
        {
            if (bQ ^ bR)
            {
                flag7 = _mth02CA(flag2, _pcls1fbe, con, true);
                j3 = j2 + flag7;
                j2 = _mth02CB(j3, _pcls1fbe, con, false);
                j3 += j2;
                flag7 = flag2 + flag7 + j2;
            } else
            {
                j3 = _mth02CB(j2, _pcls1fbe, con, true);
                flag2 += j3;
                flag7 = _mth02CA(flag2, _pcls1fbe, con, false);
                j3 = j2 + j3 + flag7;
                flag7 = flag2 + flag7;
            }
        }
        _mth02CA(_pcls1fbe, con, j3, flag7);
        if (!con.fr)
        {
            bT = -1;
            bU = 0x80000000;
            _pcls1fbe = bN;
            _pcls1fbe.dv = _pcls1fbe._mth1D16();
        }
        bO = bR;
        bV = null;
    }

    public final void _mth02CA(RecyclerView recyclerview, RecyclerView._cls1FBE _pcls1fbe)
    {
        super._mth02CA(recyclerview, _pcls1fbe);
    }

    public final int _mth02CB(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con)
    {
        if (bA == 0)
        {
            return 0;
        } else
        {
            return _mth02CE(i, _pcls1fbe, con);
        }
    }

    public final int _mth02CB(RecyclerView.con con)
    {
        return _mth02BC(con);
    }

    public final int _mth02CE(RecyclerView.con con)
    {
        return _mth02BD(con);
    }

    public final int _mth02CF(RecyclerView.con con)
    {
        return _mth02BD(con);
    }

    public final View _mth02CF(int i, RecyclerView._cls1FBE _pcls1fbe, RecyclerView.con con)
    {
        _mth027F();
        int j;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            j = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            j = 0;
        }
        if (j == 0)
        {
            return null;
        }
        switch (i)
        {
        case 1: // '\001'
            i = -1;
            break;

        case 2: // '\002'
            i = 1;
            break;

        case 33: // '!'
            if (bA == 1)
            {
                i = -1;
            } else
            {
                i = 0x80000000;
            }
            break;

        case 130: 
            if (bA == 1)
            {
                i = 1;
            } else
            {
                i = 0x80000000;
            }
            break;

        case 17: // '\021'
            if (bA == 0)
            {
                i = -1;
            } else
            {
                i = 0x80000000;
            }
            break;

        case 66: // 'B'
            if (bA == 0)
            {
                i = 1;
            } else
            {
                i = 0x80000000;
            }
            break;

        default:
            i = 0x80000000;
            break;
        }
        if (i == 0x80000000)
        {
            return null;
        }
        _mth029F();
        View view;
        if (i == -1)
        {
            view = _mth02BE(con);
        } else
        {
            view = _mth1FBE(con);
        }
        if (view == null)
        {
            return null;
        }
        _mth029F();
        _mth02CA(i, (int)((float)bN._mth1D16() * 0.33F), false, con);
        bM.cj = 0x80000000;
        bM.ce = false;
        _mth02CA(_pcls1fbe, bM, con, true);
        if (i == -1)
        {
            _pcls1fbe = _mth02B0();
        } else
        {
            _pcls1fbe = _mth03AA();
        }
        if (_pcls1fbe == view || !_pcls1fbe.isFocusable())
        {
            return null;
        } else
        {
            return _pcls1fbe;
        }
    }

    public final boolean _mth0407()
    {
        return bV == null && bO == bR;
    }

    public final int _mth141D(RecyclerView.con con)
    {
        return _mth037A(con);
    }

    public final View _mth14BD(int i)
    {
        int j;
        if (super.dC != null)
        {
            _cls0690 _lcls0690 = super.dC;
            j = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        } else
        {
            j = 0;
        }
        if (j == 0)
        {
            return null;
        }
        Object obj;
        if (super.dC != null)
        {
            obj = super.dC;
            int l = ((_cls0690) (obj)).FB1D(0);
            obj = ((_cls0690) (obj)).aF.getChildAt(l);
        } else
        {
            obj = null;
        }
        int i1 = i - ((RecyclerView._cls02BC)((View) (obj)).getLayoutParams()).eJ.getLayoutPosition();
        if (i1 >= 0 && i1 < j)
        {
            Object obj1;
            if (super.dC != null)
            {
                obj1 = super.dC;
                int k = ((_cls0690) (obj1)).FB1D(i1);
                obj1 = ((_cls0690) (obj1)).aF.getChildAt(k);
            } else
            {
                obj1 = null;
            }
            if (((RecyclerView._cls02BC)((View) (obj1)).getLayoutParams()).eJ.getLayoutPosition() == i)
            {
                return ((View) (obj1));
            }
        }
        return super._mth14BD(i);
    }

    public final void _mth1507(int i)
    {
        bT = i;
        bU = 0x80000000;
        if (bV != null)
        {
            bV.co = -1;
        }
        if (super.eH != null)
        {
            super.eH.requestLayout();
        }
    }

    public final void _mth1D4E(boolean flag)
    {
        if (bV == null)
        {
            super._mth1FBE(null);
        }
        if (bR)
        {
            return;
        }
        bR = true;
        if (super.eH != null)
        {
            super.eH.requestLayout();
        }
    }

    public final void _mth1FBE(String s)
    {
        if (bV == null)
        {
            super._mth1FBE(s);
        }
    }
}
