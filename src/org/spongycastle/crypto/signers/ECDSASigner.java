// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;

// Referenced classes of package org.spongycastle.crypto.signers:
//            RandomDSAKCalculator, DSAKCalculator, HMacDSAKCalculator

public class ECDSASigner
    implements ECConstants, DSA
{

    private SecureRandom amC;
    private final DSAKCalculator aza;
    private ECKeyParameters azc;

    public ECDSASigner()
    {
        aza = new RandomDSAKCalculator();
    }

    public ECDSASigner(HMacDSAKCalculator hmacdsakcalculator)
    {
        aza = hmacdsakcalculator;
    }

    private static BigInteger _mth02CA(BigInteger biginteger, byte abyte0[])
    {
        int i = biginteger.bitLength();
        int j = abyte0.length << 3;
        abyte0 = new BigInteger(1, abyte0);
        biginteger = abyte0;
        if (i < j)
        {
            biginteger = abyte0.shiftRight(j - i);
        }
        return biginteger;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        Object obj = null;
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                azc = (ECPrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                cipherparameters = ((ParametersWithRandom) (cipherparameters)).amC;
            } else
            {
                azc = (ECPrivateKeyParameters)cipherparameters;
                cipherparameters = obj;
            }
        } else
        {
            azc = (ECPublicKeyParameters)cipherparameters;
            cipherparameters = obj;
        }
        boolean flag1;
        if (flag && !aza._mth029D())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            cipherparameters = null;
        } else
        if (cipherparameters == null)
        {
            cipherparameters = new SecureRandom();
        }
        amC = cipherparameters;
    }

    public final boolean _mth02CA(byte abyte0[], BigInteger biginteger, BigInteger biginteger1)
    {
        ECDomainParameters ecdomainparameters = azc.aub;
        BigInteger biginteger2 = ecdomainparameters.alr;
        abyte0 = _mth02CA(biginteger2, abyte0);
        if (biginteger.compareTo(ONE) < 0 || biginteger.compareTo(biginteger2) >= 0)
        {
            return false;
        }
        if (biginteger1.compareTo(ONE) < 0 || biginteger1.compareTo(biginteger2) >= 0)
        {
            return false;
        }
        biginteger1 = biginteger1.modInverse(biginteger2);
        abyte0 = abyte0.multiply(biginteger1).mod(biginteger2);
        biginteger1 = biginteger.multiply(biginteger1).mod(biginteger2);
        abyte0 = ECAlgorithms._mth02CA(ecdomainparameters.axi, abyte0, ((ECPublicKeyParameters)azc).axk, biginteger1)._mth0188();
        if (abyte0._mth021D())
        {
            return false;
        } else
        {
            return abyte0.FF8A().toBigInteger().mod(biginteger2).equals(biginteger);
        }
    }

    public final BigInteger[] _mth1428(byte abyte0[])
    {
        ECDomainParameters ecdomainparameters = azc.aub;
        BigInteger biginteger = ecdomainparameters.alr;
        BigInteger biginteger1 = _mth02CA(biginteger, abyte0);
        BigInteger biginteger2 = ((ECPrivateKeyParameters)azc).awZ;
        if (aza._mth029D())
        {
            aza._mth02CA(biginteger, biginteger2, abyte0);
        } else
        {
            aza._mth02CE(biginteger, amC);
        }
        abyte0 = new FixedPointCombMultiplier();
        BigInteger biginteger3;
        BigInteger biginteger4;
        do
        {
            do
            {
                biginteger4 = aza._mth02AD();
                biginteger3 = abyte0._mth02CA(ecdomainparameters.axi, biginteger4)._mth0188().FF8A().toBigInteger().mod(biginteger);
            } while (biginteger3.equals(ZERO));
            biginteger4 = biginteger4.modInverse(biginteger).multiply(biginteger1.add(biginteger2.multiply(biginteger3))).mod(biginteger);
        } while (biginteger4.equals(ZERO));
        return (new BigInteger[] {
            biginteger3, biginteger4
        });
    }
}
