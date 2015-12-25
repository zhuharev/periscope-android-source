// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.field;

import java.math.BigInteger;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.math.field:
//            PolynomialExtensionField, FiniteField, Polynomial, GF2Polynomial

class GenericPolynomialExtensionField
    implements PolynomialExtensionField
{

    private FiniteField aJG;
    private Polynomial aJH;

    GenericPolynomialExtensionField(FiniteField finitefield, GF2Polynomial gf2polynomial)
    {
        aJG = finitefield;
        aJH = gf2polynomial;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField))
        {
            return false;
        }
        obj = (GenericPolynomialExtensionField)obj;
        return aJG.equals(((GenericPolynomialExtensionField) (obj)).aJG) && aJH.equals(((GenericPolynomialExtensionField) (obj)).aJH);
    }

    public int hashCode()
    {
        return aJG.hashCode() ^ Integers.rotateLeft(aJH.hashCode(), 16);
    }

    public final BigInteger _mth0506()
    {
        return aJG._mth0506();
    }

    public final int _mth0546()
    {
        return aJG._mth0546() * aJH._mth0575();
    }

    public final Polynomial _mth057D()
    {
        return aJH;
    }
}
