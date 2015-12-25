// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDSAPrivateKey
    implements DSAPrivateKey, PKCS12BagAttributeCarrier
{

    private transient PKCS12BagAttributeCarrierImpl aCJ;
    private transient DSAParams aCY;
    private BigInteger amZ;

    protected BCDSAPrivateKey()
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    BCDSAPrivateKey(DSAPrivateKey dsaprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dsaprivatekey.getX();
        aCY = dsaprivatekey.getParams();
    }

    BCDSAPrivateKey(DSAPrivateKeySpec dsaprivatekeyspec)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dsaprivatekeyspec.getX();
        aCY = new DSAParameterSpec(dsaprivatekeyspec.getP(), dsaprivatekeyspec.getQ(), dsaprivatekeyspec.getG());
    }

    public BCDSAPrivateKey(PrivateKeyInfo privatekeyinfo)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        DSAParameter dsaparameter = DSAParameter._mth1D62(privatekeyinfo.aaK.ahQ);
        amZ = new BigInteger(((ASN1Integer)ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501())).bytes);
        aCY = new DSAParameterSpec(new BigInteger(1, dsaparameter.Yq.bytes), new BigInteger(1, dsaparameter.Yr.bytes), new BigInteger(1, dsaparameter.aat.bytes));
    }

    BCDSAPrivateKey(DSAPrivateKeyParameters dsaprivatekeyparameters)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dsaprivatekeyparameters.amZ;
        aCY = new DSAParameterSpec(((DSAKeyParameters) (dsaprivatekeyparameters)).axf.amM, ((DSAKeyParameters) (dsaprivatekeyparameters)).axf.amN, ((DSAKeyParameters) (dsaprivatekeyparameters)).axf.amO);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aCY = new DSAParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(aCY.getP());
        objectoutputstream.writeObject(aCY.getQ());
        objectoutputstream.writeObject(aCY.getG());
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DSAPrivateKey))
        {
            return false;
        }
        obj = (DSAPrivateKey)obj;
        return getX().equals(((DSAPrivateKey) (obj)).getX()) && getParams().getG().equals(((DSAPrivateKey) (obj)).getParams().getG()) && getParams().getP().equals(((DSAPrivateKey) (obj)).getParams().getP()) && getParams().getQ().equals(((DSAPrivateKey) (obj)).getParams().getQ());
    }

    public String getAlgorithm()
    {
        return "DSA";
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CB(new AlgorithmIdentifier(X9ObjectIdentifiers.amm, (new DSAParameter(aCY.getP(), aCY.getQ(), aCY.getG()))._mth0427()), new ASN1Integer(getX()));
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public DSAParams getParams()
    {
        return aCY;
    }

    public BigInteger getX()
    {
        return amZ;
    }

    public int hashCode()
    {
        return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
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
}
