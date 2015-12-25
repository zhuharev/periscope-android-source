// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

class RSACoreEngine
{

    private boolean amy;
    private RSAKeyParameters asB;

    RSACoreEngine()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithRandom)
        {
            asB = (RSAKeyParameters)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            asB = (RSAKeyParameters)cipherparameters;
        }
        amy = flag;
    }

    public final byte[] _mth02CE(BigInteger biginteger)
    {
        biginteger = biginteger.toByteArray();
        if (amy)
        {
            if (biginteger[0] == 0 && biginteger.length > _mth148E())
            {
                byte abyte0[] = new byte[biginteger.length - 1];
                System.arraycopy(biginteger, 1, abyte0, 0, abyte0.length);
                return abyte0;
            }
            if (biginteger.length < _mth148E())
            {
                byte abyte1[] = new byte[_mth148E()];
                System.arraycopy(biginteger, 0, abyte1, abyte1.length - biginteger.length, biginteger.length);
                return abyte1;
            }
        } else
        if (biginteger[0] == 0)
        {
            byte abyte2[] = new byte[biginteger.length - 1];
            System.arraycopy(biginteger, 1, abyte2, 0, abyte2.length);
            return abyte2;
        }
        return biginteger;
    }

    public final BigInteger _mth02CF(BigInteger biginteger)
    {
        if (asB instanceof RSAPrivateCrtKeyParameters)
        {
            Object obj = (RSAPrivateCrtKeyParameters)asB;
            BigInteger biginteger1 = ((RSAPrivateCrtKeyParameters) (obj)).amM;
            BigInteger biginteger2 = ((RSAPrivateCrtKeyParameters) (obj)).amN;
            BigInteger biginteger4 = ((RSAPrivateCrtKeyParameters) (obj)).axG;
            BigInteger biginteger3 = ((RSAPrivateCrtKeyParameters) (obj)).axH;
            obj = ((RSAPrivateCrtKeyParameters) (obj)).axI;
            biginteger4 = biginteger.remainder(biginteger1).modPow(biginteger4, biginteger1);
            biginteger = biginteger.remainder(biginteger2).modPow(biginteger3, biginteger2);
            return biginteger4.subtract(biginteger).multiply(((BigInteger) (obj))).mod(biginteger1).multiply(biginteger2).add(biginteger);
        } else
        {
            return biginteger.modPow(asB.axE, asB.adi);
        }
    }

    public final BigInteger _mth1427(byte abyte0[], int i, int j)
    {
        if (j > _mth148C() + 1)
        {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (j == _mth148C() + 1 && !amy)
        {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (i != 0 || j != abyte0.length)
        {
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
            abyte0 = abyte1;
        }
        abyte0 = new BigInteger(1, abyte0);
        if (abyte0.compareTo(asB.adi) >= 0)
        {
            throw new DataLengthException("input too large for RSA cipher.");
        } else
        {
            return abyte0;
        }
    }

    public final int _mth148C()
    {
        int i = asB.adi.bitLength();
        if (amy)
        {
            return (i + 7) / 8 - 1;
        } else
        {
            return (i + 7) / 8;
        }
    }

    public final int _mth148E()
    {
        int i = asB.adi.bitLength();
        if (amy)
        {
            return (i + 7) / 8;
        } else
        {
            return (i + 7) / 8 - 1;
        }
    }
}
