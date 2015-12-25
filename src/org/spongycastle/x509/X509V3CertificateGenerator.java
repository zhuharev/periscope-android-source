// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import org.spongycastle.asn1.x509.V3TBSCertificateGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;

public class X509V3CertificateGenerator
{

    private X509ExtensionsGenerator aQw;
    private V3TBSCertificateGenerator aQx;

    public X509V3CertificateGenerator()
    {
        aQx = new V3TBSCertificateGenerator();
        aQw = new X509ExtensionsGenerator();
    }
}
