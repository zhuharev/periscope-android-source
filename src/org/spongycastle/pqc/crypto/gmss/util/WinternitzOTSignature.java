// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss.util:
//            GMSSRandom

public class WinternitzOTSignature
{

    private Digest aKA;
    private int aKB;
    private int aKC;
    private GMSSRandom aKD;
    private byte aLO[][];
    private int aLP;
    private int aLz;
    private int w;

    public WinternitzOTSignature(byte abyte0[], Digest digest, int i)
    {
        w = i;
        aKA = digest;
        aKD = new GMSSRandom(aKA);
        aKB = aKA._mth14AF();
        aLz = (int)Math.ceil((double)(aKB << 3) / (double)i);
        aLP = _mth1D4F((aLz << i) + 1);
        aKC = aLz + (int)Math.ceil((double)aLP / (double)i);
        i = aKC;
        int j = aKB;
        aLO = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            i, j
        });
        digest = new byte[aKB];
        System.arraycopy(abyte0, 0, digest, 0, digest.length);
        for (i = 0; i < aKC; i++)
        {
            aLO[i] = aKD._mth02D0(digest);
        }

    }

    private static int _mth1D4F(int i)
    {
        int j = 1;
        for (int k = 2; k < i;)
        {
            k <<= 1;
            j++;
        }

        return j;
    }

    public final byte[] _mth05D5(byte abyte0[])
    {
        byte abyte2[] = new byte[aKC * aKB];
        int i = 0;
        int j2 = 0;
        int k1 = 0;
        int l = 0;
        int k2 = 0;
        boolean flag = false;
        aKA.update(abyte0, 0, abyte0.length);
        byte abyte3[] = new byte[aKA._mth14AF()];
        aKA.doFinal(abyte3, 0);
        if (8 % w == 0)
        {
            int l4 = 8 / w;
            int l3 = (1 << w) - 1;
            abyte0 = new byte[aKB];
            l = 0;
            j2 = ((flag) ? 1 : 0);
            i = k1;
            for (; l < abyte3.length; l++)
            {
                for (k1 = 0; k1 < l4;)
                {
                    int l2 = abyte3[l] & l3;
                    k2 = j2 + l2;
                    System.arraycopy(aLO[i], 0, abyte0, 0, aKB);
                    for (j2 = l2; j2 > 0; j2--)
                    {
                        aKA.update(abyte0, 0, abyte0.length);
                        abyte0 = new byte[aKA._mth14AF()];
                        aKA.doFinal(abyte0, 0);
                    }

                    System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
                    abyte3[l] = (byte)(abyte3[l] >>> w);
                    i++;
                    k1++;
                    j2 = k2;
                }

            }

            k1 = (aLz << w) - j2;
            for (l = 0; l < aLP; l += w)
            {
                j2 = k1 & l3;
                System.arraycopy(aLO[i], 0, abyte0, 0, aKB);
                for (; j2 > 0; j2--)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
                k1 >>>= w;
                i++;
            }

            return abyte2;
        }
        if (w < 8)
        {
            int k5 = aKB / w;
            int i5 = (1 << w) - 1;
            abyte0 = new byte[aKB];
            int l1 = 0;
            for (j2 = 0; j2 < k5; j2++)
            {
                long l6 = 0L;
                for (k2 = 0; k2 < w; k2++)
                {
                    l6 ^= (abyte3[l1] & 0xff) << (k2 << 3);
                    l1++;
                }

                for (k2 = 0; k2 < 8;)
                {
                    int i4 = (int)((long)i5 & l6);
                    int i3 = l + i4;
                    System.arraycopy(aLO[i], 0, abyte0, 0, aKB);
                    for (l = i4; l > 0; l--)
                    {
                        aKA.update(abyte0, 0, abyte0.length);
                        abyte0 = new byte[aKA._mth14AF()];
                        aKA.doFinal(abyte0, 0);
                    }

                    System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
                    l6 >>>= w;
                    i++;
                    k2++;
                    l = i3;
                }

            }

            int j3 = aKB % w;
            long l7 = 0L;
            for (j2 = 0; j2 < j3; j2++)
            {
                l7 ^= (abyte3[l1] & 0xff) << (j2 << 3);
                l1++;
            }

            for (l1 = 0; l1 < j3 << 3;)
            {
                k2 = (int)((long)i5 & l7);
                j2 = l + k2;
                System.arraycopy(aLO[i], 0, abyte0, 0, aKB);
                for (l = k2; l > 0; l--)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
                l7 >>>= w;
                i++;
                l1 += w;
                l = j2;
            }

            l1 = (aLz << w) - l;
            for (int i1 = 0; i1 < aLP; i1 += w)
            {
                j2 = l1 & i5;
                System.arraycopy(aLO[i], 0, abyte0, 0, aKB);
                for (; j2 > 0; j2--)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
                l1 >>>= w;
                i++;
            }

            return abyte2;
        }
        if (w < 57)
        {
            int l5 = aKB;
            int i6 = w;
            int j5 = (1 << w) - 1;
            abyte0 = new byte[aKB];
            int i2 = 0;
            int j1 = k2;
            int j = j2;
            int k3;
            do
            {
                k3 = i2;
                if (k3 > (l5 << 3) - i6)
                {
                    break;
                }
                j2 = k3 >>> 3;
                int j4 = w + k3;
                i2 = j4;
                long l8 = 0L;
                k2 = 0;
                for (; j2 < j4 + 7 >>> 3; j2++)
                {
                    l8 ^= (abyte3[j2] & 0xff) << (k2 << 3);
                    k2++;
                }

                l8 = l8 >>> k3 % 8 & (long)j5;
                j1 = (int)((long)j1 + l8);
                System.arraycopy(aLO[j], 0, abyte0, 0, aKB);
                for (; l8 > 0L; l8--)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte2, aKB * j, aKB);
                j++;
            } while (true);
            int k4 = k3 >>> 3;
            j2 = k4;
            i2 = j;
            k2 = j1;
            byte abyte1[] = abyte0;
            if (k4 < aKB)
            {
                long l9 = 0L;
                i2 = 0;
                for (; j2 < aKB; j2++)
                {
                    l9 ^= (abyte3[j2] & 0xff) << (i2 << 3);
                    i2++;
                }

                l9 = l9 >>> k3 % 8 & (long)j5;
                k2 = (int)((long)j1 + l9);
                System.arraycopy(aLO[j], 0, abyte0, 0, aKB);
                for (; l9 > 0L; l9--)
                {
                    aKA.update(abyte0, 0, abyte0.length);
                    abyte0 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte0, 0);
                }

                System.arraycopy(abyte0, 0, abyte2, aKB * j, aKB);
                i2 = j + 1;
                abyte1 = abyte0;
            }
            j1 = (aLz << w) - k2;
            for (int k = 0; k < aLP; k += w)
            {
                long l10 = j1 & j5;
                System.arraycopy(aLO[i2], 0, abyte1, 0, aKB);
                for (; l10 > 0L; l10--)
                {
                    aKA.update(abyte1, 0, abyte1.length);
                    abyte1 = new byte[aKA._mth14AF()];
                    aKA.doFinal(abyte1, 0);
                }

                System.arraycopy(abyte1, 0, abyte2, aKB * i2, aKB);
                j1 >>>= w;
                i2++;
            }

        }
        return abyte2;
    }

    public final byte[] _mth06C5()
    {
        byte abyte2[] = new byte[aKC * aKB];
        int k = w;
        for (int i = 0; i < aKC; i++)
        {
            aKA.update(aLO[i], 0, aLO[i].length);
            byte abyte0[] = new byte[aKA._mth14AF()];
            aKA.doFinal(abyte0, 0);
            for (int j = 2; j < 1 << k; j++)
            {
                aKA.update(abyte0, 0, abyte0.length);
                abyte0 = new byte[aKA._mth14AF()];
                aKA.doFinal(abyte0, 0);
            }

            System.arraycopy(abyte0, 0, abyte2, aKB * i, aKB);
        }

        aKA.update(abyte2, 0, abyte2.length);
        byte abyte1[] = new byte[aKA._mth14AF()];
        aKA.doFinal(abyte1, 0);
        return abyte1;
    }
}
