// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.util:
//            EC5Util

public class ECUtil
{

    public ECUtil()
    {
    }

    static int[] _mth02BB(int ai[])
    {
        int ai1[] = new int[3];
        if (ai.length == 1)
        {
            ai1[0] = ai[0];
            return ai1;
        }
        if (ai.length != 3)
        {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        }
        if (ai[0] < ai[1] && ai[0] < ai[2])
        {
            ai1[0] = ai[0];
            if (ai[1] < ai[2])
            {
                ai1[1] = ai[1];
                ai1[2] = ai[2];
                return ai1;
            } else
            {
                ai1[1] = ai[2];
                ai1[2] = ai[1];
                return ai1;
            }
        }
        if (ai[1] < ai[2])
        {
            ai1[0] = ai[1];
            if (ai[0] < ai[2])
            {
                ai1[1] = ai[0];
                ai1[2] = ai[2];
                return ai1;
            } else
            {
                ai1[1] = ai[2];
                ai1[2] = ai[0];
                return ai1;
            }
        }
        ai1[0] = ai[2];
        if (ai[0] < ai[1])
        {
            ai1[1] = ai[0];
            ai1[2] = ai[1];
            return ai1;
        } else
        {
            ai1[1] = ai[1];
            ai1[2] = ai[0];
            return ai1;
        }
    }

    public static String _mth02BE(ASN1ObjectIdentifier asn1objectidentifier)
    {
        String s1 = X962NamedCurves._mth02CE(asn1objectidentifier);
        String s = s1;
        if (s1 == null)
        {
            String s2 = SECNamedCurves._mth02CE(asn1objectidentifier);
            s = s2;
            if (s2 == null)
            {
                s = NISTNamedCurves._mth02CE(asn1objectidentifier);
            }
            s2 = s;
            if (s == null)
            {
                s2 = TeleTrusTNamedCurves._mth02CE(asn1objectidentifier);
            }
            s = s2;
            if (s2 == null)
            {
                s = ECGOST3410NamedCurves._mth02CE(asn1objectidentifier);
            }
        }
        return s;
    }

    public static AsymmetricKeyParameter _mth02CF(PrivateKey privatekey)
    {
        if (privatekey instanceof ECPrivateKey)
        {
            ECPrivateKey ecprivatekey = (ECPrivateKey)privatekey;
            ECParameterSpec ecparameterspec = ecprivatekey._mth15A7();
            privatekey = ecparameterspec;
            if (ecparameterspec == null)
            {
                privatekey = BouncyCastleProvider.aGZ._mth1623();
            }
            return new ECPrivateKeyParameters(ecprivatekey._mth15A8(), new ECDomainParameters(((ECParameterSpec) (privatekey)).alm, ((ECParameterSpec) (privatekey)).axi, ((ECParameterSpec) (privatekey)).alr, ((ECParameterSpec) (privatekey)).als, ((ECParameterSpec) (privatekey)).aln));
        }
        if (privatekey instanceof java.security.interfaces.ECPrivateKey)
        {
            privatekey = (java.security.interfaces.ECPrivateKey)privatekey;
            ECParameterSpec ecparameterspec1 = EC5Util._mth02CA(privatekey.getParams(), false);
            return new ECPrivateKeyParameters(privatekey.getS(), new ECDomainParameters(ecparameterspec1.alm, ecparameterspec1.axi, ecparameterspec1.alr, ecparameterspec1.als, ecparameterspec1.aln));
        }
        try
        {
            privatekey = privatekey.getEncoded();
        }
        // Misplaced declaration of an exception variable
        catch (PrivateKey privatekey)
        {
            throw new InvalidKeyException((new StringBuilder("cannot identify EC private key: ")).append(privatekey.toString()).toString());
        }
        if (privatekey != null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        throw new InvalidKeyException("no encoding for EC private key");
        privatekey = BouncyCastleProvider._mth02CF(PrivateKeyInfo._mth1D38(privatekey));
        if (!(privatekey instanceof java.security.interfaces.ECPrivateKey))
        {
            break MISSING_BLOCK_LABEL_213;
        }
        privatekey = _mth02CF(privatekey);
        return privatekey;
        throw new InvalidKeyException("can't identify EC private key.");
    }

    public static AsymmetricKeyParameter _mth02CF(PublicKey publickey)
    {
        if (publickey instanceof ECPublicKey)
        {
            publickey = (ECPublicKey)publickey;
            ECParameterSpec ecparameterspec = publickey._mth15A7();
            if (ecparameterspec == null)
            {
                ecparameterspec = BouncyCastleProvider.aGZ._mth1623();
                return new ECPublicKeyParameters(((BCECPublicKey)publickey).ayu, new ECDomainParameters(ecparameterspec.alm, ecparameterspec.axi, ecparameterspec.alr, ecparameterspec.als, ecparameterspec.aln));
            } else
            {
                return new ECPublicKeyParameters(publickey._mth15AA(), new ECDomainParameters(ecparameterspec.alm, ecparameterspec.axi, ecparameterspec.alr, ecparameterspec.als, ecparameterspec.aln));
            }
        }
        if (publickey instanceof java.security.interfaces.ECPublicKey)
        {
            publickey = (java.security.interfaces.ECPublicKey)publickey;
            ECParameterSpec ecparameterspec1 = EC5Util._mth02CA(publickey.getParams(), false);
            return new ECPublicKeyParameters(EC5Util._mth02CA(publickey.getParams(), publickey.getW(), false), new ECDomainParameters(ecparameterspec1.alm, ecparameterspec1.axi, ecparameterspec1.alr, ecparameterspec1.als, ecparameterspec1.aln));
        }
        try
        {
            publickey = publickey.getEncoded();
        }
        // Misplaced declaration of an exception variable
        catch (PublicKey publickey)
        {
            throw new InvalidKeyException((new StringBuilder("cannot identify EC public key: ")).append(publickey.toString()).toString());
        }
        if (publickey != null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        throw new InvalidKeyException("no encoding for EC public key");
        publickey = BouncyCastleProvider._mth141D(SubjectPublicKeyInfo._mth13A5(publickey));
        if (!(publickey instanceof java.security.interfaces.ECPublicKey))
        {
            break MISSING_BLOCK_LABEL_263;
        }
        publickey = _mth02CF(publickey);
        return publickey;
        throw new InvalidKeyException("cannot identify EC public key.");
    }

    public static ASN1ObjectIdentifier _mth157D(String s)
    {
        ASN1ObjectIdentifier asn1objectidentifier1 = X962NamedCurves._mth1422(s);
        ASN1ObjectIdentifier asn1objectidentifier = asn1objectidentifier1;
        if (asn1objectidentifier1 == null)
        {
            ASN1ObjectIdentifier asn1objectidentifier2 = SECNamedCurves._mth1422(s);
            asn1objectidentifier = asn1objectidentifier2;
            if (asn1objectidentifier2 == null)
            {
                asn1objectidentifier = NISTNamedCurves._mth1422(s);
            }
            asn1objectidentifier2 = asn1objectidentifier;
            if (asn1objectidentifier == null)
            {
                asn1objectidentifier2 = TeleTrusTNamedCurves._mth1422(s);
            }
            asn1objectidentifier = asn1objectidentifier2;
            if (asn1objectidentifier2 == null)
            {
                asn1objectidentifier = ECGOST3410NamedCurves._mth1422(s);
            }
        }
        return asn1objectidentifier;
    }

    public static X9ECParameters _mth1FBE(ASN1ObjectIdentifier asn1objectidentifier)
    {
        X9ECParameters x9ecparameters1 = CustomNamedCurves._mth141D(asn1objectidentifier);
        X9ECParameters x9ecparameters = x9ecparameters1;
        if (x9ecparameters1 == null)
        {
            X9ECParameters x9ecparameters2 = X962NamedCurves._mth141D(asn1objectidentifier);
            x9ecparameters = x9ecparameters2;
            if (x9ecparameters2 == null)
            {
                x9ecparameters = SECNamedCurves._mth141D(asn1objectidentifier);
            }
            x9ecparameters2 = x9ecparameters;
            if (x9ecparameters == null)
            {
                x9ecparameters2 = NISTNamedCurves._mth141D(asn1objectidentifier);
            }
            x9ecparameters = x9ecparameters2;
            if (x9ecparameters2 == null)
            {
                x9ecparameters = TeleTrusTNamedCurves._mth141D(asn1objectidentifier);
            }
        }
        return x9ecparameters;
    }
}
