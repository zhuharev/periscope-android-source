// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils

public class LinkTextView extends TextView
{

    public LinkTextView(Context context)
    {
        super(context);
        init(context);
    }

    public LinkTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public LinkTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private int getLinkColor(Context context)
    {
        TypedValue typedvalue = ThemeUtils.getTypedValueColor(context.getTheme(), 0x101009b);
        if (typedvalue == null)
        {
            return ThemeUtils.getAccentColor(context.getResources(), context.getTheme());
        } else
        {
            return typedvalue.data;
        }
    }

    private void init(Context context)
    {
        setTextColor(getLinkColor(context));
    }
}
