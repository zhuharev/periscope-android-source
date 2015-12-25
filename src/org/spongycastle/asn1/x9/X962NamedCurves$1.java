// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ECParametersHolder, X9ECParameters

final class er extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        BigInteger biginteger = new BigInteger("ffffffffffffffffffffffff99def836146bc9b1b4d22831", 16);
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        org.spongycastle.math.ec.er er = new org.spongycastle.math.ec.er(new BigInteger("6277101735386680763835789423207666416083908700390324961279"), new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16), new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16), biginteger, biginteger1);
        return new X9ECParameters(er, er._mth01C3(Hex._mth1508("03188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012")), biginteger, biginteger1, Hex._mth1508("3045AE6FC8422f64ED579528D38120EAE12196D5"));
    }

    er()
    {
    }
}
