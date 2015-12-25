// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public class PolicyQualifierId extends ASN1ObjectIdentifier
{

    private PolicyQualifierId(String s)
    {
        super(s);
    }

    static 
    {
        new PolicyQualifierId("1.3.6.1.5.5.7.2.1");
        new PolicyQualifierId("1.3.6.1.5.5.7.2.2");
    }
}
