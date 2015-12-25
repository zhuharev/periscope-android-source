// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECPoint;

// Referenced classes of package org.spongycastle.crypto.generators:
//            ECKeyPairGenerator

public class DSTU4145KeyPairGenerator extends ECKeyPairGenerator
{

    public DSTU4145KeyPairGenerator()
    {
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        Object obj = super._mth1491();
        ECPublicKeyParameters ecpublickeyparameters = (ECPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(ecpublickeyparameters.axk._mth029C(), ((ECKeyParameters) (ecpublickeyparameters)).aub), ((org.spongycastle.crypto.params.AsymmetricKeyParameter) (obj)));
    }
}
