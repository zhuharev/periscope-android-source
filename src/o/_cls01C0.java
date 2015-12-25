// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls0491, _cls05DA, _cls02E0, _cls03F3, 
//            FE70, _cls0621

public abstract class _cls01C0
    implements _cls0491
{

    public Context mContext;
    private LayoutInflater _fld04AE;
    public Context _fld14B1;
    private LayoutInflater _fld14B4;
    public _cls0491.if _fld14B5;
    private int _fld14B8;
    private int _fld14B9;
    public _cls05DA _fld14D9;
    public _cls02E0 FB30;
    public int FE7C;

    public _cls01C0(Context context, int i, int j)
    {
        _fld14B1 = context;
        _fld14B4 = LayoutInflater.from(context);
        _fld14B8 = i;
        _fld14B9 = j;
    }

    public View _mth02CA(_cls03F3 _pcls03f3, View view, ViewGroup viewgroup)
    {
        if (view instanceof _cls05DA.if)
        {
            view = (_cls05DA.if)view;
        } else
        {
            view = (_cls05DA.if)_fld14B4.inflate(_fld14B9, viewgroup, false);
        }
        _mth02CA(_pcls03f3, ((_cls05DA.if) (view)));
        return (View)view;
    }

    public void _mth02CA(Context context, _cls02E0 _pcls02e0)
    {
        mContext = context;
        _fld04AE = LayoutInflater.from(mContext);
        FB30 = _pcls02e0;
    }

    public abstract void _mth02CA(_cls03F3 _pcls03f3, _cls05DA.if if1);

    public boolean _mth02CA(ViewGroup viewgroup, int i)
    {
        viewgroup.removeViewAt(i);
        return true;
    }

    public boolean _mth02CA(_cls03F3 _pcls03f3)
    {
        return true;
    }

    public boolean _mth02CA(_cls0621 _pcls0621)
    {
        if (_fld14B5 != null)
        {
            return _fld14B5._mth02CE(_pcls0621);
        } else
        {
            return false;
        }
    }

    public _cls05DA _mth02CB(ViewGroup viewgroup)
    {
        if (_fld14D9 == null)
        {
            _fld14D9 = (_cls05DA)_fld14B4.inflate(_fld14B8, viewgroup, false);
            _fld14D9._mth141D(FB30);
            _mth1427(true);
        }
        return _fld14D9;
    }

    public void _mth02CB(_cls02E0 _pcls02e0, boolean flag)
    {
        if (_fld14B5 != null)
        {
            _fld14B5._mth02CB(_pcls02e0, flag);
        }
    }

    public final boolean _mth02CB(_cls03F3 _pcls03f3)
    {
        return false;
    }

    public final boolean _mth02CE(_cls03F3 _pcls03f3)
    {
        return false;
    }

    public boolean _mth05F2()
    {
        return false;
    }

    public void _mth1427(boolean flag)
    {
        ViewGroup viewgroup1 = (ViewGroup)_fld14D9;
        if (viewgroup1 == null)
        {
            return;
        }
        int j = 0;
        int i = 0;
        if (FB30 != null)
        {
            FB30._mth1550();
            ArrayList arraylist = FB30._mth153E();
            int l = arraylist.size();
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                _cls03F3 _lcls03f3_1 = (_cls03F3)arraylist.get(k);
                j = i;
                if (_mth02CA(_lcls03f3_1))
                {
                    View view = viewgroup1.getChildAt(i);
                    _cls03F3 _lcls03f3;
                    if (view instanceof _cls05DA.if)
                    {
                        _lcls03f3 = ((_cls05DA.if)view).FEE7();
                    } else
                    {
                        _lcls03f3 = null;
                    }
                    View view1 = _mth02CA(_lcls03f3_1, view, viewgroup1);
                    if (_lcls03f3_1 != _lcls03f3)
                    {
                        view1.setPressed(false);
                        FE70._mth0559(view1);
                    }
                    if (view1 != view)
                    {
                        ViewGroup viewgroup = (ViewGroup)view1.getParent();
                        if (viewgroup != null)
                        {
                            viewgroup.removeView(view1);
                        }
                        ((ViewGroup)_fld14D9).addView(view1, i);
                    }
                    j = i + 1;
                }
                k++;
                i = j;
            } while (true);
        }
        do
        {
            if (j >= viewgroup1.getChildCount())
            {
                break;
            }
            if (!_mth02CA(viewgroup1, j))
            {
                j++;
            }
        } while (true);
    }
}
