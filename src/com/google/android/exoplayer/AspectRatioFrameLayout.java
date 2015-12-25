// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout
{

    private static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01F;
    private float videoAspectRatio;

    public AspectRatioFrameLayout(Context context)
    {
        super(context);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected final void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (videoAspectRatio == 0.0F)
        {
            return;
        }
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        float f = (float)i / (float)j;
        f = videoAspectRatio / f - 1.0F;
        if (Math.abs(f) <= 0.01F)
        {
            return;
        }
        if (f > 0.0F)
        {
            j = (int)((float)i / videoAspectRatio);
        } else
        {
            i = (int)((float)j * videoAspectRatio);
        }
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
    }

    public final void setAspectRatio(float f)
    {
        if (videoAspectRatio != f)
        {
            videoAspectRatio = f;
            requestLayout();
        }
    }
}
