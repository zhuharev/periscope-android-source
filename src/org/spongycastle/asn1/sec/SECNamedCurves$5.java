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
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
        BigInteger biginteger2 = ECConstants.ZERO;
        BigInteger biginteger3 = BigInteger.valueOf(7L);
        BigInteger biginteger = SECNamedCurves._mth1505("0100000000000000000001B8FA16DFAB9ACA16B6B3");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        Object obj1 = new BigInteger("9ba48cba5ebcb9b6bd33b92830b2a2e0e192f10a", 16);
        BigInteger biginteger4 = new BigInteger("c39c6c3b3a36d7701b9c71a1f5804ae5d0003f4", 16);
        BigInteger biginteger5 = new BigInteger("9162fbe73984472a0a9e", 16);
        BigInteger biginteger6 = new BigInteger("-96341f1138933bc2f505", 16);
        BigInteger biginteger7 = new BigInteger("127971af8721782ecffa3", 16);
        BigInteger biginteger8 = new BigInteger("9162fbe73984472a0a9e", 16);
        BigInteger biginteger9 = new BigInteger("9162fbe73984472a0a9d0590", 16);
        BigInteger biginteger10 = new BigInteger("96341f1138933bc2f503fd44", 16);
        obj1 = new GLVTypeBParameters(((BigInteger) (obj1)), biginteger4, new BigInteger[] {
            biginteger5, biginteger6
        }, new BigInteger[] {
            biginteger7, biginteger8
        }, biginteger9, biginteger10, 176);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1), ((GLVTypeBParameters) (obj1)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("043B4C382CE37AA192A4019E763036F4F5DD4D7EBB938CF935318FDCED6BC28286531733C3F03C4FEE")), biginteger, biginteger1, null);
    }

    eters()
    {
    }
}
