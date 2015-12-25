// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Store;

// Referenced classes of package org.spongycastle.x509:
//            X509Util, X509StoreSpi, NoSuchStoreException, X509StoreParameters

public class X509Store
    implements Store
{

    private Provider aQn;
    public X509StoreSpi aQo;

    private X509Store(Provider provider, X509StoreSpi x509storespi)
    {
        aQn = provider;
        aQo = x509storespi;
    }

    public static X509Store _mth02CA(String s, X509LDAPCertStoreParameters x509ldapcertstoreparameters, String s1)
    {
        return _mth02CA(s, ((X509StoreParameters) (x509ldapcertstoreparameters)), X509Util.getProvider(s1));
    }

    private static X509Store _mth02CA(String s, X509StoreParameters x509storeparameters, Provider provider)
    {
        try
        {
            s = X509Util._mth02CA("X509Store", s, provider);
            provider = (X509StoreSpi)((X509Util.Implementation) (s)).aQp;
            provider._mth02CA(x509storeparameters);
            s = new X509Store(((X509Util.Implementation) (s)).aQq, provider);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoSuchStoreException(s.getMessage());
        }
        return s;
    }
}
