// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

public class PaddedBlockCipher extends BufferedBlockCipher
{

    public final int doFinal(byte abyte0[], int i)
    {
        int l = amz.getBlockSize();
        int j = 0;
        if (amy)
        {
            if (amw == l)
            {
                if (l * 2 + i > abyte0.length)
                {
                    throw new DataLengthException("output buffer too short");
                }
                j = amz._mth02CA(buf, 0, abyte0, i);
                amw = 0;
            }
            byte byte0 = (byte)(l - amw);
            for (; amw < l; amw = amw + 1)
            {
                buf[amw] = byte0;
            }

            i = j + amz._mth02CA(buf, 0, abyte0, i + j);
        } else
        {
            int k;
            if (amw == l)
            {
                k = amz._mth02CA(buf, 0, buf, 0);
                amw = 0;
            } else
            {
                throw new DataLengthException("last block incomplete in decryption");
            }
            int i1 = buf[l - 1] & 0xff;
            if (i1 < 0 || i1 > l)
            {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            k -= i1;
            System.arraycopy(buf, 0, abyte0, i, k);
            i = k;
        }
        reset();
        return i;
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

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i2 = getBlockSize();
        int l = amw + j;
        int j1 = l % buf.length;
        if (j1 == 0)
        {
            l -= buf.length;
        } else
        {
            l -= j1;
        }
        if (l > 0 && k + l > abyte1.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        j1 = 0;
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
            return i - buf.length;
        } else
        {
            return i - j;
        }
    }
}
