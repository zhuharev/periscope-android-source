// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;

public class SubjectKeyIdentifier extends ASN1Object
{

    public byte ajC[];

    public SubjectKeyIdentifier(byte abyte0[])
    {
        ajC = abyte0;
    }

    public final ASN1Primitive _mth0427()
    {
        return new DEROctetString(ajC);
    }
}
