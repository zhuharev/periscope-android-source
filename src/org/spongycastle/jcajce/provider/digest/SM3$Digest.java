// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.crypto.digests.SM3Digest;

// Referenced classes of package org.spongycastle.jcajce.provider.digest:
//            BCMessageDigest, SM3

public static class gest extends BCMessageDigest
    implements Cloneable
{

    public Object clone()
    {
        gest gest = (gest)super.clone();
        gest.amS = new SM3Digest((SM3Digest)amS);
        return gest;
    }

    public gest()
    {
        super(new SM3Digest());
    }
}
