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
        Object obj = SECNamedCurves._mth1505("DB7C2ABF62E35E668076BEAD208B");
        BigInteger biginteger2 = SECNamedCurves._mth1505("6127C24C05F38A0AAAF65C0EF02C");
        BigInteger biginteger3 = SECNamedCurves._mth1505("51DEF1815DB5ED74FCC34C85D709");
        byte abyte0[] = Hex._mth1508("002757A1114D696E6768756151755316C05E0BD4");
        BigInteger biginteger = SECNamedCurves._mth1505("36DF0AAFD8B8D7597CA10520D04B");
        BigInteger biginteger1 = BigInteger.valueOf(4L);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("044BA30AB5E892B4E1649DD0928643ADCD46F5882E3747DEF36E956E97")), biginteger, biginteger1, abyte0);
    }

    er()
    {
    }
}
