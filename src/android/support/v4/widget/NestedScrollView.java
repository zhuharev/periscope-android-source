// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;
import o.020B;
import o.026A;
import o.1484;
import o.14D2;
import o.153E;
import o.1601;
import o.1D4A;
import o.1D58;
import o.1D64;
import o.207F;
import o.2160;
import o.4E00;
import o.FB60;
import o.FB61;
import o.FBE9;
import o.FE70;

public class NestedScrollView extends FrameLayout
    implements _cls207F, _cls1D58, FB60
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls4E00();
        public int _fld03A5;

        public String toString()
        {
            return (new StringBuilder("HorizontalScrollView.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" scrollPosition=").append(_fld03A5).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(_fld03A5);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            _fld03A5 = parcel.readInt();
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    static final class if extends _cls1601
    {

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(view, accessibilityevent);
            view = (NestedScrollView)view;
            accessibilityevent.setClassName(android/widget/ScrollView.getName());
            accessibilityevent = _cls020B._mth02CA(accessibilityevent);
            boolean flag;
            if (NestedScrollView._mth02CA(view) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            accessibilityevent.setScrollable(flag);
            accessibilityevent.setScrollX(view.getScrollX());
            accessibilityevent.setScrollY(view.getScrollY());
            accessibilityevent.setMaxScrollX(view.getScrollX());
            accessibilityevent.setMaxScrollY(NestedScrollView._mth02CA(view));
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
        {
            if (super.performAccessibilityAction(view, i, bundle))
            {
                return true;
            }
            view = (NestedScrollView)view;
            if (!view.isEnabled())
            {
                return false;
            }
            switch (i)
            {
            case 4096: 
                i = view.getHeight();
                int j = view.getPaddingBottom();
                int l = view.getPaddingTop();
                i = Math.min(view.getScrollY() + (i - j - l), NestedScrollView._mth02CA(view));
                if (i != view.getScrollY())
                {
                    view.smoothScrollBy(0 - view.getScrollX(), i - view.getScrollY());
                    return true;
                } else
                {
                    return false;
                }

            case 8192: 
                i = view.getHeight();
                int k = view.getPaddingBottom();
                int i1 = view.getPaddingTop();
                i = Math.max(view.getScrollY() - (i - k - i1), 0);
                if (i != view.getScrollY())
                {
                    view.smoothScrollBy(0 - view.getScrollX(), i - view.getScrollY());
                    return true;
                } else
                {
                    return false;
                }
            }
            return false;
        }

        public final void _mth02CA(View view, _cls026A _pcls026a)
        {
            super._mth02CA(view, _pcls026a);
            view = (NestedScrollView)view;
            _pcls026a.setClassName(android/widget/ScrollView.getName());
            if (view.isEnabled())
            {
                int i = NestedScrollView._mth02CA(view);
                if (i > 0)
                {
                    _pcls026a.setScrollable(true);
                    if (view.getScrollY() > 0)
                    {
                        _pcls026a.addAction(8192);
                    }
                    if (view.getScrollY() < i)
                    {
                        _pcls026a.addAction(4096);
                    }
                }
            }
        }

        if()
        {
        }
    }

    /* member class not found */
    class _cls02CA {}


    private static final if _fld013F = new if();
    private static final int _fld0159[] = {
        0x101017a
    };
    private final int _fld0135[];
    private final int _fld0138[];
    private int _fld0139;
    private SavedState _fld013B;
    private final Rect _fld01C0;
    private final _cls2160 _fld01F0;
    private final _cls1D64 _fld026B;
    private float _fld0287;
    private _cls02CA _fld028B;
    private boolean _fld0631;
    private int _fld0EC0;
    private VelocityTracker _fld14EF;
    private int _fld157B;
    private int _fld1D04;
    private int _fld1D10;
    private long FC62;
    private FB61 FEAE;
    private _cls1D4A FEE0;
    private _cls1D4A FEE9;
    private int FF43;
    private boolean FF69;
    private boolean FF6A;
    private View FF83;
    private boolean FF85;
    private boolean FF9D;

    public NestedScrollView(Context context)
    {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _fld01C0 = new Rect();
        FF69 = true;
        FF6A = false;
        FF83 = null;
        _fld0631 = false;
        FF9D = true;
        _fld157B = -1;
        _fld0135 = new int[2];
        _fld0138 = new int[2];
        FEAE = new FB61(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(0x40000);
        setWillNotDraw(false);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        _fld0EC0 = viewconfiguration.getScaledTouchSlop();
        _fld1D04 = viewconfiguration.getScaledMinimumFlingVelocity();
        _fld1D10 = viewconfiguration.getScaledMaximumFlingVelocity();
        context = context.obtainStyledAttributes(attributeset, _fld0159, i, 0);
        setFillViewport(context.getBoolean(0, false));
        context.recycle();
        _fld01F0 = new _cls2160(this);
        _fld026B = new _cls1D64(this);
        setNestedScrollingEnabled(true);
        FE70._mth02CA(this, _fld013F);
    }

    private boolean arrowScroll(int i)
    {
        View view1 = findFocus();
        View view = view1;
        if (view1 == this)
        {
            view = null;
        }
        view1 = FocusFinder.getInstance().findNextFocus(this, view, i);
        int i1 = (int)((float)getHeight() * 0.5F);
        if (view1 != null && _mth02CB(view1, i1, getHeight()))
        {
            view1.getDrawingRect(_fld01C0);
            offsetDescendantRectToMyCoords(view1, _fld01C0);
            int j = computeScrollDeltaToGetChildRectOnScreen(_fld01C0);
            if (j != 0)
            {
                if (FF9D)
                {
                    smoothScrollBy(0, j);
                } else
                {
                    scrollBy(0, j);
                }
            }
            view1.requestFocus(i);
        } else
        {
            int l = i1;
            int k;
            if (i == 33 && getScrollY() < l)
            {
                k = getScrollY();
            } else
            {
                k = l;
                if (i == 130)
                {
                    k = l;
                    if (getChildCount() > 0)
                    {
                        int j1 = getChildAt(0).getBottom();
                        int k1 = (getScrollY() + getHeight()) - getPaddingBottom();
                        k = l;
                        if (j1 - k1 < i1)
                        {
                            k = j1 - k1;
                        }
                    }
                }
            }
            if (k == 0)
            {
                return false;
            }
            if (i != 130)
            {
                k = -k;
            }
            if (k != 0)
            {
                if (FF9D)
                {
                    smoothScrollBy(0, k);
                } else
                {
                    scrollBy(0, k);
                }
            }
        }
        if (view != null && view.isFocused())
        {
            if (!_mth02CB(view, 0, getHeight()))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = getDescendantFocusability();
                setDescendantFocusability(0x20000);
                requestFocus();
                setDescendantFocusability(i);
            }
        }
        return true;
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect)
    {
        if (getChildCount() == 0)
        {
            return 0;
        }
        int i1 = getHeight();
        int j = getScrollY();
        int i = j;
        int k = j + i1;
        int l = getVerticalFadingEdgeLength();
        j = i;
        if (rect.top > 0)
        {
            j = i + l;
        }
        i = k;
        if (rect.bottom < getChildAt(0).getHeight())
        {
            i = k - l;
        }
        l = 0;
        if (rect.bottom > i && rect.top > j)
        {
            if (rect.height() > i1)
            {
                j = (rect.top - j) + 0;
            } else
            {
                j = (rect.bottom - i) + 0;
            }
            return Math.min(j, getChildAt(0).getBottom() - i);
        }
        k = l;
        if (rect.top < j)
        {
            k = l;
            if (rect.bottom < i)
            {
                if (rect.height() > i1)
                {
                    i = 0 - (i - rect.bottom);
                } else
                {
                    i = 0 - (j - rect.top);
                }
                k = Math.max(i, -getScrollY());
            }
        }
        return k;
    }

    private void fling(int i)
    {
        if (getChildCount() > 0)
        {
            int j = getHeight() - getPaddingBottom() - getPaddingTop();
            int k = getChildAt(0).getHeight();
            FEAE.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, k - j), 0, j / 2);
            FE70._mth1FBE(this);
        }
    }

    private boolean fullScroll(int i)
    {
        boolean flag;
        if (i == 130)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = getHeight();
        _fld01C0.top = 0;
        _fld01C0.bottom = k;
        if (flag)
        {
            int j = getChildCount();
            if (j > 0)
            {
                View view = getChildAt(j - 1);
                _fld01C0.bottom = view.getBottom() + getPaddingBottom();
                _fld01C0.top = _fld01C0.bottom - k;
            }
        }
        return _mth02CF(i, _fld01C0.top, _fld01C0.bottom);
    }

    private boolean pageScroll(int i)
    {
        boolean flag;
        if (i == 130)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = getHeight();
        if (flag)
        {
            _fld01C0.top = getScrollY() + k;
            int j = getChildCount();
            if (j > 0)
            {
                View view = getChildAt(j - 1);
                if (_fld01C0.top + k > view.getBottom())
                {
                    _fld01C0.top = view.getBottom() - k;
                }
            }
        } else
        {
            _fld01C0.top = getScrollY() - k;
            if (_fld01C0.top < 0)
            {
                _fld01C0.top = 0;
            }
        }
        _fld01C0.bottom = _fld01C0.top + k;
        return _mth02CF(i, _fld01C0.top, _fld01C0.bottom);
    }

    static int _mth02CA(NestedScrollView nestedscrollview)
    {
        return nestedscrollview._mth14A2();
    }

    private View _mth02CA(boolean flag, int i, int j)
    {
        java.util.ArrayList arraylist = getFocusables(2);
        View view2 = null;
        boolean flag3 = false;
        int i1 = arraylist.size();
        for (int k = 0; k < i1;)
        {
            View view1 = (View)arraylist.get(k);
            int l = view1.getTop();
            int j1 = view1.getBottom();
            View view = view2;
            boolean flag2 = flag3;
            if (i < j1)
            {
                view = view2;
                flag2 = flag3;
                if (l < j)
                {
                    boolean flag1;
                    if (i < l && j1 < j)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (view2 == null)
                    {
                        view = view1;
                        flag2 = flag1;
                    } else
                    {
                        boolean flag4;
                        if (flag && l < view2.getTop() || !flag && j1 > view2.getBottom())
                        {
                            flag4 = true;
                        } else
                        {
                            flag4 = false;
                        }
                        if (flag3)
                        {
                            view = view2;
                            flag2 = flag3;
                            if (flag1)
                            {
                                view = view2;
                                flag2 = flag3;
                                if (flag4)
                                {
                                    view = view1;
                                    flag2 = flag3;
                                }
                            }
                        } else
                        if (flag1)
                        {
                            view = view1;
                            flag2 = true;
                        } else
                        {
                            view = view2;
                            flag2 = flag3;
                            if (flag4)
                            {
                                view = view1;
                                flag2 = flag3;
                            }
                        }
                    }
                }
            }
            k++;
            view2 = view;
            flag3 = flag2;
        }

        return view2;
    }

    private boolean _mth02CA(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        FE70._mth02BC(this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        i1 = i + k;
        k = j + l;
        j = j1 + 0;
        boolean flag = false;
        if (i1 > 0)
        {
            i = 0;
            flag = true;
        } else
        {
            i = i1;
            if (i1 < 0)
            {
                i = 0;
                flag = true;
            }
        }
        boolean flag1 = false;
        if (k > j)
        {
            flag1 = true;
        } else
        {
            j = k;
            if (k < 0)
            {
                j = 0;
                flag1 = true;
            }
        }
        if (flag1)
        {
            FEAE.springBack(i, j, 0, 0, 0, _mth14A2());
        }
        onOverScrolled(i, j, flag, flag1);
        return flag || flag1;
    }

    private static boolean _mth02CA(View view, View view1)
    {
        if (view == view1)
        {
            return true;
        }
        view = view.getParent();
        return (view instanceof ViewGroup) && _mth02CA((View)view, view1);
    }

    private boolean _mth02CB(View view, int i, int j)
    {
        view.getDrawingRect(_fld01C0);
        offsetDescendantRectToMyCoords(view, _fld01C0);
        return _fld01C0.bottom + i >= getScrollY() && _fld01C0.top - i <= getScrollY() + j;
    }

    private boolean _mth02CF(int i, int j, int k)
    {
        boolean flag1 = true;
        int i1 = getHeight();
        int l = getScrollY();
        i1 += l;
        boolean flag;
        if (i == 33)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        View view = _mth02CA(flag, j, k);
        Object obj = view;
        if (view == null)
        {
            obj = this;
        }
        if (j >= l && k <= i1)
        {
            flag = false;
        } else
        {
            if (flag)
            {
                j -= l;
            } else
            {
                j = k - i1;
            }
            flag = flag1;
            if (j != 0)
            {
                if (FF9D)
                {
                    smoothScrollBy(0, j);
                    flag = flag1;
                } else
                {
                    scrollBy(0, j);
                    flag = flag1;
                }
            }
        }
        if (obj != findFocus())
        {
            ((View) (obj)).requestFocus(i);
        }
        return flag;
    }

    private void _mth02EE(View view)
    {
        view.getDrawingRect(_fld01C0);
        offsetDescendantRectToMyCoords(view, _fld01C0);
        int i = computeScrollDeltaToGetChildRectOnScreen(_fld01C0);
        if (i != 0)
        {
            scrollBy(0, i);
        }
    }

    private void _mth141D(MotionEvent motionevent)
    {
        int i = motionevent.getAction() >> 8 & 0xff;
        if (_cls153E._mth02CB(motionevent, i) == _fld157B)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            FF43 = (int)_cls153E._mth02CF(motionevent, i);
            _fld157B = _cls153E._mth02CB(motionevent, i);
            if (_fld14EF != null)
            {
                _fld14EF.clear();
            }
        }
    }

    private boolean _mth14A1()
    {
        View view = getChildAt(0);
        if (view != null)
        {
            int i = view.getHeight();
            return getHeight() < getPaddingTop() + i + getPaddingBottom();
        } else
        {
            return false;
        }
    }

    private int _mth14A2()
    {
        int i = 0;
        if (getChildCount() > 0)
        {
            i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
        }
        return i;
    }

    private void _mth15AE()
    {
        _fld0631 = false;
        if (_fld14EF != null)
        {
            _fld14EF.recycle();
            _fld14EF = null;
        }
        stopNestedScroll();
        if (FEE0 != null)
        {
            FEE0._mth13A5();
            FEE9._mth13A5();
        }
    }

    private void _mth1D4C()
    {
        if (FE70._mth02BC(this) != 2)
        {
            if (FEE0 == null)
            {
                Context context = getContext();
                FEE0 = new _cls1D4A(context);
                FEE9 = new _cls1D4A(context);
                return;
            }
        } else
        {
            FEE0 = null;
            FEE9 = null;
        }
    }

    private void _mth1D54(int i)
    {
        int j = getScrollY();
        boolean flag;
        if ((j > 0 || i > 0) && (j < _mth14A2() || i < 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!dispatchNestedPreFling(0.0F, i))
        {
            dispatchNestedFling(0.0F, i, flag);
            if (flag)
            {
                fling(i);
            }
        }
    }

    public void addView(View view)
    {
        if (getChildCount() > 0)
        {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else
        {
            super.addView(view);
            return;
        }
    }

    public void addView(View view, int i)
    {
        if (getChildCount() > 0)
        {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else
        {
            super.addView(view, i);
            return;
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (getChildCount() > 0)
        {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else
        {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (getChildCount() > 0)
        {
            throw new IllegalStateException("ScrollView can host only one direct child");
        } else
        {
            super.addView(view, layoutparams);
            return;
        }
    }

    public int computeHorizontalScrollExtent()
    {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset()
    {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange()
    {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll()
    {
        if (FEAE.computeScrollOffset())
        {
            int j = getScrollX();
            int k = getScrollY();
            int l = FEAE.getCurrX();
            int i1 = FEAE.getCurrY();
            if (j != l || k != i1)
            {
                int j1 = _mth14A2();
                int i = FE70._mth02BC(this);
                boolean flag;
                if (i == 0 || i == 1 && j1 > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                _mth02CA(l - j, i1 - k, j, k, 0, j1, 0, 0);
                if (flag)
                {
                    _mth1D4C();
                    if (i1 <= 0 && k > 0)
                    {
                        FEE0._mth1D35((int)FEAE.getCurrVelocity());
                        return;
                    }
                    if (i1 >= j1 && k < j1)
                    {
                        FEE9._mth1D35((int)FEAE.getCurrVelocity());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent()
    {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset()
    {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange()
    {
        int j = getChildCount();
        int i = getHeight() - getPaddingBottom() - getPaddingTop();
        if (j == 0)
        {
            return i;
        }
        j = getChildAt(0).getBottom();
        int k = getScrollY();
        int l = Math.max(0, j - i);
        if (k < 0)
        {
            return j - k;
        }
        i = j;
        if (k > l)
        {
            i = j + (k - l);
        }
        return i;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    public boolean dispatchNestedFling(float f, float f1, boolean flag)
    {
        return _fld026B.dispatchNestedFling(f, f1, flag);
    }

    public boolean dispatchNestedPreFling(float f, float f1)
    {
        _cls1D64 _lcls1d64 = _fld026B;
        if (_lcls1d64._fld1E5B && _lcls1d64._fld1E59 != null)
        {
            return _cls14D2._mth02CA(_lcls1d64._fld1E59, _lcls1d64.mView, f, f1);
        } else
        {
            return false;
        }
    }

    public boolean dispatchNestedPreScroll(int i, int j, int ai[], int ai1[])
    {
        return _fld026B.dispatchNestedPreScroll(i, j, ai, ai1);
    }

    public boolean dispatchNestedScroll(int i, int j, int k, int l, int ai[])
    {
        return _fld026B.dispatchNestedScroll(i, j, k, l, ai);
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (FEE0 != null)
        {
            int i = getScrollY();
            if (!FEE0.isFinished())
            {
                int j = canvas.save();
                int l = getWidth();
                int j1 = getPaddingLeft();
                int l1 = getPaddingRight();
                canvas.translate(getPaddingLeft(), Math.min(0, i));
                FEE0.setSize(l - j1 - l1, getHeight());
                if (FEE0.draw(canvas))
                {
                    FE70._mth1FBE(this);
                }
                canvas.restoreToCount(j);
            }
            if (!FEE9.isFinished())
            {
                int k = canvas.save();
                int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
                int k1 = getHeight();
                canvas.translate(-i1 + getPaddingLeft(), Math.max(_mth14A2(), i) + k1);
                canvas.rotate(180F, i1, 0.0F);
                FEE9.setSize(i1, k1);
                if (FEE9.draw(canvas))
                {
                    FE70._mth1FBE(this);
                }
                canvas.restoreToCount(k);
            }
        }
    }

    public final boolean executeKeyEvent(KeyEvent keyevent)
    {
        _fld01C0.setEmpty();
        if (!_mth14A1())
        {
            if (isFocused() && keyevent.getKeyCode() != 4)
            {
                View view = findFocus();
                keyevent = view;
                if (view == this)
                {
                    keyevent = null;
                }
                keyevent = FocusFinder.getInstance().findNextFocus(this, keyevent, 130);
                return keyevent != null && keyevent != this && keyevent.requestFocus(130);
            } else
            {
                return false;
            }
        }
        if (keyevent.getAction() == 0)
        {
            switch (keyevent.getKeyCode())
            {
            default:
                return false;

            case 19: // '\023'
                if (!keyevent.isAltPressed())
                {
                    return arrowScroll(33);
                } else
                {
                    return fullScroll(33);
                }

            case 20: // '\024'
                if (!keyevent.isAltPressed())
                {
                    return arrowScroll(130);
                } else
                {
                    return fullScroll(130);
                }

            case 62: // '>'
                break;
            }
            char c;
            if (keyevent.isShiftPressed())
            {
                c = '!';
            } else
            {
                c = '\202';
            }
            pageScroll(c);
        }
        return false;
    }

    protected float getBottomFadingEdgeStrength()
    {
        if (getChildCount() == 0)
        {
            return 0.0F;
        }
        int i = getVerticalFadingEdgeLength();
        int j = getHeight();
        int k = getPaddingBottom();
        j = getChildAt(0).getBottom() - getScrollY() - (j - k);
        if (j < i)
        {
            return (float)j / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    public int getNestedScrollAxes()
    {
        return _fld01F0._fld1F31;
    }

    protected float getTopFadingEdgeStrength()
    {
        if (getChildCount() == 0)
        {
            return 0.0F;
        }
        int i = getVerticalFadingEdgeLength();
        int j = getScrollY();
        if (j < i)
        {
            return (float)j / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    public boolean hasNestedScrollingParent()
    {
        return _fld026B._fld1E59 != null;
    }

    public boolean isNestedScrollingEnabled()
    {
        return _fld026B._fld1E5B;
    }

    protected void measureChild(View view, int i, int j)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutparams.width), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin + j, marginlayoutparams.width), android.view.View.MeasureSpec.makeMeasureSpec(marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, 0));
    }

    public void onAttachedToWindow()
    {
        FF6A = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if ((_cls153E._mth02CF(motionevent) & 2) != 0)
        {
            switch (motionevent.getAction())
            {
            case 8: // '\b'
                if (!_fld0631)
                {
                    float f = _cls153E._mth141D(motionevent, 9);
                    if (f != 0.0F)
                    {
                        if (_fld0287 == 0.0F)
                        {
                            motionevent = new TypedValue();
                            Context context = getContext();
                            if (!context.getTheme().resolveAttribute(0x101004d, motionevent, true))
                            {
                                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                            }
                            _fld0287 = motionevent.getDimension(context.getResources().getDisplayMetrics());
                        }
                        int i = (int)(f * _fld0287);
                        int k = _mth14A2();
                        int l = getScrollY();
                        i = l - i;
                        int j = i;
                        if (i < 0)
                        {
                            i = 0;
                        } else
                        {
                            i = j;
                            if (j > k)
                            {
                                i = k;
                            }
                        }
                        if (i != l)
                        {
                            super.scrollTo(getScrollX(), i);
                            return true;
                        }
                    }
                }
                break;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 2 && _fld0631)
        {
            return true;
        }
        switch (i & 0xff)
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            break;

        case 2: // '\002'
            int j = _fld157B;
            if (j != -1)
            {
                int i1 = _cls153E._mth02CA(motionevent, j);
                if (i1 == -1)
                {
                    Log.e("NestedScrollView", (new StringBuilder("Invalid pointerId=")).append(j).append(" in onInterceptTouchEvent").toString());
                } else
                {
                    int k = (int)_cls153E._mth02CF(motionevent, i1);
                    if (Math.abs(k - FF43) > _fld0EC0 && (getNestedScrollAxes() & 2) == 0)
                    {
                        _fld0631 = true;
                        FF43 = k;
                        if (_fld14EF == null)
                        {
                            _fld14EF = VelocityTracker.obtain();
                        }
                        _fld14EF.addMovement(motionevent);
                        _fld0139 = 0;
                        motionevent = getParent();
                        if (motionevent != null)
                        {
                            motionevent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
            break;

        case 0: // '\0'
            int j1 = (int)motionevent.getY();
            int l = (int)motionevent.getX();
            boolean flag;
            if (getChildCount() > 0)
            {
                int k1 = getScrollY();
                View view = getChildAt(0);
                if (j1 >= view.getTop() - k1 && j1 < view.getBottom() - k1 && l >= view.getLeft() && l < view.getRight())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _fld0631 = false;
                if (_fld14EF != null)
                {
                    _fld14EF.recycle();
                    _fld14EF = null;
                }
                break;
            }
            FF43 = j1;
            _fld157B = _cls153E._mth02CB(motionevent, 0);
            if (_fld14EF == null)
            {
                _fld14EF = VelocityTracker.obtain();
            } else
            {
                _fld14EF.clear();
            }
            _fld14EF.addMovement(motionevent);
            boolean flag1;
            if (!FEAE.isFinished())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            _fld0631 = flag1;
            startNestedScroll(2);
            break;

        case 1: // '\001'
        case 3: // '\003'
            _fld0631 = false;
            _fld157B = -1;
            if (_fld14EF != null)
            {
                _fld14EF.recycle();
                _fld14EF = null;
            }
            if (FEAE.springBack(getScrollX(), getScrollY(), 0, 0, 0, _mth14A2()))
            {
                FE70._mth1FBE(this);
            }
            stopNestedScroll();
            break;

        case 6: // '\006'
            _mth141D(motionevent);
            break;
        }
        return _fld0631;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        FF69 = false;
        if (FF83 != null && _mth02CA(FF83, this))
        {
            _mth02EE(FF83);
        }
        FF83 = null;
        if (!FF6A)
        {
            if (_fld013B != null)
            {
                scrollTo(getScrollX(), _fld013B._fld03A5);
                _fld013B = null;
            }
            if (getChildCount() > 0)
            {
                i = getChildAt(0).getMeasuredHeight();
            } else
            {
                i = 0;
            }
            i = Math.max(0, i - (l - j - getPaddingBottom() - getPaddingTop()));
            if (getScrollY() > i)
            {
                scrollTo(getScrollX(), i);
            } else
            if (getScrollY() < 0)
            {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        FF6A = true;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (!FF85)
        {
            return;
        }
        if (android.view.View.MeasureSpec.getMode(j) == 0)
        {
            return;
        }
        if (getChildCount() > 0)
        {
            View view = getChildAt(0);
            j = getMeasuredHeight();
            if (view.getMeasuredHeight() < j)
            {
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
                view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutparams.width), android.view.View.MeasureSpec.makeMeasureSpec(j - getPaddingTop() - getPaddingBottom(), 0x40000000));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f1, boolean flag)
    {
        if (!flag)
        {
            _mth1D54((int)f1);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onNestedPreFling(View view, float f, float f1)
    {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int j, int ai[])
    {
    }

    public void onNestedScroll(View view, int i, int j, int k, int l)
    {
        i = getScrollY();
        scrollBy(0, l);
        i = getScrollY() - i;
        dispatchNestedScroll(0, i, 0, l - i, null);
    }

    public void onNestedScrollAccepted(View view, View view1, int i)
    {
        _fld01F0._fld1F31 = i;
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1)
    {
        super.scrollTo(i, j);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        int j;
        if (i == 2)
        {
            j = 130;
        } else
        {
            j = i;
            if (i == 1)
            {
                j = 33;
            }
        }
        View view;
        if (rect == null)
        {
            view = FocusFinder.getInstance().findNextFocus(this, null, j);
        } else
        {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, j);
        }
        if (view == null)
        {
            return false;
        }
        if (!_mth02CB(view, 0, getHeight()))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            return false;
        } else
        {
            return view.requestFocus(j, rect);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        _fld013B = parcelable;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate._fld03A5 = getScrollY();
        return savedstate;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (_fld028B != null)
        {
            _fld028B._mth02CB(this);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        View view = findFocus();
        if (view == null || this == view)
        {
            return;
        }
        if (_mth02CB(view, 0, l))
        {
            view.getDrawingRect(_fld01C0);
            offsetDescendantRectToMyCoords(view, _fld01C0);
            i = computeScrollDeltaToGetChildRectOnScreen(_fld01C0);
            if (i != 0)
            {
                if (FF9D)
                {
                    smoothScrollBy(0, i);
                    return;
                }
                scrollBy(0, i);
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view1, int i)
    {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view)
    {
        _fld01F0._fld1F31 = 0;
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (_fld14EF == null)
        {
            _fld14EF = VelocityTracker.obtain();
        }
        MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
        int i = _cls153E._mth02CA(motionevent);
        if (i == 0)
        {
            _fld0139 = 0;
        }
        motionevent1.offsetLocation(0.0F, _fld0139);
        switch (i)
        {
        case 0: // '\0'
            if (getChildCount() == 0)
            {
                return false;
            }
            boolean flag1;
            if (!FEAE.isFinished())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            _fld0631 = flag1;
            if (flag1)
            {
                ViewParent viewparent = getParent();
                if (viewparent != null)
                {
                    viewparent.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (!FEAE.isFinished())
            {
                FEAE.abortAnimation();
            }
            FF43 = (int)motionevent.getY();
            _fld157B = _cls153E._mth02CB(motionevent, 0);
            startNestedScroll(2);
            break;

        case 2: // '\002'
            int l1 = _cls153E._mth02CA(motionevent, _fld157B);
            if (l1 == -1)
            {
                Log.e("NestedScrollView", (new StringBuilder("Invalid pointerId=")).append(_fld157B).append(" in onTouchEvent").toString());
            } else
            {
                int i2 = (int)_cls153E._mth02CF(motionevent, l1);
                int j = FF43 - i2;
                int i1 = j;
                if (dispatchNestedPreScroll(0, j, _fld0138, _fld0135))
                {
                    i1 = j - _fld0138[1];
                    motionevent1.offsetLocation(0.0F, _fld0135[1]);
                    _fld0139 = _fld0139 + _fld0135[1];
                }
                j = i1;
                if (!_fld0631)
                {
                    j = i1;
                    if (Math.abs(i1) > _fld0EC0)
                    {
                        ViewParent viewparent1 = getParent();
                        if (viewparent1 != null)
                        {
                            viewparent1.requestDisallowInterceptTouchEvent(true);
                        }
                        _fld0631 = true;
                        if (i1 > 0)
                        {
                            j = i1 - _fld0EC0;
                        } else
                        {
                            j = i1 + _fld0EC0;
                        }
                    }
                }
                if (_fld0631)
                {
                    FF43 = i2 - _fld0135[1];
                    int j2 = getScrollY();
                    i2 = _mth14A2();
                    int j1 = FE70._mth02BC(this);
                    boolean flag;
                    if (j1 == 0 || j1 == 1 && i2 > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (_mth02CA(0, j, 0, getScrollY(), 0, i2, 0, 0) && !hasNestedScrollingParent())
                    {
                        _fld14EF.clear();
                    }
                    int k2 = getScrollY() - j2;
                    if (dispatchNestedScroll(0, k2, 0, j - k2, _fld0135))
                    {
                        FF43 = FF43 - _fld0135[1];
                        motionevent1.offsetLocation(0.0F, _fld0135[1]);
                        _fld0139 = _fld0139 + _fld0135[1];
                    } else
                    if (flag)
                    {
                        _mth1D4C();
                        int k1 = j2 + j;
                        if (k1 < 0)
                        {
                            FEE0._mth02CB((float)j / (float)getHeight(), _cls153E._mth02CE(motionevent, l1) / (float)getWidth());
                            if (!FEE9.isFinished())
                            {
                                FEE9._mth13A5();
                            }
                        } else
                        if (k1 > i2)
                        {
                            FEE9._mth02CB((float)j / (float)getHeight(), 1.0F - _cls153E._mth02CE(motionevent, l1) / (float)getWidth());
                            if (!FEE0.isFinished())
                            {
                                FEE0._mth13A5();
                            }
                        }
                        if (FEE0 != null && (!FEE0.isFinished() || !FEE9.isFinished()))
                        {
                            FE70._mth1FBE(this);
                        }
                    }
                }
            }
            break;

        case 1: // '\001'
            if (_fld0631)
            {
                motionevent = _fld14EF;
                motionevent.computeCurrentVelocity(1000, _fld1D10);
                int k = (int)FBE9._mth02CB(motionevent, _fld157B);
                if (Math.abs(k) > _fld1D04)
                {
                    _mth1D54(-k);
                } else
                if (FEAE.springBack(getScrollX(), getScrollY(), 0, 0, 0, _mth14A2()))
                {
                    FE70._mth1FBE(this);
                }
            }
            _fld157B = -1;
            _mth15AE();
            break;

        case 3: // '\003'
            if (_fld0631 && getChildCount() > 0 && FEAE.springBack(getScrollX(), getScrollY(), 0, 0, 0, _mth14A2()))
            {
                FE70._mth1FBE(this);
            }
            _fld157B = -1;
            _mth15AE();
            break;

        case 5: // '\005'
            int l = _cls153E._mth02CB(motionevent);
            FF43 = (int)_cls153E._mth02CF(motionevent, l);
            _fld157B = _cls153E._mth02CB(motionevent, l);
            break;

        case 6: // '\006'
            _mth141D(motionevent);
            FF43 = (int)_cls153E._mth02CF(motionevent, _cls153E._mth02CA(motionevent, _fld157B));
            break;
        }
        if (_fld14EF != null)
        {
            _fld14EF.addMovement(motionevent1);
        }
        motionevent1.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view1)
    {
        if (!FF69)
        {
            _mth02EE(view1);
        } else
        {
            FF83 = view1;
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int i = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean flag1;
        if (i != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            if (flag)
            {
                scrollBy(0, i);
                return flag1;
            }
            smoothScrollBy(0, i);
        }
        return flag1;
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        if (flag && _fld14EF != null)
        {
            _fld14EF.recycle();
            _fld14EF = null;
        }
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        FF69 = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int j)
    {
        if (getChildCount() > 0)
        {
            View view = getChildAt(0);
            int k = getWidth() - getPaddingRight() - getPaddingLeft();
            int l = view.getWidth();
            if (k >= l || i < 0)
            {
                i = 0;
            } else
            if (k + i > l)
            {
                i = l - k;
            }
            k = getHeight() - getPaddingBottom() - getPaddingTop();
            l = view.getHeight();
            if (k >= l || j < 0)
            {
                j = 0;
            } else
            if (k + j > l)
            {
                j = l - k;
            }
            if (i != getScrollX() || j != getScrollY())
            {
                super.scrollTo(i, j);
            }
        }
    }

    public void setFillViewport(boolean flag)
    {
        if (flag != FF85)
        {
            FF85 = flag;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        _cls1D64 _lcls1d64 = _fld026B;
        if (_lcls1d64._fld1E5B)
        {
            FE70._mth1D35(_lcls1d64.mView);
        }
        _lcls1d64._fld1E5B = flag;
    }

    public void setOnScrollChangeListener(_cls02CA _pcls02ca)
    {
        _fld028B = _pcls02ca;
    }

    public void setSmoothScrollingEnabled(boolean flag)
    {
        FF9D = flag;
    }

    public boolean shouldDelayChildPressedState()
    {
        return true;
    }

    public final void smoothScrollBy(int i, int j)
    {
        if (getChildCount() == 0)
        {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - FC62 > 250L)
        {
            i = getHeight();
            int k = getPaddingBottom();
            int l = getPaddingTop();
            k = Math.max(0, getChildAt(0).getHeight() - (i - k - l));
            i = getScrollY();
            j = Math.max(0, Math.min(i + j, k));
            FEAE.startScroll(getScrollX(), i, 0, j - i);
            FE70._mth1FBE(this);
        } else
        {
            if (!FEAE.isFinished())
            {
                FEAE.abortAnimation();
            }
            scrollBy(i, j);
        }
        FC62 = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean startNestedScroll(int i)
    {
        return _fld026B.startNestedScroll(i);
    }

    public void stopNestedScroll()
    {
        _cls1D64 _lcls1d64 = _fld026B;
        if (_lcls1d64._fld1E59 != null)
        {
            _cls14D2._mth02CA(_lcls1d64._fld1E59, _lcls1d64.mView);
            _lcls1d64._fld1E59 = null;
        }
    }

}
