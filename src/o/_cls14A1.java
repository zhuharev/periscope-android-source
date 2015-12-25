// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls1424

class _cls14A1 extends Drawable
    implements android.graphics.drawable.Drawable.Callback, _cls1424
{

    static final android.graphics.PorterDuff.Mode _fld026A;
    private ColorStateList _fld027E;
    private android.graphics.PorterDuff.Mode _fld027F;
    private int _fld029F;
    private android.graphics.PorterDuff.Mode _fld02B0;
    private boolean _fld03AA;
    Drawable _fld0407;

    _cls14A1(Drawable drawable)
    {
        _fld027F = _fld026A;
        _mth02BB(drawable);
    }

    private boolean _mth02CA(int ai[])
    {
        if (_fld027E != null && _fld027F != null)
        {
            int i = _fld027E.getColorForState(ai, _fld027E.getDefaultColor());
            ai = _fld027F;
            if (!_fld03AA || i != _fld029F || ai != _fld02B0)
            {
                setColorFilter(i, ai);
                _fld029F = i;
                _fld02B0 = ai;
                _fld03AA = true;
                return true;
            }
        } else
        {
            _fld03AA = false;
            clearColorFilter();
        }
        return false;
    }

    public void draw(Canvas canvas)
    {
        _fld0407.draw(canvas);
    }

    public int getChangingConfigurations()
    {
        return _fld0407.getChangingConfigurations();
    }

    public Drawable getCurrent()
    {
        return _fld0407.getCurrent();
    }

    public int getIntrinsicHeight()
    {
        return _fld0407.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return _fld0407.getIntrinsicWidth();
    }

    public int getMinimumHeight()
    {
        return _fld0407.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return _fld0407.getMinimumWidth();
    }

    public int getOpacity()
    {
        return _fld0407.getOpacity();
    }

    public boolean getPadding(Rect rect)
    {
        return _fld0407.getPadding(rect);
    }

    public int[] getState()
    {
        return _fld0407.getState();
    }

    public Region getTransparentRegion()
    {
        return _fld0407.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable)
    {
        invalidateSelf();
    }

    public boolean isStateful()
    {
        return _fld027E != null && _fld027E.isStateful() || _fld0407.isStateful();
    }

    public Drawable mutate()
    {
        Drawable drawable = _fld0407;
        Drawable drawable1 = drawable.mutate();
        if (drawable1 != drawable)
        {
            _mth02BB(drawable1);
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        _fld0407.setBounds(rect);
    }

    protected boolean onLevelChange(int i)
    {
        return _fld0407.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        scheduleSelf(runnable, l);
    }

    public void setAlpha(int i)
    {
        _fld0407.setAlpha(i);
    }

    public void setChangingConfigurations(int i)
    {
        _fld0407.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        _fld0407.setColorFilter(colorfilter);
    }

    public void setDither(boolean flag)
    {
        _fld0407.setDither(flag);
    }

    public void setFilterBitmap(boolean flag)
    {
        _fld0407.setFilterBitmap(flag);
    }

    public boolean setState(int ai[])
    {
        boolean flag = _fld0407.setState(ai);
        if (_mth02CA(ai) || flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void setTint(int i)
    {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorstatelist)
    {
        _fld027E = colorstatelist;
        _mth02CA(getState());
    }

    public void setTintMode(android.graphics.PorterDuff.Mode mode)
    {
        _fld027F = mode;
        _mth02CA(getState());
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        return super.setVisible(flag, flag1) || _fld0407.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        unscheduleSelf(runnable);
    }

    public void _mth02BB(Drawable drawable)
    {
        if (_fld0407 != null)
        {
            _fld0407.setCallback(null);
        }
        _fld0407 = drawable;
        if (drawable != null)
        {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }

    public Drawable _mth02C6()
    {
        return _fld0407;
    }

    static 
    {
        _fld026A = android.graphics.PorterDuff.Mode.SRC_IN;
    }
}
