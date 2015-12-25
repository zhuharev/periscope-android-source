// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GeneralDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAValidationParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;

public class DSAParametersGenerator
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    private static final BigInteger ars = BigInteger.valueOf(2L);
    private SecureRandom amC;
    private Digest amS;
    private int atV;
    private int atX;
    private int atY;
    private boolean atZ;
    private int aua;

    public DSAParametersGenerator()
    {
        this(((GeneralDigest) (new SHA1Digest())));
    }

    public DSAParametersGenerator(GeneralDigest generaldigest)
    {
        amS = generaldigest;
    }

    private static void _mth02B4(byte abyte0[])
    {
        int i = abyte0.length - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            byte byte0 = (byte)(abyte0[i] + 1);
            abyte0[i] = byte0;
            if (byte0 != 0)
            {
                break;
            }
            i--;
        } while (true);
    }

    private static BigInteger _mth02CA(BigInteger biginteger, BigInteger biginteger1, SecureRandom securerandom)
    {
        biginteger1 = biginteger.subtract(ONE).divide(biginteger1);
        BigInteger biginteger2 = biginteger.subtract(ars);
        BigInteger biginteger3;
        do
        {
            biginteger3 = BigIntegers._mth02CB(ars, biginteger2, securerandom).modPow(biginteger1, biginteger);
        } while (biginteger3.bitLength() <= 1);
        return biginteger3;
    }

    private static BigInteger _mth02CA(Digest digest, BigInteger biginteger, BigInteger biginteger1, byte abyte0[], int i)
    {
        biginteger1 = biginteger.subtract(ONE).divide(biginteger1);
        byte abyte2[] = Hex._mth1508("6767656E");
        byte abyte1[] = new byte[abyte0.length + abyte2.length + 1 + 2];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        System.arraycopy(abyte2, 0, abyte1, abyte0.length, abyte2.length);
        abyte1[abyte1.length - 3] = (byte)i;
        abyte0 = new byte[digest._mth14AF()];
        for (i = 1; i < 0x10000; i++)
        {
            _mth02B4(abyte1);
            digest.update(abyte1, 0, abyte1.length);
            digest.doFinal(abyte0, 0);
            BigInteger biginteger2 = (new BigInteger(1, abyte0)).modPow(biginteger1, biginteger);
            if (biginteger2.compareTo(ars) >= 0)
            {
                return biginteger2;
            }
        }

        return null;
    }

    private DSAParameters FEE1()
    {
        byte abyte0[] = new byte[20];
        byte abyte1[] = new byte[20];
        byte abyte2[] = new byte[20];
        byte abyte3[] = new byte[20];
        int l = (atX - 1) / 160;
        byte abyte4[] = new byte[atX / 8];
        if (!(amS instanceof SHA1Digest))
        {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
        do
        {
            Object obj;
            do
            {
                amC.nextBytes(abyte0);
                obj = amS;
                ((Digest) (obj)).update(abyte0, 0, abyte0.length);
                ((Digest) (obj)).doFinal(abyte1, 0);
                System.arraycopy(abyte0, 0, abyte2, 0, 20);
                _mth02B4(abyte2);
                obj = amS;
                ((Digest) (obj)).update(abyte2, 0, abyte2.length);
                ((Digest) (obj)).doFinal(abyte2, 0);
                for (int i = 0; i != 20; i++)
                {
                    abyte3[i] = (byte)(abyte1[i] ^ abyte2[i]);
                }

                abyte3[0] = (byte)(abyte3[0] | 0xffffff80);
                abyte3[19] = (byte)(abyte3[19] | 1);
                obj = new BigInteger(1, abyte3);
            } while (!((BigInteger) (obj)).isProbablePrime(atV));
            byte abyte5[] = Arrays._mth1D4C(abyte0);
            _mth02B4(abyte5);
            int j = 0;
            while (j < 4096) 
            {
                for (int k = 0; k < l; k++)
                {
                    _mth02B4(abyte5);
                    Digest digest = amS;
                    digest.update(abyte5, 0, abyte5.length);
                    digest.doFinal(abyte1, 0);
                    System.arraycopy(abyte1, 0, abyte4, abyte4.length - (k + 1) * 20, 20);
                }

                _mth02B4(abyte5);
                Object obj1 = amS;
                ((Digest) (obj1)).update(abyte5, 0, abyte5.length);
                ((Digest) (obj1)).doFinal(abyte1, 0);
                System.arraycopy(abyte1, 20 - (abyte4.length - l * 20), abyte4, 0, abyte4.length - l * 20);
                abyte4[0] = (byte)(abyte4[0] | 0xffffff80);
                obj1 = new BigInteger(1, abyte4);
                obj1 = ((BigInteger) (obj1)).subtract(((BigInteger) (obj1)).mod(((BigInteger) (obj)).shiftLeft(1)).subtract(ONE));
                if (((BigInteger) (obj1)).bitLength() == atX && ((BigInteger) (obj1)).isProbablePrime(atV))
                {
                    return new DSAParameters(((BigInteger) (obj1)), ((BigInteger) (obj)), _mth02CA(((BigInteger) (obj1)), ((BigInteger) (obj)), amC), new DSAValidationParameters(abyte0, j));
                }
                j++;
            }
        } while (true);
    }

    public final void _mth02CA(DSAParameterGenerationParameters dsaparametergenerationparameters)
    {
        atZ = true;
        atX = dsaparametergenerationparameters.afM;
        atY = dsaparametergenerationparameters.axg;
        atV = dsaparametergenerationparameters.atV;
        amC = dsaparametergenerationparameters.amC;
        aua = dsaparametergenerationparameters.aua;
        if (atX < 1024 || atX > 3072 || atX % 1024 != 0)
        {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (atX == 1024 && atY != 160)
        {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        }
        if (atX == 2048 && atY != 224 && atY != 256)
        {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        }
        if (atX == 3072 && atY != 256)
        {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        }
        if (amS._mth14AF() << 3 < atY)
        {
            throw new IllegalStateException("Digest output size too small for value of N");
        } else
        {
            return;
        }
    }

    public final void _mth02CB(int i, int j, SecureRandom securerandom)
    {
        atZ = false;
        atX = i;
        if (i > 1024)
        {
            i = 256;
        } else
        {
            i = 160;
        }
        atY = i;
        atV = j;
        amC = securerandom;
    }

    public final DSAParameters FEA3()
    {
        if (atZ)
        {
            Digest digest = amS;
            int l = digest._mth14AF() << 3;
            byte abyte0[] = new byte[atY / 8];
            int i1 = (atX - 1) / l;
            int j1 = atX;
            byte abyte1[] = new byte[digest._mth14AF()];
            do
            {
                BigInteger biginteger5;
                do
                {
                    amC.nextBytes(abyte0);
                    digest.update(abyte0, 0, abyte0.length);
                    digest.doFinal(abyte1, 0);
                    BigInteger biginteger = (new BigInteger(1, abyte1)).mod(ONE.shiftLeft(atY - 1));
                    biginteger5 = ONE.shiftLeft(atY - 1).add(biginteger).add(ONE).subtract(biginteger.mod(ars));
                } while (!biginteger5.isProbablePrime(atV));
                byte abyte2[] = Arrays._mth1D4C(abyte0);
                int k1 = atX;
                int i = 0;
                while (i < k1 * 4) 
                {
                    BigInteger biginteger1 = ZERO;
                    int k = 0;
                    for (int j = 0; k <= i1; j += l)
                    {
                        _mth02B4(abyte2);
                        digest.update(abyte2, 0, abyte2.length);
                        digest.doFinal(abyte1, 0);
                        BigInteger biginteger4 = new BigInteger(1, abyte1);
                        BigInteger biginteger2 = biginteger4;
                        if (k == i1)
                        {
                            biginteger2 = biginteger4.mod(ONE.shiftLeft((j1 - 1) % l));
                        }
                        biginteger1 = biginteger1.add(biginteger2.shiftLeft(j));
                        k++;
                    }

                    biginteger1 = biginteger1.add(ONE.shiftLeft(atX - 1));
                    biginteger1 = biginteger1.subtract(biginteger1.mod(biginteger5.shiftLeft(1)).subtract(ONE));
                    if (biginteger1.bitLength() == atX && biginteger1.isProbablePrime(atV))
                    {
                        if (aua >= 0)
                        {
                            BigInteger biginteger3 = _mth02CA(digest, biginteger1, biginteger5, abyte0, aua);
                            if (biginteger3 != null)
                            {
                                return new DSAParameters(biginteger1, biginteger5, biginteger3, new DSAValidationParameters(abyte0, i, aua));
                            }
                        }
                        return new DSAParameters(biginteger1, biginteger5, _mth02CA(biginteger1, biginteger5, amC), new DSAValidationParameters(abyte0, i));
                    }
                    i++;
                }
            } while (true);
        } else
        {
            return FEE1();
        }
    }

}
