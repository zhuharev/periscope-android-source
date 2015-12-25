// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;

public class X509Extension
{

    public static final ASN1ObjectIdentifier aiI = new ASN1ObjectIdentifier("2.5.29.21");
    public static final ASN1ObjectIdentifier aiL = new ASN1ObjectIdentifier("2.5.29.29");
    boolean aiW;
    ASN1OctetString aiX;

    public X509Extension(ASN1Boolean asn1boolean, ASN1OctetString asn1octetstring)
    {
        boolean flag;
        if (asn1boolean.VP[0] != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aiW = flag;
        aiX = asn1octetstring;
    }

    public X509Extension(boolean flag, ASN1OctetString asn1octetstring)
    {
        aiW = false;
        aiX = asn1octetstring;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof X509Extension))
        {
            return false;
        }
        obj = (X509Extension)obj;
        return ((X509Extension) (obj)).aiX.equals(aiX) && ((X509Extension) (obj)).aiW == aiW;
    }

    public int hashCode()
    {
        if (aiW)
        {
            return aiX.hashCode();
        } else
        {
            return ~aiX.hashCode();
        }
    }

    static 
    {
        new ASN1ObjectIdentifier("2.5.29.9");
        new ASN1ObjectIdentifier("2.5.29.14");
        new ASN1ObjectIdentifier("2.5.29.15");
        new ASN1ObjectIdentifier("2.5.29.16");
        new ASN1ObjectIdentifier("2.5.29.17");
        new ASN1ObjectIdentifier("2.5.29.18");
        new ASN1ObjectIdentifier("2.5.29.19");
        new ASN1ObjectIdentifier("2.5.29.20");
        new ASN1ObjectIdentifier("2.5.29.23");
        new ASN1ObjectIdentifier("2.5.29.24");
        new ASN1ObjectIdentifier("2.5.29.27");
        new ASN1ObjectIdentifier("2.5.29.28");
        new ASN1ObjectIdentifier("2.5.29.30");
        new ASN1ObjectIdentifier("2.5.29.31");
        new ASN1ObjectIdentifier("2.5.29.32");
        new ASN1ObjectIdentifier("2.5.29.33");
        new ASN1ObjectIdentifier("2.5.29.35");
        new ASN1ObjectIdentifier("2.5.29.36");
        new ASN1ObjectIdentifier("2.5.29.37");
        new ASN1ObjectIdentifier("2.5.29.46");
        new ASN1ObjectIdentifier("2.5.29.54");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        new ASN1ObjectIdentifier("2.5.29.56");
        new ASN1ObjectIdentifier("2.5.29.55");
    }
}
