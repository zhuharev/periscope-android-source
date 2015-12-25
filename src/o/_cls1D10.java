// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls01C0, _cls0445, _cls1E3B, _cls02E0, 
//            _cls03F3, _cls1D3A, _cls4E28, _cls05E8, 
//            _cls05D3, _cls013E, _cls0621, FE77, 
//            _cls05DA

public final class _cls1D10 extends _cls01C0
    implements FE77.if
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    _cls02CE _fld1542;
    Drawable _fld1543;
    boolean _fld1544;
    boolean _fld1546;
    boolean _fld1585;
    private int _fld15A9;
    private int _fld15AB;
    private int _fld15AD;
    public boolean _fld15B8;
    private int _fld15BA;
    private final SparseBooleanArray _fld15C0 = new SparseBooleanArray();
    private View _fld1625;
    _cls02CF _fld1D46;
    if _fld1E1E;
    _cls02CB _fld1E38;
    private _cls02CA _fld1E3C;
    final aux _fld1E7E = new aux((byte)0);
    int _fld1F59;

    public _cls1D10(Context context)
    {
        super(context, _cls0285.if.abc_action_menu_layout, _cls0285.if.abc_action_menu_item_layout);
    }

    static _cls02E0 _mth02CA(_cls1D10 _pcls1d10)
    {
        return _pcls1d10.FB30;
    }

    static _cls02E0 _mth02CB(_cls1D10 _pcls1d10)
    {
        return _pcls1d10.FB30;
    }

    static _cls05DA _mth02CE(_cls1D10 _pcls1d10)
    {
        return _pcls1d10._fld14D9;
    }

    static _cls02E0 _mth02CF(_cls1D10 _pcls1d10)
    {
        return _pcls1d10.FB30;
    }

    static _cls05DA _mth141D(_cls1D10 _pcls1d10)
    {
        return _pcls1d10._fld14D9;
    }

    public final boolean hideOverflowMenu()
    {
        if (_fld1E38 != null && _fld14D9 != null)
        {
            ((View)_fld14D9).removeCallbacks(_fld1E38);
            _fld1E38 = null;
            return true;
        }
        _cls02CF _lcls02cf = _fld1D46;
        if (_lcls02cf != null)
        {
            _lcls02cf.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean isOverflowMenuShowing()
    {
        if (_fld1D46 != null)
        {
            _cls02CF _lcls02cf = _fld1D46;
            boolean flag;
            if (((_cls0445) (_lcls02cf)).FF93 != null && ((_cls0445) (_lcls02cf)).FF93.isShowing())
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
        }
        return false;
    }

    public final boolean showOverflowMenu()
    {
label0:
        {
            boolean flag;
label1:
            {
                if (!_fld1546)
                {
                    break label0;
                }
                if (_fld1D46 != null)
                {
                    _cls02CF _lcls02cf = _fld1D46;
                    if (((_cls0445) (_lcls02cf)).FF93 != null && ((_cls0445) (_lcls02cf)).FF93.isShowing())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        flag = true;
                        break label1;
                    }
                }
                flag = false;
            }
            if (!flag && FB30 != null && _fld14D9 != null && _fld1E38 == null)
            {
                _cls02E0 _lcls02e0 = FB30;
                _lcls02e0._mth1550();
                if (!_lcls02e0._fld1F3E.isEmpty())
                {
                    _fld1E38 = new _cls02CB(new _cls02CF(mContext, FB30, _fld1542, true));
                    ((View)_fld14D9).post(_fld1E38);
                    super._mth02CA(null);
                    return true;
                }
            }
        }
        return false;
    }

    public final void _mth02BB(boolean flag)
    {
        if (flag)
        {
            super._mth02CA(null);
            return;
        } else
        {
            FB30.FE73(false);
            return;
        }
    }

    public final View _mth02CA(_cls03F3 _pcls03f3, View view, ViewGroup viewgroup)
    {
        View view1 = _pcls03f3.getActionView();
        if (view1 == null || _pcls03f3._mth1D58())
        {
            view1 = super._mth02CA(_pcls03f3, view, viewgroup);
        }
        byte byte0;
        if (_pcls03f3.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        _pcls03f3 = (_cls1D3A)viewgroup;
        view = view1.getLayoutParams();
        if (!_pcls03f3.checkLayoutParams(view))
        {
            view1.setLayoutParams(_pcls03f3._mth02CA(view));
        }
        return view1;
    }

    public final void _mth02CA(Context context, _cls02E0 _pcls02e0)
    {
        super._mth02CA(context, _pcls02e0);
        _pcls02e0 = context.getResources();
        context = new _cls4E28(context);
        if (!_fld1585)
        {
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                flag = true;
            } else
            if (!_cls05E8._mth02CB(ViewConfiguration.get(((_cls4E28) (context)).mContext)))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _fld1546 = flag;
        }
        _fld15A9 = ((_cls4E28) (context)).mContext.getResources().getDisplayMetrics().widthPixels / 2;
        _fld15AD = ((_cls4E28) (context)).mContext.getResources().getInteger(_cls05D3.abc_max_action_buttons);
        int i = _fld15A9;
        if (_fld1546)
        {
            if (_fld1542 == null)
            {
                _fld1542 = new _cls02CE(_fld14B1);
                if (_fld1544)
                {
                    _fld1542.setImageDrawable(_fld1543);
                    _fld1543 = null;
                    _fld1544 = false;
                }
                int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                _fld1542.measure(j, j);
            }
            i -= _fld1542.getMeasuredWidth();
        } else
        {
            _fld1542 = null;
        }
        _fld15AB = i;
        _fld15BA = (int)(_pcls02e0.getDisplayMetrics().density * 56F);
        _fld1625 = null;
    }

    public final void _mth02CA(_cls03F3 _pcls03f3, _cls05DA.if if1)
    {
        if1._mth02CA(_pcls03f3, 0);
        _pcls03f3 = (_cls1D3A)_fld14D9;
        if1 = (_cls013E)if1;
        if1.setItemInvoker(_pcls03f3);
        if (_fld1E3C == null)
        {
            _fld1E3C = new _cls02CA((byte)0);
        }
        if1.setPopupCallback(_fld1E3C);
    }

    public final void _mth02CA(_cls1D3A _pcls1d3a)
    {
        _fld14D9 = _pcls1d3a;
        _pcls1d3a.FB30 = FB30;
    }

    public final boolean _mth02CA(ViewGroup viewgroup, int i)
    {
        if (viewgroup.getChildAt(i) == _fld1542)
        {
            return false;
        } else
        {
            return super._mth02CA(viewgroup, i);
        }
    }

    public final boolean _mth02CA(_cls03F3 _pcls03f3)
    {
        return (_pcls03f3._fld0E20 & 0x20) == 32;
    }

    public final boolean _mth02CA(_cls0621 _pcls0621)
    {
        Object obj;
label0:
        {
            if (!_pcls0621.hasVisibleItems())
            {
                return false;
            }
            for (obj = _pcls0621; ((_cls0621) (obj))._fld0232 != FB30; obj = (_cls0621)((_cls0621) (obj))._fld0232) { }
            MenuItem menuitem = ((_cls0621) (obj)).getItem();
            ViewGroup viewgroup = (ViewGroup)_fld14D9;
            if (viewgroup != null)
            {
                int j = viewgroup.getChildCount();
                for (int i = 0; i < j; i++)
                {
                    obj = viewgroup.getChildAt(i);
                    if ((obj instanceof _cls05DA.if) && ((_cls05DA.if)obj).FEE7() == menuitem)
                    {
                        break label0;
                    }
                }

            }
            obj = null;
        }
        Object obj1 = obj;
        if (obj == null)
        {
            if (_fld1542 == null)
            {
                return false;
            }
            obj1 = _fld1542;
        }
        _fld1F59 = _pcls0621.getItem().getItemId();
        _fld1E1E = new if(mContext, _pcls0621);
        _fld1E1E.FF8A = ((View) (obj1));
        if (!_fld1E1E._mth1D64())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            super._mth02CA(_pcls0621);
            return true;
        }
    }

    public final _cls05DA _mth02CB(ViewGroup viewgroup)
    {
        viewgroup = super._mth02CB(viewgroup);
        ((_cls1D3A)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public final void _mth02CB(_cls02E0 _pcls02e0, boolean flag)
    {
        hideOverflowMenu();
        boolean flag2;
        if (_fld1E1E != null)
        {
            _fld1E1E.dismiss();
            boolean flag1 = true;
        } else
        {
            flag2 = false;
        }
        super._mth02CB(_pcls02e0, flag);
    }

    public final boolean _mth05F2()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int l;
        int k1;
        int j3;
        int k3;
        int l3;
        int i4;
label0:
        {
            arraylist = FB30._mth153E();
            l3 = arraylist.size();
            int i = _fld15AD;
            k3 = _fld15AB;
            i4 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)_fld14D9;
            k1 = 0;
            int i2 = 0;
            j3 = 0;
            boolean flag = false;
            for (int k = 0; k < l3;)
            {
                _cls03F3 _lcls03f3 = (_cls03F3)arraylist.get(k);
                boolean flag4;
                if ((_lcls03f3.FE95 & 2) == 2)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                if (flag4)
                {
                    k1++;
                } else
                {
                    boolean flag5;
                    if ((_lcls03f3.FE95 & 1) == 1)
                    {
                        flag5 = true;
                    } else
                    {
                        flag5 = false;
                    }
                    if (flag5)
                    {
                        i2++;
                    } else
                    {
                        flag = true;
                    }
                }
                int k2 = i;
                if (_fld15B8)
                {
                    k2 = i;
                    if (_lcls03f3.isActionViewExpanded())
                    {
                        k2 = 0;
                    }
                }
                k++;
                i = k2;
            }

            l = i;
            if (!_fld1546)
            {
                break label0;
            }
            if (!flag)
            {
                l = i;
                if (k1 + i2 <= i)
                {
                    break label0;
                }
            }
            l = i - 1;
        }
        l -= k1;
        SparseBooleanArray sparsebooleanarray = _fld15C0;
        sparsebooleanarray.clear();
        boolean flag1 = false;
        int j = j3;
        j3 = ((flag1) ? 1 : 0);
        int l1;
        for (int j2 = k3; j3 < l3; j2 = l1)
        {
            _cls03F3 _lcls03f3_1 = (_cls03F3)arraylist.get(j3);
            boolean flag2;
            if ((_lcls03f3_1.FE95 & 2) == 2)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                View view = _mth02CA(_lcls03f3_1, _fld1625, viewgroup);
                if (_fld1625 == null)
                {
                    _fld1625 = view;
                }
                view.measure(i4, i4);
                int l2 = view.getMeasuredWidth();
                l1 = j2 - l2;
                int i1 = j;
                if (j == 0)
                {
                    i1 = l2;
                }
                j = _lcls03f3_1.getGroupId();
                if (j != 0)
                {
                    sparsebooleanarray.put(j, true);
                }
                _lcls03f3_1._fld0E20 = _lcls03f3_1._fld0E20 | 0x20;
                j = i1;
            } else
            {
                boolean flag3;
                if ((_lcls03f3_1.FE95 & 1) == 1)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (flag3)
                {
                    int j4 = _lcls03f3_1.getGroupId();
                    boolean flag10 = sparsebooleanarray.get(j4);
                    boolean flag6;
                    if ((l > 0 || flag10) && j2 > 0)
                    {
                        flag6 = true;
                    } else
                    {
                        flag6 = false;
                    }
                    boolean flag9 = flag6;
                    l1 = j2;
                    int j1 = j;
                    boolean flag8 = flag9;
                    if (flag6)
                    {
                        View view1 = _mth02CA(_lcls03f3_1, _fld1625, viewgroup);
                        if (_fld1625 == null)
                        {
                            _fld1625 = view1;
                        }
                        view1.measure(i4, i4);
                        int i3 = view1.getMeasuredWidth();
                        l1 = j2 - i3;
                        j1 = j;
                        if (j == 0)
                        {
                            j1 = i3;
                        }
                        if (l1 + j1 > 0)
                        {
                            j = 1;
                        } else
                        {
                            j = 0;
                        }
                        flag8 = flag9 & j;
                    }
                    if (flag8 && j4 != 0)
                    {
                        sparsebooleanarray.put(j4, true);
                        j = l;
                    } else
                    {
                        j = l;
                        if (flag10)
                        {
                            sparsebooleanarray.put(j4, false);
                            j2 = 0;
                            do
                            {
                                j = l;
                                if (j2 >= j3)
                                {
                                    break;
                                }
                                _cls03F3 _lcls03f3_2 = (_cls03F3)arraylist.get(j2);
                                j = l;
                                if (_lcls03f3_2.getGroupId() == j4)
                                {
                                    boolean flag7;
                                    if ((_lcls03f3_2._fld0E20 & 0x20) == 32)
                                    {
                                        flag7 = true;
                                    } else
                                    {
                                        flag7 = false;
                                    }
                                    j = l;
                                    if (flag7)
                                    {
                                        j = l + 1;
                                    }
                                    _lcls03f3_2._fld0E20 = _lcls03f3_2._fld0E20 & 0xffffffdf;
                                }
                                j2++;
                                l = j;
                            } while (true);
                        }
                    }
                    l = j;
                    if (flag8)
                    {
                        l = j - 1;
                    }
                    if (flag8)
                    {
                        _lcls03f3_1._fld0E20 = _lcls03f3_1._fld0E20 | 0x20;
                        j = j1;
                    } else
                    {
                        _lcls03f3_1._fld0E20 = _lcls03f3_1._fld0E20 & 0xffffffdf;
                        j = j1;
                    }
                } else
                {
                    _lcls03f3_1._fld0E20 = _lcls03f3_1._fld0E20 & 0xffffffdf;
                    l1 = j2;
                }
            }
            j3++;
        }

        return true;
    }

    public final void _mth1427(boolean flag)
    {
        ((View)_fld14D9).getParent();
        super._mth1427(flag);
        ((View)_fld14D9).requestLayout();
        if (FB30 != null)
        {
            Object obj = FB30;
            ((_cls02E0) (obj))._mth1550();
            obj = ((_cls02E0) (obj))._fld1EF5;
            int k = ((ArrayList) (obj)).size();
            for (int i = 0; i < k; i++)
            {
                FE77 fe77 = ((_cls03F3)((ArrayList) (obj)).get(i)).FEA7;
                if (fe77 != null)
                {
                    fe77._mth02CA(this);
                }
            }

        }
        Object obj1;
        if (FB30 != null)
        {
            obj1 = FB30;
            ((_cls02E0) (obj1))._mth1550();
            obj1 = ((_cls02E0) (obj1))._fld1F3E;
        } else
        {
            obj1 = null;
        }
        boolean flag1 = false;
        int j = ((flag1) ? 1 : 0);
        if (_fld1546)
        {
            j = ((flag1) ? 1 : 0);
            if (obj1 != null)
            {
                j = ((ArrayList) (obj1)).size();
                if (j == 1)
                {
                    if (!((_cls03F3)((ArrayList) (obj1)).get(0)).isActionViewExpanded())
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                } else
                if (j > 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            }
        }
        if (j != 0)
        {
            if (_fld1542 == null)
            {
                _fld1542 = new _cls02CE(_fld14B1);
            }
            Object obj2 = (ViewGroup)_fld1542.getParent();
            if (obj2 != _fld14D9)
            {
                if (obj2 != null)
                {
                    ((ViewGroup) (obj2)).removeView(_fld1542);
                }
                obj2 = (_cls1D3A)_fld14D9;
                ((_cls1D3A) (obj2)).addView(_fld1542, ((_cls1D3A) (obj2)).FE70());
            }
        } else
        if (_fld1542 != null && _fld1542.getParent() == _fld14D9)
        {
            ((ViewGroup)_fld14D9).removeView(_fld1542);
        }
        ((_cls1D3A)_fld14D9).setOverflowReserved(_fld1546);
    }

    public final void FBE9()
    {
        _fld15AD = mContext.getResources().getInteger(_cls05D3.abc_max_action_buttons);
        if (FB30 != null)
        {
            FB30.FF9E(true);
        }
    }
}
