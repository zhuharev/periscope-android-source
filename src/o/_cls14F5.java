// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

// Referenced classes of package o:
//            _cls0716, _cls207F, _cls1541, _cls153F, 
//            _cls157B, _cls1D04, _cls2160, FB61, 
//            _cls0722, _cls13B1, _cls0285, _cls0694, 
//            _cls0EC0, _cls1646, FE70, _cls14AB, 
//            FE9B

public class _cls14F5 extends ViewGroup
    implements _cls0716, _cls207F
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static int _fld153A[];
    private final _cls2160 _fld01F0;
    private int _fld06D2;
    private int _fld0718;
    private _cls0694 _fld071F;
    private _cls0EC0 _fld0931;
    private Drawable _fld098F;
    private boolean _fld0996;
    public boolean _fld0998;
    private boolean _fld09B7;
    private boolean _fld09DD;
    private int _fld0E11;
    private int _fld0E15;
    private final Rect _fld0E19;
    private final Rect _fld0E21;
    private final Rect _fld0E2D;
    private final Rect _fld0E87;
    private final Rect _fld10D4;
    private final Rect _fld10DE;
    private if _fld13D7;
    private final int _fld13DD;
    private FB61 _fld1431;
    private _cls0722 _fld14BA;
    private _cls1646 _fld14EE;
    private final _cls153F _fld1531;
    private final _cls157B _fld1532;
    private final _cls1D04 _fld1539;
    private boolean _fld1FD7;

    public _cls14F5(Context context)
    {
        this(context, null);
    }

    public _cls14F5(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _fld0718 = 0;
        _fld0E19 = new Rect();
        _fld0E21 = new Rect();
        _fld0E2D = new Rect();
        _fld0E87 = new Rect();
        _fld10D4 = new Rect();
        _fld10DE = new Rect();
        _fld13DD = 600;
        _fld1531 = new _cls153F(this);
        _fld1532 = new _cls157B(this);
        _fld1539 = new _cls1D04(this);
        init(context);
        _fld01F0 = new _cls2160(this);
    }

    private void init(Context context)
    {
        TypedArray typedarray = getContext().getTheme().obtainStyledAttributes(_fld153A);
        _fld06D2 = typedarray.getDimensionPixelSize(0, 0);
        _fld098F = typedarray.getDrawable(1);
        boolean flag;
        if (_fld098F == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        typedarray.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld0996 = flag;
        _fld1431 = FB61._mth141D(context);
    }

    static _cls1646 _mth02CA(_cls14F5 _pcls14f5, _cls1646 _pcls1646)
    {
        _pcls14f5._fld14EE = _pcls1646;
        return _pcls1646;
    }

    static void _mth02CA(_cls14F5 _pcls14f5)
    {
        _pcls14f5.FB54();
    }

    private static boolean _mth02CA(FrameLayout framelayout, Rect rect, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        flag = false;
        framelayout = (_cls02CA)framelayout.getLayoutParams();
        if (((_cls02CA) (framelayout)).leftMargin != rect.left)
        {
            flag = true;
            framelayout.leftMargin = rect.left;
        }
        if (((_cls02CA) (framelayout)).topMargin != rect.top)
        {
            flag = true;
            framelayout.topMargin = rect.top;
        }
        if (((_cls02CA) (framelayout)).rightMargin != rect.right)
        {
            flag = true;
            framelayout.rightMargin = rect.right;
        }
        flag1 = flag;
        if (flag2)
        {
            flag1 = flag;
            if (((_cls02CA) (framelayout)).bottomMargin != rect.bottom)
            {
                flag1 = true;
                framelayout.bottomMargin = rect.bottom;
            }
        }
        return flag1;
    }

    static boolean _mth02CA(_cls14F5 _pcls14f5, boolean flag)
    {
        _pcls14f5._fld09DD = false;
        return false;
    }

    static FE9B _mth02CB(_cls14F5 _pcls14f5)
    {
        return _pcls14f5._fld1531;
    }

    static _cls0EC0 _mth02CE(_cls14F5 _pcls14f5)
    {
        return _pcls14f5._fld0931;
    }

    private static _cls0722 _mth144A(View view)
    {
        if (view instanceof _cls0722)
        {
            return (_cls0722)view;
        }
        if (view instanceof Toolbar)
        {
            view = (Toolbar)view;
            if (((Toolbar) (view)).iA == null)
            {
                view.iA = new _cls13B1(view, true);
            }
            return ((Toolbar) (view)).iA;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Can't make a decor toolbar out of ")).append(view.getClass().getSimpleName()).toString());
        }
    }

    private void _mth4E36()
    {
        if (_fld071F == null)
        {
            _fld071F = (_cls0694)findViewById(_cls0285.action_bar_activity_content);
            _fld0931 = (_cls0EC0)findViewById(_cls0285.action_bar_container);
            _fld14BA = _mth144A(findViewById(_cls0285.action_bar));
        }
    }

    private void FB54()
    {
        removeCallbacks(_fld1532);
        removeCallbacks(_fld1539);
        if (_fld14EE != null)
        {
            _fld14EE.cancel();
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof _cls02CA;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (_fld098F != null && !_fld0996)
        {
            int i;
            if (_fld0931.getVisibility() == 0)
            {
                i = (int)((float)_fld0931.getBottom() + FE70._mth02D1(_fld0931) + 0.5F);
            } else
            {
                i = 0;
            }
            _fld098F.setBounds(0, i, getWidth(), _fld098F.getIntrinsicHeight() + i);
            _fld098F.draw(canvas);
        }
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        _mth4E36();
        FE70.FF9E(this);
        boolean flag = _mth02CA(_fld0931, rect, true, true, false, true);
        _fld0E87.set(rect);
        _cls14AB._mth02CA(this, _fld0E87, _fld0E19);
        if (!_fld0E21.equals(_fld0E19))
        {
            flag = true;
            _fld0E21.set(_fld0E19);
        }
        if (flag)
        {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new _cls02CA(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new _cls02CA(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new _cls02CA(layoutparams);
    }

    public int getNestedScrollAxes()
    {
        return _fld01F0._fld1F31;
    }

    public final boolean hideOverflowMenu()
    {
        _mth4E36();
        return _fld14BA.hideOverflowMenu();
    }

    public final boolean isOverflowMenuShowing()
    {
        _mth4E36();
        return _fld14BA.isOverflowMenuShowing();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        FE70._mth02B9(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        FB54();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = getChildCount();
        k = getPaddingLeft();
        getPaddingRight();
        l = getPaddingTop();
        getPaddingBottom();
        for (i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 8)
            {
                _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
                int i1 = view.getMeasuredWidth();
                int j1 = view.getMeasuredHeight();
                int k1 = k + _lcls02ca.leftMargin;
                int l1 = l + _lcls02ca.topMargin;
                view.layout(k1, l1, k1 + i1, l1 + j1);
            }
        }

    }

    protected void onMeasure(int i, int j)
    {
        _mth4E36();
        int k = 0;
        measureChildWithMargins(_fld0931, i, 0, j, 0);
        Object obj = (_cls02CA)_fld0931.getLayoutParams();
        int i2 = Math.max(0, _fld0931.getMeasuredWidth() + ((_cls02CA) (obj)).leftMargin + ((_cls02CA) (obj)).rightMargin);
        int l1 = Math.max(0, _fld0931.getMeasuredHeight() + ((_cls02CA) (obj)).topMargin + ((_cls02CA) (obj)).bottomMargin);
        int k1 = _cls14AB.combineMeasuredStates(0, FE70._mth02CC(_fld0931));
        boolean flag;
        if ((FE70.FF9E(this) & 0x100) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int i1 = _fld06D2;
            k = i1;
            if (_fld09B7)
            {
                k = i1;
                if (_fld0931._fld0475 != null)
                {
                    k = i1 + _fld06D2;
                }
            }
        } else
        if (_fld0931.getVisibility() != 8)
        {
            k = _fld0931.getMeasuredHeight();
        }
        _fld0E2D.set(_fld0E19);
        _fld10D4.set(_fld0E87);
        if (!_fld0998 && !flag)
        {
            obj = _fld0E2D;
            obj.top = ((Rect) (obj)).top + k;
            obj = _fld0E2D;
            obj.bottom = ((Rect) (obj)).bottom;
        } else
        {
            obj = _fld10D4;
            obj.top = ((Rect) (obj)).top + k;
            obj = _fld10D4;
            obj.bottom = ((Rect) (obj)).bottom;
        }
        _mth02CA(_fld071F, _fld0E2D, true, true, true, true);
        if (!_fld10DE.equals(_fld10D4))
        {
            _fld10DE.set(_fld10D4);
            _fld071F._mth02CB(_fld10D4);
        }
        measureChildWithMargins(_fld071F, i, 0, j, 0);
        obj = (_cls02CA)_fld071F.getLayoutParams();
        k = Math.max(i2, _fld071F.getMeasuredWidth() + ((_cls02CA) (obj)).leftMargin + ((_cls02CA) (obj)).rightMargin);
        int l = Math.max(l1, _fld071F.getMeasuredHeight() + ((_cls02CA) (obj)).topMargin + ((_cls02CA) (obj)).bottomMargin);
        int j1 = _cls14AB.combineMeasuredStates(k1, FE70._mth02CC(_fld071F));
        k1 = getPaddingLeft();
        l1 = getPaddingRight();
        l = Math.max(getPaddingTop() + getPaddingBottom() + l, getSuggestedMinimumHeight());
        setMeasuredDimension(FE70.resolveSizeAndState(Math.max(k + (k1 + l1), getSuggestedMinimumWidth()), i, j1), FE70.resolveSizeAndState(l, j, j1 << 16));
    }

    public boolean onNestedFling(View view, float f, float f1, boolean flag)
    {
        if (!_fld1FD7 || !flag)
        {
            return false;
        }
        _fld1431.fling(0, 0, 0, (int)f1, 0, 0, 0x80000000, 0x7fffffff);
        boolean flag1;
        if (_fld1431.getFinalY() > _fld0931.getHeight())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            FB54();
            _fld1539.run();
        } else
        {
            FB54();
            _fld1532.run();
        }
        _fld09DD = true;
        return true;
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
        _fld0E11 = _fld0E11 + j;
        setActionBarHideOffset(_fld0E11);
    }

    public void onNestedScrollAccepted(View view, View view1, int i)
    {
        _fld01F0._fld1F31 = i;
        if (_fld0931 != null)
        {
            i = -(int)FE70._mth02D1(_fld0931);
        } else
        {
            i = 0;
        }
        _fld0E11 = i;
        FB54();
        if (_fld13D7 != null)
        {
            _fld13D7._mth157D();
        }
    }

    public boolean onStartNestedScroll(View view, View view1, int i)
    {
        if ((i & 2) == 0 || _fld0931.getVisibility() != 0)
        {
            return false;
        } else
        {
            return _fld1FD7;
        }
    }

    public void onStopNestedScroll(View view)
    {
        if (_fld1FD7 && !_fld09DD)
        {
            if (_fld0E11 <= _fld0931.getHeight())
            {
                FB54();
                postDelayed(_fld1532, 600L);
                return;
            }
            FB54();
            postDelayed(_fld1539, 600L);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        _mth4E36();
        int j = _fld0E15;
        _fld0E15 = i;
        boolean flag;
        if ((i & 4) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if ((i & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (_fld13D7 != null)
        {
            if if1 = _fld13D7;
            boolean flag2;
            if (!flag1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if1._mth02C9(flag2);
            if (flag || !flag1)
            {
                _fld13D7._mth150B();
            } else
            {
                _fld13D7._mth1551();
            }
        }
        if (((j ^ i) & 0x100) != 0 && _fld13D7 != null)
        {
            FE70._mth02B9(this);
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        _fld0718 = i;
        if (_fld13D7 != null)
        {
            _fld13D7.onWindowVisibilityChanged(i);
        }
    }

    public void setActionBarHideOffset(int i)
    {
        FB54();
        i = Math.max(0, Math.min(i, _fld0931.getHeight()));
        FE70._mth02CB(_fld0931, -i);
    }

    public void setActionBarVisibilityCallback(if if1)
    {
        _fld13D7 = if1;
        if (getWindowToken() != null)
        {
            _fld13D7.onWindowVisibilityChanged(_fld0718);
            if (_fld0E15 != 0)
            {
                onWindowSystemUiVisibilityChanged(_fld0E15);
                FE70._mth02B9(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean flag)
    {
        _fld09B7 = flag;
    }

    public void setHideOnContentScrollEnabled(boolean flag)
    {
        if (flag != _fld1FD7)
        {
            _fld1FD7 = flag;
            if (!flag)
            {
                FB54();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i)
    {
        _mth4E36();
        _fld14BA.setIcon(i);
    }

    public void setIcon(Drawable drawable)
    {
        _mth4E36();
        _fld14BA.setIcon(drawable);
    }

    public void setLogo(int i)
    {
        _mth4E36();
        _fld14BA.setLogo(i);
    }

    public void setMenu(Menu menu, _cls0491.if if1)
    {
        _mth4E36();
        _fld14BA.setMenu(menu, if1);
    }

    public void setMenuPrepared()
    {
        _mth4E36();
        _fld14BA.setMenuPrepared();
    }

    public void setOverlayMode(boolean flag)
    {
        _fld0998 = flag;
        if (flag && getContext().getApplicationInfo().targetSdkVersion < 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld0996 = flag;
    }

    public void setShowingForActionMode(boolean flag)
    {
    }

    public void setUiOptions(int i)
    {
    }

    public void setWindowCallback(android.view.Window.Callback callback)
    {
        _mth4E36();
        _fld14BA.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charsequence)
    {
        _mth4E36();
        _fld14BA.setWindowTitle(charsequence);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public final boolean showOverflowMenu()
    {
        _mth4E36();
        return _fld14BA.showOverflowMenu();
    }

    public final void _mth02EE(int i)
    {
        _mth4E36();
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            _fld14BA.FE9B();
            return;

        case 5: // '\005'
            _fld14BA.FEA9();
            return;

        case 109: // 'm'
            setOverlayMode(true);
            break;
        }
    }

    public final void _mth14BB()
    {
        _mth4E36();
        _fld14BA.dismissPopupMenus();
    }

    public final boolean FB60()
    {
        _mth4E36();
        return _fld14BA.FB60();
    }

    public final boolean FBE6()
    {
        _mth4E36();
        return _fld14BA.FBE6();
    }

    static 
    {
        _fld153A = (new int[] {
            _cls1541.actionBarSize, 0x1010059
        });
    }
}
