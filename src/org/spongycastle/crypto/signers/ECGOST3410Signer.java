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

public class ECGOST3410Signer
    implements DSA
{

    private SecureRandom amC;
    private ECKeyParameters azc;

    public ECGOST3410Signer()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                amC = ((ParametersWithRandom) (cipherparameters)).amC;
                azc = (ECPrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                return;
            } else
            {
                amC = new SecureRandom();
                azc = (ECPrivateKeyParameters)cipherparameters;
                return;
            }
        } else
        {
            azc = (ECPublicKeyParameters)cipherparameters;
            return;
        }
    }

    public final boolean _mth02CA(byte abyte0[], BigInteger biginteger, BigInteger biginteger1)
    {
        byte abyte1[] = new byte[abyte0.length];
        for (int i = 0; i != abyte1.length; i++)
        {
            abyte1[i] = abyte0[abyte1.length - 1 - i];
        }

        BigInteger biginteger2 = new BigInteger(1, abyte1);
        abyte0 = azc.aub.alr;
        if (biginteger.compareTo(ECConstants.ONE) < 0 || biginteger.compareTo(abyte0) >= 0)
        {
            return false;
        }
        if (biginteger1.compareTo(ECConstants.ONE) < 0 || biginteger1.compareTo(abyte0) >= 0)
        {
            return false;
        }
        biginteger2 = biginteger2.modInverse(abyte0);
        biginteger1 = biginteger1.multiply(biginteger2).mod(abyte0);
        biginteger2 = abyte0.subtract(biginteger).multiply(biginteger2).mod(abyte0);
        biginteger1 = ECAlgorithms._mth02CA(azc.aub.axi, biginteger1, ((ECPublicKeyParameters)azc).axk, biginteger2)._mth0188();
        if (biginteger1._mth021D())
        {
            return false;
        } else
        {
            return biginteger1.FF8A().toBigInteger().mod(abyte0).equals(biginteger);
        }
    }

    public final BigInteger[] _mth1428(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length];
        for (int i = 0; i != abyte1.length; i++)
        {
            abyte1[i] = abyte0[abyte1.length - 1 - i];
        }

        abyte0 = new BigInteger(1, abyte1);
        ECDomainParameters ecdomainparameters = azc.aub;
        BigInteger biginteger = ecdomainparameters.alr;
        BigInteger biginteger1 = ((ECPrivateKeyParameters)azc).awZ;
        FixedPointCombMultiplier fixedpointcombmultiplier = new FixedPointCombMultiplier();
        BigInteger biginteger2;
        BigInteger biginteger3;
        do
        {
            do
            {
                do
                {
                    biginteger3 = new BigInteger(biginteger.bitLength(), amC);
                } while (biginteger3.equals(ECConstants.ZERO));
                biginteger2 = fixedpointcombmultiplier._mth02CA(ecdomainparameters.axi, biginteger3)._mth0188().FF8A().toBigInteger().mod(biginteger);
            } while (biginteger2.equals(ECConstants.ZERO));
            biginteger3 = biginteger3.multiply(abyte0).add(biginteger1.multiply(biginteger2)).mod(biginteger);
        } while (biginteger3.equals(ECConstants.ZERO));
        return (new BigInteger[] {
            biginteger2, biginteger3
        });
    }
}
