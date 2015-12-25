// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.GOST3410KeyPairGenerator;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.gost:
//            BCGOST3410PublicKey, BCGOST3410PrivateKey

public class KeyPairGeneratorSpi extends KeyPairGenerator
{

    private GOST3410KeyPairGenerator aDH;
    private GOST3410ParameterSpec aDI;
    private SecureRandom amC;
    private int amD;
    private boolean aqH;
    private GOST3410KeyGenerationParameters auf;

    public KeyPairGeneratorSpi()
    {
        super("GOST3410");
        aDH = new GOST3410KeyPairGenerator();
        amD = 1024;
        amC = null;
        aqH = false;
    }

    private void _mth02CA(GOST3410ParameterSpec gost3410parameterspec, SecureRandom securerandom)
    {
        GOST3410PublicKeyParameterSetSpec gost3410publickeyparametersetspec = gost3410parameterspec.aIk;
        auf = new GOST3410KeyGenerationParameters(securerandom, new GOST3410Parameters(gost3410publickeyparametersetspec.amM, gost3410publickeyparametersetspec.amN, gost3410publickeyparametersetspec.amW));
        aDH.auf = (GOST3410KeyGenerationParameters)auf;
        aqH = true;
        aDI = gost3410parameterspec;
    }

    public KeyPair generateKeyPair()
    {
        if (!aqH)
        {
            _mth02CA(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.Ya.identifier), new SecureRandom());
        }
        Object obj = aDH._mth1491();
        GOST3410PublicKeyParameters gost3410publickeyparameters = (GOST3410PublicKeyParameters)((AsymmetricCipherKeyPair) (obj)).amu;
        obj = (GOST3410PrivateKeyParameters)((AsymmetricCipherKeyPair) (obj)).amv;
        return new KeyPair(new BCGOST3410PublicKey(gost3410publickeyparameters, aDI), new BCGOST3410PrivateKey(((GOST3410PrivateKeyParameters) (obj)), aDI));
    }

    public void initialize(int i, SecureRandom securerandom)
    {
        amD = i;
        amC = securerandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(algorithmparameterspec instanceof GOST3410ParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
        } else
        {
            _mth02CA((GOST3410ParameterSpec)algorithmparameterspec, securerandom);
            return;
        }
    }
}
