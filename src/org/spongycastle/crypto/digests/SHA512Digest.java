// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            LongDigest

public class SHA512Digest extends LongDigest
{

    public SHA512Digest()
    {
    }

    public SHA512Digest(SHA512Digest sha512digest)
    {
        super(sha512digest);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        Pack._mth02CF(anw, abyte0, i);
        Pack._mth02CF(anx, abyte0, i + 8);
        Pack._mth02CF(any, abyte0, i + 16);
        Pack._mth02CF(anz, abyte0, i + 24);
        Pack._mth02CF(anA, abyte0, i + 32);
        Pack._mth02CF(anB, abyte0, i + 40);
        Pack._mth02CF(anC, abyte0, i + 48);
        Pack._mth02CF(anD, abyte0, i + 56);
        reset();
        return 64;
    }

    public final void reset()
    {
        super.reset();
        anw = 0x6a09e667f3bcc908L;
        anx = 0xbb67ae8584caa73bL;
        any = 0x3c6ef372fe94f82bL;
        anz = 0xa54ff53a5f1d36f1L;
        anA = 0x510e527fade682d1L;
        anB = 0x9b05688c2b3e6c1fL;
        anC = 0x1f83d9abfb41bd6bL;
        anD = 0x5be0cd19137e2179L;
    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA(((LongDigest) ((SHA512Digest)memoable)));
    }

    public final String _mth14AC()
    {
        return "SHA-512";
    }

    public final int _mth14AF()
    {
        return 64;
    }

    public final Memoable _mth14B7()
    {
        return new SHA512Digest(this);
    }
}
