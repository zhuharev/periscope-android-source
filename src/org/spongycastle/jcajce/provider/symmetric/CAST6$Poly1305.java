// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.engines.CAST6Engine;
import org.spongycastle.crypto.macs.Poly1305;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            CAST6

public static class nit> extends BaseMac
{

    public ()
    {
        super(new Poly1305(new CAST6Engine()));
    }
}
