// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider, Camellia

public static class Provider extends SymmetricAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Camellia.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aah).toString(), "CAMELLIA");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aai).toString(), "CAMELLIA");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NTTObjectIdentifiers.aaj).toString(), "CAMELLIA");
        configurableprovider._mth0640("AlgorithmParameterGenerator.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aah).toString(), "CAMELLIA");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aai).toString(), "CAMELLIA");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NTTObjectIdentifiers.aaj).toString(), "CAMELLIA");
        configurableprovider._mth0640("Cipher.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aah).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aai).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NTTObjectIdentifiers.aaj).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("Cipher.CAMELLIARFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211Wrap").toString());
        configurableprovider._mth0640("Cipher.CAMELLIAWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aak).toString(), "CAMELLIAWRAP");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aal).toString(), "CAMELLIAWRAP");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NTTObjectIdentifiers.aam).toString(), "CAMELLIAWRAP");
        configurableprovider._mth0640("KeyGenerator.CAMELLIA", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aak).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aal).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aam).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aah).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aai).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NTTObjectIdentifiers.aaj).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        _mth02CB(configurableprovider, "CAMELLIA", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CE(configurableprovider, "CAMELLIA", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
    }


    public Provider()
    {
    }
}
