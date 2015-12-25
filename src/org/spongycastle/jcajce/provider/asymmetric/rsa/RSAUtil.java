// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSAUtil
{

    private static ASN1ObjectIdentifier aEm[];

    public RSAUtil()
    {
    }

    static RSAKeyParameters _mth02CA(RSAPrivateKey rsaprivatekey)
    {
        if (rsaprivatekey instanceof RSAPrivateCrtKey)
        {
            rsaprivatekey = (RSAPrivateCrtKey)rsaprivatekey;
            return new RSAPrivateCrtKeyParameters(rsaprivatekey.getModulus(), rsaprivatekey.getPublicExponent(), rsaprivatekey.getPrivateExponent(), rsaprivatekey.getPrimeP(), rsaprivatekey.getPrimeQ(), rsaprivatekey.getPrimeExponentP(), rsaprivatekey.getPrimeExponentQ(), rsaprivatekey.getCrtCoefficient());
        } else
        {
            return new RSAKeyParameters(true, rsaprivatekey.getModulus(), rsaprivatekey.getPrivateExponent());
        }
    }

    static RSAKeyParameters _mth02CA(RSAPublicKey rsapublickey)
    {
        return new RSAKeyParameters(false, rsapublickey.getModulus(), rsapublickey.getPublicExponent());
    }

    public static boolean _mth037A(ASN1ObjectIdentifier asn1objectidentifier)
    {
        for (int i = 0; i != 4; i++)
        {
            if (asn1objectidentifier.equals(aEm[i]))
            {
                return true;
            }
        }

        return false;
    }

    static 
    {
        aEm = (new ASN1ObjectIdentifier[] {
            PKCSObjectIdentifiers.aaX, X509ObjectIdentifiers.akE, PKCSObjectIdentifiers.abc, PKCSObjectIdentifiers.abf
        });
    }
}
