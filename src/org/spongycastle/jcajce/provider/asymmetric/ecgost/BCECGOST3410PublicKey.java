// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
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
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECKeySpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class BCECGOST3410PublicKey
    implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{

    private String aDc;
    private transient java.security.spec.ECParameterSpec aDd;
    transient GOST3410PublicKeyAlgParameters aDw;
    private transient ECPoint ayu;

    public BCECGOST3410PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters)
    {
        aDc = "ECGOST3410";
        aDc = s;
        ayu = ecpublickeyparameters.axk;
        aDd = null;
    }

    public BCECGOST3410PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, java.security.spec.ECParameterSpec ecparameterspec)
    {
        aDc = "ECGOST3410";
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

    public BCECGOST3410PublicKey(String s, ECPublicKeyParameters ecpublickeyparameters, ECParameterSpec ecparameterspec)
    {
        aDc = "ECGOST3410";
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

    public BCECGOST3410PublicKey(ECPublicKeySpec ecpublickeyspec)
    {
        aDc = "ECGOST3410";
        aDd = ecpublickeyspec.getParams();
        ayu = EC5Util._mth02CA(aDd, ecpublickeyspec.getW(), false);
    }

    BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        aDc = "ECGOST3410";
        _mth02CE(subjectpublickeyinfo);
    }

    public BCECGOST3410PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec ecpublickeyspec)
    {
        aDc = "ECGOST3410";
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

    private static void _mth02CA(byte abyte0[], int i, BigInteger biginteger)
    {
        byte abyte1[] = biginteger.toByteArray();
        biginteger = abyte1;
        if (abyte1.length < 32)
        {
            biginteger = new byte[32];
            System.arraycopy(abyte1, 0, biginteger, 32 - abyte1.length, abyte1.length);
        }
        for (int j = 0; j != 32; j++)
        {
            abyte0[i + j] = biginteger[biginteger.length - 1 - j];
        }

    }

    private void _mth02CE(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        Object obj = subjectpublickeyinfo.ajD;
        aDc = "ECGOST3410";
        try
        {
            obj = (ASN1OctetString)ASN1Primitive._mth0640(((DERBitString) (obj)).getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("error recovering public key");
        }
        byte abyte2[] = ((ASN1OctetString) (obj))._mth0501();
        byte abyte0[] = new byte[32];
        byte abyte1[] = new byte[32];
        for (int i = 0; i != 32; i++)
        {
            abyte0[i] = abyte2[31 - i];
        }

        for (int j = 0; j != 32; j++)
        {
            abyte1[j] = abyte2[63 - j];
        }

        aDw = GOST3410PublicKeyAlgParameters._mth02BD(subjectpublickeyinfo.aaK.ahQ);
        subjectpublickeyinfo = ECGOST3410NamedCurveTable.FE72(ECGOST3410NamedCurves._mth02CE(aDw.Yt));
        ECCurve eccurve = ((ECParameterSpec) (subjectpublickeyinfo)).alm;
        EllipticCurve ellipticcurve = EC5Util._mth02CE(eccurve);
        ayu = eccurve._mth02CA(new BigInteger(1, abyte0), new BigInteger(1, abyte1), false);
        aDd = new ECNamedCurveSpec(ECGOST3410NamedCurves._mth02CE(aDw.Yt), ellipticcurve, new java.security.spec.ECPoint(((ECParameterSpec) (subjectpublickeyinfo)).axi.FF8A().toBigInteger(), ((ECParameterSpec) (subjectpublickeyinfo)).axi.FF93().toBigInteger()), ((ECParameterSpec) (subjectpublickeyinfo)).alr, ((ECParameterSpec) (subjectpublickeyinfo)).als);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCECGOST3410PublicKey))
        {
            return false;
        }
        Object obj1 = (BCECGOST3410PublicKey)obj;
        if (ayu._mth02CF(((BCECGOST3410PublicKey) (obj1)).ayu))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, false);
            } else
            {
                obj = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((BCECGOST3410PublicKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((BCECGOST3410PublicKey) (obj1)).aDd, false);
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
        if (aDw != null)
        {
            obj = aDw;
        } else
        if (aDd instanceof ECNamedCurveSpec)
        {
            obj = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves._mth1422(((ECNamedCurveSpec)aDd).name), CryptoProObjectIdentifiers.XZ);
        } else
        {
            obj = EC5Util._mth02CA(aDd.getCurve());
            obj = new X962Parameters(new X9ECParameters(((ECCurve) (obj)), EC5Util._mth02CA(((ECCurve) (obj)), aDd.getGenerator(), false), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
        }
        BigInteger biginteger = ayu.FF8A().toBigInteger();
        BigInteger biginteger1 = ayu.FF93().toBigInteger();
        byte abyte0[] = new byte[64];
        _mth02CA(abyte0, 0, biginteger);
        _mth02CA(abyte0, 32, biginteger1);
        try
        {
            obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XW, ((org.spongycastle.asn1.ASN1Encodable) (obj))), new DEROctetString(abyte0));
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
