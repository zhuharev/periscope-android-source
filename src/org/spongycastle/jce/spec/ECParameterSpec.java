// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECParameterSpec
    implements AlgorithmParameterSpec
{

    public ECCurve alm;
    public byte aln[];
    public BigInteger alr;
    public BigInteger als;
    public ECPoint axi;

    public ECParameterSpec(org.spongycastle.math.ec.ECCurve.F2m f2m, ECPoint ecpoint, BigInteger biginteger)
    {
        alm = f2m;
        axi = ecpoint._mth0188();
        alr = biginteger;
        als = BigInteger.valueOf(1L);
        aln = null;
    }

    public ECParameterSpec(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        alm = eccurve;
        axi = ecpoint._mth0188();
        alr = biginteger;
        als = biginteger1;
        aln = abyte0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ECParameterSpec))
        {
            return false;
        }
        obj = (ECParameterSpec)obj;
        return alm._mth02BB(((ECParameterSpec) (obj)).alm) && axi._mth02CF(((ECParameterSpec) (obj)).axi);
    }

    public int hashCode()
    {
        return alm.hashCode() ^ axi.hashCode();
    }
}
