// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
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
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ecgost:
//            BCECGOST3410PublicKey, BCECGOST3410PrivateKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private String aDc;
    private AlgorithmParameterSpec aDg;
    private ECKeyGenerationParameters aDi;
    private ECKeyPairGenerator aDu;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;

    public KeyPairGeneratorSpi()
    {
        super("ECGOST3410");
        aDg = null;
        aDu = new ECKeyPairGenerator();
        aDc = "ECGOST3410";
        amD = 239;
        amC = null;
        aqH = false;
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
        Object obj = aDu._mth1491();
        Object obj1 = (ECPublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        if (aDg instanceof ECParameterSpec)
        {
            ECParameterSpec ecparameterspec = (ECParameterSpec)aDg;
            obj1 = new BCECGOST3410PublicKey(aDc, ((ECPublicKeyParameters) (obj1)), ecparameterspec);
            return new KeyPair(((java.security.PublicKey) (obj1)), new BCECGOST3410PrivateKey(aDc, ((ECPrivateKeyParameters) (obj)), ((BCECGOST3410PublicKey) (obj1)), ecparameterspec));
        }
        if (aDg == null)
        {
            return new KeyPair(new BCECGOST3410PublicKey(aDc, ((ECPublicKeyParameters) (obj1))), new BCECGOST3410PrivateKey(aDc, ((ECPrivateKeyParameters) (obj))));
        } else
        {
            java.security.spec.ECParameterSpec ecparameterspec1 = (java.security.spec.ECParameterSpec)aDg;
            obj1 = new BCECGOST3410PublicKey(aDc, ((ECPublicKeyParameters) (obj1)), ecparameterspec1);
            return new KeyPair(((java.security.PublicKey) (obj1)), new BCECGOST3410PrivateKey(aDc, ((ECPrivateKeyParameters) (obj)), ((BCECGOST3410PublicKey) (obj1)), ecparameterspec1));
        }
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
        if (aDg != null)
        {
            try
            {
                initialize(((AlgorithmParameterSpec) ((ECGenParameterSpec)aDg)), securerandom);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SecureRandom securerandom)
            {
                throw new InvalidParameterException("key size not configurable.");
            }
        } else
        {
            throw new InvalidParameterException("unknown key size.");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (algorithmparameterspec instanceof ECParameterSpec)
        {
            ECParameterSpec ecparameterspec = (ECParameterSpec)algorithmparameterspec;
            aDg = algorithmparameterspec;
            aDi = new ECKeyGenerationParameters(new ECDomainParameters(ecparameterspec.alm, ecparameterspec.axi, ecparameterspec.alr), securerandom);
            aDu._mth02CA(aDi);
            aqH = true;
            return;
        }
        if (algorithmparameterspec instanceof java.security.spec.ECParameterSpec)
        {
            java.security.spec.ECParameterSpec ecparameterspec1 = (java.security.spec.ECParameterSpec)algorithmparameterspec;
            aDg = algorithmparameterspec;
            algorithmparameterspec = EC5Util._mth02CA(ecparameterspec1.getCurve());
            aDi = new ECKeyGenerationParameters(new ECDomainParameters(algorithmparameterspec, EC5Util._mth02CA(algorithmparameterspec, ecparameterspec1.getGenerator(), false), ecparameterspec1.getOrder(), BigInteger.valueOf(ecparameterspec1.getCofactor())), securerandom);
            aDu._mth02CA(aDi);
            aqH = true;
            return;
        }
        if ((algorithmparameterspec instanceof ECGenParameterSpec) || (algorithmparameterspec instanceof ECNamedCurveGenParameterSpec))
        {
            if (algorithmparameterspec instanceof ECGenParameterSpec)
            {
                algorithmparameterspec = ((ECGenParameterSpec)algorithmparameterspec).getName();
            } else
            {
                algorithmparameterspec = (ECNamedCurveGenParameterSpec)algorithmparameterspec;
                algorithmparameterspec = null;
            }
            Object obj = ECGOST3410NamedCurves._mth09F2(algorithmparameterspec);
            if (obj == null)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("unknown curve name: ")).append(algorithmparameterspec).toString());
            } else
            {
                aDg = new ECNamedCurveSpec(algorithmparameterspec, ((ECDomainParameters) (obj)).alm, ((ECDomainParameters) (obj)).axi, ((ECDomainParameters) (obj)).alr, ((ECDomainParameters) (obj)).als, Arrays._mth1D4C(((ECDomainParameters) (obj)).aln));
                algorithmparameterspec = (java.security.spec.ECParameterSpec)aDg;
                obj = EC5Util._mth02CA(algorithmparameterspec.getCurve());
                aDi = new ECKeyGenerationParameters(new ECDomainParameters(((org.spongycastle.math.ec.ECCurve) (obj)), EC5Util._mth02CA(((org.spongycastle.math.ec.ECCurve) (obj)), algorithmparameterspec.getGenerator(), false), algorithmparameterspec.getOrder(), BigInteger.valueOf(algorithmparameterspec.getCofactor())), securerandom);
                aDu._mth02CA(aDi);
                aqH = true;
                return;
            }
        }
        if (algorithmparameterspec == null && BouncyCastleProvider.aGZ._mth1623() != null)
        {
            ECParameterSpec ecparameterspec2 = BouncyCastleProvider.aGZ._mth1623();
            aDg = algorithmparameterspec;
            aDi = new ECKeyGenerationParameters(new ECDomainParameters(ecparameterspec2.alm, ecparameterspec2.axi, ecparameterspec2.alr), securerandom);
            aDu._mth02CA(aDi);
            aqH = true;
            return;
        }
        if (algorithmparameterspec == null && BouncyCastleProvider.aGZ._mth1623() == null)
        {
            throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
        } else
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("parameter object not a ECParameterSpec: ")).append(algorithmparameterspec.getClass().getName()).toString());
        }
    }
}
