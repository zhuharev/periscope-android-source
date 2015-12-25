// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            FB1F

final class np extends Drawable
{

    private final Drawable LG;
    private final Drawable LH;
    int _fld0196;

    public np(Resources resources)
    {
        _fld0196 = -1;
        LH = resources.getDrawable(FB1F.A);
        LG = resources.getDrawable(FB1F.B);
    }

    public final void draw(Canvas canvas)
    {
        LH.draw(canvas);
        canvas.drawColor(_fld0196, android.graphics.PorterDuff.Mode.SRC_IN);
        LG.draw(canvas);
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final boolean getPadding(Rect rect)
    {
        return LH.getPadding(rect);
    }

    public final void setAlpha(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final void setBounds(int i, int j, int k, int l)
    {
        LH.setBounds(i, j, k, l);
        LG.setBounds(i, j, k, l);
    }

    public final void setBounds(Rect rect)
    {
        LH.setBounds(rect);
        LG.setBounds(rect);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        throw new UnsupportedOperationException();
    }
}
