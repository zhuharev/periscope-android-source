// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class FF86
{

    FF86()
    {
    }

    public static int resolveSizeAndState(int i, int j, int k)
    {
        return View.resolveSizeAndState(i, j, k);
    }

    public static float _mth02BF(View view)
    {
        return view.getAlpha();
    }

    public static int _mth02C8(View view)
    {
        return view.getLayerType();
    }

    public static void _mth02CA(View view, float f)
    {
        view.setTranslationX(f);
    }

    public static void _mth02CA(View view, int i, Paint paint)
    {
        view.setLayerType(i, paint);
    }

    public static void _mth02CA(View view, boolean flag)
    {
        view.setSaveFromParentEnabled(flag);
    }

    public static void _mth02CB(View view, float f)
    {
        view.setTranslationY(f);
    }

    public static void _mth02CB(View view, boolean flag)
    {
        view.setActivated(flag);
    }

    public static int _mth02CC(View view)
    {
        return view.getMeasuredState();
    }

    public static float _mth02CD(View view)
    {
        return view.getTranslationX();
    }

    public static void _mth02CE(View view, float f)
    {
        view.setAlpha(f);
    }

    public static void _mth02CF(View view, float f)
    {
        view.setScaleX(f);
    }

    public static float _mth02D1(View view)
    {
        return view.getTranslationY();
    }

    public static void _mth0559(View view)
    {
        view.jumpDrawablesToCurrentState();
    }

    public static void _mth141D(View view, float f)
    {
        view.setScaleY(f);
    }

    static long _mth1507()
    {
        return ValueAnimator.getFrameDelay();
    }

    public static float FE73(View view)
    {
        return view.getScaleX();
    }
}
