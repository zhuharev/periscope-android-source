// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.jce.spec.ElGamalPublicKeySpec;

public class BCElGamalPublicKey
    implements ElGamalPublicKey, DHPublicKey
{

    private transient ElGamalParameterSpec aDz;
    private BigInteger axe;

    BCElGamalPublicKey(DHPublicKey dhpublickey)
    {
        axe = dhpublickey.getY();
        aDz = new ElGamalParameterSpec(dhpublickey.getParams().getP(), dhpublickey.getParams().getG());
    }

    BCElGamalPublicKey(DHPublicKeySpec dhpublickeyspec)
    {
        axe = dhpublickeyspec.getY();
        aDz = new ElGamalParameterSpec(dhpublickeyspec.getP(), dhpublickeyspec.getG());
    }

    BCElGamalPublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        ElGamalParameter elgamalparameter = ElGamalParameter._mth1FBE(subjectpublickeyinfo.aaK.ahQ);
        try
        {
            subjectpublickeyinfo = (ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7();
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
        axe = new BigInteger(((ASN1Integer) (subjectpublickeyinfo)).bytes);
        aDz = new ElGamalParameterSpec(new BigInteger(1, elgamalparameter.Yq.bytes), new BigInteger(1, elgamalparameter.aat.bytes));
    }

    BCElGamalPublicKey(ElGamalPublicKeyParameters elgamalpublickeyparameters)
    {
        axe = elgamalpublickeyparameters.axe;
        aDz = new ElGamalParameterSpec(((ElGamalKeyParameters) (elgamalpublickeyparameters)).axl.amM, ((ElGamalKeyParameters) (elgamalpublickeyparameters)).axl.amO);
    }

    BCElGamalPublicKey(ElGamalPublicKey elgamalpublickey)
    {
        axe = elgamalpublickey.getY();
        aDz = elgamalpublickey._mth15AC();
    }

    BCElGamalPublicKey(ElGamalPublicKeySpec elgamalpublickeyspec)
    {
        axe = null;
        throw new NullPointerException();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aDz = new ElGamalParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(aDz.amM);
        objectoutputstream.writeObject(aDz.amO);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHPublicKey))
        {
            return false;
        }
        obj = (DHPublicKey)obj;
        return getY().equals(((DHPublicKey) (obj)).getY()) && getParams().getG().equals(((DHPublicKey) (obj)).getParams().getG()) && getParams().getP().equals(((DHPublicKey) (obj)).getParams().getP()) && getParams().getL() == ((DHPublicKey) (obj)).getParams().getL();
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
            abyte0 = (new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.aay, new ElGamalParameter(aDz.amM, aDz.amO)), new ASN1Integer(axe))).getEncoded("DER");
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
        return "X.509";
    }

    public DHParameterSpec getParams()
    {
        return new DHParameterSpec(aDz.amM, aDz.amO);
    }

    public BigInteger getY()
    {
        return axe;
    }

    public int hashCode()
    {
        return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
    }

    public final ElGamalParameterSpec _mth15AC()
    {
        return aDz;
    }
}
