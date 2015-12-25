// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class DHValidationParms extends ASN1Object
{

    public DERBitString akL;
    public ASN1Integer akM;

    private DHValidationParms(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            akL = DERBitString._mth14BD(asn1sequence._mth144B(0));
            akM = ASN1Integer.FB1D(asn1sequence._mth144B(1));
            return;
        }
    }

    public static DHValidationParms _mth02D1(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new DHValidationParms(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = akL;
        asn1encodablevector.VS.addElement(obj);
        obj = akM;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
