// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cmp;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class PollRepContent extends ASN1Object
{

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        for (int i = 0; i != null.length; i++)
        {
            Object obj = new ASN1EncodableVector();
            ((ASN1EncodableVector) (obj)).VS.addElement(null);
            ((ASN1EncodableVector) (obj)).VS.addElement(null);
            obj = new DERSequence(((ASN1EncodableVector) (obj)));
            asn1encodablevector.VS.addElement(obj);
        }

        return new DERSequence(asn1encodablevector);
    }
}
