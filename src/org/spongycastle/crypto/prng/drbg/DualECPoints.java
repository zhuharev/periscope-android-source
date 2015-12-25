// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class DualECPoints
{

    final ECPoint alu;
    final int ayd;
    final ECPoint ayu;
    private final int ayv;

    public DualECPoints(int i, ECPoint ecpoint, ECPoint ecpoint1, int j)
    {
        if (!ecpoint.FF79()._mth02BB(ecpoint1.FF79()))
        {
            throw new IllegalArgumentException("points need to be on the same curve");
        } else
        {
            ayd = i;
            alu = ecpoint;
            ayu = ecpoint1;
            ayv = 1;
            return;
        }
    }

    public final int _mth028E()
    {
        int l = alu.FF79().getFieldSize();
        int j = ayv;
        int i = 0;
        do
        {
            int k = j >> 1;
            j = k;
            if (k != 0)
            {
                i++;
            } else
            {
                return (l - (i + 13)) / 8 << 3;
            }
        } while (true);
    }
}
