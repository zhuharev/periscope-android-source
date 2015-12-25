// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss.util;

import org.spongycastle.crypto.Digest;

public class WinternitzOTSVerify
{

    public Digest aKA;
    public int w;

    public WinternitzOTSVerify(Digest digest, int i)
    {
        w = i;
        aKA = digest;
    }

    public static int _mth1D4F(int i)
    {
        int j = 1;
        for (int k = 2; k < i;)
        {
            k <<= 1;
            j++;
        }

        return j;
    }

    public final byte[] _mth02D1(byte abyte0[], byte abyte1[])
    {
        int j6 = aKA._mth14AF();
        aKA.update(abyte0, 0, abyte0.length);
        byte abyte4[] = new byte[aKA._mth14AF()];
        aKA.doFinal(abyte4, 0);
        int k6 = ((j6 << 3) + (w - 1)) / w;
        int j1 = w;
        int k2 = 1;
        for (int i = 2; i < (k6 << j1) + 1;)
        {
            i <<= 1;
            k2++;
        }

        int j = j6 * (k6 + ((w + k2) - 1) / w);
        if (j != abyte1.length)
        {
            return null;
        }
        byte abyte3[] = new byte[j];
        j = 0;
        int l4 = 0;
        int l2 = 0;
        j1 = 0;
        int i5 = 0;
        int l1 = 0;
        if (8 % w == 0)
        {
            int l6 = 8 / w;
            int j5 = (1 << w) - 1;
            abyte0 = new byte[j6];
            j1 = 0;
            j = l1;
            for (; j1 < abyte4.length; j1++)
            {
                for (l1 = 0; l1 < l6;)
                {
                    i5 = abyte4[j1] & j5;
                    l4 = l2 + i5;
                    System.arraycopy(abyte1, j * j6, abyte0, 0, j6);
                    for (l2 = i5; l2 < j5; l2++)
                    {
                        aKA.update(abyte0, 0, abyte0.length);
                        abyte0 = new byte[aKA._mth14AF()];
                        aKA.doFinal(abyte0, 0);
                    }

                    System.arraycopy(abyte0, 0, abyte3, j * j6, j6);
                    abyte4[j1] = (byte)(abyte4[j1] >>> w);
                    j++;
                    l1++;
                    l2 = l4;
                }

            }

            l1 = (k6 << w) - l2;
            for (j1 = 0; j1 < k2; j1 += w)
            {
                int i3 = l1 & j5;
                System.arraycopy(abyte1, j * j6, abyte0, 0, j6);
                for (; i3 < j5; i3++)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte3, j * j6, j6);
                l1 >>>= w;
                j++;
            }

        } else
        if (w < 8)
        {
            int k7 = j6 / w;
            int i7 = (1 << w) - 1;
            abyte0 = new byte[j6];
            int i2 = 0;
            for (int j3 = 0; j3 < k7; j3++)
            {
                long l8 = 0L;
                for (l4 = 0; l4 < w; l4++)
                {
                    l8 ^= (abyte4[i2] & 0xff) << (l4 << 3);
                    i2++;
                }

                for (l4 = 0; l4 < 8;)
                {
                    int k5 = (int)((long)i7 & l8);
                    i5 = j + k5;
                    System.arraycopy(abyte1, j1 * j6, abyte0, 0, j6);
                    for (j = k5; j < i7; j++)
                    {
                        aKA.update(abyte0, 0, abyte0.length);
                        abyte0 = new byte[aKA._mth14AF()];
                        aKA.doFinal(abyte0, 0);
                    }

                    System.arraycopy(abyte0, 0, abyte3, j1 * j6, j6);
                    l8 >>>= w;
                    j1++;
                    l4++;
                    j = i5;
                }

            }

            i5 = j6 % w;
            long l9 = 0L;
            for (int k3 = 0; k3 < i5; k3++)
            {
                l9 ^= (abyte4[i2] & 0xff) << (k3 << 3);
                i2++;
            }

            for (i2 = 0; i2 < i5 << 3;)
            {
                l4 = (int)((long)i7 & l9);
                int l3 = j + l4;
                System.arraycopy(abyte1, j1 * j6, abyte0, 0, j6);
                for (j = l4; j < i7; j++)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte3, j1 * j6, j6);
                l9 >>>= w;
                j1++;
                i2 += w;
                j = l3;
            }

            i2 = (k6 << w) - j;
            for (int k = 0; k < k2; k += w)
            {
                int i4 = i2 & i7;
                System.arraycopy(abyte1, j1 * j6, abyte0, 0, j6);
                for (; i4 < i7; i4++)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte3, j1 * j6, j6);
                i2 >>>= w;
                j1++;
            }

        } else
        if (w < 57)
        {
            int l7 = w;
            int j7 = (1 << w) - 1;
            abyte0 = new byte[j6];
            int j2 = 0;
            int l = i5;
            int k1 = l4;
            do
            {
                i5 = j2;
                if (i5 > (j6 << 3) - l7)
                {
                    break;
                }
                int j4 = i5 >>> 3;
                int l5 = w + i5;
                j2 = l5;
                long l10 = 0L;
                l4 = 0;
                for (; j4 < l5 + 7 >>> 3; j4++)
                {
                    l10 ^= (abyte4[j4] & 0xff) << (l4 << 3);
                    l4++;
                }

                l10 = l10 >>> i5 % 8 & (long)j7;
                k1 = (int)((long)k1 + l10);
                System.arraycopy(abyte1, l * j6, abyte0, 0, j6);
                for (; l10 < (long)j7; l10++)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte3, l * j6, j6);
                l++;
            } while (true);
            int i6 = i5 >>> 3;
            int k4 = i6;
            l4 = k1;
            j2 = l;
            byte abyte2[] = abyte0;
            if (i6 < j6)
            {
                long l11 = 0L;
                j2 = 0;
                for (; k4 < j6; k4++)
                {
                    l11 ^= (abyte4[k4] & 0xff) << (j2 << 3);
                    j2++;
                }

                l11 = l11 >>> i5 % 8 & (long)j7;
                l4 = (int)((long)k1 + l11);
                System.arraycopy(abyte1, l * j6, abyte0, 0, j6);
                for (; l11 < (long)j7; l11++)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte3, l * j6, j6);
                j2 = l + 1;
                abyte2 = abyte0;
            }
            k1 = (k6 << w) - l4;
            for (int i1 = 0; i1 < k2; i1 += w)
            {
                long l12 = k1 & j7;
                System.arraycopy(abyte1, j2 * j6, abyte2, 0, j6);
                for (; l12 < (long)j7; l12++)
                {
                    aKA.update(abyte2, 0, abyte2.length);
                    abyte2 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte2, 0);
                }

                System.arraycopy(abyte2, 0, abyte3, j2 * j6, j6);
                k1 >>>= w;
                j2++;
            }

        }
        aKA.update(abyte3, 0, abyte3.length);
        abyte0 = new byte[aKA._mth14AF()];
        aKA.doFinal(abyte0, 0);
        return abyte0;
    }
}
