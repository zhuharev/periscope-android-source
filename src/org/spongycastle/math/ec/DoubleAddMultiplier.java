// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECPoint, ECCurve

public class DoubleAddMultiplier extends AbstractECMultiplier
{

    public DoubleAddMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECPoint aecpoint[] = new ECPoint[2];
        aecpoint[0] = ecpoint.FF79()._mth5B80();
        aecpoint[1] = ecpoint;
        int k = biginteger.bitLength();
        for (int i = 0; i < k; i++)
        {
            int j;
            if (biginteger.testBit(i))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            int l = 1 - j;
            aecpoint[l] = aecpoint[l]._mth02BB(aecpoint[j]);
        }

        return aecpoint[0];
    }
}
