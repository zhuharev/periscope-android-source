// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

public class DSAUtil
{

    public static final ASN1ObjectIdentifier aDa[];

    public DSAUtil()
    {
    }

    public static boolean _mth02BD(ASN1ObjectIdentifier asn1objectidentifier)
    {
        for (int i = 0; i != 2; i++)
        {
            if (asn1objectidentifier.equals(aDa[i]))
            {
                return true;
            }
        }

        return false;
    }

    public static DSAPrivateKeyParameters _mth02CA(PrivateKey privatekey)
    {
        if (privatekey instanceof DSAPrivateKey)
        {
            privatekey = (DSAPrivateKey)privatekey;
            return new DSAPrivateKeyParameters(privatekey.getX(), new DSAParameters(privatekey.getParams().getP(), privatekey.getParams().getQ(), privatekey.getParams().getG()));
        } else
        {
            throw new InvalidKeyException("can't identify DSA private key.");
        }
    }

    public static DSAPublicKeyParameters _mth02CA(PublicKey publickey)
    {
        if (publickey instanceof DSAPublicKey)
        {
            publickey = (DSAPublicKey)publickey;
            return new DSAPublicKeyParameters(publickey.getY(), new DSAParameters(publickey.getParams().getP(), publickey.getParams().getQ(), publickey.getParams().getG()));
        } else
        {
            throw new InvalidKeyException((new StringBuilder("can't identify DSA public key: ")).append(publickey.getClass().getName()).toString());
        }
    }

    static 
    {
        aDa = (new ASN1ObjectIdentifier[] {
            X9ObjectIdentifiers.amm, OIWObjectIdentifiers.aaw
        });
    }
}
