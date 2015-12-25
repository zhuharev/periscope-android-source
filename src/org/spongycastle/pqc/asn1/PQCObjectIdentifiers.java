// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface PQCObjectIdentifiers
{

    public static final ASN1ObjectIdentifier aJU = asn1objectidentifier;
    public static final ASN1ObjectIdentifier aJV = new ASN1ObjectIdentifier(aJU, "2");
    public static final ASN1ObjectIdentifier aJW = new ASN1ObjectIdentifier(aJU, "3");
    public static final ASN1ObjectIdentifier aJX = new ASN1ObjectIdentifier(aJU, "4");
    public static final ASN1ObjectIdentifier aJY = new ASN1ObjectIdentifier(aJU, "5");
    public static final ASN1ObjectIdentifier aJZ = asn1objectidentifier;
    public static final ASN1ObjectIdentifier aKa = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    public static final ASN1ObjectIdentifier aKb = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");

    
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        asn1objectidentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.3");
        new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        new ASN1ObjectIdentifier(aJZ, "2");
        new ASN1ObjectIdentifier(aJZ, "3");
        new ASN1ObjectIdentifier(aJZ, "4");
        new ASN1ObjectIdentifier(aJZ, "5");
    }
}
