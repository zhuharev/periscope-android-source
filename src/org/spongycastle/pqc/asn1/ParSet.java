// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.asn1;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ParSet extends ASN1Object
{

    private int aJP;
    private int aKc[];
    private int aKd[];
    private int aKe[];

    public ParSet(int i, int ai[], int ai1[], int ai2[])
    {
        aJP = i;
        aKc = ai;
        aKd = ai1;
        aKe = ai2;
    }

    public final ASN1Primitive _mth0427()
    {
        Object obj2 = new ASN1EncodableVector();
        Object obj1 = new ASN1EncodableVector();
        Object obj = new ASN1EncodableVector();
        for (int i = 0; i < aKc.length; i++)
        {
            ASN1Integer asn1integer = new ASN1Integer(aKc[i]);
            ((ASN1EncodableVector) (obj2)).VS.addElement(asn1integer);
            asn1integer = new ASN1Integer(aKd[i]);
            ((ASN1EncodableVector) (obj1)).VS.addElement(asn1integer);
            asn1integer = new ASN1Integer(aKe[i]);
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1integer);
        }

        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer1 = new ASN1Integer(aJP);
        asn1encodablevector.VS.addElement(asn1integer1);
        obj2 = new DERSequence(((ASN1EncodableVector) (obj2)));
        asn1encodablevector.VS.addElement(obj2);
        obj1 = new DERSequence(((ASN1EncodableVector) (obj1)));
        asn1encodablevector.VS.addElement(obj1);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        BigInteger.valueOf(0L);
    }
}
