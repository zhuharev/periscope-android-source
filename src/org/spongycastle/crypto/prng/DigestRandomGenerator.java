// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

// Referenced classes of package org.spongycastle.crypto.prng:
//            RandomGenerator

public class DigestRandomGenerator
    implements RandomGenerator
{

    private static long axQ = 10L;
    private byte aln[];
    private Digest amS;
    private byte aob[];
    private long axR;
    private long axS;

    public DigestRandomGenerator(SHA1Digest sha1digest)
    {
        amS = sha1digest;
        aln = new byte[sha1digest._mth14AF()];
        axS = 1L;
        aob = new byte[sha1digest._mth14AF()];
        axR = 1L;
    }

    private void _mth022F()
    {
        byte abyte0[] = aln;
        amS.update(abyte0, 0, abyte0.length);
        long l = axS;
        axS = 1L + l;
        for (int i = 0; i != 8; i++)
        {
            amS.update((byte)(int)l);
            l >>>= 8;
        }

        abyte0 = aln;
        amS.doFinal(abyte0, 0);
    }

    private void _mth0262()
    {
        long l = axR;
        axR = 1L + l;
        for (int i = 0; i != 8; i++)
        {
            amS.update((byte)(int)l);
            l >>>= 8;
        }

        byte abyte0[] = aob;
        amS.update(abyte0, 0, abyte0.length);
        abyte0 = aln;
        amS.update(abyte0, 0, abyte0.length);
        abyte0 = aob;
        amS.doFinal(abyte0, 0);
        if (axR % axQ == 0L)
        {
            _mth022F();
        }
    }

    public final void nextBytes(byte abyte0[])
    {
        FF9E(abyte0, 0, abyte0.length);
    }

    public final void FB1D(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        amS.update(abyte0, 0, abyte0.length);
        abyte0 = aln;
        amS.update(abyte0, 0, abyte0.length);
        abyte0 = aln;
        amS.doFinal(abyte0, 0);
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public final void FF9E(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        i = 0;
        _mth0262();
        int k = 0;
_L2:
        int l;
        if (k == j + 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i;
        if (i != aob.length)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        _mth0262();
        l = 0;
        byte abyte1[] = aob;
        i = l + 1;
        abyte0[k] = abyte1[l];
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        abyte0;
        throw abyte0;
    }

}
