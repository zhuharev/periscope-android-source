// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.math.BigInteger;
import java.security.cert.X509Extension;
import java.util.Date;

// Referenced classes of package org.spongycastle.x509:
//            X509Attribute, AttributeCertificateHolder, AttributeCertificateIssuer

public interface X509AttributeCertificate
    extends X509Extension
{

    public abstract void checkValidity(Date date);

    public abstract byte[] getEncoded();

    public abstract Date getNotAfter();

    public abstract BigInteger getSerialNumber();

    public abstract X509Attribute[] _mth02BA(String s);

    public abstract AttributeCertificateHolder _mth1F59();

    public abstract AttributeCertificateIssuer _mth1FE8();
}
