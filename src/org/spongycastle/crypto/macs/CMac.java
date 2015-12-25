// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.KeyParameter;

public class CMac
    implements Mac
{

    private int amw;
    private byte and[];
    private byte auC[];
    private CBCBlockCipher auD;
    private int auF;
    private byte auH[];
    private byte auI[];
    private byte auJ[];
    private byte buf[];

    public CMac(BlockCipher blockcipher)
    {
        this(blockcipher, blockcipher.getBlockSize() << 3);
    }

    private CMac(BlockCipher blockcipher, int i)
    {
        if (i % 8 != 0)
        {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i > blockcipher.getBlockSize() << 3)
        {
            throw new IllegalArgumentException((new StringBuilder("MAC size must be less or equal to ")).append(blockcipher.getBlockSize() << 3).toString());
        }
        if (blockcipher.getBlockSize() != 8 && blockcipher.getBlockSize() != 16)
        {
            throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
        } else
        {
            auD = new CBCBlockCipher(blockcipher);
            auF = i / 8;
            auC = new byte[blockcipher.getBlockSize()];
            buf = new byte[blockcipher.getBlockSize()];
            auH = new byte[blockcipher.getBlockSize()];
            amw = 0;
            return;
        }
    }

    private static byte[] _mth02E1(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length];
        int j = abyte0.length;
        int i = 0;
        do
        {
            j--;
            if (j < 0)
            {
                break;
            }
            int k = abyte0[j] & 0xff;
            abyte1[j] = (byte)(k << 1 | i);
            i = k >>> 7 & 1;
        } while (true);
        if (abyte0.length == 16)
        {
            j = -121;
        } else
        {
            j = 27;
        }
        int l = abyte0.length - 1;
        abyte1[l] = (byte)(abyte1[l] ^ (j & 0xff) >>> (1 - i << 3));
        return abyte1;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        i = auD.getBlockSize();
        byte abyte1[];
        if (amw == i)
        {
            abyte1 = auI;
        } else
        {
            new ISO7816d4Padding();
            abyte1 = buf;
            i = amw;
            int j = abyte1.length;
            abyte1[i] = -128;
            for (i++; i < abyte1.length; i++)
            {
                abyte1[i] = 0;
            }

            abyte1 = auJ;
        }
        for (i = 0; i < auC.length; i++)
        {
            byte abyte2[] = buf;
            abyte2[i] = (byte)(abyte2[i] ^ abyte1[i]);
        }

        auD._mth02CA(buf, 0, auC, 0);
        System.arraycopy(auC, 0, abyte0, 0, auF);
        reset();
        return auF;
    }

    public final void reset()
    {
        for (int i = 0; i < buf.length; i++)
        {
            buf[i] = 0;
        }

        amw = 0;
        auD.reset();
    }

    public final void update(byte byte0)
    {
        if (amw == buf.length)
        {
            auD._mth02CA(buf, 0, auC, 0);
            amw = 0;
        }
        byte abyte0[] = buf;
        int i = amw;
        amw = i + 1;
        abyte0[i] = byte0;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i1 = auD.getBlockSize();
        int j1 = i1 - amw;
        int k = i;
        int l = j;
        if (j > j1)
        {
            System.arraycopy(abyte0, i, buf, amw, j1);
            auD._mth02CA(buf, 0, auC, 0);
            amw = 0;
            j -= j1;
            i += j1;
            do
            {
                k = i;
                l = j;
                if (j <= i1)
                {
                    break;
                }
                auD._mth02CA(abyte0, i, auC, 0);
                j -= i1;
                i += i1;
            } while (true);
        }
        System.arraycopy(abyte0, k, buf, amw, l);
        amw = amw + l;
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        _mth02CF(cipherparameters);
        auD._mth02CA(true, cipherparameters);
        and = new byte[auH.length];
        auD._mth02CA(auH, 0, and, 0);
        auI = _mth02E1(and);
        auJ = _mth02E1(auI);
        reset();
    }

    void _mth02CF(CipherParameters cipherparameters)
    {
        if (cipherparameters != null && !(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        } else
        {
            return;
        }
    }

    public final String _mth14AC()
    {
        return auD._mth14AC();
    }

    public final int _mth14B3()
    {
        return auF;
    }
}
