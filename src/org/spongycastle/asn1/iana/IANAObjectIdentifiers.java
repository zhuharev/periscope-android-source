// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.iana;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface IANAObjectIdentifiers
{

    public static final ASN1ObjectIdentifier YX = asn1objectidentifier;
    public static final ASN1ObjectIdentifier YY = new ASN1ObjectIdentifier(YX, "5");
    public static final ASN1ObjectIdentifier YZ = new ASN1ObjectIdentifier(YY, "5");
    public static final ASN1ObjectIdentifier Za = asn1objectidentifier;
    public static final ASN1ObjectIdentifier Zb = asn1objectidentifier;
    public static final ASN1ObjectIdentifier Zc = new ASN1ObjectIdentifier(asn1objectidentifier, "1");
    public static final ASN1ObjectIdentifier Zd = new ASN1ObjectIdentifier(Zb, "2");
    public static final ASN1ObjectIdentifier Ze = new ASN1ObjectIdentifier(Zb, "3");
    public static final ASN1ObjectIdentifier Zf = new ASN1ObjectIdentifier(Zb, "4");

    
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier("1.3.6.1");
        new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        new ASN1ObjectIdentifier(YX, "2");
        new ASN1ObjectIdentifier(YX, "3");
        new ASN1ObjectIdentifier(YX, "4");
        new ASN1ObjectIdentifier(YX, "6");
        new ASN1ObjectIdentifier(YX, "7");
        new ASN1ObjectIdentifier(YY, "6");
        new ASN1ObjectIdentifier(YZ, "6");
        asn1objectidentifier = new ASN1ObjectIdentifier(YZ, "8");
        asn1objectidentifier = new ASN1ObjectIdentifier(asn1objectidentifier, "1");
    }
}
