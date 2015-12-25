// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils, ButtonThemer

public class AccentButton extends Button
{

    public AccentButton(Context context)
    {
        this(context, null);
    }

    public AccentButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010048);
    }

    public AccentButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        int i = ThemeUtils.getAccentColor(getResources(), getContext().getTheme());
        ButtonThemer buttonthemer = new ButtonThemer(getResources());
        buttonthemer.disableDropShadow(this);
        buttonthemer.setBackgroundAccentColor(this, i);
        buttonthemer.setTextAccentColor(this, i);
    }
}
