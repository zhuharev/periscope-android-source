// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.pqc.crypto.rainbow.RainbowSigner;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.rainbow:
//            SignatureSpi

public static class  extends SignatureSpi
{

    public ()
    {
        super(new SHA384Digest(), new RainbowSigner());
    }
}
