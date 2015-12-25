// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest, EncodableDigest

public class SHA1Digest extends GeneralDigest
    implements EncodableDigest
{

    private int anI;
    private int anM;
    private int anN;
    private int anO;
    private int anP;
    private int anQ[];
    private int anT;

    public SHA1Digest()
    {
        anQ = new int[80];
        reset();
    }

    public SHA1Digest(SHA1Digest sha1digest)
    {
        super(sha1digest);
        anQ = new int[80];
        _mth02CA(sha1digest);
    }

    private void _mth02CA(SHA1Digest sha1digest)
    {
        anM = sha1digest.anM;
        anN = sha1digest.anN;
        anO = sha1digest.anO;
        anP = sha1digest.anP;
        anT = sha1digest.anT;
        System.arraycopy(sha1digest.anQ, 0, anQ, 0, sha1digest.anQ.length);
        anI = sha1digest.anI;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        Pack._mth1FBE(anM, abyte0, i);
        Pack._mth1FBE(anN, abyte0, i + 4);
        Pack._mth1FBE(anO, abyte0, i + 8);
        Pack._mth1FBE(anP, abyte0, i + 12);
        Pack._mth1FBE(anT, abyte0, i + 16);
        reset();
        return 20;
    }

    public final void reset()
    {
        super.reset();
        anM = 0x67452301;
        anN = 0xefcdab89;
        anO = 0x98badcfe;
        anP = 0x10325476;
        anT = 0xc3d2e1f0;
        anI = 0;
        for (int i = 0; i != anQ.length; i++)
        {
            anQ[i] = 0;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (SHA1Digest)memoable;
        System.arraycopy(((GeneralDigest) (memoable)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (memoable)).ani;
        super.VD = ((GeneralDigest) (memoable)).VD;
        _mth02CA(((SHA1Digest) (memoable)));
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
        return "SHA-1";
    }

    public final int _mth14AF()
    {
        return 20;
    }

    public final Memoable _mth14B7()
    {
        return new SHA1Digest(this);
    }

    protected final void _mth14BA()
    {
        for (int i = 16; i < 80; i++)
        {
            int l = anQ[i - 3] ^ anQ[i - 8] ^ anQ[i - 14] ^ anQ[i - 16];
            anQ[i] = l << 1 | l >>> 31;
        }

        int j = anM;
        int j1 = anN;
        int i1 = anO;
        int k1 = anP;
        int l1 = anT;
        int i2 = 0;
        for (int j2 = 0; j2 < 4; j2++)
        {
            int ai[] = anQ;
            int j3 = i2 + 1;
            l1 += (j << 5 | j >>> 27) + (j1 & i1 | ~j1 & k1) + ai[i2] + 0x5a827999;
            j1 = j1 << 30 | j1 >>> 2;
            ai = anQ;
            i2 = j3 + 1;
            k1 += (l1 << 5 | l1 >>> 27) + (j & j1 | ~j & i1) + ai[j3] + 0x5a827999;
            j = j << 30 | j >>> 2;
            ai = anQ;
            j3 = i2 + 1;
            i1 += (k1 << 5 | k1 >>> 27) + (l1 & j | ~l1 & j1) + ai[i2] + 0x5a827999;
            l1 = l1 << 30 | l1 >>> 2;
            ai = anQ;
            int j4 = j3 + 1;
            j1 += (i1 << 5 | i1 >>> 27) + (k1 & l1 | ~k1 & j) + ai[j3] + 0x5a827999;
            k1 = k1 << 30 | k1 >>> 2;
            ai = anQ;
            i2 = j4 + 1;
            j += (j1 << 5 | j1 >>> 27) + (i1 & k1 | ~i1 & l1) + ai[j4] + 0x5a827999;
            i1 = i1 << 30 | i1 >>> 2;
        }

        for (int k2 = 0; k2 < 4; k2++)
        {
            int ai1[] = anQ;
            int k3 = i2 + 1;
            l1 += (j << 5 | j >>> 27) + (j1 ^ i1 ^ k1) + ai1[i2] + 0x6ed9eba1;
            j1 = j1 << 30 | j1 >>> 2;
            ai1 = anQ;
            i2 = k3 + 1;
            k1 += (l1 << 5 | l1 >>> 27) + (j ^ j1 ^ i1) + ai1[k3] + 0x6ed9eba1;
            j = j << 30 | j >>> 2;
            ai1 = anQ;
            k3 = i2 + 1;
            i1 += (k1 << 5 | k1 >>> 27) + (l1 ^ j ^ j1) + ai1[i2] + 0x6ed9eba1;
            l1 = l1 << 30 | l1 >>> 2;
            ai1 = anQ;
            int k4 = k3 + 1;
            j1 += (i1 << 5 | i1 >>> 27) + (k1 ^ l1 ^ j) + ai1[k3] + 0x6ed9eba1;
            k1 = k1 << 30 | k1 >>> 2;
            ai1 = anQ;
            i2 = k4 + 1;
            j += (j1 << 5 | j1 >>> 27) + (i1 ^ k1 ^ l1) + ai1[k4] + 0x6ed9eba1;
            i1 = i1 << 30 | i1 >>> 2;
        }

        for (int l2 = 0; l2 < 4; l2++)
        {
            int ai2[] = anQ;
            int l3 = i2 + 1;
            l1 += ((j << 5 | j >>> 27) + (j1 & i1 | j1 & k1 | i1 & k1) + ai2[i2]) - 0x70e44324;
            j1 = j1 << 30 | j1 >>> 2;
            ai2 = anQ;
            i2 = l3 + 1;
            k1 += ((l1 << 5 | l1 >>> 27) + (j & j1 | j & i1 | j1 & i1) + ai2[l3]) - 0x70e44324;
            j = j << 30 | j >>> 2;
            ai2 = anQ;
            l3 = i2 + 1;
            i1 += ((k1 << 5 | k1 >>> 27) + (l1 & j | l1 & j1 | j & j1) + ai2[i2]) - 0x70e44324;
            l1 = l1 << 30 | l1 >>> 2;
            ai2 = anQ;
            int l4 = l3 + 1;
            j1 += ((i1 << 5 | i1 >>> 27) + (k1 & l1 | k1 & j | l1 & j) + ai2[l3]) - 0x70e44324;
            k1 = k1 << 30 | k1 >>> 2;
            ai2 = anQ;
            i2 = l4 + 1;
            j += ((j1 << 5 | j1 >>> 27) + (i1 & k1 | i1 & l1 | k1 & l1) + ai2[l4]) - 0x70e44324;
            i1 = i1 << 30 | i1 >>> 2;
        }

        for (int i3 = 0; i3 <= 3; i3++)
        {
            int ai3[] = anQ;
            int i4 = i2 + 1;
            l1 += ((j << 5 | j >>> 27) + (j1 ^ i1 ^ k1) + ai3[i2]) - 0x359d3e2a;
            j1 = j1 << 30 | j1 >>> 2;
            ai3 = anQ;
            i2 = i4 + 1;
            k1 += ((l1 << 5 | l1 >>> 27) + (j ^ j1 ^ i1) + ai3[i4]) - 0x359d3e2a;
            j = j << 30 | j >>> 2;
            ai3 = anQ;
            i4 = i2 + 1;
            i1 += ((k1 << 5 | k1 >>> 27) + (l1 ^ j ^ j1) + ai3[i2]) - 0x359d3e2a;
            l1 = l1 << 30 | l1 >>> 2;
            ai3 = anQ;
            int i5 = i4 + 1;
            j1 += ((i1 << 5 | i1 >>> 27) + (k1 ^ l1 ^ j) + ai3[i4]) - 0x359d3e2a;
            k1 = k1 << 30 | k1 >>> 2;
            ai3 = anQ;
            i2 = i5 + 1;
            j += ((j1 << 5 | j1 >>> 27) + (i1 ^ k1 ^ l1) + ai3[i5]) - 0x359d3e2a;
            i1 = i1 << 30 | i1 >>> 2;
        }

        anM = anM + j;
        anN = anN + j1;
        anO = anO + i1;
        anP = anP + k1;
        anT = anT + l1;
        anI = 0;
        for (int k = 0; k < 16; k++)
        {
            anQ[k] = 0;
        }

    }
}
