// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.engines:
//            Salsa20Engine

public class ChaChaEngine extends Salsa20Engine
{

    public ChaChaEngine()
    {
    }

    public ChaChaEngine(int i)
    {
        super(20);
    }

    protected final void _mth02CB(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null)
        {
            if (abyte0.length != 16 && abyte0.length != 32)
            {
                throw new IllegalArgumentException((new StringBuilder()).append((new StringBuilder("ChaCha")).append(asY).toString()).append(" requires 128 bit or 256 bit key").toString());
            }
            arY[4] = Pack._mth02C6(abyte0, 0);
            arY[5] = Pack._mth02C6(abyte0, 4);
            arY[6] = Pack._mth02C6(abyte0, 8);
            arY[7] = Pack._mth02C6(abyte0, 12);
            byte abyte2[];
            byte byte0;
            if (abyte0.length == 32)
            {
                abyte2 = asW;
                byte0 = 16;
            } else
            {
                abyte2 = asX;
                byte0 = 0;
            }
            arY[8] = Pack._mth02C6(abyte0, byte0);
            arY[9] = Pack._mth02C6(abyte0, byte0 + 4);
            arY[10] = Pack._mth02C6(abyte0, byte0 + 8);
            arY[11] = Pack._mth02C6(abyte0, byte0 + 12);
            arY[0] = Pack._mth02C6(abyte2, 0);
            arY[1] = Pack._mth02C6(abyte2, 4);
            arY[2] = Pack._mth02C6(abyte2, 8);
            arY[3] = Pack._mth02C6(abyte2, 12);
        }
        arY[14] = Pack._mth02C6(abyte1, 0);
        arY[15] = Pack._mth02C6(abyte1, 4);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("ChaCha")).append(asY).toString();
    }

    protected final void _mth1D12()
    {
        int ai[] = arY;
        int i = ai[12] + 1;
        ai[12] = i;
        if (i == 0)
        {
            int ai1[] = arY;
            ai1[13] = ai1[13] + 1;
        }
    }

    protected final void _mth1D2B()
    {
        int ai[] = arY;
        arY[13] = 0;
        ai[12] = 0;
    }

    protected final void _mth1D62(byte abyte0[])
    {
        int i = asY;
        int ai[] = arY;
        int ai1[] = asZ;
        if (ai.length != 16)
        {
            throw new IllegalArgumentException();
        }
        if (ai1.length != 16)
        {
            throw new IllegalArgumentException();
        }
        if (i % 2 != 0)
        {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        int i4 = ai[0];
        int i3 = ai[1];
        int i2 = ai[2];
        int i1 = ai[3];
        int j3 = ai[4];
        int j2 = ai[5];
        int j1 = ai[6];
        int j = ai[7];
        int k3 = ai[8];
        int k2 = ai[9];
        int k1 = ai[10];
        int k = ai[11];
        int l3 = ai[12];
        int l2 = ai[13];
        int l1 = ai[14];
        int l = ai[15];
        for (; i > 0; i -= 2)
        {
            i4 += j3;
            l3 ^= i4;
            l3 = l3 << 16 | l3 >>> -16;
            k3 += l3;
            j3 ^= k3;
            j3 = j3 << 12 | j3 >>> -12;
            i4 += j3;
            l3 ^= i4;
            l3 = l3 << 8 | l3 >>> -8;
            k3 += l3;
            j3 ^= k3;
            j3 = j3 << 7 | j3 >>> -7;
            i3 += j2;
            l2 ^= i3;
            l2 = l2 << 16 | l2 >>> -16;
            k2 += l2;
            j2 ^= k2;
            j2 = j2 << 12 | j2 >>> -12;
            i3 += j2;
            l2 ^= i3;
            l2 = l2 << 8 | l2 >>> -8;
            k2 += l2;
            j2 ^= k2;
            j2 = j2 << 7 | j2 >>> -7;
            i2 += j1;
            l1 ^= i2;
            l1 = l1 << 16 | l1 >>> -16;
            k1 += l1;
            j1 ^= k1;
            j1 = j1 << 12 | j1 >>> -12;
            i2 += j1;
            l1 ^= i2;
            l1 = l1 << 8 | l1 >>> -8;
            k1 += l1;
            j1 ^= k1;
            j1 = j1 << 7 | j1 >>> -7;
            i1 += j;
            l ^= i1;
            l = l << 16 | l >>> -16;
            k += l;
            j ^= k;
            j = j << 12 | j >>> -12;
            i1 += j;
            l ^= i1;
            int j4 = l << 8 | l >>> -8;
            k += j4;
            j ^= k;
            j = j << 7 | j >>> -7;
            l = i4 + j2;
            i4 = j4 ^ l;
            j4 = i4 << 16 | i4 >>> -16;
            k1 += j4;
            j2 ^= k1;
            j2 = j2 << 12 | j2 >>> -12;
            i4 = l + j2;
            l = j4 ^ i4;
            l = l << 8 | l >>> -8;
            k1 += l;
            j2 ^= k1;
            j2 = j2 << 7 | j2 >>> -7;
            i3 += j1;
            l3 ^= i3;
            l3 = l3 << 16 | l3 >>> -16;
            k += l3;
            j1 ^= k;
            j1 = j1 << 12 | j1 >>> -12;
            i3 += j1;
            l3 ^= i3;
            l3 = l3 << 8 | l3 >>> -8;
            k += l3;
            j1 ^= k;
            j1 = j1 << 7 | j1 >>> -7;
            i2 += j;
            l2 ^= i2;
            l2 = l2 << 16 | l2 >>> -16;
            k3 += l2;
            j ^= k3;
            j = j << 12 | j >>> -12;
            i2 += j;
            l2 ^= i2;
            l2 = l2 << 8 | l2 >>> -8;
            k3 += l2;
            j ^= k3;
            j = j << 7 | j >>> -7;
            i1 += j3;
            l1 ^= i1;
            l1 = l1 << 16 | l1 >>> -16;
            k2 += l1;
            j3 ^= k2;
            j3 = j3 << 12 | j3 >>> -12;
            i1 += j3;
            l1 ^= i1;
            l1 = l1 << 8 | l1 >>> -8;
            k2 += l1;
            j3 ^= k2;
            j3 = j3 << 7 | j3 >>> -7;
        }

        ai1[0] = ai[0] + i4;
        ai1[1] = ai[1] + i3;
        ai1[2] = ai[2] + i2;
        ai1[3] = ai[3] + i1;
        ai1[4] = ai[4] + j3;
        ai1[5] = ai[5] + j2;
        ai1[6] = ai[6] + j1;
        ai1[7] = ai[7] + j;
        ai1[8] = ai[8] + k3;
        ai1[9] = ai[9] + k2;
        ai1[10] = ai[10] + k1;
        ai1[11] = ai[11] + k;
        ai1[12] = ai[12] + l3;
        ai1[13] = ai[13] + l2;
        ai1[14] = ai[14] + l1;
        ai1[15] = ai[15] + l;
        Pack._mth02CE(asZ, abyte0, 0);
    }
}
