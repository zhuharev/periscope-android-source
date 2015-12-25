// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECPoint

public class ZSignedDigitL2RMultiplier extends AbstractECMultiplier
{

    public ZSignedDigitL2RMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ecpoint = ecpoint._mth0188();
        ECPoint ecpoint3 = ecpoint._mth029C();
        ECPoint ecpoint1 = ecpoint;
        int i = biginteger.bitLength();
        int j = biginteger.getLowestSetBit();
        do
        {
            i--;
            if (i > j)
            {
                ECPoint ecpoint2;
                if (biginteger.testBit(i))
                {
                    ecpoint2 = ecpoint;
                } else
                {
                    ecpoint2 = ecpoint3;
                }
                ecpoint1 = ecpoint1._mth02BB(ecpoint2);
            } else
            {
                return ecpoint1._mth1483(j);
            }
        } while (true);
    }
}
