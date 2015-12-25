// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            DESede

public static class r extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/DESede.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.DESEDE", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(PKCSObjectIdentifiers.abw).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("Cipher.DESEDEWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(PKCSObjectIdentifiers.acU).toString(), (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640("Cipher.DESEDERFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211").toString());
        configurableprovider._mth0640("Alg.Alias.Cipher.TDEA", "DESEDE");
        configurableprovider._mth0640("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
        configurableprovider._mth0640("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
        if (configurableprovider._mth1427("MessageDigest", "SHA-1"))
        {
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES3Key").toString());
            configurableprovider._mth0640("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$BrokePBEWithSHAAndDES3Key").toString());
            configurableprovider._mth0640("Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$OldPBEWithSHAAndDES3Key").toString());
            configurableprovider._mth0640("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES2Key").toString());
            configurableprovider._mth0640("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$BrokePBEWithSHAAndDES2Key").toString());
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acQ).toString(), "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acR).toString(), "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        }
        configurableprovider._mth0640("KeyGenerator.DESEDE", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(PKCSObjectIdentifiers.abw).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGenerator3").toString());
        configurableprovider._mth0640("KeyGenerator.DESEDEWRAP", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        configurableprovider._mth0640("SecretKeyFactory.DESEDE", (new StringBuilder()).append(PREFIX).append("$KeyFactory").toString());
        configurableprovider._mth0640("Mac.DESEDECMAC", (new StringBuilder()).append(PREFIX).append("$CMAC").toString());
        configurableprovider._mth0640("Mac.DESEDEMAC", (new StringBuilder()).append(PREFIX).append("$CBCMAC").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
        configurableprovider._mth0640("Mac.DESEDEMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$DESedeCFB8").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
        configurableprovider._mth0640("Mac.DESEDEMAC64", (new StringBuilder()).append(PREFIX).append("$DESede64").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
        configurableprovider._mth0640("Mac.DESEDEMAC64WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DESede64with7816d4").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("AlgorithmParameters.DESEDE", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(PKCSObjectIdentifiers.abw).toString(), "DESEDE");
        configurableprovider._mth0640("AlgorithmParameterGenerator.DESEDE", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(PKCSObjectIdentifiers.abw).toString(), "DESEDE");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES3KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAndDES2KeyFactory").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
    }


    public r()
    {
    }
}
