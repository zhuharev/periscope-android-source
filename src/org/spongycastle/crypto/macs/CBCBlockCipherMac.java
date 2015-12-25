// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;

public class CBCBlockCipherMac
    implements Mac
{

    private int amw;
    private byte auC[];
    private CBCBlockCipher auD;
    private BlockCipherPadding auE;
    private int auF;
    private byte buf[];

    public CBCBlockCipherMac(BlockCipher blockcipher)
    {
        this(blockcipher, (blockcipher.getBlockSize() << 3) / 2, null);
    }

    public CBCBlockCipherMac(BlockCipher blockcipher, int i)
    {
        this(blockcipher, i, null);
    }

    public CBCBlockCipherMac(BlockCipher blockcipher, int i, ISO7816d4Padding iso7816d4padding)
    {
        if (i % 8 != 0)
        {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else
        {
            auD = new CBCBlockCipher(blockcipher);
            auE = iso7816d4padding;
            auF = i / 8;
            auC = new byte[blockcipher.getBlockSize()];
            buf = new byte[blockcipher.getBlockSize()];
            amw = 0;
            return;
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        i = auD.getBlockSize();
        if (auE == null)
        {
            for (; amw < i; amw = amw + 1)
            {
                buf[amw] = 0;
            }

        } else
        {
            if (amw == i)
            {
                auD._mth02CA(buf, 0, auC, 0);
                amw = 0;
            }
            auE._mth1427(buf, amw);
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
        reset();
        auD._mth02CA(true, cipherparameters);
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
