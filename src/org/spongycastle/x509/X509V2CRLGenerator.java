// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.cert.CRLException;
import org.spongycastle.asn1.x509.V2TBSCertListGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;

public class X509V2CRLGenerator
{
    static class ExtCRLException extends CRLException
    {

        public Throwable getCause()
        {
            return null;
        }
    }


    private V2TBSCertListGenerator aQv;
    private X509ExtensionsGenerator aQw;

    public X509V2CRLGenerator()
    {
        aQv = new V2TBSCertListGenerator();
        aQw = new X509ExtensionsGenerator();
    }
}
