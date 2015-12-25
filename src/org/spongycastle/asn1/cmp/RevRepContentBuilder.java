// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;

public class RevRepContentBuilder
{

    private ASN1EncodableVector XA;
    private ASN1EncodableVector XB;
    private ASN1EncodableVector Xz;

    public RevRepContentBuilder()
    {
        Xz = new ASN1EncodableVector();
        XA = new ASN1EncodableVector();
        XB = new ASN1EncodableVector();
    }
}
