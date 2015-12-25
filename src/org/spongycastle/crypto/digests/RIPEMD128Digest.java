// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class RIPEMD128Digest extends GeneralDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anQ[];
    private int anS;

    public RIPEMD128Digest()
    {
        anQ = new int[16];
        reset();
    }

    public RIPEMD128Digest(RIPEMD128Digest ripemd128digest)
    {
        super(ripemd128digest);
        anQ = new int[16];
        _mth02CA(ripemd128digest);
    }

    private int _mth02BB(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + (j & k | ~j & l) + i1 + 0x6d703ef3;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth02BC(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + ((j | ~k) ^ l) + i1 + 0x5c4dd124;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth02BD(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + (j & l | ~l & k) + i1 + 0x50a28be6;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth02CA(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + (j ^ k ^ l) + i1;
        return i << j1 | i >>> 32 - j1;
    }

    private static void _mth02CA(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth02CA(RIPEMD128Digest ripemd128digest)
    {
        System.arraycopy(((GeneralDigest) (ripemd128digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (ripemd128digest)).ani;
        super.VD = ((GeneralDigest) (ripemd128digest)).VD;
        anS = ripemd128digest.anS;
        anM = ripemd128digest.anM;
        anN = ripemd128digest.anN;
        anO = ripemd128digest.anO;
        System.arraycopy(ripemd128digest.anQ, 0, anQ, 0, ripemd128digest.anQ.length);
        anI = ripemd128digest.anI;
    }

    private int _mth02CB(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + (j & k | ~j & l) + i1 + 0x5a827999;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth02CE(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + ((j | ~k) ^ l) + i1 + 0x6ed9eba1;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth02CF(int i, int j, int k, int l, int i1, int j1)
    {
        i = (i + (j & l | ~l & k) + i1) - 0x70e44324;
        return i << j1 | i >>> 32 - j1;
    }

    private int _mth141D(int i, int j, int k, int l, int i1, int j1)
    {
        i = i + (j ^ k ^ l) + i1;
        return i << j1 | i >>> 32 - j1;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        _mth02CA(anS, abyte0, i);
        _mth02CA(anM, abyte0, i + 4);
        _mth02CA(anN, abyte0, i + 8);
        _mth02CA(anO, abyte0, i + 12);
        reset();
        return 16;
    }

    public final void reset()
    {
        super.reset();
        anS = 0x67452301;
        anM = 0xefcdab89;
        anN = 0x98badcfe;
        anO = 0x10325476;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((RIPEMD128Digest)memoable);
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
        return "RIPEMD128";
    }

    public final int _mth14AF()
    {
        return 16;
    }

    public final Memoable _mth14B7()
    {
        return new RIPEMD128Digest(this);
    }

    protected final void _mth14BA()
    {
        int i2 = anS;
        int j1 = anM;
        int k1 = anN;
        int l1 = anO;
        int k = _mth02CA(i2, j1, k1, l1, anQ[0], 11);
        int l = _mth02CA(l1, k, j1, k1, anQ[1], 14);
        int i1 = _mth02CA(k1, l, k, j1, anQ[2], 15);
        int i = _mth02CA(j1, i1, l, k, anQ[3], 12);
        k = _mth02CA(k, i, i1, l, anQ[4], 5);
        l = _mth02CA(l, k, i, i1, anQ[5], 8);
        i1 = _mth02CA(i1, l, k, i, anQ[6], 7);
        i = _mth02CA(i, i1, l, k, anQ[7], 9);
        k = _mth02CA(k, i, i1, l, anQ[8], 11);
        l = _mth02CA(l, k, i, i1, anQ[9], 13);
        i1 = _mth02CA(i1, l, k, i, anQ[10], 14);
        i = _mth02CA(i, i1, l, k, anQ[11], 15);
        k = _mth02CA(k, i, i1, l, anQ[12], 6);
        l = _mth02CA(l, k, i, i1, anQ[13], 7);
        i1 = _mth02CA(i1, l, k, i, anQ[14], 9);
        i = _mth02CA(i, i1, l, k, anQ[15], 8);
        k = _mth02CB(k, i, i1, l, anQ[7], 7);
        l = _mth02CB(l, k, i, i1, anQ[4], 6);
        i1 = _mth02CB(i1, l, k, i, anQ[13], 8);
        i = _mth02CB(i, i1, l, k, anQ[1], 13);
        k = _mth02CB(k, i, i1, l, anQ[10], 11);
        l = _mth02CB(l, k, i, i1, anQ[6], 9);
        i1 = _mth02CB(i1, l, k, i, anQ[15], 7);
        i = _mth02CB(i, i1, l, k, anQ[3], 15);
        k = _mth02CB(k, i, i1, l, anQ[12], 7);
        l = _mth02CB(l, k, i, i1, anQ[0], 12);
        i1 = _mth02CB(i1, l, k, i, anQ[9], 15);
        i = _mth02CB(i, i1, l, k, anQ[5], 9);
        k = _mth02CB(k, i, i1, l, anQ[2], 11);
        l = _mth02CB(l, k, i, i1, anQ[14], 7);
        i1 = _mth02CB(i1, l, k, i, anQ[11], 13);
        i = _mth02CB(i, i1, l, k, anQ[8], 12);
        k = _mth02CE(k, i, i1, l, anQ[3], 11);
        l = _mth02CE(l, k, i, i1, anQ[10], 13);
        i1 = _mth02CE(i1, l, k, i, anQ[14], 6);
        i = _mth02CE(i, i1, l, k, anQ[4], 7);
        k = _mth02CE(k, i, i1, l, anQ[9], 14);
        l = _mth02CE(l, k, i, i1, anQ[15], 9);
        i1 = _mth02CE(i1, l, k, i, anQ[8], 13);
        i = _mth02CE(i, i1, l, k, anQ[1], 15);
        k = _mth02CE(k, i, i1, l, anQ[2], 14);
        l = _mth02CE(l, k, i, i1, anQ[7], 8);
        i1 = _mth02CE(i1, l, k, i, anQ[0], 13);
        i = _mth02CE(i, i1, l, k, anQ[6], 6);
        k = _mth02CE(k, i, i1, l, anQ[13], 5);
        l = _mth02CE(l, k, i, i1, anQ[11], 12);
        i1 = _mth02CE(i1, l, k, i, anQ[5], 7);
        i = _mth02CE(i, i1, l, k, anQ[12], 5);
        k = _mth02CF(k, i, i1, l, anQ[1], 11);
        l = _mth02CF(l, k, i, i1, anQ[9], 12);
        i1 = _mth02CF(i1, l, k, i, anQ[11], 14);
        i = _mth02CF(i, i1, l, k, anQ[10], 15);
        k = _mth02CF(k, i, i1, l, anQ[0], 14);
        l = _mth02CF(l, k, i, i1, anQ[8], 15);
        i1 = _mth02CF(i1, l, k, i, anQ[12], 9);
        i = _mth02CF(i, i1, l, k, anQ[4], 8);
        k = _mth02CF(k, i, i1, l, anQ[13], 9);
        l = _mth02CF(l, k, i, i1, anQ[3], 14);
        i1 = _mth02CF(i1, l, k, i, anQ[7], 5);
        int j2 = _mth02CF(i, i1, l, k, anQ[15], 6);
        i = _mth02CF(k, j2, i1, l, anQ[14], 8);
        k = _mth02CF(l, i, j2, i1, anQ[5], 6);
        l = _mth02CF(i1, k, i, j2, anQ[6], 5);
        i1 = _mth02CF(j2, l, k, i, anQ[2], 12);
        i2 = _mth02BD(i2, j1, k1, l1, anQ[5], 8);
        l1 = _mth02BD(l1, i2, j1, k1, anQ[14], 9);
        k1 = _mth02BD(k1, l1, i2, j1, anQ[7], 9);
        j1 = _mth02BD(j1, k1, l1, i2, anQ[0], 11);
        i2 = _mth02BD(i2, j1, k1, l1, anQ[9], 13);
        l1 = _mth02BD(l1, i2, j1, k1, anQ[2], 15);
        k1 = _mth02BD(k1, l1, i2, j1, anQ[11], 15);
        j1 = _mth02BD(j1, k1, l1, i2, anQ[4], 5);
        i2 = _mth02BD(i2, j1, k1, l1, anQ[13], 7);
        l1 = _mth02BD(l1, i2, j1, k1, anQ[6], 7);
        k1 = _mth02BD(k1, l1, i2, j1, anQ[15], 8);
        j1 = _mth02BD(j1, k1, l1, i2, anQ[8], 11);
        i2 = _mth02BD(i2, j1, k1, l1, anQ[1], 14);
        l1 = _mth02BD(l1, i2, j1, k1, anQ[10], 14);
        k1 = _mth02BD(k1, l1, i2, j1, anQ[3], 12);
        j1 = _mth02BD(j1, k1, l1, i2, anQ[12], 6);
        i2 = _mth02BC(i2, j1, k1, l1, anQ[6], 9);
        l1 = _mth02BC(l1, i2, j1, k1, anQ[11], 13);
        k1 = _mth02BC(k1, l1, i2, j1, anQ[3], 15);
        j1 = _mth02BC(j1, k1, l1, i2, anQ[7], 7);
        i2 = _mth02BC(i2, j1, k1, l1, anQ[0], 12);
        l1 = _mth02BC(l1, i2, j1, k1, anQ[13], 8);
        k1 = _mth02BC(k1, l1, i2, j1, anQ[5], 9);
        j1 = _mth02BC(j1, k1, l1, i2, anQ[10], 11);
        i2 = _mth02BC(i2, j1, k1, l1, anQ[14], 7);
        l1 = _mth02BC(l1, i2, j1, k1, anQ[15], 7);
        k1 = _mth02BC(k1, l1, i2, j1, anQ[8], 12);
        j1 = _mth02BC(j1, k1, l1, i2, anQ[12], 7);
        i2 = _mth02BC(i2, j1, k1, l1, anQ[4], 6);
        l1 = _mth02BC(l1, i2, j1, k1, anQ[9], 15);
        k1 = _mth02BC(k1, l1, i2, j1, anQ[1], 13);
        j1 = _mth02BC(j1, k1, l1, i2, anQ[2], 11);
        i2 = _mth02BB(i2, j1, k1, l1, anQ[15], 9);
        l1 = _mth02BB(l1, i2, j1, k1, anQ[5], 7);
        k1 = _mth02BB(k1, l1, i2, j1, anQ[1], 15);
        j1 = _mth02BB(j1, k1, l1, i2, anQ[3], 11);
        i2 = _mth02BB(i2, j1, k1, l1, anQ[7], 8);
        l1 = _mth02BB(l1, i2, j1, k1, anQ[14], 6);
        k1 = _mth02BB(k1, l1, i2, j1, anQ[6], 6);
        j1 = _mth02BB(j1, k1, l1, i2, anQ[9], 14);
        i2 = _mth02BB(i2, j1, k1, l1, anQ[11], 12);
        l1 = _mth02BB(l1, i2, j1, k1, anQ[8], 13);
        k1 = _mth02BB(k1, l1, i2, j1, anQ[12], 5);
        j1 = _mth02BB(j1, k1, l1, i2, anQ[2], 14);
        i2 = _mth02BB(i2, j1, k1, l1, anQ[10], 13);
        l1 = _mth02BB(l1, i2, j1, k1, anQ[0], 13);
        k1 = _mth02BB(k1, l1, i2, j1, anQ[4], 7);
        j1 = _mth02BB(j1, k1, l1, i2, anQ[13], 5);
        i2 = _mth141D(i2, j1, k1, l1, anQ[8], 15);
        l1 = _mth141D(l1, i2, j1, k1, anQ[6], 5);
        k1 = _mth141D(k1, l1, i2, j1, anQ[4], 8);
        j1 = _mth141D(j1, k1, l1, i2, anQ[1], 11);
        i2 = _mth141D(i2, j1, k1, l1, anQ[3], 14);
        l1 = _mth141D(l1, i2, j1, k1, anQ[11], 14);
        k1 = _mth141D(k1, l1, i2, j1, anQ[15], 6);
        j1 = _mth141D(j1, k1, l1, i2, anQ[0], 14);
        i2 = _mth141D(i2, j1, k1, l1, anQ[5], 6);
        l1 = _mth141D(l1, i2, j1, k1, anQ[12], 9);
        k1 = _mth141D(k1, l1, i2, j1, anQ[2], 12);
        j2 = _mth141D(j1, k1, l1, i2, anQ[13], 9);
        j1 = _mth141D(i2, j2, k1, l1, anQ[9], 12);
        l1 = _mth141D(l1, j1, j2, k1, anQ[7], 5);
        k1 = _mth141D(k1, l1, j1, j2, anQ[10], 15);
        i2 = _mth141D(j2, k1, l1, j1, anQ[14], 8);
        j2 = anM;
        anM = anN + k + j1;
        anN = anO + i + i2;
        anO = anS + i1 + k1;
        anS = l1 + (j2 + l);
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
