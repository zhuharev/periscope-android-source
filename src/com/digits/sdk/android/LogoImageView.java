// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils

public class LogoImageView extends ImageView
{

    public LogoImageView(Context context)
    {
        super(context);
        initImageView(context);
    }

    public LogoImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LogoImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initImageView(context);
    }

    void initImageView(Context context)
    {
        context = ThemeUtils.getLogoDrawable(context.getTheme());
        if (context != null)
        {
            setVisibility(0);
            setImageDrawable(context);
            return;
        } else
        {
            setVisibility(8);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(i);
        setMeasuredDimension(i, (i * getDrawable().getIntrinsicHeight()) / getDrawable().getIntrinsicWidth());
    }
}
