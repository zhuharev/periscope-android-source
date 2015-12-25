// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

// Referenced classes of package o:
//            _cls4E28, _cls1D60, _cls1541, _cls0295, 
//            FF8D, _cls1646

public final class FF8C extends HorizontalScrollView
    implements android.widget.AdapterView.OnItemSelectedListener
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    FF8D fR;
    private _cls02CA fS;
    private _cls1D60 fT;
    private Spinner fU;
    private boolean fV;
    int fW;
    private int fX;
    private int fY;
    private _cls02CE fZ;
    private int _fld03DD;
    protected _cls1646 _fld03EE;

    public FF8C(Context context)
    {
        super(context);
        fZ = new _cls02CE();
        setHorizontalScrollBarEnabled(false);
        context = new _cls4E28(context);
        setContentHeight(context._mth1D67());
        fX = ((_cls4E28) (context)).mContext.getResources().getDimensionPixelSize(_cls1ECA.if.abc_action_bar_stacked_tab_max_width);
        context = new _cls1D60(getContext(), null, _cls1541.actionBarTabBarStyle);
        context.setMeasureWithLargestChildEnabled(true);
        context.setGravity(17);
        context.setLayoutParams(new _cls1D60.if(-2, -1));
        fT = context;
        addView(fT, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    static _cls02CB _mth02CA(FF8C ff8c, _cls019A._cls02CA _pcls02ca, boolean flag)
    {
        _pcls02ca = new _cls02CB(ff8c, ff8c.getContext(), _pcls02ca, true);
        _pcls02ca.setBackgroundDrawable(null);
        _pcls02ca.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, ff8c._fld03DD));
        return _pcls02ca;
    }

    static _cls1D60 _mth02CB(FF8C ff8c)
    {
        return ff8c.fT;
    }

    private boolean FB55()
    {
        boolean flag;
        if (fU != null && fU.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return false;
        } else
        {
            removeView(fU);
            addView(fT, new android.view.ViewGroup.LayoutParams(-2, -1));
            setTabSelected(fU.getSelectedItemPosition());
            return false;
        }
    }

    public final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (fR != null)
        {
            post(fR);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        configuration = new _cls4E28(getContext());
        setContentHeight(configuration._mth1D67());
        fX = ((_cls4E28) (configuration)).mContext.getResources().getDimensionPixelSize(_cls1ECA.if.abc_action_bar_stacked_tab_max_width);
    }

    public final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (fR != null)
        {
            removeCallbacks(fR);
        }
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
    }

    public final void onMeasure(int i, int j)
    {
        j = android.view.View.MeasureSpec.getMode(i);
        boolean flag;
        if (j == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        int k = fT.getChildCount();
        if (k > 1 && (j == 0x40000000 || j == 0x80000000))
        {
            if (k > 2)
            {
                fW = (int)((float)android.view.View.MeasureSpec.getSize(i) * 0.4F);
            } else
            {
                fW = android.view.View.MeasureSpec.getSize(i) / 2;
            }
            fW = Math.min(fW, fX);
        } else
        {
            fW = -1;
        }
        k = android.view.View.MeasureSpec.makeMeasureSpec(_fld03DD, 0x40000000);
        if (!flag && fV)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            fT.measure(0, k);
            if (fT.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i))
            {
                if (fU != null && fU.getParent() == this)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (j == 0)
                {
                    if (fU == null)
                    {
                        _cls0295 _lcls0295 = new _cls0295(getContext(), null, _cls1541.actionDropDownStyle);
                        _lcls0295.setLayoutParams(new _cls1D60.if(-2, -1));
                        _lcls0295.setOnItemSelectedListener(this);
                        fU = _lcls0295;
                    }
                    removeView(fT);
                    addView(fU, new android.view.ViewGroup.LayoutParams(-2, -1));
                    if (fU.getAdapter() == null)
                    {
                        fU.setAdapter(new if((byte)0));
                    }
                    if (fR != null)
                    {
                        removeCallbacks(fR);
                        fR = null;
                    }
                    fU.setSelection(fY);
                }
            } else
            {
                FB55();
            }
        } else
        {
            FB55();
        }
        j = getMeasuredWidth();
        super.onMeasure(i, k);
        i = getMeasuredWidth();
        if (flag && j != i)
        {
            setTabSelected(fY);
        }
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    public final void setAllowCollapse(boolean flag)
    {
        fV = flag;
    }

    public final void setContentHeight(int i)
    {
        _fld03DD = i;
        requestLayout();
    }

    public final void setTabSelected(int i)
    {
        fY = i;
        int k = fT.getChildCount();
        for (int j = 0; j < k; j++)
        {
            View view = fT.getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (!flag)
            {
                continue;
            }
            view = fT.getChildAt(i);
            if (fR != null)
            {
                removeCallbacks(fR);
            }
            fR = new FF8D(this, view);
            post(fR);
        }

        if (fU != null && i >= 0)
        {
            fU.setSelection(i);
        }
    }

    static 
    {
        new DecelerateInterpolator();
    }
}
