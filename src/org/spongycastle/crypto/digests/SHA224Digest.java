// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest, EncodableDigest

public class SHA224Digest extends GeneralDigest
    implements EncodableDigest
{

    private static int anY[] = {
        0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5, 0xd807aa98, 0x12835b01, 
        0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174, 0xe49b69c1, 0xefbe4786, 0xfc19dc6, 0x240ca1cc, 
        0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 
        0x6ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 
        0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08, 
        0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 
        0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
    };
    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];
    private int anT;
    private int anU;
    private int anV;
    private int anW;

    public SHA224Digest()
    {
        anQ = new int[64];
        reset();
    }

    public SHA224Digest(SHA224Digest sha224digest)
    {
        super(sha224digest);
        anQ = new int[64];
        _mth02CA(sha224digest);
    }

    private void _mth02CA(SHA224Digest sha224digest)
    {
        System.arraycopy(((GeneralDigest) (sha224digest)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (sha224digest)).ani;
        super.VD = ((GeneralDigest) (sha224digest)).VD;
        anM = sha224digest.anM;
        anN = sha224digest.anN;
        anO = sha224digest.anO;
        anP = sha224digest.anP;
        anT = sha224digest.anT;
        anU = sha224digest.anU;
        anV = sha224digest.anV;
        anW = sha224digest.anW;
        System.arraycopy(sha224digest.anQ, 0, anQ, 0, sha224digest.anQ.length);
        anI = sha224digest.anI;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        Pack._mth1FBE(anM, abyte0, i);
        Pack._mth1FBE(anN, abyte0, i + 4);
        Pack._mth1FBE(anO, abyte0, i + 8);
        Pack._mth1FBE(anP, abyte0, i + 12);
        Pack._mth1FBE(anT, abyte0, i + 16);
        Pack._mth1FBE(anU, abyte0, i + 20);
        Pack._mth1FBE(anV, abyte0, i + 24);
        reset();
        return 28;
    }

    public final void reset()
    {
        super.reset();
        anM = 0xc1059ed8;
        anN = 0x367cd507;
        anO = 0x3070dd17;
        anP = 0xf70e5939;
        anT = 0xffc00b31;
        anU = 0x68581511;
        anV = 0x64f98fa7;
        anW = 0xbefa4fa4;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        _mth02CA((SHA224Digest)memoable);
    }

    protected final void _mth0674(long l)
    {
        if (anI > 14)
        {
            _mth14BA();
        }
        anQ[14] = (int)(l >>> 32);
        anQ[15] = (int)l;
    }

    protected final void _mth141D(byte abyte0[], int i)
    {
        byte byte0 = abyte0[i];
        int j = i + 1;
        i = abyte0[j];
        int k = j + 1;
        j = abyte0[k];
        k = abyte0[k + 1];
        anQ[anI] = byte0 << 24 | (i & 0xff) << 16 | (j & 0xff) << 8 | k & 0xff;
        i = anI + 1;
        anI = i;
        if (i == 16)
        {
            _mth14BA();
        }
    }

    public final String _mth14AC()
    {
        return "SHA-224";
    }

    public final int _mth14AF()
    {
        return 28;
    }

    public final Memoable _mth14B7()
    {
        return new SHA224Digest(this);
    }

    protected final void _mth14BA()
    {
        for (int i = 16; i <= 63; i++)
        {
            int ai[] = anQ;
            int l = ai[i - 2];
            int j1 = anQ[i - 7];
            int l1 = anQ[i - 15];
            ai[i] = ((l >>> 17 | l << 15) ^ (l >>> 19 | l << 13) ^ l >>> 10) + j1 + ((l1 >>> 7 | l1 << 25) ^ (l1 >>> 18 | l1 << 14) ^ l1 >>> 3) + anQ[i - 16];
        }

        int i1 = anM;
        int i2 = anN;
        int k2 = anO;
        int j3 = anP;
        int k1 = anT;
        int j2 = anU;
        int l2 = anV;
        int k3 = anW;
        int i3 = 0;
        for (int j = 0; j < 8; j++)
        {
            k3 += ((k1 >>> 6 | k1 << 26) ^ (k1 >>> 11 | k1 << 21) ^ (k1 >>> 25 | k1 << 7)) + (k1 & j2 ^ ~k1 & l2) + anY[i3] + anQ[i3];
            j3 += k3;
            k3 += ((i1 >>> 2 | i1 << 30) ^ (i1 >>> 13 | i1 << 19) ^ (i1 >>> 22 | i1 << 10)) + (i1 & i2 ^ i1 & k2 ^ i2 & k2);
            i3++;
            l2 += ((j3 >>> 6 | j3 << 26) ^ (j3 >>> 11 | j3 << 21) ^ (j3 >>> 25 | j3 << 7)) + (j3 & k1 ^ ~j3 & j2) + anY[i3] + anQ[i3];
            k2 += l2;
            l2 += ((k3 >>> 2 | k3 << 30) ^ (k3 >>> 13 | k3 << 19) ^ (k3 >>> 22 | k3 << 10)) + (k3 & i1 ^ k3 & i2 ^ i1 & i2);
            i3++;
            j2 += ((k2 >>> 6 | k2 << 26) ^ (k2 >>> 11 | k2 << 21) ^ (k2 >>> 25 | k2 << 7)) + (k2 & j3 ^ ~k2 & k1) + anY[i3] + anQ[i3];
            i2 += j2;
            j2 += ((l2 >>> 2 | l2 << 30) ^ (l2 >>> 13 | l2 << 19) ^ (l2 >>> 22 | l2 << 10)) + (l2 & k3 ^ l2 & i1 ^ k3 & i1);
            i3++;
            k1 += ((i2 >>> 6 | i2 << 26) ^ (i2 >>> 11 | i2 << 21) ^ (i2 >>> 25 | i2 << 7)) + (i2 & k2 ^ ~i2 & j3) + anY[i3] + anQ[i3];
            i1 += k1;
            k1 += ((j2 >>> 2 | j2 << 30) ^ (j2 >>> 13 | j2 << 19) ^ (j2 >>> 22 | j2 << 10)) + (j2 & l2 ^ j2 & k3 ^ l2 & k3);
            i3++;
            j3 += ((i1 >>> 6 | i1 << 26) ^ (i1 >>> 11 | i1 << 21) ^ (i1 >>> 25 | i1 << 7)) + (i1 & i2 ^ ~i1 & k2) + anY[i3] + anQ[i3];
            k3 += j3;
            j3 += ((k1 >>> 2 | k1 << 30) ^ (k1 >>> 13 | k1 << 19) ^ (k1 >>> 22 | k1 << 10)) + (k1 & j2 ^ k1 & l2 ^ j2 & l2);
            i3++;
            k2 += ((k3 >>> 6 | k3 << 26) ^ (k3 >>> 11 | k3 << 21) ^ (k3 >>> 25 | k3 << 7)) + (k3 & i1 ^ ~k3 & i2) + anY[i3] + anQ[i3];
            l2 += k2;
            k2 += ((j3 >>> 2 | j3 << 30) ^ (j3 >>> 13 | j3 << 19) ^ (j3 >>> 22 | j3 << 10)) + (j3 & k1 ^ j3 & j2 ^ k1 & j2);
            i3++;
            i2 += ((l2 >>> 6 | l2 << 26) ^ (l2 >>> 11 | l2 << 21) ^ (l2 >>> 25 | l2 << 7)) + (l2 & k3 ^ ~l2 & i1) + anY[i3] + anQ[i3];
            j2 += i2;
            i2 += ((k2 >>> 2 | k2 << 30) ^ (k2 >>> 13 | k2 << 19) ^ (k2 >>> 22 | k2 << 10)) + (k2 & j3 ^ k2 & k1 ^ j3 & k1);
            i3++;
            i1 += ((j2 >>> 6 | j2 << 26) ^ (j2 >>> 11 | j2 << 21) ^ (j2 >>> 25 | j2 << 7)) + (j2 & l2 ^ ~j2 & k3) + anY[i3] + anQ[i3];
            k1 += i1;
            i1 += ((i2 >>> 2 | i2 << 30) ^ (i2 >>> 13 | i2 << 19) ^ (i2 >>> 22 | i2 << 10)) + (i2 & k2 ^ i2 & j3 ^ k2 & j3);
            i3++;
        }

        anM = anM + i1;
        anN = anN + i2;
        anO = anO + k2;
        anP = anP + j3;
        anT = anT + k1;
        anU = anU + j2;
        anV = anV + l2;
        anW = anW + k3;
        anI = 0;
        for (int k = 0; k < 16; k++)
        {
            anQ[k] = 0;
        }

    }

}
