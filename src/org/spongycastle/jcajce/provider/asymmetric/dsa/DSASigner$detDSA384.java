// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dsa;

import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.signers.DSASigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dsa:
//            DSASigner

public static class I extends org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner
{

    public I()
    {
        super(new SHA384Digest(), new DSASigner(new HMacDSAKCalculator(new SHA384Digest())));
    }
}
