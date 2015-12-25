// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class AuthorityInformationAccess extends ASN1Object
{

    public String toString()
    {
        new StringBuilder("AuthorityInformationAccess: Oid(");
        throw new NullPointerException();
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        for (int i = 0; i != null.length; i++)
        {
            asn1encodablevector.VS.addElement(null);
        }

        return new DERSequence(asn1encodablevector);
    }
}
