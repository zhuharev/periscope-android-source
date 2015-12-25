// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.drbg.HashSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

// Referenced classes of package org.spongycastle.crypto.prng:
//            DRBGProvider, SP800SecureRandomBuilder, EntropySource

static class 
    implements DRBGProvider
{

    private final byte XD[];
    private final Digest amS;
    private final int ayd;
    private final byte ayh[];

    public final SP80090DRBG _mth02CA(EntropySource entropysource)
    {
        return new HashSP800DRBG(amS, ayd, entropysource, ayh, XD);
    }
}
