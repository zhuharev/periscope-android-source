// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionParameters, IndexGenerator, NTRUEncryptionPublicKeyParameters, NTRUEncryptionPrivateKeyParameters

public class NTRUEngine
    implements AsymmetricBlockCipher
{

    private NTRUEncryptionParameters aMP;
    private NTRUEncryptionPublicKeyParameters aMT;
    private NTRUEncryptionPrivateKeyParameters aMU;
    private SecureRandom amC;
    private boolean amy;

    public NTRUEngine()
    {
    }

    private IntegerPolynomial _mth02CA(byte abyte0[], int i, int j, boolean flag)
    {
        Digest digest = aMP.aMp;
        int l = digest._mth14AF();
        byte abyte1[] = new byte[j * l];
        if (flag)
        {
            byte abyte2[] = new byte[digest._mth14AF()];
            digest.update(abyte0, 0, abyte0.length);
            digest.doFinal(abyte2, 0);
            abyte0 = abyte2;
        }
        int k;
        for (k = 0; k < j; k++)
        {
            digest.update(abyte0, 0, abyte0.length);
            _mth02CA(digest, k);
            byte abyte3[] = new byte[digest._mth14AF()];
            digest.doFinal(abyte3, 0);
            System.arraycopy(abyte3, 0, abyte1, k * l, l);
        }

        IntegerPolynomial integerpolynomial = new IntegerPolynomial(i);
        do
        {
            j = 0;
            for (int i1 = 0; i1 != abyte1.length;)
            {
                int l1 = abyte1[i1] & 0xff;
                int j1 = l1;
                int k1 = j;
                if (l1 < 243)
                {
                    boolean flag1 = false;
                    k1 = j;
                    for (j = ((flag1) ? 1 : 0); j < 4; j++)
                    {
                        int i2 = j1 % 3;
                        integerpolynomial.aPb[k1] = i2 - 1;
                        k1++;
                        if (k1 == i)
                        {
                            return integerpolynomial;
                        }
                        j1 = (j1 - i2) / 3;
                    }

                    integerpolynomial.aPb[k1] = j1 - 1;
                    j = k1 + 1;
                    k1 = j;
                    if (j == i)
                    {
                        return integerpolynomial;
                    }
                }
                i1++;
                j = k1;
            }

            if (j >= i)
            {
                return integerpolynomial;
            }
            digest.update(abyte0, 0, abyte0.length);
            _mth02CA(digest, k);
            abyte1 = new byte[digest._mth14AF()];
            digest.doFinal(abyte1, 0);
            k++;
        } while (true);
    }

    private static void _mth02CA(Digest digest, int i)
    {
        digest.update(i >> 24);
        digest.update((byte)(i >> 16));
        digest.update((byte)(i >> 8));
        digest.update((byte)i);
    }

    private static byte[] _mth02CA(byte abyte0[], byte abyte1[], int i, byte abyte2[], byte abyte3[])
    {
        byte abyte4[] = new byte[abyte0.length + i + abyte2.length + abyte3.length];
        System.arraycopy(abyte0, 0, abyte4, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte4, abyte0.length, abyte1.length);
        System.arraycopy(abyte2, 0, abyte4, abyte0.length + abyte1.length, abyte2.length);
        System.arraycopy(abyte3, 0, abyte4, abyte0.length + abyte1.length + abyte2.length, abyte3.length);
        return abyte4;
    }

    private int[] _mth02CA(IndexGenerator indexgenerator, int i)
    {
        int ai[] = new int[aMP.atY];
        for (int j = -1; j <= 1; j += 2)
        {
            int l;
            for (int k = 0; k < i; k = l)
            {
                int i1 = indexgenerator.nextIndex();
                l = k;
                if (ai[i1] == 0)
                {
                    ai[i1] = j;
                    l = k + 1;
                }
            }

        }

        return ai;
    }

    private Polynomial _mth13A5(byte abyte0[])
    {
        abyte0 = new IndexGenerator(abyte0, aMP);
        if (aMP.aMO == 1)
        {
            return new ProductFormPolynomial(new SparseTernaryPolynomial(_mth02CA(abyte0, aMP.aMy)), new SparseTernaryPolynomial(_mth02CA(abyte0, aMP.aMz)), new SparseTernaryPolynomial(_mth02CA(abyte0, aMP.aMA)));
        }
        int i = aMP.aMx;
        boolean flag = aMP.aMM;
        abyte0 = _mth02CA(abyte0, i);
        if (flag)
        {
            return new SparseTernaryPolynomial(abyte0);
        } else
        {
            return new DenseTernaryPolynomial(abyte0);
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                amC = ((ParametersWithRandom) (cipherparameters)).amC;
                aMT = (NTRUEncryptionPublicKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
            } else
            {
                amC = new SecureRandom();
                aMT = (NTRUEncryptionPublicKeyParameters)cipherparameters;
            }
            aMP = aMT._mth06D2();
            return;
        } else
        {
            aMU = (NTRUEncryptionPrivateKeyParameters)cipherparameters;
            aMP = aMU._mth06D2();
            return;
        }
    }

    public final int _mth148C()
    {
        return aMP.aMD;
    }

    public final int _mth148E()
    {
        int i = aMP.atY;
        if (aMP.aMs != 2048)
        {
            throw new IllegalStateException("log2 not fully implemented");
        } else
        {
            return (i * 11 + 7) / 8;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        byte abyte4[] = new byte[j];
        System.arraycopy(abyte0, i, abyte4, 0, j);
        if (amy)
        {
            abyte0 = aMT.aMS;
            j = aMP.atY;
            int k = aMP.aMs;
            int i1 = aMP.aMD;
            int k1 = aMP.aME;
            int i2 = aMP.aMF;
            int k2 = aMP.aMH;
            int i3 = aMP.aMI;
            int j3 = aMP.aMJ;
            boolean flag = aMP.aMK;
            byte abyte1[] = aMP.aML;
            int k3 = abyte4.length;
            if (i1 > 255)
            {
                throw new IllegalArgumentException("llen values bigger than 1 are not supported");
            }
            if (k3 > i1)
            {
                throw new DataLengthException((new StringBuilder("Message too long: ")).append(k3).append(">").append(i1).toString());
            }
            IntegerPolynomial integerpolynomial;
            IntegerPolynomial integerpolynomial2;
            do
            {
                byte abyte2[] = new byte[k1 / 8];
                amC.nextBytes(abyte2);
                byte abyte5[] = new byte[(i1 + 1) - k3];
                byte abyte7[] = new byte[i2 / 8];
                System.arraycopy(abyte2, 0, abyte7, 0, abyte2.length);
                abyte7[abyte2.length] = (byte)k3;
                System.arraycopy(abyte4, 0, abyte7, abyte2.length + 1, abyte4.length);
                System.arraycopy(abyte5, 0, abyte7, abyte2.length + 1 + abyte4.length, abyte5.length);
                integerpolynomial2 = IntegerPolynomial.FE7A(abyte7, j);
                abyte7 = ArrayEncoder._mth02BC(((IntegerPolynomial) (abyte0)).aPb, k);
                i = i3 / 8;
                byte abyte9[] = new byte[i];
                if (i >= abyte7.length)
                {
                    i = abyte7.length;
                }
                System.arraycopy(abyte7, 0, abyte9, 0, i);
                integerpolynomial = _mth13A5(_mth02CA(abyte1, abyte4, k3, abyte2, abyte9))._mth02CA(abyte0, k);
                IntegerPolynomial integerpolynomial4 = (IntegerPolynomial)integerpolynomial.clone();
                integerpolynomial4._mth0E27(4);
                integerpolynomial2._mth02CE(_mth02CA(ArrayEncoder._mth02BC(integerpolynomial4.aPb, 4), j, j3, flag));
                integerpolynomial2._mth15BA();
            } while (integerpolynomial2._mth1D16(-1) < k2 || integerpolynomial2._mth1D16(0) < k2 || integerpolynomial2._mth1D16(1) < k2);
            integerpolynomial._mth02CE(integerpolynomial2, k);
            integerpolynomial._mth1484(k);
            return ArrayEncoder._mth02BC(integerpolynomial.aPb, k);
        }
        Object obj = aMU;
        abyte0 = ((NTRUEncryptionPrivateKeyParameters) (obj)).aMQ;
        IntegerPolynomial integerpolynomial3 = ((NTRUEncryptionPrivateKeyParameters) (obj)).aMR;
        obj = ((NTRUEncryptionPrivateKeyParameters) (obj)).aMS;
        int j1 = aMP.atY;
        j = aMP.aMs;
        int l2 = aMP.aME;
        i = aMP.aMD;
        int l1 = aMP.aMH;
        int l = aMP.aMI;
        int j2 = aMP.aMJ;
        boolean flag1 = aMP.aMK;
        byte abyte3[] = aMP.aML;
        if (i > 255)
        {
            throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
        }
        l2 /= 8;
        IntegerPolynomial integerpolynomial1 = IntegerPolynomial._mth2071(abyte4, j1, j);
        if (aMP.aMN)
        {
            abyte0 = abyte0._mth02CA(integerpolynomial1, aMP.aMs);
            abyte0._mth0719(3);
            abyte0._mth02CE(integerpolynomial1);
        } else
        {
            abyte0 = abyte0._mth02CA(integerpolynomial1, aMP.aMs);
        }
        abyte0._mth1506(aMP.aMs);
        abyte0._mth15BA();
        if (!aMP.aMN)
        {
            abyte0 = (new DenseTernaryPolynomial(abyte0))._mth02CA(integerpolynomial3, 3);
        }
        abyte0._mth1506(3);
        if (abyte0._mth1D16(-1) < l1)
        {
            throw new InvalidCipherTextException("Less than dm0 coefficients equal -1");
        }
        if (abyte0._mth1D16(0) < l1)
        {
            throw new InvalidCipherTextException("Less than dm0 coefficients equal 0");
        }
        if (abyte0._mth1D16(1) < l1)
        {
            throw new InvalidCipherTextException("Less than dm0 coefficients equal 1");
        }
        integerpolynomial1 = (IntegerPolynomial)integerpolynomial1.clone();
        integerpolynomial1._mth02CF(abyte0);
        integerpolynomial1._mth0E27(j);
        integerpolynomial3 = (IntegerPolynomial)integerpolynomial1.clone();
        integerpolynomial3._mth0E27(4);
        abyte0._mth02CF(_mth02CA(ArrayEncoder._mth02BC(integerpolynomial3.aPb, 4), j1, j2, flag1));
        abyte0._mth15BA();
        byte abyte8[] = ArrayEncoder.FE73(((IntegerPolynomial) (abyte0)).aPb);
        byte abyte6[] = new byte[l2];
        System.arraycopy(abyte8, 0, abyte6, 0, l2);
        j1 = abyte8[l2] & 0xff;
        if (j1 > i)
        {
            throw new InvalidCipherTextException((new StringBuilder("Message too long: ")).append(j1).append(">").append(i).toString());
        }
        abyte0 = new byte[j1];
        System.arraycopy(abyte8, l2 + 1, abyte0, 0, j1);
        byte abyte10[] = new byte[abyte8.length - (l2 + 1 + j1)];
        System.arraycopy(abyte8, l2 + 1 + j1, abyte10, 0, abyte10.length);
        if (!Arrays._mth1427(abyte10, new byte[abyte10.length]))
        {
            throw new InvalidCipherTextException("The message is not followed by zeroes");
        }
        abyte8 = ArrayEncoder._mth02BC(((IntegerPolynomial) (obj)).aPb, j);
        i = l / 8;
        abyte10 = new byte[i];
        if (i >= abyte8.length)
        {
            i = abyte8.length;
        }
        System.arraycopy(abyte8, 0, abyte10, 0, i);
        obj = _mth13A5(_mth02CA(abyte3, abyte0, j1, abyte6, abyte10))._mth02CA(((IntegerPolynomial) (obj)));
        ((IntegerPolynomial) (obj))._mth0E27(j);
        if (!((IntegerPolynomial) (obj)).equals(integerpolynomial1))
        {
            throw new InvalidCipherTextException("Invalid message encoding");
        } else
        {
            return abyte0;
        }
    }
}
