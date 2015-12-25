// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.02B8;
import o.0690;
import o.FB1F;
import o.FE70;
import o.FEE3;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public final class eU
{

    public static final int eX = 0x7f010000;
    final ArrayList eQ;
    ArrayList eR;
    public final ArrayList eS;
    final List eT;
    int eU;
    eS eV;
    eS eW;
    final RecyclerView ex;

    private void _mth02B2(View view)
    {
        if (RecyclerView._mth02D1(ex) != null && RecyclerView._mth02D1(ex).isEnabled())
        {
            if (FE70._mth02BE(view) == 0)
            {
                FE70._mth02CE(view, 1);
            }
            if (!FE70._mth02BD(view))
            {
                FE70._mth02CA(view, RecyclerView._mth0640(ex).fI);
            }
        }
    }

    private boolean _mth02BE(ex ex1)
    {
        boolean flag;
        if ((ex1._fld0E20 & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return true;
        }
        if (ex1.bX < 0 || ex1.bX >= RecyclerView._mth02BB(ex).tItemCount())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid view holder adapter position")).append(ex1).toString());
        }
        if (!ex.ek.r && RecyclerView._mth02BB(ex).tItemViewType(ex1.bX) != ex1.getItemViewType())
        {
            return false;
        }
        if (RecyclerView._mth02BB(ex).)
        {
            return ex1.getItemId() == RecyclerView._mth02BB(ex).tItemId(ex1.bX);
        } else
        {
            return true;
        }
    }

    private void _mth02BF(bX bx)
    {
        if (bx.fy instanceof ViewGroup)
        {
            _mth02CB((ViewGroup)bx.fy, false);
        }
    }

    private fy _mth02CA(long l, int i, boolean flag)
    {
        for (int j = eQ.size() - 1; j >= 0; j--)
        {
            fy fy = (eQ)eQ.get(j);
            if (fy.getItemId() != l)
            {
                continue;
            }
            boolean flag1;
            if ((fy._fld0E20 & 0x20) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                continue;
            }
            if (i == fy.getItemViewType())
            {
                fy._fld0E20 = fy._fld0E20 | 0x20;
                if ((fy._fld0E20 & 8) != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0 && !ex.ek.r)
                {
                    fy._fld0E20 = fy._fld0E20 & 0xfffffff1 | 2;
                }
                return fy;
            }
            if (!flag)
            {
                eQ.remove(j);
                ex.removeDetachedView(fy.fy, false);
                _mth02E3(fy.fy);
            }
        }

        for (int k = eS.size() - 1; k >= 0; k--)
        {
            fy fy1 = (eS)eS.get(k);
            if (fy1.getItemId() != l)
            {
                continue;
            }
            if (i == fy1.getItemViewType())
            {
                if (!flag)
                {
                    eS.remove(k);
                }
                return fy1;
            }
            if (!flag)
            {
                _mth1D38(k);
            }
        }

        return null;
    }

    private _cls1D38 _mth02CB(int i, int j, boolean flag)
    {
label0:
        {
            View view;
label1:
            {
                int k = eQ.size();
                for (j = 0; j < k; j++)
                {
                    _cls1D38 _lcls1d38 = (eQ)eQ.get(j);
                    boolean flag1;
                    if ((_lcls1d38._fld0E20 & 0x20) != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1 || _lcls1d38.getLayoutPosition() != i)
                    {
                        continue;
                    }
                    if ((_lcls1d38._fld0E20 & 4) != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        continue;
                    }
                    if (!ex.ek.r)
                    {
                        boolean flag2;
                        if ((_lcls1d38._fld0E20 & 8) != 0)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        if (flag2)
                        {
                            continue;
                        }
                    }
                    _lcls1d38._fld0E20 = _lcls1d38._fld0E20 | 0x20;
                    return _lcls1d38;
                }

                if (flag)
                {
                    break label0;
                }
                _cls0690 _lcls0690 = ex.dC;
                k = _lcls0690.aH.size();
                for (j = 0; j < k; j++)
                {
                    view = (View)_lcls0690.aH.get(j);
                    _cls1D38 _lcls1d38_2 = _lcls0690.aF.dC(view);
                    if (_lcls1d38_2.getLayoutPosition() != i)
                    {
                        continue;
                    }
                    boolean flag3;
                    if ((_lcls1d38_2._fld0E20 & 4) != 0)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (!flag3)
                    {
                        break label1;
                    }
                }

                view = null;
            }
            if (view != null)
            {
                ex.ea._mth02CE(ex._mth1D63(view));
            }
        }
        int l = eS.size();
        for (j = 0; j < l; j++)
        {
            _cls1D38 _lcls1d38_1 = (eS)eS.get(j);
            boolean flag4;
            if ((_lcls1d38_1._fld0E20 & 4) != 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (!flag4 && _lcls1d38_1.getLayoutPosition() == i)
            {
                if (!flag)
                {
                    eS.remove(j);
                }
                return _lcls1d38_1;
            }
        }

        return null;
    }

    private void _mth02CB(ViewGroup viewgroup, boolean flag)
    {
        for (int i = viewgroup.getChildCount() - 1; i >= 0; i--)
        {
            View view = viewgroup.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                _mth02CB((ViewGroup)view, true);
            }
        }

        if (!flag)
        {
            return;
        }
        if (viewgroup.getVisibility() == 4)
        {
            viewgroup.setVisibility(0);
            viewgroup.setVisibility(4);
            return;
        } else
        {
            int j = viewgroup.getVisibility();
            viewgroup.setVisibility(4);
            viewgroup.setVisibility(j);
            return;
        }
    }

    private _cls02CB _mth1D40(int i)
    {
        int k;
label0:
        {
            if (eR != null)
            {
                k = eR.size();
                if (k != 0)
                {
                    break label0;
                }
            }
            return null;
        }
        for (int j = 0; j < k; j++)
        {
            _cls02CB _lcls02cb = (eR)eR.get(j);
            boolean flag1;
            if ((_lcls02cb._fld0E20 & 0x20) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1 && _lcls02cb.getLayoutPosition() == i)
            {
                _lcls02cb._fld0E20 = _lcls02cb._fld0E20 | 0x20;
                return _lcls02cb;
            }
        }

        if (RecyclerView._mth02BB(ex).)
        {
            i = ex.dB._mth02BF(i, 0);
            if (i > 0 && i < RecyclerView._mth02BB(ex).tItemCount())
            {
                long l = RecyclerView._mth02BB(ex).tItemId(i);
                for (i = 0; i < k; i++)
                {
                    _cls02CB _lcls02cb1 = (tItemId)eR.get(i);
                    boolean flag;
                    if ((_lcls02cb1._fld0E20 & 0x20) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag && _lcls02cb1.getItemId() == l)
                    {
                        _lcls02cb1._fld0E20 = _lcls02cb1._fld0E20 | 0x20;
                        return _lcls02cb1;
                    }
                }

            }
        }
        return null;
    }

    public final View _mth02BB(int i, boolean flag)
    {
label0:
        {
            if (i >= 0)
            {
                _cls0E20 _lcls0e20 = ex.ek;
                int j;
                if (_lcls0e20.r)
                {
                    j = _lcls0e20.o - _lcls0e20.p;
                } else
                {
                    j = _lcls0e20.n;
                }
                if (i < j)
                {
                    break label0;
                }
            }
            StringBuilder stringbuilder = (new StringBuilder("Invalid item position ")).append(i).append("(").append(i).append("). Item count:");
            _cls0E20 _lcls0e20_2 = ex.ek;
            if (_lcls0e20_2.r)
            {
                i = _lcls0e20_2.o - _lcls0e20_2.p;
            } else
            {
                i = _lcls0e20_2.n;
            }
            throw new IndexOutOfBoundsException(stringbuilder.append(i).toString());
        }
        Object obj2;
        boolean flag2;
        int l;
label1:
        {
            int k = 0;
            obj2 = null;
            if (ex.ek.r)
            {
                obj2 = _mth1D40(i);
                if (obj2 != null)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
            }
            Object obj = obj2;
            flag2 = k;
            if (obj2 == null)
            {
                obj2 = _mth02CB(i, -1, false);
                obj = obj2;
                flag2 = k;
                if (obj2 != null)
                {
                    if (!_mth02BE(((_cls02BE) (obj2))))
                    {
                        obj2._fld0E20 = ((_cls0E20) (obj2))._fld0E20 | 4;
                        if (((_cls0E20) (obj2)).fG != null)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        if (flag2)
                        {
                            ex.removeDetachedView(((eDetachedView) (obj2)).fy, false);
                            ((fy) (obj2)).fG._mth02C9(((_cls02C9) (obj2)));
                        } else
                        {
                            if ((((_cls02C9) (obj2))._fld0E20 & 0x20) != 0)
                            {
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                            if (flag2)
                            {
                                obj2._fld0E20 = ((_cls0E20) (obj2))._fld0E20 & 0xffffffdf;
                            }
                        }
                        _mth02C8(((_cls02C8) (obj2)));
                        obj = null;
                        flag2 = k;
                    } else
                    {
                        flag2 = true;
                        obj = obj2;
                    }
                }
            }
            obj2 = obj;
            l = ((flag2) ? 1 : 0);
            if (obj == null)
            {
                l = ex.dB._mth144A(i);
                if (l < 0 || l >= RecyclerView._mth02BB(ex).tItemCount())
                {
                    obj = (new StringBuilder("Inconsistency detected. Invalid item position ")).append(i).append("(offset:").append(l).append(").state:");
                    obj2 = ex.ek;
                    if (((ex) (obj2)).r)
                    {
                        i = ((r) (obj2)).o - ((o) (obj2)).p;
                    } else
                    {
                        i = ((p) (obj2)).n;
                    }
                    throw new IndexOutOfBoundsException(((StringBuilder) (obj)).append(i).toString());
                }
                int i1 = RecyclerView._mth02BB(ex).tItemViewType(l);
                k = ((flag2) ? 1 : 0);
                if (RecyclerView._mth02BB(ex).)
                {
                    obj2 = _mth02CA(RecyclerView._mth02BB(ex).tItemId(l), i1, false);
                    obj = obj2;
                    k = ((flag2) ? 1 : 0);
                    if (obj2 != null)
                    {
                        obj2.bX = l;
                        k = 1;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                if (obj == null)
                {
                    obj2 = obj;
                    if (eW != null)
                    {
                        View view = eW.FB36();
                        obj2 = obj;
                        if (view != null)
                        {
                            obj2 = ex._mth1D63(view);
                            if (obj2 == null)
                            {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            }
                            if ((((ex) (obj2))._fld0E20 & 0x80) != 0)
                            {
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                            if (flag2)
                            {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                }
                obj = obj2;
                if (obj2 == null)
                {
                    if (eV == null)
                    {
                        eV = new <init>();
                    }
                    obj2 = eV._mth1D36(i1);
                    obj = obj2;
                    if (obj2 != null)
                    {
                        ((_cls1D36) (obj2)).resetInternal();
                        obj = obj2;
                        if (RecyclerView._mth309D())
                        {
                            _mth02BF(((_cls02BF) (obj2)));
                            obj = obj2;
                        }
                    }
                }
                obj2 = obj;
                l = k;
                if (obj == null)
                {
                    _cls0E20 _lcls0e20_1 = RecyclerView._mth02BB(ex);
                    obj2 = ex;
                    _cls02B8.beginSection("RV CreateView");
                    obj2 = _lcls0e20_1.CB(((ViewGroup) (obj2)), i1);
                    obj2.fB = i1;
                    _cls02B8.endSection();
                    l = k;
                }
            }
            flag2 = false;
            if (ex.ek.r)
            {
                if ((((r) (obj2))._fld0E20 & 1) != 0)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                if (k)
                {
                    obj2.fC = i;
                    break label1;
                }
            }
            if ((((fC) (obj2))._fld0E20 & 1) != 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k)
            {
                boolean flag1;
                if ((((_cls0E20) (obj2))._fld0E20 & 2) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    if ((((_cls0E20) (obj2))._fld0E20 & 4) != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag1)
                    {
                        break label1;
                    }
                }
            }
            flag1 = ex.dB._mth144A(i);
            obj2.fH = ex;
            RecyclerView._mth02BB(ex).CB(((CB) (obj2)), flag1);
            _mth02B2(((_cls02B2) (obj2)).fy);
            flag1 = true;
            flag2 = flag1;
            if (ex.ek.r)
            {
                obj2.fC = i;
                flag2 = flag1;
            }
        }
        Object obj1 = ((fC) (obj2)).fy.getLayoutParams();
        if (obj1 == null)
        {
            obj1 = (fy)ex.generateDefaultLayoutParams();
            ((ateDefaultLayoutParams) (obj2)).fy.setLayoutParams(((android.view.rams) (obj1)));
        } else
        if (!ex.checkLayoutParams(((android.view.rams) (obj1))))
        {
            obj1 = (LayoutParams)ex.generateLayoutParams(((android.view.rams) (obj1)));
            ((ateLayoutParams) (obj2)).fy.setLayoutParams(((android.view.rams) (obj1)));
        } else
        {
            obj1 = (fy)obj1;
        }
        obj1.eJ = ((eJ) (obj2));
        if (l != 0 && flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1.eM = flag;
        return ((eM) (obj2)).fy;
    }

    final void _mth02C8(fy fy)
    {
        boolean flag;
        if (fy.fG != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || fy.fy.getParent() != null)
        {
            StringBuilder stringbuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            boolean flag6;
            if (fy.fG != null)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            stringbuilder = stringbuilder.append(flag6).append(" isAttached:");
            if (fy.fy.getParent() != null)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            throw new IllegalArgumentException(stringbuilder.append(flag6).toString());
        }
        if ((fy._fld0E20 & 0x100) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw new IllegalArgumentException((new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ")).append(fy).toString());
        }
        if ((fy._fld0E20 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        }
        boolean flag2;
        if ((fy._fld0E20 & 0x10) == 0 && FE70._mth037A(fy.fy))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (RecyclerView._mth02BB(ex) != null && flag2)
        {
            RecyclerView._mth02BB(ex);
        }
        int i = 0;
        boolean flag5 = false;
        boolean flag4 = false;
        if ((fy._fld0E20 & 0x10) == 0 && !FE70._mth037A(fy.fy))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag3 = flag4;
        if (flag)
        {
            if ((fy._fld0E20 & 4) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            boolean flag1 = flag5;
            if (i == 0)
            {
                if ((fy._fld0E20 & 8) != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                flag1 = flag5;
                if (i == 0)
                {
                    if ((fy._fld0E20 & 0x40) != 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    flag1 = flag5;
                    if (i == 0)
                    {
                        i = eS.size();
                        if (i == eU && i > 0)
                        {
                            _mth1D38(0);
                        }
                        flag1 = flag5;
                        if (i < eU)
                        {
                            eS.add(fy);
                            flag1 = true;
                        }
                    }
                }
            }
            i = ((flag1) ? 1 : 0);
            flag3 = flag4;
            if (!flag1)
            {
                FE70._mth02CA(fy.fy, null);
                _mth02CC(fy);
                fy.fH = null;
                if (eV == null)
                {
                    eV = new <init>();
                }
                eV._mth1FBE(fy);
                flag3 = true;
                i = ((flag1) ? 1 : 0);
            }
        }
        ex.ek._mth2CD(fy);
        if (i == 0 && !flag3 && flag2)
        {
            fy.fH = null;
        }
    }

    final void _mth02C9(fH fh)
    {
        boolean flag;
        if ((fh._fld0E20 & 0x40) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || !RecyclerView._mth02BD(ex) || eR == null)
        {
            eQ.remove(fh);
        } else
        {
            eR.remove(fh);
        }
        fh.fG = null;
        fh._fld0E20 = fh._fld0E20 & 0xffffffdf;
    }

    final void _mth02CC(_cls0E20 _pcls0e20)
    {
        if (RecyclerView._mth1427(ex) != null)
        {
            RecyclerView._mth1427(ex);
        }
        if (RecyclerView._mth02BB(ex) != null)
        {
            RecyclerView._mth02BB(ex);
        }
        ex.ek._mth2CD(_pcls0e20);
    }

    public final void _mth02D0(View view)
    {
        _cls2CD _lcls2cd = RecyclerView._mth1508(view);
        boolean flag;
        if ((_lcls2cd._fld0E20 & 0x100) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ex.removeDetachedView(view, false);
        }
        if (_lcls2cd.fG != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            _lcls2cd.fG._mth02C9(_lcls2cd);
        } else
        {
            boolean flag1;
            if ((_lcls2cd._fld0E20 & 0x20) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                _lcls2cd._fld0E20 = _lcls2cd._fld0E20 & 0xffffffdf;
            }
        }
        _mth02C8(_lcls2cd);
    }

    final void _mth02E3(View view)
    {
        view = RecyclerView._mth1508(view);
        view.fG = null;
        view._fld0E20 = ((_cls0E20) (view))._fld0E20 & 0xffffffdf;
        _mth02C8(view);
    }

    final void _mth1D38(int i)
    {
        _cls02C8 _lcls02c8 = (_cls02C8)eS.get(i);
        FE70._mth02CA(_lcls02c8.fy, null);
        _mth02CC(_lcls02c8);
        _lcls02c8.fH = null;
        if (eV == null)
        {
            eV = new <init>();
        }
        eV._mth1FBE(_lcls02c8);
        eS.remove(i);
    }

    final void _mth1D61()
    {
        int j = eS.size();
        for (int i = 0; i < j; i++)
        {
            eS es = (eS)((eS)eS.get(i)).fy.getLayoutParams();
            if (es != null)
            {
                es.eL = true;
            }
        }

    }

    final void _mth1ECA()
    {
        if (RecyclerView._mth02BB(ex) != null && RecyclerView._mth02BB(ex).)
        {
            int j = eS.size();
            for (int i = 0; i < j; i++)
            {
                eL el = (eS)eS.get(i);
                if (el != null)
                {
                    el._fld0E20 = el._fld0E20 | 6;
                }
            }

            return;
        } else
        {
            _mth4E00();
            return;
        }
    }

    final void _mth4E00()
    {
        for (int i = eS.size() - 1; i >= 0; i--)
        {
            _cls4E00 _lcls4e00 = (eS)eS.get(i);
            FE70._mth02CA(_lcls4e00.fy, null);
            _mth02CC(_lcls4e00);
            _lcls4e00.fH = null;
            if (eV == null)
            {
                eV = new <init>();
            }
            eV._mth1FBE(_lcls4e00);
            eS.remove(i);
        }

        eS.clear();
    }

    public ger()
    {
    }

    public ger(RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
        eQ = new ArrayList();
        eR = null;
        eS = new ArrayList();
        eT = Collections.unmodifiableList(eQ);
        eU = 2;
    }
}
