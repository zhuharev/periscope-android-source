// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;

// Referenced classes of package org.spongycastle.crypto.modes:
//            CBCBlockCipher

public class OldCTSBlockCipher extends BufferedBlockCipher
{

    public final int doFinal(byte abyte0[], int i)
    {
        if (amw + i > abyte0.length)
        {
            throw new DataLengthException("output buffer to small in doFinal");
        }
        int j = amz.getBlockSize();
        int j1 = amw - j;
        byte abyte1[] = new byte[j];
        if (amy)
        {
            amz._mth02CA(buf, 0, abyte1, 0);
            if (amw < j)
            {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            for (int k = amw; k != buf.length; k++)
            {
                buf[k] = abyte1[k - j];
            }

            for (int l = j; l != amw; l++)
            {
                byte abyte2[] = buf;
                abyte2[l] = (byte)(abyte2[l] ^ abyte1[l - j]);
            }

            if (amz instanceof CBCBlockCipher)
            {
                ((CBCBlockCipher)amz).amz._mth02CA(buf, j, abyte0, i);
            } else
            {
                amz._mth02CA(buf, j, abyte0, i);
            }
            System.arraycopy(abyte1, 0, abyte0, i + j, j1);
        } else
        {
            byte abyte3[] = new byte[j];
            if (amz instanceof CBCBlockCipher)
            {
                ((CBCBlockCipher)amz).amz._mth02CA(buf, 0, abyte1, 0);
            } else
            {
                amz._mth02CA(buf, 0, abyte1, 0);
            }
            for (int i1 = j; i1 != amw; i1++)
            {
                abyte3[i1 - j] = (byte)(abyte1[i1 - j] ^ buf[i1]);
            }

            System.arraycopy(buf, j, abyte1, 0, j1);
            amz._mth02CA(abyte1, 0, abyte0, i);
            System.arraycopy(abyte3, 0, abyte0, i + j, j1);
        }
        i = amw;
        reset();
        return i;
    }

    public final int getOutputSize(int i)
    {
        return amw + i;
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
            byte abyte2[] = buf;
            System.arraycopy(abyte2, i2, abyte2, 0, i2);
            amw = i2;
            j -= j2;
            i += j2;
            do
            {
                j1 = i1;
                k1 = i;
                l1 = j;
                if (j <= i2)
                {
                    break;
                }
                System.arraycopy(abyte0, i, buf, amw, i2);
                i1 += amz._mth02CA(buf, 0, abyte1, k + i1);
                byte abyte3[] = buf;
                System.arraycopy(abyte3, i2, abyte3, 0, i2);
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
