// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class RIPEMD256Digest extends GeneralDigest
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

    public RIPEMD256Digest()
    {
        anQ = new int[16];
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest ripemd256digest)
    {
        super(ripemd256digest);
        anQ = new int[16];
        _mth02CA(ripemd256digest);
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

    private void _mth02CA(RIPEMD256Digest ripemd256digest)
    {
        System.arraycopy(((GeneralDigest) (ripemd256digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (ripemd256digest)).ani;
        super.VD = ((GeneralDigest) (ripemd256digest)).VD;
        anS = ripemd256digest.anS;
        anM = ripemd256digest.anM;
        anN = ripemd256digest.anN;
        anO = ripemd256digest.anO;
        anP = ripemd256digest.anP;
        anT = ripemd256digest.anT;
        anU = ripemd256digest.anU;
        anV = ripemd256digest.anV;
        System.arraycopy(ripemd256digest.anQ, 0, anQ, 0, ripemd256digest.anQ.length);
        anI = ripemd256digest.anI;
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
        _mth02CA(anP, abyte0, i + 16);
        _mth02CA(anT, abyte0, i + 20);
        _mth02CA(anU, abyte0, i + 24);
        _mth02CA(anV, abyte0, i + 28);
        reset();
        return 32;
    }

    public final void reset()
    {
        super.reset();
        anS = 0x67452301;
        anM = 0xefcdab89;
        anN = 0x98badcfe;
        anO = 0x10325476;
        anP = 0x76543210;
        anT = 0xfedcba98;
        anU = 0x89abcdef;
        anV = 0x1234567;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((RIPEMD256Digest)memoable);
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
        return "RIPEMD256";
    }

    public final int _mth14AF()
    {
        return 32;
    }

    public final Memoable _mth14B7()
    {
        return new RIPEMD256Digest(this);
    }

    protected final void _mth14BA()
    {
        int l = anS;
        int i = anM;
        int j1 = anN;
        int i1 = anO;
        int i2 = anP;
        int k = anT;
        int k1 = anU;
        int l1 = anV;
        l = _mth02CA(l, i, j1, i1, anQ[0], 11);
        i1 = _mth02CA(i1, l, i, j1, anQ[1], 14);
        j1 = _mth02CA(j1, i1, l, i, anQ[2], 15);
        i = _mth02CA(i, j1, i1, l, anQ[3], 12);
        l = _mth02CA(l, i, j1, i1, anQ[4], 5);
        i1 = _mth02CA(i1, l, i, j1, anQ[5], 8);
        j1 = _mth02CA(j1, i1, l, i, anQ[6], 7);
        i = _mth02CA(i, j1, i1, l, anQ[7], 9);
        l = _mth02CA(l, i, j1, i1, anQ[8], 11);
        i1 = _mth02CA(i1, l, i, j1, anQ[9], 13);
        j1 = _mth02CA(j1, i1, l, i, anQ[10], 14);
        int j2 = _mth02CA(i, j1, i1, l, anQ[11], 15);
        i = _mth02CA(l, j2, j1, i1, anQ[12], 6);
        l = _mth02CA(i1, i, j2, j1, anQ[13], 7);
        i1 = _mth02CA(j1, l, i, j2, anQ[14], 9);
        j1 = _mth02CA(j2, i1, l, i, anQ[15], 8);
        i2 = _mth02BD(i2, k, k1, l1, anQ[5], 8);
        l1 = _mth02BD(l1, i2, k, k1, anQ[14], 9);
        k1 = _mth02BD(k1, l1, i2, k, anQ[7], 9);
        k = _mth02BD(k, k1, l1, i2, anQ[0], 11);
        i2 = _mth02BD(i2, k, k1, l1, anQ[9], 13);
        l1 = _mth02BD(l1, i2, k, k1, anQ[2], 15);
        k1 = _mth02BD(k1, l1, i2, k, anQ[11], 15);
        k = _mth02BD(k, k1, l1, i2, anQ[4], 5);
        i2 = _mth02BD(i2, k, k1, l1, anQ[13], 7);
        l1 = _mth02BD(l1, i2, k, k1, anQ[6], 7);
        j2 = _mth02BD(k1, l1, i2, k, anQ[15], 8);
        k = _mth02BD(k, j2, l1, i2, anQ[8], 11);
        int k2 = _mth02BD(i2, k, j2, l1, anQ[1], 14);
        k1 = _mth02BD(l1, k2, k, j2, anQ[10], 14);
        l1 = _mth02BD(j2, k1, k2, k, anQ[3], 12);
        i2 = _mth02BD(k, l1, k1, k2, anQ[12], 6);
        k = _mth02CB(k2, j1, i1, l, anQ[7], 7);
        l = _mth02CB(l, k, j1, i1, anQ[4], 6);
        i1 = _mth02CB(i1, l, k, j1, anQ[13], 8);
        j1 = _mth02CB(j1, i1, l, k, anQ[1], 13);
        k = _mth02CB(k, j1, i1, l, anQ[10], 11);
        l = _mth02CB(l, k, j1, i1, anQ[6], 9);
        i1 = _mth02CB(i1, l, k, j1, anQ[15], 7);
        j1 = _mth02CB(j1, i1, l, k, anQ[3], 15);
        k = _mth02CB(k, j1, i1, l, anQ[12], 7);
        j2 = _mth02CB(l, k, j1, i1, anQ[0], 12);
        k2 = _mth02CB(i1, j2, k, j1, anQ[9], 15);
        int l2 = _mth02CB(j1, k2, j2, k, anQ[5], 9);
        l = _mth02CB(k, l2, k2, j2, anQ[2], 11);
        i1 = _mth02CB(j2, l, l2, k2, anQ[14], 7);
        j1 = _mth02CB(k2, i1, l, l2, anQ[11], 13);
        k = _mth02CB(l2, j1, i1, l, anQ[8], 12);
        i = _mth02BC(i, i2, l1, k1, anQ[6], 9);
        k1 = _mth02BC(k1, i, i2, l1, anQ[11], 13);
        l1 = _mth02BC(l1, k1, i, i2, anQ[3], 15);
        i2 = _mth02BC(i2, l1, k1, i, anQ[7], 7);
        i = _mth02BC(i, i2, l1, k1, anQ[0], 12);
        k1 = _mth02BC(k1, i, i2, l1, anQ[13], 8);
        l1 = _mth02BC(l1, k1, i, i2, anQ[5], 9);
        i2 = _mth02BC(i2, l1, k1, i, anQ[10], 11);
        i = _mth02BC(i, i2, l1, k1, anQ[14], 7);
        j2 = _mth02BC(k1, i, i2, l1, anQ[15], 7);
        k2 = _mth02BC(l1, j2, i, i2, anQ[8], 12);
        l2 = _mth02BC(i2, k2, j2, i, anQ[12], 7);
        k1 = _mth02BC(i, l2, k2, j2, anQ[4], 6);
        l1 = _mth02BC(j2, k1, l2, k2, anQ[9], 15);
        i2 = _mth02BC(k2, l1, k1, l2, anQ[1], 13);
        i = _mth02BC(l2, i2, l1, k1, anQ[2], 11);
        l = _mth02CE(l, i, j1, i1, anQ[3], 11);
        i1 = _mth02CE(i1, l, i, j1, anQ[10], 13);
        j1 = _mth02CE(j1, i1, l, i, anQ[14], 6);
        i = _mth02CE(i, j1, i1, l, anQ[4], 7);
        l = _mth02CE(l, i, j1, i1, anQ[9], 14);
        i1 = _mth02CE(i1, l, i, j1, anQ[15], 9);
        j1 = _mth02CE(j1, i1, l, i, anQ[8], 13);
        i = _mth02CE(i, j1, i1, l, anQ[1], 15);
        l = _mth02CE(l, i, j1, i1, anQ[2], 14);
        i1 = _mth02CE(i1, l, i, j1, anQ[7], 8);
        j1 = _mth02CE(j1, i1, l, i, anQ[0], 13);
        j2 = _mth02CE(i, j1, i1, l, anQ[6], 6);
        l = _mth02CE(l, j2, j1, i1, anQ[13], 5);
        i1 = _mth02CE(i1, l, j2, j1, anQ[11], 12);
        i = _mth02CE(j1, i1, l, j2, anQ[5], 7);
        j1 = _mth02CE(j2, i, i1, l, anQ[12], 5);
        k1 = _mth02BB(k1, k, i2, l1, anQ[15], 9);
        l1 = _mth02BB(l1, k1, k, i2, anQ[5], 7);
        i2 = _mth02BB(i2, l1, k1, k, anQ[1], 15);
        k = _mth02BB(k, i2, l1, k1, anQ[3], 11);
        k1 = _mth02BB(k1, k, i2, l1, anQ[7], 8);
        l1 = _mth02BB(l1, k1, k, i2, anQ[14], 6);
        i2 = _mth02BB(i2, l1, k1, k, anQ[6], 6);
        k = _mth02BB(k, i2, l1, k1, anQ[9], 14);
        k1 = _mth02BB(k1, k, i2, l1, anQ[11], 12);
        l1 = _mth02BB(l1, k1, k, i2, anQ[8], 13);
        i2 = _mth02BB(i2, l1, k1, k, anQ[12], 5);
        j2 = _mth02BB(k, i2, l1, k1, anQ[2], 14);
        k = _mth02BB(k1, j2, i2, l1, anQ[10], 13);
        k1 = _mth02BB(l1, k, j2, i2, anQ[0], 13);
        i2 = _mth02BB(i2, k1, k, j2, anQ[4], 7);
        l1 = _mth02BB(j2, i2, k1, k, anQ[13], 5);
        l = _mth02CF(l, j1, i2, i1, anQ[1], 11);
        i1 = _mth02CF(i1, l, j1, i2, anQ[9], 12);
        i2 = _mth02CF(i2, i1, l, j1, anQ[11], 14);
        j1 = _mth02CF(j1, i2, i1, l, anQ[10], 15);
        l = _mth02CF(l, j1, i2, i1, anQ[0], 14);
        i1 = _mth02CF(i1, l, j1, i2, anQ[8], 15);
        i2 = _mth02CF(i2, i1, l, j1, anQ[12], 9);
        j1 = _mth02CF(j1, i2, i1, l, anQ[4], 8);
        l = _mth02CF(l, j1, i2, i1, anQ[13], 9);
        i1 = _mth02CF(i1, l, j1, i2, anQ[3], 14);
        i2 = _mth02CF(i2, i1, l, j1, anQ[7], 5);
        j2 = _mth02CF(j1, i2, i1, l, anQ[15], 6);
        l = _mth02CF(l, j2, i2, i1, anQ[14], 8);
        i1 = _mth02CF(i1, l, j2, i2, anQ[5], 6);
        j1 = _mth02CF(i2, i1, l, j2, anQ[6], 5);
        i2 = _mth02CF(j2, j1, i1, l, anQ[2], 12);
        k = _mth141D(k, l1, i, k1, anQ[8], 15);
        k1 = _mth141D(k1, k, l1, i, anQ[6], 5);
        i = _mth141D(i, k1, k, l1, anQ[4], 8);
        l1 = _mth141D(l1, i, k1, k, anQ[1], 11);
        k = _mth141D(k, l1, i, k1, anQ[3], 14);
        k1 = _mth141D(k1, k, l1, i, anQ[11], 14);
        i = _mth141D(i, k1, k, l1, anQ[15], 6);
        l1 = _mth141D(l1, i, k1, k, anQ[0], 14);
        k = _mth141D(k, l1, i, k1, anQ[5], 6);
        k1 = _mth141D(k1, k, l1, i, anQ[12], 9);
        i = _mth141D(i, k1, k, l1, anQ[2], 12);
        l1 = _mth141D(l1, i, k1, k, anQ[13], 9);
        k = _mth141D(k, l1, i, k1, anQ[9], 12);
        k1 = _mth141D(k1, k, l1, i, anQ[7], 5);
        i = _mth141D(i, k1, k, l1, anQ[10], 15);
        l1 = _mth141D(l1, i, k1, k, anQ[14], 8);
        anS = anS + l;
        anM = anM + i2;
        anN = anN + j1;
        anO = anO + k1;
        anP = anP + k;
        anT = anT + l1;
        anU = anU + i;
        anV = anV + i1;
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
