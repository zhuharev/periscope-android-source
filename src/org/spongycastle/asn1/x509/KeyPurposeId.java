// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

// Referenced classes of package org.spongycastle.asn1.x509:
//            Extension

public class KeyPurposeId extends ASN1Object
{

    private static final ASN1ObjectIdentifier ajr;
    private ASN1ObjectIdentifier ajs;

    private KeyPurposeId(ASN1ObjectIdentifier asn1objectidentifier)
    {
        ajs = asn1objectidentifier;
    }

    public final ASN1Primitive _mth0427()
    {
        return ajs;
    }

    static 
    {
        ajr = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.3");
        new KeyPurposeId(new ASN1ObjectIdentifier(Extension.aiS, "0"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "1"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "2"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "3"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "4"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "5"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "6"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "7"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "8"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "9"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "10"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "11"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "12"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "13"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "14"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "15"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "16"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "17"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "18"));
        new KeyPurposeId(new ASN1ObjectIdentifier(ajr, "19"));
        new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.2"));
    }
}
