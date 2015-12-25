// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECDomainParameters
    implements ECConstants
{

    public ECCurve alm;
    public byte aln[];
    public BigInteger alr;
    public BigInteger als;
    public ECPoint axi;

    public ECDomainParameters(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger)
    {
        this(eccurve, ecpoint, biginteger, ONE, null);
    }

    public ECDomainParameters(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1)
    {
        this(eccurve, ecpoint, biginteger, biginteger1, null);
    }

    public ECDomainParameters(ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        alm = eccurve;
        axi = ecpoint._mth0188();
        alr = biginteger;
        als = biginteger1;
        aln = abyte0;
    }
}
