// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

abstract class GCMUtil
{

    private static final int awM[];

    GCMUtil()
    {
    }

    static int[] _mth01AB()
    {
        int ai[] = new int[4];
        ai[0] = 0x80000000;
        return ai;
    }

    static void _mth02BC(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = Arrays._mth1D4C(abyte0);
        byte abyte3[] = new byte[16];
        for (int i = 0; i < 16; i++)
        {
            byte byte0 = abyte1[i];
            for (int j = 7; j >= 0; j--)
            {
                if ((1 << j & byte0) != 0)
                {
                    int k = 0;
                    int i1;
                    do
                    {
                        abyte3[k] = (byte)(abyte3[k] ^ abyte2[k]);
                        k++;
                        abyte3[k] = (byte)(abyte3[k] ^ abyte2[k]);
                        k++;
                        abyte3[k] = (byte)(abyte3[k] ^ abyte2[k]);
                        k++;
                        abyte3[k] = (byte)(abyte3[k] ^ abyte2[k]);
                        i1 = k + 1;
                        k = i1;
                    } while (i1 < 16);
                }
                int j1 = 0;
                int l = 0;
                int k1;
                int l1;
                do
                {
                    k1 = abyte2[j1] & 0xff;
                    l1 = j1 + 1;
                    abyte2[j1] = (byte)(k1 >>> 1 | l);
                    l = abyte2[l1] & 0xff;
                    j1 = l1 + 1;
                    abyte2[l1] = (byte)(l >>> 1 | (k1 & 1) << 7);
                    l1 = abyte2[j1] & 0xff;
                    int i2 = j1 + 1;
                    abyte2[j1] = (byte)(l1 >>> 1 | (l & 1) << 7);
                    l = abyte2[i2] & 0xff;
                    k1 = i2 + 1;
                    abyte2[i2] = (byte)(l >>> 1 | (l1 & 1) << 7);
                    l1 = (l & 1) << 7;
                    j1 = k1;
                    l = l1;
                } while (k1 < 16);
                if ((byte)l1 != 0)
                {
                    abyte2[0] = (byte)(abyte2[0] ^ 0xffffffe1);
                }
            }

        }

        System.arraycopy(abyte3, 0, abyte0, 0, 16);
    }

    static void _mth02CA(int ai[], byte abyte0[])
    {
        Pack._mth02CB(ai, abyte0, 0);
    }

    static void _mth02CA(int ai[], int ai1[], int ai2[])
    {
        ai2[0] = ai[0] ^ ai1[0];
        ai2[1] = ai[1] ^ ai1[1];
        ai2[2] = ai[2] ^ ai1[2];
        ai2[3] = ai[3] ^ ai1[3];
    }

    static void _mth02CB(byte abyte0[], int ai[])
    {
        Pack._mth02CA(abyte0, 0, ai);
    }

    static void _mth02CB(int ai[], int ai1[])
    {
        int ai2[] = Arrays._mth02D1(ai);
        int ai3[] = new int[4];
        for (int i = 0; i < 4; i++)
        {
            int k = ai1[i];
            for (int j = 31; j >= 0; j--)
            {
                if ((1 << j & k) != 0)
                {
                    ai3[0] = ai3[0] ^ ai2[0];
                    ai3[1] = ai3[1] ^ ai2[1];
                    ai3[2] = ai3[2] ^ ai2[2];
                    ai3[3] = ai3[3] ^ ai2[3];
                }
                int i1 = ai2[0];
                ai2[0] = i1 >>> 1;
                int l = ai2[1];
                ai2[1] = l >>> 1 | i1 << 31;
                i1 = ai2[2];
                ai2[2] = i1 >>> 1 | l << 31;
                l = ai2[3];
                ai2[3] = l >>> 1 | i1 << 31;
                if (l << 31 != 0)
                {
                    ai2[0] = ai2[0] ^ 0xe1000000;
                }
            }

        }

        System.arraycopy(ai3, 0, ai, 0, 4);
    }

    static void _mth02CE(int ai[], int ai1[])
    {
        int j = ai[0];
        ai1[0] = j >>> 1;
        int i = ai[1];
        ai1[1] = i >>> 1 | j << 31;
        j = ai[2];
        ai1[2] = j >>> 1 | i << 31;
        i = ai[3];
        ai1[3] = i >>> 1 | j << 31;
        if (i << 31 != 0)
        {
            ai1[0] = ai1[0] ^ 0xe1000000;
        }
    }

    static void _mth02CF(int ai[], int ai1[])
    {
        int j = ai[0];
        ai1[0] = j >>> 8;
        int i = ai[1];
        ai1[1] = i >>> 8 | j << 24;
        j = ai[2];
        ai1[2] = j >>> 8 | i << 24;
        i = ai[3];
        ai1[3] = i >>> 8 | j << 24;
        ai1[0] = ai1[0] ^ awM[(i << 24) >>> 24];
    }

    static int[] _mth144A(byte abyte0[])
    {
        int ai[] = new int[4];
        Pack._mth02CA(abyte0, 0, ai);
        return ai;
    }

    static 
    {
        int ai[] = new int[256];
        for (int i = 0; i < 256; i++)
        {
            int k = 0;
            for (int j = 7; j >= 0;)
            {
                int l = k;
                if ((1 << j & i) != 0)
                {
                    l = k ^ 0xe1000000 >>> 7 - j;
                }
                j--;
                k = l;
            }

            ai[i] = k;
        }

        awM = ai;
    }
}
