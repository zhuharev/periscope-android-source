// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package o:
//            xe, aap

public class akt extends View
{

    aap bpO;
    int _fld029F;
    Drawable _fld0407;

    public akt(Context context)
    {
        this(context, null);
    }

    public akt(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01000c);
    }

    public akt(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, xe.ToolbarButton, i, 0);
        _fld0407 = context.getDrawable(1);
        _fld029F = context.getColor(0, -1);
        if (_fld0407 != null)
        {
            _fld0407.setColorFilter(_fld029F, android.graphics.PorterDuff.Mode.SRC_IN);
            invalidate();
        }
        context.recycle();
    }

    protected void onDraw(Canvas canvas)
    {
        _fld0407.draw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = _fld0407.getIntrinsicWidth();
        j = _fld0407.getIntrinsicHeight();
        int k = (getMeasuredWidth() - i) / 2;
        int l = (getMeasuredHeight() - j) / 2;
        _fld0407.setBounds(k, l, k + i, l + j);
    }

    public void setColor(int i)
    {
        _fld029F = i;
        if (_fld0407 != null)
        {
            _fld0407.setColorFilter(_fld029F, android.graphics.PorterDuff.Mode.SRC_IN);
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable)
    {
        _fld0407 = drawable;
        requestLayout();
        if (_fld0407 != null)
        {
            _fld0407.setColorFilter(_fld029F, android.graphics.PorterDuff.Mode.SRC_IN);
            invalidate();
        }
    }

    public void setTargetColor(int i)
    {
        bpO = new aap(_fld029F, i);
    }
}
