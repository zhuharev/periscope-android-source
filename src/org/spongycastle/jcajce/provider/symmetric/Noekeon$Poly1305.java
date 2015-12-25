// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.engines.NoekeonEngine;
import org.spongycastle.crypto.macs.Poly1305;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            Noekeon

public static class t> extends BaseMac
{

    public A()
    {
        super(new Poly1305(new NoekeonEngine()));
    }
}
