// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.util;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.asn1.x9.DHDomainParameters;
import org.spongycastle.asn1.x9.DHPublicKey;
import org.spongycastle.asn1.x9.DHValidationParms;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.DHValidationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECNamedDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class PublicKeyFactory
{

    public PublicKeyFactory()
    {
    }

    public static AsymmetricKeyParameter _mth02CA(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        Object obj2 = subjectpublickeyinfo.aaK;
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(PKCSObjectIdentifiers.aaX) || (new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(X509ObjectIdentifiers.akE))
        {
            subjectpublickeyinfo = RSAPublicKey._mth02BC((new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7());
            return new RSAKeyParameters(false, ((RSAPublicKey) (subjectpublickeyinfo)).adi, ((RSAPublicKey) (subjectpublickeyinfo)).adj);
        }
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(X9ObjectIdentifiers.ams))
        {
            BigInteger biginteger = new BigInteger(DHPublicKey._mth02CD((new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7()).akK.bytes);
            Object obj4 = DHDomainParameters._mth02EE(((AlgorithmIdentifier) (obj2)).ahQ);
            obj2 = new BigInteger(((DHDomainParameters) (obj4)).Yq.bytes);
            BigInteger biginteger1 = new BigInteger(((DHDomainParameters) (obj4)).aat.bytes);
            BigInteger biginteger2 = new BigInteger(((DHDomainParameters) (obj4)).Yr.bytes);
            subjectpublickeyinfo = null;
            if (((DHDomainParameters) (obj4)).akI != null)
            {
                subjectpublickeyinfo = new BigInteger(((DHDomainParameters) (obj4)).akI.bytes);
            }
            DHValidationParameters dhvalidationparameters = null;
            obj4 = ((DHDomainParameters) (obj4)).akJ;
            if (obj4 != null)
            {
                dhvalidationparameters = new DHValidationParameters(((DHValidationParms) (obj4)).akL.getBytes(), (new BigInteger(((DHValidationParms) (obj4)).akM.bytes)).intValue());
            }
            return new DHPublicKeyParameters(biginteger, new DHParameters(((BigInteger) (obj2)), biginteger1, biginteger2, subjectpublickeyinfo, dhvalidationparameters));
        }
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(PKCSObjectIdentifiers.abl))
        {
            DHParameter dhparameter = DHParameter._mth15EE(((AlgorithmIdentifier) (obj2)).ahQ);
            ASN1Integer asn1integer1 = (ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7();
            if (dhparameter.aaI == null)
            {
                subjectpublickeyinfo = null;
            } else
            {
                subjectpublickeyinfo = new BigInteger(1, dhparameter.aaI.bytes);
            }
            int i;
            if (subjectpublickeyinfo == null)
            {
                i = 0;
            } else
            {
                i = subjectpublickeyinfo.intValue();
            }
            subjectpublickeyinfo = new DHParameters(new BigInteger(1, dhparameter.Yq.bytes), new BigInteger(1, dhparameter.aat.bytes), null, i);
            return new DHPublicKeyParameters(new BigInteger(asn1integer1.bytes), subjectpublickeyinfo);
        }
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(OIWObjectIdentifiers.aay))
        {
            ElGamalParameter elgamalparameter = ElGamalParameter._mth1FBE(((AlgorithmIdentifier) (obj2)).ahQ);
            return new ElGamalPublicKeyParameters(new BigInteger(((ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7()).bytes), new ElGamalParameters(new BigInteger(1, elgamalparameter.Yq.bytes), new BigInteger(1, elgamalparameter.aat.bytes)));
        }
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(X9ObjectIdentifiers.amm) || (new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(OIWObjectIdentifiers.aaw))
        {
            ASN1Integer asn1integer = (ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7();
            ASN1Encodable asn1encodable = ((AlgorithmIdentifier) (obj2)).ahQ;
            subjectpublickeyinfo = null;
            if (asn1encodable != null)
            {
                subjectpublickeyinfo = DSAParameter._mth1D62(asn1encodable._mth0427());
                subjectpublickeyinfo = new DSAParameters(new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).Yq.bytes), new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).Yr.bytes), new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).aat.bytes));
            }
            return new DSAPublicKeyParameters(new BigInteger(asn1integer.bytes), subjectpublickeyinfo);
        }
        if ((new ASN1ObjectIdentifier(((AlgorithmIdentifier) (obj2)).ahP.identifier)).equals(X9ObjectIdentifiers.alH))
        {
            Object obj = X962Parameters._mth06E5(((AlgorithmIdentifier) (obj2)).ahQ);
            Object obj1;
            if (((X962Parameters) (obj)).alk instanceof ASN1ObjectIdentifier)
            {
                ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)((X962Parameters) (obj)).alk;
                obj1 = CustomNamedCurves._mth141D(asn1objectidentifier);
                obj = obj1;
                if (obj1 == null)
                {
                    obj = ECNamedCurveTable._mth141D(asn1objectidentifier);
                }
                org.spongycastle.math.ec.ECCurve eccurve = ((X9ECParameters) (obj)).alm;
                org.spongycastle.math.ec.ECPoint ecpoint1 = ((X9ECParameters) (obj)).alq;
                BigInteger biginteger4 = ((X9ECParameters) (obj)).alr;
                if (((X9ECParameters) (obj)).als == null)
                {
                    obj1 = X9ECParameters.ONE;
                } else
                {
                    obj1 = ((X9ECParameters) (obj)).als;
                }
                obj1 = new ECNamedDomainParameters(asn1objectidentifier, eccurve, ecpoint1, biginteger4, ((BigInteger) (obj1)), ((X9ECParameters) (obj)).aln);
            } else
            {
                obj1 = X9ECParameters._mth0640(((X962Parameters) (obj)).alk);
                Object obj3 = ((X9ECParameters) (obj1)).alm;
                org.spongycastle.math.ec.ECPoint ecpoint = ((X9ECParameters) (obj1)).alq;
                BigInteger biginteger3 = ((X9ECParameters) (obj1)).alr;
                if (((X9ECParameters) (obj1)).als == null)
                {
                    obj = X9ECParameters.ONE;
                } else
                {
                    obj = ((X9ECParameters) (obj1)).als;
                }
                obj3 = new ECDomainParameters(((org.spongycastle.math.ec.ECCurve) (obj3)), ecpoint, biginteger3, ((BigInteger) (obj)), ((X9ECParameters) (obj1)).aln);
                obj = obj1;
                obj1 = obj3;
            }
            subjectpublickeyinfo = new DEROctetString(subjectpublickeyinfo.ajD.getBytes());
            return new ECPublicKeyParameters((new X9ECPoint(((X9ECParameters) (obj)).alm, subjectpublickeyinfo)).alu, ((ECDomainParameters) (obj1)));
        } else
        {
            throw new RuntimeException("algorithm identifier in key not recognised");
        }
    }
}
