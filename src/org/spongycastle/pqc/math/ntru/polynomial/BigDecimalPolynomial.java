// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            BigIntPolynomial

public class BigDecimalPolynomial
{

    private static final BigDecimal ZERO = new BigDecimal("0");
    private static final BigDecimal aOS = new BigDecimal("0.5");
    BigDecimal aOT[];

    BigDecimalPolynomial(int i)
    {
        aOT = new BigDecimal[i];
        for (int j = 0; j < i; j++)
        {
            aOT[j] = ZERO;
        }

    }

    private BigDecimalPolynomial(BigIntPolynomial bigintpolynomial)
    {
        int j = bigintpolynomial.aOV.length;
        aOT = new BigDecimal[j];
        for (int i = 0; i < j; i++)
        {
            aOT[i] = new BigDecimal(bigintpolynomial.aOV[i]);
        }

    }

    private BigDecimalPolynomial(BigDecimal abigdecimal[])
    {
        aOT = abigdecimal;
    }

    private BigDecimalPolynomial _mth02CA(BigDecimalPolynomial bigdecimalpolynomial)
    {
        int i = aOT.length;
        if (bigdecimalpolynomial.aOT.length != i)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        bigdecimalpolynomial = _mth02CB(bigdecimalpolynomial);
        if (bigdecimalpolynomial.aOT.length > i)
        {
            for (int j = i; j < bigdecimalpolynomial.aOT.length; j++)
            {
                bigdecimalpolynomial.aOT[j - i] = bigdecimalpolynomial.aOT[j - i].add(bigdecimalpolynomial.aOT[j]);
            }

            BigDecimal abigdecimal[] = bigdecimalpolynomial.aOT;
            BigDecimal abigdecimal1[] = new BigDecimal[i];
            if (abigdecimal.length < i)
            {
                i = abigdecimal.length;
            }
            System.arraycopy(abigdecimal, 0, abigdecimal1, 0, i);
            bigdecimalpolynomial.aOT = abigdecimal1;
        }
        return bigdecimalpolynomial;
    }

    private static BigDecimal[] _mth02CA(BigDecimal abigdecimal[], int i, int j)
    {
        int k = j - i;
        BigDecimal abigdecimal1[] = new BigDecimal[j - i];
        if (abigdecimal.length - i < k)
        {
            j = abigdecimal.length - i;
        } else
        {
            j = k;
        }
        System.arraycopy(abigdecimal, i, abigdecimal1, 0, j);
        return abigdecimal1;
    }

    private BigDecimalPolynomial _mth02CB(BigDecimalPolynomial bigdecimalpolynomial)
    {
        BigDecimal abigdecimal[] = aOT;
        BigDecimal abigdecimal1[] = bigdecimalpolynomial.aOT;
        int k1 = bigdecimalpolynomial.aOT.length;
        if (k1 <= 1)
        {
            abigdecimal = (BigDecimal[])aOT.clone();
            for (int i = 0; i < aOT.length; i++)
            {
                abigdecimal[i] = abigdecimal[i].multiply(bigdecimalpolynomial.aOT[0]);
            }

            return new BigDecimalPolynomial(abigdecimal);
        }
        int j = k1 / 2;
        bigdecimalpolynomial = new BigDecimal[j];
        int k;
        if (abigdecimal.length < j)
        {
            k = abigdecimal.length;
        } else
        {
            k = j;
        }
        System.arraycopy(abigdecimal, 0, bigdecimalpolynomial, 0, k);
        bigdecimalpolynomial = new BigDecimalPolynomial(bigdecimalpolynomial);
        BigDecimalPolynomial bigdecimalpolynomial1 = new BigDecimalPolynomial(_mth02CA(abigdecimal, j, k1));
        BigDecimal abigdecimal2[] = new BigDecimal[j];
        if (abigdecimal1.length < j)
        {
            k = abigdecimal1.length;
        } else
        {
            k = j;
        }
        System.arraycopy(abigdecimal1, 0, abigdecimal2, 0, k);
        BigDecimalPolynomial bigdecimalpolynomial4 = new BigDecimalPolynomial(abigdecimal2);
        BigDecimalPolynomial bigdecimalpolynomial5 = new BigDecimalPolynomial(_mth02CA(abigdecimal1, j, k1));
        BigDecimalPolynomial bigdecimalpolynomial2 = (BigDecimalPolynomial)bigdecimalpolynomial.clone();
        bigdecimalpolynomial2._mth02CE(bigdecimalpolynomial1);
        BigDecimalPolynomial bigdecimalpolynomial3 = (BigDecimalPolynomial)bigdecimalpolynomial4.clone();
        bigdecimalpolynomial3._mth02CE(bigdecimalpolynomial5);
        bigdecimalpolynomial = bigdecimalpolynomial._mth02CB(bigdecimalpolynomial4);
        bigdecimalpolynomial1 = bigdecimalpolynomial1._mth02CB(bigdecimalpolynomial5);
        bigdecimalpolynomial2 = bigdecimalpolynomial2._mth02CB(bigdecimalpolynomial3);
        bigdecimalpolynomial2._mth02CF(bigdecimalpolynomial);
        bigdecimalpolynomial2._mth02CF(bigdecimalpolynomial1);
        bigdecimalpolynomial3 = new BigDecimalPolynomial(k1 * 2 - 1);
        for (int l = 0; l < bigdecimalpolynomial.aOT.length; l++)
        {
            bigdecimalpolynomial3.aOT[l] = bigdecimalpolynomial.aOT[l];
        }

        for (int i1 = 0; i1 < bigdecimalpolynomial2.aOT.length; i1++)
        {
            bigdecimalpolynomial3.aOT[j + i1] = bigdecimalpolynomial3.aOT[j + i1].add(bigdecimalpolynomial2.aOT[i1]);
        }

        for (int j1 = 0; j1 < bigdecimalpolynomial1.aOT.length; j1++)
        {
            bigdecimalpolynomial3.aOT[j * 2 + j1] = bigdecimalpolynomial3.aOT[j * 2 + j1].add(bigdecimalpolynomial1.aOT[j1]);
        }

        return bigdecimalpolynomial3;
    }

    private void _mth02CF(BigDecimalPolynomial bigdecimalpolynomial)
    {
        if (bigdecimalpolynomial.aOT.length > aOT.length)
        {
            int l = aOT.length;
            BigDecimal abigdecimal[] = aOT;
            int i = bigdecimalpolynomial.aOT.length;
            BigDecimal abigdecimal2[] = new BigDecimal[i];
            if (abigdecimal.length < i)
            {
                i = abigdecimal.length;
            }
            System.arraycopy(abigdecimal, 0, abigdecimal2, 0, i);
            aOT = abigdecimal2;
            for (int j = l; j < aOT.length; j++)
            {
                aOT[j] = ZERO;
            }

        }
        for (int k = 0; k < bigdecimalpolynomial.aOT.length; k++)
        {
            BigDecimal abigdecimal1[] = aOT;
            abigdecimal1[k] = abigdecimal1[k].subtract(bigdecimalpolynomial.aOT[k]);
        }

    }

    public Object clone()
    {
        return new BigDecimalPolynomial((BigDecimal[])aOT.clone());
    }

    public final BigDecimalPolynomial _mth02CA(BigIntPolynomial bigintpolynomial)
    {
        return _mth02CA(new BigDecimalPolynomial(bigintpolynomial));
    }

    public final void _mth02CE(BigDecimalPolynomial bigdecimalpolynomial)
    {
        if (bigdecimalpolynomial.aOT.length > aOT.length)
        {
            int l = aOT.length;
            BigDecimal abigdecimal[] = aOT;
            int i = bigdecimalpolynomial.aOT.length;
            BigDecimal abigdecimal2[] = new BigDecimal[i];
            if (abigdecimal.length < i)
            {
                i = abigdecimal.length;
            }
            System.arraycopy(abigdecimal, 0, abigdecimal2, 0, i);
            aOT = abigdecimal2;
            for (int j = l; j < aOT.length; j++)
            {
                aOT[j] = ZERO;
            }

        }
        for (int k = 0; k < bigdecimalpolynomial.aOT.length; k++)
        {
            BigDecimal abigdecimal1[] = aOT;
            abigdecimal1[k] = abigdecimal1[k].add(bigdecimalpolynomial.aOT[k]);
        }

    }

    public final void _mth1544()
    {
        for (int i = 0; i < aOT.length; i++)
        {
            BigDecimal abigdecimal[] = aOT;
            abigdecimal[i] = abigdecimal[i].multiply(aOS);
        }

    }

    public final BigIntPolynomial _mth1546()
    {
        int j = aOT.length;
        BigIntPolynomial bigintpolynomial = new BigIntPolynomial(j);
        for (int i = 0; i < j; i++)
        {
            bigintpolynomial.aOV[i] = aOT[i].setScale(0, 6).toBigInteger();
        }

        return bigintpolynomial;
    }

}
