// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.security.PublicKey;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore.pkcs12:
//            PKCS12KeyStoreSpi

class aFm
{

    private byte aFm[];
    private PKCS12KeyStoreSpi aFn;

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof aFm))
        {
            return false;
        } else
        {
            obj = (aFm)obj;
            return Arrays._mth1427(aFm, ((aFm) (obj)).aFm);
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(aFm);
    }

    (PKCS12KeyStoreSpi pkcs12keystorespi, PublicKey publickey)
    {
        aFn = pkcs12keystorespi;
        super();
        aFm = PKCS12KeyStoreSpi._mth02CA(pkcs12keystorespi, publickey).ajC;
    }

    aFm(PKCS12KeyStoreSpi pkcs12keystorespi, byte abyte0[])
    {
        aFn = pkcs12keystorespi;
        super();
        aFm = abyte0;
    }
}
