// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;

// Referenced classes of package o:
//            _cls2174, _cls0690

final class _cls30A3 extends _cls2174
{

    _cls30A3(android.support.v7.widget.RecyclerView._cls02BB _pcls02bb)
    {
        super(_pcls02bb, (byte)0);
    }

    public final int getEnd()
    {
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        if (_lcls02bb.eH != null)
        {
            return _lcls02bb.eH.getWidth();
        } else
        {
            return 0;
        }
    }

    public final int getEndPadding()
    {
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        if (_lcls02bb.eH != null)
        {
            return _lcls02bb.eH.getPaddingRight();
        } else
        {
            return 0;
        }
    }

    public final int _mth1421(View view)
    {
        android.support.v7.widget.RecyclerView._cls02BC _lcls02bc = (android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams();
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        return view.getLeft() - android.support.v7.widget.RecyclerView._cls02BB._mth0131(view) - _lcls02bc.leftMargin;
    }

    public final int _mth142A(View view)
    {
        android.support.v7.widget.RecyclerView._cls02BC _lcls02bc = (android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams();
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        return view.getRight() + android.support.v7.widget.RecyclerView._cls02BB._mth01C3(view) + _lcls02bc.rightMargin;
    }

    public final int _mth14BD(View view)
    {
        android.support.v7.widget.RecyclerView._cls02BC _lcls02bc = (android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams();
        return android.support.v7.widget.RecyclerView._cls02BB._mth1D40(view) + _lcls02bc.leftMargin + _lcls02bc.rightMargin;
    }

    public final int _mth14D1()
    {
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        if (_lcls02bb.eH != null)
        {
            return _lcls02bb.eH.getPaddingLeft();
        } else
        {
            return 0;
        }
    }

    public final int _mth1506()
    {
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        int i;
        if (_lcls02bb.eH != null)
        {
            i = _lcls02bb.eH.getWidth();
        } else
        {
            i = 0;
        }
        _lcls02bb = du;
        int j;
        if (_lcls02bb.eH != null)
        {
            j = _lcls02bb.eH.getPaddingRight();
        } else
        {
            j = 0;
        }
        return i - j;
    }

    public final int _mth1507(View view)
    {
        android.support.v7.widget.RecyclerView._cls02BC _lcls02bc = (android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams();
        return android.support.v7.widget.RecyclerView._cls02BB._mth1D4B(view) + _lcls02bc.topMargin + _lcls02bc.bottomMargin;
    }

    public final void _mth1508(int i)
    {
        Object obj = du;
        if (((android.support.v7.widget.RecyclerView._cls02BB) (obj)).eH != null)
        {
            obj = ((android.support.v7.widget.RecyclerView._cls02BB) (obj)).eH;
            _cls0690 _lcls0690 = ((RecyclerView) (obj)).dC;
            int k = _lcls0690.aF.getChildCount();
            int l = _lcls0690.aH.size();
            for (int j = 0; j < k - l; j++)
            {
                _cls0690 _lcls0690_1 = ((RecyclerView) (obj)).dC;
                int i1 = _lcls0690_1.FB1D(j);
                _lcls0690_1.aF.getChildAt(i1).offsetLeftAndRight(i);
            }

        }
    }

    public final int _mth1D16()
    {
        android.support.v7.widget.RecyclerView._cls02BB _lcls02bb = du;
        int i;
        if (_lcls02bb.eH != null)
        {
            i = _lcls02bb.eH.getWidth();
        } else
        {
            i = 0;
        }
        _lcls02bb = du;
        int j;
        if (_lcls02bb.eH != null)
        {
            j = _lcls02bb.eH.getPaddingLeft();
        } else
        {
            j = 0;
        }
        _lcls02bb = du;
        int k;
        if (_lcls02bb.eH != null)
        {
            k = _lcls02bb.eH.getPaddingRight();
        } else
        {
            k = 0;
        }
        return i - j - k;
    }
}
