// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jce.provider.CertPathValidatorUtilities;

public class PKIXCertPathReviewer extends CertPathValidatorUtilities
{

    public PKIXCertPathReviewer()
    {
    }

    static 
    {
        org.spongycastle.asn1.ASN1ObjectIdentifier asn1objectidentifier = X509Extensions.aks;
        asn1objectidentifier = X509Extensions.akk;
        asn1objectidentifier = X509Extensions.akr;
    }
}
