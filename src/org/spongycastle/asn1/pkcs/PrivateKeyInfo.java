// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Object
{

    public AlgorithmIdentifier aaK;
    public ASN1OctetString acY;
    private ASN1Set acZ;

    private PrivateKeyInfo(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        if ((new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes)).intValue() != 0)
        {
            throw new IllegalArgumentException("wrong version for private key info");
        }
        aaK = AlgorithmIdentifier._mth01C3(asn1sequence.nextElement());
        acY = ASN1OctetString.FB39(asn1sequence.nextElement());
        if (asn1sequence.hasMoreElements())
        {
            acZ = ASN1Set._mth02BB((ASN1TaggedObject)asn1sequence.nextElement(), false);
        }
    }

    private PrivateKeyInfo(AlgorithmIdentifier algorithmidentifier, ASN1Encodable asn1encodable, ASN1Set asn1set)
    {
        acY = new DEROctetString(asn1encodable._mth0427().getEncoded("DER"));
        aaK = algorithmidentifier;
        acZ = null;
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmidentifier, ASN1Object asn1object)
    {
        this(algorithmidentifier, ((ASN1Encodable) (asn1object)), null);
    }

    public static PrivateKeyInfo _mth1D38(Object obj)
    {
        if (obj instanceof PrivateKeyInfo)
        {
            return (PrivateKeyInfo)obj;
        }
        if (obj != null)
        {
            return new PrivateKeyInfo(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new ASN1Integer(0L);
        asn1encodablevector.VS.addElement(obj);
        obj = aaK;
        asn1encodablevector.VS.addElement(obj);
        obj = acY;
        asn1encodablevector.VS.addElement(obj);
        if (acZ != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, acZ);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        return new DERSequence(asn1encodablevector);
    }
}
