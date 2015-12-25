// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AlgorithmIdentifier

public class DigestInfo extends ASN1Object
{

    public AlgorithmIdentifier aaK;
    public byte aiy[];

    private DigestInfo(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        aaK = AlgorithmIdentifier._mth01C3(asn1sequence.nextElement());
        aiy = ASN1OctetString.FB39(asn1sequence.nextElement())._mth0501();
    }

    public DigestInfo(AlgorithmIdentifier algorithmidentifier, byte abyte0[])
    {
        aiy = abyte0;
        aaK = algorithmidentifier;
    }

    public static DigestInfo _mth2071(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof DigestInfo)
        {
            return (DigestInfo)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new DigestInfo(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaK;
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aiy);
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
