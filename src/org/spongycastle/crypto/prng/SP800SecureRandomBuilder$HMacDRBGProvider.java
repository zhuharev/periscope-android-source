// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

// Referenced classes of package org.spongycastle.crypto.prng:
//            DRBGProvider, SP800SecureRandomBuilder, EntropySource

static class 
    implements DRBGProvider
{

    private final byte XD[];
    private final int ayd;
    private final byte ayh[];
    private final Mac ayj;

    public final SP80090DRBG _mth02CA(EntropySource entropysource)
    {
        return new HMacSP800DRBG(ayj, ayd, entropysource, ayh, XD);
    }
}
