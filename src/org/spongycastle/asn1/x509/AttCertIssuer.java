// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            V2Form, GeneralNames

public class AttCertIssuer extends ASN1Object
    implements ASN1Choice
{

    public ASN1Object ahS;
    private ASN1Primitive ahT;

    private AttCertIssuer(GeneralNames generalnames)
    {
        ahS = generalnames;
        ahT = ahS._mth0427();
    }

    private AttCertIssuer(V2Form v2form)
    {
        ahS = v2form;
        ahT = new DERTaggedObject(false, 0, ahS);
    }

    public static AttCertIssuer _mth05D9(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof AttCertIssuer))
        {
            return (AttCertIssuer)asn1encodable;
        }
        if (asn1encodable instanceof V2Form)
        {
            return new AttCertIssuer(V2Form._mth15AE(asn1encodable));
        }
        if (asn1encodable instanceof GeneralNames)
        {
            return new AttCertIssuer((GeneralNames)asn1encodable);
        }
        if (asn1encodable instanceof ASN1TaggedObject)
        {
            return new AttCertIssuer(V2Form._mth02CD((ASN1TaggedObject)asn1encodable, false));
        }
        if (asn1encodable instanceof ASN1Sequence)
        {
            return new AttCertIssuer(GeneralNames._mth05D5(asn1encodable));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in factory: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return ahT;
    }
}
