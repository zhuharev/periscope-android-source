// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ua.DSTU4145BinaryField;
import org.spongycastle.asn1.ua.DSTU4145ECBinary;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.ua.DSTU4145PointEncoder;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECKeySpec;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class BCDSTU4145PublicKey
    implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{

    private String aDc;
    private transient java.security.spec.ECParameterSpec aDd;
    transient DSTU4145Params aDf;
    private transient ECPoint ayu;

    public BCDSTU4145PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters)
    {
        aDc = "DSTU4145";
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        aDd = null;
    }

    public BCDSTU4145PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, java.security.spec.ECParameterSpec ecparameterspec)
    {
        aDc = "DSTU4145";
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecpublickeyparameters)).aub;
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = _mth02CA(EC5Util._mth02CE(s), ecdomainparameters);
            return;
        } else
        {
            aDd = ecparameterspec;
            return;
        }
    }

    public BCDSTU4145PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, ECParameterSpec ecparameterspec)
    {
        aDc = "DSTU4145";
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecpublickeyparameters)).aub;
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = _mth02CA(EC5Util._mth02CE(s), ecdomainparameters);
            return;
        } else
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(ecparameterspec.alm), ecparameterspec);
            return;
        }
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec ecpublickeyspec)
    {
        aDc = "DSTU4145";
        aDd = ecpublickeyspec.getParams();
        ayu = EC5Util._mth02CA(aDd, ecpublickeyspec.getW(), false);
    }

    BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        aDc = "DSTU4145";
        _mth02CE(subjectpublickeyinfo);
    }

    public BCDSTU4145PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec ecpublickeyspec)
    {
        aDc = "DSTU4145";
        ayu = ecpublickeyspec.ayu;
        if (((ECKeySpec) (ecpublickeyspec)).aIj != null)
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(((ECKeySpec) (ecpublickeyspec)).aIj.alm), ((ECKeySpec) (ecpublickeyspec)).aIj);
            return;
        }
        if (ayu.FF79() == null)
        {
            ayu = BouncyCastleProvider.aGZ._mth1623().alm._mth02CA(ayu.FF8A().toBigInteger(), ayu.FF93().toBigInteger(), false);
        }
        aDd = null;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        _mth02CE(SubjectPublicKeyInfo._mth13A5(ASN1Primitive._mth0640((byte[])objectinputstream.readObject())));
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
        Object obj = subjectpublickeyinfo.ajD;
        aDc = "DSTU4145";
        try
        {
            obj = (ASN1OctetString)ASN1Primitive._mth0640(((DERBitString) (obj)).getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("error recovering public key");
        }
        byte abyte0[] = ((ASN1OctetString) (obj))._mth0501();
        if ((new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier)).equals(UAObjectIdentifiers.afZ))
        {
            _mth1D40(abyte0);
        }
        aDf = DSTU4145Params._mth141D((ASN1Sequence)subjectpublickeyinfo.aaK.ahQ);
        boolean flag;
        if (aDf.afV != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            subjectpublickeyinfo = aDf.afV;
            ECDomainParameters ecdomainparameters = DSTU4145NamedCurves._mth02CB(subjectpublickeyinfo);
            subjectpublickeyinfo = new ECNamedCurveParameterSpec(((ASN1ObjectIdentifier) (subjectpublickeyinfo)).identifier, ecdomainparameters.alm, ecdomainparameters.axi, ecdomainparameters.alr, ecdomainparameters.als, Arrays._mth1D4C(ecdomainparameters.aln));
        } else
        {
            DSTU4145ECBinary dstu4145ecbinary = aDf.afW;
            byte abyte1[] = Arrays._mth1D4C(dstu4145ecbinary.afO._mth0501());
            if ((new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier)).equals(UAObjectIdentifiers.afZ))
            {
                _mth1D40(abyte1);
            }
            DSTU4145BinaryField dstu4145binaryfield = dstu4145ecbinary.afN;
            org.spongycastle.math.ec.ECCurve.F2m f2m = new org.spongycastle.math.ec.ECCurve.F2m(dstu4145binaryfield.afJ, dstu4145binaryfield.afK, dstu4145binaryfield.afL, dstu4145binaryfield.afM, new BigInteger(dstu4145ecbinary.Ys.bytes), new BigInteger(1, abyte1));
            byte abyte2[] = Arrays._mth1D4C(dstu4145ecbinary.afQ._mth0501());
            if ((new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier)).equals(UAObjectIdentifiers.afZ))
            {
                _mth1D40(abyte2);
            }
            subjectpublickeyinfo = new ECParameterSpec(f2m, DSTU4145PointEncoder._mth02CA(f2m, abyte2), new BigInteger(dstu4145ecbinary.afP.bytes));
        }
        ECCurve eccurve = ((ECParameterSpec) (subjectpublickeyinfo)).alm;
        EllipticCurve ellipticcurve = EC5Util._mth02CE(eccurve);
        ayu = DSTU4145PointEncoder._mth02CA(eccurve, abyte0);
        if (aDf.afV != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aDd = new ECNamedCurveSpec(aDf.afV.identifier, ellipticcurve, new java.security.spec.ECPoint(((ECParameterSpec) (subjectpublickeyinfo)).axi.FF8A().toBigInteger(), ((ECParameterSpec) (subjectpublickeyinfo)).axi.FF93().toBigInteger()), ((ECParameterSpec) (subjectpublickeyinfo)).alr, ((ECParameterSpec) (subjectpublickeyinfo)).als);
            return;
        } else
        {
            aDd = new java.security.spec.ECParameterSpec(ellipticcurve, new java.security.spec.ECPoint(((ECParameterSpec) (subjectpublickeyinfo)).axi.FF8A().toBigInteger(), ((ECParameterSpec) (subjectpublickeyinfo)).axi.FF93().toBigInteger()), ((ECParameterSpec) (subjectpublickeyinfo)).alr, ((ECParameterSpec) (subjectpublickeyinfo)).als.intValue());
            return;
        }
    }

    private static void _mth1D40(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length / 2; i++)
        {
            byte byte0 = abyte0[i];
            abyte0[i] = abyte0[abyte0.length - 1 - i];
            abyte0[abyte0.length - 1 - i] = byte0;
        }

    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCDSTU4145PublicKey))
        {
            return false;
        }
        Object obj1 = (BCDSTU4145PublicKey)obj;
        if (ayu._mth02CF(((BCDSTU4145PublicKey) (obj1)).ayu))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, false);
            } else
            {
                obj = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((BCDSTU4145PublicKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((BCDSTU4145PublicKey) (obj1)).aDd, false);
            } else
            {
                obj1 = BouncyCastleProvider.aGZ._mth1623();
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
        IOException ioexception;
        Object obj;
        if (aDf != null)
        {
            obj = aDf;
        } else
        if (aDd instanceof ECNamedCurveSpec)
        {
            obj = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec)aDd).name));
        } else
        {
            obj = EC5Util._mth02CA(aDd.getCurve());
            obj = new X962Parameters(new X9ECParameters(((ECCurve) (obj)), EC5Util._mth02CA(((ECCurve) (obj)), aDd.getGenerator(), false), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
        }
        byte abyte0[] = DSTU4145PointEncoder._mth02CA(ayu);
        try
        {
            obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.aga, ((org.spongycastle.asn1.ASN1Encodable) (obj))), new DEROctetString(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return KeyUtil._mth02CF(((SubjectPublicKeyInfo) (obj)));
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
            ecparameterspec = BouncyCastleProvider.aGZ._mth1623();
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
