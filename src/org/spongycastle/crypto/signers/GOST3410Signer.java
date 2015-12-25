// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.GOST3410KeyParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class GOST3410Signer
    implements DSA
{

    private SecureRandom amC;
    private GOST3410KeyParameters azd;

    public GOST3410Signer()
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
                azd = (GOST3410PrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                return;
            } else
            {
                amC = new SecureRandom();
                azd = (GOST3410PrivateKeyParameters)cipherparameters;
                return;
            }
        } else
        {
            azd = (GOST3410PublicKeyParameters)cipherparameters;
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
        abyte0 = azd.axm;
        BigInteger biginteger3 = BigInteger.valueOf(0L);
        if (biginteger3.compareTo(biginteger) >= 0 || ((GOST3410Parameters) (abyte0)).amN.compareTo(biginteger) <= 0)
        {
            return false;
        }
        if (biginteger3.compareTo(biginteger1) >= 0 || ((GOST3410Parameters) (abyte0)).amN.compareTo(biginteger1) <= 0)
        {
            return false;
        } else
        {
            biginteger2 = biginteger2.modPow(((GOST3410Parameters) (abyte0)).amN.subtract(new BigInteger("2")), ((GOST3410Parameters) (abyte0)).amN);
            biginteger1 = biginteger1.multiply(biginteger2).mod(((GOST3410Parameters) (abyte0)).amN);
            biginteger2 = ((GOST3410Parameters) (abyte0)).amN.subtract(biginteger).multiply(biginteger2).mod(((GOST3410Parameters) (abyte0)).amN);
            return ((GOST3410Parameters) (abyte0)).amW.modPow(biginteger1, ((GOST3410Parameters) (abyte0)).amM).multiply(((GOST3410PublicKeyParameters)azd).axe.modPow(biginteger2, ((GOST3410Parameters) (abyte0)).amM)).mod(((GOST3410Parameters) (abyte0)).amM).mod(((GOST3410Parameters) (abyte0)).amN).equals(biginteger);
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
        GOST3410Parameters gost3410parameters = azd.axm;
        BigInteger biginteger;
        do
        {
            biginteger = new BigInteger(gost3410parameters.amN.bitLength(), amC);
        } while (biginteger.compareTo(gost3410parameters.amN) >= 0);
        BigInteger biginteger1 = gost3410parameters.amW.modPow(biginteger, gost3410parameters.amM).mod(gost3410parameters.amN);
        return (new BigInteger[] {
            biginteger1, biginteger.multiply(abyte0).add(((GOST3410PrivateKeyParameters)azd).amZ.multiply(biginteger1)).mod(gost3410parameters.amN)
        });
    }
}
