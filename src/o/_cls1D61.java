// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class _cls1D61
{

    _cls1D61()
    {
    }

    public static void finish(Object obj)
    {
        ((EdgeEffect)obj).finish();
    }

    public static void _mth02CA(Object obj, int i, int j)
    {
        ((EdgeEffect)obj).setSize(i, j);
    }

    public static boolean _mth02CA(Object obj, float f)
    {
        ((EdgeEffect)obj).onPull(f);
        return true;
    }

    public static boolean _mth02CA(Object obj, Canvas canvas)
    {
        return ((EdgeEffect)obj).draw(canvas);
    }

    public static Object _mth02CF(Context context)
    {
        return new EdgeEffect(context);
    }

    public static boolean _mth037A(Object obj, int i)
    {
        ((EdgeEffect)obj).onAbsorb(i);
        return true;
    }

    public static boolean _mth0559(Object obj)
    {
        return ((EdgeEffect)obj).isFinished();
    }

    public static boolean _mth05D9(Object obj)
    {
        obj = (EdgeEffect)obj;
        ((EdgeEffect) (obj)).onRelease();
        return ((EdgeEffect) (obj)).isFinished();
    }
}
