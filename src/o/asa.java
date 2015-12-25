// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

// Referenced classes of package o:
//            xe, aos

public class asa extends ProgressBar
{

    private int bCA;
    private float bCB;
    private int bCC;
    private Paint bCw;
    private Paint bCx;
    private float bCy;
    private int bCz;
    private int bac;

    public asa(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CF(context, attributeset);
    }

    public asa(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        Resources resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, xe.SegmentedProgressBar);
        bCC = attributeset.getDimensionPixelOffset(0, 0);
        bCy = attributeset.getDimensionPixelOffset(2, 0);
        bCz = attributeset.getDimensionPixelOffset(1, 0);
        attributeset.recycle();
        bCw = new Paint();
        bCw.setColor(resources.getColor(0x7f0c001a));
        bCw.setStrokeWidth(resources.getDimensionPixelOffset(0x7f09009c));
        bCx = new Paint();
        bCx.setColor(-1);
        bac = aos._mth02B2(context).x;
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        float f;
        float f1;
        f1 = aos._mth02B2(getContext()).x;
        f = getProgress();
        if (getMax() <= 0) goto _L2; else goto _L1
_L1:
        f = (f / (float)getMax()) * (float)bac;
_L4:
        int i;
        int j;
        canvas.translate(f1 * 0.5F - f, getTranslationY());
        super.onDraw(canvas);
        Rect rect = getProgressDrawable().getBounds();
        i = rect.height();
        j = rect.width();
        if (bCB <= 0.0F)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        f = bCB;
_L3:
        if (f >= (float)j)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        canvas.drawLine(f, 0.0F, f, i, bCw);
        f += bCB;
          goto _L3
        f = bCA;
        if (getMax() <= 0)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        f = (f / (float)getMax()) * (float)bac;
_L5:
        canvas.drawCircle(f, bCz + i, bCy, bCx);
        this;
        JVM INSTR monitorexit ;
        return;
        canvas;
        throw canvas;
_L2:
        f = 0.0F;
          goto _L4
        f = 0.0F;
          goto _L5
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(bac, bCC, k, l);
    }

    public void setBarWidth(int i)
    {
        bac = i;
        Rect rect = getProgressDrawable().getBounds();
        onSizeChanged(bac, rect.height(), rect.width(), bCC);
    }

    public void setInitialProgress(int i)
    {
        bCA = i;
    }

    public void setSegmentSize(float f)
    {
        bCB = f;
    }
}
