// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;

public final class WhirlpoolDigest
    implements ExtendedDigest, Memoable
{

    private static final int apb[] = {
        24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 
        210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 
        163, 12, 123, 53, 29, 224, 215, 194, 46, 75, 
        254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 
        88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 
        16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 
        167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 
        71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 
        99, 2, 170, 113, 200, 25, 73, 217, 242, 227, 
        91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 
        190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 
        26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 
        64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 
        207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 
        69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 
        47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 
        178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 
        37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 
        209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 
        252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 
        59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 
        148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 
        86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 
        157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 
        22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 
        152, 164, 40, 92, 248, 134
    };
    private static final long apc[] = new long[256];
    private static final long apd[] = new long[256];
    private static final long ape[] = new long[256];
    private static final long apf[] = new long[256];
    private static final long apg[] = new long[256];
    private static final long aph[] = new long[256];
    private static final long apj[] = new long[256];
    private static final long apk[] = new long[256];
    private static final short apu[];
    private final long apl[];
    private byte apm[];
    private int apn;
    private short apo[];
    private long app[];
    private long apq[];
    private long apr[];
    private long aps[];
    private long apt[];

    public WhirlpoolDigest()
    {
        apl = new long[11];
        apm = new byte[64];
        apn = 0;
        apo = new short[32];
        app = new long[8];
        apq = new long[8];
        apr = new long[8];
        aps = new long[8];
        apt = new long[8];
        for (int i = 0; i < 256; i++)
        {
            int i2 = apb[i];
            int j1 = i2 << 1;
            int i1 = j1;
            int k = i1;
            if ((long)j1 >= 256L)
            {
                k = i1 ^ 0x11d;
            }
            int k1 = k << 1;
            j1 = k1;
            i1 = j1;
            if ((long)k1 >= 256L)
            {
                i1 = j1 ^ 0x11d;
            }
            int j2 = i1 ^ i2;
            int l1 = i1 << 1;
            k1 = l1;
            j1 = k1;
            if ((long)l1 >= 256L)
            {
                j1 = k1 ^ 0x11d;
            }
            k1 = j1 ^ i2;
            apc[i] = _mth02CB(i2, i2, i1, i2, j1, j2, k, k1);
            apd[i] = _mth02CB(k1, i2, i2, i1, i2, j1, j2, k);
            ape[i] = _mth02CB(k, k1, i2, i2, i1, i2, j1, j2);
            apf[i] = _mth02CB(j2, k, k1, i2, i2, i1, i2, j1);
            apg[i] = _mth02CB(j1, j2, k, k1, i2, i2, i1, i2);
            aph[i] = _mth02CB(i2, j1, j2, k, k1, i2, i2, i1);
            apj[i] = _mth02CB(i1, i2, j1, j2, k, k1, i2, i2);
            apk[i] = _mth02CB(i2, i1, i2, j1, j2, k, k1, i2);
        }

        apl[0] = 0L;
        for (int j = 1; j <= 10; j++)
        {
            int l = (j - 1) * 8;
            apl[j] = apc[l] & 0xff00000000000000L ^ apd[l + 1] & 0xff000000000000L ^ ape[l + 2] & 0xff0000000000L ^ apf[l + 3] & 0xff00000000L ^ apg[l + 4] & 0xff000000L ^ aph[l + 5] & 0xff0000L ^ apj[l + 6] & 65280L ^ apk[l + 7] & 255L;
        }

    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpooldigest)
    {
        apl = new long[11];
        apm = new byte[64];
        apn = 0;
        apo = new short[32];
        app = new long[8];
        apq = new long[8];
        apr = new long[8];
        aps = new long[8];
        apt = new long[8];
        _mth02CA(whirlpooldigest);
    }

    private void increment()
    {
        int j = 0;
        for (int i = apo.length - 1; i >= 0; i--)
        {
            int k = (apo[i] & 0xff) + apu[i] + j;
            j = k >>> 8;
            apo[i] = (short)(k & 0xff);
        }

    }

    private static long _mth02BB(byte abyte0[], int i)
    {
        return ((long)abyte0[i] & 255L) << 56 | ((long)abyte0[i + 1] & 255L) << 48 | ((long)abyte0[i + 2] & 255L) << 40 | ((long)abyte0[i + 3] & 255L) << 32 | ((long)abyte0[i + 4] & 255L) << 24 | ((long)abyte0[i + 5] & 255L) << 16 | ((long)abyte0[i + 6] & 255L) << 8 | (long)abyte0[i + 7] & 255L;
    }

    private static long _mth02CB(int i, int j, int k, int l, int i1, int j1, int k1, int l1)
    {
        return (long)i << 56 ^ (long)j << 48 ^ (long)k << 40 ^ (long)l << 32 ^ (long)i1 << 24 ^ (long)j1 << 16 ^ (long)k1 << 8 ^ (long)l1;
    }

    private void _mth14BA()
    {
        for (int i = 0; i < 8; i++)
        {
            long al[] = apt;
            long l1 = aps[i];
            long al5[] = apq;
            long l2 = app[i];
            al5[i] = l2;
            al[i] = l1 ^ l2;
        }

        for (int j = 1; j <= 10; j++)
        {
            for (int l = 0; l < 8; l++)
            {
                apr[l] = 0L;
                long al1[] = apr;
                al1[l] = al1[l] ^ apc[(int)(apq[l & 7] >>> 56) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ apd[(int)(apq[l - 1 & 7] >>> 48) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ ape[(int)(apq[l - 2 & 7] >>> 40) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ apf[(int)(apq[l - 3 & 7] >>> 32) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ apg[(int)(apq[l - 4 & 7] >>> 24) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ aph[(int)(apq[l - 5 & 7] >>> 16) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ apj[(int)(apq[l - 6 & 7] >>> 8) & 0xff];
                al1 = apr;
                al1[l] = al1[l] ^ apk[(int)apq[l - 7 & 7] & 0xff];
            }

            System.arraycopy(apr, 0, apq, 0, apq.length);
            long al2[] = apq;
            al2[0] = al2[0] ^ apl[j];
            for (int i1 = 0; i1 < 8; i1++)
            {
                apr[i1] = apq[i1];
                long al3[] = apr;
                al3[i1] = al3[i1] ^ apc[(int)(apt[i1 & 7] >>> 56) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ apd[(int)(apt[i1 - 1 & 7] >>> 48) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ ape[(int)(apt[i1 - 2 & 7] >>> 40) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ apf[(int)(apt[i1 - 3 & 7] >>> 32) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ apg[(int)(apt[i1 - 4 & 7] >>> 24) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ aph[(int)(apt[i1 - 5 & 7] >>> 16) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ apj[(int)(apt[i1 - 6 & 7] >>> 8) & 0xff];
                al3 = apr;
                al3[i1] = al3[i1] ^ apk[(int)apt[i1 - 7 & 7] & 0xff];
            }

            System.arraycopy(apr, 0, apt, 0, apt.length);
        }

        for (int k = 0; k < 8; k++)
        {
            long al4[] = app;
            al4[k] = al4[k] ^ (apt[k] ^ aps[k]);
        }

    }

    private void _mth1622()
    {
        for (int i = 0; i < apt.length; i++)
        {
            aps[i] = _mth02BB(apm, i << 3);
        }

        _mth14BA();
        apn = 0;
        Arrays.fill(apm, (byte)0);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[32];
        for (int j = 0; j < 32; j++)
        {
            abyte1[j] = (byte)apo[j];
        }

        byte abyte2[] = apm;
        int k = apn;
        apn = k + 1;
        abyte2[k] = (byte)(abyte2[k] | 0x80);
        if (apn == apm.length)
        {
            _mth1622();
        }
        if (apn > 32)
        {
            while (apn != 0) 
            {
                update((byte)0);
            }
        }
        while (apn <= 32) 
        {
            update((byte)0);
        }
        System.arraycopy(abyte1, 0, apm, 32, 32);
        _mth1622();
        for (int l = 0; l < 8; l++)
        {
            long l1 = app[l];
            for (int i1 = 0; i1 < 8; i1++)
            {
                abyte0[i + (l << 3) + i1] = (byte)(int)(l1 >> 56 - (i1 << 3) & 255L);
            }

        }

        reset();
        return 64;
    }

    public final void reset()
    {
        apn = 0;
        Arrays.fill(apo, (short)0);
        Arrays.fill(apm, (byte)0);
        Arrays.fill(app, 0L);
        Arrays.fill(apq, 0L);
        Arrays.fill(apr, 0L);
        Arrays.fill(aps, 0L);
        Arrays.fill(apt, 0L);
    }

    public final void update(byte byte0)
    {
        apm[apn] = byte0;
        apn = apn + 1;
        if (apn == apm.length)
        {
            _mth1622();
        }
        increment();
    }

    public final void update(byte abyte0[], int i, int j)
    {
        for (; j > 0; j--)
        {
            update(abyte0[i]);
            i++;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (WhirlpoolDigest)memoable;
        System.arraycopy(((WhirlpoolDigest) (memoable)).apl, 0, apl, 0, 11);
        System.arraycopy(((WhirlpoolDigest) (memoable)).apm, 0, apm, 0, apm.length);
        apn = ((WhirlpoolDigest) (memoable)).apn;
        System.arraycopy(((WhirlpoolDigest) (memoable)).apo, 0, apo, 0, apo.length);
        System.arraycopy(((WhirlpoolDigest) (memoable)).app, 0, app, 0, app.length);
        System.arraycopy(((WhirlpoolDigest) (memoable)).apq, 0, apq, 0, apq.length);
        System.arraycopy(((WhirlpoolDigest) (memoable)).apr, 0, apr, 0, apr.length);
        System.arraycopy(((WhirlpoolDigest) (memoable)).aps, 0, aps, 0, aps.length);
        System.arraycopy(((WhirlpoolDigest) (memoable)).apt, 0, apt, 0, apt.length);
    }

    public final String _mth14AC()
    {
        return "Whirlpool";
    }

    public final int _mth14AF()
    {
        return 64;
    }

    public final int _mth14B2()
    {
        return 64;
    }

    public final Memoable _mth14B7()
    {
        return new WhirlpoolDigest(this);
    }

    static 
    {
        short aword0[] = new short[32];
        apu = aword0;
        aword0[31] = 8;
    }
}
