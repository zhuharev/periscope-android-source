// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1506, _cls30FD, _cls309D, _cls30FC, 
//            FE79

final class _cls1ECA extends Drawable
    implements Animatable
{
    /* member class not found */
    class if {}


    private static final LinearInterpolator _fld06D5 = new LinearInterpolator();
    private static final _cls1506 _fld0715 = new _cls1506();
    private final int _fld09A3[] = {
        0xff000000
    };
    private final ArrayList _fld0E08 = new ArrayList();
    final if _fld0E41;
    float _fld0E46;
    private Resources _fld13AB;
    private View _fld13B1;
    private _cls309D _fld13D3;
    private float _fld14A6;
    private double _fld14A8;
    private double _fld14AB;
    boolean _fld159F;
    private final _cls30FD _fld1607 = new _cls30FD(this);

    public _cls1ECA(Context context, FE79 fe79)
    {
        _fld13B1 = fe79;
        _fld13AB = context.getResources();
        _fld0E41 = new if(_fld1607);
        context = _fld0E41;
        context._fld1D5D = _fld09A3;
        context._fld1D66 = 0;
        context._fld029F = ((if) (context))._fld1D5D[((if) (context))._fld1D66];
        _mth1D4E(1);
        context = _fld0E41;
        fe79 = new _cls309D(this, context);
        fe79.setRepeatCount(-1);
        fe79.setRepeatMode(1);
        fe79.setInterpolator(_fld06D5);
        fe79.setAnimationListener(new _cls30FC(this, context));
        _fld13D3 = fe79;
    }

    static float _mth02CA(_cls1ECA _pcls1eca)
    {
        return _pcls1eca._fld14A6;
    }

    static float _mth02CA(_cls1ECA _pcls1eca, float f)
    {
        _pcls1eca._fld14A6 = f;
        return f;
    }

    static float _mth02CA(_cls1ECA _pcls1eca, if if1)
    {
        return (float)Math.toRadians((double)if1.mStrokeWidth / (if1._fld4EA0 * 6.2831853071795862D));
    }

    private void _mth02CA(double d, double d1, double d2, double d3, float f, float f1)
    {
        if if1 = _fld0E41;
        float f2 = _fld13AB.getDisplayMetrics().density;
        _fld14A8 = (double)f2 * d;
        _fld14AB = (double)f2 * d1;
        float f3 = (float)d3 * f2;
        if1.mStrokeWidth = f3;
        if1.mPaint.setStrokeWidth(f3);
        if1._fld1D3C.invalidateDrawable(null);
        if1._fld4EA0 = d2 * (double)f2;
        if1._fld1D66 = 0;
        if1._fld029F = if1._fld1D5D[if1._fld1D66];
        if1._fld51AB = (int)(f * f2);
        if1.FB3C = (int)(f1 * f2);
        f = Math.min((int)_fld14A8, (int)_fld14AB);
        if (if1._fld4EA0 <= 0.0D || f < 0.0F)
        {
            f = FloatMath.ceil(if1.mStrokeWidth / 2.0F);
        } else
        {
            f = (float)((double)(f / 2.0F) - if1._fld4EA0);
        }
        if1._fld1D5A = f;
    }

    private void _mth02CA(float f, if if1)
    {
        if (f > 0.75F)
        {
            f = (f - 0.75F) / 0.25F;
            int j = if1._fld1D5D[if1._fld1D66];
            int i = if1._fld1D5D[(if1._fld1D66 + 1) % if1._fld1D5D.length];
            int i1 = Integer.valueOf(j).intValue();
            j = i1 >>> 24;
            int k = i1 >> 16 & 0xff;
            int l = i1 >> 8 & 0xff;
            i1 &= 0xff;
            i = Integer.valueOf(i).intValue();
            if1._fld029F = (int)((float)((i >>> 24) - j) * f) + j << 24 | (int)((float)((i >> 16 & 0xff) - k) * f) + k << 16 | (int)((float)((i >> 8 & 0xff) - l) * f) + l << 8 | (int)((float)((i & 0xff) - i1) * f) + i1;
        }
    }

    static void _mth02CA(_cls1ECA _pcls1eca, float f, if if1)
    {
        _pcls1eca._mth02CA(f, if1);
        float f1 = (float)(Math.floor(if1._fld3033 / 0.8F) + 1.0D);
        float f2 = (float)Math.toRadians((double)if1.mStrokeWidth / (if1._fld4EA0 * 6.2831853071795862D));
        if1._fld1D4D = if1._fld1E8B + (if1._fld1E8D - f2 - if1._fld1E8B) * f;
        if1._fld1D3C.invalidateDrawable(null);
        if1._fld1D50 = if1._fld1E8D;
        if1._fld1D3C.invalidateDrawable(null);
        if1._fld0E46 = if1._fld3033 + (f1 - if1._fld3033) * f;
        if1._fld1D3C.invalidateDrawable(null);
    }

    static void _mth02CB(_cls1ECA _pcls1eca, float f, if if1)
    {
        _pcls1eca._mth02CA(f, if1);
    }

    static Interpolator _mth1424()
    {
        return _fld0715;
    }

    public final void draw(Canvas canvas)
    {
        Rect rect = getBounds();
        int i = canvas.save();
        canvas.rotate(_fld0E46, rect.exactCenterX(), rect.exactCenterY());
        if if1 = _fld0E41;
        RectF rectf = if1._fld1D2E;
        rectf.set(rect);
        rectf.inset(if1._fld1D5A, if1._fld1D5A);
        float f = (if1._fld1D4D + if1._fld0E46) * 360F;
        float f1 = (if1._fld1D50 + if1._fld0E46) * 360F - f;
        if1.mPaint.setColor(if1._fld029F);
        canvas.drawArc(rectf, f, f1, false, if1.mPaint);
        if (if1._fld3035)
        {
            if (if1._fld30CE == null)
            {
                if1._fld30CE = new Path();
                if1._fld30CE.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            } else
            {
                if1._fld30CE.reset();
            }
            float f2 = (int)if1._fld1D5A / 2;
            float f3 = if1._fld4E85;
            float f4 = (float)(if1._fld4EA0 * Math.cos(0.0D) + (double)rect.exactCenterX());
            float f5 = (float)(if1._fld4EA0 * Math.sin(0.0D) + (double)rect.exactCenterY());
            if1._fld30CE.moveTo(0.0F, 0.0F);
            if1._fld30CE.lineTo((float)if1._fld51AB * if1._fld4E85, 0.0F);
            if1._fld30CE.lineTo(((float)if1._fld51AB * if1._fld4E85) / 2.0F, (float)if1.FB3C * if1._fld4E85);
            if1._fld30CE.offset(f4 - f2 * f3, f5);
            if1._fld30CE.close();
            if1._fld1D33.setColor(if1._fld029F);
            canvas.rotate((f + f1) - 5F, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(if1._fld30CE, if1._fld1D33);
        }
        if (if1.FB83 < 255)
        {
            if1.FB85.setColor(if1.FC60);
            if1.FB85.setAlpha(255 - if1.FB83);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, if1.FB85);
        }
        canvas.restoreToCount(i);
    }

    public final int getAlpha()
    {
        return _fld0E41.FB83;
    }

    public final int getIntrinsicHeight()
    {
        return (int)_fld14AB;
    }

    public final int getIntrinsicWidth()
    {
        return (int)_fld14A8;
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final boolean isRunning()
    {
        ArrayList arraylist = _fld0E08;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Animation animation = (Animation)arraylist.get(i);
            if (animation.hasStarted() && !animation.hasEnded())
            {
                return true;
            }
        }

        return false;
    }

    public final void setAlpha(int i)
    {
        _fld0E41.FB83 = i;
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        if if1 = _fld0E41;
        if1.mPaint.setColorFilter(colorfilter);
        if1._fld1D3C.invalidateDrawable(null);
    }

    public final void start()
    {
        _fld13D3.reset();
        if if1 = _fld0E41;
        if1._fld1E8B = if1._fld1D4D;
        if1._fld1E8D = if1._fld1D50;
        if1._fld3033 = if1._fld0E46;
        if (_fld0E41._fld1D50 != _fld0E41._fld1D4D)
        {
            _fld159F = true;
            _fld13D3.setDuration(666L);
            _fld13B1.startAnimation(_fld13D3);
            return;
        } else
        {
            if if2 = _fld0E41;
            if2._fld1D66 = 0;
            if2._fld029F = if2._fld1D5D[if2._fld1D66];
            if2 = _fld0E41;
            if2._fld1E8B = 0.0F;
            if2._fld1E8D = 0.0F;
            if2._fld3033 = 0.0F;
            if2._fld1D4D = 0.0F;
            if2._fld1D3C.invalidateDrawable(null);
            if2._fld1D50 = 0.0F;
            if2._fld1D3C.invalidateDrawable(null);
            if2._fld0E46 = 0.0F;
            if2._fld1D3C.invalidateDrawable(null);
            _fld13D3.setDuration(1332L);
            _fld13B1.startAnimation(_fld13D3);
            return;
        }
    }

    public final void stop()
    {
        _fld13B1.clearAnimation();
        _fld0E46 = 0.0F;
        invalidateSelf();
        if if1 = _fld0E41;
        if (if1._fld3035)
        {
            if1._fld3035 = false;
            if1._fld1D3C.invalidateDrawable(null);
        }
        if1 = _fld0E41;
        if1._fld1D66 = 0;
        if1._fld029F = if1._fld1D5D[if1._fld1D66];
        if1 = _fld0E41;
        if1._fld1E8B = 0.0F;
        if1._fld1E8D = 0.0F;
        if1._fld3033 = 0.0F;
        if1._fld1D4D = 0.0F;
        if1._fld1D3C.invalidateDrawable(null);
        if1._fld1D50 = 0.0F;
        if1._fld1D3C.invalidateDrawable(null);
        if1._fld0E46 = 0.0F;
        if1._fld1D3C.invalidateDrawable(null);
    }

    public final void _mth02BD(float f)
    {
        if if1 = _fld0E41;
        if (f != if1._fld4E85)
        {
            if1._fld4E85 = f;
            if1._fld1D3C.invalidateDrawable(null);
        }
    }

    public final void _mth02CE(float f, float f1)
    {
        if if1 = _fld0E41;
        if1._fld1D4D = 0.0F;
        if1._fld1D3C.invalidateDrawable(null);
        if1 = _fld0E41;
        if1._fld1D50 = f1;
        if1._fld1D3C.invalidateDrawable(null);
    }

    public final void _mth037A(boolean flag)
    {
        if if1 = _fld0E41;
        if (if1._fld3035 != flag)
        {
            if1._fld3035 = flag;
            if1._fld1D3C.invalidateDrawable(null);
        }
    }

    public final void _mth1D4E(int i)
    {
        if (i == 0)
        {
            _mth02CA(56D, 56D, 12.5D, 3D, 12F, 6F);
            return;
        } else
        {
            _mth02CA(40D, 40D, 8.75D, 2.5D, 10F, 5F);
            return;
        }
    }

}
