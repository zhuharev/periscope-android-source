// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class RIPEMD160Digest extends GeneralDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];
    private int anS;

    public RIPEMD160Digest()
    {
        anQ = new int[16];
        reset();
    }

    public RIPEMD160Digest(RIPEMD160Digest ripemd160digest)
    {
        super(ripemd160digest);
        anQ = new int[16];
        _mth02CA(ripemd160digest);
    }

    private static int _mth02BF(int i, int j, int k)
    {
        return i ^ j ^ k;
    }

    private static int _mth02C8(int i, int j, int k)
    {
        return i & j | ~i & k;
    }

    private static int _mth02C9(int i, int j, int k)
    {
        return (~j | i) ^ k;
    }

    private static void _mth02CA(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth02CA(RIPEMD160Digest ripemd160digest)
    {
        System.arraycopy(((GeneralDigest) (ripemd160digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (ripemd160digest)).ani;
        super.VD = ((GeneralDigest) (ripemd160digest)).VD;
        anS = ripemd160digest.anS;
        anM = ripemd160digest.anM;
        anN = ripemd160digest.anN;
        anO = ripemd160digest.anO;
        anP = ripemd160digest.anP;
        System.arraycopy(ripemd160digest.anQ, 0, anQ, 0, ripemd160digest.anQ.length);
        anI = ripemd160digest.anI;
    }

    private static int _mth02CC(int i, int j, int k)
    {
        return i & k | ~k & j;
    }

    private static int _mth02CD(int i, int j, int k)
    {
        return (~k | j) ^ i;
    }

    private static int FB1D(int i, int j)
    {
        return i << j | i >>> 32 - j;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        _mth02CA(anS, abyte0, i);
        _mth02CA(anM, abyte0, i + 4);
        _mth02CA(anN, abyte0, i + 8);
        _mth02CA(anO, abyte0, i + 12);
        _mth02CA(anP, abyte0, i + 16);
        reset();
        return 20;
    }

    public final void reset()
    {
        super.reset();
        anS = 0x67452301;
        anM = 0xefcdab89;
        anN = 0x98badcfe;
        anO = 0x10325476;
        anP = 0xc3d2e1f0;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((RIPEMD160Digest)memoable);
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
        return "RIPEMD160";
    }

    public final int _mth14AF()
    {
        return 20;
    }

    public final Memoable _mth14B7()
    {
        return new RIPEMD160Digest(this);
    }

    protected final void _mth14BA()
    {
        int k2 = anS;
        int k = anM;
        int j1 = anN;
        int i = anO;
        int l = anP;
        int i1 = (k ^ j1 ^ i) + k2 + anQ[0];
        int k1 = (i1 << 11 | i1 >>> 21) + l;
        int l1 = j1 << 10 | j1 >>> 22;
        i1 = (k1 ^ k ^ l1) + l + anQ[1];
        int i2 = (i1 << 14 | i1 >>> 18) + i;
        int j2 = k << 10 | k >>> 22;
        i1 = (i2 ^ k1 ^ j2) + i + anQ[2];
        i1 = (i1 << 15 | i1 >>> 17) + l1;
        k1 = k1 << 10 | k1 >>> 22;
        l1 = (i1 ^ i2 ^ k1) + l1 + anQ[3];
        l1 = (l1 << 12 | l1 >>> 20) + j2;
        i2 = i2 << 10 | i2 >>> 22;
        j2 = (l1 ^ i1 ^ i2) + j2 + anQ[4];
        j2 = (j2 << 5 | j2 >>> 27) + k1;
        i1 = i1 << 10 | i1 >>> 22;
        k1 = (j2 ^ l1 ^ i1) + k1 + anQ[5];
        k1 = (k1 << 8 | k1 >>> 24) + i2;
        l1 = l1 << 10 | l1 >>> 22;
        i2 = (k1 ^ j2 ^ l1) + i2 + anQ[6];
        i2 = (i2 << 7 | i2 >>> 25) + i1;
        j2 = j2 << 10 | j2 >>> 22;
        i1 = (i2 ^ k1 ^ j2) + i1 + anQ[7];
        i1 = (i1 << 9 | i1 >>> 23) + l1;
        k1 = k1 << 10 | k1 >>> 22;
        l1 = (i1 ^ i2 ^ k1) + l1 + anQ[8];
        l1 = (l1 << 11 | l1 >>> 21) + j2;
        i2 = i2 << 10 | i2 >>> 22;
        j2 = (l1 ^ i1 ^ i2) + j2 + anQ[9];
        j2 = (j2 << 13 | j2 >>> 19) + k1;
        i1 = i1 << 10 | i1 >>> 22;
        k1 = (j2 ^ l1 ^ i1) + k1 + anQ[10];
        k1 = (k1 << 14 | k1 >>> 18) + i2;
        l1 = l1 << 10 | l1 >>> 22;
        i2 = (k1 ^ j2 ^ l1) + i2 + anQ[11];
        i2 = (i2 << 15 | i2 >>> 17) + i1;
        j2 = j2 << 10 | j2 >>> 22;
        i1 = (i2 ^ k1 ^ j2) + i1 + anQ[12];
        int l2 = (i1 << 6 | i1 >>> 26) + l1;
        int i3 = k1 << 10 | k1 >>> 22;
        i1 = (l2 ^ i2 ^ i3) + l1 + anQ[13];
        int j3 = (i1 << 7 | i1 >>> 25) + j2;
        i1 = i2 << 10 | i2 >>> 22;
        k1 = (j3 ^ l2 ^ i1) + j2 + anQ[14];
        k1 = (k1 << 9 | k1 >>> 23) + i3;
        l1 = l2 << 10 | l2 >>> 22;
        i2 = (k1 ^ j3 ^ l1) + i3 + anQ[15];
        i2 = (i2 << 8 | i2 >>> 24) + i1;
        j2 = j3 << 10 | j3 >>> 22;
        k2 = ((~i | j1) ^ k) + k2 + anQ[5] + 0x50a28be6;
        k2 = (k2 << 8 | k2 >>> 24) + l;
        j1 = j1 << 10 | j1 >>> 22;
        l = ((~j1 | k) ^ k2) + l + anQ[14] + 0x50a28be6;
        l = (l << 9 | l >>> 23) + i;
        k = k << 10 | k >>> 22;
        i = ((~k | k2) ^ l) + i + anQ[7] + 0x50a28be6;
        i = (i << 9 | i >>> 23) + j1;
        k2 = k2 << 10 | k2 >>> 22;
        j1 = ((~k2 | l) ^ i) + j1 + anQ[0] + 0x50a28be6;
        j1 = (j1 << 11 | j1 >>> 21) + k;
        l = l << 10 | l >>> 22;
        k = ((~l | i) ^ j1) + k + anQ[9] + 0x50a28be6;
        k = (k << 13 | k >>> 19) + k2;
        i = i << 10 | i >>> 22;
        k2 = ((~i | j1) ^ k) + k2 + anQ[2] + 0x50a28be6;
        k2 = (k2 << 15 | k2 >>> 17) + l;
        j1 = j1 << 10 | j1 >>> 22;
        l = ((~j1 | k) ^ k2) + l + anQ[11] + 0x50a28be6;
        l = (l << 15 | l >>> 17) + i;
        k = k << 10 | k >>> 22;
        i = ((~k | k2) ^ l) + i + anQ[4] + 0x50a28be6;
        i = (i << 5 | i >>> 27) + j1;
        k2 = k2 << 10 | k2 >>> 22;
        j1 = FB1D(_mth02CD(i, l, k2) + j1 + anQ[13] + 0x50a28be6, 7) + k;
        l = FB1D(l, 10);
        k = FB1D(_mth02CD(j1, i, l) + k + anQ[6] + 0x50a28be6, 7) + k2;
        i = FB1D(i, 10);
        k2 = FB1D(_mth02CD(k, j1, i) + k2 + anQ[15] + 0x50a28be6, 8) + l;
        j1 = FB1D(j1, 10);
        l = FB1D(_mth02CD(k2, k, j1) + l + anQ[8] + 0x50a28be6, 11) + i;
        k = FB1D(k, 10);
        l2 = FB1D(_mth02CD(l, k2, k) + i + anQ[1] + 0x50a28be6, 14) + j1;
        k2 = FB1D(k2, 10);
        i3 = FB1D(_mth02CD(l2, l, k2) + j1 + anQ[10] + 0x50a28be6, 14) + k;
        i = FB1D(l, 10);
        k = FB1D(_mth02CD(i3, l2, i) + k + anQ[3] + 0x50a28be6, 12) + k2;
        l = FB1D(l2, 10);
        j1 = FB1D(_mth02CD(k, i3, l) + k2 + anQ[12] + 0x50a28be6, 6) + i;
        k2 = FB1D(i3, 10);
        i1 = FB1D(_mth02C8(i2, k1, j2) + i1 + anQ[7] + 0x5a827999, 7) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C8(i1, i2, k1) + l1 + anQ[4] + 0x5a827999, 6) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, i1, i2) + j2 + anQ[13] + 0x5a827999, 8) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D(_mth02C8(j2, l1, i1) + k1 + anQ[1] + 0x5a827999, 13) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C8(k1, j2, l1) + i2 + anQ[10] + 0x5a827999, 11) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D(_mth02C8(i2, k1, j2) + i1 + anQ[6] + 0x5a827999, 9) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C8(i1, i2, k1) + l1 + anQ[15] + 0x5a827999, 7) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, i1, i2) + j2 + anQ[3] + 0x5a827999, 15) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D(_mth02C8(j2, l1, i1) + k1 + anQ[12] + 0x5a827999, 7) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C8(k1, j2, l1) + i2 + anQ[0] + 0x5a827999, 12) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D(_mth02C8(i2, k1, j2) + i1 + anQ[9] + 0x5a827999, 15) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C8(i1, i2, k1) + l1 + anQ[5] + 0x5a827999, 9) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, i1, i2) + j2 + anQ[2] + 0x5a827999, 11) + k1;
        l2 = FB1D(i1, 10);
        i3 = FB1D(_mth02C8(j2, l1, l2) + k1 + anQ[14] + 0x5a827999, 7) + i2;
        i1 = FB1D(l1, 10);
        k1 = FB1D(_mth02C8(i3, j2, i1) + i2 + anQ[11] + 0x5a827999, 13) + l2;
        l1 = FB1D(j2, 10);
        i2 = FB1D(_mth02C8(k1, i3, l1) + l2 + anQ[8] + 0x5a827999, 12) + i1;
        j2 = FB1D(i3, 10);
        i = FB1D(_mth02CC(j1, k, k2) + i + anQ[6] + 0x5c4dd124, 9) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02CC(i, j1, k) + l + anQ[11] + 0x5c4dd124, 13) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02CC(l, i, j1) + k2 + anQ[3] + 0x5c4dd124, 15) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02CC(k2, l, i) + k + anQ[7] + 0x5c4dd124, 7) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02CC(k, k2, l) + j1 + anQ[0] + 0x5c4dd124, 12) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02CC(j1, k, k2) + i + anQ[13] + 0x5c4dd124, 8) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02CC(i, j1, k) + l + anQ[5] + 0x5c4dd124, 9) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02CC(l, i, j1) + k2 + anQ[10] + 0x5c4dd124, 11) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02CC(k2, l, i) + k + anQ[14] + 0x5c4dd124, 7) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02CC(k, k2, l) + j1 + anQ[15] + 0x5c4dd124, 7) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02CC(j1, k, k2) + i + anQ[8] + 0x5c4dd124, 12) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02CC(i, j1, k) + l + anQ[12] + 0x5c4dd124, 7) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02CC(l, i, j1) + k2 + anQ[4] + 0x5c4dd124, 6) + k;
        l2 = FB1D(i, 10);
        i3 = FB1D(_mth02CC(k2, l, l2) + k + anQ[9] + 0x5c4dd124, 15) + j1;
        i = FB1D(l, 10);
        k = FB1D(_mth02CC(i3, k2, i) + j1 + anQ[1] + 0x5c4dd124, 13) + l2;
        l = FB1D(k2, 10);
        j1 = FB1D(_mth02CC(k, i3, l) + l2 + anQ[2] + 0x5c4dd124, 11) + i;
        k2 = FB1D(i3, 10);
        i1 = FB1D(_mth02C9(i2, k1, j2) + i1 + anQ[3] + 0x6ed9eba1, 11) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C9(i1, i2, k1) + l1 + anQ[10] + 0x6ed9eba1, 13) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, i1, i2) + j2 + anQ[14] + 0x6ed9eba1, 6) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D(_mth02C9(j2, l1, i1) + k1 + anQ[4] + 0x6ed9eba1, 7) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C9(k1, j2, l1) + i2 + anQ[9] + 0x6ed9eba1, 14) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D(_mth02C9(i2, k1, j2) + i1 + anQ[15] + 0x6ed9eba1, 9) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C9(i1, i2, k1) + l1 + anQ[8] + 0x6ed9eba1, 13) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, i1, i2) + j2 + anQ[1] + 0x6ed9eba1, 15) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D(_mth02C9(j2, l1, i1) + k1 + anQ[2] + 0x6ed9eba1, 14) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C9(k1, j2, l1) + i2 + anQ[7] + 0x6ed9eba1, 8) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D(_mth02C9(i2, k1, j2) + i1 + anQ[0] + 0x6ed9eba1, 13) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D(_mth02C9(i1, i2, k1) + l1 + anQ[6] + 0x6ed9eba1, 6) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, i1, i2) + j2 + anQ[13] + 0x6ed9eba1, 5) + k1;
        l2 = FB1D(i1, 10);
        i3 = FB1D(_mth02C9(j2, l1, l2) + k1 + anQ[11] + 0x6ed9eba1, 12) + i2;
        i1 = FB1D(l1, 10);
        k1 = FB1D(_mth02C9(i3, j2, i1) + i2 + anQ[5] + 0x6ed9eba1, 7) + l2;
        l1 = FB1D(j2, 10);
        i2 = FB1D(_mth02C9(k1, i3, l1) + l2 + anQ[12] + 0x6ed9eba1, 5) + i1;
        j2 = FB1D(i3, 10);
        i = FB1D(_mth02C9(j1, k, k2) + i + anQ[15] + 0x6d703ef3, 9) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C9(i, j1, k) + l + anQ[5] + 0x6d703ef3, 7) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C9(l, i, j1) + k2 + anQ[1] + 0x6d703ef3, 15) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02C9(k2, l, i) + k + anQ[3] + 0x6d703ef3, 11) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02C9(k, k2, l) + j1 + anQ[7] + 0x6d703ef3, 8) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C9(j1, k, k2) + i + anQ[14] + 0x6d703ef3, 6) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C9(i, j1, k) + l + anQ[6] + 0x6d703ef3, 6) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C9(l, i, j1) + k2 + anQ[9] + 0x6d703ef3, 14) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02C9(k2, l, i) + k + anQ[11] + 0x6d703ef3, 12) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02C9(k, k2, l) + j1 + anQ[8] + 0x6d703ef3, 13) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C9(j1, k, k2) + i + anQ[12] + 0x6d703ef3, 5) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C9(i, j1, k) + l + anQ[2] + 0x6d703ef3, 14) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C9(l, i, j1) + k2 + anQ[10] + 0x6d703ef3, 13) + k;
        l2 = FB1D(i, 10);
        i3 = FB1D(_mth02C9(k2, l, l2) + k + anQ[0] + 0x6d703ef3, 13) + j1;
        i = FB1D(l, 10);
        k = FB1D(_mth02C9(i3, k2, i) + j1 + anQ[4] + 0x6d703ef3, 7) + l2;
        l = FB1D(k2, 10);
        j1 = FB1D(_mth02C9(k, i3, l) + l2 + anQ[13] + 0x6d703ef3, 5) + i;
        k2 = FB1D(i3, 10);
        i1 = FB1D((_mth02CC(i2, k1, j2) + i1 + anQ[1]) - 0x70e44324, 11) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CC(i1, i2, k1) + l1 + anQ[9]) - 0x70e44324, 12) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CC(l1, i1, i2) + j2 + anQ[11]) - 0x70e44324, 14) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D((_mth02CC(j2, l1, i1) + k1 + anQ[10]) - 0x70e44324, 15) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CC(k1, j2, l1) + i2 + anQ[0]) - 0x70e44324, 14) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D((_mth02CC(i2, k1, j2) + i1 + anQ[8]) - 0x70e44324, 15) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CC(i1, i2, k1) + l1 + anQ[12]) - 0x70e44324, 9) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CC(l1, i1, i2) + j2 + anQ[4]) - 0x70e44324, 8) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D((_mth02CC(j2, l1, i1) + k1 + anQ[13]) - 0x70e44324, 9) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CC(k1, j2, l1) + i2 + anQ[3]) - 0x70e44324, 14) + i1;
        j2 = FB1D(j2, 10);
        i1 = FB1D((_mth02CC(i2, k1, j2) + i1 + anQ[7]) - 0x70e44324, 5) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CC(i1, i2, k1) + l1 + anQ[15]) - 0x70e44324, 6) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CC(l1, i1, i2) + j2 + anQ[14]) - 0x70e44324, 8) + k1;
        l2 = FB1D(i1, 10);
        i3 = FB1D((_mth02CC(j2, l1, l2) + k1 + anQ[5]) - 0x70e44324, 6) + i2;
        i1 = FB1D(l1, 10);
        k1 = FB1D((_mth02CC(i3, j2, i1) + i2 + anQ[6]) - 0x70e44324, 5) + l2;
        l1 = FB1D(j2, 10);
        i2 = FB1D((_mth02CC(k1, i3, l1) + l2 + anQ[2]) - 0x70e44324, 12) + i1;
        j2 = FB1D(i3, 10);
        i = FB1D(_mth02C8(j1, k, k2) + i + anQ[8] + 0x7a6d76e9, 15) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C8(i, j1, k) + l + anQ[6] + 0x7a6d76e9, 5) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C8(l, i, j1) + k2 + anQ[4] + 0x7a6d76e9, 8) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02C8(k2, l, i) + k + anQ[1] + 0x7a6d76e9, 11) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02C8(k, k2, l) + j1 + anQ[3] + 0x7a6d76e9, 14) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C8(j1, k, k2) + i + anQ[11] + 0x7a6d76e9, 14) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C8(i, j1, k) + l + anQ[15] + 0x7a6d76e9, 6) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C8(l, i, j1) + k2 + anQ[0] + 0x7a6d76e9, 14) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02C8(k2, l, i) + k + anQ[5] + 0x7a6d76e9, 6) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02C8(k, k2, l) + j1 + anQ[12] + 0x7a6d76e9, 9) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C8(j1, k, k2) + i + anQ[2] + 0x7a6d76e9, 12) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C8(i, j1, k) + l + anQ[13] + 0x7a6d76e9, 9) + k2;
        j1 = FB1D(j1, 10);
        k2 = FB1D(_mth02C8(l, i, j1) + k2 + anQ[9] + 0x7a6d76e9, 12) + k;
        i = FB1D(i, 10);
        l2 = FB1D(_mth02C8(k2, l, i) + k + anQ[7] + 0x7a6d76e9, 5) + j1;
        k = FB1D(l, 10);
        l = FB1D(_mth02C8(l2, k2, k) + j1 + anQ[10] + 0x7a6d76e9, 15) + i;
        j1 = FB1D(k2, 10);
        k2 = FB1D(_mth02C8(l, l2, j1) + i + anQ[14] + 0x7a6d76e9, 8) + k;
        l2 = FB1D(l2, 10);
        i = FB1D((_mth02CD(i2, k1, j2) + i1 + anQ[4]) - 0x56ac02b2, 9) + l1;
        i1 = FB1D(k1, 10);
        k1 = FB1D((_mth02CD(i, i2, i1) + l1 + anQ[0]) - 0x56ac02b2, 15) + j2;
        l1 = FB1D(i2, 10);
        i2 = FB1D((_mth02CD(k1, i, l1) + j2 + anQ[5]) - 0x56ac02b2, 5) + i1;
        i = FB1D(i, 10);
        i1 = FB1D((_mth02CD(i2, k1, i) + i1 + anQ[9]) - 0x56ac02b2, 11) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CD(i1, i2, k1) + l1 + anQ[7]) - 0x56ac02b2, 6) + i;
        i2 = FB1D(i2, 10);
        i = FB1D((_mth02CD(l1, i1, i2) + i + anQ[12]) - 0x56ac02b2, 8) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D((_mth02CD(i, l1, i1) + k1 + anQ[2]) - 0x56ac02b2, 13) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CD(k1, i, l1) + i2 + anQ[10]) - 0x56ac02b2, 12) + i1;
        i = FB1D(i, 10);
        i1 = FB1D((_mth02CD(i2, k1, i) + i1 + anQ[14]) - 0x56ac02b2, 5) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CD(i1, i2, k1) + l1 + anQ[1]) - 0x56ac02b2, 12) + i;
        i2 = FB1D(i2, 10);
        i = FB1D((_mth02CD(l1, i1, i2) + i + anQ[3]) - 0x56ac02b2, 13) + k1;
        i1 = FB1D(i1, 10);
        k1 = FB1D((_mth02CD(i, l1, i1) + k1 + anQ[8]) - 0x56ac02b2, 14) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CD(k1, i, l1) + i2 + anQ[11]) - 0x56ac02b2, 11) + i1;
        j2 = FB1D(i, 10);
        i3 = FB1D((_mth02CD(i2, k1, j2) + i1 + anQ[6]) - 0x56ac02b2, 8) + l1;
        i = FB1D(k1, 10);
        i1 = FB1D((_mth02CD(i3, i2, i) + l1 + anQ[15]) - 0x56ac02b2, 5) + j2;
        k1 = FB1D(i2, 10);
        l1 = FB1D((_mth02CD(i1, i3, k1) + j2 + anQ[13]) - 0x56ac02b2, 6);
        i2 = FB1D(i3, 10);
        k = FB1D(_mth02BF(k2, l, l2) + k + anQ[12], 8) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02BF(k, k2, l) + j1 + anQ[15], 5) + l2;
        j2 = FB1D(k2, 10);
        k2 = FB1D(_mth02BF(j1, k, j2) + l2 + anQ[10], 12) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02BF(k2, j1, k) + l + anQ[4], 9) + j2;
        j1 = FB1D(j1, 10);
        j2 = FB1D(_mth02BF(l, k2, j1) + j2 + anQ[1], 12) + k;
        k2 = FB1D(k2, 10);
        k = FB1D(_mth02BF(j2, l, k2) + k + anQ[5], 5) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02BF(k, j2, l) + j1 + anQ[8], 14) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D(_mth02BF(j1, k, j2) + k2 + anQ[7], 6) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02BF(k2, j1, k) + l + anQ[6], 8) + j2;
        j1 = FB1D(j1, 10);
        j2 = FB1D(_mth02BF(l, k2, j1) + j2 + anQ[2], 13) + k;
        k2 = FB1D(k2, 10);
        k = FB1D(_mth02BF(j2, l, k2) + k + anQ[13], 6) + j1;
        l = FB1D(l, 10);
        j1 = FB1D(_mth02BF(k, j2, l) + j1 + anQ[14], 5) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D(_mth02BF(j1, k, j2) + k2 + anQ[0], 15) + l;
        l2 = FB1D(k, 10);
        l = FB1D(_mth02BF(k2, j1, l2) + l + anQ[3], 13) + j2;
        k = FB1D(j1, 10);
        j1 = FB1D(_mth02BF(l, k2, k) + j2 + anQ[9], 11) + l2;
        j2 = FB1D(k2, 10);
        k2 = FB1D(_mth02BF(j1, l, j2) + l2 + anQ[11], 11);
        l = FB1D(l, 10);
        l2 = anM;
        anM = anN + i2 + j2;
        anN = anO + k1 + k;
        anO = anP + i + (k2 + k);
        anP = anS + (l1 + i) + j1;
        anS = l + (l2 + i1);
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
