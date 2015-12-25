// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            DES

public static class ider extends AlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/DES.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("Cipher.DES", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(OIWObjectIdentifiers.aau).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        ASN1ObjectIdentifier asn1objectidentifier = OIWObjectIdentifiers.aau;
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyGenerator.")).append(asn1objectidentifier.identifier).toString(), "DES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.KeyFactory.")).append(asn1objectidentifier.identifier).toString(), "DES");
        configurableprovider._mth0640("Cipher.DESRFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211").toString());
        configurableprovider._mth0640("KeyGenerator.DES", (new StringBuilder()).append(PREFIX).append("$KeyGenerator").toString());
        configurableprovider._mth0640("SecretKeyFactory.DES", (new StringBuilder()).append(PREFIX).append("$KeyFactory").toString());
        configurableprovider._mth0640("Mac.DESCMAC", (new StringBuilder()).append(PREFIX).append("$CMAC").toString());
        configurableprovider._mth0640("Mac.DESMAC", (new StringBuilder()).append(PREFIX).append("$CBCMAC").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DES", "DESMAC");
        configurableprovider._mth0640("Mac.DESMAC/CFB8", (new StringBuilder()).append(PREFIX).append("$DESCFB8").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
        configurableprovider._mth0640("Mac.DESMAC64", (new StringBuilder()).append(PREFIX).append("$DES64").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DES64", "DESMAC64");
        configurableprovider._mth0640("Mac.DESMAC64WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DES64with7816d4").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
        configurableprovider._mth0640("Mac.DESWITHISO9797", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
        configurableprovider._mth0640("Mac.ISO9797ALG3MAC", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
        configurableprovider._mth0640("Mac.ISO9797ALG3WITHISO7816-4PADDING", (new StringBuilder()).append(PREFIX).append("$DES9797Alg3with7816d4").toString());
        configurableprovider._mth0640("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
        configurableprovider._mth0640("AlgorithmParameters.DES", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(OIWObjectIdentifiers.aau).toString(), "DES");
        configurableprovider._mth0640("AlgorithmParameterGenerator.DES", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(OIWObjectIdentifiers.aau).toString(), "DES");
        configurableprovider._mth0640("Cipher.PBEWITHMD2ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD2").toString());
        configurableprovider._mth0640("Cipher.PBEWITHMD5ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHA1ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abn).toString(), "PBEWITHMD2ANDDES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abp).toString(), "PBEWITHMD5ANDDES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(PKCSObjectIdentifiers.abr).toString(), "PBEWITHSHA1ANDDES");
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD2ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD2KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5KeyFactory").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA1ANDDES", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA1KeyFactory").toString());
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abn).toString(), "PBEWITHMD2ANDDES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abp).toString(), "PBEWITHMD5ANDDES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(PKCSObjectIdentifiers.abr).toString(), "PBEWITHSHA1ANDDES");
    }


    public ider()
    {
    }
}
