// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            GeneralDigest

public class SM3Digest extends GeneralDigest
{

    private static final int aoA[];
    private int anI;
    private int aow[];
    private int aox[];
    private int aoy[];
    private int aoz[];

    public SM3Digest()
    {
        aow = new int[8];
        aox = new int[16];
        aoy = new int[68];
        aoz = new int[64];
        reset();
    }

    public SM3Digest(SM3Digest sm3digest)
    {
        super(sm3digest);
        aow = new int[8];
        aox = new int[16];
        aoy = new int[68];
        aoz = new int[64];
        _mth02CA(sm3digest);
    }

    private void _mth02CA(SM3Digest sm3digest)
    {
        System.arraycopy(sm3digest.aow, 0, aow, 0, aow.length);
        System.arraycopy(sm3digest.aox, 0, aox, 0, aox.length);
        anI = sm3digest.anI;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        finish();
        Pack._mth1FBE(aow[0], abyte0, i);
        Pack._mth1FBE(aow[1], abyte0, i + 4);
        Pack._mth1FBE(aow[2], abyte0, i + 8);
        Pack._mth1FBE(aow[3], abyte0, i + 12);
        Pack._mth1FBE(aow[4], abyte0, i + 16);
        Pack._mth1FBE(aow[5], abyte0, i + 20);
        Pack._mth1FBE(aow[6], abyte0, i + 24);
        Pack._mth1FBE(aow[7], abyte0, i + 28);
        reset();
        return 32;
    }

    public final void reset()
    {
        super.reset();
        aow[0] = 0x7380166f;
        aow[1] = 0x4914b2b9;
        aow[2] = 0x172442d7;
        aow[3] = 0xda8a0600;
        aow[4] = 0xa96f30bc;
        aow[5] = 0x163138aa;
        aow[6] = 0xe38dee4d;
        aow[7] = 0xb0fb0e4e;
        anI = 0;
    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (SM3Digest)memoable;
        System.arraycopy(((GeneralDigest) (memoable)).anh, 0, super.anh, 0, 4);
        super.ani = ((GeneralDigest) (memoable)).ani;
        super.VD = ((GeneralDigest) (memoable)).VD;
        _mth02CA(((SM3Digest) (memoable)));
    }

    protected final void _mth0674(long l)
    {
        if (anI > 14)
        {
            aox[anI] = 0;
            anI = anI + 1;
            _mth14BA();
        }
        for (; anI < 14; anI = anI + 1)
        {
            aox[anI] = 0;
        }

        int ai[] = aox;
        int i = anI;
        anI = i + 1;
        ai[i] = (int)(l >>> 32);
        ai = aox;
        i = anI;
        anI = i + 1;
        ai[i] = (int)l;
    }

    protected final void _mth141D(byte abyte0[], int i)
    {
        byte byte0 = abyte0[i];
        int j = i + 1;
        i = abyte0[j];
        int k = j + 1;
        j = abyte0[k];
        k = abyte0[k + 1];
        aox[anI] = (byte0 & 0xff) << 24 | (i & 0xff) << 16 | (j & 0xff) << 8 | k & 0xff;
        anI = anI + 1;
        if (anI >= 16)
        {
            _mth14BA();
        }
    }

    public final String _mth14AC()
    {
        return "SM3";
    }

    public final int _mth14AF()
    {
        return 32;
    }

    public final Memoable _mth14B7()
    {
        return new SM3Digest(this);
    }

    protected final void _mth14BA()
    {
        for (int i = 0; i < 16; i++)
        {
            aoy[i] = aox[i];
        }

        for (int j = 16; j < 68; j++)
        {
            int k1 = aoy[j - 3];
            int i1 = aoy[j - 13];
            int ai[] = aoy;
            k1 = ai[j - 16] ^ aoy[j - 9] ^ (k1 << 15 | k1 >>> 17);
            ai[j] = k1 ^ (k1 << 15 | k1 >>> 17) ^ (k1 << 23 | k1 >>> 9) ^ (i1 << 7 | i1 >>> 25) ^ aoy[j - 6];
        }

        for (int k = 0; k < 64; k++)
        {
            aoz[k] = aoy[k] ^ aoy[k + 4];
        }

        int l = aow[0];
        int l2 = aow[1];
        int k2 = aow[2];
        int i3 = aow[3];
        int j1 = aow[4];
        int i2 = aow[5];
        int l1 = aow[6];
        int j2 = aow[7];
        int j3 = 0;
        int k3;
        int i4;
        do
        {
            i4 = i3;
            k3 = l2;
            if (j3 >= 16)
            {
                break;
            }
            int k5 = l << 12 | l >>> 20;
            l2 = k5 + j1 + aoA[j3];
            int i6 = l2 << 7 | l2 >>> 25;
            int k6 = aoz[j3];
            int i5 = (j1 ^ i2 ^ l1) + j2 + i6 + aoy[j3];
            i3 = k2;
            int k4 = k3 << 9 | k3 >>> 23;
            l2 = l;
            l = (l ^ k3 ^ k2) + i4 + (k5 ^ i6) + k6;
            j2 = l1;
            l1 = i2 << 19 | i2 >>> 13;
            i2 = j1;
            j1 = i5 ^ (i5 << 9 | i5 >>> 23) ^ (i5 << 17 | i5 >>> 15);
            j3++;
            k2 = k4;
        } while (true);
        l2 = 16;
        j3 = j2;
        i3 = i2;
        j2 = i4;
        i2 = k3;
        do
        {
            int j4 = j2;
            int l4 = i2;
            if (l2 < 64)
            {
                int l5 = l << 12 | l >>> 20;
                i2 = l5 + j1 + aoA[l2];
                int j6 = i2 << 7 | i2 >>> 25;
                int l6 = aoz[l2];
                int j5 = (j1 & i3 | ~j1 & l1) + j3 + j6 + aoy[l2];
                j2 = k2;
                int l3 = l4 << 9 | l4 >>> 23;
                i2 = l;
                l = (l & l4 | l & k2 | l4 & k2) + j4 + (l5 ^ j6) + l6;
                j3 = l1;
                l1 = i3 << 19 | i3 >>> 13;
                i3 = j1;
                j1 = j5 ^ (j5 << 9 | j5 >>> 23) ^ (j5 << 17 | j5 >>> 15);
                l2++;
                k2 = l3;
            } else
            {
                int ai1[] = aow;
                ai1[0] = ai1[0] ^ l;
                ai1 = aow;
                ai1[1] = ai1[1] ^ l4;
                ai1 = aow;
                ai1[2] = ai1[2] ^ k2;
                ai1 = aow;
                ai1[3] = ai1[3] ^ j4;
                ai1 = aow;
                ai1[4] = ai1[4] ^ j1;
                ai1 = aow;
                ai1[5] = ai1[5] ^ i3;
                ai1 = aow;
                ai1[6] = ai1[6] ^ l1;
                ai1 = aow;
                ai1[7] = ai1[7] ^ j3;
                anI = 0;
                return;
            }
        } while (true);
    }

    static 
    {
        aoA = new int[64];
        for (int i = 0; i < 16; i++)
        {
            aoA[i] = 0x79cc4519 << i | 0x79cc4519 >>> 32 - i;
        }

        for (int j = 16; j < 64; j++)
        {
            int k = j % 32;
            aoA[j] = 0x7a879d8a << k | 0x7a879d8a >>> 32 - k;
        }

    }
}
