// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SkeinDigest;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, Skein

public static class  extends BCMessageDigest
    implements Cloneable
{

    public Object clone()
    {
        BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
        bcmessagedigest.amS = new SkeinDigest((SkeinDigest)amS);
        return bcmessagedigest;
    }

    public (int i)
    {
        super(new SkeinDigest(1024, i));
    }
}
