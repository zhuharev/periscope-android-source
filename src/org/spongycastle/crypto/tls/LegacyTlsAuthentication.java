// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


// Referenced classes of package org.spongycastle.crypto.tls:
//            ServerOnlyTlsAuthentication, Certificate, CertificateVerifyer

public class LegacyTlsAuthentication extends ServerOnlyTlsAuthentication
{

    private CertificateVerifyer aAC;

    public LegacyTlsAuthentication(CertificateVerifyer certificateverifyer)
    {
        aAC = certificateverifyer;
    }

    public final void _mth02CB(Certificate certificate)
    {
        certificate._mth0534();
    }
}
