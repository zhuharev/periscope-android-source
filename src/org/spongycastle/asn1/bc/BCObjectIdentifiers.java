// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface BCObjectIdentifiers
{

    public static final ASN1ObjectIdentifier Xc = asn1objectidentifier;
    public static final ASN1ObjectIdentifier Xd = asn1objectidentifier;
    public static final ASN1ObjectIdentifier Xe = new ASN1ObjectIdentifier(asn1objectidentifier, "1");
    public static final ASN1ObjectIdentifier Xf = new ASN1ObjectIdentifier(Xd, "2.1");
    public static final ASN1ObjectIdentifier Xg = new ASN1ObjectIdentifier(Xe, "2");
    public static final ASN1ObjectIdentifier Xh = new ASN1ObjectIdentifier(Xf, "2");
    public static final ASN1ObjectIdentifier Xi = new ASN1ObjectIdentifier(Xg, "1.2");
    public static final ASN1ObjectIdentifier Xj = new ASN1ObjectIdentifier(Xg, "1.22");
    public static final ASN1ObjectIdentifier Xk = new ASN1ObjectIdentifier(Xg, "1.42");
    public static final ASN1ObjectIdentifier Xl = new ASN1ObjectIdentifier(Xh, "1.2");
    public static final ASN1ObjectIdentifier Xm = new ASN1ObjectIdentifier(Xh, "1.22");
    public static final ASN1ObjectIdentifier Xn = new ASN1ObjectIdentifier(Xh, "1.42");

    
    {
        ASN1ObjectIdentifier asn1objectidentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        asn1objectidentifier = new ASN1ObjectIdentifier(asn1objectidentifier, "1");
        new ASN1ObjectIdentifier(Xd, "2.2");
        new ASN1ObjectIdentifier(Xd, "2.3");
        new ASN1ObjectIdentifier(Xd, "2.4");
        new ASN1ObjectIdentifier(Xe, "1");
        new ASN1ObjectIdentifier(Xf, "1");
    }
}
