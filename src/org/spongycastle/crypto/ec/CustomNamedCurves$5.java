// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.sec.SecP224R1Curve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class rve extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        byte abyte0[] = Hex._mth1508("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
        ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP224R1Curve());
        return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34")), eccurve.getOrder(), eccurve.FB52(), abyte0);
    }

    rve()
    {
    }
}
