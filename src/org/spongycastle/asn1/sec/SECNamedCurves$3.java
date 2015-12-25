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
        Object obj = SECNamedCurves._mth1505("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
        BigInteger biginteger2 = SECNamedCurves._mth1505("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC");
        BigInteger biginteger3 = SECNamedCurves._mth1505("E87579C11079F43DD824993C2CEE5ED3");
        byte abyte0[] = Hex._mth1508("000E0D4D696E6768756151750CC03A4473D03679");
        BigInteger biginteger = SECNamedCurves._mth1505("FFFFFFFE0000000075A30D1B9038A115");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04161FF7528B899B2D0C28607CA52C5B86CF5AC8395BAFEB13C02DA292DDED7A83")), biginteger, biginteger1, abyte0);
    }

    er()
    {
    }
}
