// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.x509.X509CertificatePair;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;

public class X509CertPairParser extends X509StreamParserSpi
{

    public InputStream aEw;

    public X509CertPairParser()
    {
        aEw = null;
    }

    public final X509CertificatePair _mth3005()
    {
        X509CertificatePair x509certificatepair;
        int i;
        try
        {
            aEw.mark(10);
            i = aEw.read();
        }
        catch (Exception exception)
        {
            throw new StreamParsingException(exception.toString(), exception);
        }
        if (i == -1)
        {
            return null;
        }
        aEw.reset();
        x509certificatepair = new X509CertificatePair(CertificatePair._mth02BF((ASN1Sequence)(new ASN1InputStream(aEw))._mth04B7()));
        return x509certificatepair;
    }
}
