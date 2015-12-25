// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, WNafUtil, ECPoint, ECCurve

public class NafR2LMultiplier extends AbstractECMultiplier
{

    public NafR2LMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        int ai[] = WNafUtil._mth037A(biginteger);
        ECPoint ecpoint1 = ecpoint.FF79()._mth5B80();
        int j = 0;
        int i = 0;
        biginteger = ecpoint;
        ecpoint = ecpoint1;
        for (; i < ai.length; i++)
        {
            int k = ai[i];
            biginteger = biginteger._mth1483(j + (0xffff & k));
            Object obj;
            if (k >> 16 < 0)
            {
                obj = biginteger._mth029C();
            } else
            {
                obj = biginteger;
            }
            ecpoint = ecpoint._mth141D(((ECPoint) (obj)));
            j = 1;
        }

        return ecpoint;
    }
}
