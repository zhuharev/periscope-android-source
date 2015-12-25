// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

class X509SignatureUtil
{

    private static final DERNull aET;

    X509SignatureUtil()
    {
    }

    private static String _mth02BF(ASN1ObjectIdentifier asn1objectidentifier)
    {
        if (PKCSObjectIdentifiers.abC.equals(asn1objectidentifier))
        {
            return "MD5";
        }
        if (OIWObjectIdentifiers.aav.equals(asn1objectidentifier))
        {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.ZG.equals(asn1objectidentifier))
        {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.ZD.equals(asn1objectidentifier))
        {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.ZE.equals(asn1objectidentifier))
        {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.ZF.equals(asn1objectidentifier))
        {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.afk.equals(asn1objectidentifier))
        {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.afj.equals(asn1objectidentifier))
        {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.afl.equals(asn1objectidentifier))
        {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.XO.equals(asn1objectidentifier))
        {
            return "GOST3411";
        } else
        {
            return asn1objectidentifier.identifier;
        }
    }

    static String _mth02CA(AlgorithmIdentifier algorithmidentifier)
    {
        ASN1Encodable asn1encodable = algorithmidentifier.ahQ;
        if (asn1encodable != null && !aET.equals(asn1encodable))
        {
            if ((new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier)).equals(PKCSObjectIdentifiers.abf))
            {
                algorithmidentifier = RSASSAPSSparams._mth1D57(asn1encodable);
                return (new StringBuilder()).append(_mth02BF(new ASN1ObjectIdentifier(((RSASSAPSSparams) (algorithmidentifier)).adb.ahP.identifier))).append("withRSAandMGF1").toString();
            }
            if ((new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier)).equals(X9ObjectIdentifiers.alI))
            {
                algorithmidentifier = ASN1Sequence._mth141F(asn1encodable);
                return (new StringBuilder()).append(_mth02BF(ASN1ObjectIdentifier._mth02CE(algorithmidentifier._mth144B(0)))).append("withECDSA").toString();
            }
        }
        return (new ASN1ObjectIdentifier(algorithmidentifier.ahP.identifier)).identifier;
    }

    static void _mth02CA(Signature signature, ASN1Encodable asn1encodable)
    {
        if (asn1encodable != null && !aET.equals(asn1encodable))
        {
            AlgorithmParameters algorithmparameters = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try
            {
                algorithmparameters.init(asn1encodable._mth0427().getEncoded());
            }
            // Misplaced declaration of an exception variable
            catch (Signature signature)
            {
                throw new SignatureException((new StringBuilder("IOException decoding parameters: ")).append(signature.getMessage()).toString());
            }
            if (signature.getAlgorithm().endsWith("MGF1"))
            {
                try
                {
                    signature.setParameter(algorithmparameters.getParameterSpec(java/security/spec/PSSParameterSpec));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Signature signature)
                {
                    throw new SignatureException((new StringBuilder("Exception extracting parameters: ")).append(signature.getMessage()).toString());
                }
            }
        }
    }

    static 
    {
        aET = DERNull.WL;
    }
}
