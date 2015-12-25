// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils, ButtonThemer

public class StateButton extends RelativeLayout
{

    int accentColor;
    ButtonThemer buttonThemer;
    CharSequence finishText;
    ImageView imageView;
    ProgressBar progressBar;
    CharSequence progressText;
    CharSequence startText;
    TextView textView;

    public StateButton(Context context)
    {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StateButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, R.styleable.StateButton);
        init(attributeset);
        attributeset.recycle();
        accentColor = ThemeUtils.getAccentColor(getResources(), context.getTheme());
        buttonThemer = new ButtonThemer(getResources());
        buttonThemer.setBackgroundAccentColor(this, accentColor);
        buttonThemer.setTextAccentColor(textView, accentColor);
        setImageAccentColor();
        setSpinnerAccentColor();
    }

    private void initView()
    {
        inflate(getContext(), R.layout.dgts__state_button, this);
        textView = (TextView)findViewById(R.id.dgts__state_button);
        progressBar = (ProgressBar)findViewById(R.id.dgts__state_progress);
        imageView = (ImageView)findViewById(R.id.dgts__state_success);
        showStart();
    }

    Drawable getProgressDrawable()
    {
        if (ThemeUtils.isLightColor(accentColor))
        {
            return getResources().getDrawable(R.drawable.progress_dark);
        } else
        {
            return getResources().getDrawable(R.drawable.progress_light);
        }
    }

    int getTextColor()
    {
        return buttonThemer.getTextColor(accentColor);
    }

    void init(TypedArray typedarray)
    {
        startText = typedarray.getText(R.styleable.StateButton_startStateText);
        progressText = typedarray.getText(R.styleable.StateButton_progressStateText);
        finishText = typedarray.getText(R.styleable.StateButton_finishStateText);
        initView();
    }

    void setImageAccentColor()
    {
        imageView.setColorFilter(getTextColor(), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    void setSpinnerAccentColor()
    {
        progressBar.setIndeterminateDrawable(getProgressDrawable());
    }

    public void setStatesText(int i, int j, int k)
    {
        Context context = getContext();
        startText = context.getString(i);
        progressText = context.getString(j);
        finishText = context.getString(k);
    }

    public void showError()
    {
        showStart();
    }

    public void showFinish()
    {
        setClickable(false);
        textView.setText(finishText);
        progressBar.setVisibility(8);
        imageView.setVisibility(0);
    }

    public void showProgress()
    {
        setClickable(false);
        textView.setText(progressText);
        progressBar.setVisibility(0);
        imageView.setVisibility(8);
    }

    public void showStart()
    {
        setClickable(true);
        textView.setText(startText);
        progressBar.setVisibility(8);
        imageView.setVisibility(8);
    }
}
