// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class DHPublicKey extends ASN1Object
{

    public ASN1Integer akK;

    private DHPublicKey(ASN1Integer asn1integer)
    {
        if (asn1integer == null)
        {
            throw new IllegalArgumentException("'y' cannot be null");
        } else
        {
            akK = asn1integer;
            return;
        }
    }

    public static DHPublicKey _mth02CD(ASN1Primitive asn1primitive)
    {
        if (asn1primitive == null)
        {
            return (DHPublicKey)asn1primitive;
        }
        if (asn1primitive instanceof ASN1Integer)
        {
            return new DHPublicKey((ASN1Integer)asn1primitive);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid DHPublicKey: ")).append(asn1primitive.getClass().getName()).toString());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return akK;
    }
}
