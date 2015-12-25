// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;

public class aic
{

    private final int bmK = 25;
    private final int bmL = 500;
    private final int bmM = 4;
    private int bmN;
    private long bmO;
    private long bmP;

    public aic(int i, int j, int k)
    {
    }

    public final boolean cr()
    {
        if (SystemClock.elapsedRealtime() - bmP < (long)bmK)
        {
            return true;
        }
        bmP = SystemClock.elapsedRealtime();
        if (bmN == 0)
        {
            bmO = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - bmO < (long)bmL)
        {
            if (bmN > bmM)
            {
                return true;
            } else
            {
                bmO = SystemClock.elapsedRealtime();
                bmN = bmN + 1;
                return false;
            }
        } else
        {
            bmN = 0;
            bmO = SystemClock.elapsedRealtime();
            return false;
        }
    }
}
