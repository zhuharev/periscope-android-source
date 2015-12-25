// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package o:
//            xe

public class arc extends ImageView
{

    private ColorStateList bBg;
    public int bBh;
    public int bBi;

    public arc(Context context)
    {
        super(context);
        _mth02CA(context, null, 0);
    }

    public arc(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _mth02CA(context, attributeset, 0);
    }

    public arc(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _mth02CA(context, attributeset, i);
    }

    private void _mth02CA(Context context, AttributeSet attributeset, int i)
    {
        context = context.obtainStyledAttributes(attributeset, xe.PsImageView, i, 0);
        bBg = context.getColorStateList(0);
        bBh = context.getResourceId(1, 0);
        bBi = context.getResourceId(2, 0);
        context.recycle();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (bBg != null && bBg.isStateful())
        {
            setColorFilter(bBg.getColorForState(getDrawableState(), 0));
        }
    }

    public void setColorFilter(ColorStateList colorstatelist)
    {
        bBg = colorstatelist;
        super.setColorFilter(colorstatelist.getColorForState(getDrawableState(), 0));
    }
}
