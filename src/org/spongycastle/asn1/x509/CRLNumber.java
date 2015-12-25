// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CRLNumber extends ASN1Object
{

    private BigInteger aio;

    public CRLNumber(BigInteger biginteger)
    {
        aio = biginteger;
    }

    public String toString()
    {
        return (new StringBuilder("CRLNumber: ")).append(aio).toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return new ASN1Integer(aio);
    }
}
