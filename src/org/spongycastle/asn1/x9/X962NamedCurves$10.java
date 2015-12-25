// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ECParametersHolder, X9ECParameters

final class r extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        BigInteger biginteger = new BigInteger("03FFFFFFFFFFFFFFFFFFFE1AEE140F110AFF961309", 16);
        BigInteger biginteger1 = BigInteger.valueOf(2L);
        org.spongycastle.math.ec.r r = new org.spongycastle.math.ec.r(163, 1, 2, 8, new BigInteger("07A526C63D3E25A256A007699F5447E32AE456B50E", 16), new BigInteger("03F7061798EB99E238FD6F1BF95B48FEEB4854252B", 16), biginteger, biginteger1);
        return new X9ECParameters(r, r._mth01C3(Hex._mth1508("0202F9F87B7C574D0BDECF8A22E6524775F98CDEBDCB")), biginteger, biginteger1, null);
    }

    r()
    {
    }
}
