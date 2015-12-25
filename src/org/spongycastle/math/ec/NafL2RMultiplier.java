// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, WNafUtil, ECPoint, ECCurve

public class NafL2RMultiplier extends AbstractECMultiplier
{

    public NafL2RMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        int ai[] = WNafUtil._mth037A(biginteger);
        ECPoint ecpoint1 = ecpoint._mth0188();
        ECPoint ecpoint2 = ecpoint1._mth029C();
        ecpoint = ecpoint.FF79()._mth5B80();
        int i = ai.length;
        do
        {
            i--;
            if (i >= 0)
            {
                int j = ai[i];
                if (j >> 16 < 0)
                {
                    biginteger = ecpoint2;
                } else
                {
                    biginteger = ecpoint1;
                }
                ecpoint = ecpoint._mth02BB(biginteger)._mth1483(j & 0xffff);
            } else
            {
                return ecpoint;
            }
        } while (true);
    }
}
