// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

// Referenced classes of package o:
//            _cls1D37, FE9B

class _cls1D0A
{

    _cls1D0A()
    {
    }

    public static void _mth02BC(View view, float f)
    {
        view.animate().alpha(f);
    }

    public static void _mth02BD(View view, float f)
    {
        view.animate().translationX(f);
    }

    public static long _mth02C6(View view)
    {
        return view.animate().getDuration();
    }

    public static void _mth02C7(View view)
    {
        view.animate().cancel();
    }

    public static void _mth02CA(View view, long l)
    {
        view.animate().setDuration(l);
    }

    public static void _mth02CA(View view, Interpolator interpolator)
    {
        view.animate().setInterpolator(interpolator);
    }

    public static void _mth02CA(View view, FE9B fe9b)
    {
        if (fe9b != null)
        {
            view.animate().setListener(new _cls1D37(fe9b, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }

    public static void _mth02CB(View view, long l)
    {
        view.animate().setStartDelay(l);
    }

    public static void _mth02E1(View view)
    {
        view.animate().start();
    }

    public static void _mth037A(View view, float f)
    {
        view.animate().translationY(f);
    }

    public static void _mth1FBE(View view, float f)
    {
        view.animate().scaleX(f);
    }
}
