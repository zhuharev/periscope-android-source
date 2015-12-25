// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410PrivateKeySpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeySpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.gost:
//            BCGOST3410PrivateKey, BCGOST3410PublicKey

public class KeyFactorySpi extends BaseKeyFactorySpi
{

    public KeyFactorySpi()
    {
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keyspec)
    {
        if (keyspec instanceof GOST3410PrivateKeySpec)
        {
            return new BCGOST3410PrivateKey((GOST3410PrivateKeySpec)keyspec);
        } else
        {
            return super.engineGeneratePrivate(keyspec);
        }
    }

    protected PublicKey engineGeneratePublic(KeySpec keyspec)
    {
        if (keyspec instanceof GOST3410PublicKeySpec)
        {
            return new BCGOST3410PublicKey((GOST3410PublicKeySpec)keyspec);
        } else
        {
            return super.engineGeneratePublic(keyspec);
        }
    }

    protected KeySpec engineGetKeySpec(Key key, Class class1)
    {
        if (class1.isAssignableFrom(org/spongycastle/jce/spec/GOST3410PublicKeySpec) && (key instanceof GOST3410PublicKey))
        {
            key = (GOST3410PublicKey)key;
            class1 = key._mth15BD()._mth1D2D();
            return new GOST3410PublicKeySpec(key.getY(), ((GOST3410PublicKeyParameterSetSpec) (class1)).amM, ((GOST3410PublicKeyParameterSetSpec) (class1)).amN, ((GOST3410PublicKeyParameterSetSpec) (class1)).amW);
        }
        if (class1.isAssignableFrom(org/spongycastle/jce/spec/GOST3410PrivateKeySpec) && (key instanceof GOST3410PrivateKey))
        {
            key = (GOST3410PrivateKey)key;
            class1 = key._mth15BD()._mth1D2D();
            return new GOST3410PrivateKeySpec(key.getX(), ((GOST3410PublicKeyParameterSetSpec) (class1)).amM, ((GOST3410PublicKeyParameterSetSpec) (class1)).amN, ((GOST3410PublicKeyParameterSetSpec) (class1)).amW);
        } else
        {
            return super.engineGetKeySpec(key, class1);
        }
    }

    protected Key engineTranslateKey(Key key)
    {
        if (key instanceof GOST3410PublicKey)
        {
            return new BCGOST3410PublicKey((GOST3410PublicKey)key);
        }
        if (key instanceof GOST3410PrivateKey)
        {
            return new BCGOST3410PrivateKey((GOST3410PrivateKey)key);
        } else
        {
            throw new InvalidKeyException("key type unknown");
        }
    }

    public final PrivateKey _mth02CA(PrivateKeyInfo privatekeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(privatekeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(CryptoProObjectIdentifiers.XV))
        {
            return new BCGOST3410PrivateKey(privatekeyinfo);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }

    public final PublicKey _mth02CB(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier);
        if (asn1objectidentifier.equals(CryptoProObjectIdentifiers.XV))
        {
            return new BCGOST3410PublicKey(subjectpublickeyinfo);
        } else
        {
            throw new IOException((new StringBuilder("algorithm identifier ")).append(asn1objectidentifier).append(" in key not recognised").toString());
        }
    }
}
