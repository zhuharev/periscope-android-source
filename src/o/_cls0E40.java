// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls15AE

class _cls0E40
{

    _cls0E40()
    {
    }

    public static void _mth02CA(Drawable drawable, boolean flag)
    {
        drawable.setAutoMirrored(flag);
    }

    public static boolean _mth02CE(Drawable drawable)
    {
        return drawable.isAutoMirrored();
    }

    public static Drawable _mth141D(Drawable drawable)
    {
        if (!(drawable instanceof _cls15AE))
        {
            return new _cls15AE(drawable);
        } else
        {
            return drawable;
        }
    }
}
