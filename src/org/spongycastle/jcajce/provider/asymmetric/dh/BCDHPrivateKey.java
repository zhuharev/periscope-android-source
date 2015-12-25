// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

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
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.DHDomainParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDHPrivateKey
    implements DHPrivateKey, PKCS12BagAttributeCarrier
{

    private transient DHParameterSpec aCH;
    private transient PrivateKeyInfo aCI;
    private transient PKCS12BagAttributeCarrierImpl aCJ;
    private BigInteger amZ;

    protected BCDHPrivateKey()
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    BCDHPrivateKey(DHPrivateKey dhprivatekey)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dhprivatekey.getX();
        aCH = dhprivatekey.getParams();
    }

    BCDHPrivateKey(DHPrivateKeySpec dhprivatekeyspec)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dhprivatekeyspec.getX();
        aCH = new DHParameterSpec(dhprivatekeyspec.getP(), dhprivatekeyspec.getG());
    }

    public BCDHPrivateKey(PrivateKeyInfo privatekeyinfo)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        Object obj = ASN1Sequence._mth141F(privatekeyinfo.aaK.ahQ);
        ASN1Integer asn1integer = (ASN1Integer)ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501());
        Object obj1 = new ASN1ObjectIdentifier(privatekeyinfo.aaK.ahP.identifier);
        aCI = privatekeyinfo;
        amZ = new BigInteger(asn1integer.bytes);
        if (((ASN1ObjectIdentifier) (obj1)).equals(PKCSObjectIdentifiers.abl))
        {
            obj = DHParameter._mth15EE(obj);
            if (((DHParameter) (obj)).aaI == null)
            {
                privatekeyinfo = null;
            } else
            {
                privatekeyinfo = new BigInteger(1, ((DHParameter) (obj)).aaI.bytes);
            }
            if (privatekeyinfo != null)
            {
                BigInteger biginteger = new BigInteger(1, ((DHParameter) (obj)).Yq.bytes);
                obj1 = new BigInteger(1, ((DHParameter) (obj)).aat.bytes);
                if (((DHParameter) (obj)).aaI == null)
                {
                    privatekeyinfo = null;
                } else
                {
                    privatekeyinfo = new BigInteger(1, ((DHParameter) (obj)).aaI.bytes);
                }
                aCH = new DHParameterSpec(biginteger, ((BigInteger) (obj1)), privatekeyinfo.intValue());
                return;
            } else
            {
                aCH = new DHParameterSpec(new BigInteger(1, ((DHParameter) (obj)).Yq.bytes), new BigInteger(1, ((DHParameter) (obj)).aat.bytes));
                return;
            }
        }
        if (((ASN1ObjectIdentifier) (obj1)).equals(X9ObjectIdentifiers.ams))
        {
            privatekeyinfo = DHDomainParameters._mth02EE(((ASN1Encodable) (obj)));
            aCH = new DHParameterSpec(new BigInteger(((DHDomainParameters) (privatekeyinfo)).Yq.bytes), new BigInteger(((DHDomainParameters) (privatekeyinfo)).aat.bytes));
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown algorithm type: ")).append(obj1).toString());
        }
    }

    BCDHPrivateKey(DHPrivateKeyParameters dhprivatekeyparameters)
    {
        aCJ = new PKCS12BagAttributeCarrierImpl();
        amZ = dhprivatekeyparameters.amZ;
        aCH = new DHParameterSpec(((DHKeyParameters) (dhprivatekeyparameters)).axb.amM, ((DHKeyParameters) (dhprivatekeyparameters)).axb.amO, ((DHKeyParameters) (dhprivatekeyparameters)).axb.afM);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aCH = new DHParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), objectinputstream.readInt());
        aCI = null;
        aCJ = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeObject(aCH.getP());
        objectoutputstream.writeObject(aCH.getG());
        objectoutputstream.writeInt(aCH.getL());
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
        return "DH";
    }

    public byte[] getEncoded()
    {
        byte abyte0[];
        if (aCI == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        abyte0 = aCI.getEncoded("DER");
        return abyte0;
        Exception exception;
        byte abyte1[];
        try
        {
            abyte1 = (new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.abl, (new DHParameter(aCH.getP(), aCH.getG(), aCH.getL()))._mth0427()), new ASN1Integer(getX()))).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return null;
        }
        return abyte1;
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public DHParameterSpec getParams()
    {
        return aCH;
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
}
