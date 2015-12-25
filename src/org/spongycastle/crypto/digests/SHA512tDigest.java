// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.MemoableResetException;

// Referenced classes of package org.spongycastle.crypto.digests:
//            LongDigest

public class SHA512tDigest extends LongDigest
{

    private int aon;
    private long aoo;
    private long aop;
    private long aoq;
    private long aor;
    private long aos;
    private long aot;
    private long aou;
    private long aov;

    public SHA512tDigest(int i)
    {
        if (i >= 512)
        {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        }
        if (i % 8 != 0)
        {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        }
        if (i == 384)
        {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
        aon = i / 8;
        int j = aon << 3;
        anw = 0xcfac43c256196cadL;
        anx = 0x1ec20b20216f029eL;
        any = 0x99cb56d75b315d8eL;
        anz = 0xea509ffab89354L;
        anA = 0xf4abf7da08432774L;
        anB = 0x3ea0cd298e9bc9baL;
        anC = 0xba267c0e5ee418ceL;
        anD = 0xfe4568bcb6db84dcL;
        update((byte)83);
        update((byte)72);
        update((byte)65);
        update((byte)45);
        update((byte)53);
        update((byte)49);
        update((byte)50);
        update((byte)47);
        if (j > 100)
        {
            update((byte)(j / 100 + 48));
            i = j % 100;
            update((byte)(i / 10 + 48));
            i %= 10;
        } else
        {
            i = j;
            if (j > 10)
            {
                update((byte)(j / 10 + 48));
                i = j % 10;
            }
        }
        update((byte)(i + 48));
        finish();
        aoo = anw;
        aop = anx;
        aoq = any;
        aor = anz;
        aos = anA;
        aot = anB;
        aou = anC;
        aov = anD;
        reset();
    }

    public SHA512tDigest(SHA512tDigest sha512tdigest)
    {
        super(sha512tdigest);
        aon = sha512tdigest.aon;
        _mth02CA(sha512tdigest);
    }

    private static void _mth02CA(long l, byte abyte0[], int i, int j)
    {
        if (j > 0)
        {
            _mth02CE((int)(l >>> 32), abyte0, i, j);
            if (j > 4)
            {
                _mth02CE((int)l, abyte0, i + 4, j - 4);
            }
        }
    }

    private static void _mth02CE(int i, byte abyte0[], int j, int k)
    {
        k = Math.min(4, k);
        do
        {
            k--;
            if (k >= 0)
            {
                abyte0[j + k] = (byte)(i >>> (3 - k) * 8);
            } else
            {
                return;
            }
        } while (true);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        _mth02CA(anw, abyte0, i, aon);
        _mth02CA(anx, abyte0, i + 8, aon - 8);
        _mth02CA(any, abyte0, i + 16, aon - 16);
        _mth02CA(anz, abyte0, i + 24, aon - 24);
        _mth02CA(anA, abyte0, i + 32, aon - 32);
        _mth02CA(anB, abyte0, i + 40, aon - 40);
        _mth02CA(anC, abyte0, i + 48, aon - 48);
        _mth02CA(anD, abyte0, i + 56, aon - 56);
        reset();
        return aon;
    }

    public final void reset()
    {
        super.reset();
        anw = aoo;
        anx = aop;
        any = aoq;
        anz = aor;
        anA = aos;
        anB = aot;
        anC = aou;
        anD = aov;
    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (SHA512tDigest)memoable;
        if (aon != ((SHA512tDigest) (memoable)).aon)
        {
            throw new MemoableResetException("digestLength inappropriate in other");
        } else
        {
            super._mth02CA(memoable);
            aoo = ((SHA512tDigest) (memoable)).aoo;
            aop = ((SHA512tDigest) (memoable)).aop;
            aoq = ((SHA512tDigest) (memoable)).aoq;
            aor = ((SHA512tDigest) (memoable)).aor;
            aos = ((SHA512tDigest) (memoable)).aos;
            aot = ((SHA512tDigest) (memoable)).aot;
            aou = ((SHA512tDigest) (memoable)).aou;
            aov = ((SHA512tDigest) (memoable)).aov;
            return;
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("SHA-512/")).append(Integer.toString(aon << 3)).toString();
    }

    public final int _mth14AF()
    {
        return aon;
    }

    public final Memoable _mth14B7()
    {
        return new SHA512tDigest(this);
    }
}
