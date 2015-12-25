// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

// Referenced classes of package o:
//            FBE6, _cls1541, _cls09A3, _cls1FD1, 
//            _cls0715, FB33, FB59, _cls0296

public class _cls0295 extends Spinner
    implements FBE6
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final boolean ad;
    private static final boolean ae;
    private static final int af[] = {
        0x10102f1
    };
    private _cls0715 E;
    private FB33 F;
    private _cls1E3B._cls02CA ag;
    private SpinnerAdapter ah;
    private boolean ai;
    private _cls02CA aj;
    private int ak;
    private final Rect _fld01C0;
    private Context _fld039A;

    public _cls0295(Context context)
    {
        this(context, null);
    }

    public _cls0295(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.spinnerStyle);
    }

    public _cls0295(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, -1);
    }

    public _cls0295(Context context, AttributeSet attributeset, int i, int j)
    {
        this(context, attributeset, i, j, null);
    }

    public _cls0295(Context context, AttributeSet attributeset, int i, int j, android.content.res.Resources.Theme theme)
    {
        Object obj;
        _cls09A3 _lcls09a3;
        int l;
        super(context, attributeset, i);
        _fld01C0 = new Rect();
        _lcls09a3 = new _cls09A3(context, context.obtainStyledAttributes(attributeset, o._cls1FD1.Spinner, i, 0));
        if (_lcls09a3.E == null)
        {
            _lcls09a3.E = _cls0715._mth1FBE(_lcls09a3.mContext);
        }
        E = _lcls09a3.E;
        F = new FB33(this, E);
        if (theme != null)
        {
            theme = new FB59(context, theme);
        } else
        {
            int k = _cls1FD1.Spinner_popupTheme;
            k = _lcls09a3.hU.getResourceId(k, 0);
            if (k != 0)
            {
                theme = new FB59(context, k);
            } else
            if (!ad)
            {
                theme = context;
            } else
            {
                theme = null;
            }
        }
        _fld039A = theme;
        if (_fld039A == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        l = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj = null;
        theme = null;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, af, i, 0);
        context = typedarray;
        l = j;
        theme = context;
        obj = context;
        if (!typedarray.hasValue(0))
        {
            break MISSING_BLOCK_LABEL_242;
        }
        theme = context;
        obj = context;
        l = context.getInt(0, 0);
        int i1;
        i1 = l;
        if (context != null)
        {
            context.recycle();
            break MISSING_BLOCK_LABEL_315;
        }
        break MISSING_BLOCK_LABEL_305;
        context;
        obj = theme;
        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", context);
        i1 = j;
        if (theme != null)
        {
            theme.recycle();
            l = j;
            break MISSING_BLOCK_LABEL_315;
        }
        break MISSING_BLOCK_LABEL_305;
        context;
        if (obj != null)
        {
            ((TypedArray) (obj)).recycle();
        }
        throw context;
        l = i1;
        break MISSING_BLOCK_LABEL_315;
        l = 1;
        if (l == 1)
        {
            context = new _cls02CA(_fld039A, attributeset, i);
            theme = _fld039A;
            theme = new _cls09A3(theme, theme.obtainStyledAttributes(attributeset, o._cls1FD1.Spinner, i, 0));
            j = _cls1FD1.Spinner_android_dropDownWidth;
            ak = ((_cls09A3) (theme)).hU.getLayoutDimension(j, -2);
            context.setBackgroundDrawable(theme.getDrawable(_cls1FD1.Spinner_android_popupBackground));
            j = _cls1FD1.Spinner_android_prompt;
            context._mth037A(_lcls09a3.hU.getString(j));
            ((_cls09A3) (theme)).hU.recycle();
            aj = context;
            ag = new _cls0296(this, this, context);
        }
        _lcls09a3.hU.recycle();
        ai = true;
        if (ah != null)
        {
            setAdapter(ah);
            ah = null;
        }
        F._mth02CA(attributeset, i);
        return;
    }

    private int _mth02CA(SpinnerAdapter spinneradapter, Drawable drawable)
    {
        if (spinneradapter == null)
        {
            return 0;
        }
        int i = 0;
        View view = null;
        int k = 0;
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int j = Math.max(0, getSelectedItemPosition());
        int l1 = Math.min(spinneradapter.getCount(), j + 15);
        for (j = Math.max(0, j - (15 - (l1 - j))); j < l1;)
        {
            int i1 = spinneradapter.getItemViewType(j);
            int l = k;
            if (i1 != k)
            {
                l = i1;
                view = null;
            }
            view = spinneradapter.getView(j, view, this);
            if (view.getLayoutParams() == null)
            {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(j1, k1);
            i = Math.max(i, view.getMeasuredWidth());
            j++;
            k = l;
        }

        j = i;
        if (drawable != null)
        {
            drawable.getPadding(_fld01C0);
            j = i + (_fld01C0.left + _fld01C0.right);
        }
        return j;
    }

    static int _mth02CA(_cls0295 _pcls0295, SpinnerAdapter spinneradapter, Drawable drawable)
    {
        return _pcls0295._mth02CA(spinneradapter, drawable);
    }

    static _cls02CA _mth02CA(_cls0295 _pcls0295)
    {
        return _pcls0295.aj;
    }

    static Rect _mth02CB(_cls0295 _pcls0295)
    {
        return _pcls0295._fld01C0;
    }

    static int _mth02CE(_cls0295 _pcls0295)
    {
        return _pcls0295.ak;
    }

    static boolean _mth1425()
    {
        return ad;
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (F != null)
        {
            F._mth05E8();
        }
    }

    public int getDropDownHorizontalOffset()
    {
        if (aj != null)
        {
            return aj.getHorizontalOffset();
        }
        if (ae)
        {
            return super.getDropDownHorizontalOffset();
        } else
        {
            return 0;
        }
    }

    public int getDropDownVerticalOffset()
    {
        if (aj != null)
        {
            return aj.getVerticalOffset();
        }
        if (ae)
        {
            return super.getDropDownVerticalOffset();
        } else
        {
            return 0;
        }
    }

    public int getDropDownWidth()
    {
        if (aj != null)
        {
            return ak;
        }
        if (ae)
        {
            return super.getDropDownWidth();
        } else
        {
            return 0;
        }
    }

    public Drawable getPopupBackground()
    {
        if (aj != null)
        {
            return aj.getBackground();
        }
        if (ae)
        {
            return super.getPopupBackground();
        } else
        {
            return null;
        }
    }

    public Context getPopupContext()
    {
        if (aj != null)
        {
            return _fld039A;
        }
        if (ad)
        {
            return super.getPopupContext();
        } else
        {
            return null;
        }
    }

    public CharSequence getPrompt()
    {
        if (aj != null)
        {
            return aj._mth1483();
        } else
        {
            return super.getPrompt();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (aj != null && aj.isShowing())
        {
            aj.dismiss();
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (aj != null && android.view.View.MeasureSpec.getMode(i) == 0x80000000)
        {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), _mth02CA(getAdapter(), getBackground())), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (ag != null && ag.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public boolean performClick()
    {
        if (aj != null && !aj.isShowing())
        {
            aj.show();
            return true;
        } else
        {
            return super.performClick();
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((SpinnerAdapter)adapter);
    }

    public void setAdapter(SpinnerAdapter spinneradapter)
    {
        if (!ai)
        {
            ah = spinneradapter;
            return;
        }
        super.setAdapter(spinneradapter);
        if (aj != null)
        {
            Context context;
            if (_fld039A == null)
            {
                context = getContext();
            } else
            {
                context = _fld039A;
            }
            aj.setAdapter(new if(spinneradapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        if (F != null)
        {
            F._mth02BC(drawable);
        }
    }

    public void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        if (F != null)
        {
            F._mth1D55(i);
        }
    }

    public void setDropDownHorizontalOffset(int i)
    {
        if (aj != null)
        {
            aj.setHorizontalOffset(i);
            return;
        }
        if (ae)
        {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i)
    {
        if (aj != null)
        {
            aj.setVerticalOffset(i);
            return;
        }
        if (ae)
        {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i)
    {
        if (aj != null)
        {
            ak = i;
            return;
        }
        if (ae)
        {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable)
    {
        if (aj != null)
        {
            aj.setBackgroundDrawable(drawable);
            return;
        }
        if (ae)
        {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i)
    {
        setPopupBackgroundDrawable(getPopupContext().getDrawable(i));
    }

    public void setPrompt(CharSequence charsequence)
    {
        if (aj != null)
        {
            aj._mth037A(charsequence);
            return;
        } else
        {
            super.setPrompt(charsequence);
            return;
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintList(colorstatelist);
        }
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (F != null)
        {
            F.setSupportBackgroundTintMode(mode);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ad = flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ae = flag;
    }
}
