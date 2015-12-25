// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class BaseKeyFactorySpi extends KeyFactorySpi
    implements AsymmetricKeyInfoConverter
{

    public BaseKeyFactorySpi()
    {
    }

    public PrivateKey engineGeneratePrivate(KeySpec keyspec)
    {
        if (keyspec instanceof PKCS8EncodedKeySpec)
        {
            try
            {
                keyspec = _mth02CA(PrivateKeyInfo._mth1D38(((PKCS8EncodedKeySpec)keyspec).getEncoded()));
            }
            // Misplaced declaration of an exception variable
            catch (KeySpec keyspec)
            {
                throw new InvalidKeySpecException("encoded key spec not recognised");
            }
            return keyspec;
        } else
        {
            throw new InvalidKeySpecException("key spec not recognised");
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keyspec)
    {
        if (keyspec instanceof X509EncodedKeySpec)
        {
            try
            {
                keyspec = _mth02CB(SubjectPublicKeyInfo._mth13A5(((X509EncodedKeySpec)keyspec).getEncoded()));
            }
            // Misplaced declaration of an exception variable
            catch (KeySpec keyspec)
            {
                throw new InvalidKeySpecException("encoded key spec not recognised");
            }
            return keyspec;
        } else
        {
            throw new InvalidKeySpecException("key spec not recognised");
        }
    }

    public KeySpec engineGetKeySpec(Key key, Class class1)
    {
        if (class1.isAssignableFrom(java/security/spec/PKCS8EncodedKeySpec) && key.getFormat().equals("PKCS#8"))
        {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (class1.isAssignableFrom(java/security/spec/X509EncodedKeySpec) && key.getFormat().equals("X.509"))
        {
            return new X509EncodedKeySpec(key.getEncoded());
        } else
        {
            throw new InvalidKeySpecException((new StringBuilder("not implemented yet ")).append(key).append(" ").append(class1).toString());
        }
    }
}
