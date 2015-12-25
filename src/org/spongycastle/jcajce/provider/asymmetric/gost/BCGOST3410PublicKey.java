// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeySpec;

public class BCGOST3410PublicKey
    implements GOST3410PublicKey
{

    private transient GOST3410Params aDF;
    private BigInteger axe;

    BCGOST3410PublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        GOST3410PublicKeyAlgParameters gost3410publickeyalgparameters;
        gost3410publickeyalgparameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence)subjectpublickeyinfo.aaK.ahQ);
        byte abyte0[];
        int i;
        try
        {
            subjectpublickeyinfo = ((DEROctetString)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7())._mth0501();
            abyte0 = new byte[subjectpublickeyinfo.length];
        }
        // Misplaced declaration of an exception variable
        catch (SubjectPublicKeyInfo subjectpublickeyinfo)
        {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
        i = 0;
        if (i == subjectpublickeyinfo.length)
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0[i] = subjectpublickeyinfo[subjectpublickeyinfo.length - 1 - i];
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_54;
_L1:
        axe = new BigInteger(1, abyte0);
        aDF = GOST3410ParameterSpec._mth02CA(gost3410publickeyalgparameters);
        return;
    }

    BCGOST3410PublicKey(GOST3410PublicKeyParameters gost3410publickeyparameters, GOST3410ParameterSpec gost3410parameterspec)
    {
        axe = gost3410publickeyparameters.axe;
        aDF = gost3410parameterspec;
    }

    BCGOST3410PublicKey(GOST3410PublicKey gost3410publickey)
    {
        axe = gost3410publickey.getY();
        aDF = gost3410publickey._mth15BD();
    }

    BCGOST3410PublicKey(GOST3410PublicKeySpec gost3410publickeyspec)
    {
        axe = gost3410publickeyspec.axe;
        aDF = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gost3410publickeyspec.amM, gost3410publickeyspec.amN, gost3410publickeyspec.amW));
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        String s = (String)objectinputstream.readObject();
        if (s != null)
        {
            aDF = new GOST3410ParameterSpec(s, (String)objectinputstream.readObject(), (String)objectinputstream.readObject());
            return;
        } else
        {
            aDF = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject()));
            objectinputstream.readObject();
            objectinputstream.readObject();
            return;
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        if (aDF._mth1D1D() != null)
        {
            objectoutputstream.writeObject(aDF._mth1D1D());
            objectoutputstream.writeObject(aDF._mth1D26());
            objectoutputstream.writeObject(aDF._mth1D29());
            return;
        } else
        {
            objectoutputstream.writeObject(null);
            objectoutputstream.writeObject(aDF._mth1D2D().amM);
            objectoutputstream.writeObject(aDF._mth1D2D().amN);
            objectoutputstream.writeObject(aDF._mth1D2D().amW);
            objectoutputstream.writeObject(aDF._mth1D26());
            objectoutputstream.writeObject(aDF._mth1D29());
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof BCGOST3410PublicKey)
        {
            obj = (BCGOST3410PublicKey)obj;
            return axe.equals(((BCGOST3410PublicKey) (obj)).axe) && aDF.equals(((BCGOST3410PublicKey) (obj)).aDF);
        } else
        {
            return false;
        }
    }

    public String getAlgorithm()
    {
        return "GOST3410";
    }

    public byte[] getEncoded()
    {
        Object obj;
        byte abyte1[] = axe.toByteArray();
        if (abyte1[0] == 0)
        {
            obj = new byte[abyte1.length - 1];
        } else
        {
            obj = new byte[abyte1.length];
        }
        for (int i = 0; i != obj.length; i++)
        {
            obj[i] = abyte1[abyte1.length - 1 - i];
        }

        if (aDF instanceof GOST3410ParameterSpec)
        {
            if (aDF._mth1D29() != null)
            {
                obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XV, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(aDF._mth1D1D()), new ASN1ObjectIdentifier(aDF._mth1D26()), new ASN1ObjectIdentifier(aDF._mth1D29()))), new DEROctetString(((byte []) (obj))));
                break MISSING_BLOCK_LABEL_255;
            }
            byte abyte0[];
            try
            {
                obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XV, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(aDF._mth1D1D()), new ASN1ObjectIdentifier(aDF._mth1D26()))), new DEROctetString(((byte []) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
            break MISSING_BLOCK_LABEL_255;
        }
        obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XV), new DEROctetString(((byte []) (obj))));
        abyte0 = KeyUtil._mth02CF(((SubjectPublicKeyInfo) (obj)));
        IOException ioexception;
        return abyte0;
    }

    public String getFormat()
    {
        return "X.509";
    }

    public final BigInteger getY()
    {
        return axe;
    }

    public int hashCode()
    {
        return axe.hashCode() ^ aDF.hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("GOST3410 Public Key").append(s);
        stringbuffer.append("            y: ").append(axe.toString(16)).append(s);
        return stringbuffer.toString();
    }

    public final GOST3410Params _mth15BD()
    {
        return aDF;
    }
}
