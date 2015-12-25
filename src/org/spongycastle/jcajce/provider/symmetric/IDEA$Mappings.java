// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            IDEA

public static class der extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/IDEA.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameterGenerator.IDEA", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("AlgorithmParameters.IDEA", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Cipher.IDEA", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("Cipher.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAANDIDEA-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndIDEA").toString());
        configurableprovider._mth0640("KeyGenerator.IDEA", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("KeyGenerator.1.3.6.1.4.1.188.7.1.1.2", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndIDEAKeyGen").toString());
        configurableprovider._mth0640("Mac.IDEAMAC", (new StringBuilder()).append(PREFIX).append("$Mac").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.IDEA", "IDEAMAC");
        configurableprovider._mth0640("Mac.IDEAMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$CFB8Mac").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
    }


    public der()
    {
    }
}
