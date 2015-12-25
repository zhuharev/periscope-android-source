// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.x509;

import org.spongycastle.util.Selector;

// Referenced classes of package org.spongycastle.x509:
//            X509CertStoreSelector, X509CertificatePair

public class X509CertPairStoreSelector
    implements Selector
{

    public X509CertStoreSelector aQh;
    public X509CertStoreSelector aQi;
    public X509CertificatePair aQj;

    public X509CertPairStoreSelector()
    {
    }

    public Object clone()
    {
        X509CertPairStoreSelector x509certpairstoreselector = new X509CertPairStoreSelector();
        x509certpairstoreselector.aQj = aQj;
        if (aQh != null)
        {
            x509certpairstoreselector.aQh = (X509CertStoreSelector)aQh.clone();
        }
        if (aQi != null)
        {
            x509certpairstoreselector.aQi = (X509CertStoreSelector)aQi.clone();
        }
        return x509certpairstoreselector;
    }

    public final boolean _mth1D59(Object obj)
    {
        if (!(obj instanceof X509CertificatePair))
        {
            return false;
        }
        X509CertificatePair x509certificatepair;
        boolean flag;
        x509certificatepair = (X509CertificatePair)obj;
        if (aQh == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        flag = aQh._mth1D59(x509certificatepair.aQk);
        if (!flag)
        {
            return false;
        }
        if (aQi == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        flag = aQi._mth1D59(x509certificatepair.aQl);
        if (!flag)
        {
            return false;
        }
label0:
        {
            boolean flag1;
            try
            {
                if (aQj == null)
                {
                    break label0;
                }
                flag1 = aQj.equals(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            return flag1;
        }
        return true;
    }
}
