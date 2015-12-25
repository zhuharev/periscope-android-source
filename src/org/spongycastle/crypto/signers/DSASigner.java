// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

// Referenced classes of package org.spongycastle.crypto.signers:
//            RandomDSAKCalculator, DSAKCalculator, HMacDSAKCalculator

public class DSASigner
    implements DSA
{

    private SecureRandom amC;
    private final DSAKCalculator aza;
    private DSAKeyParameters azb;

    public DSASigner()
    {
        aza = new RandomDSAKCalculator();
    }

    public DSASigner(HMacDSAKCalculator hmacdsakcalculator)
    {
        aza = hmacdsakcalculator;
    }

    private static BigInteger _mth02CA(BigInteger biginteger, byte abyte0[])
    {
        if (biginteger.bitLength() >= abyte0.length << 3)
        {
            return new BigInteger(1, abyte0);
        } else
        {
            biginteger = new byte[biginteger.bitLength() / 8];
            System.arraycopy(abyte0, 0, biginteger, 0, biginteger.length);
            return new BigInteger(1, biginteger);
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        Object obj = null;
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                azb = (DSAPrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                cipherparameters = ((ParametersWithRandom) (cipherparameters)).amC;
            } else
            {
                azb = (DSAPrivateKeyParameters)cipherparameters;
                cipherparameters = obj;
            }
        } else
        {
            azb = (DSAPublicKeyParameters)cipherparameters;
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
        DSAParameters dsaparameters = azb.axf;
        abyte0 = _mth02CA(dsaparameters.amN, abyte0);
        BigInteger biginteger2 = BigInteger.valueOf(0L);
        if (biginteger2.compareTo(biginteger) >= 0 || dsaparameters.amN.compareTo(biginteger) <= 0)
        {
            return false;
        }
        if (biginteger2.compareTo(biginteger1) >= 0 || dsaparameters.amN.compareTo(biginteger1) <= 0)
        {
            return false;
        } else
        {
            biginteger1 = biginteger1.modInverse(dsaparameters.amN);
            abyte0 = abyte0.multiply(biginteger1).mod(dsaparameters.amN);
            biginteger1 = biginteger.multiply(biginteger1).mod(dsaparameters.amN);
            return dsaparameters.amO.modPow(abyte0, dsaparameters.amM).multiply(((DSAPublicKeyParameters)azb).axe.modPow(biginteger1, dsaparameters.amM)).mod(dsaparameters.amM).mod(dsaparameters.amN).equals(biginteger);
        }
    }

    public final BigInteger[] _mth1428(byte abyte0[])
    {
        DSAParameters dsaparameters = azb.axf;
        BigInteger biginteger = _mth02CA(dsaparameters.amN, abyte0);
        if (aza._mth029D())
        {
            aza._mth02CA(dsaparameters.amN, ((DSAPrivateKeyParameters)azb).amZ, abyte0);
        } else
        {
            aza._mth02CE(dsaparameters.amN, amC);
        }
        abyte0 = aza._mth02AD();
        BigInteger biginteger1 = dsaparameters.amO.modPow(abyte0, dsaparameters.amM).mod(dsaparameters.amN);
        return (new BigInteger[] {
            biginteger1, abyte0.modInverse(dsaparameters.amN).multiply(biginteger.add(((DSAPrivateKeyParameters)azb).amZ.multiply(biginteger1))).mod(dsaparameters.amN)
        });
    }
}
