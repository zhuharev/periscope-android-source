// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;

public final class _cls0582
{

    private static final double sh;

    public static double _mth02BB(long l)
    {
        long l1;
        if (17 <= android.os.Build.VERSION.SDK_INT)
        {
            l1 = SystemClock.elapsedRealtimeNanos();
        } else
        {
            l1 = System.currentTimeMillis();
        }
        return (double)(l1 - l) * sh;
    }

    public static long _mth0621()
    {
        if (17 <= android.os.Build.VERSION.SDK_INT)
        {
            return SystemClock.elapsedRealtimeNanos();
        } else
        {
            return System.currentTimeMillis();
        }
    }

    static 
    {
        double d;
        if (17 <= android.os.Build.VERSION.SDK_INT)
        {
            d = 1.0D / Math.pow(10D, 6D);
        } else
        {
            d = 1.0D;
        }
        sh = d;
    }
}
