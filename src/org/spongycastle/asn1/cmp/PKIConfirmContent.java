// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

public class PKIConfirmContent extends ASN1Object
{

    private DERNull Xx;

    public PKIConfirmContent()
    {
        Xx = DERNull.WL;
    }

    public final ASN1Primitive _mth0427()
    {
        return Xx;
    }
}
