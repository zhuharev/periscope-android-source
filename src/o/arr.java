// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;

public class arr extends TextureView
{

    public arr(Context context)
    {
        super(context);
    }

    public arr(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public arr(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (j == 0 || l == 0)
        {
            return;
        }
        if (l - j > 0)
        {
            Matrix matrix = new Matrix();
            matrix.setScale(1.0F, (float)l / (float)j);
            setTransform(matrix);
            return;
        } else
        {
            Matrix matrix1 = new Matrix();
            matrix1.setScale(1.0F, 1.0F);
            setTransform(matrix1);
            return;
        }
    }
}
