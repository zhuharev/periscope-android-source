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
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF");
        BigInteger biginteger2 = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC");
        BigInteger biginteger3 = SECNamedCurves._mth1505("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1");
        byte abyte0[] = Hex._mth1508("3045AE6FC8422F64ED579528D38120EAE12196D5");
        BigInteger biginteger = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), biginteger, biginteger1, abyte0);
    }

    er()
    {
    }
}
