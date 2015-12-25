// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.sec.SecP192R1Curve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class rve extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        byte abyte0[] = Hex._mth1508("3045AE6FC8422F64ED579528D38120EAE12196D5");
        ECCurve eccurve = CustomNamedCurves._mth02CA(new SecP192R1Curve());
        return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), eccurve.getOrder(), eccurve.FB52(), abyte0);
    }

    rve()
    {
    }
}
