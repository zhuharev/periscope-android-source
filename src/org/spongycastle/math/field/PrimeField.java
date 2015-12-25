// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.field;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.field:
//            FiniteField

class PrimeField
    implements FiniteField
{

    private BigInteger aJI;

    PrimeField(BigInteger biginteger)
    {
        aJI = biginteger;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof PrimeField))
        {
            return false;
        } else
        {
            obj = (PrimeField)obj;
            return aJI.equals(((PrimeField) (obj)).aJI);
        }
    }

    public int hashCode()
    {
        return aJI.hashCode();
    }

    public final BigInteger _mth0506()
    {
        return aJI;
    }

    public final int _mth0546()
    {
        return 1;
    }
}
