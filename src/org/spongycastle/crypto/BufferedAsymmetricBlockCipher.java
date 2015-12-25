// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            AsymmetricBlockCipher, DataLengthException, CipherParameters

public class BufferedAsymmetricBlockCipher
{

    private int amw;
    public final AsymmetricBlockCipher amx;
    private byte buf[];

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricblockcipher)
    {
        amx = asymmetricblockcipher;
    }

    private void reset()
    {
        if (buf != null)
        {
            for (int i = 0; i < buf.length; i++)
            {
                buf[i] = 0;
            }

        }
        amw = 0;
    }

    public final byte[] doFinal()
    {
        byte abyte0[] = amx._mth1FBE(buf, 0, amw);
        reset();
        return abyte0;
    }

    public final void _mth02BE(byte abyte0[], int i, int j)
    {
        if (j == 0)
        {
            return;
        }
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        if (amw + j > buf.length)
        {
            throw new DataLengthException("attempt to process message too long for cipher");
        } else
        {
            System.arraycopy(abyte0, i, buf, amw, j);
            amw = amw + j;
            return;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        reset();
        amx._mth02CA(flag, cipherparameters);
        int j = amx._mth148C();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        buf = new byte[j + i];
        amw = 0;
    }
}
