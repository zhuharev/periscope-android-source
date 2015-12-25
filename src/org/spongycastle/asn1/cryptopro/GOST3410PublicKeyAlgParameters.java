// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cryptopro;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters extends ASN1Object
{

    public ASN1ObjectIdentifier Yt;
    public ASN1ObjectIdentifier Yu;
    public ASN1ObjectIdentifier Yv;

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier asn1objectidentifier, ASN1ObjectIdentifier asn1objectidentifier1)
    {
        Yt = asn1objectidentifier;
        Yu = asn1objectidentifier1;
        Yv = null;
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier asn1objectidentifier, ASN1ObjectIdentifier asn1objectidentifier1, ASN1ObjectIdentifier asn1objectidentifier2)
    {
        Yt = asn1objectidentifier;
        Yu = asn1objectidentifier1;
        Yv = asn1objectidentifier2;
    }

    public GOST3410PublicKeyAlgParameters(ASN1Sequence asn1sequence)
    {
        Yt = (ASN1ObjectIdentifier)asn1sequence._mth144B(0);
        Yu = (ASN1ObjectIdentifier)asn1sequence._mth144B(1);
        if (asn1sequence.size() > 2)
        {
            Yv = (ASN1ObjectIdentifier)asn1sequence._mth144B(2);
        }
    }

    public static GOST3410PublicKeyAlgParameters _mth02BD(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof GOST3410PublicKeyAlgParameters)
        {
            return (GOST3410PublicKeyAlgParameters)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new GOST3410PublicKeyAlgParameters(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1ObjectIdentifier asn1objectidentifier = Yt;
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        asn1objectidentifier = Yu;
        asn1encodablevector.VS.addElement(asn1objectidentifier);
        if (Yv != null)
        {
            ASN1ObjectIdentifier asn1objectidentifier1 = Yv;
            asn1encodablevector.VS.addElement(asn1objectidentifier1);
        }
        return new DERSequence(asn1encodablevector);
    }
}
