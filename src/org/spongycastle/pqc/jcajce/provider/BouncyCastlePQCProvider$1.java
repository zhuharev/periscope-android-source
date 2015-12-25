// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider;

import java.security.PrivilegedAction;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider:
//            BouncyCastlePQCProvider

class aOa
    implements PrivilegedAction
{

    private BouncyCastlePQCProvider aOa;

    public Object run()
    {
        BouncyCastlePQCProvider._mth02CA(aOa);
        return null;
    }

    (BouncyCastlePQCProvider bouncycastlepqcprovider)
    {
        aOa = bouncycastlepqcprovider;
        super();
    }
}
