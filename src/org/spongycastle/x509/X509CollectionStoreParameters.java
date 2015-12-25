// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import java.util.Collection;

// Referenced classes of package org.spongycastle.x509:
//            X509StoreParameters

public class X509CollectionStoreParameters
    implements X509StoreParameters
{

    public Collection aQm;

    private X509CollectionStoreParameters(Collection collection)
    {
        if (collection == null)
        {
            throw new NullPointerException("collection cannot be null");
        } else
        {
            aQm = collection;
            return;
        }
    }

    public Object clone()
    {
        return new X509CollectionStoreParameters(aQm);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("X509CollectionStoreParameters: [\n");
        stringbuffer.append((new StringBuilder("  collection: ")).append(aQm).append("\n").toString());
        stringbuffer.append("]");
        return stringbuffer.toString();
    }
}
