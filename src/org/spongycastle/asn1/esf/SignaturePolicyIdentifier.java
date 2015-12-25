// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

public class SignaturePolicyIdentifier extends ASN1Object
{

    private boolean YV;

    public SignaturePolicyIdentifier()
    {
        YV = true;
    }

    public final ASN1Primitive _mth0427()
    {
        if (YV)
        {
            return DERNull.WL;
        } else
        {
            throw new NullPointerException();
        }
    }
}
