// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.eac;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.eac:
//            PublicKeyDataObject, UnsignedInteger

public class ECDSAPublicKey extends PublicKeyDataObject
{

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.VS.addElement(null);
        Object obj = new UnsignedInteger(1, null);
        asn1encodablevector.VS.addElement(obj);
        obj = new UnsignedInteger(2, null);
        asn1encodablevector.VS.addElement(obj);
        obj = new UnsignedInteger(3, null);
        asn1encodablevector.VS.addElement(obj);
        obj = new DERTaggedObject(false, 4, new DEROctetString(null));
        asn1encodablevector.VS.addElement(obj);
        obj = new UnsignedInteger(5, null);
        asn1encodablevector.VS.addElement(obj);
        obj = new DERTaggedObject(false, 6, new DEROctetString(null));
        asn1encodablevector.VS.addElement(obj);
        obj = new UnsignedInteger(7, null);
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
