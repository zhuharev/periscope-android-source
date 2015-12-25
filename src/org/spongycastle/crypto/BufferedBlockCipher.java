// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            BlockCipher, StreamCipher, OutputLengthException, DataLengthException, 
//            CipherParameters

public class BufferedBlockCipher
{

    private boolean amA;
    private boolean amB;
    public int amw;
    public boolean amy;
    public BlockCipher amz;
    public byte buf[];

    public BufferedBlockCipher()
    {
    }

    public BufferedBlockCipher(BlockCipher blockcipher)
    {
        amz = blockcipher;
        buf = new byte[blockcipher.getBlockSize()];
        amw = 0;
        String s = blockcipher._mth14AC();
        int i = s.indexOf('/') + 1;
        boolean flag;
        if (i > 0 && s.startsWith("PGP", i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        amB = flag;
        if (amB || (blockcipher instanceof StreamCipher))
        {
            flag = true;
        } else
        if (i > 0 && s.startsWith("OpenPGP", i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        amA = flag;
    }

    public int doFinal(byte abyte0[], int i)
    {
        int j = 0;
        if (amw + i > abyte0.length)
        {
            throw new OutputLengthException("output buffer too short for doFinal()");
        }
        if (amw != 0)
        {
            if (!amA)
            {
                throw new DataLengthException("data not block size aligned");
            }
            amz._mth02CA(buf, 0, buf, 0);
            j = amw;
            amw = 0;
            System.arraycopy(buf, 0, abyte0, i, j);
        }
        reset();
        return j;
        abyte0;
        reset();
        throw abyte0;
    }

    public final int getBlockSize()
    {
        return amz.getBlockSize();
    }

    public int getOutputSize(int i)
    {
        return amw + i;
    }

    public final void reset()
    {
        for (int i = 0; i < buf.length; i++)
        {
            buf[i] = 0;
        }

        amw = 0;
        amz.reset();
    }

    public void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        reset();
        amz._mth02CA(flag, cipherparameters);
    }

    public int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int l1 = amz.getBlockSize();
        int l = _mth1550(j);
        if (l > 0 && k + l > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        l = 0;
        int i2 = buf.length - amw;
        int j1 = i;
        int k1 = j;
        if (j > i2)
        {
            System.arraycopy(abyte0, i, buf, amw, i2);
            int i1 = amz._mth02CA(buf, 0, abyte1, k) + 0;
            amw = 0;
            j -= i2;
            i += i2;
            do
            {
                l = i1;
                j1 = i;
                k1 = j;
                if (j <= buf.length)
                {
                    break;
                }
                i1 += amz._mth02CA(abyte0, i, abyte1, k + i1);
                j -= l1;
                i += l1;
            } while (true);
        }
        System.arraycopy(abyte0, j1, buf, amw, k1);
        amw = amw + k1;
        i = l;
        if (amw == buf.length)
        {
            i = l + amz._mth02CA(buf, 0, abyte1, k + l);
            amw = 0;
        }
        return i;
    }

    public final BlockCipher _mth14AD()
    {
        return amz;
    }

    public int _mth1550(int i)
    {
        int j = i + amw;
        if (amB)
        {
            i = j % buf.length - (amz.getBlockSize() + 2);
        } else
        {
            i = j % buf.length;
        }
        return j - i;
    }
}
