// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.BigIntegers;

public class ElGamalEngine
    implements AsymmetricBlockCipher
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    private static final BigInteger ars = BigInteger.valueOf(2L);
    private SecureRandom amC;
    private boolean amy;
    private int apP;
    private ElGamalKeyParameters arr;

    public ElGamalEngine()
    {
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            arr = (ElGamalKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
            amC = ((ParametersWithRandom) (cipherparameters)).amC;
        } else
        {
            arr = (ElGamalKeyParameters)cipherparameters;
            amC = new SecureRandom();
        }
        amy = flag;
        apP = arr.axl.amM.bitLength();
        if (flag)
        {
            if (!(arr instanceof ElGamalPublicKeyParameters))
            {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else
        if (!(arr instanceof ElGamalPrivateKeyParameters))
        {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    public final int _mth148C()
    {
        if (amy)
        {
            return (apP - 1) / 8;
        } else
        {
            return ((apP + 7) / 8) * 2;
        }
    }

    public final int _mth148E()
    {
        if (amy)
        {
            return ((apP + 7) / 8) * 2;
        } else
        {
            return (apP - 1) / 8;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (arr == null)
        {
            throw new IllegalStateException("ElGamal engine not initialised");
        }
        int k;
        if (amy)
        {
            k = ((apP - 1) + 7) / 8;
        } else
        if (amy)
        {
            k = (apP - 1) / 8;
        } else
        {
            k = ((apP + 7) / 8) * 2;
        }
        if (j > k)
        {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        BigInteger biginteger2 = arr.axl.amM;
        if (arr instanceof ElGamalPrivateKeyParameters)
        {
            byte abyte5[] = new byte[j / 2];
            byte abyte1[] = new byte[j / 2];
            System.arraycopy(abyte0, i, abyte5, 0, abyte5.length);
            System.arraycopy(abyte0, abyte5.length + i, abyte1, 0, abyte1.length);
            abyte0 = new BigInteger(1, abyte5);
            BigInteger biginteger = new BigInteger(1, abyte1);
            ElGamalPrivateKeyParameters elgamalprivatekeyparameters = (ElGamalPrivateKeyParameters)arr;
            return BigIntegers._mth02D1(abyte0.modPow(biginteger2.subtract(ONE).subtract(elgamalprivatekeyparameters.amZ), biginteger2).multiply(biginteger).mod(biginteger2));
        }
        if (i != 0 || j != abyte0.length)
        {
            byte abyte2[] = new byte[j];
            System.arraycopy(abyte0, i, abyte2, 0, j);
            abyte0 = abyte2;
        }
        BigInteger biginteger1 = new BigInteger(1, abyte0);
        if (biginteger1.compareTo(biginteger2) >= 0)
        {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        ElGamalPublicKeyParameters elgamalpublickeyparameters = (ElGamalPublicKeyParameters)arr;
        i = biginteger2.bitLength();
        for (abyte0 = new BigInteger(i, amC); abyte0.equals(ZERO) || abyte0.compareTo(biginteger2.subtract(ars)) > 0; abyte0 = new BigInteger(i, amC)) { }
        BigInteger biginteger3 = arr.axl.amO.modPow(abyte0, biginteger2);
        biginteger1 = biginteger1.multiply(elgamalpublickeyparameters.axe.modPow(abyte0, biginteger2)).mod(biginteger2);
        abyte0 = biginteger3.toByteArray();
        byte abyte3[] = biginteger1.toByteArray();
        if (amy)
        {
            i = ((apP + 7) / 8) * 2;
        } else
        {
            i = (apP - 1) / 8;
        }
        byte abyte4[] = new byte[i];
        if (abyte0.length > abyte4.length / 2)
        {
            System.arraycopy(abyte0, 1, abyte4, abyte4.length / 2 - (abyte0.length - 1), abyte0.length - 1);
        } else
        {
            System.arraycopy(abyte0, 0, abyte4, abyte4.length / 2 - abyte0.length, abyte0.length);
        }
        if (abyte3.length > abyte4.length / 2)
        {
            System.arraycopy(abyte3, 1, abyte4, abyte4.length - (abyte3.length - 1), abyte3.length - 1);
            return abyte4;
        } else
        {
            System.arraycopy(abyte3, 0, abyte4, abyte4.length - abyte3.length, abyte3.length);
            return abyte4;
        }
    }

}
