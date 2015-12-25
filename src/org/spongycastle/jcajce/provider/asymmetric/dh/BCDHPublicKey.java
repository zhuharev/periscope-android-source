// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.DHDomainParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCDHPublicKey
    implements DHPublicKey
{

    private transient DHParameterSpec aCH;
    private transient SubjectPublicKeyInfo aCK;
    private BigInteger axe;

    BCDHPublicKey(BigInteger biginteger, DHParameterSpec dhparameterspec)
    {
        axe = biginteger;
        aCH = dhparameterspec;
    }

    BCDHPublicKey(DHPublicKey dhpublickey)
    {
        axe = dhpublickey.getY();
        aCH = dhpublickey.getParams();
    }

    BCDHPublicKey(DHPublicKeySpec dhpublickeyspec)
    {
        axe = dhpublickeyspec.getY();
        aCH = new DHParameterSpec(dhpublickeyspec.getP(), dhpublickeyspec.getG());
    }

    public BCDHPublicKey(SubjectPublicKeyInfo subjectpublickeyinfo)
    {
        Object obj;
label0:
        {
label1:
            {
                boolean flag;
label2:
                {
                    super();
                    aCK = subjectpublickeyinfo;
                    try
                    {
                        obj = (ASN1Integer)(new ASN1InputStream(subjectpublickeyinfo.ajD.getBytes()))._mth04B7();
                    }
                    // Misplaced declaration of an exception variable
                    catch (SubjectPublicKeyInfo subjectpublickeyinfo)
                    {
                        throw new IllegalArgumentException("invalid info structure in DH public key");
                    }
                    axe = new BigInteger(((ASN1Integer) (obj)).bytes);
                    obj = ASN1Sequence._mth141F(subjectpublickeyinfo.aaK.ahQ);
                    subjectpublickeyinfo = new ASN1ObjectIdentifier(subjectpublickeyinfo.aaK.ahP.identifier);
                    if (subjectpublickeyinfo.equals(PKCSObjectIdentifiers.abl))
                    {
                        break label1;
                    }
                    if (((ASN1Sequence) (obj)).size() != 2)
                    {
                        if (((ASN1Sequence) (obj)).size() > 3)
                        {
                            flag = false;
                            break label2;
                        }
                        ASN1Integer asn1integer = ASN1Integer.FB1D(((ASN1Sequence) (obj))._mth144B(2));
                        ASN1Integer asn1integer1 = ASN1Integer.FB1D(((ASN1Sequence) (obj))._mth144B(0));
                        if ((new BigInteger(asn1integer.bytes)).compareTo(BigInteger.valueOf((new BigInteger(asn1integer1.bytes)).bitLength())) > 0)
                        {
                            flag = false;
                            break label2;
                        }
                    }
                    flag = true;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            obj = DHParameter._mth15EE(obj);
            if (((DHParameter) (obj)).aaI == null)
            {
                subjectpublickeyinfo = null;
            } else
            {
                subjectpublickeyinfo = new BigInteger(1, ((DHParameter) (obj)).aaI.bytes);
            }
            if (subjectpublickeyinfo != null)
            {
                BigInteger biginteger = new BigInteger(1, ((DHParameter) (obj)).Yq.bytes);
                BigInteger biginteger1 = new BigInteger(1, ((DHParameter) (obj)).aat.bytes);
                if (((DHParameter) (obj)).aaI == null)
                {
                    subjectpublickeyinfo = null;
                } else
                {
                    subjectpublickeyinfo = new BigInteger(1, ((DHParameter) (obj)).aaI.bytes);
                }
                aCH = new DHParameterSpec(biginteger, biginteger1, subjectpublickeyinfo.intValue());
                return;
            } else
            {
                aCH = new DHParameterSpec(new BigInteger(1, ((DHParameter) (obj)).Yq.bytes), new BigInteger(1, ((DHParameter) (obj)).aat.bytes));
                return;
            }
        }
        if (subjectpublickeyinfo.equals(X9ObjectIdentifiers.ams))
        {
            subjectpublickeyinfo = DHDomainParameters._mth02EE(((org.spongycastle.asn1.ASN1Encodable) (obj)));
            aCH = new DHParameterSpec(new BigInteger(((DHDomainParameters) (subjectpublickeyinfo)).Yq.bytes), new BigInteger(((DHDomainParameters) (subjectpublickeyinfo)).aat.bytes));
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown algorithm type: ")).append(subjectpublickeyinfo).toString());
        }
    }

    BCDHPublicKey(DHPublicKeyParameters dhpublickeyparameters)
    {
        axe = dhpublickeyparameters.axe;
        aCH = new DHParameterSpec(((DHKeyParameters) (dhpublickeyparameters)).axb.amM, ((DHKeyParameters) (dhpublickeyparameters)).axb.amO, ((DHKeyParameters) (dhpublickeyparameters)).axb.afM);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        aCH = new DHParameterSpec((BigInteger)objectinputstream.readObject(), (BigInteger)objectinputstream.readObject(), objectinputstream.readInt());
        aCK = null;
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
        if (!(obj instanceof DHPublicKey))
        {
            return false;
        }
        obj = (DHPublicKey)obj;
        return getY().equals(((DHPublicKey) (obj)).getY()) && getParams().getG().equals(((DHPublicKey) (obj)).getParams().getG()) && getParams().getP().equals(((DHPublicKey) (obj)).getParams().getP()) && getParams().getL() == ((DHPublicKey) (obj)).getParams().getL();
    }

    public String getAlgorithm()
    {
        return "DH";
    }

    public byte[] getEncoded()
    {
        if (aCK != null)
        {
            return KeyUtil._mth02CF(aCK);
        } else
        {
            return KeyUtil._mth02CA(new AlgorithmIdentifier(PKCSObjectIdentifiers.abl, (new DHParameter(aCH.getP(), aCH.getG(), aCH.getL()))._mth0427()), new ASN1Integer(axe));
        }
    }

    public String getFormat()
    {
        return "X.509";
    }

    public DHParameterSpec getParams()
    {
        return aCH;
    }

    public BigInteger getY()
    {
        return axe;
    }

    public int hashCode()
    {
        return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
    }
}
