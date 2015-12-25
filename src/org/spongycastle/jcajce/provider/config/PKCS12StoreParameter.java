// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.config;

import java.io.OutputStream;

public class PKCS12StoreParameter
    implements java.security.KeyStore.LoadStoreParameter
{

    private final java.security.KeyStore.ProtectionParameter aEU;
    public final boolean aEV;
    public final OutputStream out;

    public PKCS12StoreParameter(OutputStream outputstream, java.security.KeyStore.ProtectionParameter protectionparameter, boolean flag)
    {
        out = outputstream;
        aEU = protectionparameter;
        aEV = flag;
    }

    public java.security.KeyStore.ProtectionParameter getProtectionParameter()
    {
        return aEU;
    }
}
