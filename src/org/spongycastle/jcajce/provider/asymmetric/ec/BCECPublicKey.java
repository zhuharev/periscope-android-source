// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECKeySpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class BCECPublicKey
    implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{

    private String aDc;
    private transient java.security.spec.ECParameterSpec aDd;
    private transient ProviderConfiguration aDm;
    public transient ECPoint ayu;

    public BCECPublicKey(String s, ECPublicKeySpec ecpublickeyspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aDc = s;
        aDd = ecpublickeyspec.getParams();
        ayu = EC5Util._mth02CA(aDd, ecpublickeyspec.getW(), false);
        aDm = providerconfiguration;
    }

    BCECPublicKey(String s, SubjectPublicKeyInfo subjectpublickeyinfo, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aDc = s;
        aDm = providerconfiguration;
        _mth02CE(subjectpublickeyinfo);
    }

    public BCECPublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, java.security.spec.ECParameterSpec ecparameterspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecpublickeyparameters)).aub;
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = _mth02CA(EC5Util._mth02CE(s), ecdomainparameters);
        } else
        {
            aDd = ecparameterspec;
        }
        aDm = providerconfiguration;
    }

    public BCECPublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        aDd = null;
        aDm = providerconfiguration;
    }

    public BCECPublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, ECParameterSpec ecparameterspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecpublickeyparameters)).aub;
        aDc = s;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = _mth02CA(EC5Util._mth02CE(s), ecdomainparameters);
        } else
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(ecparameterspec.alm), ecparameterspec);
        }
        ayu = EC5Util._mth02CA(aDd.getCurve())._mth02CA(ecpublickeyparameters.axk.FF8A().toBigInteger(), ecpublickeyparameters.axk.FF93().toBigInteger(), false);
        aDm = providerconfiguration;
    }

    public BCECPublicKey(String s, org.spongycastle.jce.spec.ECPublicKeySpec ecpublickeyspec, ProviderConfiguration providerconfiguration)
    {
        aDc = "EC";
        aDc = s;
        ayu = ecpublickeyspec.ayu;
        if (((ECKeySpec) (ecpublickeyspec)).aIj != null)
        {
            s = EC5Util._mth02CE(((ECKeySpec) (ecpublickeyspec)).aIj.alm);
            ayu = EC5Util._mth02CA(s)._mth02CA(ecpublickeyspec.ayu.FF8A().toBigInteger(), ecpublickeyspec.ayu.FF93().toBigInteger(), false);
            aDd = EC5Util._mth02CA(s, ((ECKeySpec) (ecpublickeyspec)).aIj);
        } else
        {
            if (ayu.FF79() == null)
            {
                ayu = providerconfiguration._mth1623().alm._mth02CA(ayu._mth0134().toBigInteger(), ayu._mth0141().toBigInteger(), false);
            }
            aDd = null;
        }
        aDm = providerconfiguration;
    }

    public BCECPublicKey(ECPublicKey ecpublickey)
    {
        aDc = "EC";
        aDc = ecpublickey.getAlgorithm();
        aDd = ecpublickey.getParams();
        ayu = EC5Util._mth02CA(aDd, ecpublickey.getW(), false);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        _mth02CE(SubjectPublicKeyInfo._mth13A5(ASN1Primitive._mth0640((byte[])objectinputstream.readObject())));
        aDm = BouncyCastleProvider.aGZ;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(getEncoded());
    }

    private static java.security.spec.ECParameterSpec _mth02CA(EllipticCurve ellipticcurve, ECDomainParameters ecdomainparameters)
    {
        return new java.security.spec.ECParameterSpec(ellipticcurve, new java.security.spec.ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als.intValue());
    }

    private void _mth02CE(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        Object obj;
label0:
        {
            obj = new X962Parameters((ASN1Primitive)subjectpublickeyinfo.aaK.ahQ);
            if (((X962Parameters) (obj)).alk instanceof ASN1ObjectIdentifier)
            {
                Object obj1 = (ASN1ObjectIdentifier)((X962Parameters) (obj)).alk;
                obj = ECUtil._mth1FBE(((ASN1ObjectIdentifier) (obj1)));
                ECCurve eccurve = ((X9ECParameters) (obj)).alm;
                EllipticCurve ellipticcurve = EC5Util._mth02CE(eccurve);
                obj1 = ECUtil._mth02BE(((ASN1ObjectIdentifier) (obj1)));
                java.security.spec.ECPoint ecpoint1 = new java.security.spec.ECPoint(((X9ECParameters) (obj)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj)).alq.FF93().toBigInteger());
                BigInteger biginteger1 = ((X9ECParameters) (obj)).alr;
                if (((X9ECParameters) (obj)).als == null)
                {
                    obj = X9ECParameters.ONE;
                } else
                {
                    obj = ((X9ECParameters) (obj)).als;
                }
                aDd = new ECNamedCurveSpec(((String) (obj1)), ellipticcurve, ecpoint1, biginteger1, ((BigInteger) (obj)));
                obj = eccurve;
            } else
            if (((X962Parameters) (obj)).alk instanceof ASN1Null)
            {
                aDd = null;
                obj = aDm._mth1623().alm;
            } else
            {
                obj = X9ECParameters._mth0640(((X962Parameters) (obj)).alk);
                ECCurve eccurve1 = ((X9ECParameters) (obj)).alm;
                EllipticCurve ellipticcurve1 = EC5Util._mth02CE(eccurve1);
                java.security.spec.ECPoint ecpoint = new java.security.spec.ECPoint(((X9ECParameters) (obj)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj)).alq.FF93().toBigInteger());
                BigInteger biginteger = ((X9ECParameters) (obj)).alr;
                if (((X9ECParameters) (obj)).als == null)
                {
                    obj = X9ECParameters.ONE;
                } else
                {
                    obj = ((X9ECParameters) (obj)).als;
                }
                aDd = new java.security.spec.ECParameterSpec(ellipticcurve1, ecpoint, biginteger, ((BigInteger) (obj)).intValue());
                obj = eccurve1;
            }
            byte abyte0[] = subjectpublickeyinfo.ajD.getBytes();
            DEROctetString deroctetstring = new DEROctetString(abyte0);
            subjectpublickeyinfo = deroctetstring;
            if (abyte0[0] != 4)
            {
                break label0;
            }
            subjectpublickeyinfo = deroctetstring;
            if (abyte0[1] != abyte0.length - 2)
            {
                break label0;
            }
            if (abyte0[2] != 2)
            {
                subjectpublickeyinfo = deroctetstring;
                if (abyte0[2] != 3)
                {
                    break label0;
                }
            }
            new X9IntegerConverter();
            subjectpublickeyinfo = deroctetstring;
            if (X9IntegerConverter._mth02CB(((ECCurve) (obj))) >= abyte0.length - 3)
            {
                try
                {
                    subjectpublickeyinfo = (ASN1OctetString)ASN1Primitive._mth0640(abyte0);
                }
                // Misplaced declaration of an exception variable
                catch (SubjectPublicKeyInfo subjectpublickeyinfo)
                {
                    throw new IllegalArgumentException("error recovering public key");
                }
            }
        }
        ayu = (new X9ECPoint(((ECCurve) (obj)), subjectpublickeyinfo)).alu;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCECPublicKey))
        {
            return false;
        }
        Object obj1 = (BCECPublicKey)obj;
        if (ayu._mth02CF(((BCECPublicKey) (obj1)).ayu))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, false);
            } else
            {
                obj = aDm._mth1623();
            }
            if (((BCECPublicKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((BCECPublicKey) (obj1)).aDd, false);
            } else
            {
                obj1 = ((BCECPublicKey) (obj1)).aDm._mth1623();
            }
            if (((ECParameterSpec) (obj)).equals(obj1))
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
            obj = new X962Parameters(new X9ECParameters(((ECCurve) (obj)), EC5Util._mth02CA(((ECCurve) (obj)), aDd.getGenerator(), false), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
        }
        ECCurve eccurve = ayu.FF79();
        Object obj1;
        if (aDd == null)
        {
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            BigInteger biginteger = ((ECPoint) (obj1))._mth0134().toBigInteger();
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            obj1 = (ASN1OctetString)(new X9ECPoint(eccurve._mth02CA(biginteger, ((ECPoint) (obj1))._mth0141().toBigInteger(), false)))._mth0427();
        } else
        {
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            BigInteger biginteger1 = ((ECPoint) (obj1)).FF8A().toBigInteger();
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            obj1 = (ASN1OctetString)(new X9ECPoint(eccurve._mth02CA(biginteger1, ((ECPoint) (obj1)).FF93().toBigInteger(), false)))._mth0427();
        }
        return KeyUtil._mth02CF(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.alH, ((org.spongycastle.asn1.ASN1Encodable) (obj))), ((ASN1OctetString) (obj1))._mth0501()));
    }

    public String getFormat()
    {
        return "X.509";
    }

    public java.security.spec.ECParameterSpec getParams()
    {
        return aDd;
    }

    public java.security.spec.ECPoint getW()
    {
        return new java.security.spec.ECPoint(ayu.FF8A().toBigInteger(), ayu.FF93().toBigInteger());
    }

    public int hashCode()
    {
        int i = ayu.hashCode();
        ECParameterSpec ecparameterspec;
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
        stringbuffer.append("EC Public Key").append(s);
        stringbuffer.append("            X: ").append(ayu.FF8A().toBigInteger().toString(16)).append(s);
        stringbuffer.append("            Y: ").append(ayu.FF93().toBigInteger().toString(16)).append(s);
        return stringbuffer.toString();
    }

    public final ECParameterSpec _mth15A7()
    {
        if (aDd == null)
        {
            return null;
        } else
        {
            return EC5Util._mth02CA(aDd, false);
        }
    }

    public final ECPoint _mth15AA()
    {
        if (aDd == null)
        {
            return ayu.FF78();
        } else
        {
            return ayu;
        }
    }
}
