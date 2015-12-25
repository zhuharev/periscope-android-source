// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.sec.SecP224K1Curve;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class rve extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        Object obj = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
        BigInteger biginteger = new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
        BigInteger biginteger1 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
        BigInteger biginteger2 = new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16);
        BigInteger biginteger3 = new BigInteger("1243ae1b4d71613bc9f780a03690e", 16);
        BigInteger biginteger4 = new BigInteger("6b8cf07d4ca75c88957d9d670591", 16);
        BigInteger biginteger5 = new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16);
        BigInteger biginteger6 = new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16);
        obj = new GLVTypeBParameters(((BigInteger) (obj)), biginteger, new BigInteger[] {
            biginteger1, biginteger2
        }, new BigInteger[] {
            biginteger3, biginteger4
        }, biginteger5, biginteger6, 240);
        obj = CustomNamedCurves._mth02CA(new SecP224K1Curve(), ((GLVTypeBParameters) (obj)));
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj))._mth01C3(Hex._mth1508("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), ((ECCurve) (obj)).getOrder(), ((ECCurve) (obj)).FB52(), null);
    }

    rve()
    {
    }
}
