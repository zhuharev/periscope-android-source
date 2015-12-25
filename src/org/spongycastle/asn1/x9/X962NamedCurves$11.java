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
        BigInteger biginteger = new BigInteger("010092537397ECA4F6145799D62B0A19CE06FE26AD", 16);
        BigInteger biginteger1 = BigInteger.valueOf(65390L);
        org.spongycastle.math.ec.r r = new org.spongycastle.math.ec.r(176, 1, 2, 43, new BigInteger("00E4E6DB2995065C407D9D39B8D0967B96704BA8E9C90B", 16), new BigInteger("005DDA470ABE6414DE8EC133AE28E9BBD7FCEC0AE0FFF2", 16), biginteger, biginteger1);
        return new X9ECParameters(r, r._mth01C3(Hex._mth1508("038D16C2866798B600F9F08BB4A8E860F3298CE04A5798")), biginteger, biginteger1, null);
    }

    r()
    {
    }
}
