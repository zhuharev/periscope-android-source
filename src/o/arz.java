// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.widget.LinearLayout;

// Referenced classes of package o:
//            xe

public class arz extends LinearLayout
{
    public static interface if
    {

        public abstract int getColor();
    }


    private final RectShape bCp;
    private float bCq;
    private int bCr;
    float bCs;
    float bCt;
    private int bCu;
    private if bCv;
    int bX;
    private final Paint mPaint;

    public arz(Context context)
    {
        super(context);
        bCp = new RectShape();
        mPaint = new Paint();
        bCu = 0;
        _mth02CF(context, null);
    }

    public arz(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bCp = new RectShape();
        mPaint = new Paint();
        bCu = 0;
        _mth02CF(context, attributeset);
    }

    public arz(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bCp = new RectShape();
        mPaint = new Paint();
        bCu = 0;
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, xe.ScrollTabLayout);
        bCq = attributeset.getDimension(0, 9F);
        bCr = context.getResources().getColor(attributeset.getResourceId(1, 0x7f0c00a4));
        mPaint.setColor(bCr);
        attributeset.recycle();
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (bCu == 0)
        {
            int i = canvas.save(1);
            canvas.translate((float)bX * bCt + bCs, (float)getHeight() - bCp.getHeight());
            if (bCv != null)
            {
                mPaint.setColor(bCv.getColor());
            } else
            {
                mPaint.setColor(bCr);
            }
            bCp.draw(canvas, mPaint);
            canvas.restoreToCount(i);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        float f = getMeasuredWidth() / getChildCount();
        bCp.resize(f, bCq);
        bCt = f;
    }

    public void setPosition(int i)
    {
        bX = i;
        bCs = 0.0F;
        invalidate();
    }

    public void setScrollColorProvider(if if1)
    {
        bCv = if1;
    }

    public void setScrollVisibility(int i)
    {
        if (bCu != i)
        {
            bCu = i;
            invalidate();
        }
    }
}
