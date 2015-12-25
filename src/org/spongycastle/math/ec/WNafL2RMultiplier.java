// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, WNafUtil, WNafPreCompInfo, ECPoint, 
//            ECCurve, LongArray

public class WNafL2RMultiplier extends AbstractECMultiplier
{

    public WNafL2RMultiplier()
    {
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        ECPoint aecpoint[];
        ECPoint aecpoint1[];
        int ai[];
        int i;
        int j;
        int k;
        int j1;
        j1 = Math.max(2, Math.min(16, WNafUtil._mth1D0A(biginteger.bitLength())));
        WNafPreCompInfo wnafprecompinfo = WNafUtil._mth02CA(ecpoint, j1, true);
        aecpoint = wnafprecompinfo._mth03D9();
        aecpoint1 = wnafprecompinfo._mth03F5();
        ai = WNafUtil._mth02CE(j1, biginteger);
        ecpoint = ecpoint.FF79()._mth5B80();
        k = ai.length;
        i = k;
        j = i;
        if (k <= 1) goto _L2; else goto _L1
_L1:
        i--;
        j = ai[i];
        int l1 = j >> 16;
        j &= 0xffff;
        int l = Math.abs(l1);
        if (l1 < 0)
        {
            ecpoint = aecpoint1;
        } else
        {
            ecpoint = aecpoint;
        }
        if (l << 2 < 1 << j1)
        {
            byte byte0 = LongArray.aIP[l];
            int i2 = j1 - byte0;
            ecpoint = ecpoint[(1 << j1 - 1) - 1 >>> 1]._mth141D(ecpoint[((l ^ 1 << byte0 - 1) << i2) + 1 >>> 1]);
            j -= i2;
        } else
        {
            ecpoint = ecpoint[l >>> 1];
        }
_L4:
        ecpoint = ecpoint._mth1483(j);
        j = i;
_L2:
        if (j > 0)
        {
            i = j - 1;
            j = ai[i];
            int i1 = j >> 16;
            j &= 0xffff;
            int k1 = Math.abs(i1);
            if (i1 < 0)
            {
                biginteger = aecpoint1;
            } else
            {
                biginteger = aecpoint;
            }
            ecpoint = ecpoint._mth02BB(biginteger[k1 >>> 1]);
        } else
        {
            return ecpoint;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
