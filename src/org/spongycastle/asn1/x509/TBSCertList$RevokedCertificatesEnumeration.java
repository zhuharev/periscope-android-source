// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1.x509:
//            TBSCertList

class ajL
    implements Enumeration
{

    private TBSCertList ajK;
    private final Enumeration ajL;

    public boolean hasMoreElements()
    {
        return ajL.hasMoreElements();
    }

    public Object nextElement()
    {
        return ajL(ajL.nextElement());
    }

    (TBSCertList tbscertlist, Enumeration enumeration)
    {
        ajK = tbscertlist;
        super();
        ajL = enumeration;
    }
}
