// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

// Referenced classes of package org.spongycastle.crypto.prng:
//            DRBGProvider, SP800SecureRandomBuilder, EntropySource

static class 
    implements DRBGProvider
{

    private final byte XD[];
    private final int ayd;
    private final BlockCipher ayf;
    private final int ayg;
    private final byte ayh[];

    public final SP80090DRBG _mth02CA(EntropySource entropysource)
    {
        return new CTRSP800DRBG(ayf, ayg, ayd, entropysource, ayh, XD);
    }
}
