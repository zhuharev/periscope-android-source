// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public final class ns extends TextView
{

    private int LO;
    private int LP;

    public ns(Context context)
    {
        super(context);
        LO = 0;
        LP = 0;
    }

    public ns(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        LO = 0;
        LP = 0;
    }

    public ns(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        LO = 0;
        LP = 0;
    }

    public final void draw(Canvas canvas)
    {
        canvas.translate(LP / 2, LO / 2);
        super.draw(canvas);
    }

    protected final void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        int k = Math.max(i, j);
        if (i > j)
        {
            LO = i - j;
            LP = 0;
        } else
        {
            LO = 0;
            LP = j - i;
        }
        setMeasuredDimension(k, k);
    }
}
