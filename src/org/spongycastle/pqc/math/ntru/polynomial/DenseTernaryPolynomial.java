// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            IntegerPolynomial, TernaryPolynomial, LongPolynomial5

public class DenseTernaryPolynomial extends IntegerPolynomial
    implements TernaryPolynomial
{

    public DenseTernaryPolynomial(IntegerPolynomial integerpolynomial)
    {
        this(integerpolynomial.aPb);
    }

    public DenseTernaryPolynomial(int ai[])
    {
        super(ai);
        for (int i = 0; i != aPb.length; i++)
        {
            int j = aPb[i];
            if (j < -1 || j > 1)
            {
                throw new IllegalStateException((new StringBuilder("Illegal value: ")).append(j).append(", must be one of {-1, 0, 1}").toString());
            }
        }

    }

    public static DenseTernaryPolynomial _mth02CA(int i, int j, int k, SecureRandom securerandom)
    {
        return new DenseTernaryPolynomial(Util._mth02CE(i, j, k, securerandom));
    }

    public final int size()
    {
        return aPb.length;
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial, int i)
    {
        if (i == 2048)
        {
            integerpolynomial = (IntegerPolynomial)integerpolynomial.clone();
            for (i = 0; i < integerpolynomial.aPb.length; i++)
            {
                int ai[] = integerpolynomial.aPb;
                ai[i] = ai[i] % 2048;
            }

            integerpolynomial._mth1484(2048);
            integerpolynomial = new LongPolynomial5(integerpolynomial);
            i = ((LongPolynomial5) (integerpolynomial)).aPd.length;
            int j = (size() + 4) / 5;
            Object obj = (long[][])Array.newInstance(Long.TYPE, new int[] {
                5, (i + j) - 1
            });
            long al[] = _mth15AB();
            for (i = 0; i != al.length; i++)
            {
                int k = al[i];
                int j2 = k / 5;
                int j3 = k - j2 * 5;
                for (int l = 0; l < ((LongPolynomial5) (integerpolynomial)).aPd.length; l++)
                {
                    obj[j3][j2] = obj[j3][j2] + ((LongPolynomial5) (integerpolynomial)).aPd[l] & 0x7ff7ff7ff7ff7ffL;
                    j2++;
                }

            }

            al = _mth15AD();
            for (i = 0; i != al.length; i++)
            {
                int i1 = al[i];
                int k2 = i1 / 5;
                int k3 = i1 - k2 * 5;
                for (int j1 = 0; j1 < ((LongPolynomial5) (integerpolynomial)).aPd.length; j1++)
                {
                    obj[k3][k2] = (obj[k3][k2] + 0x800800800800800L) - ((LongPolynomial5) (integerpolynomial)).aPd[j1] & 0x7ff7ff7ff7ff7ffL;
                    k2++;
                }

            }

            al = Arrays.copyOf(obj[0], obj[0].length + 1);
            for (i = 1; i <= 4; i++)
            {
                int l2 = i * 12;
                int l3 = 60 - l2;
                int k4 = obj[i].length;
                for (int k1 = 0; k1 < k4; k1++)
                {
                    long l5 = obj[i][k1];
                    long l7 = obj[i][k1];
                    al[k1] = al[k1] + ((l7 & (1L << l3) - 1L) << l2) & 0x7ff7ff7ff7ff7ffL;
                    int i5 = k1 + 1;
                    al[i5] = al[i5] + (l5 >> l3) & 0x7ff7ff7ff7ff7ffL;
                }

            }

            int i3 = ((LongPolynomial5) (integerpolynomial)).aPe;
            for (i = ((LongPolynomial5) (integerpolynomial)).aPd.length - 1; i < al.length; i++)
            {
                int l1;
                long l6;
                if (i == ((LongPolynomial5) (integerpolynomial)).aPd.length - 1)
                {
                    if (((LongPolynomial5) (integerpolynomial)).aPe == 5)
                    {
                        l6 = 0L;
                    } else
                    {
                        l6 = al[i] >> (i3 % 5) * 12;
                    }
                    l1 = 0;
                } else
                {
                    l6 = al[i];
                    l1 = i * 5 - ((LongPolynomial5) (integerpolynomial)).aPe;
                }
                int i4 = l1 / 5;
                l1 -= i4 * 5;
                al[i4] = al[i4] + (l6 << l1 * 12) & 0x7ff7ff7ff7ff7ffL;
                i4++;
                if (i4 < ((LongPolynomial5) (integerpolynomial)).aPd.length)
                {
                    al[i4] = al[i4] + (l6 >> (5 - l1) * 12) & 0x7ff7ff7ff7ff7ffL;
                }
            }

            integerpolynomial = new LongPolynomial5(al, ((LongPolynomial5) (integerpolynomial)).aPe);
            obj = new int[((LongPolynomial5) (integerpolynomial)).aPe];
            i3 = 0;
            i = 0;
            for (int i2 = 0; i2 < ((LongPolynomial5) (integerpolynomial)).aPe;)
            {
                obj[i2] = (int)(((LongPolynomial5) (integerpolynomial)).aPd[i3] >> i & 2047L);
                int l4 = i + 12;
                int j4 = i3;
                i = l4;
                if (l4 >= 60)
                {
                    i = 0;
                    j4 = i3 + 1;
                }
                i2++;
                i3 = j4;
            }

            return new IntegerPolynomial(((int []) (obj)));
        } else
        {
            return super._mth02CA(integerpolynomial, i);
        }
    }

    public final int[] _mth15AB()
    {
        int l = aPb.length;
        int ai[] = new int[l];
        int i = 0;
        for (int j = 0; j < l;)
        {
            int k = i;
            if (aPb[j] == 1)
            {
                k = i + 1;
                ai[i] = j;
            }
            j++;
            i = k;
        }

        return Arrays.copyOf(ai, i);
    }

    public final int[] _mth15AD()
    {
        int l = aPb.length;
        int ai[] = new int[l];
        int i = 0;
        for (int j = 0; j < l;)
        {
            int k = i;
            if (aPb[j] == -1)
            {
                k = i + 1;
                ai[i] = j;
            }
            j++;
            i = k;
        }

        return Arrays.copyOf(ai, i);
    }
}
