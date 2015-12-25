// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.cert.X509Certificate;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.jce.provider.X509CertificateObject;

public class X509CertificatePair
{

    public X509CertificateObject aQk;
    public X509CertificateObject aQl;

    public X509CertificatePair(CertificatePair certificatepair)
    {
        if (certificatepair.aiv != null)
        {
            aQk = new X509CertificateObject(certificatepair.aiv);
        }
        if (certificatepair.aiw != null)
        {
            aQl = new X509CertificateObject(certificatepair.aiw);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof X509CertificatePair))
        {
            return false;
        }
        obj = (X509CertificatePair)obj;
        boolean flag1 = true;
        boolean flag = true;
        if (aQk != null)
        {
            flag = aQk.equals(((X509CertificatePair) (obj)).aQk);
        } else
        if (((X509CertificatePair) (obj)).aQk != null)
        {
            flag = false;
        }
        if (aQl != null)
        {
            flag1 = aQl.equals(((X509CertificatePair) (obj)).aQl);
        } else
        if (((X509CertificatePair) (obj)).aQl != null)
        {
            flag1 = false;
        }
        return flag && flag1;
    }

    public int hashCode()
    {
        int i = -1;
        if (aQk != null)
        {
            i = ~aQk.hashCode();
        }
        int j = i;
        if (aQl != null)
        {
            j = i * 17 ^ aQl.hashCode();
        }
        return j;
    }
}
