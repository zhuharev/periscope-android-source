// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import org.spongycastle.util.encoders.Base64;

// Referenced classes of package o:
//            FF6A

public class acb
{

    final PublicKey bcN;

    public acb(String s)
    {
        s = Base64._mth1508(s);
        try
        {
            s = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(s)).getPublicKey();
        }
        catch (CertificateException certificateexception)
        {
            s = null;
            FF6A._mth02CA("KeyLoader", "cert", certificateexception);
        }
        bcN = s;
    }

    public PublicKey getPublicKey()
    {
        return bcN;
    }
}
