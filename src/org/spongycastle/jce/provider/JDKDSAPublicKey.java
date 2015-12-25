// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public class JDKDSAPublicKey
    implements DSAPublicKey
{

    private DSAParameterSpec aHw;
    private BigInteger axe;

    private void readObject(ObjectInputStream objectinputstream)
    {
        axe = (BigInteger)objectinputstream.readObject();
        aHw = new DSAParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(axe);
        objectoutputstream.writeObject(aHw.getP());
        objectoutputstream.writeObject(aHw.getQ());
        objectoutputstream.writeObject(aHw.getG());
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DSAPublicKey))
        {
            return false;
        }
        obj = (DSAPublicKey)obj;
        return getY().equals(((DSAPublicKey) (obj)).getY()) && getParams().getG().equals(((DSAPublicKey) (obj)).getParams().getG()) && getParams().getP().equals(((DSAPublicKey) (obj)).getParams().getP()) && getParams().getQ().equals(((DSAPublicKey) (obj)).getParams().getQ());
    }

    public String getAlgorithm()
    {
        return "DSA";
    }

    public byte[] getEncoded()
    {
        byte abyte0[];
        if (aHw != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        abyte0 = (new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.amm), new ASN1Integer(axe))).getEncoded("DER");
        return abyte0;
        IOException ioexception;
        byte abyte1[];
        try
        {
            abyte1 = (new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.amm, new DSAParameter(aHw.getP(), aHw.getQ(), aHw.getG())), new ASN1Integer(axe))).getEncoded("DER");
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
        return "X.509";
    }

    public DSAParams getParams()
    {
        return aHw;
    }

    public BigInteger getY()
    {
        return axe;
    }

    public int hashCode()
    {
        return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("DSA Public Key").append(s);
        stringbuffer.append("            y: ").append(getY().toString(16)).append(s);
        return stringbuffer.toString();
    }
}
