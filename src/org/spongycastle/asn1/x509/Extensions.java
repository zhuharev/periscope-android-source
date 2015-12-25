// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Extension

public class Extensions extends ASN1Object
{

    public Hashtable aiY;
    public Vector aiZ;

    private Extensions(ASN1Sequence asn1sequence)
    {
        aiY = new Hashtable();
        aiZ = new Vector();
        Extension extension;
        for (asn1sequence = asn1sequence._mth0675(); asn1sequence.hasMoreElements(); aiZ.addElement(extension.aiV))
        {
            extension = Extension._mth02D0(asn1sequence.nextElement());
            aiY.put(extension.aiV, extension);
        }

    }

    public static Extensions FE7A(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof Extensions)
        {
            return (Extensions)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new Extensions(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj;
        for (Enumeration enumeration = aiZ.elements(); enumeration.hasMoreElements(); asn1encodablevector.VS.addElement(obj))
        {
            obj = (ASN1ObjectIdentifier)enumeration.nextElement();
            obj = (Extension)aiY.get(obj);
        }

        return new DERSequence(asn1encodablevector);
    }
}
