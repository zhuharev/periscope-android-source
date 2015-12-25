// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
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
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.ECPrivateKeyStructure;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jce.provider:
//            BouncyCastleProvider

public class JCEECPrivateKey
    implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{

    private PKCS12BagAttributeCarrierImpl aCJ;
    private String aDc;
    private ECParameterSpec aDd;
    private DERBitString aDe;
    private boolean aHv;
    private BigInteger awZ;

    protected JCEECPrivateKey()
    {
        aDc = "EC";
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        PrivateKeyInfo privatekeyinfo = PrivateKeyInfo._mth1D38(ASN1Primitive._mth0640((byte[])objectinputstream.readObject()));
        Object obj = new X962Parameters((ASN1Primitive)privatekeyinfo.aaK.ahQ);
        if (((X962Parameters) (obj)).alk instanceof ASN1ObjectIdentifier)
        {
            obj = ASN1ObjectIdentifier._mth02CE(((X962Parameters) (obj)).alk);
            X9ECParameters x9ecparameters = ECUtil._mth1FBE(((ASN1ObjectIdentifier) (obj)));
            if (x9ecparameters == null)
            {
                ECDomainParameters ecdomainparameters = ECGOST3410NamedCurves._mth02CB(((ASN1ObjectIdentifier) (obj)));
                Object obj1 = ecdomainparameters.alm;
                Arrays._mth1D4C(ecdomainparameters.aln);
                obj1 = EC5Util._mth02CE(((org.spongycastle.math.ec.ECCurve) (obj1)));
                aDd = new ECNamedCurveSpec(ECGOST3410NamedCurves._mth02CE(((ASN1ObjectIdentifier) (obj))), ((EllipticCurve) (obj1)), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als);
            } else
            {
                EllipticCurve ellipticcurve = EC5Util._mth02CE(x9ecparameters.alm);
                String s = ECUtil._mth02BE(((ASN1ObjectIdentifier) (obj)));
                ECPoint ecpoint1 = new ECPoint(x9ecparameters.alq.FF8A().toBigInteger(), x9ecparameters.alq.FF93().toBigInteger());
                BigInteger biginteger1 = x9ecparameters.alr;
                if (x9ecparameters.als == null)
                {
                    obj = X9ECParameters.ONE;
                } else
                {
                    obj = x9ecparameters.als;
                }
                aDd = new ECNamedCurveSpec(s, ellipticcurve, ecpoint1, biginteger1, ((BigInteger) (obj)));
            }
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
        obj = ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501());
        if (obj instanceof ASN1Integer)
        {
            awZ = new BigInteger(ASN1Integer.FB1D(obj).bytes);
        } else
        {
            obj = new ECPrivateKeyStructure((ASN1Sequence)obj);
            awZ = new BigInteger(1, ((ASN1OctetString)((ECPrivateKeyStructure) (obj)).adC._mth144B(1))._mth0501());
            aDe = ((ECPrivateKeyStructure) (obj))._mth0930();
        }
        aDc = (String)objectinputstream.readObject();
        aHv = objectinputstream.readBoolean();
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aCJ.readObject(objectinputstream);
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(getEncoded());
        objectoutputstream.writeObject(aDc);
        objectoutputstream.writeBoolean(aHv);
        aCJ.writeObject(objectoutputstream);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof JCEECPrivateKey))
        {
            return false;
        }
        Object obj1 = (JCEECPrivateKey)obj;
        if (awZ.equals(((JCEECPrivateKey) (obj1)).awZ))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, aHv);
            } else
            {
                obj = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((JCEECPrivateKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((JCEECPrivateKey) (obj1)).aDd, ((JCEECPrivateKey) (obj1)).aHv);
            } else
            {
                obj1 = BouncyCastleProvider.aGZ._mth1623();
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
            obj = new X962Parameters(new X9ECParameters(((org.spongycastle.math.ec.ECCurve) (obj)), EC5Util._mth02CA(((org.spongycastle.math.ec.ECCurve) (obj)), aDd.getGenerator(), aHv), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
        }
        ECPrivateKeyStructure ecprivatekeystructure;
        if (aDe != null)
        {
            ecprivatekeystructure = new ECPrivateKeyStructure(getS(), aDe, ((ASN1Encodable) (obj)));
        } else
        {
            ecprivatekeystructure = new ECPrivateKeyStructure(getS(), ((X962Parameters) (obj)));
        }
        byte abyte0[];
        try
        {
            if (aDc.equals("ECGOST3410"))
            {
                obj = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XW, ((X962Parameters) (obj))._mth0427()), ecprivatekeystructure._mth0427());
                break MISSING_BLOCK_LABEL_259;
            }
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        obj = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.alH, ((X962Parameters) (obj))._mth0427()), ecprivatekeystructure._mth0427());
        abyte0 = ((PrivateKeyInfo) (obj)).getEncoded("DER");
        IOException ioexception;
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
            ecparameterspec = EC5Util._mth02CA(aDd, aHv);
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
            return EC5Util._mth02CA(aDd, aHv);
        }
    }

    public final BigInteger _mth15A8()
    {
        return awZ;
    }
}
