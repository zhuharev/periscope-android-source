// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECPoint, FixedPointUtil, FixedPointPreCompInfo, 
//            ECCurve

public class FixedPointCombMultiplier extends AbstractECMultiplier
{

    public FixedPointCombMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECCurve eccurve = ecpoint.FF79();
        int j = FixedPointUtil._mth02BC(eccurve);
        if (biginteger.bitLength() > j)
        {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        byte byte0;
        if (j > 257)
        {
            byte0 = 6;
        } else
        {
            byte0 = 5;
        }
        ecpoint = FixedPointUtil._mth02CA(ecpoint, byte0);
        ECPoint aecpoint[] = ecpoint._mth03D9();
        int j1 = ecpoint.getWidth();
        int k1 = ((j + j1) - 1) / j1;
        ecpoint = eccurve._mth5B80();
        for (int k = 0; k < k1; k++)
        {
            int i = 0;
            for (int l = k1 * j1 - 1 - k; l >= 0; l -= k1)
            {
                int i1 = i << 1;
                i = i1;
                if (biginteger.testBit(l))
                {
                    i = i1 | 1;
                }
            }

            ecpoint = ecpoint._mth02BB(aecpoint[i]);
        }

        return ecpoint;
    }
}
