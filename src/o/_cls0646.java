// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Gravity;

// Referenced classes of package o:
//            _cls0EB2

public class _cls0646 extends _cls0EB2
{
    /* member class not found */
    class if {}


    private int height;
    private final Rect pe;
    private boolean pf;
    private boolean pg;
    if ph;
    private int width;

    public _cls0646(Resources resources, Bitmap bitmap)
    {
        this(resources, new if(bitmap));
    }

    _cls0646(Resources resources, if if1)
    {
        pe = new Rect();
        if (if1 == null)
        {
            throw new NullPointerException("BitmapState must not be null");
        }
        ph = if1;
        int i;
        if (resources != null)
        {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0)
            {
                i = 160;
            }
            if1.pj = i;
        } else
        {
            i = if1.pj;
        }
        width = if1.oW.getScaledWidth(i);
        height = if1.oW.getScaledHeight(i);
    }

    public void draw(Canvas canvas)
    {
        if (pf)
        {
            Gravity.apply(119, width, height, getBounds(), pe);
            pf = false;
        }
        canvas.drawBitmap(ph.oW, null, pe, ph.paint);
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return ph;
    }

    public int getIntrinsicHeight()
    {
        return height;
    }

    public int getIntrinsicWidth()
    {
        return width;
    }

    public int getOpacity()
    {
        Bitmap bitmap = ph.oW;
        return bitmap != null && !bitmap.hasAlpha() && ph.paint.getAlpha() >= 255 ? -1 : -3;
    }

    public boolean isRunning()
    {
        return false;
    }

    public Drawable mutate()
    {
        if (!pg && super.mutate() == this)
        {
            ph = new if(ph);
            pg = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        pf = true;
    }

    public void setAlpha(int i)
    {
        if (ph.paint.getAlpha() != i)
        {
            if if1 = ph;
            if (if.pi == if1.paint)
            {
                if1.paint = new Paint(6);
            }
            if1.paint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        if if1 = ph;
        if (if.pi == if1.paint)
        {
            if1.paint = new Paint(6);
        }
        if1.paint.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void start()
    {
    }

    public void stop()
    {
    }

    public final void _mth15AE(int i)
    {
    }

    public final boolean FB82()
    {
        return false;
    }
}
