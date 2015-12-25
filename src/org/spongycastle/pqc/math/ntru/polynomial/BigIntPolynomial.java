// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            Constants, IntegerPolynomial, BigDecimalPolynomial

public class BigIntPolynomial
{

    private static final double aOU = Math.log10(2D);
    BigInteger aOV[];

    BigIntPolynomial(int i)
    {
        aOV = new BigInteger[i];
        for (int j = 0; j < i; j++)
        {
            aOV[j] = Constants.aOW;
        }

    }

    public BigIntPolynomial(IntegerPolynomial integerpolynomial)
    {
        aOV = new BigInteger[integerpolynomial.aPb.length];
        for (int i = 0; i < aOV.length; i++)
        {
            aOV[i] = BigInteger.valueOf(integerpolynomial.aPb[i]);
        }

    }

    BigIntPolynomial(BigInteger abiginteger[])
    {
        aOV = abiginteger;
    }

    private BigIntPolynomial _mth02CE(BigIntPolynomial bigintpolynomial)
    {
        BigInteger abiginteger[] = aOV;
        BigInteger abiginteger1[] = bigintpolynomial.aOV;
        int i = bigintpolynomial.aOV.length;
        if (i <= 1)
        {
            abiginteger = Arrays._mth02CB(aOV);
            for (i = 0; i < aOV.length; i++)
            {
                abiginteger[i] = abiginteger[i].multiply(bigintpolynomial.aOV[0]);
            }

            return new BigIntPolynomial(abiginteger);
        }
        int i1 = i / 2;
        bigintpolynomial = new BigIntPolynomial(Arrays._mth02CA(abiginteger, i1));
        BigIntPolynomial bigintpolynomial1 = new BigIntPolynomial(Arrays._mth02CA(abiginteger, i1, i));
        BigIntPolynomial bigintpolynomial4 = new BigIntPolynomial(Arrays._mth02CA(abiginteger1, i1));
        BigIntPolynomial bigintpolynomial5 = new BigIntPolynomial(Arrays._mth02CA(abiginteger1, i1, i));
        BigIntPolynomial bigintpolynomial2 = (BigIntPolynomial)bigintpolynomial.clone();
        bigintpolynomial2._mth02CF(bigintpolynomial1);
        BigIntPolynomial bigintpolynomial3 = (BigIntPolynomial)bigintpolynomial4.clone();
        bigintpolynomial3._mth02CF(bigintpolynomial5);
        bigintpolynomial = bigintpolynomial._mth02CE(bigintpolynomial4);
        bigintpolynomial1 = bigintpolynomial1._mth02CE(bigintpolynomial5);
        bigintpolynomial2 = bigintpolynomial2._mth02CE(bigintpolynomial3);
        bigintpolynomial2._mth141D(bigintpolynomial);
        bigintpolynomial2._mth141D(bigintpolynomial1);
        bigintpolynomial3 = new BigIntPolynomial(i * 2 - 1);
        for (int j = 0; j < bigintpolynomial.aOV.length; j++)
        {
            bigintpolynomial3.aOV[j] = bigintpolynomial.aOV[j];
        }

        for (int k = 0; k < bigintpolynomial2.aOV.length; k++)
        {
            bigintpolynomial3.aOV[i1 + k] = bigintpolynomial3.aOV[i1 + k].add(bigintpolynomial2.aOV[k]);
        }

        for (int l = 0; l < bigintpolynomial1.aOV.length; l++)
        {
            bigintpolynomial3.aOV[i1 * 2 + l] = bigintpolynomial3.aOV[i1 * 2 + l].add(bigintpolynomial1.aOV[l]);
        }

        return bigintpolynomial3;
    }

    private BigInteger _mth15A9()
    {
        BigInteger biginteger = aOV[0].abs();
        for (int i = 1; i < aOV.length;)
        {
            BigInteger biginteger2 = aOV[i].abs();
            BigInteger biginteger1 = biginteger;
            if (biginteger2.compareTo(biginteger) > 0)
            {
                biginteger1 = biginteger2;
            }
            i++;
            biginteger = biginteger1;
        }

        return biginteger;
    }

    public Object clone()
    {
        return new BigIntPolynomial((BigInteger[])aOV.clone());
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (BigIntPolynomial)obj;
        return Arrays._mth02CA(aOV, ((BigIntPolynomial) (obj)).aOV);
    }

    public int hashCode()
    {
        return Arrays._mth02CA(aOV) + 31;
    }

    public final BigDecimalPolynomial _mth02CA(BigDecimal bigdecimal, int i)
    {
        int j = (int)((double)_mth15A9().bitLength() * aOU);
        bigdecimal = Constants.aOY.divide(bigdecimal, j + 1 + i + 1, 6);
        BigDecimalPolynomial bigdecimalpolynomial = new BigDecimalPolynomial(aOV.length);
        for (int k = 0; k < aOV.length; k++)
        {
            bigdecimalpolynomial.aOT[k] = (new BigDecimal(aOV[k])).multiply(bigdecimal).setScale(i, 6);
        }

        return bigdecimalpolynomial;
    }

    public final BigIntPolynomial _mth02CB(BigIntPolynomial bigintpolynomial)
    {
        int j = aOV.length;
        if (bigintpolynomial.aOV.length != j)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        bigintpolynomial = _mth02CE(bigintpolynomial);
        if (bigintpolynomial.aOV.length > j)
        {
            for (int i = j; i < bigintpolynomial.aOV.length; i++)
            {
                bigintpolynomial.aOV[i - j] = bigintpolynomial.aOV[i - j].add(bigintpolynomial.aOV[i]);
            }

            bigintpolynomial.aOV = Arrays._mth02CA(bigintpolynomial.aOV, j);
        }
        return bigintpolynomial;
    }

    public final void _mth02CC(BigInteger biginteger)
    {
        for (int i = 0; i < aOV.length; i++)
        {
            BigInteger abiginteger[] = aOV;
            abiginteger[i] = abiginteger[i].multiply(biginteger);
        }

    }

    public final void _mth02CD(BigInteger biginteger)
    {
        BigInteger biginteger2 = biginteger.add(Constants.aOX).divide(BigInteger.valueOf(2L));
        for (int i = 0; i < aOV.length; i++)
        {
            BigInteger abiginteger1[] = aOV;
            BigInteger biginteger1;
            if (abiginteger1[i].compareTo(Constants.aOW) > 0)
            {
                biginteger1 = aOV[i].add(biginteger2);
            } else
            {
                biginteger1 = aOV[i].add(biginteger2.negate());
            }
            abiginteger1[i] = biginteger1;
            BigInteger abiginteger[] = aOV;
            abiginteger[i] = abiginteger[i].divide(biginteger);
        }

    }

    public final void _mth02CF(BigIntPolynomial bigintpolynomial)
    {
        if (bigintpolynomial.aOV.length > aOV.length)
        {
            int i = aOV.length;
            for (aOV = Arrays._mth02CA(aOV, bigintpolynomial.aOV.length); i < aOV.length; i++)
            {
                aOV[i] = Constants.aOW;
            }

        }
        for (int j = 0; j < bigintpolynomial.aOV.length; j++)
        {
            BigInteger abiginteger[] = aOV;
            abiginteger[j] = abiginteger[j].add(bigintpolynomial.aOV[j]);
        }

    }

    public final void _mth141D(BigIntPolynomial bigintpolynomial)
    {
        if (bigintpolynomial.aOV.length > aOV.length)
        {
            int i = aOV.length;
            for (aOV = Arrays._mth02CA(aOV, bigintpolynomial.aOV.length); i < aOV.length; i++)
            {
                aOV[i] = Constants.aOW;
            }

        }
        for (int j = 0; j < bigintpolynomial.aOV.length; j++)
        {
            BigInteger abiginteger[] = aOV;
            abiginteger[j] = abiginteger[j].subtract(bigintpolynomial.aOV[j]);
        }

    }

    public final int _mth1585()
    {
        return (int)((double)_mth15A9().bitLength() * aOU) + 1;
    }

}
