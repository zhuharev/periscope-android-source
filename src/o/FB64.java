// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class FB64
{

    FB64()
    {
    }

    public static void _mth02CA(Object obj, int i, int j, int k, int l)
    {
        ((OverScroller)obj).startScroll(i, j, k, l);
    }

    public static void _mth02CA(Object obj, int i, int j, int k, int l, int i1)
    {
        ((OverScroller)obj).startScroll(i, j, k, l, i1);
    }

    public static void _mth02CA(Object obj, int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        ((OverScroller)obj).fling(i, j, k, l, i1, j1, k1, l1);
    }

    public static void _mth02CA(Object obj, int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        ((OverScroller)obj).fling(i, j, k, l, i1, j1, k1, l1, i2, j2);
    }

    public static boolean _mth02CA(Object obj, int i, int j, int k, int l, int i1, int j1)
    {
        return ((OverScroller)obj).springBack(i, j, k, l, i1, j1);
    }

    public static Object _mth02CB(Context context, Interpolator interpolator)
    {
        if (interpolator != null)
        {
            return new OverScroller(context, interpolator);
        } else
        {
            return new OverScroller(context);
        }
    }

    public static boolean _mth0559(Object obj)
    {
        return ((OverScroller)obj).isFinished();
    }

    public static int _mth0674(Object obj)
    {
        return ((OverScroller)obj).getCurrX();
    }

    public static int _mth1D35(Object obj)
    {
        return ((OverScroller)obj).getCurrY();
    }

    public static boolean _mth1D54(Object obj)
    {
        return ((OverScroller)obj).computeScrollOffset();
    }

    public static void _mth1D62(Object obj)
    {
        ((OverScroller)obj).abortAnimation();
    }

    public static int _mth2071(Object obj)
    {
        return ((OverScroller)obj).getFinalX();
    }

    public static int FE76(Object obj)
    {
        return ((OverScroller)obj).getFinalY();
    }
}
