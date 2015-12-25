// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            SymmetricAlgorithmProvider, AES

public static class ider extends SymmetricAlgorithmProvider
{

    private static final String PREFIX = org/spongycastle/jcajce/provider/symmetric/AES.getName();

    public final void _mth02CA(ConfigurableProvider configurableprovider)
    {
        configurableprovider._mth0640("AlgorithmParameters.AES", (new StringBuilder()).append(PREFIX).append("$AlgParams").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZL).toString(), "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZR).toString(), "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZX).toString(), "AES");
        configurableprovider._mth0640("AlgorithmParameters.GCM", (new StringBuilder()).append(PREFIX).append("$AlgParamsGCM").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZP).toString(), "GCM");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.ZV).toString(), "GCM");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(NISTObjectIdentifiers.aab).toString(), "GCM");
        configurableprovider._mth0640("AlgorithmParameterGenerator.AES", (new StringBuilder()).append(PREFIX).append("$AlgParamGen").toString());
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZL).toString(), "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZR).toString(), "AES");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameterGenerator.")).append(NISTObjectIdentifiers.ZX).toString(), "AES");
        configurableprovider._mth0640("Cipher.AES", (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
        configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
        configurableprovider._mth0640("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZK).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZQ).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZW).toString(), (new StringBuilder()).append(PREFIX).append("$ECB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZL).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZR).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZX).toString(), (new StringBuilder()).append(PREFIX).append("$CBC").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZM).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZS).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZY).toString(), (new StringBuilder()).append(PREFIX).append("$OFB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZN).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZT).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
        configurableprovider._mth0640((new StringBuilder("Cipher.")).append(NISTObjectIdentifiers.ZZ).toString(), (new StringBuilder()).append(PREFIX).append("$CFB").toString());
        configurableprovider._mth0640("Cipher.AESWRAP", (new StringBuilder()).append(PREFIX).append("$Wrap").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZO).toString(), "AESWRAP");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZU).toString(), "AESWRAP");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.aaa).toString(), "AESWRAP");
        configurableprovider._mth0640("Cipher.AESRFC3211WRAP", (new StringBuilder()).append(PREFIX).append("$RFC3211Wrap").toString());
        configurableprovider._mth0640("Cipher.AESRFC5649WRAP", (new StringBuilder()).append(PREFIX).append("$RFC5649Wrap").toString());
        configurableprovider._mth0640("Cipher.GCM", (new StringBuilder()).append(PREFIX).append("$GCM").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZP).toString(), "GCM");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.ZV).toString(), "GCM");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(NISTObjectIdentifiers.aab).toString(), "GCM");
        configurableprovider._mth0640("KeyGenerator.AES", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.2", (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.22", (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640("KeyGenerator.2.16.840.1.101.3.4.42", (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZK).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZL).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZM).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZN).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZQ).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZR).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZS).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZT).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZW).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZX).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZY).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZZ).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640("KeyGenerator.AESWRAP", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZO).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.ZU).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen192").toString());
        configurableprovider._mth0640((new StringBuilder("KeyGenerator.")).append(NISTObjectIdentifiers.aaa).toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen256").toString());
        configurableprovider._mth0640("Mac.AESCMAC", (new StringBuilder()).append(PREFIX).append("$AESCMAC").toString());
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.Cipher.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
        configurableprovider._mth0640("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithAESCBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And128BitAESCBCOpenSSL").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And192BitAESCBCOpenSSL").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", (new StringBuilder()).append(PREFIX).append("$PBEWithMD5And256BitAESCBCOpenSSL").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd128BitAESBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd192BitAESBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHAAnd256BitAESBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And128BitAESBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And192BitAESBC").toString());
        configurableprovider._mth0640("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", (new StringBuilder()).append(PREFIX).append("$PBEWithSHA256And256BitAESBC").toString());
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PBEWITHSHAAND128BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PBEWITHSHAAND192BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PBEWITHSHAAND256BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.SecretKeyFactory.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xi.identifier).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xj.identifier).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xk.identifier).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xl.identifier).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xm.identifier).toString(), "PKCS12PBE");
        configurableprovider._mth0640((new StringBuilder("Alg.Alias.AlgorithmParameters.")).append(BCObjectIdentifiers.Xn.identifier).toString(), "PKCS12PBE");
        _mth02CB(configurableprovider, "AES", (new StringBuilder()).append(PREFIX).append("$AESGMAC").toString(), (new StringBuilder()).append(PREFIX).append("$KeyGen128").toString());
        _mth02CE(configurableprovider, "AES", (new StringBuilder()).append(PREFIX).append("$Poly1305").toString(), (new StringBuilder()).append(PREFIX).append("$Poly1305KeyGen").toString());
    }


    public ider()
    {
    }
}
