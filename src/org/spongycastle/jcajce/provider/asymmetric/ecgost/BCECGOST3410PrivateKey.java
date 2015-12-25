// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ecgost;

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
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECKeySpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ecgost:
//            BCECGOST3410PublicKey

public class BCECGOST3410PrivateKey
    implements ECPrivateKey, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{

    private transient PKCS12BagAttributeCarrierImpl aCJ;
    private String aDc;
    private transient ECParameterSpec aDd;
    private transient DERBitString aDe;
    private transient GOST3410PublicKeyAlgParameters aDw;
    private transient BigInteger awZ;

    protected BCECGOST3410PrivateKey()
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    public BCECGOST3410PrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        aDd = null;
    }

    public BCECGOST3410PrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters, BCECGOST3410PublicKey bcecgost3410publickey, ECParameterSpec ecparameterspec)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecprivatekeyparameters)).aub;
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = new ECParameterSpec(EC5Util._mth02CE(s), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als.intValue());
        } else
        {
            aDd = ecparameterspec;
        }
        aDw = bcecgost3410publickey.aDw;
        aDe = _mth02CA(bcecgost3410publickey);
    }

    public BCECGOST3410PrivateKey(String s, ECPrivateKeyParameters ecprivatekeyparameters, BCECGOST3410PublicKey bcecgost3410publickey, org.spongycastle.jce.spec.ECParameterSpec ecparameterspec)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters ecdomainparameters = ((ECKeyParameters) (ecprivatekeyparameters)).aub;
        aDc = s;
        awZ = ecprivatekeyparameters.awZ;
        if (ecparameterspec == null)
        {
            s = ecdomainparameters.alm;
            Arrays._mth1D4C(ecdomainparameters.aln);
            aDd = new ECParameterSpec(EC5Util._mth02CE(s), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als.intValue());
        } else
        {
            aDd = new ECParameterSpec(EC5Util._mth02CE(ecparameterspec.alm), new ECPoint(ecparameterspec.axi.FF8A().toBigInteger(), ecparameterspec.axi.FF93().toBigInteger()), ecparameterspec.alr, ecparameterspec.als.intValue());
        }
        aDw = bcecgost3410publickey.aDw;
        aDe = _mth02CA(bcecgost3410publickey);
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec ecprivatekeyspec)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        awZ = ecprivatekeyspec.getS();
        aDd = ecprivatekeyspec.getParams();
    }

    BCECGOST3410PrivateKey(PrivateKeyInfo privatekeyinfo)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        _mth02CB(privatekeyinfo);
    }

    public BCECGOST3410PrivateKey(org.spongycastle.jce.spec.ECPrivateKeySpec ecprivatekeyspec)
    {
        aDc = "ECGOST3410";
        aCJ = new PKCS12BagAttributeCarrierImpl();
        awZ = ecprivatekeyspec.awZ;
        if (((ECKeySpec) (ecprivatekeyspec)).aIj != null)
        {
            aDd = EC5Util._mth02CA(EC5Util._mth02CE(((ECKeySpec) (ecprivatekeyspec)).aIj.alm), ((ECKeySpec) (ecprivatekeyspec)).aIj);
            return;
        } else
        {
            aDd = null;
            return;
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        _mth02CB(PrivateKeyInfo._mth1D38(ASN1Primitive._mth0640((byte[])objectinputstream.readObject())));
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(getEncoded());
    }

    private static DERBitString _mth02CA(BCECGOST3410PublicKey bcecgost3410publickey)
    {
        try
        {
            bcecgost3410publickey = SubjectPublicKeyInfo._mth13A5(ASN1Primitive._mth0640(bcecgost3410publickey.getEncoded())).ajD;
        }
        // Misplaced declaration of an exception variable
        catch (BCECGOST3410PublicKey bcecgost3410publickey)
        {
            return null;
        }
        return bcecgost3410publickey;
    }

    private void _mth02CB(PrivateKeyInfo privatekeyinfo)
    {
        Object obj = privatekeyinfo.aaK.ahQ._mth0427();
        if ((obj instanceof ASN1Sequence) && (ASN1Sequence._mth141F(obj).size() == 2 || ASN1Sequence._mth141F(obj).size() == 3))
        {
            aDw = GOST3410PublicKeyAlgParameters._mth02BD(privatekeyinfo.aaK.ahQ);
            obj = ECGOST3410NamedCurveTable.FE72(ECGOST3410NamedCurves._mth02CE(aDw.Yt));
            EllipticCurve ellipticcurve = EC5Util._mth02CE(((org.spongycastle.jce.spec.ECParameterSpec) (obj)).alm);
            aDd = new ECNamedCurveSpec(ECGOST3410NamedCurves._mth02CE(aDw.Yt), ellipticcurve, new ECPoint(((org.spongycastle.jce.spec.ECParameterSpec) (obj)).axi.FF8A().toBigInteger(), ((org.spongycastle.jce.spec.ECParameterSpec) (obj)).axi.FF93().toBigInteger()), ((org.spongycastle.jce.spec.ECParameterSpec) (obj)).alr, ((org.spongycastle.jce.spec.ECParameterSpec) (obj)).als);
            privatekeyinfo = ASN1OctetString.FB39(ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501()))._mth0501();
            byte abyte0[] = new byte[privatekeyinfo.length];
            for (int i = 0; i != privatekeyinfo.length; i++)
            {
                abyte0[i] = privatekeyinfo[privatekeyinfo.length - 1 - i];
            }

            awZ = new BigInteger(1, abyte0);
            return;
        }
        abyte0 = X962Parameters._mth06E5(privatekeyinfo.aaK.ahQ);
        if (((X962Parameters) (abyte0)).alk instanceof ASN1ObjectIdentifier)
        {
            abyte0 = ASN1ObjectIdentifier._mth02CE(((X962Parameters) (abyte0)).alk);
            X9ECParameters x9ecparameters = ECUtil._mth1FBE(abyte0);
            if (x9ecparameters == null)
            {
                ECDomainParameters ecdomainparameters = ECGOST3410NamedCurves._mth02CB(abyte0);
                Object obj1 = ecdomainparameters.alm;
                Arrays._mth1D4C(ecdomainparameters.aln);
                obj1 = EC5Util._mth02CE(((org.spongycastle.math.ec.ECCurve) (obj1)));
                aDd = new ECNamedCurveSpec(ECGOST3410NamedCurves._mth02CE(abyte0), ((EllipticCurve) (obj1)), new ECPoint(ecdomainparameters.axi.FF8A().toBigInteger(), ecdomainparameters.axi.FF93().toBigInteger()), ecdomainparameters.alr, ecdomainparameters.als);
            } else
            {
                EllipticCurve ellipticcurve1 = EC5Util._mth02CE(x9ecparameters.alm);
                String s = ECUtil._mth02BE(abyte0);
                ECPoint ecpoint1 = new ECPoint(x9ecparameters.alq.FF8A().toBigInteger(), x9ecparameters.alq.FF93().toBigInteger());
                BigInteger biginteger1 = x9ecparameters.alr;
                if (x9ecparameters.als == null)
                {
                    abyte0 = X9ECParameters.ONE;
                } else
                {
                    abyte0 = x9ecparameters.als;
                }
                aDd = new ECNamedCurveSpec(s, ellipticcurve1, ecpoint1, biginteger1, abyte0);
            }
        } else
        if (((X962Parameters) (abyte0)).alk instanceof ASN1Null)
        {
            aDd = null;
        } else
        {
            abyte0 = X9ECParameters._mth0640(((X962Parameters) (abyte0)).alk);
            EllipticCurve ellipticcurve2 = EC5Util._mth02CE(((X9ECParameters) (abyte0)).alm);
            ECPoint ecpoint = new ECPoint(((X9ECParameters) (abyte0)).alq.FF8A().toBigInteger(), ((X9ECParameters) (abyte0)).alq.FF93().toBigInteger());
            BigInteger biginteger = ((X9ECParameters) (abyte0)).alr;
            if (((X9ECParameters) (abyte0)).als == null)
            {
                abyte0 = X9ECParameters.ONE;
            } else
            {
                abyte0 = ((X9ECParameters) (abyte0)).als;
            }
            aDd = new ECParameterSpec(ellipticcurve2, ecpoint, biginteger, abyte0.intValue());
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
        if (!(obj instanceof BCECGOST3410PrivateKey))
        {
            return false;
        }
        Object obj1 = (BCECGOST3410PrivateKey)obj;
        if (awZ.equals(((BCECGOST3410PrivateKey) (obj1)).awZ))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, false);
            } else
            {
                obj = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((BCECGOST3410PrivateKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((BCECGOST3410PrivateKey) (obj1)).aDd, false);
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
        IOException ioexception;
        if (aDw != null)
        {
            byte abyte3[] = new byte[32];
            byte abyte2[] = getS().toByteArray();
            byte abyte0[] = abyte2;
            if (abyte2.length < 32)
            {
                abyte0 = new byte[32];
                System.arraycopy(abyte2, 0, abyte0, 32 - abyte2.length, abyte2.length);
            }
            for (int i = 0; i != 32; i++)
            {
                abyte3[i + 0] = abyte0[abyte0.length - 1 - i];
            }

            try
            {
                abyte0 = (new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XW, aDw), new DEROctetString(abyte3))).getEncoded("DER");
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
            return abyte0;
        }
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
        byte abyte1[];
        try
        {
            abyte1 = (new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XW, ((X962Parameters) (obj))._mth0427()), ecprivatekey._mth0427())).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        return abyte1;
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
            return EC5Util._mth02CA(aDd, false);
        }
    }

    public final BigInteger _mth15A8()
    {
        return awZ;
    }
}
