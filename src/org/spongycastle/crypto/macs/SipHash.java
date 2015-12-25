// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class SipHash
    implements Mac
{

    private int asc;
    private int avA;
    private int avB;
    private int avs;
    private long avt;
    private long avu;
    private long avv;
    private long avw;
    private long avx;
    private long avy;
    private long avz;

    public SipHash()
    {
        avz = 0L;
        avA = 0;
        avB = 0;
        asc = 2;
        avs = 4;
    }

    public SipHash(int i, int j)
    {
        avz = 0L;
        avA = 0;
        avB = 0;
        asc = 4;
        avs = 8;
    }

    private void FF3F(int i)
    {
        long l3 = avv;
        long l1 = avw;
        long l2 = avx;
        long l = avy;
        for (int j = 0; j < i; j++)
        {
            l3 += l1;
            l2 += l;
            l1 = (l1 << 13 | l1 >>> -13) ^ l3;
            l = (l << 16 | l >>> -16) ^ l2;
            l2 += l1;
            l3 = (l3 << 32 | l3 >>> -32) + l;
            l1 = (l1 << 17 | l1 >>> -17) ^ l2;
            l = (l << 21 | l >>> -21) ^ l3;
            l2 = l2 << 32 | l2 >>> -32;
        }

        avv = l3;
        avw = l1;
        avx = l2;
        avy = l;
    }

    private void FF9C()
    {
        avB = avB + 1;
        avy = avy ^ avz;
        FF3F(asc);
        avv = avv ^ avz;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        avz = avz >>> (7 - avA << 3);
        avz = avz >>> 8;
        avz = avz | ((long)((avB << 3) + avA) & 255L) << 56;
        FF9C();
        avx = avx ^ 255L;
        FF3F(avs);
        long l = avv;
        long l1 = avw;
        long l2 = avx;
        long l3 = avy;
        reset();
        Pack._mth141D(l ^ l1 ^ l2 ^ l3, abyte0, 0);
        return 8;
    }

    public final void reset()
    {
        avv = avt ^ 0x736f6d6570736575L;
        avw = avu ^ 0x646f72616e646f6dL;
        avx = avt ^ 0x6c7967656e657261L;
        avy = avu ^ 0x7465646279746573L;
        avz = 0L;
        avA = 0;
        avB = 0;
    }

    public final void update(byte byte0)
    {
        avz = avz >>> 8;
        avz = avz | ((long)byte0 & 255L) << 56;
        byte0 = avA + 1;
        avA = byte0;
        if (byte0 == 8)
        {
            FF9C();
            avA = 0;
        }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int k = 0;
        int i1 = 0;
        int j1 = j & -8;
        if (avA == 0)
        {
            k = i1;
            do
            {
                i1 = k;
                if (k >= j1)
                {
                    break;
                }
                avz = Pack._mth02C7(abyte0, i + k);
                FF9C();
                k += 8;
            } while (true);
            for (; i1 < j; i1++)
            {
                avz = avz >>> 8;
                avz = avz | ((long)abyte0[i + i1] & 255L) << 56;
            }

            avA = j - j1;
            return;
        }
        int k1 = avA << 3;
        do
        {
            i1 = k;
            if (k >= j1)
            {
                break;
            }
            long l1 = Pack._mth02C7(abyte0, i + k);
            avz = l1 << k1 | avz >>> -k1;
            FF9C();
            avz = l1;
            k += 8;
        } while (true);
        for (; i1 < j; i1++)
        {
            avz = avz >>> 8;
            avz = avz | ((long)abyte0[i + i1] & 255L) << 56;
            int l = avA + 1;
            avA = l;
            if (l == 8)
            {
                FF9C();
                avA = 0;
            }
        }

    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
        }
        cipherparameters = ((KeyParameter)cipherparameters).key;
        if (cipherparameters.length != 16)
        {
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        } else
        {
            avt = Pack._mth02C7(cipherparameters, 0);
            avu = Pack._mth02C7(cipherparameters, 8);
            reset();
            return;
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("SipHash-")).append(asc).append("-").append(avs).toString();
    }

    public final int _mth14B3()
    {
        return 8;
    }
}
