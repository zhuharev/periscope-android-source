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
        BigInteger biginteger = new BigInteger("20000000000000000000000050508CB89F652824E06B8173", 16);
        BigInteger biginteger1 = BigInteger.valueOf(4L);
        org.spongycastle.math.ec.r r = new org.spongycastle.math.ec.r(191, 9, new BigInteger("401028774D7777C7B7666D1366EA432071274F89FF01E718", 16), new BigInteger("0620048D28BCBD03B6249C99182B7C8CD19700C362C46A01", 16), biginteger, biginteger1);
        return new X9ECParameters(r, r._mth01C3(Hex._mth1508("023809B2B7CC1B28CC5A87926AAD83FD28789E81E2C9E3BF10")), biginteger, biginteger1, null);
    }

    r()
    {
    }
}
