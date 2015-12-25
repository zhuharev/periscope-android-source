// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            BCECPrivateKey, BCECPublicKey

public class KeyFactorySpi extends BaseKeyFactorySpi
    implements AsymmetricKeyInfoConverter
{
    public static class EC extends KeyFactorySpi
    {

        public EC()
        {
            super("EC", BouncyCastleProvider.aGZ);
        }
    }

    public static class ECDH extends KeyFactorySpi
    {

        public ECDH()
        {
            super("ECDH", BouncyCastleProvider.aGZ);
        }
    }

    public static class ECDHC extends KeyFactorySpi
    {

        public ECDHC()
        {
            super("ECDHC", BouncyCastleProvider.aGZ);
        }
    }

    public static class ECDSA extends KeyFactorySpi
    {

        public ECDSA()
        {
            super("ECDSA", BouncyCastleProvider.aGZ);
        }
    }

    public static class ECGOST3410 extends KeyFactorySpi
    {

        public ECGOST3410()
        {
            super("ECGOST3410", BouncyCastleProvider.aGZ);
        }
    }

    public static class ECMQV extends KeyFactorySpi
    {

        public ECMQV()
        {
            super("ECMQV", BouncyCastleProvider.aGZ);
        }
    }


    private String aDc;
    private ProviderConfiguration aDm;

    KeyFactorySpi(String s, ProviderConfiguration providerconfiguration)
    {
        aDc = s;
        aDm = providerconfiguration;
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keyspec)
    {
        if (keyspec instanceof ECPrivateKeySpec)
        {
            return new BCECPrivateKey(aDc, (ECPrivateKeySpec)keyspec, aDm);
        }
        if (keyspec instanceof java.security.spec.ECPrivateKeySpec)
        {
            return new BCECPrivateKey(aDc, (java.security.spec.ECPrivateKeySpec)keyspec, aDm);
        } else
        {
            return super.engineGeneratePrivate(keyspec);
        }
    }

    protected PublicKey engineGeneratePublic(KeySpec keyspec)
    {
        if (keyspec instanceof ECPublicKeySpec)
        {
            return new BCECPublicKey(aDc, (ECPublicKeySpec)keyspec, aDm);
        }
        if (keyspec instanceof java.security.spec.ECPublicKeySpec)
        {
            return new BCECPublicKey(aDc, (java.security.spec.ECPublicKeySpec)keyspec, aDm);
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
        if (key instanceof ECPublicKey)
        {
            return new BCECPublicKey((ECPublicKey)key);
        }
        if (key instanceof ECPrivateKey)
        {
            return new BCECPrivateKey((ECPrivateKey)key, aDm);
        } else
        {
            throw new InvalidKeyException("key type unknown");
        }
    }

    public final PrivateKey _mth02CA(PrivateKeyInfo privatekeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(privatekeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(X9ObjectIdentifiers.alH))
        {
            return new BCECPrivateKey(aDc, privatekeyinfo, aDm);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }

    public final PublicKey _mth02CB(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(X9ObjectIdentifiers.alH))
        {
            return new BCECPublicKey(aDc, subjectpublickeyinfo, aDm);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }
}
