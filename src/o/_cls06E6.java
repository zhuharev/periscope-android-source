// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls14A2

class _cls06E6
{

    _cls06E6()
    {
    }

    public static void _mth02CB(Drawable drawable)
    {
        drawable.jumpToCurrentState();
    }

    public static Drawable _mth141D(Drawable drawable)
    {
        if (!(drawable instanceof _cls14A2))
        {
            return new _cls14A2(drawable);
        } else
        {
            return drawable;
        }
    }
}
