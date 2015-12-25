// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ecgost:
//            BCECGOST3410PrivateKey, BCECGOST3410PublicKey

public class KeyFactorySpi extends BaseKeyFactorySpi
{

    public KeyFactorySpi()
    {
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keyspec)
    {
        if (keyspec instanceof ECPrivateKeySpec)
        {
            return new BCECGOST3410PrivateKey((ECPrivateKeySpec)keyspec);
        }
        if (keyspec instanceof java.security.spec.ECPrivateKeySpec)
        {
            return new BCECGOST3410PrivateKey((java.security.spec.ECPrivateKeySpec)keyspec);
        } else
        {
            return super.engineGeneratePrivate(keyspec);
        }
    }

    protected PublicKey engineGeneratePublic(KeySpec keyspec)
    {
        if (keyspec instanceof ECPublicKeySpec)
        {
            return new BCECGOST3410PublicKey((ECPublicKeySpec)keyspec);
        }
        if (keyspec instanceof java.security.spec.ECPublicKeySpec)
        {
            return new BCECGOST3410PublicKey((java.security.spec.ECPublicKeySpec)keyspec);
        } else
        {
            return super.engineGeneratePublic(keyspec);
        }
    }

    protected KeySpec engineGetKeySpec(Key key, Class class1)
    {
        if (class1.isAssignableFrom(java/security/spec/ECPublicKeySpec) && (key instanceof ECPublicKey))
        {
            key = (ECPublicKey)key;
            if (key.getParams() != null)
            {
                return new java.security.spec.ECPublicKeySpec(key.getW(), key.getParams());
            } else
            {
                class1 = BouncyCastleProvider.aGZ._mth1623();
                return new java.security.spec.ECPublicKeySpec(key.getW(), EC5Util._mth02CA(EC5Util._mth02CE(((ECParameterSpec) (class1)).alm), class1));
            }
        }
        if (class1.isAssignableFrom(java/security/spec/ECPrivateKeySpec) && (key instanceof ECPrivateKey))
        {
            key = (ECPrivateKey)key;
            if (key.getParams() != null)
            {
                return new java.security.spec.ECPrivateKeySpec(key.getS(), key.getParams());
            } else
            {
                class1 = BouncyCastleProvider.aGZ._mth1623();
                return new java.security.spec.ECPrivateKeySpec(key.getS(), EC5Util._mth02CA(EC5Util._mth02CE(((ECParameterSpec) (class1)).alm), class1));
            }
        }
        if (class1.isAssignableFrom(org/spongycastle/jce/spec/ECPublicKeySpec) && (key instanceof ECPublicKey))
        {
            key = (ECPublicKey)key;
            if (key.getParams() != null)
            {
                return new ECPublicKeySpec(EC5Util._mth02CA(key.getParams(), key.getW(), false), EC5Util._mth02CA(key.getParams(), false));
            } else
            {
                class1 = BouncyCastleProvider.aGZ._mth1623();
                return new ECPublicKeySpec(EC5Util._mth02CA(key.getParams(), key.getW(), false), class1);
            }
        }
        if (class1.isAssignableFrom(org/spongycastle/jce/spec/ECPrivateKeySpec) && (key instanceof ECPrivateKey))
        {
            key = (ECPrivateKey)key;
            if (key.getParams() != null)
            {
                return new ECPrivateKeySpec(key.getS(), EC5Util._mth02CA(key.getParams(), false));
            } else
            {
                class1 = BouncyCastleProvider.aGZ._mth1623();
                return new ECPrivateKeySpec(key.getS(), class1);
            }
        } else
        {
            return super.engineGetKeySpec(key, class1);
        }
    }

    protected Key engineTranslateKey(Key key)
    {
        throw new InvalidKeyException("key type unknown");
    }

    public final PrivateKey _mth02CA(PrivateKeyInfo privatekeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(privatekeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(CryptoProObjectIdentifiers.XW))
        {
            return new BCECGOST3410PrivateKey(privatekeyinfo);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }

    public final PublicKey _mth02CB(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(CryptoProObjectIdentifiers.XW))
        {
            return new BCECGOST3410PublicKey(subjectpublickeyinfo);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }
}
