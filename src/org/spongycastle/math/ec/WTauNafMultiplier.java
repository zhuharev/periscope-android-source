// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            AbstractECMultiplier, ECFieldElement, WTauNafPreCompInfo, Tnaf, 
//            ECCurve, PreCompInfo, ECPoint

public class WTauNafMultiplier extends AbstractECMultiplier
{

    public WTauNafMultiplier()
    {
    }

    private static ECPoint.F2m _mth02CA(ECPoint.F2m f2m, byte abyte0[], PreCompInfo precompinfo)
    {
        ECCurve.F2m f2m1 = (ECCurve.F2m)f2m.FF79();
        byte byte0 = f2m1.FB46().toBigInteger().byteValue();
        if (precompinfo == null || !(precompinfo instanceof WTauNafPreCompInfo))
        {
            precompinfo = Tnaf._mth02CA(f2m, byte0);
            WTauNafPreCompInfo wtaunafprecompinfo = new WTauNafPreCompInfo();
            wtaunafprecompinfo._mth02CA(precompinfo);
            f2m1._mth02CA(f2m, "bc_wtnaf", wtaunafprecompinfo);
        } else
        {
            precompinfo = ((WTauNafPreCompInfo)precompinfo)._mth0421();
        }
        f2m = (ECPoint.F2m)f2m.FF79()._mth5B80();
        for (int i = abyte0.length - 1; i >= 0; i--)
        {
            ECPoint.F2m f2m2 = Tnaf._mth02CB(f2m);
            byte byte1 = abyte0[i];
            f2m = f2m2;
            if (byte1 == 0)
            {
                continue;
            }
            if (byte1 > 0)
            {
                f2m = f2m2._mth02CA(precompinfo[byte1]);
                continue;
            }
            f2m = precompinfo[-byte1];
            if (f2m._mth021D())
            {
                f2m = f2m2;
            } else
            {
                f2m = f2m2._mth02CA((ECPoint.F2m)f2m._mth029C());
            }
        }

        return f2m;
    }

    protected final ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger)
    {
        if (!(ecpoint instanceof ECPoint.F2m))
        {
            throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
        }
        ECPoint.F2m f2m = (ECPoint.F2m)ecpoint;
        ecpoint = (ECCurve.F2m)f2m.FF79();
        int i = ((ECCurve.F2m) (ecpoint)).afJ;
        byte byte0 = ecpoint.FB46().toBigInteger().byteValue();
        byte byte1 = ecpoint.FECC();
        biginteger = Tnaf._mth02CA(biginteger, i, byte0, ecpoint.FEE2(), byte1, (byte)10);
        PreCompInfo precompinfo = ecpoint._mth02CA(f2m, "bc_wtnaf");
        if (byte0 == 0)
        {
            ecpoint = Tnaf.aIZ;
        } else
        {
            ecpoint = Tnaf.aJb;
        }
        BigInteger biginteger1 = Tnaf._mth02CA(byte1, 4);
        return _mth02CA(f2m, Tnaf._mth02CA(byte1, biginteger, (byte)4, BigInteger.valueOf(16L), biginteger1, ecpoint), precompinfo);
    }
}
