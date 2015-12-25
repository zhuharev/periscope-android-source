// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECCurve, ECPoint, WNafUtil

public class MixedNafR2LMultiplier extends AbstractECMultiplier
{

    private int aIR;
    private int aIS;

    public MixedNafR2LMultiplier()
    {
        this(2, 4);
    }

    private MixedNafR2LMultiplier(int i, int j)
    {
        aIR = 2;
        aIS = 4;
    }

    private static ECCurve _mth02CA(ECCurve eccurve, int i)
    {
        if (eccurve.FB5E() == i)
        {
            return eccurve;
        }
        if (!eccurve._mth071D(i))
        {
            throw new IllegalArgumentException((new StringBuilder("Coordinate system ")).append(i).append(" not supported by this curve").toString());
        } else
        {
            return eccurve._mth30C3()._mth0E32(i).FEA7();
        }
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECCurve eccurve1 = ecpoint.FF79();
        ECCurve eccurve2 = _mth02CA(eccurve1, aIR);
        ECCurve eccurve = _mth02CA(eccurve1, aIS);
        int ai[] = WNafUtil._mth037A(biginteger);
        ECPoint ecpoint1 = eccurve2._mth5B80();
        biginteger = eccurve._mth02CE(ecpoint);
        int j = 0;
        int i = 0;
        ecpoint = ecpoint1;
        while (i < ai.length) 
        {
            int k = ai[i];
            ECPoint ecpoint2 = biginteger._mth1483(j + (0xffff & k));
            ECPoint ecpoint3 = eccurve2._mth02CE(ecpoint2);
            biginteger = ecpoint3;
            if (k >> 16 < 0)
            {
                biginteger = ecpoint3._mth029C();
            }
            ecpoint = ecpoint._mth141D(biginteger);
            j = 1;
            i++;
            biginteger = ecpoint2;
        }
        return eccurve1._mth02CE(ecpoint);
    }
}
