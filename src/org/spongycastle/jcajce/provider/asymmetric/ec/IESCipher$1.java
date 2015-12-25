// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECPoint;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            IESCipher

class aDo
    implements KeyEncoder
{

    private IESCipher aDo;

    public final byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter)
    {
        return ((ECPublicKeyParameters)asymmetrickeyparameter).axk.getEncoded();
    }

    (IESCipher iescipher)
    {
        aDo = iescipher;
        super();
    }
}
