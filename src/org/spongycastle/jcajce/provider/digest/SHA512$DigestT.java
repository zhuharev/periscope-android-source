// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SHA512tDigest;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, SHA512

public static class  extends BCMessageDigest
    implements Cloneable
{

    public Object clone()
    {
          = ()super.clone();
        .amS = new SHA512tDigest((SHA512tDigest)amS);
        return ;
    }

    public (int i)
    {
        super(new SHA512tDigest(i));
    }
}
