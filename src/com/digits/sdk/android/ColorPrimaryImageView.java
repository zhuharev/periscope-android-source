// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ColorPrimaryImageView extends ImageView
{

    public ColorPrimaryImageView(Context context)
    {
        super(context);
        init(context);
    }

    public ColorPrimaryImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ColorPrimaryImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private int getTextColorPrimary(Context context)
    {
        context = context.getTheme().obtainStyledAttributes(new int[] {
            0x1010036
        });
        int i = context.getColor(0, getResources().getColor(R.color.dgts__default_logo_name));
        context.recycle();
        return i;
    }

    private void init(Context context)
    {
        setColorFilter(getTextColorPrimary(context), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
