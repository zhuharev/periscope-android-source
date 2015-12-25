// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.encoders.Hex;

public class GMSSRootSig
{

    private int Wr;
    private Digest aKA;
    private int aKB;
    private int aKC;
    private GMSSRandom aKD;
    private int aKI;
    private byte aKJ[];
    private int aLA;
    private int aLB;
    private long aLC;
    private int aLD;
    private byte aLx[];
    private byte aLy[];
    private int aLz;
    private int afK;
    private byte aln[];
    private int axu;
    private int height;
    private int w;

    public GMSSRootSig(Digest digest, int i, int j)
    {
        aKA = digest;
        aKD = new GMSSRandom(aKA);
        aKB = aKA._mth14AF();
        w = i;
        height = j;
        afK = (1 << i) - 1;
        aLz = (int)Math.ceil((double)(aKB << 3) / (double)i);
    }

    public String toString()
    {
        String s = (new StringBuilder()).append(0L).append("  ").toString();
        int l = aKI;
        int i1 = aKC;
        int j1 = height;
        int k1 = w;
        int l1 = aLD;
        int i = aKB;
        i = aKB;
        byte abyte0[][] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            5, i
        });
        abyte0[0] = aKJ;
        abyte0[1] = aln;
        abyte0[2] = aLx;
        abyte0[3] = aLy;
        abyte0[4] = (new byte[] {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0
        });
        for (int j = 0; j < 9; j++)
        {
            s = (new StringBuilder()).append(s).append((new int[] {
                0, 0, 0, 0, l, i1, j1, k1, l1
            })[j]).append(" ").toString();
        }

        for (int k = 0; k < 5; k++)
        {
            s = (new StringBuilder()).append(s).append(new String(Hex._mth1D65(abyte0[k]))).append(" ").toString();
        }

        return s;
    }

    public final void _mth02CC(byte abyte0[], byte abyte1[])
    {
        aLx = new byte[aKB];
        aKA.update(abyte1, 0, abyte1.length);
        aLx = new byte[aKA._mth14AF()];
        aKA.doFinal(aLx, 0);
        abyte1 = new byte[aKB];
        System.arraycopy(aLx, 0, abyte1, 0, aKB);
        int j2 = 0;
        int i3 = 0;
        int k = 0;
        int j1 = 0;
        int j3 = aLz;
        int l3 = w;
        int i1 = 1;
        for (int i = 2; i < (j3 << l3) + 1;)
        {
            i <<= 1;
            i1++;
        }

        int j;
        if (8 % w == 0)
        {
            j2 = 8 / w;
            k = 0;
            j = j1;
            for (; k < aKB; k++)
            {
                for (j1 = 0; j1 < j2; j1++)
                {
                    j += abyte1[k] & afK;
                    abyte1[k] = (byte)(abyte1[k] >>> w);
                }

            }

            aLD = (aLz << w) - j;
            j1 = aLD;
            for (k = 0; k < i1; k += w)
            {
                j += afK & j1;
                j1 >>>= w;
            }

        } else
        if (w < 8)
        {
            k = 0;
            i3 = aKB / w;
            int k1 = 0;
            j = j2;
            for (; k1 < i3; k1++)
            {
                long l4 = 0L;
                for (j2 = 0; j2 < w; j2++)
                {
                    l4 ^= (abyte1[k] & 0xff) << (j2 << 3);
                    k++;
                }

                for (j2 = 0; j2 < 8; j2++)
                {
                    j += (int)((long)afK & l4);
                    l4 >>>= w;
                }

            }

            j2 = aKB % w;
            long l5 = 0L;
            for (k1 = 0; k1 < j2; k1++)
            {
                l5 ^= (abyte1[k] & 0xff) << (k1 << 3);
                k++;
            }

            for (k = 0; k < j2 << 3; k += w)
            {
                j += (int)((long)afK & l5);
                l5 >>>= w;
            }

            aLD = (aLz << w) - j;
            k1 = aLD;
            for (k = 0; k < i1; k += w)
            {
                j += afK & k1;
                k1 >>>= w;
            }

        } else
        {
            j = k;
            if (w < 57)
            {
                int l = 0;
                j = i3;
                do
                {
                    i3 = l;
                    if (i3 > (aKB << 3) - w)
                    {
                        break;
                    }
                    int l1 = i3 >>> 3;
                    int k3 = w + i3;
                    l = k3;
                    long l6 = 0L;
                    int k2 = 0;
                    for (; l1 < k3 + 7 >>> 3; l1++)
                    {
                        l6 ^= (abyte1[l1] & 0xff) << (k2 << 3);
                        k2++;
                    }

                    j = (int)((long)j + ((long)afK & l6 >>> i3 % 8));
                } while (true);
                int l2 = i3 >>> 3;
                int i2 = l2;
                l = j;
                if (l2 < aKB)
                {
                    long l7 = 0L;
                    l = 0;
                    for (; i2 < aKB; i2++)
                    {
                        l7 ^= (abyte1[i2] & 0xff) << (l << 3);
                        l++;
                    }

                    l = (int)((long)j + ((long)afK & l7 >>> i3 % 8));
                }
                aLD = (aLz << w) - l;
                l2 = aLD;
                i2 = 0;
                do
                {
                    j = l;
                    if (i2 >= i1)
                    {
                        break;
                    }
                    l += afK & l2;
                    l2 >>>= w;
                    i2 += w;
                } while (true);
            }
        }
        aKC = aLz + (int)Math.ceil((double)i1 / (double)w);
        aKI = (int)Math.ceil((double)(aKC + j) / (double)(1 << height));
        aLy = new byte[aKC * aKB];
        Wr = 0;
        aLA = 0;
        aLB = 0;
        aLC = 0L;
        axu = 0;
        aKJ = new byte[aKB];
        aln = new byte[aKB];
        System.arraycopy(abyte0, 0, aln, 0, aKB);
    }
}
