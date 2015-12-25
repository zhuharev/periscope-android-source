// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;

public class V2AttributeCertificateInfoGenerator
{

    private ASN1Integer ada;
    private ASN1EncodableVector ajY;

    public V2AttributeCertificateInfoGenerator()
    {
        ada = new ASN1Integer(1L);
        ajY = new ASN1EncodableVector();
    }
}
