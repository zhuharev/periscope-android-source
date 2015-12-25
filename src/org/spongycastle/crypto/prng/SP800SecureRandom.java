// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

// Referenced classes of package org.spongycastle.crypto.prng:
//            DRBGProvider, EntropySource

public class SP800SecureRandom extends SecureRandom
{

    private final DRBGProvider axX;
    private final boolean axY;
    private final SecureRandom axZ;
    private final EntropySource aya;
    private SP80090DRBG ayb;

    public byte[] generateSeed(int i)
    {
        byte abyte0[] = new byte[i];
        nextBytes(abyte0);
        return abyte0;
    }

    public void nextBytes(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (ayb == null)
        {
            ayb = axX._mth02CA(aya);
        }
        if (ayb._mth02CA(abyte0, null, axY) < 0)
        {
            ayb._mth141F(aya._mth01B3());
            ayb._mth02CA(abyte0, null, axY);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void setSeed(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (axZ != null)
        {
            axZ.setSeed(l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSeed(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (axZ != null)
        {
            axZ.setSeed(abyte0);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }
}
