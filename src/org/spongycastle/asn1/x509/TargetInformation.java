// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class TargetInformation extends ASN1Object
{

    public ASN1Sequence ajV;

    private TargetInformation(ASN1Sequence asn1sequence)
    {
        ajV = asn1sequence;
    }

    public static TargetInformation _mth02C9(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new TargetInformation(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return ajV;
    }
}
