// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.paddings;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;

// Referenced classes of package org.spongycastle.crypto.paddings:
//            PKCS7Padding, BlockCipherPadding

public class PaddedBufferedBlockCipher extends BufferedBlockCipher
{

    private BlockCipherPadding auE;

    public PaddedBufferedBlockCipher(BlockCipher blockcipher)
    {
        this(blockcipher, ((BlockCipherPadding) (new PKCS7Padding())));
    }

    public PaddedBufferedBlockCipher(BlockCipher blockcipher, BlockCipherPadding blockcipherpadding)
    {
        amz = blockcipher;
        auE = blockcipherpadding;
        buf = new byte[blockcipher.getBlockSize()];
        amw = 0;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        int j;
        int k = amz.getBlockSize();
        j = 0;
        if (amy)
        {
            if (amw == k)
            {
                if (k * 2 + i > abyte0.length)
                {
                    reset();
                    throw new OutputLengthException("output buffer too short");
                }
                j = amz._mth02CA(buf, 0, abyte0, i);
                amw = 0;
            }
            auE._mth1427(buf, amw);
            i = amz._mth02CA(buf, 0, abyte0, i + j);
            reset();
            return j + i;
        }
        if (amw == k)
        {
            j = amz._mth02CA(buf, 0, buf, 0);
            amw = 0;
        } else
        {
            reset();
            throw new DataLengthException("last block incomplete in decryption");
        }
        j -= auE._mth1540(buf);
        System.arraycopy(buf, 0, abyte0, i, j);
        reset();
        return j;
        abyte0;
        reset();
        throw abyte0;
    }

    public final int getOutputSize(int i)
    {
        i = amw + i;
        int j = i % buf.length;
        if (j == 0)
        {
            if (amy)
            {
                return buf.length + i;
            } else
            {
                return i;
            }
        } else
        {
            return (i - j) + buf.length;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        reset();
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            auE.init(((ParametersWithRandom) (cipherparameters)).amC);
            amz._mth02CA(flag, ((ParametersWithRandom) (cipherparameters)).axC);
            return;
        } else
        {
            auE.init(null);
            amz._mth02CA(flag, cipherparameters);
            return;
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i2 = getBlockSize();
        int l = _mth1550(j);
        if (l > 0 && k + l > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        int j1 = 0;
        int j2 = buf.length - amw;
        int k1 = i;
        int l1 = j;
        if (j > j2)
        {
            System.arraycopy(abyte0, i, buf, amw, j2);
            int i1 = amz._mth02CA(buf, 0, abyte1, k) + 0;
            amw = 0;
            j -= j2;
            i += j2;
            do
            {
                j1 = i1;
                k1 = i;
                l1 = j;
                if (j <= buf.length)
                {
                    break;
                }
                i1 += amz._mth02CA(abyte0, i, abyte1, k + i1);
                j -= i2;
                i += i2;
            } while (true);
        }
        System.arraycopy(abyte0, k1, buf, amw, l1);
        amw = amw + l1;
        return j1;
    }

    public final int _mth1550(int i)
    {
        i = amw + i;
        int j = i % buf.length;
        if (j == 0)
        {
            return Math.max(0, i - buf.length);
        } else
        {
            return i - j;
        }
    }
}
