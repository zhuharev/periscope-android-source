// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SHA3Digest;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, SHA3

public static class <init> extends BCMessageDigest
    implements Cloneable
{

    public Object clone()
    {
        BCMessageDigest bcmessagedigest = (BCMessageDigest)super.clone();
        bcmessagedigest.amS = new SHA3Digest((SHA3Digest)amS);
        return bcmessagedigest;
    }

    public (int i)
    {
        super(new SHA3Digest(i));
    }
}
