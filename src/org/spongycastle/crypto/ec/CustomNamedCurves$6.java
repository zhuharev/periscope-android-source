// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.sec.SecP256K1Curve;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class rve extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
        BigInteger biginteger = new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
        BigInteger biginteger1 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
        BigInteger biginteger2 = new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16);
        BigInteger biginteger3 = new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16);
        BigInteger biginteger4 = new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16);
        BigInteger biginteger5 = new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16);
        BigInteger biginteger6 = new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16);
        obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
            biginteger1, biginteger2
        }, new BigInteger[] {
            biginteger3, biginteger4
        }, biginteger5, biginteger6, 272);
        obj = CustomNamedCurves._mth02CA(new SecP256K1Curve(), ((GLVTypeBParameters) (obj)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
    }

    rve()
    {
    }
}
