// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECKeySpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            BCECPublicKey

public class BCECPrivateKey
    implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{

    private transient PKCS12BagAttributeCarrierImpl aCJ;
    private String aDc;
    private transient ECParameterSpec aDd;
    private transient DERBitString aDe;
    private transient ProviderConfiguration aDm;
    private transient BigInteger awZ;

    protected BCECPrivateKey()
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    public BCECPrivateKey(String s, ECPrivateKeySpec ecprivatekeyspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aDc = s;
        awZ = ecprivatekeyspec.getS();
        aDd = ecprivatekeyspec.getParams();
        aDm = providerconfiguration;
    }

    BCECPrivateKey(String s, PrivateKeyInfo privatekeyinfo, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aDc = s;
        aDm = providerconfiguration;
        _mth02CB(privatekeyinfo);
    }

    public BCECPrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters, BCECPublicKey bcecpublickey, ECParameterSpec ecparameterspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecprivatekeyparameters)).aub;
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        aDm = providerconfiguration;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = new ECParameterSpec(EC5Util._mth02CE(s), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als.intValue());
        } else
        {
            aDd = ecparameterspec;
        }
        aDe = _mth02CA(bcecpublickey);
    }

    public BCECPrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters, BCECPublicKey bcecpublickey, org.spongycastle.jce.spec.ECParameterSpec ecparameterspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecprivatekeyparameters)).aub;
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        aDm = providerconfiguration;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = new ECParameterSpec(EC5Util._mth02CE(s), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als.intValue());
        } else
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(ecparameterspec.alm), ecparameterspec);
        }
        aDe = _mth02CA(bcecpublickey);
    }

    public BCECPrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        aDd = null;
        aDm = providerconfiguration;
    }

    public BCECPrivateKey(String s, org.spongycastle.jce.spec.ECPrivateKeySpec ecprivatekeyspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aDc = s;
        awZ = ecprivatekeyspec.awZ;
        if (((ECKeySpec) (ecprivatekeyspec)).aIj != null)
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(((ECKeySpec) (ecprivatekeyspec)).aIj.alm), ((ECKeySpec) (ecprivatekeyspec)).aIj);
        } else
        {
            aDd = null;
        }
        aDm = providerconfiguration;
    }

    public BCECPrivateKey(ECPrivateKey ecprivatekey, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        awZ = ecprivatekey.getS();
        aDc = ecprivatekey.getAlgorithm();
        aDd = ecprivatekey.getParams();
        aDm = providerconfiguration;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        _mth02CB(PrivateKeyInfo._mth1D38(ASN1Primitive._mth0640((byte[])objectinputstream.readObject())));
        aDm = BouncyCastleProvider.aGZ;
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(getEncoded());
    }

    private static DERBitString _mth02CA(BCECPublicKey bcecpublickey)
    {
        try
        {
            bcecpublickey = SubjectPublicKeyInfo._mth13A5(ASN1Primitive._mth0640(bcecpublickey.getEncoded())).ajD;
        }
        // Misplaced declaration of an exception variable
        catch (BCECPublicKey bcecpublickey)
        {
            return null;
        }
        return bcecpublickey;
    }

    private void _mth02CB(PrivateKeyInfo privatekeyinfo)
    {
        Object obj = X962Parameters._mth06E5(privatekeyinfo.aaK.ahQ);
        if (((X962Parameters) (obj)).alk instanceof ASN1ObjectIdentifier)
        {
            Object obj1 = ASN1ObjectIdentifier._mth02CE(((X962Parameters) (obj)).alk);
            obj = ECUtil._mth1FBE(((ASN1ObjectIdentifier) (obj1)));
            EllipticCurve ellipticcurve = EC5Util._mth02CE(((X9ECParameters) (obj)).alm);
            obj1 = ECUtil._mth02BE(((ASN1ObjectIdentifier) (obj1)));
            ECPoint ecpoint1 = new ECPoint(((X9ECParameters) (obj)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj)).alq.FF93().toBigInteger());
            BigInteger biginteger1 = ((X9ECParameters) (obj)).alr;
            if (((X9ECParameters) (obj)).als == null)
            {
                obj = X9ECParameters.ONE;
            } else
            {
                obj = ((X9ECParameters) (obj)).als;
            }
            aDd = new ECNamedCurveSpec(((String) (obj1)), ellipticcurve, ecpoint1, biginteger1, ((BigInteger) (obj)));
        } else
        if (((X962Parameters) (obj)).alk instanceof ASN1Null)
        {
            aDd = null;
        } else
        {
            obj = X9ECParameters._mth0640(((X962Parameters) (obj)).alk);
            EllipticCurve ellipticcurve1 = EC5Util._mth02CE(((X9ECParameters) (obj)).alm);
            ECPoint ecpoint = new ECPoint(((X9ECParameters) (obj)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj)).alq.FF93().toBigInteger());
            BigInteger biginteger = ((X9ECParameters) (obj)).alr;
            if (((X9ECParameters) (obj)).als == null)
            {
                obj = X9ECParameters.ONE;
            } else
            {
                obj = ((X9ECParameters) (obj)).als;
            }
            aDd = new ECParameterSpec(ellipticcurve1, ecpoint, biginteger, ((BigInteger) (obj)).intValue());
        }
        privatekeyinfo = ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501());
        if (privatekeyinfo instanceof ASN1Integer)
        {
            awZ = new BigInteger(ASN1Integer.FB1D(privatekeyinfo).bytes);
            return;
        } else
        {
            privatekeyinfo = org.spongycastle.asn1.sec.ECPrivateKey._mth1427(privatekeyinfo);
            awZ = new BigInteger(1, ((ASN1OctetString)((org.spongycastle.asn1.sec.ECPrivateKey) (privatekeyinfo)).adC._mth144B(1))._mth0501());
            aDe = privatekeyinfo._mth0930();
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCECPrivateKey))
        {
            return false;
        }
        Object obj1 = (BCECPrivateKey)obj;
        if (awZ.equals(((BCECPrivateKey) (obj1)).awZ))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, false);
            } else
            {
                obj = aDm._mth1623();
            }
            if (((BCECPrivateKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((BCECPrivateKey) (obj1)).aDd, false);
            } else
            {
                obj1 = ((BCECPrivateKey) (obj1)).aDm._mth1623();
            }
            if (((org.spongycastle.jce.spec.ECParameterSpec) (obj)).equals(obj1))
            {
                return true;
            }
        }
        return false;
    }

    public String getAlgorithm()
    {
        return aDc;
    }

    public byte[] getEncoded()
    {
        IOException ioexception;
        Object obj;
        if (aDd instanceof ECNamedCurveSpec)
        {
            ASN1ObjectIdentifier asn1objectidentifier = ECUtil._mth157D(((ECNamedCurveSpec)aDd).name);
            obj = asn1objectidentifier;
            if (asn1objectidentifier == null)
            {
                obj = new ASN1ObjectIdentifier(((ECNamedCurveSpec)aDd).name);
            }
            obj = new X962Parameters(((ASN1ObjectIdentifier) (obj)));
        } else
        if (aDd == null)
        {
            obj = new X962Parameters(DERNull.WL);
        } else
        {
            obj = EC5Util._mth02CA(aDd.getCurve());
            obj = new X962Parameters(new X9ECParameters(((org.spongycastle.math.ec.ECCurve) (obj)), EC5Util._mth02CA(((org.spongycastle.math.ec.ECCurve) (obj)), aDd.getGenerator(), false), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
        }
        org.spongycastle.asn1.sec.ECPrivateKey ecprivatekey;
        if (aDe != null)
        {
            ecprivatekey = new org.spongycastle.asn1.sec.ECPrivateKey(getS(), aDe, ((ASN1Encodable) (obj)));
        } else
        {
            ecprivatekey = new org.spongycastle.asn1.sec.ECPrivateKey(getS(), ((X962Parameters) (obj)));
        }
        byte abyte0[];
        try
        {
            abyte0 = (new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.alH, ((ASN1Encodable) (obj))), ecprivatekey)).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return abyte0;
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public ECParameterSpec getParams()
    {
        return aDd;
    }

    public BigInteger getS()
    {
        return awZ;
    }

    public int hashCode()
    {
        int i = awZ.hashCode();
        org.spongycastle.jce.spec.ECParameterSpec ecparameterspec;
        if (aDd != null)
        {
            ecparameterspec = EC5Util._mth02CA(aDd, false);
        } else
        {
            ecparameterspec = aDm._mth1623();
        }
        return i ^ ecparameterspec.hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("EC Private Key").append(s);
        stringbuffer.append("             S: ").append(awZ.toString(16)).append(s);
        return stringbuffer.toString();
    }

    public final ASN1Encodable _mth02BC(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (ASN1Encodable)aCJ.aEq.get(asn1objectidentifier);
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, ASN1Encodable asn1encodable)
    {
        aCJ._mth02CA(asn1objectidentifier, asn1encodable);
    }

    public final Enumeration _mth152C()
    {
        return aCJ.aEr.elements();
    }

    public final org.spongycastle.jce.spec.ECParameterSpec _mth15A7()
    {
        if (aDd == null)
        {
            return null;
        } else
        {
            return EC5Util._mth02CA(aDd, false);
        }
    }

    public final BigInteger _mth15A8()
    {
        return awZ;
    }
}
