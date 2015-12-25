// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.field;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.field:
//            PrimeField, GenericPolynomialExtensionField, GF2Polynomial, FiniteField

public abstract class FiniteFields
{

    private static PrimeField aJD = new PrimeField(BigInteger.valueOf(2L));
    private static PrimeField aJE = new PrimeField(BigInteger.valueOf(3L));

    public FiniteFields()
    {
    }

    public static FiniteField _mth02C8(BigInteger biginteger)
    {
        int i = biginteger.bitLength();
        if (biginteger.signum() <= 0 || i < 2)
        {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (i < 3)
        {
            switch (biginteger.intValue())
            {
            case 2: // '\002'
                return aJD;

            case 3: // '\003'
                return aJE;
            }
        }
        return new PrimeField(biginteger);
    }

    public static GenericPolynomialExtensionField _mth1FBE(int ai[])
    {
        if (ai[0] != 0)
        {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i = 1; i < ai.length; i++)
        {
            if (ai[i] <= ai[i - 1])
            {
                throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
            }
        }

        return new GenericPolynomialExtensionField(aJD, new GF2Polynomial(ai));
    }

}
