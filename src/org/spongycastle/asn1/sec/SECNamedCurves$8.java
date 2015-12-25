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

final class eters extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
        BigInteger biginteger2 = ECConstants.ZERO;
        BigInteger biginteger3 = BigInteger.valueOf(3L);
        BigInteger biginteger = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        Object obj1 = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
        BigInteger biginteger4 = new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
        BigInteger biginteger5 = new BigInteger("71169be7330b3038edb025f1", 16);
        BigInteger biginteger6 = new BigInteger("-b3fb3400dec5c4adceb8655c", 16);
        BigInteger biginteger7 = new BigInteger("12511cfe811d0f4e6bc688b4d", 16);
        BigInteger biginteger8 = new BigInteger("71169be7330b3038edb025f1", 16);
        BigInteger biginteger9 = new BigInteger("71169be7330b3038edb025f1d0f9", 16);
        BigInteger biginteger10 = new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16);
        obj1 = new GLVTypeBParameters(((BigInteger) (obj1)), biginteger4, new BigInteger[] {
            biginteger5, biginteger6
        }, new BigInteger[] {
            biginteger7, biginteger8
        }, biginteger9, biginteger10, 208);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1), ((GLVTypeBParameters) (obj1)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), biginteger, biginteger1, null);
    }

    eters()
    {
    }
}
