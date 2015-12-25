// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

public final class asg extends ShapeDrawable
{

    private final int bCG;
    private final int bCH;
    private final Paint bCI = new Paint(1);
    private CharSequence bCJ;

    public asg(Resources resources, OvalShape ovalshape, int i, int j, int k, int l, String s)
    {
        super(ovalshape);
        bCG = i;
        bCH = j;
        getPaint().setColor(resources.getColor(k));
        bCI.setColor(resources.getColor(0x7f0c00a4));
        bCI.setTextAlign(android.graphics.Paint.Align.CENTER);
        bCI.setStyle(android.graphics.Paint.Style.FILL);
        bCI.setTextSize(Math.min(i, j) / 2);
        bCJ = s;
    }

    public final void draw(Canvas canvas)
    {
        super.draw(canvas);
        Rect rect = getBounds();
        canvas.drawText(bCJ.toString(), rect.width() / 2, (float)(rect.height() / 2) - (bCI.descent() + bCI.ascent()) / 2.0F, bCI);
    }

    public final int getIntrinsicHeight()
    {
        return bCH;
    }

    public final int getIntrinsicWidth()
    {
        return bCG;
    }

    public final int getOpacity()
    {
        return bCI.getAlpha();
    }

    public final void setAlpha(int i)
    {
        bCI.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        bCI.setColorFilter(colorfilter);
    }
}
