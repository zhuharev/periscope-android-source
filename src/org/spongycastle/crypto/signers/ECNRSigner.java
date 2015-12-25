// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public class ECNRSigner
    implements DSA
{

    private SecureRandom amC;
    private boolean ayZ;
    private ECKeyParameters azc;

    public ECNRSigner()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        ayZ = flag;
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
        if (ayZ)
        {
            throw new IllegalStateException("not initialised for verifying");
        }
        ECPublicKeyParameters ecpublickeyparameters = (ECPublicKeyParameters)azc;
        BigInteger biginteger2 = ((ECKeyParameters) (ecpublickeyparameters)).aub.alr;
        int i = biginteger2.bitLength();
        abyte0 = new BigInteger(1, abyte0);
        if (abyte0.bitLength() > i)
        {
            throw new DataLengthException("input too large for ECNR key.");
        }
        if (biginteger.compareTo(ECConstants.ONE) < 0 || biginteger.compareTo(biginteger2) >= 0)
        {
            return false;
        }
        if (biginteger1.compareTo(ECConstants.ZERO) < 0 || biginteger1.compareTo(biginteger2) >= 0)
        {
            return false;
        }
        biginteger1 = ECAlgorithms._mth02CA(((ECKeyParameters) (ecpublickeyparameters)).aub.axi, biginteger1, ecpublickeyparameters.axk, biginteger)._mth0188();
        if (biginteger1._mth021D())
        {
            return false;
        } else
        {
            return biginteger.subtract(biginteger1.FF8A().toBigInteger()).mod(biginteger2).equals(abyte0);
        }
    }

    public final BigInteger[] _mth1428(byte abyte0[])
    {
        if (!ayZ)
        {
            throw new IllegalStateException("not initialised for signing");
        }
        BigInteger biginteger = ((ECKeyParameters) ((ECPrivateKeyParameters)azc)).aub.alr;
        int i = biginteger.bitLength();
        abyte0 = new BigInteger(1, abyte0);
        int j = abyte0.bitLength();
        ECPrivateKeyParameters ecprivatekeyparameters = (ECPrivateKeyParameters)azc;
        if (j > i)
        {
            throw new DataLengthException("input too large for ECNR key.");
        }
        Object obj;
        BigInteger biginteger1;
        do
        {
            obj = new ECKeyPairGenerator();
            ((ECKeyPairGenerator) (obj))._mth02CA(new ECKeyGenerationParameters(((ECKeyParameters) (ecprivatekeyparameters)).aub, amC));
            obj = ((ECKeyPairGenerator) (obj))._mth1491();
            biginteger1 = ((ECPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu).axk.FF8A().toBigInteger().add(abyte0).mod(biginteger);
        } while (biginteger1.equals(ECConstants.ZERO));
        abyte0 = ecprivatekeyparameters.awZ;
        return (new BigInteger[] {
            biginteger1, ((ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv).awZ.subtract(biginteger1.multiply(abyte0)).mod(biginteger)
        });
    }
}
