// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            KeyPairGeneratorSpi, BCECPublicKey, BCECPrivateKey

public static class aDm extends KeyPairGeneratorSpi
{

    private static Hashtable aDv;
    private String aDc;
    private AlgorithmParameterSpec aDg;
    private ECKeyGenerationParameters aDi;
    private ProviderConfiguration aDm;
    private ECKeyPairGenerator aDu;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;
    private int atV;

    private static ECKeyGenerationParameters _mth02CA(ECParameterSpec ecparameterspec, SecureRandom securerandom)
    {
        org.spongycastle.math.ec.ECCurve eccurve = EC5Util._mth02CA(ecparameterspec.getCurve());
        return new ECKeyGenerationParameters(new ECDomainParameters(eccurve, EC5Util._mth02CA(eccurve, ecparameterspec.getGenerator(), false), ecparameterspec.getOrder(), BigInteger.valueOf(ecparameterspec.getCofactor())), securerandom);
    }

    private static ECNamedCurveSpec _mth1551(String s)
    {
        Object obj;
        X9ECParameters x9ecparameters = ECNamedCurveTable._mth14BB(s);
        obj = x9ecparameters;
        if (x9ecparameters != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        try
        {
            obj = ECNamedCurveTable._mth141D(new ASN1ObjectIdentifier(s));
        }
        // Misplaced declaration of an exception variable
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("unknown curve name: ")).append(s).toString());
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        throw new InvalidAlgorithmParameterException((new StringBuilder("unknown curve OID: ")).append(s).toString());
        IllegalArgumentException illegalargumentexception;
        org.spongycastle.math.ec.ECCurve eccurve = ((X9ECParameters) (obj)).alm;
        org.spongycastle.math.ec.ECPoint ecpoint = ((X9ECParameters) (obj)).alq;
        BigInteger biginteger = ((X9ECParameters) (obj)).alr;
        if (((X9ECParameters) (obj)).als == null)
        {
            obj = X9ECParameters.ONE;
        } else
        {
            obj = ((X9ECParameters) (obj)).als;
        }
        return new ECNamedCurveSpec(s, eccurve, ecpoint, biginteger, ((BigInteger) (obj)), null);
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            initialize(amD, new SecureRandom());
        }
        Object obj = aDu._mth1491();
        Object obj1 = (ECPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        if (aDg instanceof org.spongycastle.jce.spec.ECParameterSpec)
        {
            org.spongycastle.jce.spec.ECParameterSpec ecparameterspec = (org.spongycastle.jce.spec.ECParameterSpec)aDg;
            obj1 = new BCECPublicKey(aDc, ((ECPublicKeyParameters) (obj1)), ecparameterspec, aDm);
            return new KeyPair(((java.security.PublicKey) (obj1)), new BCECPrivateKey(aDc, ((ECPrivateKeyParameters) (obj)), ((BCECPublicKey) (obj1)), ecparameterspec, aDm));
        }
        if (aDg == null)
        {
            return new KeyPair(new BCECPublicKey(aDc, ((ECPublicKeyParameters) (obj1)), aDm), new BCECPrivateKey(aDc, ((ECPrivateKeyParameters) (obj)), aDm));
        } else
        {
            ECParameterSpec ecparameterspec1 = (ECParameterSpec)aDg;
            obj1 = new BCECPublicKey(aDc, ((ECPublicKeyParameters) (obj1)), ecparameterspec1, aDm);
            return new KeyPair(((java.security.PublicKey) (obj1)), new BCECPrivateKey(aDc, ((ECPrivateKeyParameters) (obj)), ((BCECPublicKey) (obj1)), ecparameterspec1, aDm));
        }
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
        ECGenParameterSpec ecgenparameterspec = (ECGenParameterSpec)aDv.get(Integers.valueOf(i));
        if (ecgenparameterspec == null)
        {
            throw new InvalidParameterException("unknown key size.");
        }
        try
        {
            initialize(((AlgorithmParameterSpec) (ecgenparameterspec)), securerandom);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SecureRandom securerandom)
        {
            throw new InvalidParameterException("key size not configurable.");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec == null)
        {
            algorithmparameterspec = aDm._mth1623();
            if (algorithmparameterspec == null)
            {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            aDg = null;
            aDi = new ECKeyGenerationParameters(new ECDomainParameters(((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).alm, ((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).axi, ((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).alr), securerandom);
        } else
        if (algorithmparameterspec instanceof org.spongycastle.jce.spec.ECParameterSpec)
        {
            aDg = algorithmparameterspec;
            algorithmparameterspec = (org.spongycastle.jce.spec.ECParameterSpec)algorithmparameterspec;
            aDi = new ECKeyGenerationParameters(new ECDomainParameters(((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).alm, ((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).axi, ((org.spongycastle.jce.spec.ECParameterSpec) (algorithmparameterspec)).alr), securerandom);
        } else
        if (algorithmparameterspec instanceof ECParameterSpec)
        {
            aDg = algorithmparameterspec;
            aDi = _mth02CA((ECParameterSpec)algorithmparameterspec, securerandom);
        } else
        if (algorithmparameterspec instanceof ECGenParameterSpec)
        {
            algorithmparameterspec = _mth1551(((ECGenParameterSpec)algorithmparameterspec).getName());
            aDg = algorithmparameterspec;
            aDi = _mth02CA(algorithmparameterspec, securerandom);
        } else
        if (algorithmparameterspec instanceof ECNamedCurveGenParameterSpec)
        {
            algorithmparameterspec = (ECNamedCurveGenParameterSpec)algorithmparameterspec;
            algorithmparameterspec = _mth1551(null);
            aDg = algorithmparameterspec;
            aDi = _mth02CA(algorithmparameterspec, securerandom);
        } else
        {
            throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
        }
        aDu._mth02CA(aDi);
        aqH = true;
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        aDv = hashtable;
        hashtable.put(Integers.valueOf(192), new ECGenParameterSpec("prime192v1"));
        aDv.put(Integers.valueOf(239), new ECGenParameterSpec("prime239v1"));
        aDv.put(Integers.valueOf(256), new ECGenParameterSpec("prime256v1"));
        aDv.put(Integers.valueOf(224), new ECGenParameterSpec("P-224"));
        aDv.put(Integers.valueOf(384), new ECGenParameterSpec("P-384"));
        aDv.put(Integers.valueOf(521), new ECGenParameterSpec("P-521"));
    }

    public ()
    {
        super("EC");
        aDu = new ECKeyPairGenerator();
        aDg = null;
        amD = 239;
        atV = 50;
        amC = new SecureRandom();
        aqH = false;
        aDc = "EC";
        aDm = BouncyCastleProvider.aGZ;
    }

    public aDm(String s, ProviderConfiguration providerconfiguration)
    {
        super(s);
        aDu = new ECKeyPairGenerator();
        aDg = null;
        amD = 239;
        atV = 50;
        amC = new SecureRandom();
        aqH = false;
        aDc = s;
        aDm = providerconfiguration;
    }
}
