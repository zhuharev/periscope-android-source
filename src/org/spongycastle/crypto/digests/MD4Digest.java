// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class MD4Digest extends GeneralDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];

    public MD4Digest()
    {
        anQ = new int[16];
        reset();
    }

    public MD4Digest(MD4Digest md4digest)
    {
        super(md4digest);
        anQ = new int[16];
        _mth02CA(md4digest);
    }

    private static void _mth02CA(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth02CA(MD4Digest md4digest)
    {
        System.arraycopy(((GeneralDigest) (md4digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (md4digest)).ani;
        super.VD = ((GeneralDigest) (md4digest)).VD;
        anM = md4digest.anM;
        anN = md4digest.anN;
        anO = md4digest.anO;
        anP = md4digest.anP;
        System.arraycopy(md4digest.anQ, 0, anQ, 0, md4digest.anQ.length);
        anI = md4digest.anI;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        _mth02CA(anM, abyte0, i);
        _mth02CA(anN, abyte0, i + 4);
        _mth02CA(anO, abyte0, i + 8);
        _mth02CA(anP, abyte0, i + 12);
        reset();
        return 16;
    }

    public final void reset()
    {
        super.reset();
        anM = 0x67452301;
        anN = 0xefcdab89;
        anO = 0x98badcfe;
        anP = 0x10325476;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((MD4Digest)memoable);
    }

    protected final void _mth0674(long l)
    {
        if (anI > 14)
        {
            _mth14BA();
        }
        anQ[14] = (int)l;
        anQ[15] = (int)(l >>> 32);
    }

    protected final void _mth141D(byte abyte0[], int i)
    {
        int ai[] = anQ;
        int j = anI;
        anI = j + 1;
        ai[j] = abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 3] & 0xff) << 24;
        if (anI == 16)
        {
            _mth14BA();
        }
    }

    public final String _mth14AC()
    {
        return "MD4";
    }

    public final int _mth14AF()
    {
        return 16;
    }

    public final Memoable _mth14B7()
    {
        return new MD4Digest(this);
    }

    protected final void _mth14BA()
    {
        int k = anM;
        int i = anN;
        int i1 = anO;
        int l = anP;
        k = (i & i1 | ~i & l) + k + anQ[0];
        k = k << 3 | k >>> 29;
        l = (k & i | ~k & i1) + l + anQ[1];
        l = l << 7 | l >>> 25;
        i1 = (l & k | ~l & i) + i1 + anQ[2];
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 & l | ~i1 & k) + i + anQ[3];
        i = i << 19 | i >>> 13;
        k = (i & i1 | ~i & l) + k + anQ[4];
        k = k << 3 | k >>> 29;
        l = (k & i | ~k & i1) + l + anQ[5];
        l = l << 7 | l >>> 25;
        i1 = (l & k | ~l & i) + i1 + anQ[6];
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 & l | ~i1 & k) + i + anQ[7];
        i = i << 19 | i >>> 13;
        k = (i & i1 | ~i & l) + k + anQ[8];
        k = k << 3 | k >>> 29;
        l = (k & i | ~k & i1) + l + anQ[9];
        l = l << 7 | l >>> 25;
        i1 = (l & k | ~l & i) + i1 + anQ[10];
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 & l | ~i1 & k) + i + anQ[11];
        i = i << 19 | i >>> 13;
        k = (i & i1 | ~i & l) + k + anQ[12];
        k = k << 3 | k >>> 29;
        l = (k & i | ~k & i1) + l + anQ[13];
        l = l << 7 | l >>> 25;
        i1 = (l & k | ~l & i) + i1 + anQ[14];
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 & l | ~i1 & k) + i + anQ[15];
        i = i << 19 | i >>> 13;
        k = (i & i1 | i & l | i1 & l) + k + anQ[0] + 0x5a827999;
        k = k << 3 | k >>> 29;
        l = (k & i | k & i1 | i & i1) + l + anQ[4] + 0x5a827999;
        l = l << 5 | l >>> 27;
        i1 = (l & k | l & i | k & i) + i1 + anQ[8] + 0x5a827999;
        i1 = i1 << 9 | i1 >>> 23;
        i = (i1 & l | i1 & k | l & k) + i + anQ[12] + 0x5a827999;
        i = i << 13 | i >>> 19;
        k = (i & i1 | i & l | i1 & l) + k + anQ[1] + 0x5a827999;
        k = k << 3 | k >>> 29;
        l = (k & i | k & i1 | i & i1) + l + anQ[5] + 0x5a827999;
        l = l << 5 | l >>> 27;
        i1 = (l & k | l & i | k & i) + i1 + anQ[9] + 0x5a827999;
        i1 = i1 << 9 | i1 >>> 23;
        i = (i1 & l | i1 & k | l & k) + i + anQ[13] + 0x5a827999;
        i = i << 13 | i >>> 19;
        k = (i & i1 | i & l | i1 & l) + k + anQ[2] + 0x5a827999;
        k = k << 3 | k >>> 29;
        l = (k & i | k & i1 | i & i1) + l + anQ[6] + 0x5a827999;
        l = l << 5 | l >>> 27;
        i1 = (l & k | l & i | k & i) + i1 + anQ[10] + 0x5a827999;
        i1 = i1 << 9 | i1 >>> 23;
        i = (i1 & l | i1 & k | l & k) + i + anQ[14] + 0x5a827999;
        i = i << 13 | i >>> 19;
        k = (i & i1 | i & l | i1 & l) + k + anQ[3] + 0x5a827999;
        k = k << 3 | k >>> 29;
        l = (k & i | k & i1 | i & i1) + l + anQ[7] + 0x5a827999;
        l = l << 5 | l >>> 27;
        i1 = (l & k | l & i | k & i) + i1 + anQ[11] + 0x5a827999;
        i1 = i1 << 9 | i1 >>> 23;
        i = (i1 & l | i1 & k | l & k) + i + anQ[15] + 0x5a827999;
        i = i << 13 | i >>> 19;
        k = (i ^ i1 ^ l) + k + anQ[0] + 0x6ed9eba1;
        k = k << 3 | k >>> 29;
        l = (k ^ i ^ i1) + l + anQ[8] + 0x6ed9eba1;
        l = l << 9 | l >>> 23;
        i1 = (l ^ k ^ i) + i1 + anQ[4] + 0x6ed9eba1;
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 ^ l ^ k) + i + anQ[12] + 0x6ed9eba1;
        i = i << 15 | i >>> 17;
        k = (i ^ i1 ^ l) + k + anQ[2] + 0x6ed9eba1;
        k = k << 3 | k >>> 29;
        l = (k ^ i ^ i1) + l + anQ[10] + 0x6ed9eba1;
        l = l << 9 | l >>> 23;
        i1 = (l ^ k ^ i) + i1 + anQ[6] + 0x6ed9eba1;
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 ^ l ^ k) + i + anQ[14] + 0x6ed9eba1;
        i = i << 15 | i >>> 17;
        k = (i ^ i1 ^ l) + k + anQ[1] + 0x6ed9eba1;
        k = k << 3 | k >>> 29;
        l = (k ^ i ^ i1) + l + anQ[9] + 0x6ed9eba1;
        l = l << 9 | l >>> 23;
        i1 = (l ^ k ^ i) + i1 + anQ[5] + 0x6ed9eba1;
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 ^ l ^ k) + i + anQ[13] + 0x6ed9eba1;
        i = i << 15 | i >>> 17;
        k = (i ^ i1 ^ l) + k + anQ[3] + 0x6ed9eba1;
        k = k << 3 | k >>> 29;
        l = (k ^ i ^ i1) + l + anQ[11] + 0x6ed9eba1;
        l = l << 9 | l >>> 23;
        i1 = (l ^ k ^ i) + i1 + anQ[7] + 0x6ed9eba1;
        i1 = i1 << 11 | i1 >>> 21;
        i = (i1 ^ l ^ k) + i + anQ[15] + 0x6ed9eba1;
        anM = anM + k;
        anN = anN + (i << 15 | i >>> 17);
        anO = anO + i1;
        anP = anP + l;
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
