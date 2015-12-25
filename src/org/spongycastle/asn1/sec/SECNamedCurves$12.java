// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.sec:
//            SECNamedCurves

final class ters extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
        BigInteger biginteger2 = ECConstants.ZERO;
        BigInteger biginteger3 = BigInteger.valueOf(7L);
        BigInteger biginteger = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        Object obj1 = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
        BigInteger biginteger4 = new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
        BigInteger biginteger5 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
        BigInteger biginteger6 = new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16);
        BigInteger biginteger7 = new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16);
        BigInteger biginteger8 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
        BigInteger biginteger9 = new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16);
        BigInteger biginteger10 = new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16);
        obj1 = new GLVTypeBParameters(((BigInteger) (obj1)), biginteger4, new BigInteger[] {
            biginteger5, biginteger6
        }, new BigInteger[] {
            biginteger7, biginteger8
        }, biginteger9, biginteger10, 272);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.CA(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1), ((GLVTypeBParameters) (obj1)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), biginteger, biginteger1, null);
    }

    ters()
    {
    }
}
