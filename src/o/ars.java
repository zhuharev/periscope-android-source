// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ars extends ImageView
{

    public ars(Context context)
    {
        super(context);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public ars(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ars(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    private void ex()
    {
        if (getDrawable() == null)
        {
            return;
        }
        Matrix matrix = getImageMatrix();
        int i = getWidth() - getPaddingLeft() - getPaddingRight();
        int j = getHeight() - getPaddingTop() - getPaddingBottom();
        int k = getDrawable().getIntrinsicWidth();
        int l = getDrawable().getIntrinsicHeight();
        float f;
        if (k * j > l * i)
        {
            f = (float)j / (float)l;
        } else
        {
            f = (float)i / (float)k;
        }
        matrix.setScale(f, f);
        setImageMatrix(matrix);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        ex();
    }

    protected boolean setFrame(int i, int j, int k, int l)
    {
        ex();
        return super.setFrame(i, j, k, l);
    }

    public void setImageMatrix(Matrix matrix)
    {
        super.setImageMatrix(matrix);
    }
}
