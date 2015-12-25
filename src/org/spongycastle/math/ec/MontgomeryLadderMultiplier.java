// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECPoint, ECCurve

public class MontgomeryLadderMultiplier extends AbstractECMultiplier
{

    public MontgomeryLadderMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECPoint aecpoint[] = new ECPoint[2];
        aecpoint[0] = ecpoint.FF79()._mth5B80();
        aecpoint[1] = ecpoint;
        int i = biginteger.bitLength();
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                if (biginteger.testBit(j))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                int k = 1 - i;
                aecpoint[k] = aecpoint[k]._mth141D(aecpoint[i]);
                aecpoint[i] = aecpoint[i]._mth038E();
                i = j;
            } else
            {
                return aecpoint[0];
            }
        } while (true);
    }
}
