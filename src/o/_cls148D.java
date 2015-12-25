// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;

// Referenced classes of package o:
//            _cls0EB2, _cls30CE, _cls14D7, _cls1D3C, 
//            _cls4EA0, _cls06BA, _cls0264

public class _cls148D extends _cls0EB2
    implements _cls14D7._cls02CA
{
    /* member class not found */
    class if {}


    private int kX;
    boolean ni;
    public final if pF;
    public final _cls30CE pG;
    final _cls14D7 pH;
    private boolean pI;
    private boolean pJ;
    private boolean pK;
    private int pL;
    private final Paint paint;
    private final Rect pe;
    private boolean pf;

    public _cls148D(Context context, _cls30CE.if if1, _cls06BA _pcls06ba, _cls0264 _pcls0264, int i, int j, _cls4EA0 _pcls4ea0, 
            byte abyte0[], Bitmap bitmap)
    {
        this(new if(_pcls4ea0, abyte0, context, _pcls0264, i, j, if1, _pcls06ba, bitmap));
    }

    _cls148D(if if1)
    {
        pe = new Rect();
        pK = true;
        pL = -1;
        if (if1 == null)
        {
            throw new NullPointerException("GifState must not be null");
        } else
        {
            pF = if1;
            pG = new _cls30CE(if1.kD);
            paint = new Paint();
            pG._mth02CA(if1.pM, if1.data);
            pH = new _cls14D7(if1.context, this, pG, if1.pO, if1.pP);
            return;
        }
    }

    private void reset()
    {
        _cls14D7 _lcls14d7 = pH;
        _lcls14d7.pI = false;
        if (_lcls14d7.pY != null)
        {
            _cls1D3C._mth02CA(_lcls14d7.pY);
            _lcls14d7.pY = null;
        }
        _lcls14d7.pZ = true;
        invalidateSelf();
    }

    private void FE8B()
    {
label0:
        {
            if (pG.kC.frameCount != 1)
            {
                if (pI)
                {
                    break label0;
                }
                pI = true;
                _cls14D7 _lcls14d7 = pH;
                if (!_lcls14d7.pI)
                {
                    _lcls14d7.pI = true;
                    _lcls14d7.pZ = false;
                    _lcls14d7.FE9C();
                }
            }
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas)
    {
        if (ni)
        {
            return;
        }
        if (pf)
        {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), pe);
            pf = false;
        }
        Object obj = pH;
        if (((_cls14D7) (obj)).pY != null)
        {
            obj = ((_cls14D7) (obj)).pY.qb;
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            obj = pF.pQ;
        }
        canvas.drawBitmap(((Bitmap) (obj)), null, pe, paint);
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return pF;
    }

    public int getIntrinsicHeight()
    {
        return pF.pQ.getHeight();
    }

    public int getIntrinsicWidth()
    {
        return pF.pQ.getWidth();
    }

    public int getOpacity()
    {
        return -2;
    }

    public boolean isRunning()
    {
        return pI;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        pf = true;
    }

    public void setAlpha(int i)
    {
        paint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        paint.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        pK = flag;
        if (!flag)
        {
            pI = false;
            pH.pI = false;
        } else
        if (pJ)
        {
            FE8B();
        }
        return super.setVisible(flag, flag1);
    }

    public void start()
    {
        pJ = true;
        kX = 0;
        if (pK)
        {
            FE8B();
        }
    }

    public void stop()
    {
        pJ = false;
        pI = false;
        pH.pI = false;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            _cls14D7 _lcls14d7 = pH;
            _lcls14d7.pI = false;
            if (_lcls14d7.pY != null)
            {
                _cls1D3C._mth02CA(_lcls14d7.pY);
                _lcls14d7.pY = null;
            }
            _lcls14d7.pZ = true;
            invalidateSelf();
        }
    }

    public final void _mth15AE(int i)
    {
        if (i <= 0 && i != -1 && i != 0)
        {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0)
        {
            pL = pG.kC.kX;
            return;
        } else
        {
            pL = i;
            return;
        }
    }

    public final void _mth1D53(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11 && getCallback() == null)
        {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i == pG.kC.frameCount - 1)
        {
            kX = kX + 1;
        }
        if (pL != -1 && kX >= pL)
        {
            stop();
        }
    }

    public final boolean FB82()
    {
        return true;
    }
}
