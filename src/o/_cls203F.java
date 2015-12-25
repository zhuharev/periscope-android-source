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
//            _cls02D0

public class _cls203F extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private Drawable _fld0407;

    public _cls203F(Drawable drawable)
    {
        _mth02BB(drawable);
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

    public boolean isAutoMirrored()
    {
        return _cls02D0._mth02CE(_fld0407);
    }

    public boolean isStateful()
    {
        return _fld0407.isStateful();
    }

    public void jumpToCurrentState()
    {
        _cls02D0._mth02CB(_fld0407);
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

    public void setAutoMirrored(boolean flag)
    {
        _cls02D0._mth02CA(_fld0407, flag);
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

    public void setHotspot(float f, float f1)
    {
        _cls02D0._mth02CA(_fld0407, f, f1);
    }

    public void setHotspotBounds(int i, int j, int k, int l)
    {
        _cls02D0._mth02CA(_fld0407, i, j, k, l);
    }

    public boolean setState(int ai[])
    {
        return _fld0407.setState(ai);
    }

    public void setTint(int i)
    {
        _cls02D0._mth02CA(_fld0407, i);
    }

    public void setTintList(ColorStateList colorstatelist)
    {
        _cls02D0._mth02CA(_fld0407, colorstatelist);
    }

    public void setTintMode(android.graphics.PorterDuff.Mode mode)
    {
        _cls02D0._mth02CA(_fld0407, mode);
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
    }
}
