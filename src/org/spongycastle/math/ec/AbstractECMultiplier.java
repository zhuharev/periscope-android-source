// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            ECMultiplier, ECPoint, ECCurve, ECAlgorithms

public abstract class AbstractECMultiplier
    implements ECMultiplier
{

    public AbstractECMultiplier()
    {
    }

    public final ECPoint _mth02CA(ECPoint ecpoint, BigInteger biginteger)
    {
        int i = biginteger.signum();
        if (i == 0 || ecpoint._mth021D())
        {
            return ecpoint.FF79()._mth5B80();
        }
        ecpoint = _mth02CB(ecpoint, biginteger.abs());
        if (i <= 0)
        {
            ecpoint = ecpoint._mth029C();
        }
        return ECAlgorithms._mth02CB(ecpoint);
    }

    protected abstract ECPoint _mth02CB(ECPoint ecpoint, BigInteger biginteger);
}
