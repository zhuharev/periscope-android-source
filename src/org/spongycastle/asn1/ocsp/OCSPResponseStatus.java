// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class OCSPResponseStatus extends ASN1Object
{

    private ASN1Enumerated YC;

    private OCSPResponseStatus(ASN1Enumerated asn1enumerated)
    {
        YC = asn1enumerated;
    }

    public static OCSPResponseStatus _mth037A(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof OCSPResponseStatus)
        {
            return (OCSPResponseStatus)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new OCSPResponseStatus(ASN1Enumerated._mth1D63(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return YC;
    }
}
