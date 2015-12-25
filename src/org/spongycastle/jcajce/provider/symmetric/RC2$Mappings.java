// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            RC2

public static class ider extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/RC2.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameterGenerator.RC2", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("AlgorithmParameterGenerator.1.2.840.113549.3.2", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("KeyGenerator.RC2", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        configurableprovider._mth0640("KeyGenerator.1.2.840.113549.3.2", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        configurableprovider._mth0640("AlgorithmParameters.RC2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("AlgorithmParameters.1.2.840.113549.3.2", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("Cipher.RC2", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("Cipher.RC2WRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.acV).toString(), "RC2WRAP");
        configurableprovider._mth0640("Cipher.1.2.840.113549.3.2", (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640("Mac.RC2MAC", (new StringBuilder()).append(PREFIX).append("$CBCMAC").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.RC2", "RC2MAC");
        configurableprovider._mth0640("Mac.RC2MAC/CFB8", (new StringBuilder()).append(PREFIX).append("$CFB8MAC").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.RC2/CFB8", "RC2MAC/CFB8");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDRC2-CBC", "PBEWITHMD2ANDRC2");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abo).toString(), "PBEWITHMD2ANDRC2");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abq).toString(), "PBEWITHMD5ANDRC2");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abs).toString(), "PBEWITHSHA1ANDRC2");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD2ANDRC2", (new StringBuilder()).append(PREFIX).append("$PBEWithMD2KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5ANDRC2", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA1ANDRC2", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitKeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40BitKeyFactory").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abo).toString(), "PBEWITHMD2ANDRC2");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abq).toString(), "PBEWITHMD5ANDRC2");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abs).toString(), "PBEWITHSHA1ANDRC2");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.Cipher.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        configurableprovider._mth0640("Alg.Alias.Cipher.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
        configurableprovider._mth0640("Cipher.PBEWITHSHA1ANDRC2", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1AndRC2").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND128BITRC2-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitRC2").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND40BITRC2-CBC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd40BitRC2").toString());
        configurableprovider._mth0640("Cipher.PBEWITHMD5ANDRC2", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5AndRC2").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
    }


    public ider()
    {
    }
}
