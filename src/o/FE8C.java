// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class FE8C
    implements _cls0690._cls02CA
{

    private RecyclerView ex;

    public FE8C()
    {
    }

    public FE8C(RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
    }

    public final void addView(View view, int i)
    {
        ex.addView(view, i);
        RecyclerView._mth02CA(ex, view);
    }

    public final void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.support.v7.widget.RecyclerView._cls02CC _lcls02cc = RecyclerView._mth1508(view);
        if (_lcls02cc != null)
        {
            boolean flag;
            if ((_lcls02cc._fld0E20 & 0x100) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                boolean flag1;
                if ((_lcls02cc._fld0E20 & 0x80) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    throw new IllegalArgumentException((new StringBuilder("Called attach on a child which is not detached: ")).append(_lcls02cc).toString());
                }
            }
            _lcls02cc._fld0E20 = _lcls02cc._fld0E20 & 0xfffffeff;
        }
        RecyclerView._mth02CA(ex, view, i, layoutparams);
    }

    public final void detachViewFromParent(int i)
    {
        Object obj = ex.getChildAt(i);
        if (obj != null)
        {
            obj = RecyclerView._mth1508(((View) (obj)));
            if (obj != null)
            {
                boolean flag;
                if ((((android.support.v7.widget.RecyclerView._cls02CC) (obj))._fld0E20 & 0x100) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    boolean flag1;
                    if ((((android.support.v7.widget.RecyclerView._cls02CC) (obj))._fld0E20 & 0x80) != 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag1)
                    {
                        throw new IllegalArgumentException((new StringBuilder("called detach on an already detached child ")).append(obj).toString());
                    }
                }
                obj._fld0E20 = ((android.support.v7.widget.RecyclerView._cls02CC) (obj))._fld0E20 | 0x100;
            }
        }
        RecyclerView._mth02CA(ex, i);
    }

    public final View getChildAt(int i)
    {
        return ex.getChildAt(i);
    }

    public final int getChildCount()
    {
        return ex.getChildCount();
    }

    public final int indexOfChild(View view)
    {
        return ex.indexOfChild(view);
    }

    public final void removeAllViews()
    {
        int j = ex.getChildCount();
        for (int i = 0; i < j; i++)
        {
            RecyclerView._mth02CB(ex, ex.getChildAt(i));
        }

        ex.removeAllViews();
    }

    public final void removeViewAt(int i)
    {
        View view = ex.getChildAt(i);
        if (view != null)
        {
            RecyclerView._mth02CB(ex, view);
        }
        ex.removeViewAt(i);
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth1D63(View view)
    {
        return RecyclerView._mth1508(view);
    }
}
