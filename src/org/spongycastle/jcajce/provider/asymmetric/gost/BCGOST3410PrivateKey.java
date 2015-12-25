// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PrivateKeySpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class BCGOST3410PrivateKey
    implements GOST3410PrivateKey, PKCS12BagAttributeCarrier
{

    private transient GOST3410Params aDF;
    private transient PKCS12BagAttributeCarrierImpl aDG;
    private BigInteger amZ;

    protected BCGOST3410PrivateKey()
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
    }

    BCGOST3410PrivateKey(PrivateKeyInfo privatekeyinfo)
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
        GOST3410PublicKeyAlgParameters gost3410publickeyalgparameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence)privatekeyinfo.aaK.ahQ);
        privatekeyinfo = ASN1OctetString.FB39(ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501()))._mth0501();
        byte abyte0[] = new byte[privatekeyinfo.length];
        for (int i = 0; i != privatekeyinfo.length; i++)
        {
            abyte0[i] = privatekeyinfo[privatekeyinfo.length - 1 - i];
        }

        amZ = new BigInteger(1, abyte0);
        aDF = GOST3410ParameterSpec._mth02CA(gost3410publickeyalgparameters);
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeyParameters gost3410privatekeyparameters, GOST3410ParameterSpec gost3410parameterspec)
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
        amZ = gost3410privatekeyparameters.amZ;
        aDF = gost3410parameterspec;
        if (gost3410parameterspec == null)
        {
            throw new IllegalArgumentException("spec is null");
        } else
        {
            return;
        }
    }

    BCGOST3410PrivateKey(GOST3410PrivateKey gost3410privatekey)
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
        amZ = gost3410privatekey.getX();
        aDF = gost3410privatekey._mth15BD();
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeySpec gost3410privatekeyspec)
    {
        aDG = new PKCS12BagAttributeCarrierImpl();
        amZ = gost3410privatekeyspec.amZ;
        aDF = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gost3410privatekeyspec.amM, gost3410privatekeyspec.amN, gost3410privatekeyspec.amW));
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        String s = (String)objectinputstream.readObject();
        if (s != null)
        {
            aDF = new GOST3410ParameterSpec(s, (String)objectinputstream.readObject(), (String)objectinputstream.readObject());
        } else
        {
            aDF = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject()));
            objectinputstream.readObject();
            objectinputstream.readObject();
        }
        aDG = new PKCS12BagAttributeCarrierImpl();
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
        if (!(obj instanceof GOST3410PrivateKey))
        {
            return false;
        }
        Object obj1 = (GOST3410PrivateKey)obj;
        if (amZ.equals(((GOST3410PrivateKey) (obj1)).getX()) && aDF._mth1D2D().equals(((GOST3410PrivateKey) (obj1))._mth15BD()._mth1D2D()) && aDF._mth1D26().equals(((GOST3410PrivateKey) (obj1))._mth15BD()._mth1D26()))
        {
            obj = aDF._mth1D29();
            obj1 = ((GOST3410PrivateKey) (obj1))._mth15BD()._mth1D29();
            boolean flag;
            if (obj == obj1)
            {
                flag = true;
            } else
            if (obj == null)
            {
                flag = false;
            } else
            {
                flag = obj.equals(obj1);
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public String getAlgorithm()
    {
        return "GOST3410";
    }

    public byte[] getEncoded()
    {
        byte abyte1[] = amZ.toByteArray();
        Object obj;
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

        byte abyte0[];
        try
        {
            if (aDF instanceof GOST3410ParameterSpec)
            {
                obj = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XV, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(aDF._mth1D1D()), new ASN1ObjectIdentifier(aDF._mth1D26()))), new DEROctetString(((byte []) (obj))));
                break MISSING_BLOCK_LABEL_159;
            }
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return null;
        }
        obj = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XV), new DEROctetString(((byte []) (obj))));
        abyte0 = ((PrivateKeyInfo) (obj)).getEncoded("DER");
        IOException ioexception;
        return abyte0;
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public final BigInteger getX()
    {
        return amZ;
    }

    public int hashCode()
    {
        return amZ.hashCode() ^ aDF.hashCode();
    }

    public final ASN1Encodable _mth02BC(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return aDG._mth02BC(asn1objectidentifier);
    }

    public final void _mth02CA(ASN1ObjectIdentifier asn1objectidentifier, ASN1Encodable asn1encodable)
    {
        aDG._mth02CA(asn1objectidentifier, asn1encodable);
    }

    public final Enumeration _mth152C()
    {
        return aDG._mth152C();
    }

    public final GOST3410Params _mth15BD()
    {
        return aDF;
    }
}
