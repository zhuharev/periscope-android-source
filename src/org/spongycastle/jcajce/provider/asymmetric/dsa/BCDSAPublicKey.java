// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCDSAPublicKey
    implements DSAPublicKey
{

    private transient DSAParams aCY;
    private BigInteger axe;

    BCDSAPublicKey(DSAPublicKey dsapublickey)
    {
        axe = dsapublickey.getY();
        aCY = dsapublickey.getParams();
    }

    BCDSAPublicKey(DSAPublicKeySpec dsapublickeyspec)
    {
        axe = dsapublickeyspec.getY();
        aCY = new DSAParameterSpec(dsapublickeyspec.getP(), dsapublickeyspec.getQ(), dsapublickeyspec.getG());
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        Object obj;
        try
        {
            obj = (ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7();
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
        axe = new BigInteger(((ASN1Integer) (obj)).bytes);
        obj = subjectpublickeyinfo.aaK.ahQ;
        boolean flag;
        if (obj != null && !DERNull.WL.equals(((ASN1Encodable) (obj))._mth0427()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            subjectpublickeyinfo = DSAParameter._mth1D62(subjectpublickeyinfo.aaK.ahQ);
            aCY = new DSAParameterSpec(new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).Yq.bytes), new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).Yr.bytes), new BigInteger(1, ((DSAParameter) (subjectpublickeyinfo)).aat.bytes));
        }
    }

    BCDSAPublicKey(DSAPublicKeyParameters dsapublickeyparameters)
    {
        axe = dsapublickeyparameters.axe;
        aCY = new DSAParameterSpec(((DSAKeyParameters) (dsapublickeyparameters)).axf.amM, ((DSAKeyParameters) (dsapublickeyparameters)).axf.amN, ((DSAKeyParameters) (dsapublickeyparameters)).axf.amO);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aCY = new DSAParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
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
        if (aCY == null)
        {
            return KeyUtil._mth02CA(new AlgorithmIdentifier(X9ObjectIdentifiers.amm), new ASN1Integer(axe));
        } else
        {
            return KeyUtil._mth02CA(new AlgorithmIdentifier(X9ObjectIdentifiers.amm, (new DSAParameter(aCY.getP(), aCY.getQ(), aCY.getG()))._mth0427()), new ASN1Integer(axe));
        }
    }

    public String getFormat()
    {
        return "X.509";
    }

    public DSAParams getParams()
    {
        return aCY;
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
