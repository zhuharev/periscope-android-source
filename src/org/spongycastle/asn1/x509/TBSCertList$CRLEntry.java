// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            TBSCertList, Extensions

public static class adC extends ASN1Object
{

    public ASN1Sequence adC;
    private Extensions ajJ;

    public static adC _mth1424(Object obj)
    {
        if (obj instanceof adC)
        {
            return (adC)obj;
        }
        if (obj != null)
        {
            return new <init>(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }

    public final Extensions _mth142F()
    {
        if (ajJ == null && adC.size() == 3)
        {
            ajJ = Extensions.FE7A(adC._mth144B(2));
        }
        return ajJ;
    }

    private (ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() < 2 || asn1sequence.size() > 3)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        } else
        {
            adC = asn1sequence;
            return;
        }
    }
}
