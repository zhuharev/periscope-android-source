// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RFC3394WrapEngine
    implements Wrapper
{

    private KeyParameter arm;
    private boolean aro;
    private BlockCipher asw;
    private byte iv[] = {
        -90, -90, -90, -90, -90, -90, -90, -90
    };

    public RFC3394WrapEngine(BlockCipher blockcipher)
    {
        asw = blockcipher;
    }

    public final byte[] _mth02C8(byte abyte0[], int i, int j)
    {
        if (!aro)
        {
            throw new IllegalStateException("not set for wrapping");
        }
        int i1 = j / 8;
        if (i1 << 3 != j)
        {
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        byte abyte1[] = new byte[iv.length + j];
        byte abyte2[] = new byte[iv.length + 8];
        System.arraycopy(iv, 0, abyte1, 0, iv.length);
        System.arraycopy(abyte0, i, abyte1, iv.length, j);
        asw._mth02CA(true, arm);
        for (i = 0; i != 6; i++)
        {
            for (j = 1; j <= i1; j++)
            {
                System.arraycopy(abyte1, 0, abyte2, 0, iv.length);
                System.arraycopy(abyte1, j * 8, abyte2, iv.length, 8);
                asw._mth02CA(abyte2, 0, abyte2, 0);
                int l = i1 * i + j;
                for (int k = 1; l != 0; k++)
                {
                    byte byte0 = (byte)l;
                    int j1 = iv.length - k;
                    abyte2[j1] = (byte)(abyte2[j1] ^ byte0);
                    l >>>= 8;
                }

                System.arraycopy(abyte2, 0, abyte1, 0, 8);
                System.arraycopy(abyte2, 8, abyte1, j * 8, 8);
            }

        }

        return abyte1;
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
        byte abyte1[] = new byte[j - iv.length];
        byte abyte2[] = new byte[iv.length];
        byte abyte3[] = new byte[iv.length + 8];
        System.arraycopy(abyte0, 0, abyte2, 0, iv.length);
        System.arraycopy(abyte0, iv.length + 0, abyte1, 0, j - iv.length);
        asw._mth02CA(false, arm);
        int i1 = i - 1;
        for (i = 5; i >= 0; i--)
        {
            for (j = i1; j > 0; j--)
            {
                System.arraycopy(abyte2, 0, abyte3, 0, iv.length);
                System.arraycopy(abyte1, (j - 1) * 8, abyte3, iv.length, 8);
                int l = i1 * i + j;
                for (int k = 1; l != 0; k++)
                {
                    byte byte0 = (byte)l;
                    int j1 = iv.length - k;
                    abyte3[j1] = (byte)(abyte3[j1] ^ byte0);
                    l >>>= 8;
                }

                asw._mth02CA(abyte3, 0, abyte3, 0);
                System.arraycopy(abyte3, 0, abyte2, 0, 8);
                System.arraycopy(abyte3, 8, abyte1, (j - 1) * 8, 8);
            }

        }

        if (!Arrays._mth1428(abyte2, iv))
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
            iv = ((ParametersWithIV)cipherparameters1).iv;
            arm = (KeyParameter)((ParametersWithIV)cipherparameters1).axC;
            if (iv.length != 8)
            {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    public final String _mth14AC()
    {
        return asw._mth14AC();
    }
}
