// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            SHA1

public static class y extends PBESecretKeyFactory
{

    public y()
    {
        super("PBEwithHmacSHA", null, false, 2, 1, 160, 0);
    }
}
