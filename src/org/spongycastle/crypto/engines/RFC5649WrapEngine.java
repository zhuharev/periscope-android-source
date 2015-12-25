// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.engines:
//            RFC3394WrapEngine

public class RFC5649WrapEngine
    implements Wrapper
{

    private KeyParameter arm;
    private boolean aro;
    private BlockCipher asw;
    private byte asx[] = {
        -90, 89, 89, -90
    };
    private byte asy[];
    private byte asz[];

    public RFC5649WrapEngine(BlockCipher blockcipher)
    {
        asy = asx;
        asz = null;
        asw = blockcipher;
    }

    private byte[] _mth0640(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j - 8];
        byte abyte2[] = new byte[8];
        byte abyte3[] = new byte[16];
        System.arraycopy(abyte0, i, abyte2, 0, 8);
        System.arraycopy(abyte0, i + 8, abyte1, 0, j - 8);
        asw._mth02CA(false, arm);
        int i1 = j / 8 - 1;
        for (i = 5; i >= 0; i--)
        {
            for (j = i1; j > 0; j--)
            {
                System.arraycopy(abyte2, 0, abyte3, 0, 8);
                System.arraycopy(abyte1, (j - 1) * 8, abyte3, 8, 8);
                int l = i1 * i + j;
                for (int k = 1; l != 0; k++)
                {
                    byte byte0 = (byte)l;
                    int j1 = 8 - k;
                    abyte3[j1] = (byte)(abyte3[j1] ^ byte0);
                    l >>>= 8;
                }

                asw._mth02CA(abyte3, 0, abyte3, 0);
                System.arraycopy(abyte3, 0, abyte2, 0, 8);
                System.arraycopy(abyte3, 8, abyte1, (j - 1) * 8, 8);
            }

        }

        asz = abyte2;
        return abyte1;
    }

    public final byte[] _mth02C8(byte abyte0[], int i, int j)
    {
        if (!aro)
        {
            throw new IllegalStateException("not set for wrapping");
        }
        byte abyte1[] = new byte[8];
        byte abyte2[] = Pack._mth1D31(j);
        System.arraycopy(asy, 0, abyte1, 0, asy.length);
        System.arraycopy(abyte2, 0, abyte1, asy.length, 4);
        abyte2 = new byte[j];
        System.arraycopy(abyte0, i, abyte2, 0, j);
        j = abyte2.length;
        int k = (8 - j % 8) % 8;
        abyte0 = new byte[j + k];
        System.arraycopy(abyte2, 0, abyte0, 0, j);
        if (k != 0)
        {
            System.arraycopy(new byte[k], 0, abyte0, j, k);
        }
        if (abyte0.length == 8)
        {
            byte abyte3[] = new byte[abyte0.length + 8];
            System.arraycopy(abyte1, 0, abyte3, 0, 8);
            System.arraycopy(abyte0, 0, abyte3, 8, abyte0.length);
            asw._mth02CA(true, arm);
            for (i = 0; i < abyte3.length; i += asw.getBlockSize())
            {
                asw._mth02CA(abyte3, i, abyte3, i);
            }

            return abyte3;
        } else
        {
            RFC3394WrapEngine rfc3394wrapengine = new RFC3394WrapEngine(asw);
            rfc3394wrapengine._mth02CA(true, new ParametersWithIV(arm, abyte1));
            return rfc3394wrapengine._mth02C8(abyte0, i, abyte0.length);
        }
    }

    public final byte[] _mth02C9(byte abyte0[], int i, int j)
    {
        if (aro)
        {
            throw new IllegalStateException("not set for unwrapping");
        }
        i = j / 8;
        if (i << 3 != j)
        {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        if (i == 1)
        {
            throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
        }
        byte abyte2[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte2, 0, j);
        byte abyte1[] = new byte[j];
        if (i == 2)
        {
            asw._mth02CA(false, arm);
            for (i = 0; i < abyte2.length; i += asw.getBlockSize())
            {
                asw._mth02CA(abyte2, i, abyte1, i);
            }

            asz = new byte[8];
            System.arraycopy(abyte1, 0, asz, 0, asz.length);
            abyte0 = new byte[abyte1.length - asz.length];
            System.arraycopy(abyte1, asz.length, abyte0, 0, abyte0.length);
        } else
        {
            abyte0 = _mth0640(abyte0, 0, j);
        }
        abyte1 = new byte[4];
        abyte2 = new byte[4];
        System.arraycopy(asz, 0, abyte1, 0, 4);
        System.arraycopy(asz, 4, abyte2, 0, 4);
        j = Pack._mth02B3(abyte2, 0);
        i = 1;
        if (!Arrays._mth1428(abyte1, asy))
        {
            i = 0;
        }
        int k = abyte0.length;
        if (j <= k - 8)
        {
            i = 0;
        }
        if (j > k)
        {
            i = 0;
        }
        k -= j;
        abyte1 = new byte[k];
        abyte2 = new byte[k];
        System.arraycopy(abyte0, abyte0.length - k, abyte2, 0, k);
        if (!Arrays._mth1428(abyte2, abyte1))
        {
            i = 0;
        }
        abyte1 = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
        if (i == 0)
        {
            throw new InvalidCipherTextException("checksum failed");
        } else
        {
            return abyte1;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aro = flag;
        CipherParameters cipherparameters1 = cipherparameters;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters1 = ((ParametersWithRandom)cipherparameters).axC;
        }
        if (cipherparameters1 instanceof KeyParameter)
        {
            arm = (KeyParameter)cipherparameters1;
            return;
        }
        if (cipherparameters1 instanceof ParametersWithIV)
        {
            asy = ((ParametersWithIV)cipherparameters1).iv;
            arm = (KeyParameter)((ParametersWithIV)cipherparameters1).axC;
            if (asy.length != 4)
            {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    public final String _mth14AC()
    {
        return asw._mth14AC();
    }
}
