// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.digits.sdk.android:
//            Digits, DigitsClient, AuthCallback

public class DigitsAuthButton extends Button
    implements android.view.View.OnClickListener
{

    private AuthCallback callback;
    volatile DigitsClient digitsClient;
    private android.view.View.OnClickListener onClickListener;

    public DigitsAuthButton(Context context)
    {
        this(context, null);
    }

    public DigitsAuthButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010048);
    }

    public DigitsAuthButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setUpButton();
        super.setOnClickListener(this);
    }

    private void setUpButton()
    {
        Resources resources = getResources();
        setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_drawable_padding));
        setText(R.string.dgts__login_digits_text);
        setTextColor(resources.getColor(R.color.tw__solid_white));
        setTextSize(0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_text_size));
        setTypeface(Typeface.DEFAULT_BOLD);
        setPadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_right_padding), 0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_right_padding), 0);
        setBackgroundResource(R.drawable.dgts__digits_btn);
    }

    protected Digits getDigits()
    {
        return Digits.getInstance();
    }

    protected DigitsClient getDigitsClient()
    {
        if (digitsClient != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        com/digits/sdk/android/DigitsClient;
        JVM INSTR monitorenter ;
        if (digitsClient == null)
        {
            digitsClient = getDigits().getDigitsClient();
        }
        com/digits/sdk/android/DigitsClient;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        throw exception;
        return digitsClient;
    }

    public void onClick(View view)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("AuthCallback must not be null");
        }
        getDigitsClient().startSignUp(callback);
        if (onClickListener != null)
        {
            onClickListener.onClick(view);
        }
    }

    public void setAuthTheme(int i)
    {
        getDigits().setTheme(i);
    }

    public void setCallback(AuthCallback authcallback)
    {
        callback = authcallback;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }
}
