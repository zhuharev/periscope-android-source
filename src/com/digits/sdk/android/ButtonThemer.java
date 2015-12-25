// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            ThemeUtils

class ButtonThemer
{

    private final Resources resources;

    public ButtonThemer(Resources resources1)
    {
        resources = resources1;
    }

    private int getPressedColor(int i)
    {
        if (ThemeUtils.isLightColor(i))
        {
            return ThemeUtils.calculateOpacityTransform(0.20000000000000001D, 0xff000000, i);
        } else
        {
            return ThemeUtils.calculateOpacityTransform(0.20000000000000001D, -1, i);
        }
    }

    void disableDropShadow(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            view.setStateListAnimator(null);
            view.setElevation(0.0F);
        }
    }

    int getTextColor(int i)
    {
        if (ThemeUtils.isLightColor(i))
        {
            return resources.getColor(R.color.dgts__text_dark);
        } else
        {
            return resources.getColor(R.color.dgts__text_light);
        }
    }

    void setBackgroundAccentColor(View view, int i)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        float f = TypedValue.applyDimension(1, 5F, resources.getDisplayMetrics());
        GradientDrawable gradientdrawable = new GradientDrawable();
        gradientdrawable.setCornerRadius(f);
        gradientdrawable.setColor(getPressedColor(i));
        statelistdrawable.addState(new int[] {
            0x101009c, 0x10100a7
        }, gradientdrawable);
        statelistdrawable.addState(new int[] {
            0xfefeff64, 0x10100a7
        }, gradientdrawable);
        statelistdrawable.addState(new int[] {
            0x101009c
        }, gradientdrawable);
        gradientdrawable = new GradientDrawable();
        gradientdrawable.setColor(i);
        gradientdrawable.setCornerRadius(f);
        statelistdrawable.addState(StateSet.WILD_CARD, gradientdrawable);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(statelistdrawable);
            return;
        } else
        {
            view.setBackgroundDrawable(statelistdrawable);
            return;
        }
    }

    void setBackgroundAccentColorInverse(View view, int i)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        float f = TypedValue.applyDimension(1, 5F, resources.getDisplayMetrics());
        float f1 = TypedValue.applyDimension(1, 2.0F, resources.getDisplayMetrics());
        GradientDrawable gradientdrawable = new GradientDrawable();
        gradientdrawable.setCornerRadius(f);
        gradientdrawable.setStroke((int)f1, getPressedColor(i));
        statelistdrawable.addState(new int[] {
            0x101009c, 0x10100a7
        }, gradientdrawable);
        statelistdrawable.addState(new int[] {
            0xfefeff64, 0x10100a7
        }, gradientdrawable);
        statelistdrawable.addState(new int[] {
            0x101009c
        }, gradientdrawable);
        gradientdrawable = new GradientDrawable();
        gradientdrawable.setCornerRadius(f);
        gradientdrawable.setStroke((int)f1, i);
        statelistdrawable.addState(StateSet.WILD_CARD, gradientdrawable);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(statelistdrawable);
            return;
        } else
        {
            view.setBackgroundDrawable(statelistdrawable);
            return;
        }
    }

    void setTextAccentColor(TextView textview, int i)
    {
        textview.setTextColor(getTextColor(i));
    }

    void setTextAccentColorInverse(TextView textview, int i)
    {
        int j = getPressedColor(i);
        textview.setTextColor(new ColorStateList(new int[][] {
            new int[] {
                0x101009c, 0xfefeff59
            }, new int[] {
                0x101009c, 0x10100a7
            }, new int[] {
                0xfefeff64, 0x10100a7
            }, StateSet.WILD_CARD
        }, new int[] {
            i, j, j, i
        }));
    }
}
