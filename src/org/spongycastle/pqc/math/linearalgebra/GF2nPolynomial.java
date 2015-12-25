// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


public class GF2nPolynomial
{

    public final boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2nPolynomial))
        {
            return false;
        } else
        {
            obj = (GF2nPolynomial)obj;
            return true;
        }
    }

    public int hashCode()
    {
        throw new NullPointerException();
    }
}
