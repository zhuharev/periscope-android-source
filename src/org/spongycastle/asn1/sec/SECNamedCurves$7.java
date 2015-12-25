// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.sec:
//            SECNamedCurves

final class er extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
        BigInteger biginteger2 = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70");
        BigInteger biginteger3 = SECNamedCurves._mth1505("B4E134D3FB59EB8BAB57274904664D5AF50388BA");
        byte abyte0[] = Hex._mth1508("B99B99B099B323E02709A4D696E6768756151751");
        BigInteger biginteger = SECNamedCurves._mth1505("0100000000000000000000351EE786A818F3A1A16B");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("0452DCB034293A117E1F4FF11B30F7199D3144CE6DFEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E")), biginteger, biginteger1, abyte0);
    }

    er()
    {
    }
}
