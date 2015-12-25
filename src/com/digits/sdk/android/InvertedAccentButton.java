// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils, ButtonThemer

public class InvertedAccentButton extends Button
{

    public InvertedAccentButton(Context context)
    {
        this(context, null);
    }

    public InvertedAccentButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010048);
    }

    public InvertedAccentButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    void init()
    {
        int i = ThemeUtils.getAccentColor(getResources(), getContext().getTheme());
        ButtonThemer buttonthemer = new ButtonThemer(getResources());
        buttonthemer.disableDropShadow(this);
        buttonthemer.setBackgroundAccentColorInverse(this, i);
        buttonthemer.setTextAccentColorInverse(this, i);
    }
}
