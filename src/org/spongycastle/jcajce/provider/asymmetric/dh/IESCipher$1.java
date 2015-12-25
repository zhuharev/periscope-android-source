// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dh:
//            IESCipher

class aCS
    implements KeyEncoder
{

    private IESCipher aCS;

    public final byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter)
    {
        byte abyte0[] = new byte[(((DHKeyParameters)asymmetrickeyparameter).axb.amM.bitLength() + 7) / 8];
        asymmetrickeyparameter = BigIntegers._mth02D1(((DHPublicKeyParameters)asymmetrickeyparameter).axe);
        if (asymmetrickeyparameter.length > abyte0.length)
        {
            throw new IllegalArgumentException("Senders's public key longer than expected.");
        } else
        {
            System.arraycopy(asymmetrickeyparameter, 0, abyte0, abyte0.length - asymmetrickeyparameter.length, asymmetrickeyparameter.length);
            return abyte0;
        }
    }

    (IESCipher iescipher)
    {
        aCS = iescipher;
        super();
    }
}
