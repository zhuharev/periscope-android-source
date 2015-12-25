// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.rainbow:
//            BCRainbowPrivateKey, BCRainbowPublicKey

public class RainbowKeysToParams
{

    public RainbowKeysToParams()
    {
    }

    public static RainbowPrivateKeyParameters _mth02BD(PrivateKey privatekey)
    {
        if (privatekey instanceof BCRainbowPrivateKey)
        {
            privatekey = (BCRainbowPrivateKey)privatekey;
            return new RainbowPrivateKeyParameters(((BCRainbowPrivateKey) (privatekey)).aND, ((BCRainbowPrivateKey) (privatekey)).aNE, ((BCRainbowPrivateKey) (privatekey)).aNG, ((BCRainbowPrivateKey) (privatekey)).aNH, ((BCRainbowPrivateKey) (privatekey)).aNI, ((BCRainbowPrivateKey) (privatekey)).aKk);
        } else
        {
            throw new InvalidKeyException("can't identify Rainbow private key.");
        }
    }

    public static RainbowPublicKeyParameters _mth1FBE(PublicKey publickey)
    {
        if (publickey instanceof BCRainbowPublicKey)
        {
            publickey = (BCRainbowPublicKey)publickey;
            return new RainbowPublicKeyParameters(((BCRainbowPublicKey) (publickey)).aNM, ((BCRainbowPublicKey) (publickey)).aNO, publickey._mth09DD(), Arrays._mth02CB(((BCRainbowPublicKey) (publickey)).aNQ));
        } else
        {
            throw new InvalidKeyException((new StringBuilder("can't identify Rainbow public key: ")).append(publickey.getClass().getName()).toString());
        }
    }
}
