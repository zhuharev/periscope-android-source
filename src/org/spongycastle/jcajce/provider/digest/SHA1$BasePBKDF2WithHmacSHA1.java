// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            SHA1

public static class scheme extends BaseSecretKeyFactory
{

    private int scheme;

    protected SecretKey engineGenerateSecret(KeySpec keyspec)
    {
        if (keyspec instanceof PBEKeySpec)
        {
            keyspec = (PBEKeySpec)keyspec;
            if (keyspec.getSalt() == null)
            {
                throw new InvalidKeySpecException("missing required salt");
            }
            if (keyspec.getIterationCount() <= 0)
            {
                throw new InvalidKeySpecException((new StringBuilder("positive iteration count required: ")).append(keyspec.getIterationCount()).toString());
            }
            if (keyspec.getKeyLength() <= 0)
            {
                throw new InvalidKeySpecException((new StringBuilder("positive key length required: ")).append(keyspec.getKeyLength()).toString());
            }
            if (keyspec.getPassword().length == 0)
            {
                throw new IllegalArgumentException("password empty");
            } else
            {
                int i = keyspec.getKeyLength();
                org.spongycastle.crypto.CipherParameters cipherparameters = org.spongycastle.jcajce.provider.symmetric.util.Q(keyspec, scheme, 1, i);
                return new BCPBEKey(aFS, aFZ, scheme, 1, i, -1, keyspec, cipherparameters);
            }
        } else
        {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public (String s, int i)
    {
        super(s, PKCSObjectIdentifiers.abu);
        scheme = i;
    }
}
