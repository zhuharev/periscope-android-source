// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class PKIStatus extends ASN1Object
{

    private ASN1Integer Xy;

    private PKIStatus(int i)
    {
        this(new ASN1Integer(i));
    }

    private PKIStatus(ASN1Integer asn1integer)
    {
        Xy = asn1integer;
    }

    public final ASN1Primitive _mth0427()
    {
        return Xy;
    }

    static 
    {
        new PKIStatus(0);
        new PKIStatus(1);
        new PKIStatus(2);
        new PKIStatus(3);
        new PKIStatus(4);
        new PKIStatus(5);
        new PKIStatus(6);
    }
}
