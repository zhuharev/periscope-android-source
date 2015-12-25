// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreSpi;
import java.util.Collection;

public class MultiCertStoreSpi extends CertStoreSpi
{

    public Collection engineGetCRLs(CRLSelector crlselector)
    {
        throw new NullPointerException();
    }

    public Collection engineGetCertificates(CertSelector certselector)
    {
        throw new NullPointerException();
    }
}
