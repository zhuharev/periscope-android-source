// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.sec.SecP192K1Curve;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class rve extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
        BigInteger biginteger = new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
        BigInteger biginteger1 = new BigInteger("71169be7330b3038edb025f1", 16);
        BigInteger biginteger2 = new BigInteger("-b3fb3400dec5c4adceb8655c", 16);
        BigInteger biginteger3 = new BigInteger("12511cfe811d0f4e6bc688b4d", 16);
        BigInteger biginteger4 = new BigInteger("71169be7330b3038edb025f1", 16);
        BigInteger biginteger5 = new BigInteger("71169be7330b3038edb025f1d0f9", 16);
        BigInteger biginteger6 = new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16);
        obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
            biginteger1, biginteger2
        }, new BigInteger[] {
            biginteger3, biginteger4
        }, biginteger5, biginteger6, 208);
        obj = CustomNamedCurves._mth02CA(new SecP192K1Curve(), ((GLVTypeBParameters) (obj)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
    }

    rve()
    {
    }
}
