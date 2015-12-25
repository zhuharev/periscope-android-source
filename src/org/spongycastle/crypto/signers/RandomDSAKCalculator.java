// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.crypto.signers:
//            DSAKCalculator

class RandomDSAKCalculator
    implements DSAKCalculator
{

    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    private SecureRandom amC;
    private BigInteger amN;

    RandomDSAKCalculator()
    {
    }

    public final boolean _mth029D()
    {
        return false;
    }

    public final BigInteger _mth02AD()
    {
        int i = amN.bitLength();
        BigInteger biginteger;
        do
        {
            biginteger = new BigInteger(i, amC);
        } while (biginteger.equals(ZERO) || biginteger.compareTo(amN) >= 0);
        return biginteger;
    }

    public final void _mth02CA(BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        throw new IllegalStateException("Operation not supported");
    }

    public final void _mth02CE(BigInteger biginteger, SecureRandom securerandom)
    {
        amN = biginteger;
        amC = securerandom;
    }

}
