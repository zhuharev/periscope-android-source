// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            PBEPBKDF2

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
            }
            if (keyspec instanceof PBKDF2KeySpec)
            {
                Object obj = new ASN1ObjectIdentifier(((PBKDF2KeySpec)keyspec).aaU.ahP.identifier);
                byte byte0;
                if (((ASN1ObjectIdentifier) (obj)).equals(CryptoProObjectIdentifiers.XP))
                {
                    byte0 = 6;
                } else
                if (((ASN1ObjectIdentifier) (obj)).equals(PKCSObjectIdentifiers.abD))
                {
                    byte0 = 1;
                } else
                {
                    throw new InvalidKeySpecException((new StringBuilder("Invalid KeySpec: unknown PRF algorithm ")).append(obj).toString());
                }
                int j = keyspec.getKeyLength();
                obj = org.spongycastle.jcajce.provider.symmetric.util.e(keyspec, scheme, byte0, j);
                return new BCPBEKey(aFS, aFZ, scheme, byte0, j, -1, keyspec, ((org.spongycastle.crypto.CipherParameters) (obj)));
            } else
            {
                int i = keyspec.getKeyLength();
                org.spongycastle.crypto.CipherParameters cipherparameters = org.spongycastle.jcajce.provider.symmetric.util.e(keyspec, scheme, 1, i);
                return new BCPBEKey(aFS, aFZ, scheme, 1, i, -1, keyspec, cipherparameters);
            }
        } else
        {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public tory(String s, int i)
    {
        super(s, PKCSObjectIdentifiers.abu);
        scheme = 5;
    }
}
