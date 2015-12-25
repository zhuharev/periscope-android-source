// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.rainbow:
//            BCRainbowPrivateKey, BCRainbowPublicKey

public class RainbowKeyFactorySpi extends KeyFactorySpi
    implements AsymmetricKeyInfoConverter
{

    public RainbowKeyFactorySpi()
    {
    }

    public PrivateKey engineGeneratePrivate(KeySpec keyspec)
    {
        if (keyspec instanceof RainbowPrivateKeySpec)
        {
            return new BCRainbowPrivateKey((RainbowPrivateKeySpec)keyspec);
        }
        if (keyspec instanceof PKCS8EncodedKeySpec)
        {
            keyspec = ((PKCS8EncodedKeySpec)keyspec).getEncoded();
            try
            {
                keyspec = _mth02CA(PrivateKeyInfo._mth1D38(ASN1Primitive._mth0640(keyspec)));
            }
            // Misplaced declaration of an exception variable
            catch (KeySpec keyspec)
            {
                throw new InvalidKeySpecException(keyspec.toString());
            }
            return keyspec;
        } else
        {
            throw new InvalidKeySpecException((new StringBuilder("Unsupported key specification: ")).append(keyspec.getClass()).append(".").toString());
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keyspec)
    {
        if (keyspec instanceof RainbowPublicKeySpec)
        {
            return new BCRainbowPublicKey((RainbowPublicKeySpec)keyspec);
        }
        if (keyspec instanceof X509EncodedKeySpec)
        {
            keyspec = ((X509EncodedKeySpec)keyspec).getEncoded();
            try
            {
                keyspec = RainbowPublicKey._mth1427((new ASN1InputStream(SubjectPublicKeyInfo._mth13A5(keyspec).ajD.getBytes()))._mth04B7());
                keyspec = new BCRainbowPublicKey((new BigInteger(((RainbowPublicKey) (keyspec)).aKl.bytes)).intValue(), RainbowUtil._mth02CE(((RainbowPublicKey) (keyspec)).aKm), RainbowUtil._mth02CE(((RainbowPublicKey) (keyspec)).aKn), RainbowUtil._mth14A2(((RainbowPublicKey) (keyspec)).aKo));
            }
            // Misplaced declaration of an exception variable
            catch (KeySpec keyspec)
            {
                throw new InvalidKeySpecException(keyspec.toString());
            }
            return keyspec;
        } else
        {
            throw new InvalidKeySpecException((new StringBuilder("Unknown key specification: ")).append(keyspec).append(".").toString());
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class class1)
    {
        if (key instanceof BCRainbowPrivateKey)
        {
            if (java/security/spec/PKCS8EncodedKeySpec.isAssignableFrom(class1))
            {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (org/spongycastle/pqc/jcajce/spec/RainbowPrivateKeySpec.isAssignableFrom(class1))
            {
                key = (BCRainbowPrivateKey)key;
                return new RainbowPrivateKeySpec(((BCRainbowPrivateKey) (key)).aND, ((BCRainbowPrivateKey) (key)).aNE, ((BCRainbowPrivateKey) (key)).aNG, ((BCRainbowPrivateKey) (key)).aNH, ((BCRainbowPrivateKey) (key)).aNI, ((BCRainbowPrivateKey) (key)).aKk);
            }
        } else
        if (key instanceof BCRainbowPublicKey)
        {
            if (java/security/spec/X509EncodedKeySpec.isAssignableFrom(class1))
            {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (org/spongycastle/pqc/jcajce/spec/RainbowPublicKeySpec.isAssignableFrom(class1))
            {
                key = (BCRainbowPublicKey)key;
                return new RainbowPublicKeySpec(((BCRainbowPublicKey) (key)).aNM, ((BCRainbowPublicKey) (key)).aNO, key._mth09DD(), Arrays._mth02CB(((BCRainbowPublicKey) (key)).aNQ));
            }
        } else
        {
            throw new InvalidKeySpecException((new StringBuilder("Unsupported key type: ")).append(key.getClass()).append(".").toString());
        }
        throw new InvalidKeySpecException((new StringBuilder("Unknown key specification: ")).append(class1).append(".").toString());
    }

    public final Key engineTranslateKey(Key key)
    {
        if ((key instanceof BCRainbowPrivateKey) || (key instanceof BCRainbowPublicKey))
        {
            return key;
        } else
        {
            throw new InvalidKeyException("Unsupported key type");
        }
    }

    public final PrivateKey _mth02CA(PrivateKeyInfo privatekeyinfo)
    {
        privatekeyinfo = RainbowPrivateKey._mth1423(ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501()));
        return new BCRainbowPrivateKey(RainbowUtil._mth02CE(((RainbowPrivateKey) (privatekeyinfo)).aKf), RainbowUtil._mth14A2(((RainbowPrivateKey) (privatekeyinfo)).aKg), RainbowUtil._mth02CE(((RainbowPrivateKey) (privatekeyinfo)).aKh), RainbowUtil._mth14A2(((RainbowPrivateKey) (privatekeyinfo)).aKi), RainbowUtil._mth14A1(((RainbowPrivateKey) (privatekeyinfo)).aKj), ((RainbowPrivateKey) (privatekeyinfo)).aKk);
    }

    public final PublicKey _mth02CB(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        subjectpublickeyinfo = RainbowPublicKey._mth1427((new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7());
        return new BCRainbowPublicKey((new BigInteger(((RainbowPublicKey) (subjectpublickeyinfo)).aKl.bytes)).intValue(), RainbowUtil._mth02CE(((RainbowPublicKey) (subjectpublickeyinfo)).aKm), RainbowUtil._mth02CE(((RainbowPublicKey) (subjectpublickeyinfo)).aKn), RainbowUtil._mth14A2(((RainbowPublicKey) (subjectpublickeyinfo)).aKo));
    }
}
