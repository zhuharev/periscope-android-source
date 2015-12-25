// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2Polynomial, GF2nPolynomialField, GF2nONBField

public abstract class GF2nField
{

    protected GF2Polynomial aOE;

    public GF2nField()
    {
    }

    public final boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2nField))
        {
            return false;
        }
        obj = (GF2nField)obj;
        if (!aOE.equals(((GF2nField) (obj)).aOE))
        {
            return false;
        }
        if ((this instanceof GF2nPolynomialField) && !(obj instanceof GF2nPolynomialField))
        {
            return false;
        }
        return !(this instanceof GF2nONBField) || (obj instanceof GF2nONBField);
    }

    public int hashCode()
    {
        return aOE.hashCode() + 0;
    }

    public final GF2Polynomial _mth1531()
    {
        if (aOE == null)
        {
            _mth1532();
        }
        return new GF2Polynomial(aOE);
    }

    protected abstract void _mth1532();
}
