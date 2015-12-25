// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            Resultant, BigIntPolynomial

public class ModularResultant extends Resultant
{

    private BigInteger adi;

    ModularResultant(BigIntPolynomial bigintpolynomial, BigInteger biginteger, BigInteger biginteger1)
    {
        super(bigintpolynomial, biginteger);
        adi = biginteger1;
    }

    static ModularResultant _mth02CA(ModularResultant modularresultant, ModularResultant modularresultant1)
    {
        BigInteger biginteger1 = modularresultant.adi;
        BigInteger biginteger2 = modularresultant1.adi;
        BigInteger biginteger = biginteger1.multiply(biginteger2);
        BigIntEuclidean biginteuclidean = BigIntEuclidean._mth141D(biginteger2, biginteger1);
        modularresultant = (BigIntPolynomial)modularresultant.aPi.clone();
        modularresultant._mth02CC(biginteuclidean.amZ.multiply(biginteger2));
        modularresultant1 = (BigIntPolynomial)modularresultant1.aPi.clone();
        modularresultant1._mth02CC(biginteuclidean.axe.multiply(biginteger1));
        modularresultant._mth02CF(modularresultant1);
        for (int i = 0; i < ((BigIntPolynomial) (modularresultant)).aOV.length; i++)
        {
            modularresultant1 = ((BigIntPolynomial) (modularresultant)).aOV;
            modularresultant1[i] = modularresultant1[i].mod(biginteger);
        }

        return new ModularResultant(modularresultant, null, biginteger);
    }
}
