// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            TernaryPolynomial, IntegerPolynomial, BigIntPolynomial

public class SparseTernaryPolynomial
    implements TernaryPolynomial
{

    private int aPk[];
    private int aPl[];
    private int atY;

    public SparseTernaryPolynomial(int ai[])
    {
        atY = ai.length;
        aPk = new int[atY];
        aPl = new int[atY];
        int k = 0;
        int j = 0;
        for (int i = 0; i < atY; i++)
        {
            int l = ai[i];
            switch (l)
            {
            case 1: // '\001'
                int ai1[] = aPk;
                l = k + 1;
                ai1[k] = i;
                k = l;
                break;

            case -1: 
                int ai2[] = aPl;
                l = j + 1;
                ai2[j] = i;
                j = l;
                break;

            default:
                throw new IllegalArgumentException((new StringBuilder("Illegal value: ")).append(l).append(", must be one of {-1, 0, 1}").toString());

            case 0: // '\0'
                break;
            }
        }

        aPk = Arrays.copyOf(aPk, k);
        aPl = Arrays.copyOf(aPl, j);
    }

    public static SparseTernaryPolynomial _mth02CB(int i, int j, int k, SecureRandom securerandom)
    {
        return new SparseTernaryPolynomial(Util._mth02CE(i, j, k, securerandom));
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
        obj = (SparseTernaryPolynomial)obj;
        if (atY != ((SparseTernaryPolynomial) (obj)).atY)
        {
            return false;
        }
        if (!Arrays._mth1427(aPl, ((SparseTernaryPolynomial) (obj)).aPl))
        {
            return false;
        }
        return Arrays._mth1427(aPk, ((SparseTernaryPolynomial) (obj)).aPk);
    }

    public int hashCode()
    {
        return ((atY + 31) * 31 + Arrays.hashCode(aPl)) * 31 + Arrays.hashCode(aPk);
    }

    public final int size()
    {
        return atY;
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial)
    {
        integerpolynomial = integerpolynomial.aPb;
        if (integerpolynomial.length != atY)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        int ai[] = new int[atY];
        for (int k = 0; k != aPk.length; k++)
        {
            int i = aPk[k];
            i = atY - 1 - i;
            for (int i1 = atY - 1; i1 >= 0; i1--)
            {
                ai[i1] = ai[i1] + integerpolynomial[i];
                int k1 = i - 1;
                i = k1;
                if (k1 < 0)
                {
                    i = atY - 1;
                }
            }

        }

        for (int l = 0; l != aPl.length; l++)
        {
            int j = aPl[l];
            j = atY - 1 - j;
            for (int j1 = atY - 1; j1 >= 0; j1--)
            {
                ai[j1] = ai[j1] - integerpolynomial[j];
                int l1 = j - 1;
                j = l1;
                if (l1 < 0)
                {
                    j = atY - 1;
                }
            }

        }

        return new IntegerPolynomial(ai);
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial, int i)
    {
        integerpolynomial = _mth02CA(integerpolynomial);
        for (int j = 0; j < integerpolynomial.aPb.length; j++)
        {
            int ai[] = integerpolynomial.aPb;
            ai[j] = ai[j] % i;
        }

        return integerpolynomial;
    }

    public final BigIntPolynomial _mth02CB(BigIntPolynomial bigintpolynomial)
    {
        bigintpolynomial = bigintpolynomial.aOV;
        if (bigintpolynomial.length != atY)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        BigInteger abiginteger[] = new BigInteger[atY];
        for (int i = 0; i < atY; i++)
        {
            abiginteger[i] = BigInteger.ZERO;
        }

        for (int l = 0; l != aPk.length; l++)
        {
            int j = aPk[l];
            j = atY - 1 - j;
            for (int j1 = atY - 1; j1 >= 0; j1--)
            {
                abiginteger[j1] = abiginteger[j1].add(bigintpolynomial[j]);
                int l1 = j - 1;
                j = l1;
                if (l1 < 0)
                {
                    j = atY - 1;
                }
            }

        }

        for (int i1 = 0; i1 != aPl.length; i1++)
        {
            int k = aPl[i1];
            k = atY - 1 - k;
            for (int k1 = atY - 1; k1 >= 0; k1--)
            {
                abiginteger[k1] = abiginteger[k1].subtract(bigintpolynomial[k]);
                int i2 = k - 1;
                k = i2;
                if (i2 < 0)
                {
                    k = atY - 1;
                }
            }

        }

        return new BigIntPolynomial(abiginteger);
    }

    public final int[] _mth15AB()
    {
        return aPk;
    }

    public final int[] _mth15AD()
    {
        return aPl;
    }

    public final IntegerPolynomial _mth1D46()
    {
        int ai[] = new int[atY];
        for (int i = 0; i != aPk.length; i++)
        {
            ai[aPk[i]] = 1;
        }

        for (int j = 0; j != aPl.length; j++)
        {
            ai[aPl[j]] = -1;
        }

        return new IntegerPolynomial(ai);
    }
}
