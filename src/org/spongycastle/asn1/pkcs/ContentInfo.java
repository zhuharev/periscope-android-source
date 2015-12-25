// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DLSequence;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers

public class ContentInfo extends ASN1Object
    implements PKCSObjectIdentifiers
{

    private boolean aaA;
    public ASN1ObjectIdentifier aaG;
    public ASN1Encodable aaH;

    public ContentInfo(ASN1ObjectIdentifier asn1objectidentifier, ASN1Object asn1object)
    {
        aaA = true;
        aaG = asn1objectidentifier;
        aaH = asn1object;
    }

    private ContentInfo(ASN1Sequence asn1sequence)
    {
        aaA = true;
        Object obj = asn1sequence._mth0675();
        aaG = (ASN1ObjectIdentifier)((Enumeration) (obj)).nextElement();
        if (((Enumeration) (obj)).hasMoreElements())
        {
            obj = (ASN1TaggedObject)((Enumeration) (obj)).nextElement();
            if (((ASN1TaggedObject) (obj)).Wn != null)
            {
                obj = ((ASN1TaggedObject) (obj)).Wn._mth0427();
            } else
            {
                obj = null;
            }
            aaH = ((ASN1Encodable) (obj));
        }
        aaA = asn1sequence instanceof BERSequence;
    }

    public static ContentInfo _mth1508(Object obj)
    {
        if (obj instanceof ContentInfo)
        {
            return (ContentInfo)obj;
        }
        if (obj != null)
        {
            return new ContentInfo(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1ObjectIdentifier asn1objectidentifier = aaG;
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        if (aaH != null)
        {
            BERTaggedObject bertaggedobject = new BERTaggedObject(true, 0, aaH);
            asn1encodablevector.VS.addElement(bertaggedobject);
        }
        if (aaA)
        {
            return new BERSequence(asn1encodablevector);
        } else
        {
            return new DLSequence(asn1encodablevector);
        }
    }
}
