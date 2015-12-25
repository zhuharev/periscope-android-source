// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECPoint, ECCurve

public class ZSignedDigitR2LMultiplier extends AbstractECMultiplier
{

    public ZSignedDigitR2LMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECPoint ecpoint1 = ecpoint.FF79()._mth5B80();
        int j = biginteger.bitLength();
        int i = biginteger.getLowestSetBit();
        ecpoint = ecpoint._mth1483(i);
        do
        {
            i++;
            if (i < j)
            {
                ECPoint ecpoint2;
                if (biginteger.testBit(i))
                {
                    ecpoint2 = ecpoint;
                } else
                {
                    ecpoint2 = ecpoint._mth029C();
                }
                ecpoint1 = ecpoint1._mth141D(ecpoint2);
                ecpoint = ecpoint._mth038E();
            } else
            {
                return ecpoint1._mth141D(ecpoint);
            }
        } while (true);
    }
}
