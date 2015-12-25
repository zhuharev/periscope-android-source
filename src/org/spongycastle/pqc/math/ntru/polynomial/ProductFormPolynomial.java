// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            Polynomial, SparseTernaryPolynomial, IntegerPolynomial, BigIntPolynomial

public class ProductFormPolynomial
    implements Polynomial
{

    private SparseTernaryPolynomial aPf;
    private SparseTernaryPolynomial aPg;
    private SparseTernaryPolynomial aPh;

    public ProductFormPolynomial(SparseTernaryPolynomial sparseternarypolynomial, SparseTernaryPolynomial sparseternarypolynomial1, SparseTernaryPolynomial sparseternarypolynomial2)
    {
        aPf = sparseternarypolynomial;
        aPg = sparseternarypolynomial1;
        aPh = sparseternarypolynomial2;
    }

    public static ProductFormPolynomial _mth02CA(int i, int j, int k, int l, int i1, SecureRandom securerandom)
    {
        return new ProductFormPolynomial(SparseTernaryPolynomial._mth02CB(i, j, j, securerandom), SparseTernaryPolynomial._mth02CB(i, k, k, securerandom), SparseTernaryPolynomial._mth02CB(i, l, i1, securerandom));
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
        obj = (ProductFormPolynomial)obj;
        if (aPf == null)
        {
            if (((ProductFormPolynomial) (obj)).aPf != null)
            {
                return false;
            }
        } else
        if (!aPf.equals(((ProductFormPolynomial) (obj)).aPf))
        {
            return false;
        }
        if (aPg == null)
        {
            if (((ProductFormPolynomial) (obj)).aPg != null)
            {
                return false;
            }
        } else
        if (!aPg.equals(((ProductFormPolynomial) (obj)).aPg))
        {
            return false;
        }
        if (aPh == null)
        {
            if (((ProductFormPolynomial) (obj)).aPh != null)
            {
                return false;
            }
        } else
        if (!aPh.equals(((ProductFormPolynomial) (obj)).aPh))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        int i;
        if (aPf == null)
        {
            i = 0;
        } else
        {
            i = aPf.hashCode();
        }
        int j;
        if (aPg == null)
        {
            j = 0;
        } else
        {
            j = aPg.hashCode();
        }
        int k;
        if (aPh == null)
        {
            k = 0;
        } else
        {
            k = aPh.hashCode();
        }
        return ((i + 31) * 31 + j) * 31 + k;
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial)
    {
        IntegerPolynomial integerpolynomial1 = aPf._mth02CA(integerpolynomial);
        integerpolynomial1 = aPg._mth02CA(integerpolynomial1);
        integerpolynomial1._mth02CE(aPh._mth02CA(integerpolynomial));
        return integerpolynomial1;
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial, int i)
    {
        IntegerPolynomial integerpolynomial1 = aPf._mth02CA(integerpolynomial);
        integerpolynomial1 = aPg._mth02CA(integerpolynomial1);
        integerpolynomial1._mth02CE(aPh._mth02CA(integerpolynomial));
        for (int j = 0; j < integerpolynomial1.aPb.length; j++)
        {
            integerpolynomial = integerpolynomial1.aPb;
            integerpolynomial[j] = integerpolynomial[j] % i;
        }

        return integerpolynomial1;
    }

    public final BigIntPolynomial _mth02CB(BigIntPolynomial bigintpolynomial)
    {
        BigIntPolynomial bigintpolynomial1 = aPf._mth02CB(bigintpolynomial);
        bigintpolynomial1 = aPg._mth02CB(bigintpolynomial1);
        bigintpolynomial1._mth02CF(aPh._mth02CB(bigintpolynomial));
        return bigintpolynomial1;
    }

    public final IntegerPolynomial _mth1D46()
    {
        IntegerPolynomial integerpolynomial = aPf._mth02CA(aPg._mth1D46());
        integerpolynomial._mth02CE(aPh._mth1D46());
        return integerpolynomial;
    }
}
