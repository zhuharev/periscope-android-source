// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCERSAPrivateKey
    implements RSAPrivateKey, PKCS12BagAttributeCarrier
{

    private static BigInteger ZERO = BigInteger.valueOf(0L);
    private PKCS12BagAttributeCarrierImpl aCJ;
    private BigInteger adi;
    private BigInteger adk;

    protected JCERSAPrivateKey()
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        adi = (BigInteger)objectinputstream.readObject();
        aCJ = new PKCS12BagAttributeCarrierImpl();
        aCJ.readObject(objectinputstream);
        adk = (BigInteger)objectinputstream.readObject();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(adi);
        aCJ.writeObject(objectoutputstream);
        objectoutputstream.writeObject(adk);
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
