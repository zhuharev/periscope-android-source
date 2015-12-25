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

final class ters extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = SECNamedCurves._mth1505("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D");
        BigInteger biginteger2 = ECConstants.ZERO;
        BigInteger biginteger3 = BigInteger.valueOf(5L);
        BigInteger biginteger = SECNamedCurves._mth1505("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        Object obj1 = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
        BigInteger biginteger4 = new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
        BigInteger biginteger5 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
        BigInteger biginteger6 = new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16);
        BigInteger biginteger7 = new BigInteger("1243ae1b4d71613bc9f780a03690e", 16);
        BigInteger biginteger8 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
        BigInteger biginteger9 = new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16);
        BigInteger biginteger10 = new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16);
        obj1 = new GLVTypeBParameters(((BigInteger) (obj1)), biginteger4, new BigInteger[] {
            biginteger5, biginteger6
        }, new BigInteger[] {
            biginteger7, biginteger8
        }, biginteger9, biginteger10, 240);
        obj = SECNamedCurves._mth02CA(new org.spongycastle.math.ec.CA(((BigInteger) (obj)), biginteger2, biginteger3, biginteger, biginteger1), ((GLVTypeBParameters) (obj1)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), biginteger, biginteger1, null);
    }

    ters()
    {
    }
}
