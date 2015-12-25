// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.dvcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class DVCSRequestInformation extends ASN1Object
{

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("DVCSRequestInformation {\n");
        stringbuffer.append((new StringBuilder("version: ")).append(0).append("\n").toString());
        stringbuffer.append((new StringBuilder("service: ")).append(null).append("\n").toString());
        stringbuffer.append("}\n");
        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(0L);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1encodablevector.VS.addElement(null);
        for (int i = 0; i < 5; i++)
        {
            int j = (new int[] {
                0, 1, 2, 3, 4
            })[i];
            Object obj = (new ASN1Encodable[] {
                null, null, null, null, null
            })[i];
            if (obj != null)
            {
                obj = new DERTaggedObject(false, j, ((ASN1Encodable) (obj)));
                asn1encodablevector.VS.addElement(obj);
            }
        }

        return new DERSequence(asn1encodablevector);
    }
}
