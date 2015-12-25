// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.jce.spec.ElGamalPrivateKeySpec;

public class BCElGamalPrivateKey
    implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier
{

    private transient PKCS12BagAttributeCarrierImpl aCJ;
    private transient ElGamalParameterSpec aDz;
    private BigInteger amZ;

    protected BCElGamalPrivateKey()
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    BCElGamalPrivateKey(DHPrivateKey dhprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dhprivatekey.getX();
        aDz = new ElGamalParameterSpec(dhprivatekey.getParams().getP(), dhprivatekey.getParams().getG());
    }

    BCElGamalPrivateKey(DHPrivateKeySpec dhprivatekeyspec)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dhprivatekeyspec.getX();
        aDz = new ElGamalParameterSpec(dhprivatekeyspec.getP(), dhprivatekeyspec.getG());
    }

    BCElGamalPrivateKey(PrivateKeyInfo privatekeyinfo)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        ElGamalParameter elgamalparameter = ElGamalParameter._mth1FBE(privatekeyinfo.aaK.ahQ);
        amZ = new BigInteger(ASN1Integer.FB1D(ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501())).bytes);
        aDz = new ElGamalParameterSpec(new BigInteger(1, elgamalparameter.Yq.bytes), new BigInteger(1, elgamalparameter.aat.bytes));
    }

    BCElGamalPrivateKey(ElGamalPrivateKeyParameters elgamalprivatekeyparameters)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = elgamalprivatekeyparameters.amZ;
        aDz = new ElGamalParameterSpec(((ElGamalKeyParameters) (elgamalprivatekeyparameters)).axl.amM, ((ElGamalKeyParameters) (elgamalprivatekeyparameters)).axl.amO);
    }

    BCElGamalPrivateKey(ElGamalPrivateKey elgamalprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = elgamalprivatekey.getX();
        aDz = elgamalprivatekey._mth15AC();
    }

    BCElGamalPrivateKey(ElGamalPrivateKeySpec elgamalprivatekeyspec)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = null;
        throw new NullPointerException();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aDz = new ElGamalParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(aDz.amM);
        objectoutputstream.writeObject(aDz.amO);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHPrivateKey))
        {
            return false;
        }
        obj = (DHPrivateKey)obj;
        return getX().equals(((DHPrivateKey) (obj)).getX()) && getParams().getG().equals(((DHPrivateKey) (obj)).getParams().getG()) && getParams().getP().equals(((DHPrivateKey) (obj)).getParams().getP()) && getParams().getL() == ((DHPrivateKey) (obj)).getParams().getL();
    }

    public String getAlgorithm()
    {
        return "ElGamal";
    }

    public byte[] getEncoded()
    {
        IOException ioexception;
        byte abyte0[];
        try
        {
            abyte0 = (new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.aay, new ElGamalParameter(aDz.amM, aDz.amO)), new ASN1Integer(getX()))).getEncoded("DER");
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

    public DHParameterSpec getParams()
    {
        return new DHParameterSpec(aDz.amM, aDz.amO);
    }

    public BigInteger getX()
    {
        return amZ;
    }

    public int hashCode()
    {
        return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
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

    public final ElGamalParameterSpec _mth15AC()
    {
        return aDz;
    }
}
