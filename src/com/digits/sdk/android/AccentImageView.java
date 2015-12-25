// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils

public class AccentImageView extends ImageView
{

    public AccentImageView(Context context)
    {
        super(context);
        init(context);
    }

    public AccentImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AccentImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        setColorFilter(ThemeUtils.getAccentColor(getResources(), context.getTheme()), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
