// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec
{

    public BigInteger amM;
    public BigInteger amN;
    public BigInteger amW;

    public GOST3410PublicKeyParameterSetSpec(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        amM = biginteger;
        amN = biginteger1;
        amW = biginteger2;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof GOST3410PublicKeyParameterSetSpec)
        {
            obj = (GOST3410PublicKeyParameterSetSpec)obj;
            return amW.equals(((GOST3410PublicKeyParameterSetSpec) (obj)).amW) && amM.equals(((GOST3410PublicKeyParameterSetSpec) (obj)).amM) && amN.equals(((GOST3410PublicKeyParameterSetSpec) (obj)).amN);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return amW.hashCode() ^ amM.hashCode() ^ amN.hashCode();
    }
}
