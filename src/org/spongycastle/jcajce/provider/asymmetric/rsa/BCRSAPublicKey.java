// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCRSAPublicKey
    implements RSAPublicKey
{

    private static final AlgorithmIdentifier aDV;
    private transient AlgorithmIdentifier aDW;
    private BigInteger adi;
    private BigInteger adj;

    BCRSAPublicKey(RSAPublicKey rsapublickey)
    {
        aDW = aDV;
        adi = rsapublickey.getModulus();
        adj = rsapublickey.getPublicExponent();
    }

    BCRSAPublicKey(RSAPublicKeySpec rsapublickeyspec)
    {
        aDW = aDV;
        adi = rsapublickeyspec.getModulus();
        adj = rsapublickeyspec.getPublicExponent();
    }

    BCRSAPublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        try
        {
            org.spongycastle.asn1.pkcs.RSAPublicKey rsapublickey = org.spongycastle.asn1.pkcs.RSAPublicKey._mth02BC((new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7());
            aDW = subjectpublickeyinfo.aaK;
            adi = rsapublickey.adi;
            adj = rsapublickey.adj;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }

    BCRSAPublicKey(RSAKeyParameters rsakeyparameters)
    {
        aDW = aDV;
        adi = rsakeyparameters.adi;
        adj = rsakeyparameters.axE;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        try
        {
            aDW = AlgorithmIdentifier._mth01C3(objectinputstream.readObject());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            aDW = aDV;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            aDW = aDV;
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        if (!aDW.equals(aDV))
        {
            objectoutputstream.writeObject(aDW.getEncoded());
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof RSAPublicKey))
        {
            return false;
        }
        obj = (RSAPublicKey)obj;
        return getModulus().equals(((RSAPublicKey) (obj)).getModulus()) && getPublicExponent().equals(((RSAPublicKey) (obj)).getPublicExponent());
    }

    public String getAlgorithm()
    {
        return "RSA";
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CA(aDW, new org.spongycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    public String getFormat()
    {
        return "X.509";
    }

    public BigInteger getModulus()
    {
        return adi;
    }

    public BigInteger getPublicExponent()
    {
        return adj;
    }

    public int hashCode()
    {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("RSA Public Key").append(s);
        stringbuffer.append("            modulus: ").append(getModulus().toString(16)).append(s);
        stringbuffer.append("    public exponent: ").append(getPublicExponent().toString(16)).append(s);
        return stringbuffer.toString();
    }

    static 
    {
        aDV = new AlgorithmIdentifier(PKCSObjectIdentifiers.aaX, DERNull.WL);
    }
}
