// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider, Twofish

public static class  extends SymmetricAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/Twofish.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.Twofish", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("KeyGenerator.Twofish", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("AlgorithmParameters.Twofish", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Cipher.PBEWITHSHAANDTWOFISH-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAKeyFactory").toString());
        _mth02CB(configurableprovider, "Twofish", (new StringBuilder()).append(PREFIX).append("$GMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        _mth02CE(configurableprovider, "Twofish", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
    }


    public ()
    {
    }
}
