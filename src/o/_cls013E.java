// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package o:
//            _cls05E5, _cls1D64, _cls1FD1, _cls03F3, 
//            FE70, _cls02E0

public class _cls013E extends _cls05E5
    implements _cls05DA.if, android.view.View.OnClickListener, android.view.View.OnLongClickListener, _cls1D3A.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private CharSequence mTitle;
    private _cls03F3 _fld0E25;
    private _cls02E0._cls02CA _fld0E2B;
    private if _fld0E42;
    private _cls02CA _fld0E44;
    private Drawable _fld0EB2;
    private boolean _fld10C1;
    private boolean _fld10EB;
    private int _fld1435;
    private int _fld1448;
    private int _fld148F;

    public _cls013E(Context context)
    {
        this(context, null);
    }

    public _cls013E(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls013E(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Resources resources = context.getResources();
        _fld10C1 = resources.getBoolean(_cls1D64.abc_config_allowActionMenuItemTextWithIcon);
        context = context.obtainStyledAttributes(attributeset, _cls1FD1.ActionMenuItemView, i, 0);
        _fld1435 = context.getDimensionPixelSize(_cls1FD1.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        _fld148F = (int)(32F * resources.getDisplayMetrics().density + 0.5F);
        setOnClickListener(this);
        setOnLongClickListener(this);
        _fld1448 = -1;
    }

    static _cls02CA _mth02CA(_cls013E _pcls013e)
    {
        return _pcls013e._fld0E44;
    }

    static _cls02E0._cls02CA _mth02CB(_cls013E _pcls013e)
    {
        return _pcls013e._fld0E2B;
    }

    static _cls03F3 _mth02CE(_cls013E _pcls013e)
    {
        return _pcls013e._fld0E25;
    }

    private void _mth0399()
    {
        boolean flag;
        boolean flag2;
label0:
        {
label1:
            {
                if (!TextUtils.isEmpty(mTitle))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (_fld0EB2 != null)
                {
                    boolean flag1;
                    if ((_fld0E25.FE95 & 4) == 4)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag1 || !_fld10C1 && !_fld10EB)
                    {
                        break label1;
                    }
                }
                flag2 = true;
                break label0;
            }
            flag2 = false;
        }
        CharSequence charsequence;
        if (flag & flag2)
        {
            charsequence = mTitle;
        } else
        {
            charsequence = null;
        }
        setText(charsequence);
    }

    public void onClick(View view)
    {
        if (_fld0E2B != null)
        {
            _fld0E2B._mth02CF(_fld0E25);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        _fld10C1 = getContext().getResources().getBoolean(_cls1D64.abc_config_allowActionMenuItemTextWithIcon);
        _mth0399();
    }

    public boolean onLongClick(View view)
    {
        boolean flag;
        if (!TextUtils.isEmpty(getText()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return false;
        }
        int ai[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int i = getWidth();
        int k = getHeight();
        int l = ai[1];
        int i1 = k / 2;
        int j = ai[0] + i / 2;
        i = j;
        if (FE70._mth02C9(view) == 0)
        {
            i = context.getResources().getDisplayMetrics().widthPixels - j;
        }
        view = Toast.makeText(context, _fld0E25.getTitle(), 0);
        if (l + i1 < rect.height())
        {
            view.setGravity(0x800035, i, (ai[1] + k) - rect.top);
        } else
        {
            view.setGravity(81, 0, k);
        }
        view.show();
        return true;
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag;
        if (!TextUtils.isEmpty(getText()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && _fld1448 >= 0)
        {
            super.setPadding(_fld1448, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        int l = getMeasuredWidth();
        if (k == 0x80000000)
        {
            i = Math.min(i, _fld1435);
        } else
        {
            i = _fld1435;
        }
        if (k != 0x40000000 && _fld1435 > 0 && l < i)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), j);
        }
        if (!flag && _fld0EB2 != null)
        {
            super.setPadding((getMeasuredWidth() - _fld0EB2.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (_fld0E25.hasSubMenu() && _fld0E42 != null && _fld0E42.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setCheckable(boolean flag)
    {
    }

    public void setChecked(boolean flag)
    {
    }

    public void setExpandedFormat(boolean flag)
    {
        if (_fld10EB != flag)
        {
            _fld10EB = flag;
            if (_fld0E25 != null)
            {
                _cls02E0 _lcls02e0 = _fld0E25.FB30;
                _lcls02e0._fld1F3F = true;
                _lcls02e0.FF9E(true);
            }
        }
    }

    public void setIcon(Drawable drawable)
    {
        _fld0EB2 = drawable;
        if (drawable != null)
        {
            int l = drawable.getIntrinsicWidth();
            int k = drawable.getIntrinsicHeight();
            int i = l;
            int j = k;
            if (l > _fld148F)
            {
                float f = (float)_fld148F / (float)l;
                i = _fld148F;
                j = (int)((float)k * f);
            }
            l = i;
            k = j;
            if (j > _fld148F)
            {
                float f1 = (float)_fld148F / (float)j;
                k = _fld148F;
                l = (int)((float)i * f1);
            }
            drawable.setBounds(0, 0, l, k);
        }
        setCompoundDrawables(drawable, null, null, null);
        _mth0399();
    }

    public void setItemInvoker(_cls02E0._cls02CA _pcls02ca)
    {
        _fld0E2B = _pcls02ca;
    }

    public void setPadding(int i, int j, int k, int l)
    {
        _fld1448 = i;
        super.setPadding(i, j, k, l);
    }

    public void setPopupCallback(_cls02CA _pcls02ca)
    {
        _fld0E44 = _pcls02ca;
    }

    public void setShortcut(boolean flag, char c)
    {
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        setContentDescription(mTitle);
        _mth0399();
    }

    public final boolean _mth02BA()
    {
        return true;
    }

    public final void _mth02CA(_cls03F3 _pcls03f3, int i)
    {
        _fld0E25 = _pcls03f3;
        setIcon(_pcls03f3.getIcon());
        CharSequence charsequence;
        if (this != null && _mth02BA())
        {
            charsequence = _pcls03f3.getTitleCondensed();
        } else
        {
            charsequence = _pcls03f3.getTitle();
        }
        setTitle(charsequence);
        setId(_pcls03f3.getItemId());
        if (_pcls03f3.isVisible())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        setVisibility(i);
        setEnabled(_pcls03f3.isEnabled());
        if (_pcls03f3.hasSubMenu() && _fld0E42 == null)
        {
            _fld0E42 = new if();
        }
    }

    public final boolean _mth0406()
    {
        boolean flag;
        if (!TextUtils.isEmpty(getText()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && _fld0E25.getIcon() == null;
    }

    public final boolean _mth0456()
    {
        return !TextUtils.isEmpty(getText());
    }

    public final _cls03F3 FEE7()
    {
        return _fld0E25;
    }
}
