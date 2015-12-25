// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.spongycastle.crypto.prng.drbg.DualECPoints;
import org.spongycastle.crypto.prng.drbg.DualECSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HashSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

// Referenced classes of package org.spongycastle.crypto.prng:
//            BasicEntropySourceProvider, DRBGProvider, EntropySource

public class SP800SecureRandomBuilder
{
    static class CTRDRBGProvider
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

    static class ConfigurableDualECDRBGProvider
        implements DRBGProvider
    {

        private final byte XD[];
        private final Digest amS;
        private final int ayd;
        private final byte ayh[];
        private final DualECPoints ayi[];

        public final SP80090DRBG _mth02CA(EntropySource entropysource)
        {
            return new DualECSP800DRBG(ayi, amS, ayd, entropysource, ayh, XD);
        }
    }

    static class DualECDRBGProvider
        implements DRBGProvider
    {

        private final byte XD[];
        private final Digest amS;
        private final int ayd;
        private final byte ayh[];

        public final SP80090DRBG _mth02CA(EntropySource entropysource)
        {
            return new DualECSP800DRBG(amS, ayd, entropysource, ayh, XD);
        }
    }

    static class HMacDRBGProvider
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

    static class HashDRBGProvider
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


    private final SecureRandom amC;
    private final BasicEntropySourceProvider ayc;
    private int ayd;
    private int aye;

    public SP800SecureRandomBuilder()
    {
        this(new SecureRandom(), false);
    }

    private SP800SecureRandomBuilder(SecureRandom securerandom, boolean flag)
    {
        ayd = 256;
        aye = 256;
        amC = securerandom;
        ayc = new BasicEntropySourceProvider(amC, false);
    }
}
