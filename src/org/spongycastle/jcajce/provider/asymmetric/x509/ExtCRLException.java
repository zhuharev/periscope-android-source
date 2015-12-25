// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException
{

    private Throwable VU;

    ExtCRLException(String s, Exception exception)
    {
        super(s);
        VU = exception;
    }

    public Throwable getCause()
    {
        return VU;
    }
}
