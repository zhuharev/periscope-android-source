// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class RIPEMD320Digest extends GeneralDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];
    private int anS;
    private int anT;
    private int anU;
    private int anV;
    private int anW;
    private int anX;

    public RIPEMD320Digest()
    {
        anQ = new int[16];
        reset();
    }

    public RIPEMD320Digest(RIPEMD320Digest ripemd320digest)
    {
        super(ripemd320digest);
        anQ = new int[16];
        _mth02CA(ripemd320digest);
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

    private void _mth02CA(RIPEMD320Digest ripemd320digest)
    {
        System.arraycopy(((GeneralDigest) (ripemd320digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (ripemd320digest)).ani;
        super.VD = ((GeneralDigest) (ripemd320digest)).VD;
        anS = ripemd320digest.anS;
        anM = ripemd320digest.anM;
        anN = ripemd320digest.anN;
        anO = ripemd320digest.anO;
        anP = ripemd320digest.anP;
        anT = ripemd320digest.anT;
        anU = ripemd320digest.anU;
        anV = ripemd320digest.anV;
        anW = ripemd320digest.anW;
        anX = ripemd320digest.anX;
        System.arraycopy(ripemd320digest.anQ, 0, anQ, 0, ripemd320digest.anQ.length);
        anI = ripemd320digest.anI;
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
        _mth02CA(anT, abyte0, i + 20);
        _mth02CA(anU, abyte0, i + 24);
        _mth02CA(anV, abyte0, i + 28);
        _mth02CA(anW, abyte0, i + 32);
        _mth02CA(anX, abyte0, i + 36);
        reset();
        return 40;
    }

    public final void reset()
    {
        super.reset();
        anS = 0x67452301;
        anM = 0xefcdab89;
        anN = 0x98badcfe;
        anO = 0x10325476;
        anP = 0xc3d2e1f0;
        anT = 0x76543210;
        anU = 0xfedcba98;
        anV = 0x89abcdef;
        anW = 0x1234567;
        anX = 0x3c2d1e0f;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((RIPEMD320Digest)memoable);
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
        return "RIPEMD320";
    }

    public final int _mth14AF()
    {
        return 40;
    }

    public final Memoable _mth14B7()
    {
        return new RIPEMD320Digest(this);
    }

    protected final void _mth14BA()
    {
        int l1 = anS;
        int k2 = anM;
        int i2 = anN;
        int i = anO;
        int j2 = anP;
        int k1 = anT;
        int l = anU;
        int j1 = anV;
        int k = anW;
        int i1 = anX;
        l1 = (k2 ^ i2 ^ i) + l1 + anQ[0];
        l1 = (l1 << 11 | l1 >>> 21) + j2;
        i2 = i2 << 10 | i2 >>> 22;
        j2 = (l1 ^ k2 ^ i2) + j2 + anQ[1];
        j2 = (j2 << 14 | j2 >>> 18) + i;
        k2 = k2 << 10 | k2 >>> 22;
        i = (j2 ^ l1 ^ k2) + i + anQ[2];
        i = (i << 15 | i >>> 17) + i2;
        l1 = l1 << 10 | l1 >>> 22;
        i2 = (i ^ j2 ^ l1) + i2 + anQ[3];
        i2 = (i2 << 12 | i2 >>> 20) + k2;
        j2 = j2 << 10 | j2 >>> 22;
        k2 = (i2 ^ i ^ j2) + k2 + anQ[4];
        k2 = (k2 << 5 | k2 >>> 27) + l1;
        i = i << 10 | i >>> 22;
        l1 = (k2 ^ i2 ^ i) + l1 + anQ[5];
        l1 = (l1 << 8 | l1 >>> 24) + j2;
        i2 = i2 << 10 | i2 >>> 22;
        j2 = (l1 ^ k2 ^ i2) + j2 + anQ[6];
        j2 = (j2 << 7 | j2 >>> 25) + i;
        k2 = k2 << 10 | k2 >>> 22;
        i = (j2 ^ l1 ^ k2) + i + anQ[7];
        i = (i << 9 | i >>> 23) + i2;
        l1 = l1 << 10 | l1 >>> 22;
        i2 = (i ^ j2 ^ l1) + i2 + anQ[8];
        i2 = (i2 << 11 | i2 >>> 21) + k2;
        j2 = j2 << 10 | j2 >>> 22;
        k2 = (i2 ^ i ^ j2) + k2 + anQ[9];
        k2 = (k2 << 13 | k2 >>> 19) + l1;
        i = i << 10 | i >>> 22;
        l1 = (k2 ^ i2 ^ i) + l1 + anQ[10];
        l1 = (l1 << 14 | l1 >>> 18) + j2;
        i2 = i2 << 10 | i2 >>> 22;
        j2 = (l1 ^ k2 ^ i2) + j2 + anQ[11];
        j2 = (j2 << 15 | j2 >>> 17) + i;
        k2 = k2 << 10 | k2 >>> 22;
        i = (j2 ^ l1 ^ k2) + i + anQ[12];
        i = (i << 6 | i >>> 26) + i2;
        int l2 = l1 << 10 | l1 >>> 22;
        l1 = (i ^ j2 ^ l2) + i2 + anQ[13];
        int i3 = (l1 << 7 | l1 >>> 25) + k2;
        l1 = j2 << 10 | j2 >>> 22;
        i2 = (i3 ^ i ^ l1) + k2 + anQ[14];
        i2 = (i2 << 9 | i2 >>> 23) + l2;
        j2 = i << 10 | i >>> 22;
        i = (i2 ^ i3 ^ j2) + l2 + anQ[15];
        i = (i << 8 | i >>> 24) + l1;
        k2 = i3 << 10 | i3 >>> 22;
        k1 = ((~k | j1) ^ l) + k1 + anQ[5] + 0x50a28be6;
        k1 = (k1 << 8 | k1 >>> 24) + i1;
        j1 = j1 << 10 | j1 >>> 22;
        i1 = ((~j1 | l) ^ k1) + i1 + anQ[14] + 0x50a28be6;
        i1 = (i1 << 9 | i1 >>> 23) + k;
        l = l << 10 | l >>> 22;
        k = ((~l | k1) ^ i1) + k + anQ[7] + 0x50a28be6;
        k = (k << 9 | k >>> 23) + j1;
        k1 = k1 << 10 | k1 >>> 22;
        j1 = ((~k1 | i1) ^ k) + j1 + anQ[0] + 0x50a28be6;
        j1 = (j1 << 11 | j1 >>> 21) + l;
        i1 = i1 << 10 | i1 >>> 22;
        l = ((~i1 | k) ^ j1) + l + anQ[9] + 0x50a28be6;
        l = (l << 13 | l >>> 19) + k1;
        k = FB1D(k, 10);
        k1 = FB1D(((~k | j1) ^ l) + k1 + anQ[2] + 0x50a28be6, 15) + i1;
        j1 = FB1D(j1, 10);
        i1 = FB1D(_mth02CD(k1, l, j1) + i1 + anQ[11] + 0x50a28be6, 15) + k;
        l = FB1D(l, 10);
        k = FB1D(_mth02CD(i1, k1, l) + k + anQ[4] + 0x50a28be6, 5) + j1;
        k1 = FB1D(k1, 10);
        j1 = FB1D(_mth02CD(k, i1, k1) + j1 + anQ[13] + 0x50a28be6, 7) + l;
        i1 = FB1D(i1, 10);
        l = FB1D(_mth02CD(j1, k, i1) + l + anQ[6] + 0x50a28be6, 7) + k1;
        k = FB1D(k, 10);
        k1 = FB1D(_mth02CD(l, j1, k) + k1 + anQ[15] + 0x50a28be6, 8) + i1;
        j1 = FB1D(j1, 10);
        i1 = FB1D(_mth02CD(k1, l, j1) + i1 + anQ[8] + 0x50a28be6, 11) + k;
        l2 = FB1D(l, 10);
        k = FB1D(_mth02CD(i1, k1, l2) + k + anQ[1] + 0x50a28be6, 14) + j1;
        k1 = FB1D(k1, 10);
        i3 = FB1D(_mth02CD(k, i1, k1) + j1 + anQ[10] + 0x50a28be6, 14) + l2;
        l = FB1D(i1, 10);
        i1 = FB1D(_mth02CD(i3, k, l) + l2 + anQ[3] + 0x50a28be6, 12) + k1;
        j1 = FB1D(k, 10);
        k = FB1D(_mth02CD(i1, i3, j1) + k1 + anQ[12] + 0x50a28be6, 6) + l;
        k1 = FB1D(i3, 10);
        l1 = FB1D(_mth02C8(k, i2, k2) + l1 + anQ[7] + 0x5a827999, 7) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, k, i2) + j2 + anQ[4] + 0x5a827999, 6) + k2;
        k = FB1D(k, 10);
        k2 = FB1D(_mth02C8(j2, l1, k) + k2 + anQ[13] + 0x5a827999, 8) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C8(k2, j2, l1) + i2 + anQ[1] + 0x5a827999, 13) + k;
        j2 = FB1D(j2, 10);
        k = FB1D(_mth02C8(i2, k2, j2) + k + anQ[10] + 0x5a827999, 11) + l1;
        k2 = FB1D(k2, 10);
        l1 = FB1D(_mth02C8(k, i2, k2) + l1 + anQ[6] + 0x5a827999, 9) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, k, i2) + j2 + anQ[15] + 0x5a827999, 7) + k2;
        k = FB1D(k, 10);
        k2 = FB1D(_mth02C8(j2, l1, k) + k2 + anQ[3] + 0x5a827999, 15) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C8(k2, j2, l1) + i2 + anQ[12] + 0x5a827999, 7) + k;
        j2 = FB1D(j2, 10);
        k = FB1D(_mth02C8(i2, k2, j2) + k + anQ[0] + 0x5a827999, 12) + l1;
        k2 = FB1D(k2, 10);
        l1 = FB1D(_mth02C8(k, i2, k2) + l1 + anQ[9] + 0x5a827999, 15) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C8(l1, k, i2) + j2 + anQ[5] + 0x5a827999, 9) + k2;
        k = FB1D(k, 10);
        k2 = FB1D(_mth02C8(j2, l1, k) + k2 + anQ[2] + 0x5a827999, 11) + i2;
        l2 = FB1D(l1, 10);
        i3 = FB1D(_mth02C8(k2, j2, l2) + i2 + anQ[14] + 0x5a827999, 7) + k;
        l1 = FB1D(j2, 10);
        i2 = FB1D(_mth02C8(i3, k2, l1) + k + anQ[11] + 0x5a827999, 13) + l2;
        j2 = FB1D(k2, 10);
        k2 = FB1D(_mth02C8(i2, i3, j2) + l2 + anQ[8] + 0x5a827999, 12) + l1;
        k = FB1D(i3, 10);
        l = FB1D(_mth02CC(i, i1, k1) + l + anQ[6] + 0x5c4dd124, 9) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02CC(l, i, i1) + j1 + anQ[11] + 0x5c4dd124, 13) + k1;
        i = FB1D(i, 10);
        k1 = FB1D(_mth02CC(j1, l, i) + k1 + anQ[3] + 0x5c4dd124, 15) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02CC(k1, j1, l) + i1 + anQ[7] + 0x5c4dd124, 7) + i;
        j1 = FB1D(j1, 10);
        i = FB1D(_mth02CC(i1, k1, j1) + i + anQ[0] + 0x5c4dd124, 12) + l;
        k1 = FB1D(k1, 10);
        l = FB1D(_mth02CC(i, i1, k1) + l + anQ[13] + 0x5c4dd124, 8) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02CC(l, i, i1) + j1 + anQ[5] + 0x5c4dd124, 9) + k1;
        i = FB1D(i, 10);
        k1 = FB1D(_mth02CC(j1, l, i) + k1 + anQ[10] + 0x5c4dd124, 11) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02CC(k1, j1, l) + i1 + anQ[14] + 0x5c4dd124, 7) + i;
        j1 = FB1D(j1, 10);
        i = FB1D(_mth02CC(i1, k1, j1) + i + anQ[15] + 0x5c4dd124, 7) + l;
        k1 = FB1D(k1, 10);
        l = FB1D(_mth02CC(i, i1, k1) + l + anQ[8] + 0x5c4dd124, 12) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02CC(l, i, i1) + j1 + anQ[12] + 0x5c4dd124, 7) + k1;
        i = FB1D(i, 10);
        k1 = FB1D(_mth02CC(j1, l, i) + k1 + anQ[4] + 0x5c4dd124, 6) + i1;
        l2 = FB1D(l, 10);
        i3 = FB1D(_mth02CC(k1, j1, l2) + i1 + anQ[9] + 0x5c4dd124, 15) + i;
        l = FB1D(j1, 10);
        i1 = FB1D(_mth02CC(i3, k1, l) + i + anQ[1] + 0x5c4dd124, 13) + l2;
        j1 = FB1D(k1, 10);
        k1 = FB1D(_mth02CC(i1, i3, j1) + l2 + anQ[2] + 0x5c4dd124, 11) + l;
        i = FB1D(i3, 10);
        l1 = FB1D(_mth02C9(k2, i2, i) + l1 + anQ[3] + 0x6ed9eba1, 11) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, k2, i2) + j2 + anQ[10] + 0x6ed9eba1, 13) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C9(j2, l1, k2) + i + anQ[14] + 0x6ed9eba1, 6) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C9(i, j2, l1) + i2 + anQ[4] + 0x6ed9eba1, 7) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D(_mth02C9(i2, i, j2) + k2 + anQ[9] + 0x6ed9eba1, 14) + l1;
        i = FB1D(i, 10);
        l1 = FB1D(_mth02C9(k2, i2, i) + l1 + anQ[15] + 0x6ed9eba1, 9) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, k2, i2) + j2 + anQ[8] + 0x6ed9eba1, 13) + i;
        k2 = FB1D(k2, 10);
        i = FB1D(_mth02C9(j2, l1, k2) + i + anQ[1] + 0x6ed9eba1, 15) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D(_mth02C9(i, j2, l1) + i2 + anQ[2] + 0x6ed9eba1, 14) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D(_mth02C9(i2, i, j2) + k2 + anQ[7] + 0x6ed9eba1, 8) + l1;
        i = FB1D(i, 10);
        l1 = FB1D(_mth02C9(k2, i2, i) + l1 + anQ[0] + 0x6ed9eba1, 13) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D(_mth02C9(l1, k2, i2) + j2 + anQ[6] + 0x6ed9eba1, 6) + i;
        k2 = FB1D(k2, 10);
        l2 = FB1D(_mth02C9(j2, l1, k2) + i + anQ[13] + 0x6ed9eba1, 5) + i2;
        i3 = FB1D(l1, 10);
        int j3 = FB1D(_mth02C9(l2, j2, i3) + i2 + anQ[11] + 0x6ed9eba1, 12) + k2;
        i = FB1D(j2, 10);
        l1 = FB1D(_mth02C9(j3, l2, i) + k2 + anQ[5] + 0x6ed9eba1, 7) + i3;
        i2 = FB1D(l2, 10);
        j2 = FB1D(_mth02C9(l1, j3, i2) + i3 + anQ[12] + 0x6ed9eba1, 5) + i;
        k2 = FB1D(j3, 10);
        l = FB1D(_mth02C9(k1, i1, k) + l + anQ[15] + 0x6d703ef3, 9) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02C9(l, k1, i1) + j1 + anQ[5] + 0x6d703ef3, 7) + k;
        k1 = FB1D(k1, 10);
        k = FB1D(_mth02C9(j1, l, k1) + k + anQ[1] + 0x6d703ef3, 15) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02C9(k, j1, l) + i1 + anQ[3] + 0x6d703ef3, 11) + k1;
        j1 = FB1D(j1, 10);
        k1 = FB1D(_mth02C9(i1, k, j1) + k1 + anQ[7] + 0x6d703ef3, 8) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C9(k1, i1, k) + l + anQ[14] + 0x6d703ef3, 6) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02C9(l, k1, i1) + j1 + anQ[6] + 0x6d703ef3, 6) + k;
        k1 = FB1D(k1, 10);
        k = FB1D(_mth02C9(j1, l, k1) + k + anQ[9] + 0x6d703ef3, 14) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02C9(k, j1, l) + i1 + anQ[11] + 0x6d703ef3, 12) + k1;
        j1 = FB1D(j1, 10);
        k1 = FB1D(_mth02C9(i1, k, j1) + k1 + anQ[8] + 0x6d703ef3, 13) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02C9(k1, i1, k) + l + anQ[12] + 0x6d703ef3, 5) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02C9(l, k1, i1) + j1 + anQ[2] + 0x6d703ef3, 14) + k;
        k1 = FB1D(k1, 10);
        k = FB1D(_mth02C9(j1, l, k1) + k + anQ[10] + 0x6d703ef3, 13) + i1;
        l2 = FB1D(l, 10);
        i3 = FB1D(_mth02C9(k, j1, l2) + i1 + anQ[0] + 0x6d703ef3, 13) + k1;
        j3 = FB1D(j1, 10);
        l = FB1D(_mth02C9(i3, k, j3) + k1 + anQ[4] + 0x6d703ef3, 7) + l2;
        i1 = FB1D(k, 10);
        j1 = FB1D(_mth02C9(l, i3, i1) + l2 + anQ[13] + 0x6d703ef3, 5) + j3;
        k1 = FB1D(i3, 10);
        k = FB1D((_mth02CC(j2, l1, k2) + j3 + anQ[1]) - 0x70e44324, 11) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CC(k, j2, l1) + i2 + anQ[9]) - 0x70e44324, 12) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CC(i2, k, j2) + k2 + anQ[11]) - 0x70e44324, 14) + l1;
        k = FB1D(k, 10);
        l1 = FB1D((_mth02CC(k2, i2, k) + l1 + anQ[10]) - 0x70e44324, 15) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CC(l1, k2, i2) + j2 + anQ[0]) - 0x70e44324, 14) + k;
        k2 = FB1D(k2, 10);
        k = FB1D((_mth02CC(j2, l1, k2) + k + anQ[8]) - 0x70e44324, 15) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CC(k, j2, l1) + i2 + anQ[12]) - 0x70e44324, 9) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CC(i2, k, j2) + k2 + anQ[4]) - 0x70e44324, 8) + l1;
        k = FB1D(k, 10);
        l1 = FB1D((_mth02CC(k2, i2, k) + l1 + anQ[13]) - 0x70e44324, 9) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CC(l1, k2, i2) + j2 + anQ[3]) - 0x70e44324, 14) + k;
        k2 = FB1D(k2, 10);
        k = FB1D((_mth02CC(j2, l1, k2) + k + anQ[7]) - 0x70e44324, 5) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CC(k, j2, l1) + i2 + anQ[15]) - 0x70e44324, 6) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CC(i2, k, j2) + k2 + anQ[14]) - 0x70e44324, 8) + l1;
        l2 = FB1D(k, 10);
        i3 = FB1D((_mth02CC(k2, i2, l2) + l1 + anQ[5]) - 0x70e44324, 6) + j2;
        l1 = FB1D(i2, 10);
        k = FB1D((_mth02CC(i3, k2, l1) + j2 + anQ[6]) - 0x70e44324, 5) + l2;
        i2 = FB1D(k2, 10);
        j2 = FB1D((_mth02CC(k, i3, i2) + l2 + anQ[2]) - 0x70e44324, 12) + l1;
        k2 = FB1D(i3, 10);
        i = FB1D(_mth02C8(j1, l, k1) + i + anQ[8] + 0x7a6d76e9, 15) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02C8(i, j1, l) + i1 + anQ[6] + 0x7a6d76e9, 5) + k1;
        j1 = FB1D(j1, 10);
        k1 = FB1D(_mth02C8(i1, i, j1) + k1 + anQ[4] + 0x7a6d76e9, 8) + l;
        i = FB1D(i, 10);
        l = FB1D(_mth02C8(k1, i1, i) + l + anQ[1] + 0x7a6d76e9, 11) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02C8(l, k1, i1) + j1 + anQ[3] + 0x7a6d76e9, 14) + i;
        k1 = FB1D(k1, 10);
        i = FB1D(_mth02C8(j1, l, k1) + i + anQ[11] + 0x7a6d76e9, 14) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02C8(i, j1, l) + i1 + anQ[15] + 0x7a6d76e9, 6) + k1;
        j1 = FB1D(j1, 10);
        k1 = FB1D(_mth02C8(i1, i, j1) + k1 + anQ[0] + 0x7a6d76e9, 14) + l;
        i = FB1D(i, 10);
        l = FB1D(_mth02C8(k1, i1, i) + l + anQ[5] + 0x7a6d76e9, 6) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02C8(l, k1, i1) + j1 + anQ[12] + 0x7a6d76e9, 9) + i;
        k1 = FB1D(k1, 10);
        i = FB1D(_mth02C8(j1, l, k1) + i + anQ[2] + 0x7a6d76e9, 12) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02C8(i, j1, l) + i1 + anQ[13] + 0x7a6d76e9, 9) + k1;
        j1 = FB1D(j1, 10);
        k1 = FB1D(_mth02C8(i1, i, j1) + k1 + anQ[9] + 0x7a6d76e9, 12) + l;
        l2 = FB1D(i, 10);
        i3 = FB1D(_mth02C8(k1, i1, l2) + l + anQ[7] + 0x7a6d76e9, 5) + j1;
        i = FB1D(i1, 10);
        j3 = FB1D(_mth02C8(i3, k1, i) + j1 + anQ[10] + 0x7a6d76e9, 15) + l2;
        l = FB1D(k1, 10);
        i1 = FB1D(_mth02C8(j3, i3, l) + l2 + anQ[14] + 0x7a6d76e9, 8) + i;
        j1 = FB1D(i3, 10);
        k1 = FB1D((_mth02CD(j2, j3, k2) + l1 + anQ[4]) - 0x56ac02b2, 9) + i2;
        l1 = FB1D(j3, 10);
        i2 = FB1D((_mth02CD(k1, j2, l1) + i2 + anQ[0]) - 0x56ac02b2, 15) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CD(i2, k1, j2) + k2 + anQ[5]) - 0x56ac02b2, 5) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CD(k2, i2, k1) + l1 + anQ[9]) - 0x56ac02b2, 11) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CD(l1, k2, i2) + j2 + anQ[7]) - 0x56ac02b2, 6) + k1;
        k2 = FB1D(k2, 10);
        k1 = FB1D((_mth02CD(j2, l1, k2) + k1 + anQ[12]) - 0x56ac02b2, 8) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CD(k1, j2, l1) + i2 + anQ[2]) - 0x56ac02b2, 13) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CD(i2, k1, j2) + k2 + anQ[10]) - 0x56ac02b2, 12) + l1;
        k1 = FB1D(k1, 10);
        l1 = FB1D((_mth02CD(k2, i2, k1) + l1 + anQ[14]) - 0x56ac02b2, 5) + j2;
        i2 = FB1D(i2, 10);
        j2 = FB1D((_mth02CD(l1, k2, i2) + j2 + anQ[1]) - 0x56ac02b2, 12) + k1;
        k2 = FB1D(k2, 10);
        k1 = FB1D((_mth02CD(j2, l1, k2) + k1 + anQ[3]) - 0x56ac02b2, 13) + i2;
        l1 = FB1D(l1, 10);
        i2 = FB1D((_mth02CD(k1, j2, l1) + i2 + anQ[8]) - 0x56ac02b2, 14) + k2;
        j2 = FB1D(j2, 10);
        k2 = FB1D((_mth02CD(i2, k1, j2) + k2 + anQ[11]) - 0x56ac02b2, 11) + l1;
        l2 = FB1D(k1, 10);
        i3 = FB1D((_mth02CD(k2, i2, l2) + l1 + anQ[6]) - 0x56ac02b2, 8) + j2;
        k1 = FB1D(i2, 10);
        l1 = FB1D((_mth02CD(i3, k2, k1) + j2 + anQ[15]) - 0x56ac02b2, 5) + l2;
        i2 = FB1D(k2, 10);
        j2 = FB1D((_mth02CD(l1, i3, i2) + l2 + anQ[13]) - 0x56ac02b2, 6);
        k2 = FB1D(i3, 10);
        i = FB1D(_mth02BF(i1, k, j1) + i + anQ[12], 8) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02BF(i, i1, k) + l + anQ[15], 5) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02BF(l, i, i1) + j1 + anQ[10], 12) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02BF(j1, l, i) + k + anQ[4], 9) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02BF(k, j1, l) + i1 + anQ[1], 12) + i;
        j1 = FB1D(j1, 10);
        i = FB1D(_mth02BF(i1, k, j1) + i + anQ[5], 5) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02BF(i, i1, k) + l + anQ[8], 14) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02BF(l, i, i1) + j1 + anQ[7], 6) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02BF(j1, l, i) + k + anQ[6], 8) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02BF(k, j1, l) + i1 + anQ[2], 13) + i;
        j1 = FB1D(j1, 10);
        i = FB1D(_mth02BF(i1, k, j1) + i + anQ[13], 6) + l;
        k = FB1D(k, 10);
        l = FB1D(_mth02BF(i, i1, k) + l + anQ[14], 5) + j1;
        i1 = FB1D(i1, 10);
        j1 = FB1D(_mth02BF(l, i, i1) + j1 + anQ[0], 15) + k;
        i = FB1D(i, 10);
        k = FB1D(_mth02BF(j1, l, i) + k + anQ[3], 13) + i1;
        l = FB1D(l, 10);
        i1 = FB1D(_mth02BF(k, j1, l) + i1 + anQ[9], 11) + i;
        j1 = FB1D(j1, 10);
        i = FB1D(_mth02BF(i1, k, j1) + i + anQ[11], 11);
        k = FB1D(k, 10);
        anS = anS + k1;
        anM = anM + (j2 + k1);
        anN = anN + l1;
        anO = anO + k2;
        anP = anP + j1;
        anT = anT + l;
        anU = anU + (i + l);
        anV = anV + i1;
        anW = anW + k;
        anX = anX + i2;
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
