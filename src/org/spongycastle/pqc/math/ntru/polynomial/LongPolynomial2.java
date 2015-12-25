// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            IntegerPolynomial

public class LongPolynomial2
{

    private long aPd[];
    private int aPe;

    private LongPolynomial2(int i)
    {
        aPd = new long[i];
    }

    public LongPolynomial2(IntegerPolynomial integerpolynomial)
    {
        aPe = integerpolynomial.aPb.length;
        aPd = new long[(aPe + 1) / 2];
        int j = 0;
        for (int i = 0; i < aPe;)
        {
            int ai[] = integerpolynomial.aPb;
            int l = i + 1;
            int k;
            for (k = ai[i]; k < 0; k += 2048) { }
            long l1;
            if (l < aPe)
            {
                int ai1[] = integerpolynomial.aPb;
                i = l + 1;
                l1 = ai1[l];
            } else
            {
                l1 = 0L;
                i = l;
            }
            for (; l1 < 0L; l1 = 2048L + l1) { }
            aPd[j] = (long)k + (l1 << 24);
            j++;
        }

    }

    private LongPolynomial2(long al[])
    {
        aPd = al;
    }

    private LongPolynomial2 _mth02CB(LongPolynomial2 longpolynomial2)
    {
        long al1[] = aPd;
        long al[] = longpolynomial2.aPd;
        int k1 = longpolynomial2.aPd.length;
        if (k1 <= 32)
        {
            int l1 = k1 * 2;
            longpolynomial2 = new LongPolynomial2(new long[l1]);
            for (int i = 0; i < l1; i++)
            {
                for (int i1 = Math.max(0, (i - k1) + 1); i1 <= Math.min(i, k1 - 1); i1++)
                {
                    long l2 = al1[i - i1] * al[i1];
                    long al2[] = longpolynomial2.aPd;
                    al2[i] = al2[i] + (l2 & (2047L & l2) + 0x7ff000000L) & 0x7ff0007ffL;
                    longpolynomial2.aPd[i + 1] = longpolynomial2.aPd[i + 1] + (l2 >>> 48 & 2047L) & 0x7ff0007ffL;
                }

            }

            return longpolynomial2;
        }
        int j1 = k1 / 2;
        longpolynomial2 = new LongPolynomial2(Arrays.copyOf(al1, j1));
        LongPolynomial2 longpolynomial2_2 = new LongPolynomial2(Arrays.copyOfRange(al1, j1, k1));
        LongPolynomial2 longpolynomial2_4 = new LongPolynomial2(Arrays.copyOf(al, j1));
        LongPolynomial2 longpolynomial2_5 = new LongPolynomial2(Arrays.copyOfRange(al, j1, k1));
        LongPolynomial2 longpolynomial2_1 = (LongPolynomial2)longpolynomial2.clone();
        longpolynomial2_1._mth02CE(longpolynomial2_2);
        LongPolynomial2 longpolynomial2_3 = (LongPolynomial2)longpolynomial2_4.clone();
        longpolynomial2_3._mth02CE(longpolynomial2_5);
        longpolynomial2 = longpolynomial2._mth02CB(longpolynomial2_4);
        longpolynomial2_2 = longpolynomial2_2._mth02CB(longpolynomial2_5);
        longpolynomial2_1 = longpolynomial2_1._mth02CB(longpolynomial2_3);
        longpolynomial2_1._mth02CF(longpolynomial2);
        longpolynomial2_1._mth02CF(longpolynomial2_2);
        longpolynomial2_3 = new LongPolynomial2(k1 * 2);
        for (int j = 0; j < longpolynomial2.aPd.length; j++)
        {
            longpolynomial2_3.aPd[j] = longpolynomial2.aPd[j] & 0x7ff0007ffL;
        }

        for (int k = 0; k < longpolynomial2_1.aPd.length; k++)
        {
            longpolynomial2_3.aPd[j1 + k] = longpolynomial2_3.aPd[j1 + k] + longpolynomial2_1.aPd[k] & 0x7ff0007ffL;
        }

        for (int l = 0; l < longpolynomial2_2.aPd.length; l++)
        {
            longpolynomial2_3.aPd[j1 * 2 + l] = longpolynomial2_3.aPd[j1 * 2 + l] + longpolynomial2_2.aPd[l] & 0x7ff0007ffL;
        }

        return longpolynomial2_3;
    }

    private void _mth02CE(LongPolynomial2 longpolynomial2)
    {
        if (longpolynomial2.aPd.length > aPd.length)
        {
            aPd = Arrays.copyOf(aPd, longpolynomial2.aPd.length);
        }
        for (int i = 0; i < longpolynomial2.aPd.length; i++)
        {
            long al[] = aPd;
            al[i] = al[i] + longpolynomial2.aPd[i] & 0x7ff0007ffL;
        }

    }

    private void _mth02CF(LongPolynomial2 longpolynomial2)
    {
        if (longpolynomial2.aPd.length > aPd.length)
        {
            aPd = Arrays.copyOf(aPd, longpolynomial2.aPd.length);
        }
        for (int i = 0; i < longpolynomial2.aPd.length; i++)
        {
            aPd[i] = (aPd[i] + 0x800000800000L) - longpolynomial2.aPd[i] & 0x7ff0007ffL;
        }

    }

    public Object clone()
    {
        LongPolynomial2 longpolynomial2 = new LongPolynomial2((long[])aPd.clone());
        longpolynomial2.aPe = aPe;
        return longpolynomial2;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LongPolynomial2)
        {
            return Arrays._mth02CF(aPd, ((LongPolynomial2)obj).aPd);
        } else
        {
            return false;
        }
    }

    public final LongPolynomial2 _mth02CA(LongPolynomial2 longpolynomial2)
    {
        int i = aPd.length;
        if (longpolynomial2.aPd.length != i || aPe != longpolynomial2.aPe)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        longpolynomial2 = _mth02CB(longpolynomial2);
        if (longpolynomial2.aPd.length > i)
        {
            if (aPe % 2 == 0)
            {
                for (int j = i; j < longpolynomial2.aPd.length; j++)
                {
                    longpolynomial2.aPd[j - i] = longpolynomial2.aPd[j - i] + longpolynomial2.aPd[j] & 0x7ff0007ffL;
                }

                longpolynomial2.aPd = Arrays.copyOf(longpolynomial2.aPd, i);
            } else
            {
                for (int k = i; k < longpolynomial2.aPd.length; k++)
                {
                    longpolynomial2.aPd[k - i] = longpolynomial2.aPd[k - i] + (longpolynomial2.aPd[k - 1] >> 24);
                    longpolynomial2.aPd[k - i] = longpolynomial2.aPd[k - i] + ((longpolynomial2.aPd[k] & 2047L) << 24);
                    long al[] = longpolynomial2.aPd;
                    int l = k - i;
                    al[l] = al[l] & 0x7ff0007ffL;
                }

                longpolynomial2.aPd = Arrays.copyOf(longpolynomial2.aPd, i);
                long al1[] = longpolynomial2.aPd;
                i = longpolynomial2.aPd.length - 1;
                al1[i] = al1[i] & 2047L;
            }
        }
        longpolynomial2 = new LongPolynomial2(longpolynomial2.aPd);
        longpolynomial2.aPe = aPe;
        return longpolynomial2;
    }

    public final void _mth02CA(LongPolynomial2 longpolynomial2, int i)
    {
        long l = i;
        long l1 = i;
        for (i = 0; i < longpolynomial2.aPd.length; i++)
        {
            aPd[i] = (aPd[i] + 0x800000800000L) - longpolynomial2.aPd[i] & (l << 24) + l1;
        }

    }

    public final void _mth1D2C(int i)
    {
        long l = i;
        long l1 = i;
        for (i = 0; i < aPd.length; i++)
        {
            long al[] = aPd;
            al[i] = al[i] << 1 & (l << 24) + l1;
        }

    }

    public final IntegerPolynomial _mth1D46()
    {
        int ai[] = new int[aPe];
        int i = 0;
        for (int j = 0; j < aPd.length; j++)
        {
            int k = i + 1;
            ai[i] = (int)(aPd[j] & 2047L);
            i = k;
            if (k < aPe)
            {
                i = k + 1;
                ai[k] = (int)(aPd[j] >> 24 & 2047L);
            }
        }

        return new IntegerPolynomial(ai);
    }
}
