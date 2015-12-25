// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class MD5Digest extends GeneralDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];

    public MD5Digest()
    {
        anQ = new int[16];
        reset();
    }

    public MD5Digest(MD5Digest md5digest)
    {
        super(md5digest);
        anQ = new int[16];
        _mth02CA(md5digest);
    }

    private static void _mth02CA(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[j + 1] = (byte)(i >>> 8);
        abyte0[j + 2] = (byte)(i >>> 16);
        abyte0[j + 3] = i >> 24;
    }

    private void _mth02CA(MD5Digest md5digest)
    {
        System.arraycopy(((GeneralDigest) (md5digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (md5digest)).ani;
        super.VD = ((GeneralDigest) (md5digest)).VD;
        anM = md5digest.anM;
        anN = md5digest.anN;
        anO = md5digest.anO;
        anP = md5digest.anP;
        System.arraycopy(md5digest.anQ, 0, anQ, 0, md5digest.anQ.length);
        anI = md5digest.anI;
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
        _mth02CA((MD5Digest)memoable);
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
        return "MD5";
    }

    public final int _mth14AF()
    {
        return 16;
    }

    public final Memoable _mth14B7()
    {
        return new MD5Digest(this);
    }

    protected final void _mth14BA()
    {
        int k = anM;
        int i = anN;
        int i1 = anO;
        int l = anP;
        k = ((i & i1 | ~i & l) + k + anQ[0]) - 0x28955b88;
        k = (k << 7 | k >>> 25) + i;
        l = ((k & i | ~k & i1) + l + anQ[1]) - 0x173848aa;
        l = (l << 12 | l >>> 20) + k;
        i1 = (l & k | ~l & i) + i1 + anQ[2] + 0x242070db;
        i1 = (i1 << 17 | i1 >>> 15) + l;
        i = ((i1 & l | ~i1 & k) + i + anQ[3]) - 0x3e423112;
        i = (i << 22 | i >>> 10) + i1;
        k = ((i & i1 | ~i & l) + k + anQ[4]) - 0xa83f051;
        k = (k << 7 | k >>> 25) + i;
        l = (k & i | ~k & i1) + l + anQ[5] + 0x4787c62a;
        l = (l << 12 | l >>> 20) + k;
        i1 = ((l & k | ~l & i) + i1 + anQ[6]) - 0x57cfb9ed;
        i1 = (i1 << 17 | i1 >>> 15) + l;
        i = ((i1 & l | ~i1 & k) + i + anQ[7]) - 0x2b96aff;
        i = (i << 22 | i >>> 10) + i1;
        k = (i & i1 | ~i & l) + k + anQ[8] + 0x698098d8;
        k = (k << 7 | k >>> 25) + i;
        l = ((k & i | ~k & i1) + l + anQ[9]) - 0x74bb0851;
        l = (l << 12 | l >>> 20) + k;
        i1 = ((l & k | ~l & i) + i1 + anQ[10]) - 42063;
        i1 = (i1 << 17 | i1 >>> 15) + l;
        i = ((i1 & l | ~i1 & k) + i + anQ[11]) - 0x76a32842;
        i = (i << 22 | i >>> 10) + i1;
        k = (i & i1 | ~i & l) + k + anQ[12] + 0x6b901122;
        k = (k << 7 | k >>> 25) + i;
        l = ((k & i | ~k & i1) + l + anQ[13]) - 0x2678e6d;
        l = (l << 12 | l >>> 20) + k;
        i1 = ((l & k | ~l & i) + i1 + anQ[14]) - 0x5986bc72;
        i1 = (i1 << 17 | i1 >>> 15) + l;
        i = (i1 & l | ~i1 & k) + i + anQ[15] + 0x49b40821;
        i = (i << 22 | i >>> 10) + i1;
        k = ((i & l | ~l & i1) + k + anQ[1]) - 0x9e1da9e;
        k = (k << 5 | k >>> 27) + i;
        l = ((k & i1 | ~i1 & i) + l + anQ[6]) - 0x3fbf4cc0;
        l = (l << 9 | l >>> 23) + k;
        i1 = (l & i | ~i & k) + i1 + anQ[11] + 0x265e5a51;
        i1 = (i1 << 14 | i1 >>> 18) + l;
        i = ((i1 & k | ~k & l) + i + anQ[0]) - 0x16493856;
        i = (i << 20 | i >>> 12) + i1;
        k = ((i & l | ~l & i1) + k + anQ[5]) - 0x29d0efa3;
        k = (k << 5 | k >>> 27) + i;
        l = (k & i1 | ~i1 & i) + l + anQ[10] + 0x2441453;
        l = (l << 9 | l >>> 23) + k;
        i1 = ((l & i | ~i & k) + i1 + anQ[15]) - 0x275e197f;
        i1 = (i1 << 14 | i1 >>> 18) + l;
        i = ((i1 & k | ~k & l) + i + anQ[4]) - 0x182c0438;
        i = (i << 20 | i >>> 12) + i1;
        k = (i & l | ~l & i1) + k + anQ[9] + 0x21e1cde6;
        k = (k << 5 | k >>> 27) + i;
        l = ((k & i1 | ~i1 & i) + l + anQ[14]) - 0x3cc8f82a;
        l = (l << 9 | l >>> 23) + k;
        i1 = ((l & i | ~i & k) + i1 + anQ[3]) - 0xb2af279;
        i1 = (i1 << 14 | i1 >>> 18) + l;
        i = (i1 & k | ~k & l) + i + anQ[8] + 0x455a14ed;
        i = (i << 20 | i >>> 12) + i1;
        k = ((i & l | ~l & i1) + k + anQ[13]) - 0x561c16fb;
        k = (k << 5 | k >>> 27) + i;
        l = ((k & i1 | ~i1 & i) + l + anQ[2]) - 0x3105c08;
        l = (l << 9 | l >>> 23) + k;
        i1 = (l & i | ~i & k) + i1 + anQ[7] + 0x676f02d9;
        i1 = (i1 << 14 | i1 >>> 18) + l;
        i = ((i1 & k | ~k & l) + i + anQ[12]) - 0x72d5b376;
        i = (i << 20 | i >>> 12) + i1;
        k = ((i ^ i1 ^ l) + k + anQ[5]) - 0x5c6be;
        k = (k << 4 | k >>> 28) + i;
        l = ((k ^ i ^ i1) + l + anQ[8]) - 0x788e097f;
        l = (l << 11 | l >>> 21) + k;
        i1 = (l ^ k ^ i) + i1 + anQ[11] + 0x6d9d6122;
        i1 = (i1 << 16 | i1 >>> 16) + l;
        i = ((i1 ^ l ^ k) + i + anQ[14]) - 0x21ac7f4;
        i = (i << 23 | i >>> 9) + i1;
        k = ((i ^ i1 ^ l) + k + anQ[1]) - 0x5b4115bc;
        k = (k << 4 | k >>> 28) + i;
        l = (k ^ i ^ i1) + l + anQ[4] + 0x4bdecfa9;
        l = (l << 11 | l >>> 21) + k;
        i1 = ((l ^ k ^ i) + i1 + anQ[7]) - 0x944b4a0;
        i1 = (i1 << 16 | i1 >>> 16) + l;
        i = ((i1 ^ l ^ k) + i + anQ[10]) - 0x41404390;
        i = (i << 23 | i >>> 9) + i1;
        k = (i ^ i1 ^ l) + k + anQ[13] + 0x289b7ec6;
        k = (k << 4 | k >>> 28) + i;
        l = ((k ^ i ^ i1) + l + anQ[0]) - 0x155ed806;
        l = (l << 11 | l >>> 21) + k;
        i1 = ((l ^ k ^ i) + i1 + anQ[3]) - 0x2b10cf7b;
        i1 = (i1 << 16 | i1 >>> 16) + l;
        i = (i1 ^ l ^ k) + i + anQ[6] + 0x4881d05;
        i = (i << 23 | i >>> 9) + i1;
        k = ((i ^ i1 ^ l) + k + anQ[9]) - 0x262b2fc7;
        k = (k << 4 | k >>> 28) + i;
        l = ((k ^ i ^ i1) + l + anQ[12]) - 0x1924661b;
        l = (l << 11 | l >>> 21) + k;
        i1 = (l ^ k ^ i) + i1 + anQ[15] + 0x1fa27cf8;
        i1 = (i1 << 16 | i1 >>> 16) + l;
        i = ((i1 ^ l ^ k) + i + anQ[2]) - 0x3b53a99b;
        i = (i << 23 | i >>> 9) + i1;
        k = (((~l | i) ^ i1) + k + anQ[0]) - 0xbd6ddbc;
        k = (k << 6 | k >>> 26) + i;
        l = ((~i1 | k) ^ i) + l + anQ[7] + 0x432aff97;
        l = (l << 10 | l >>> 22) + k;
        i1 = (((~i | l) ^ k) + i1 + anQ[14]) - 0x546bdc59;
        i1 = (i1 << 15 | i1 >>> 17) + l;
        i = (((~k | i1) ^ l) + i + anQ[5]) - 0x36c5fc7;
        i = (i << 21 | i >>> 11) + i1;
        k = ((~l | i) ^ i1) + k + anQ[12] + 0x655b59c3;
        k = (k << 6 | k >>> 26) + i;
        l = (((~i1 | k) ^ i) + l + anQ[3]) - 0x70f3336e;
        l = (l << 10 | l >>> 22) + k;
        i1 = (((~i | l) ^ k) + i1 + anQ[10]) - 0x100b83;
        i1 = (i1 << 15 | i1 >>> 17) + l;
        i = (((~k | i1) ^ l) + i + anQ[1]) - 0x7a7ba22f;
        i = (i << 21 | i >>> 11) + i1;
        k = ((~l | i) ^ i1) + k + anQ[8] + 0x6fa87e4f;
        k = (k << 6 | k >>> 26) + i;
        l = (((~i1 | k) ^ i) + l + anQ[15]) - 0x1d31920;
        l = (l << 10 | l >>> 22) + k;
        i1 = (((~i | l) ^ k) + i1 + anQ[6]) - 0x5cfebcec;
        i1 = (i1 << 15 | i1 >>> 17) + l;
        i = ((~k | i1) ^ l) + i + anQ[13] + 0x4e0811a1;
        i = (i << 21 | i >>> 11) + i1;
        k = (((~l | i) ^ i1) + k + anQ[4]) - 0x8ac817e;
        k = (k << 6 | k >>> 26) + i;
        l = (((~i1 | k) ^ i) + l + anQ[11]) - 0x42c50dcb;
        l = (l << 10 | l >>> 22) + k;
        i1 = ((~i | l) ^ k) + i1 + anQ[2] + 0x2ad7d2bb;
        i1 = (i1 << 15 | i1 >>> 17) + l;
        i = (((~k | i1) ^ l) + i + anQ[9]) - 0x14792c6f;
        anM = anM + k;
        anN = anN + ((i << 21 | i >>> 11) + i1);
        anO = anO + i1;
        anP = anP + l;
        anI = 0;
        for (int j = 0; j != anQ.length; j++)
        {
            anQ[j] = 0;
        }

    }
}
