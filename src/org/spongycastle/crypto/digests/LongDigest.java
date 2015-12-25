// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.digests:
//            EncodableDigest

public abstract class LongDigest
    implements ExtendedDigest, Memoable, EncodableDigest
{

    private static long anG[] = {
        0x428a2f98d728ae22L, 0x7137449123ef65cdL, 0xb5c0fbcfec4d3b2fL, 0xe9b5dba58189dbbcL, 0x3956c25bf348b538L, 0x59f111f1b605d019L, 0x923f82a4af194f9bL, 0xab1c5ed5da6d8118L, 0xd807aa98a3030242L, 0x12835b0145706fbeL, 
        0x243185be4ee4b28cL, 0x550c7dc3d5ffb4e2L, 0x72be5d74f27b896fL, 0x80deb1fe3b1696b1L, 0x9bdc06a725c71235L, 0xc19bf174cf692694L, 0xe49b69c19ef14ad2L, 0xefbe4786384f25e3L, 0xfc19dc68b8cd5b5L, 0x240ca1cc77ac9c65L, 
        0x2de92c6f592b0275L, 0x4a7484aa6ea6e483L, 0x5cb0a9dcbd41fbd4L, 0x76f988da831153b5L, 0x983e5152ee66dfabL, 0xa831c66d2db43210L, 0xb00327c898fb213fL, 0xbf597fc7beef0ee4L, 0xc6e00bf33da88fc2L, 0xd5a79147930aa725L, 
        0x6ca6351e003826fL, 0x142929670a0e6e70L, 0x27b70a8546d22ffcL, 0x2e1b21385c26c926L, 0x4d2c6dfc5ac42aedL, 0x53380d139d95b3dfL, 0x650a73548baf63deL, 0x766a0abb3c77b2a8L, 0x81c2c92e47edaee6L, 0x92722c851482353bL, 
        0xa2bfe8a14cf10364L, 0xa81a664bbc423001L, 0xc24b8b70d0f89791L, 0xc76c51a30654be30L, 0xd192e819d6ef5218L, 0xd69906245565a910L, 0xf40e35855771202aL, 0x106aa07032bbd1b8L, 0x19a4c116b8d2d0c8L, 0x1e376c085141ab53L, 
        0x2748774cdf8eeb99L, 0x34b0bcb5e19b48a8L, 0x391c0cb3c5c95a63L, 0x4ed8aa4ae3418acbL, 0x5b9cca4f7763e373L, 0x682e6ff3d6b2b8a3L, 0x748f82ee5defb2fcL, 0x78a5636f43172f60L, 0x84c87814a1f0ab72L, 0x8cc702081a6439ecL, 
        0x90befffa23631e28L, 0xa4506cebde82bde9L, 0xbef9a3f7b2c67915L, 0xc67178f2e372532bL, 0xca273eceea26619cL, 0xd186b8c721c0c207L, 0xeada7dd6cde0eb1eL, 0xf57d4f7fee6ed178L, 0x6f067aa72176fbaL, 0xa637dc5a2c898a6L, 
        0x113f9804bef90daeL, 0x1b710b35131c471bL, 0x28db77f523047d84L, 0x32caab7b40c72493L, 0x3c9ebe0a15c9bebcL, 0x431d67c49c100d4cL, 0x4cc5d4becb3e42b6L, 0x597f299cfc657e2aL, 0x5fcb6fab3ad6faecL, 0x6c44198c4a475817L
    };
    protected long anA;
    protected long anB;
    protected long anC;
    protected long anD;
    private long anE[];
    private int anF;
    private byte anh[];
    private int ani;
    private long anu;
    private long anv;
    protected long anw;
    protected long anx;
    protected long any;
    protected long anz;

    protected LongDigest()
    {
        anh = new byte[8];
        anE = new long[80];
        ani = 0;
        reset();
    }

    protected LongDigest(LongDigest longdigest)
    {
        anh = new byte[8];
        anE = new long[80];
        _mth02CA(longdigest);
    }

    private void _mth141D(byte abyte0[], int i)
    {
        anE[anF] = Pack._mth02B4(abyte0, i);
        i = anF + 1;
        anF = i;
        if (i == 16)
        {
            _mth14BA();
        }
    }

    private void _mth14BA()
    {
        _mth14D6();
        for (int i = 16; i <= 79; i++)
        {
            long al[] = anE;
            long l1 = al[i - 2];
            long l3 = anE[i - 7];
            long l5 = anE[i - 15];
            al[i] = ((l1 << 45 | l1 >>> 19) ^ (l1 << 3 | l1 >>> 61) ^ l1 >>> 6) + l3 + ((l5 << 63 | l5 >>> 1) ^ (l5 << 56 | l5 >>> 8) ^ l5 >>> 7) + anE[i - 16];
        }

        long l2 = anw;
        long l6 = anx;
        long l8 = any;
        long l10 = anz;
        long l4 = anA;
        long l7 = anB;
        long l9 = anC;
        long l11 = anD;
        int l = 0;
        for (int j = 0; j < 10; j++)
        {
            long l12 = anG[l];
            long al1[] = anE;
            int i1 = l + 1;
            l11 += ((l4 << 50 | l4 >>> 14) ^ (l4 << 46 | l4 >>> 18) ^ (l4 << 23 | l4 >>> 41)) + (l4 & l7 ^ (-1L ^ l4) & l9) + l12 + al1[l];
            l10 += l11;
            l11 += ((l2 << 36 | l2 >>> 28) ^ (l2 << 30 | l2 >>> 34) ^ (l2 << 25 | l2 >>> 39)) + (l2 & l6 ^ l2 & l8 ^ l6 & l8);
            l12 = anG[i1];
            al1 = anE;
            l = i1 + 1;
            l9 += ((l10 << 50 | l10 >>> 14) ^ (l10 << 46 | l10 >>> 18) ^ (l10 << 23 | l10 >>> 41)) + (l10 & l4 ^ (-1L ^ l10) & l7) + l12 + al1[i1];
            l8 += l9;
            l9 += ((l11 << 36 | l11 >>> 28) ^ (l11 << 30 | l11 >>> 34) ^ (l11 << 25 | l11 >>> 39)) + (l11 & l2 ^ l11 & l6 ^ l2 & l6);
            l12 = anG[l];
            al1 = anE;
            i1 = l + 1;
            l7 += ((l8 << 50 | l8 >>> 14) ^ (l8 << 46 | l8 >>> 18) ^ (l8 << 23 | l8 >>> 41)) + (l8 & l10 ^ (-1L ^ l8) & l4) + l12 + al1[l];
            l6 += l7;
            l7 += ((l9 << 36 | l9 >>> 28) ^ (l9 << 30 | l9 >>> 34) ^ (l9 << 25 | l9 >>> 39)) + (l9 & l11 ^ l9 & l2 ^ l11 & l2);
            l12 = anG[i1];
            al1 = anE;
            l = i1 + 1;
            l4 += ((l6 << 50 | l6 >>> 14) ^ (l6 << 46 | l6 >>> 18) ^ (l6 << 23 | l6 >>> 41)) + (l6 & l8 ^ (-1L ^ l6) & l10) + l12 + al1[i1];
            l2 += l4;
            l4 += ((l7 << 36 | l7 >>> 28) ^ (l7 << 30 | l7 >>> 34) ^ (l7 << 25 | l7 >>> 39)) + (l7 & l9 ^ l7 & l11 ^ l9 & l11);
            l12 = anG[l];
            al1 = anE;
            i1 = l + 1;
            l10 += ((l2 << 50 | l2 >>> 14) ^ (l2 << 46 | l2 >>> 18) ^ (l2 << 23 | l2 >>> 41)) + (l2 & l6 ^ (-1L ^ l2) & l8) + l12 + al1[l];
            l11 += l10;
            l10 += ((l4 << 36 | l4 >>> 28) ^ (l4 << 30 | l4 >>> 34) ^ (l4 << 25 | l4 >>> 39)) + (l4 & l7 ^ l4 & l9 ^ l7 & l9);
            l12 = anG[i1];
            al1 = anE;
            l = i1 + 1;
            l8 += ((l11 << 50 | l11 >>> 14) ^ (l11 << 46 | l11 >>> 18) ^ (l11 << 23 | l11 >>> 41)) + (l11 & l2 ^ (-1L ^ l11) & l6) + l12 + al1[i1];
            l9 += l8;
            l8 += ((l10 << 36 | l10 >>> 28) ^ (l10 << 30 | l10 >>> 34) ^ (l10 << 25 | l10 >>> 39)) + (l10 & l4 ^ l10 & l7 ^ l4 & l7);
            l12 = anG[l];
            al1 = anE;
            i1 = l + 1;
            l6 += ((l9 << 50 | l9 >>> 14) ^ (l9 << 46 | l9 >>> 18) ^ (l9 << 23 | l9 >>> 41)) + (l9 & l11 ^ (-1L ^ l9) & l2) + l12 + al1[l];
            l7 += l6;
            l6 += ((l8 << 36 | l8 >>> 28) ^ (l8 << 30 | l8 >>> 34) ^ (l8 << 25 | l8 >>> 39)) + (l8 & l10 ^ l8 & l4 ^ l10 & l4);
            l12 = anG[i1];
            al1 = anE;
            l = i1 + 1;
            l2 += ((l7 << 50 | l7 >>> 14) ^ (l7 << 46 | l7 >>> 18) ^ (l7 << 23 | l7 >>> 41)) + (l7 & l9 ^ (-1L ^ l7) & l11) + l12 + al1[i1];
            l4 += l2;
            l2 += ((l6 << 36 | l6 >>> 28) ^ (l6 << 30 | l6 >>> 34) ^ (l6 << 25 | l6 >>> 39)) + (l6 & l8 ^ l6 & l10 ^ l8 & l10);
        }

        anw = anw + l2;
        anx = anx + l6;
        any = any + l8;
        anz = anz + l10;
        anA = anA + l4;
        anB = anB + l7;
        anC = anC + l9;
        anD = anD + l11;
        anF = 0;
        for (int k = 0; k < 16; k++)
        {
            anE[k] = 0L;
        }

    }

    private void _mth14D6()
    {
        if (anu > 0x1fffffffffffffffL)
        {
            anv = anv + (anu >>> 61);
            anu = anu & 0x1fffffffffffffffL;
        }
    }

    public final void finish()
    {
        _mth14D6();
        long l = anu;
        long l1 = anv;
        update((byte)-128);
        while (ani != 0) 
        {
            update((byte)0);
        }
        if (anF > 14)
        {
            _mth14BA();
        }
        anE[14] = l1;
        anE[15] = l << 3;
        _mth14BA();
    }

    public void reset()
    {
        anu = 0L;
        anv = 0L;
        ani = 0;
        for (int i = 0; i < anh.length; i++)
        {
            anh[i] = 0;
        }

        anF = 0;
        for (int j = 0; j != anE.length; j++)
        {
            anE[j] = 0L;
        }

    }

    public final void update(byte byte0)
    {
        byte abyte0[] = anh;
        int i = ani;
        ani = i + 1;
        abyte0[i] = byte0;
        if (ani == anh.length)
        {
            _mth141D(anh, 0);
            ani = 0;
        }
        anu = anu + 1L;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int k = j;
        int l = i;
        do
        {
            i = l;
            j = k;
            if (ani == 0)
            {
                break;
            }
            i = l;
            j = k;
            if (k <= 0)
            {
                break;
            }
            update(abyte0[l]);
            l++;
            k--;
        } while (true);
        do
        {
            k = i;
            l = j;
            if (j <= anh.length)
            {
                break;
            }
            _mth141D(abyte0, i);
            i += anh.length;
            j -= anh.length;
            anu = anu + (long)anh.length;
        } while (true);
        for (; l > 0; l--)
        {
            update(abyte0[k]);
            k++;
        }

    }

    protected final void _mth02CA(LongDigest longdigest)
    {
        System.arraycopy(longdigest.anh, 0, anh, 0, longdigest.anh.length);
        ani = longdigest.ani;
        anu = longdigest.anu;
        anv = longdigest.anv;
        anw = longdigest.anw;
        anx = longdigest.anx;
        any = longdigest.any;
        anz = longdigest.anz;
        anA = longdigest.anA;
        anB = longdigest.anB;
        anC = longdigest.anC;
        anD = longdigest.anD;
        System.arraycopy(longdigest.anE, 0, anE, 0, longdigest.anE.length);
        anF = longdigest.anF;
    }

    public final int _mth14B2()
    {
        return 128;
    }

}
