// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.djb.Curve25519;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.crypto.ec:
//            CustomNamedCurves

final class  extends X9ECParametersHolder
{

    protected final X9ECParameters _mth098C()
    {
        ECCurve eccurve = CustomNamedCurves._mth02CA(new Curve25519());
        return new X9ECParameters(eccurve, eccurve._mth01C3(Hex._mth1508("042AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD245A20AE19A1B8A086B4E01EDD2C7748D14C923D4D7E6D7C61B229E9C5A27ECED3D9")), eccurve.getOrder(), eccurve.FB52(), null);
    }

    ()
    {
    }
}
