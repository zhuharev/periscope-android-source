// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package o:
//            _cls09A3, _cls1FD1, _cls14AB, FE70, 
//            FE7C

public class _cls1D60 extends ViewGroup
{
    /* member class not found */
    class if {}


    private int bA;
    private int bB;
    private int bC;
    private float bD;
    private boolean bE;
    private int bF[];
    private int bG[];
    private Drawable bH;
    private int bI;
    private int bJ;
    private int bK;
    private int bL;
    private boolean bx;
    private int by;
    private int bz;

    public _cls1D60(Context context)
    {
        this(context, null);
    }

    public _cls1D60(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls1D60(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bx = true;
        by = -1;
        bz = 0;
        bB = 0x800033;
        context = new _cls09A3(context, context.obtainStyledAttributes(attributeset, _cls1FD1.LinearLayoutCompat, i, 0));
        i = _cls1FD1.LinearLayoutCompat_android_orientation;
        i = ((_cls09A3) (context)).hU.getInt(i, -1);
        if (i >= 0)
        {
            setOrientation(i);
        }
        i = _cls1FD1.LinearLayoutCompat_android_gravity;
        i = ((_cls09A3) (context)).hU.getInt(i, -1);
        if (i >= 0)
        {
            setGravity(i);
        }
        i = _cls1FD1.LinearLayoutCompat_android_baselineAligned;
        boolean flag = ((_cls09A3) (context)).hU.getBoolean(i, true);
        if (!flag)
        {
            setBaselineAligned(flag);
        }
        i = _cls1FD1.LinearLayoutCompat_android_weightSum;
        bD = ((_cls09A3) (context)).hU.getFloat(i, -1F);
        i = _cls1FD1.LinearLayoutCompat_android_baselineAlignedChildIndex;
        by = ((_cls09A3) (context)).hU.getInt(i, -1);
        i = _cls1FD1.LinearLayoutCompat_measureWithLargestChild;
        bE = ((_cls09A3) (context)).hU.getBoolean(i, false);
        setDividerDrawable(context.getDrawable(_cls1FD1.LinearLayoutCompat_divider));
        i = _cls1FD1.LinearLayoutCompat_showDividers;
        bK = ((_cls09A3) (context)).hU.getInt(i, 0);
        i = _cls1FD1.LinearLayoutCompat_dividerPadding;
        bL = ((_cls09A3) (context)).hU.getDimensionPixelSize(i, 0);
        ((_cls09A3) (context)).hU.recycle();
    }

    private void _mth02CE(View view, int i, int j, int k, int l)
    {
        view.layout(i, j, i + k, j + l);
    }

    private void _mth1427(int i, int j)
    {
        int l = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000);
        for (int k = 0; k < i; k++)
        {
            View view = getVirtualChildAt(k);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            if if1 = (if)view.getLayoutParams();
            if (if1.width == -1)
            {
                int i1 = if1.height;
                if1.height = view.getMeasuredHeight();
                measureChildWithMargins(view, l, 0, j, 0);
                if1.height = i1;
            }
        }

    }

    private void FE73(int i, int j)
    {
        int l = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0x40000000);
        for (int k = 0; k < i; k++)
        {
            View view = getVirtualChildAt(k);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            if if1 = (if)view.getLayoutParams();
            if (if1.height == -1)
            {
                int i1 = if1.width;
                if1.width = view.getMeasuredWidth();
                measureChildWithMargins(view, j, 0, l, 0);
                if1.width = i1;
            }
        }

    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof if;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return FE97();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return _mth02CE(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return _mth02CB(layoutparams);
    }

    public int getBaseline()
    {
        if (by < 0)
        {
            return super.getBaseline();
        }
        if (getChildCount() <= by)
        {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View view = getChildAt(by);
        int k = view.getBaseline();
        if (k == -1)
        {
            if (by == 0)
            {
                return -1;
            } else
            {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        }
        int j = bz;
        int i = j;
        if (bA == 1)
        {
            int l = bB & 0x70;
            i = j;
            if (l != 48)
            {
                switch (l)
                {
                default:
                    i = j;
                    break;

                case 80: // 'P'
                    i = getBottom() - getTop() - getPaddingBottom() - bC;
                    break;

                case 16: // '\020'
                    i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - bC) / 2;
                    break;
                }
            }
        }
        return ((if)view.getLayoutParams()).topMargin + i + k;
    }

    View getVirtualChildAt(int i)
    {
        return getChildAt(i);
    }

    int getVirtualChildCount()
    {
        return getChildCount();
    }

    protected void onDraw(Canvas canvas)
    {
        if (bH == null)
        {
            return;
        }
        if (bA == 1)
        {
            _mth02CA(canvas);
            return;
        } else
        {
            _mth02CB(canvas);
            return;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.onInitializeAccessibilityEvent(accessibilityevent);
            accessibilityevent.setClassName(o/1D60.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
            accessibilitynodeinfo.setClassName(o/1D60.getName());
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (bA == 1)
        {
            _mth02CF(i, j, k, l);
            return;
        } else
        {
            _mth141D(i, j, k, l);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (bA == 1)
        {
            _mth0640(i, j);
            return;
        } else
        {
            _mth1428(i, j);
            return;
        }
    }

    public void setBaselineAligned(boolean flag)
    {
        bx = flag;
    }

    public void setBaselineAlignedChildIndex(int i)
    {
        if (i < 0 || i >= getChildCount())
        {
            throw new IllegalArgumentException((new StringBuilder("base aligned child index out of range (0, ")).append(getChildCount()).append(")").toString());
        } else
        {
            by = i;
            return;
        }
    }

    public void setDividerDrawable(Drawable drawable)
    {
        if (drawable == bH)
        {
            return;
        }
        bH = drawable;
        if (drawable != null)
        {
            bI = drawable.getIntrinsicWidth();
            bJ = drawable.getIntrinsicHeight();
        } else
        {
            bI = 0;
            bJ = 0;
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        requestLayout();
    }

    public void setDividerPadding(int i)
    {
        bL = i;
    }

    public void setGravity(int i)
    {
        if (bB != i)
        {
            int j = i;
            if ((0x800007 & i) == 0)
            {
                j = i | 0x800003;
            }
            i = j;
            if ((j & 0x70) == 0)
            {
                i = j | 0x30;
            }
            bB = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i)
    {
        i &= 0x800007;
        if ((bB & 0x800007) != i)
        {
            bB = bB & 0xff7ffff8 | i;
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean flag)
    {
        bE = flag;
    }

    public void setOrientation(int i)
    {
        if (bA != i)
        {
            bA = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i)
    {
        if (i != bK)
        {
            requestLayout();
        }
        bK = i;
    }

    public void setVerticalGravity(int i)
    {
        i &= 0x70;
        if ((bB & 0x70) != i)
        {
            bB = bB & 0xffffff8f | i;
            requestLayout();
        }
    }

    public void setWeightSum(float f)
    {
        bD = Math.max(0.0F, f);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public int _mth0208()
    {
        return bI;
    }

    int _mth02BB(View view, int i)
    {
        return 0;
    }

    void _mth02CA(Canvas canvas)
    {
        int k = getVirtualChildCount();
        for (int i = 0; i < k; i++)
        {
            View view = getVirtualChildAt(i);
            if (view != null && view.getVisibility() != 8 && _mth1421(i))
            {
                if if1 = (if)view.getLayoutParams();
                _mth02CA(canvas, view.getTop() - if1.topMargin - bJ);
            }
        }

        if (_mth1421(k))
        {
            View view1 = getVirtualChildAt(k - 1);
            int j;
            if (view1 == null)
            {
                j = getHeight() - getPaddingBottom() - bJ;
            } else
            {
                if if2 = (if)view1.getLayoutParams();
                j = view1.getBottom() + if2.bottomMargin;
            }
            _mth02CA(canvas, j);
        }
    }

    void _mth02CA(Canvas canvas, int i)
    {
        bH.setBounds(getPaddingLeft() + bL, i, getWidth() - getPaddingRight() - bL, bJ + i);
        bH.draw(canvas);
    }

    void _mth02CA(View view, int i, int j, int k, int l, int i1)
    {
        measureChildWithMargins(view, j, k, l, i1);
    }

    protected if _mth02CB(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new if(layoutparams);
    }

    void _mth02CB(Canvas canvas)
    {
        int l = getVirtualChildCount();
        boolean flag = _cls14AB._mth02CF(this);
        for (int i = 0; i < l; i++)
        {
            View view = getVirtualChildAt(i);
            if (view == null || view.getVisibility() == 8 || !_mth1421(i))
            {
                continue;
            }
            if if1 = (if)view.getLayoutParams();
            int k;
            if (flag)
            {
                k = view.getRight() + if1.rightMargin;
            } else
            {
                k = view.getLeft() - if1.leftMargin - bI;
            }
            _mth02CB(canvas, k);
        }

        if (_mth1421(l))
        {
            View view1 = getVirtualChildAt(l - 1);
            int j;
            if (view1 == null)
            {
                if (flag)
                {
                    j = getPaddingLeft();
                } else
                {
                    j = getWidth() - getPaddingRight() - bI;
                }
            } else
            {
                if if2 = (if)view1.getLayoutParams();
                if (flag)
                {
                    j = view1.getLeft() - if2.leftMargin - bI;
                } else
                {
                    j = view1.getRight() + if2.rightMargin;
                }
            }
            _mth02CB(canvas, j);
        }
    }

    void _mth02CB(Canvas canvas, int i)
    {
        bH.setBounds(i, getPaddingTop() + bL, bI + i, getHeight() - getPaddingBottom() - bL);
        bH.draw(canvas);
    }

    public if _mth02CE(AttributeSet attributeset)
    {
        return new if(getContext(), attributeset);
    }

    void _mth02CF(int i, int j, int k, int l)
    {
        int i1 = getPaddingLeft();
        int j1 = k - i;
        int k1 = getPaddingRight();
        int l1 = getPaddingRight();
        int i2 = getVirtualChildCount();
        i = bB;
        int j2 = bB;
        switch (i & 0x70)
        {
        case 80: // 'P'
            i = (getPaddingTop() + l) - j - bC;
            break;

        case 16: // '\020'
            i = getPaddingTop() + (l - j - bC) / 2;
            break;

        default:
            i = getPaddingTop();
            break;
        }
        for (j = 0; j < i2;)
        {
            View view = getVirtualChildAt(j);
            if (view == null)
            {
                k = i + _mth142A(j);
                l = j;
            } else
            {
                k = i;
                l = j;
                if (view.getVisibility() != 8)
                {
                    int k2 = view.getMeasuredWidth();
                    int l2 = view.getMeasuredHeight();
                    if if1 = (if)view.getLayoutParams();
                    l = if1.gravity;
                    k = l;
                    if (l < 0)
                    {
                        k = j2 & 0x800007;
                    }
                    switch (FE7C.getAbsoluteGravity(k, FE70._mth02C9(this)) & 7)
                    {
                    case 1: // '\001'
                        k = ((j1 - i1 - l1 - k2) / 2 + i1 + if1.leftMargin) - if1.rightMargin;
                        break;

                    case 5: // '\005'
                        k = j1 - k1 - k2 - if1.rightMargin;
                        break;

                    case 2: // '\002'
                    case 3: // '\003'
                    case 4: // '\004'
                    default:
                        k = i1 + if1.leftMargin;
                        break;
                    }
                    l = i;
                    if (_mth1421(j))
                    {
                        l = i + bJ;
                    }
                    i = l + if1.topMargin;
                    _mth02CE(view, k, FB1D(view) + i, k2, l2);
                    k = i + (if1.bottomMargin + l2 + FB39(view));
                    l = j + _mth02BB(view, j);
                }
            }
            j = l + 1;
            i = k;
        }

    }

    void _mth0640(int i, int j)
    {
        bC = 0;
        int i1 = 0;
        int l = 0;
        int k1 = 0;
        int j2 = 0;
        int k = 1;
        float f = 0.0F;
        int j7 = getVirtualChildCount();
        int k7 = android.view.View.MeasureSpec.getMode(i);
        int l7 = android.view.View.MeasureSpec.getMode(j);
        int j1 = 0;
        int i2 = 0;
        int i8 = by;
        boolean flag = bE;
        int l1 = 0x80000000;
        for (int k2 = 0; k2 < j7; k2++)
        {
            View view = getVirtualChildAt(k2);
            if (view == null)
            {
                bC = bC + _mth142A(k2);
                continue;
            }
            int j5 = i1;
            int l5 = l;
            int j6 = k1;
            int k6 = j2;
            int l6 = k;
            float f1 = f;
            int i7 = j1;
            int j3 = i2;
            int k4 = l1;
            if (view.getVisibility() != 8)
            {
                if (_mth1421(k2))
                {
                    bC = bC + bJ;
                }
                if if1 = (if)view.getLayoutParams();
                f1 = f + if1.weight;
                if (l7 == 0x40000000 && if1.height == 0 && if1.weight > 0.0F)
                {
                    i2 = bC;
                    bC = Math.max(i2, if1.topMargin + i2 + if1.bottomMargin);
                    j3 = 1;
                    k4 = l1;
                } else
                {
                    k4 = 0x80000000;
                    j3 = k4;
                    if (if1.height == 0)
                    {
                        j3 = k4;
                        if (if1.weight > 0.0F)
                        {
                            j3 = 0;
                            if1.height = -2;
                        }
                    }
                    if (f1 == 0.0F)
                    {
                        k4 = bC;
                    } else
                    {
                        k4 = 0;
                    }
                    _mth02CA(view, k2, i, 0, j, k4);
                    if (j3 != 0x80000000)
                    {
                        if1.height = j3;
                    }
                    j5 = view.getMeasuredHeight();
                    j3 = bC;
                    bC = Math.max(j3, j3 + j5 + if1.topMargin + if1.bottomMargin + FB39(view));
                    j3 = i2;
                    k4 = l1;
                    if (flag)
                    {
                        k4 = Math.max(j5, l1);
                        j3 = i2;
                    }
                }
                if (i8 >= 0 && i8 == k2 + 1)
                {
                    bz = bC;
                }
                if (k2 < i8 && if1.weight > 0.0F)
                {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                j5 = 0;
                l1 = j1;
                i2 = j5;
                if (k7 != 0x40000000)
                {
                    l1 = j1;
                    i2 = j5;
                    if (if1.width == -1)
                    {
                        l1 = 1;
                        i2 = 1;
                    }
                }
                j1 = if1.leftMargin + if1.rightMargin;
                j5 = view.getMeasuredWidth() + j1;
                i1 = Math.max(i1, j5);
                l5 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(view));
                if (k != 0 && if1.width == -1)
                {
                    l6 = 1;
                } else
                {
                    l6 = 0;
                }
                if (if1.weight > 0.0F)
                {
                    if (i2 == 0)
                    {
                        j1 = j5;
                    }
                    k6 = Math.max(j2, j1);
                    j5 = i1;
                    j6 = k1;
                    i7 = l1;
                } else
                {
                    if (i2 == 0)
                    {
                        j1 = j5;
                    }
                    j6 = Math.max(k1, j1);
                    i7 = l1;
                    k6 = j2;
                    j5 = i1;
                }
            }
            k2 += _mth02BB(view, k2);
            l1 = k4;
            i2 = j3;
            j1 = i7;
            f = f1;
            k = l6;
            j2 = k6;
            k1 = j6;
            l = l5;
            i1 = j5;
        }

        if (bC > 0 && _mth1421(j7))
        {
            bC = bC + bJ;
        }
        if (flag && (l7 == 0x80000000 || l7 == 0))
        {
            bC = 0;
            for (int l2 = 0; l2 < j7; l2++)
            {
                View view1 = getVirtualChildAt(l2);
                if (view1 == null)
                {
                    bC = bC + _mth142A(l2);
                    continue;
                }
                if (view1.getVisibility() == 8)
                {
                    l2 += _mth02BB(view1, l2);
                } else
                {
                    if if2 = (if)view1.getLayoutParams();
                    int k3 = bC;
                    bC = Math.max(k3, k3 + l1 + if2.topMargin + if2.bottomMargin + FB39(view1));
                }
            }

        }
        bC = bC + (getPaddingTop() + getPaddingBottom());
        int i6 = FE70.resolveSizeAndState(Math.max(bC, getSuggestedMinimumHeight()), j, 0);
        int l3 = (i6 & 0xffffff) - bC;
        int i3;
        if (i2 != 0 || l3 != 0 && f > 0.0F)
        {
            if (bD > 0.0F)
            {
                f = bD;
            }
            bC = 0;
            i3 = 0;
            j2 = l3;
            while (i3 < j7) 
            {
                View view2 = getVirtualChildAt(i3);
                int k5 = i1;
                l1 = l;
                int l4 = k1;
                int i4 = k;
                i2 = j2;
                float f2 = f;
                if (view2.getVisibility() != 8)
                {
                    if if3 = (if)view2.getLayoutParams();
                    float f3 = if3.weight;
                    l1 = l;
                    i2 = j2;
                    f2 = f;
                    if (f3 > 0.0F)
                    {
                        l1 = (int)(((float)j2 * f3) / f);
                        f2 = f - f3;
                        i2 = j2 - l1;
                        i4 = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + if3.leftMargin + if3.rightMargin, if3.width);
                        if (if3.height != 0 || l7 != 0x40000000)
                        {
                            j2 = view2.getMeasuredHeight() + l1;
                            l1 = j2;
                            if (j2 < 0)
                            {
                                l1 = 0;
                            }
                        } else
                        if (l1 <= 0)
                        {
                            l1 = 0;
                        }
                        view2.measure(i4, android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000));
                        l1 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(view2) & 0xffffff00);
                    }
                    j2 = if3.leftMargin + if3.rightMargin;
                    i4 = view2.getMeasuredWidth() + j2;
                    k5 = Math.max(i1, i4);
                    if (k7 != 0x40000000 && if3.width == -1)
                    {
                        l = 1;
                    } else
                    {
                        l = 0;
                    }
                    if (l != 0)
                    {
                        l = j2;
                    } else
                    {
                        l = i4;
                    }
                    l4 = Math.max(k1, l);
                    if (k != 0 && if3.width == -1)
                    {
                        k = 1;
                    } else
                    {
                        k = 0;
                    }
                    l = bC;
                    bC = Math.max(l, view2.getMeasuredHeight() + l + if3.topMargin + if3.bottomMargin + FB39(view2));
                    i4 = k;
                }
                i3++;
                i1 = k5;
                l = l1;
                k1 = l4;
                k = i4;
                j2 = i2;
                f = f2;
            }
            bC = bC + (getPaddingTop() + getPaddingBottom());
            i2 = i1;
            j2 = l;
            i3 = k;
        } else
        {
            int i5 = Math.max(k1, j2);
            i2 = i1;
            j2 = l;
            k1 = i5;
            i3 = k;
            if (flag)
            {
                i2 = i1;
                j2 = l;
                k1 = i5;
                i3 = k;
                if (l7 != 0x40000000)
                {
                    int j4 = 0;
                    do
                    {
                        i2 = i1;
                        j2 = l;
                        k1 = i5;
                        i3 = k;
                        if (j4 >= j7)
                        {
                            break;
                        }
                        View view3 = getVirtualChildAt(j4);
                        if (view3 != null && view3.getVisibility() != 8 && ((if)view3.getLayoutParams()).weight > 0.0F)
                        {
                            view3.measure(android.view.View.MeasureSpec.makeMeasureSpec(view3.getMeasuredWidth(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000));
                        }
                        j4++;
                    } while (true);
                }
            }
        }
        k = i2;
        if (i3 == 0)
        {
            k = i2;
            if (k7 != 0x40000000)
            {
                k = k1;
            }
        }
        setMeasuredDimension(FE70.resolveSizeAndState(Math.max(getPaddingLeft() + getPaddingRight() + k, getSuggestedMinimumWidth()), i, j2), i6);
        if (j1 != 0)
        {
            _mth1427(j7, j);
        }
    }

    void _mth141D(int i, int j, int k, int l)
    {
        boolean flag = _cls14AB._mth02CF(this);
        int k1 = getPaddingTop();
        int k2 = l - j;
        int l2 = getPaddingBottom();
        int i3 = getPaddingBottom();
        int j3 = getVirtualChildCount();
        j = bB;
        int k3 = bB;
        boolean flag1 = bx;
        int ai[] = bF;
        int ai1[] = bG;
        switch (FE7C.getAbsoluteGravity(j & 0x800007, FE70._mth02C9(this)))
        {
        case 5: // '\005'
            i = (getPaddingLeft() + k) - i - bC;
            break;

        case 1: // '\001'
            i = getPaddingLeft() + (k - i - bC) / 2;
            break;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        default:
            i = getPaddingLeft();
            break;
        }
        int i1 = 0;
        l = 1;
        if (flag)
        {
            i1 = j3 - 1;
            l = -1;
        }
        j = 0;
        for (k = i; j < j3; k = i)
        {
            int l3 = i1 + l * j;
            View view = getVirtualChildAt(l3);
            int j1;
            if (view == null)
            {
                i = k + _mth142A(l3);
                j1 = j;
            } else
            {
                j1 = j;
                i = k;
                if (view.getVisibility() != 8)
                {
                    int i4 = view.getMeasuredWidth();
                    int j4 = view.getMeasuredHeight();
                    i = -1;
                    if if1 = (if)view.getLayoutParams();
                    j1 = i;
                    if (flag1)
                    {
                        j1 = i;
                        if (if1.height != -1)
                        {
                            j1 = view.getBaseline();
                        }
                    }
                    int l1 = if1.gravity;
                    i = l1;
                    if (l1 < 0)
                    {
                        i = k3 & 0x70;
                    }
                    switch (i & 0x70)
                    {
                    case 48: // '0'
                        int i2 = k1 + if1.topMargin;
                        i = i2;
                        if (j1 != -1)
                        {
                            i = i2 + (ai[1] - j1);
                        }
                        break;

                    case 16: // '\020'
                        i = ((k2 - k1 - i3 - j4) / 2 + k1 + if1.topMargin) - if1.bottomMargin;
                        break;

                    case 80: // 'P'
                        int j2 = k2 - l2 - j4 - if1.bottomMargin;
                        i = j2;
                        if (j1 != -1)
                        {
                            i = view.getMeasuredHeight();
                            i = j2 - (ai1[2] - (i - j1));
                        }
                        break;

                    default:
                        i = k1;
                        break;
                    }
                    j1 = k;
                    if (_mth1421(l3))
                    {
                        j1 = k + bI;
                    }
                    k = j1 + if1.leftMargin;
                    _mth02CE(view, FB1D(view) + k, i, i4, j4);
                    i = k + (if1.rightMargin + i4 + FB39(view));
                    j1 = j + _mth02BB(view, l3);
                }
            }
            j = j1 + 1;
        }

    }

    protected boolean _mth1421(int i)
    {
        if (i == 0)
        {
            return (bK & 1) != 0;
        }
        if (i == getChildCount())
        {
            return (bK & 4) != 0;
        }
        if ((bK & 2) != 0)
        {
            for (i--; i >= 0; i--)
            {
                if (getChildAt(i).getVisibility() != 8)
                {
                    return true;
                }
            }

            return false;
        } else
        {
            return false;
        }
    }

    void _mth1428(int i, int j)
    {
        float f;
        int ai[];
        int ai1[];
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int j3;
        int l3;
        boolean flag2;
        int i8;
        int j8;
        int k8;
        boolean flag3;
        boolean flag4;
label0:
        {
            bC = 0;
            int i2 = 0;
            l = 0;
            j1 = 0;
            j3 = 0;
            k = 1;
            f = 0.0F;
            i8 = getVirtualChildCount();
            k8 = android.view.View.MeasureSpec.getMode(i);
            j8 = android.view.View.MeasureSpec.getMode(j);
            i1 = 0;
            l1 = 0;
            if (bF == null || bG == null)
            {
                bF = new int[4];
                bG = new int[4];
            }
            ai = bF;
            ai1 = bG;
            ai[3] = -1;
            ai[2] = -1;
            ai[1] = -1;
            ai[0] = -1;
            ai1[3] = -1;
            ai1[2] = -1;
            ai1[1] = -1;
            ai1[0] = -1;
            flag3 = bx;
            flag4 = bE;
            if (k8 == 0x40000000)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            k1 = 0x80000000;
            for (int k3 = 0; k3 < i8; k3++)
            {
                View view1 = getVirtualChildAt(k3);
                if (view1 == null)
                {
                    bC = bC + _mth142A(k3);
                    continue;
                }
                int l5 = i2;
                int j6 = l;
                int k6 = j1;
                int i7 = j3;
                boolean flag1 = k;
                float f1 = f;
                int l7 = i1;
                int i4 = l1;
                int i5 = k1;
                if (view1.getVisibility() != 8)
                {
                    if (_mth1421(k3))
                    {
                        bC = bC + bI;
                    }
                    if if1 = (if)view1.getLayoutParams();
                    f1 = f + if1.weight;
                    if (k8 == 0x40000000 && if1.width == 0 && if1.weight > 0.0F)
                    {
                        if (flag2)
                        {
                            bC = bC + (if1.leftMargin + if1.rightMargin);
                        } else
                        {
                            i4 = bC;
                            bC = Math.max(i4, if1.leftMargin + i4 + if1.rightMargin);
                        }
                        if (flag3)
                        {
                            i4 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                            view1.measure(i4, i4);
                            i4 = l1;
                            i5 = k1;
                        } else
                        {
                            i4 = 1;
                            i5 = k1;
                        }
                    } else
                    {
                        i5 = 0x80000000;
                        i4 = i5;
                        if (if1.width == 0)
                        {
                            i4 = i5;
                            if (if1.weight > 0.0F)
                            {
                                i4 = 0;
                                if1.width = -2;
                            }
                        }
                        if (f1 == 0.0F)
                        {
                            i5 = bC;
                        } else
                        {
                            i5 = 0;
                        }
                        _mth02CA(view1, k3, i, i5, j, 0);
                        if (i4 != 0x80000000)
                        {
                            if1.width = i4;
                        }
                        l5 = view1.getMeasuredWidth();
                        if (flag2)
                        {
                            bC = bC + (if1.leftMargin + l5 + if1.rightMargin + FB39(view1));
                        } else
                        {
                            i4 = bC;
                            bC = Math.max(i4, i4 + l5 + if1.leftMargin + if1.rightMargin + FB39(view1));
                        }
                        i4 = l1;
                        i5 = k1;
                        if (flag4)
                        {
                            i5 = Math.max(l5, k1);
                            i4 = l1;
                        }
                    }
                    l5 = 0;
                    k1 = i1;
                    l1 = l5;
                    if (j8 != 0x40000000)
                    {
                        k1 = i1;
                        l1 = l5;
                        if (if1.height == -1)
                        {
                            k1 = 1;
                            l1 = 1;
                        }
                    }
                    i1 = if1.topMargin + if1.bottomMargin;
                    l5 = view1.getMeasuredHeight() + i1;
                    j6 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(view1));
                    if (flag3)
                    {
                        k6 = view1.getBaseline();
                        if (k6 != -1)
                        {
                            if (if1.gravity < 0)
                            {
                                l = bB;
                            } else
                            {
                                l = if1.gravity;
                            }
                            l = ((l & 0x70) >> 4 & -2) >> 1;
                            ai[l] = Math.max(ai[l], k6);
                            ai1[l] = Math.max(ai1[l], l5 - k6);
                        }
                    }
                    l = Math.max(i2, l5);
                    if (k && if1.height == -1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (if1.weight > 0.0F)
                    {
                        if (l1 == 0)
                        {
                            i1 = l5;
                        }
                        i7 = Math.max(j3, i1);
                        l5 = l;
                        k6 = j1;
                        l7 = k1;
                    } else
                    {
                        if (l1 == 0)
                        {
                            i1 = l5;
                        }
                        k6 = Math.max(j1, i1);
                        l7 = k1;
                        i7 = j3;
                        l5 = l;
                    }
                }
                k3 += _mth02BB(view1, k3);
                k1 = i5;
                l1 = i4;
                i1 = l7;
                f = f1;
                k = ((flag1) ? 1 : 0);
                j3 = i7;
                j1 = k6;
                l = j6;
                i2 = l5;
            }

            if (bC > 0 && _mth1421(i8))
            {
                bC = bC + bI;
            }
            if (ai[1] == -1 && ai[0] == -1 && ai[2] == -1)
            {
                l3 = i2;
                if (ai[3] == -1)
                {
                    break label0;
                }
            }
            l3 = Math.max(i2, Math.max(ai[3], Math.max(ai[0], Math.max(ai[1], ai[2]))) + Math.max(ai1[3], Math.max(ai1[0], Math.max(ai1[1], ai1[2]))));
        }
        int i3;
        int j7;
label1:
        {
label2:
            {
label3:
                {
                    if (flag4 && (k8 == 0x80000000 || k8 == 0))
                    {
                        bC = 0;
                        for (int j2 = 0; j2 < i8; j2++)
                        {
                            View view2 = getVirtualChildAt(j2);
                            if (view2 == null)
                            {
                                bC = bC + _mth142A(j2);
                                continue;
                            }
                            if (view2.getVisibility() == 8)
                            {
                                j2 += _mth02BB(view2, j2);
                                continue;
                            }
                            if if2 = (if)view2.getLayoutParams();
                            if (flag2)
                            {
                                bC = bC + (if2.leftMargin + k1 + if2.rightMargin + FB39(view2));
                            } else
                            {
                                int j4 = bC;
                                bC = Math.max(j4, j4 + k1 + if2.leftMargin + if2.rightMargin + FB39(view2));
                            }
                        }

                    }
                    bC = bC + (getPaddingLeft() + getPaddingRight());
                    j7 = FE70.resolveSizeAndState(Math.max(bC, getSuggestedMinimumWidth()), i, 0);
                    int k2 = (j7 & 0xffffff) - bC;
                    if (l1 == 0 && (k2 == 0 || f <= 0.0F))
                    {
                        break label2;
                    }
                    if (bD > 0.0F)
                    {
                        f = bD;
                    }
                    ai[3] = -1;
                    ai[2] = -1;
                    ai[1] = -1;
                    ai[0] = -1;
                    ai1[3] = -1;
                    ai1[2] = -1;
                    ai1[1] = -1;
                    ai1[0] = -1;
                    k1 = -1;
                    bC = 0;
                    l3 = 0;
                    j3 = k2;
                    while (l3 < i8) 
                    {
                        View view3 = getVirtualChildAt(l3);
                        int k4 = k1;
                        int j5 = l;
                        int i6 = j1;
                        boolean flag = k;
                        int l6 = j3;
                        float f3 = f;
                        if (view3 != null)
                        {
                            k4 = k1;
                            j5 = l;
                            i6 = j1;
                            flag = k;
                            l6 = j3;
                            f3 = f;
                            if (view3.getVisibility() != 8)
                            {
                                if if3 = (if)view3.getLayoutParams();
                                f3 = if3.weight;
                                int l2 = l;
                                l1 = j3;
                                float f2 = f;
                                if (f3 > 0.0F)
                                {
                                    l1 = (int)(((float)j3 * f3) / f);
                                    f2 = f - f3;
                                    l2 = j3 - l1;
                                    k4 = getChildMeasureSpec(j, getPaddingTop() + getPaddingBottom() + if3.topMargin + if3.bottomMargin, if3.height);
                                    if (if3.width != 0 || k8 != 0x40000000)
                                    {
                                        j3 = view3.getMeasuredWidth() + l1;
                                        l1 = j3;
                                        if (j3 < 0)
                                        {
                                            l1 = 0;
                                        }
                                    } else
                                    if (l1 <= 0)
                                    {
                                        l1 = 0;
                                    }
                                    view3.measure(android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000), k4);
                                    l = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(view3) & 0xff000000);
                                    l1 = l2;
                                    l2 = l;
                                }
                                if (flag2)
                                {
                                    bC = bC + (view3.getMeasuredWidth() + if3.leftMargin + if3.rightMargin + FB39(view3));
                                } else
                                {
                                    l = bC;
                                    bC = Math.max(l, view3.getMeasuredWidth() + l + if3.leftMargin + if3.rightMargin + FB39(view3));
                                }
                                if (j8 != 0x40000000 && if3.height == -1)
                                {
                                    l = 1;
                                } else
                                {
                                    l = 0;
                                }
                                k4 = if3.topMargin + if3.bottomMargin;
                                j3 = view3.getMeasuredHeight() + k4;
                                k1 = Math.max(k1, j3);
                                if (l != 0)
                                {
                                    l = k4;
                                } else
                                {
                                    l = j3;
                                }
                                j1 = Math.max(j1, l);
                                if (k && if3.height == -1)
                                {
                                    k = 1;
                                } else
                                {
                                    k = 0;
                                }
                                k4 = k1;
                                j5 = l2;
                                i6 = j1;
                                flag = k;
                                l6 = l1;
                                f3 = f2;
                                if (flag3)
                                {
                                    int k7 = view3.getBaseline();
                                    k4 = k1;
                                    j5 = l2;
                                    i6 = j1;
                                    flag = k;
                                    l6 = l1;
                                    f3 = f2;
                                    if (k7 != -1)
                                    {
                                        if (if3.gravity < 0)
                                        {
                                            l = bB;
                                        } else
                                        {
                                            l = if3.gravity;
                                        }
                                        l = ((l & 0x70) >> 4 & -2) >> 1;
                                        ai[l] = Math.max(ai[l], k7);
                                        ai1[l] = Math.max(ai1[l], j3 - k7);
                                        f3 = f2;
                                        l6 = l1;
                                        flag = k;
                                        i6 = j1;
                                        j5 = l2;
                                        k4 = k1;
                                    }
                                }
                            }
                        }
                        l3++;
                        k1 = k4;
                        l = j5;
                        j1 = i6;
                        k = ((flag) ? 1 : 0);
                        j3 = l6;
                        f = f3;
                    }
                    bC = bC + (getPaddingLeft() + getPaddingRight());
                    if (ai[1] == -1 && ai[0] == -1 && ai[2] == -1)
                    {
                        l1 = k1;
                        if (ai[3] == -1)
                        {
                            break label3;
                        }
                    }
                    l1 = Math.max(k1, Math.max(ai[3], Math.max(ai[0], Math.max(ai[1], ai[2]))) + Math.max(ai1[3], Math.max(ai1[0], Math.max(ai1[1], ai1[2]))));
                }
                i3 = l;
                j3 = k;
                break label1;
            }
            int k5 = Math.max(j1, j3);
            l1 = l3;
            i3 = l;
            j1 = k5;
            j3 = k;
            if (flag4)
            {
                l1 = l3;
                i3 = l;
                j1 = k5;
                j3 = k;
                if (k8 != 0x40000000)
                {
                    int l4 = 0;
                    do
                    {
                        l1 = l3;
                        i3 = l;
                        j1 = k5;
                        j3 = k;
                        if (l4 >= i8)
                        {
                            break;
                        }
                        View view = getVirtualChildAt(l4);
                        if (view != null && view.getVisibility() != 8 && ((if)view.getLayoutParams()).weight > 0.0F)
                        {
                            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000));
                        }
                        l4++;
                    } while (true);
                }
            }
        }
        k = l1;
        if (j3 == 0)
        {
            k = l1;
            if (j8 != 0x40000000)
            {
                k = j1;
            }
        }
        setMeasuredDimension(0xff000000 & i3 | j7, FE70.resolveSizeAndState(Math.max(getPaddingTop() + getPaddingBottom() + k, getSuggestedMinimumHeight()), j, i3 << 16));
        if (i1 != 0)
        {
            FE73(i8, i);
        }
    }

    int _mth142A(int i)
    {
        return 0;
    }

    int FB1D(View view)
    {
        return 0;
    }

    int FB39(View view)
    {
        return 0;
    }

    protected if FE97()
    {
        if (bA == 0)
        {
            return new if(-2, -2);
        }
        if (bA == 1)
        {
            return new if(-1, -2);
        } else
        {
            return null;
        }
    }
}
