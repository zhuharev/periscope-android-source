// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

class nr extends FrameLayout
{

    private int LN;

    public nr(Context context)
    {
        super(context);
    }

    public nr(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public nr(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void dispatchDraw(Canvas canvas)
    {
        if (LN == 0)
        {
            super.dispatchDraw(canvas);
            return;
        }
        if (LN == 1)
        {
            canvas.translate(getWidth(), 0.0F);
            canvas.rotate(90F, getWidth() / 2, 0.0F);
            canvas.translate(getHeight() / 2, getWidth() / 2);
        } else
        if (LN == 2)
        {
            canvas.rotate(180F, getWidth() / 2, getHeight() / 2);
        } else
        {
            canvas.translate(0.0F, getHeight());
            canvas.rotate(270F, getWidth() / 2, 0.0F);
            canvas.translate(getHeight() / 2, -getWidth() / 2);
        }
        super.dispatchDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        if (LN == 1 || LN == 3)
        {
            super.onMeasure(i, j);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setViewRotation(int i)
    {
        LN = ((i + 360) % 360) / 90;
    }
}
