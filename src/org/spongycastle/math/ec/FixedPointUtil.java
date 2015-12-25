// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            ECCurve, ECPoint, FixedPointPreCompInfo

public class FixedPointUtil
{

    public FixedPointUtil()
    {
    }

    public static int _mth02BC(ECCurve eccurve)
    {
        BigInteger biginteger = eccurve.getOrder();
        if (biginteger == null)
        {
            return eccurve.getFieldSize() + 1;
        } else
        {
            return biginteger.bitLength();
        }
    }

    public static FixedPointPreCompInfo _mth02CA(ECPoint ecpoint, int i)
    {
        ECCurve eccurve = ecpoint.FF79();
        int l1 = 1 << i;
        Object obj = eccurve._mth02CA(ecpoint, "bc_fixed_point");
        if (obj != null && (obj instanceof FixedPointPreCompInfo))
        {
            obj = (FixedPointPreCompInfo)obj;
        } else
        {
            obj = new FixedPointPreCompInfo();
        }
        ECPoint aecpoint[] = ((FixedPointPreCompInfo) (obj))._mth03D9();
        if (aecpoint == null || aecpoint.length < l1)
        {
            BigInteger biginteger = eccurve.getOrder();
            int j;
            if (biginteger == null)
            {
                j = eccurve.getFieldSize() + 1;
            } else
            {
                j = biginteger.bitLength();
            }
            int i1 = ((j + i) - 1) / i;
            ECPoint aecpoint1[] = new ECPoint[i];
            aecpoint1[0] = ecpoint;
            for (int k = 1; k < i; k++)
            {
                aecpoint1[k] = aecpoint1[k - 1]._mth1483(i1);
            }

            eccurve._mth02CA(aecpoint1);
            ECPoint aecpoint2[] = new ECPoint[l1];
            aecpoint2[0] = eccurve._mth5B80();
            for (int j1 = i - 1; j1 >= 0; j1--)
            {
                ECPoint ecpoint1 = aecpoint1[j1];
                int k1 = 1 << j1;
                for (int l = k1; l < l1; l += k1 << 1)
                {
                    aecpoint2[l] = aecpoint2[l - k1]._mth141D(ecpoint1);
                }

            }

            eccurve._mth02CA(aecpoint2);
            ((FixedPointPreCompInfo) (obj))._mth02CB(aecpoint2);
            ((FixedPointPreCompInfo) (obj)).setWidth(i);
            eccurve._mth02CA(ecpoint, "bc_fixed_point", ((PreCompInfo) (obj)));
        }
        return ((FixedPointPreCompInfo) (obj));
    }
}
