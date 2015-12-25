// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            GOST3411

public static class nit> extends PBESecretKeyFactory
{

    public ()
    {
        super("PBEwithHmacGOST3411", null, false, 2, 6, 256, 0);
    }
}
