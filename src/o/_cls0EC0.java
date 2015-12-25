// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package o:
//            _cls0ABD, _cls068F, _cls1FD1, _cls0285, 
//            FF8C

public class _cls0EC0 extends FrameLayout
{

    private boolean _fld043F;
    FF8C _fld0475;
    private View _fld0492;
    private View _fld04AC;
    Drawable _fld04DF;
    Drawable _fld04F4;
    boolean _fld0506;
    boolean _fld0546;
    private int _fld0575;
    Drawable _fld15BF;

    public _cls0EC0(Context context)
    {
        this(context, null);
    }

    public _cls0EC0(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            obj = new _cls0ABD(this);
        } else
        {
            obj = new _cls068F(this);
        }
        setBackgroundDrawable(((Drawable) (obj)));
        context = context.obtainStyledAttributes(attributeset, _cls1FD1.ActionBar);
        _fld15BF = context.getDrawable(_cls1FD1.ActionBar_background);
        _fld04DF = context.getDrawable(_cls1FD1.ActionBar_backgroundStacked);
        _fld0575 = context.getDimensionPixelSize(_cls1FD1.ActionBar_height, -1);
        if (getId() == _cls0285.split_action_bar)
        {
            _fld0506 = true;
            _fld04F4 = context.getDrawable(_cls1FD1.ActionBar_backgroundSplit);
        }
        context.recycle();
        boolean flag;
        if (_fld0506)
        {
            if (_fld04F4 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (_fld15BF == null && _fld04DF == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (_fld15BF != null && _fld15BF.isStateful())
        {
            _fld15BF.setState(getDrawableState());
        }
        if (_fld04DF != null && _fld04DF.isStateful())
        {
            _fld04DF.setState(getDrawableState());
        }
        if (_fld04F4 != null && _fld04F4.isStateful())
        {
            _fld04F4.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.jumpDrawablesToCurrentState();
            if (_fld15BF != null)
            {
                _fld15BF.jumpToCurrentState();
            }
            if (_fld04DF != null)
            {
                _fld04DF.jumpToCurrentState();
            }
            if (_fld04F4 != null)
            {
                _fld04F4.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        _fld0492 = findViewById(_cls0285.action_bar);
        _fld04AC = findViewById(_cls0285.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return _fld043F || super.onInterceptTouchEvent(motionevent);
    }

    public void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        FF8C ff8c = _fld0475;
        if (ff8c != null && ff8c.getVisibility() != 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ff8c != null && ff8c.getVisibility() != 8)
        {
            j = getMeasuredHeight();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ff8c.getLayoutParams();
            ff8c.layout(i, j - ff8c.getMeasuredHeight() - layoutparams.bottomMargin, k, j - layoutparams.bottomMargin);
        }
        i = 0;
        j = 0;
        if (_fld0506)
        {
            if (_fld04F4 != null)
            {
                _fld04F4.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                i = 1;
            }
        } else
        {
            if (_fld15BF != null)
            {
                if (_fld0492.getVisibility() == 0)
                {
                    _fld15BF.setBounds(_fld0492.getLeft(), _fld0492.getTop(), _fld0492.getRight(), _fld0492.getBottom());
                } else
                if (_fld04AC != null && _fld04AC.getVisibility() == 0)
                {
                    _fld15BF.setBounds(_fld04AC.getLeft(), _fld04AC.getTop(), _fld04AC.getRight(), _fld04AC.getBottom());
                } else
                {
                    _fld15BF.setBounds(0, 0, 0, 0);
                }
                j = 1;
            }
            _fld0546 = flag;
            i = j;
            if (flag)
            {
                i = j;
                if (_fld04DF != null)
                {
                    _fld04DF.setBounds(ff8c.getLeft(), ff8c.getTop(), ff8c.getRight(), ff8c.getBottom());
                    i = 1;
                }
            }
        }
        if (i != 0)
        {
            invalidate();
        }
    }

    public void onMeasure(int i, int j)
    {
        int k = j;
        if (_fld0492 == null)
        {
            k = j;
            if (android.view.View.MeasureSpec.getMode(j) == 0x80000000)
            {
                k = j;
                if (_fld0575 >= 0)
                {
                    k = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(_fld0575, android.view.View.MeasureSpec.getSize(j)), 0x80000000);
                }
            }
        }
        super.onMeasure(i, k);
        if (_fld0492 == null)
        {
            return;
        }
        j = android.view.View.MeasureSpec.getMode(k);
        if (_fld0475 != null && _fld0475.getVisibility() != 8 && j != 0x40000000)
        {
            Object obj = _fld0492;
            if (obj == null || ((View) (obj)).getVisibility() == 8 || ((View) (obj)).getMeasuredHeight() == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0)
            {
                obj = _fld0492;
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
                i = ((View) (obj)).getMeasuredHeight() + layoutparams.topMargin + layoutparams.bottomMargin;
            } else
            {
                obj = _fld04AC;
                if (obj == null || ((View) (obj)).getVisibility() == 8 || ((View) (obj)).getMeasuredHeight() == 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    obj = _fld04AC;
                    android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
                    i = ((View) (obj)).getMeasuredHeight() + layoutparams1.topMargin + layoutparams1.bottomMargin;
                } else
                {
                    i = 0;
                }
            }
            if (j == 0x80000000)
            {
                j = android.view.View.MeasureSpec.getSize(k);
            } else
            {
                j = 0x7fffffff;
            }
            k = getMeasuredWidth();
            obj = _fld0475;
            android.widget.FrameLayout.LayoutParams layoutparams2 = (android.widget.FrameLayout.LayoutParams)((View) (obj)).getLayoutParams();
            setMeasuredDimension(k, Math.min(i + (((View) (obj)).getMeasuredHeight() + layoutparams2.topMargin + layoutparams2.bottomMargin), j));
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable)
    {
        if (_fld15BF != null)
        {
            _fld15BF.setCallback(null);
            unscheduleDrawable(_fld15BF);
        }
        _fld15BF = drawable;
        if (drawable != null)
        {
            drawable.setCallback(this);
            if (_fld0492 != null)
            {
                _fld15BF.setBounds(_fld0492.getLeft(), _fld0492.getTop(), _fld0492.getRight(), _fld0492.getBottom());
            }
        }
        boolean flag;
        if (_fld0506)
        {
            if (_fld04F4 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (_fld15BF == null && _fld04DF == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable)
    {
        if (_fld04F4 != null)
        {
            _fld04F4.setCallback(null);
            unscheduleDrawable(_fld04F4);
        }
        _fld04F4 = drawable;
        if (drawable != null)
        {
            drawable.setCallback(this);
            if (_fld0506 && _fld04F4 != null)
            {
                _fld04F4.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        boolean flag;
        if (_fld0506)
        {
            if (_fld04F4 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (_fld15BF == null && _fld04DF == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable)
    {
        if (_fld04DF != null)
        {
            _fld04DF.setCallback(null);
            unscheduleDrawable(_fld04DF);
        }
        _fld04DF = drawable;
        if (drawable != null)
        {
            drawable.setCallback(this);
            if (_fld0546 && _fld04DF != null)
            {
                _fld04DF.setBounds(_fld0475.getLeft(), _fld0475.getTop(), _fld0475.getRight(), _fld0475.getBottom());
            }
        }
        boolean flag;
        if (_fld0506)
        {
            if (_fld04F4 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (_fld15BF == null && _fld04DF == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setTabContainer(FF8C ff8c)
    {
        if (_fld0475 != null)
        {
            removeView(_fld0475);
        }
        _fld0475 = ff8c;
        if (ff8c != null)
        {
            addView(ff8c);
            android.view.ViewGroup.LayoutParams layoutparams = ff8c.getLayoutParams();
            layoutparams.width = -1;
            layoutparams.height = -2;
            ff8c.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean flag)
    {
        _fld043F = flag;
        int i;
        if (flag)
        {
            i = 0x60000;
        } else
        {
            i = 0x40000;
        }
        setDescendantFocusability(i);
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (_fld15BF != null)
        {
            _fld15BF.setVisible(flag, false);
        }
        if (_fld04DF != null)
        {
            _fld04DF.setVisible(flag, false);
        }
        if (_fld04F4 != null)
        {
            _fld04F4.setVisible(flag, false);
        }
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback)
    {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return drawable == _fld15BF && !_fld0506 || drawable == _fld04DF && _fld0546 || drawable == _fld04F4 && _fld0506 || super.verifyDrawable(drawable);
    }
}
