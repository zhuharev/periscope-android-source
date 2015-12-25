// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.encodings;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding
    implements AsymmetricBlockCipher
{

    private static final BigInteger apK = BigInteger.valueOf(16L);
    private static final BigInteger apL = BigInteger.valueOf(6L);
    private static byte apM[] = {
        14, 3, 5, 8, 9, 4, 2, 15, 0, 13, 
        11, 6, 7, 10, 12, 1
    };
    private static byte apN[] = {
        8, 15, 6, 1, 5, 2, 11, 12, 3, 4, 
        13, 10, 14, 9, 0, 7
    };
    private int WE;
    private BigInteger adi;
    private boolean amy;
    private AsymmetricBlockCipher apO;
    private int apP;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricblockcipher)
    {
        WE = 0;
        apO = asymmetricblockcipher;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        RSAKeyParameters rsakeyparameters;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            rsakeyparameters = (RSAKeyParameters)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            rsakeyparameters = (RSAKeyParameters)cipherparameters;
        }
        apO._mth02CA(flag, cipherparameters);
        adi = rsakeyparameters.adi;
        apP = adi.bitLength();
        amy = flag;
    }

    public final int _mth148C()
    {
        int i = apO._mth148C();
        if (amy)
        {
            return (i + 1) / 2;
        } else
        {
            return i;
        }
    }

    public final int _mth148E()
    {
        int i = apO._mth148E();
        if (amy)
        {
            return i;
        } else
        {
            return (i + 1) / 2;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (amy)
        {
            byte abyte1[] = new byte[(apP + 7) / 8];
            int i1 = WE;
            int j1 = (apP + 13) / 16;
            for (int k = 0; k < j1; k += j)
            {
                if (k > j1 - j)
                {
                    System.arraycopy(abyte0, (i + j) - (j1 - k), abyte1, abyte1.length - j1, j1 - k);
                } else
                {
                    System.arraycopy(abyte0, i, abyte1, abyte1.length - (k + j), j);
                }
            }

            for (i = abyte1.length - j1 * 2; i != abyte1.length; i += 2)
            {
                byte byte0 = abyte1[(abyte1.length - j1) + i / 2];
                abyte1[i] = (byte)(apM[(byte0 & 0xff) >>> 4] << 4 | apM[byte0 & 0xf]);
                abyte1[i + 1] = byte0;
            }

            i = abyte1.length - j * 2;
            abyte1[i] = (byte)(abyte1[i] ^ i1 + 1);
            abyte1[abyte1.length - 1] = (byte)(abyte1[abyte1.length - 1] << 4 | 6);
            j = 8 - (apP - 1) % 8;
            i = 0;
            if (j != 8)
            {
                abyte1[0] = (byte)(abyte1[0] & 255 >>> j);
                abyte1[0] = (byte)(abyte1[0] | 128 >>> j);
            } else
            {
                abyte1[0] = 0;
                abyte1[1] = (byte)(abyte1[1] | 0x80);
                i = 1;
            }
            return apO._mth1FBE(abyte1, i, abyte1.length - i);
        }
        abyte0 = apO._mth1FBE(abyte0, i, j);
        int l = 1;
        int k1 = (apP + 13) / 16;
        abyte0 = new BigInteger(1, abyte0);
        if (!abyte0.mod(apK).equals(apL))
        {
            if (adi.subtract(abyte0).mod(apK).equals(apL))
            {
                abyte0 = adi.subtract(abyte0);
            } else
            {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        abyte0 = abyte0.toByteArray();
        if (abyte0[0] == 0)
        {
            byte abyte2[] = new byte[abyte0.length - 1];
            System.arraycopy(abyte0, 1, abyte2, 0, abyte2.length);
            abyte0 = abyte2;
        }
        if ((abyte0[abyte0.length - 1] & 0xf) != 6)
        {
            throw new InvalidCipherTextException("invalid forcing byte in block");
        }
        abyte0[abyte0.length - 1] = (byte)((abyte0[abyte0.length - 1] & 0xff) >>> 4 | apN[(abyte0[abyte0.length - 2] & 0xff) >> 4] << 4);
        abyte0[0] = (byte)(apM[(abyte0[1] & 0xff) >>> 4] << 4 | apM[abyte0[1] & 0xf]);
        boolean flag = false;
        i = 0;
        for (j = abyte0.length - 1; j >= abyte0.length - k1 * 2;)
        {
            int l1 = apM[(abyte0[j] & 0xff) >>> 4] << 4 | apM[abyte0[j] & 0xf];
            boolean flag1 = flag;
            if (((abyte0[j - 1] ^ l1) & 0xff) != 0)
            {
                if (!flag)
                {
                    flag1 = true;
                    l = (abyte0[j - 1] ^ l1) & 0xff;
                    i = j - 1;
                } else
                {
                    throw new InvalidCipherTextException("invalid tsums in block");
                }
            }
            j -= 2;
            flag = flag1;
        }

        abyte0[i] = 0;
        byte abyte3[] = new byte[(abyte0.length - i) / 2];
        for (j = 0; j < abyte3.length; j++)
        {
            abyte3[j] = abyte0[j * 2 + i + 1];
        }

        WE = l - 1;
        return abyte3;
    }

}
