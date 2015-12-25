// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import java.util.List;

// Referenced classes of package o:
//            FEE8, _cls0690, _cls2174, _cls1F31, 
//            _cls0EC0

public class _cls1FD0
    implements FEE8
{

    private _cls1F31 _fld30A4;

    _cls1FD0()
    {
    }

    _cls1FD0(_cls1F31 _pcls1f31)
    {
        _fld30A4 = _pcls1f31;
        super();
    }

    public static int _mth02CA(android.support.v7.widget.RecyclerView.con con, _cls2174 _pcls2174, View view, View view1, LinearLayoutManager linearlayoutmanager, boolean flag)
    {
label0:
        {
            int i;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC != null)
            {
                linearlayoutmanager = ((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC;
                i = ((_cls0690) (linearlayoutmanager)).aF.getChildCount() - ((_cls0690) (linearlayoutmanager)).aH.size();
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                int j;
                if (con.fr)
                {
                    j = con.fo - con.fp;
                } else
                {
                    j = con.fn;
                }
                if (j != 0 && view != null && view1 != null)
                {
                    break label0;
                }
            }
            return 0;
        }
        if (!flag)
        {
            return Math.abs(android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view) - android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view1)) + 1;
        } else
        {
            int k = _pcls2174._mth142A(view1);
            int l = _pcls2174._mth1421(view);
            return Math.min(_pcls2174._mth1D16(), k - l);
        }
    }

    public static int _mth02CA(android.support.v7.widget.RecyclerView.con con, _cls2174 _pcls2174, View view, View view1, LinearLayoutManager linearlayoutmanager, boolean flag, boolean flag1)
    {
label0:
        {
            int i;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC != null)
            {
                linearlayoutmanager = ((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC;
                i = ((_cls0690) (linearlayoutmanager)).aF.getChildCount() - ((_cls0690) (linearlayoutmanager)).aH.size();
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                int j;
                if (con.fr)
                {
                    j = con.fo - con.fp;
                } else
                {
                    j = con.fn;
                }
                if (j != 0 && view != null && view1 != null)
                {
                    break label0;
                }
            }
            return 0;
        }
        int k = Math.min(android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view), android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view1));
        int l = Math.max(android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view), android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view1));
        if (flag1)
        {
            if (con.fr)
            {
                k = con.fo - con.fp;
            } else
            {
                k = con.fn;
            }
            k = Math.max(0, k - l - 1);
        } else
        {
            k = Math.max(0, k);
        }
        if (!flag)
        {
            return k;
        } else
        {
            int i1 = Math.abs(_pcls2174._mth142A(view1) - _pcls2174._mth1421(view));
            int j1 = Math.abs(android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view) - android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view1));
            float f = (float)i1 / (float)(j1 + 1);
            return Math.round((float)k * f + (float)(_pcls2174._mth14D1() - _pcls2174._mth1421(view)));
        }
    }

    public static int _mth02CB(android.support.v7.widget.RecyclerView.con con, _cls2174 _pcls2174, View view, View view1, LinearLayoutManager linearlayoutmanager, boolean flag)
    {
label0:
        {
            int i;
            if (((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC != null)
            {
                linearlayoutmanager = ((android.support.v7.widget.RecyclerView._cls02BB) (linearlayoutmanager)).dC;
                i = ((_cls0690) (linearlayoutmanager)).aF.getChildCount() - ((_cls0690) (linearlayoutmanager)).aH.size();
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                int j;
                if (con.fr)
                {
                    j = con.fo - con.fp;
                } else
                {
                    j = con.fn;
                }
                if (j != 0 && view != null && view1 != null)
                {
                    break label0;
                }
            }
            return 0;
        }
        if (!flag)
        {
            if (con.fr)
            {
                return con.fo - con.fp;
            } else
            {
                return con.fn;
            }
        }
        int k = _pcls2174._mth142A(view1);
        int l = _pcls2174._mth1421(view);
        int i1 = Math.abs(android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view) - android.support.v7.widget.RecyclerView._cls02BB._mth1D38(view1));
        float f = (float)(k - l) / (float)(i1 + 1);
        if (con.fr)
        {
            k = con.fo - con.fp;
        } else
        {
            k = con.fn;
        }
        return (int)(f * (float)k);
    }

    public final void FF9F()
    {
        ((View)_cls1F31._mth02CE(_fld30A4).getParent()).invalidate();
    }
}
