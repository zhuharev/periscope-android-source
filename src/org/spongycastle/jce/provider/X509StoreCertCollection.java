// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.util.ArrayList;
import java.util.Collection;
import org.spongycastle.util.CollectionStore;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509CollectionStoreParameters;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;

public class X509StoreCertCollection extends X509StoreSpi
{

    private CollectionStore aIh;

    public X509StoreCertCollection()
    {
    }

    public final Collection _mth02CA(Selector selector)
    {
        return aIh._mth02CB(selector);
    }

    public final void _mth02CA(X509StoreParameters x509storeparameters)
    {
        if (!(x509storeparameters instanceof X509CollectionStoreParameters))
        {
            throw new IllegalArgumentException(x509storeparameters.toString());
        } else
        {
            aIh = new CollectionStore(new ArrayList(((X509CollectionStoreParameters)x509storeparameters).aQm));
            return;
        }
    }
}
