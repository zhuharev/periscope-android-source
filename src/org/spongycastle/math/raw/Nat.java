// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat
{

    public Nat()
    {
    }

    public static int _mth02BB(int i, int ai[], int j, int ai1[], int k)
    {
        long l = 0L;
        for (j = 0; j < i; j++)
        {
            l += ((long)ai1[k + j] & 0xffffffffL) - ((long)ai[j + 0] & 0xffffffffL);
            ai1[k + j] = (int)l;
            l >>= 32;
        }

        return (int)l;
    }

    public static int _mth02BB(int i, int ai[], int ai1[])
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai1[j] & 0xffffffffL) - ((long)ai[j] & 0xffffffffL);
            ai1[j] = (int)l;
            l >>= 32;
        }

        return (int)l;
    }

    public static int[] _mth02BC(int i, int ai[])
    {
        int ai1[] = new int[i];
        System.arraycopy(ai, 0, ai1, 0, i);
        return ai1;
    }

    public static int _mth02BD(int i, int ai[])
    {
        for (i = 0; i < 16; i++)
        {
            int j = ai[i] - 1;
            ai[i] = j;
            if (j != -1)
            {
                return 0;
            }
        }

        return -1;
    }

    public static boolean _mth02BE(int i, int ai[])
    {
        for (int j = 0; j < i; j++)
        {
            if (ai[j] != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static BigInteger _mth02BF(int i, int ai[])
    {
        byte abyte0[] = new byte[i << 2];
        for (int j = 0; j < i; j++)
        {
            int k = ai[j];
            if (k != 0)
            {
                Pack._mth1FBE(k, abyte0, i - 1 - j << 2);
            }
        }

        return new BigInteger(1, abyte0);
    }

    public static void _mth02C8(int i, int ai[])
    {
        for (int j = 0; j < i; j++)
        {
            ai[j] = 0;
        }

    }

    public static int _mth02CA(int i, int j, int ai[], int k)
    {
        long l = ((long)j & 0xffffffffL) + ((long)ai[k] & 0xffffffffL);
        ai[k] = (int)l;
        if (l >>> 32 == 0L)
        {
            return 0;
        }
        for (j = k + 1; j < i; j++)
        {
            k = ai[j] + 1;
            ai[j] = k;
            if (k != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth02CA(int i, int j, int ai[], int k, int ai1[], int l)
    {
        long l1 = 0L;
        long l3 = j;
        i = 0;
        long l2;
        do
        {
            l1 += ((long)ai[i + 0] & 0xffffffffL) * (l3 & 0xffffffffL) + ((long)ai1[i + 16] & 0xffffffffL);
            ai1[i + 16] = (int)l1;
            l2 = l1 >>> 32;
            j = i + 1;
            l1 = l2;
            i = j;
        } while (j < 16);
        return (int)l2;
    }

    public static int _mth02CA(int i, int j, int ai[], int k, int ai1[], int ai2[], int l)
    {
        long l1 = 0L;
        long l3 = j;
        long l4 = k;
        i = 0;
        long l2;
        do
        {
            l1 += ((long)ai[i] & 0xffffffffL) * (l3 & 0xffffffffL) + ((long)ai1[i] & 0xffffffffL) * (l4 & 0xffffffffL) + ((long)ai2[i + 16] & 0xffffffffL);
            ai2[i + 16] = (int)l1;
            l2 = l1 >>> 32;
            j = i + 1;
            l1 = l2;
            i = j;
        } while (j < 16);
        return (int)l2;
    }

    public static int _mth02CA(int i, int ai[], int j, int k)
    {
        for (; k < i; k++)
        {
            int l = j + k;
            int i1 = ai[l] + 1;
            ai[l] = i1;
            if (i1 != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth02CA(int i, int ai[], int j, int k, int l, int ai1[], int i1)
    {
        i = 16;
        do
        {
            i--;
            if (i >= 0)
            {
                j = ai[i + 16];
                ai1[i + 0] = j >>> 9 | l << -9;
                l = j;
            } else
            {
                return l << -9;
            }
        } while (true);
    }

    public static int _mth02CA(int i, int ai[], int j, int k, int ai1[])
    {
        for (j = 0; j < i; j++)
        {
            int l = ai[j];
            ai1[j] = l << 3 | k >>> -3;
            k = l;
        }

        return k >>> -3;
    }

    public static int _mth02CA(int i, int ai[], int j, int k, int ai1[], int l)
    {
        for (i = 0; i < 8; i++)
        {
            j = ai[i + 8];
            ai1[i + 0] = j << 1 | k >>> 31;
            k = j;
        }

        return k >>> 31;
    }

    public static int _mth02CA(int i, int ai[], int j, int ai1[])
    {
        boolean flag = false;
        int k = j;
        for (j = ((flag) ? 1 : 0); j < i; j++)
        {
            int l = ai[j];
            ai1[j] = l << 1 | k >>> 31;
            k = l;
        }

        return k >>> 31;
    }

    public static int _mth02CA(int i, int ai[], int ai1[], int ai2[])
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai[j] & 0xffffffffL) + ((long)ai1[j] & 0xffffffffL);
            ai2[j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int _mth02CB(int i, int j, int ai[])
    {
        long l = ((long)ai[0] & 0xffffffffL) + ((long)j & 0xffffffffL);
        ai[0] = (int)l;
        l = (l >>> 32) + (((long)ai[1] & 0xffffffffL) + 1L);
        ai[1] = (int)l;
        if (l >>> 32 == 0L)
        {
            return 0;
        }
        for (j = 2; j < i; j++)
        {
            int k = ai[j] + 1;
            ai[j] = k;
            if (k != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth02CB(int i, int ai[], int j)
    {
        for (; j < i; j++)
        {
            int k = ai[j] - 1;
            ai[j] = k;
            if (k != -1)
            {
                return 0;
            }
        }

        return -1;
    }

    public static int _mth02CB(int i, int ai[], int j, int k)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                int l = ai[i];
                ai[i] = l >>> j | k << -j;
                k = l;
            } else
            {
                return k << -j;
            }
        } while (true);
    }

    public static int _mth02CB(int i, int ai[], int ai1[])
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai[j] & 0xffffffffL) + ((long)ai1[j] & 0xffffffffL);
            ai1[j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int _mth02CB(int i, int ai[], int ai1[], int ai2[])
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai[j] & 0xffffffffL) + ((long)ai1[j] & 0xffffffffL) + ((long)ai2[j] & 0xffffffffL);
            ai2[j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int _mth02CE(int i, int j, int ai[])
    {
        long l = ((long)j & 0xffffffffL) + ((long)ai[0] & 0xffffffffL);
        ai[0] = (int)l;
        if (l >>> 32 == 0L)
        {
            return 0;
        }
        for (j = 1; j < i; j++)
        {
            int k = ai[j] + 1;
            ai[j] = k;
            if (k != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth02CE(int i, int ai[], int j)
    {
        for (; j < i; j++)
        {
            int k = ai[j] + 1;
            ai[j] = k;
            if (k != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth02CE(int i, int ai[], int j, int k)
    {
        for (j = 0; j < i; j++)
        {
            int l = ai[j];
            ai[j] = l << 2 | k >>> -2;
            k = l;
        }

        return k >>> -2;
    }

    public static int _mth02CE(int i, int ai[], int ai1[], int ai2[])
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai[j] & 0xffffffffL) - ((long)ai1[j] & 0xffffffffL);
            ai2[j] = (int)l;
            l >>= 32;
        }

        return (int)l;
    }

    public static int _mth02CE(int ai[], int i)
    {
        return ai[0] & 1;
    }

    public static boolean _mth02CE(int i, int ai[], int ai1[])
    {
        for (i--; i >= 0; i--)
        {
            if (ai[i] != ai1[i])
            {
                return false;
            }
        }

        return true;
    }

    public static int _mth02CF(int i, int j, int ai[])
    {
        long l = ((long)ai[0] & 0xffffffffL) - ((long)j & 0xffffffffL);
        ai[0] = (int)l;
        l = (l >> 32) + (((long)ai[1] & 0xffffffffL) - 1L);
        ai[1] = (int)l;
        if (l >> 32 == 0L)
        {
            return 0;
        }
        for (j = 2; j < i; j++)
        {
            int k = ai[j] - 1;
            ai[j] = k;
            if (k != -1)
            {
                return 0;
            }
        }

        return -1;
    }

    public static int _mth02CF(int i, int ai[], int j)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                int k = ai[i];
                ai[i] = k >>> 1 | j << 31;
                j = k;
            } else
            {
                return j << 31;
            }
        } while (true);
    }

    public static boolean _mth02CF(int i, int ai[], int ai1[])
    {
        for (i--; i >= 0; i--)
        {
            int j = ai[i] ^ 0x80000000;
            int k = ai1[i] ^ 0x80000000;
            if (j < k)
            {
                return false;
            }
            if (j > k)
            {
                return true;
            }
        }

        return true;
    }

    public static int _mth037A(int i, int ai[])
    {
        for (i = 0; i < 16; i++)
        {
            int j = ai[i] + 1;
            ai[i] = j;
            if (j != 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static int _mth141D(int i, int ai[], int j)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                int k = ai[i];
                ai[i] = j;
                j = k;
            } else
            {
                return j;
            }
        } while (true);
    }

    public static int _mth141D(int i, int ai[], int j, int ai1[], int k)
    {
        long l = 0L;
        for (j = 0; j < i; j++)
        {
            l += ((long)ai[j + 0] & 0xffffffffL) + ((long)ai1[k + j] & 0xffffffffL);
            ai1[k + j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int _mth141D(int i, int ai[], int ai1[])
    {
        for (int j = 0; j < i;)
        {
            int k = ai[j] + 1;
            ai1[j] = k;
            j++;
            if (k != 0)
            {
                for (; j < i; j++)
                {
                    ai1[j] = ai[j];
                }

                return 0;
            }
        }

        return 1;
    }

    public static int[] _mth141D(int i, BigInteger biginteger)
    {
        if (biginteger.signum() < 0 || biginteger.bitLength() > i)
        {
            throw new IllegalArgumentException();
        }
        int ai[] = new int[i + 31 >> 5];
        int j;
        for (i = 0; biginteger.signum() != 0; i = j)
        {
            j = i + 1;
            ai[i] = biginteger.intValue();
            biginteger = biginteger.shiftRight(32);
        }

        return ai;
    }

    public static int[] _mth1D37(int i)
    {
        return new int[i];
    }

    public static boolean _mth1FBE(int i, int ai[])
    {
        if (ai[0] != 1)
        {
            return false;
        }
        for (int j = 1; j < i; j++)
        {
            if (ai[j] != 0)
            {
                return false;
            }
        }

        return true;
    }
}
