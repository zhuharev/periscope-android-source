// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Random;

// Referenced classes of package o:
//            th, ti

final class _cls09BD
    implements th
{

    private Random random;
    private th sR;
    private double sS;

    private _cls09BD(th th1, double d, Random random1)
    {
        if (d < 0.0D || d > 1.0D)
        {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (th1 == null)
        {
            throw new NullPointerException("backoff must not be null");
        } else
        {
            sR = th1;
            sS = d;
            random = random1;
            return;
        }
    }

    public _cls09BD(ti ti, double d)
    {
        this(((th) (ti)), 0.10000000000000001D, new Random());
    }

    public final long _mth1D65(int i)
    {
        double d = 1.0D - sS;
        return (long)((((1.0D + sS) - d) * random.nextDouble() + d) * (double)sR._mth1D65(i));
    }
}
