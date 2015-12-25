// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            LongDigest

public class SHA384Digest extends LongDigest
{

    public SHA384Digest()
    {
    }

    public SHA384Digest(SHA384Digest sha384digest)
    {
        super(sha384digest);
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
        reset();
        return 48;
    }

    public final void reset()
    {
        super.reset();
        anw = 0xcbbb9d5dc1059ed8L;
        anx = 0x629a292a367cd507L;
        any = 0x9159015a3070dd17L;
        anz = 0x152fecd8f70e5939L;
        anA = 0x67332667ffc00b31L;
        anB = 0x8eb44a8768581511L;
        anC = 0xdb0c2e0d64f98fa7L;
        anD = 0x47b5481dbefa4fa4L;
    }

    public final void _mth02CA(Memoable memoable)
    {
        super._mth02CA((SHA384Digest)memoable);
    }

    public final String _mth14AC()
    {
        return "SHA-384";
    }

    public final int _mth14AF()
    {
        return 48;
    }

    public final Memoable _mth14B7()
    {
        return new SHA384Digest(this);
    }
}
