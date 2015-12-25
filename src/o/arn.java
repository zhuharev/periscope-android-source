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

// Referenced classes of package o:
//            arp, xe

public class arn extends arp
{

    private final RectShape bBK;
    private float bBL;
    private final Paint mPaint;

    public arn(Context context)
    {
        super(context);
        bBK = new RectShape();
        mPaint = new Paint();
        _mth02CF(context, null);
    }

    public arn(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bBK = new RectShape();
        mPaint = new Paint();
        _mth02CF(context, attributeset);
    }

    public arn(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bBK = new RectShape();
        mPaint = new Paint();
        _mth02CF(context, attributeset);
    }

    private void _mth02CF(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, xe.PsSelectedTextView);
        bBL = attributeset.getDimension(0, 9F);
        int i = context.getResources().getColor(attributeset.getResourceId(1, 0x7f0c00a4));
        mPaint.setColor(i);
        attributeset.recycle();
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        bBK.resize(getWidth(), bBL);
        int i = canvas.save(1);
        canvas.translate(0.0F, (float)getTop() + bBK.getHeight());
        if (isActivated())
        {
            bBK.draw(canvas, mPaint);
        }
        canvas.restoreToCount(i);
    }
}
