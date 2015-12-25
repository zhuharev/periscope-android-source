// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

class _cls02B6
{

    _cls02B6()
    {
    }

    public static void _mth02B9(View view)
    {
        view.requestFitSystemWindows();
    }

    public static int _mth02BE(View view)
    {
        return view.getImportantForAccessibility();
    }

    public static void _mth02CA(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }

    public static void _mth02CA(View view, Runnable runnable, long l)
    {
        view.postOnAnimationDelayed(runnable, l);
    }

    public static void _mth02CE(View view, int i)
    {
        view.setImportantForAccessibility(i);
    }

    public static boolean _mth037A(View view)
    {
        return view.hasTransientState();
    }

    public static boolean _mth05D9(View view)
    {
        return view.hasOverlappingRendering();
    }

    public static int _mth0640(View view)
    {
        return view.getMinimumWidth();
    }

    public static int _mth1427(View view)
    {
        return view.getMinimumHeight();
    }

    public static void _mth1FBE(View view)
    {
        view.postInvalidateOnAnimation();
    }
}
