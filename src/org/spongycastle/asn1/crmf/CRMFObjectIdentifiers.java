// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface CRMFObjectIdentifiers
{

    public static final ASN1ObjectIdentifier XH = asn1objectidentifier;
    public static final ASN1ObjectIdentifier XI = asn1objectidentifier;
    public static final ASN1ObjectIdentifier XJ = asn1objectidentifier;

    
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        asn1objectidentifier = new ASN1ObjectIdentifier(asn1objectidentifier, "5");
        asn1objectidentifier = new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        new ASN1ObjectIdentifier(XJ, "2");
        new ASN1ObjectIdentifier(XJ, "3");
        new ASN1ObjectIdentifier(XJ, "4");
        new ASN1ObjectIdentifier(PKCSObjectIdentifiers.acf, "21");
    }
}
