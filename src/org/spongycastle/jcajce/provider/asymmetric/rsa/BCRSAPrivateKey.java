// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCRSAPrivateKey
    implements RSAPrivateKey, PKCS12BagAttributeCarrier
{

    private static BigInteger ZERO = BigInteger.valueOf(0L);
    private transient PKCS12BagAttributeCarrierImpl aCJ;
    protected BigInteger adi;
    protected BigInteger adk;

    protected BCRSAPrivateKey()
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    BCRSAPrivateKey(RSAPrivateKey rsaprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        adi = rsaprivatekey.getModulus();
        adk = rsaprivatekey.getPrivateExponent();
    }

    BCRSAPrivateKey(RSAPrivateKeySpec rsaprivatekeyspec)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        adi = rsaprivatekeyspec.getModulus();
        adk = rsaprivatekeyspec.getPrivateExponent();
    }

    BCRSAPrivateKey(org.spongycastle.asn1.pkcs.RSAPrivateKey rsaprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        adi = rsaprivatekey.adi;
        adk = rsaprivatekey.adk;
    }

    BCRSAPrivateKey(RSAPrivateCrtKeyParameters rsaprivatecrtkeyparameters)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        adi = ((RSAKeyParameters) (rsaprivatecrtkeyparameters)).adi;
        adk = ((RSAKeyParameters) (rsaprivatecrtkeyparameters)).axE;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof RSAPrivateKey))
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        obj = (RSAPrivateKey)obj;
        return getModulus().equals(((RSAPrivateKey) (obj)).getModulus()) && getPrivateExponent().equals(((RSAPrivateKey) (obj)).getPrivateExponent());
    }

    public String getAlgorithm()
    {
        return "RSA";
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CB(new AlgorithmIdentifier(PKCSObjectIdentifiers.aaX, DERNull.WL), new org.spongycastle.asn1.pkcs.RSAPrivateKey(getModulus(), ZERO, getPrivateExponent(), ZERO, ZERO, ZERO, ZERO, ZERO));
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public BigInteger getModulus()
    {
        return adi;
    }

    public BigInteger getPrivateExponent()
    {
        return adk;
    }

    public int hashCode()
    {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
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
