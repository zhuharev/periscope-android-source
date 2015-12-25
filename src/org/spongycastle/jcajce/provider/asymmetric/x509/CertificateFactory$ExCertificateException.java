// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CertificateException;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.x509:
//            CertificateFactory

class VU extends CertificateException
{

    private Throwable VU;
    private CertificateFactory aEA;

    public Throwable getCause()
    {
        return VU;
    }

    public (CertificateFactory certificatefactory, Exception exception)
    {
        aEA = certificatefactory;
        super();
        VU = exception;
    }
}
