// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class RainbowUtil
{

    public RainbowUtil()
    {
    }

    public static boolean equals(short aword0[], short aword1[])
    {
        if (aword0.length != aword1.length)
        {
            return false;
        }
        boolean flag1 = true;
        for (int i = aword0.length - 1; i >= 0; i--)
        {
            boolean flag;
            if (aword0[i] == aword1[i])
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 &= flag;
        }

        return flag1;
    }

    public static boolean _mth02CA(short aword0[][][], short aword1[][][])
    {
        if (aword0.length != aword1.length)
        {
            return false;
        }
        boolean flag = true;
        for (int i = aword0.length - 1; i >= 0; i--)
        {
            flag &= _mth02CB(aword0[i], aword1[i]);
        }

        return flag;
    }

    public static byte[] _mth02CA(short aword0[])
    {
        byte abyte0[] = new byte[aword0.length];
        for (int i = 0; i < aword0.length; i++)
        {
            abyte0[i] = (byte)aword0[i];
        }

        return abyte0;
    }

    public static short[][][] _mth02CA(byte abyte0[][][])
    {
        int i = abyte0.length;
        int k = abyte0[0].length;
        int i1 = abyte0[0][0].length;
        short aword0[][][] = (short[][][])Array.newInstance(Short.TYPE, new int[] {
            i, k, i1
        });
        for (int j = 0; j < abyte0.length; j++)
        {
            for (int l = 0; l < abyte0[0].length; l++)
            {
                for (int j1 = 0; j1 < abyte0[0][0].length; j1++)
                {
                    aword0[j][l][j1] = (short)(abyte0[j][l][j1] & 0xff);
                }

            }

        }

        return aword0;
    }

    public static boolean _mth02CB(short aword0[][], short aword1[][])
    {
        if (aword0.length != aword1.length)
        {
            return false;
        }
        boolean flag = true;
        for (int i = aword0.length - 1; i >= 0; i--)
        {
            flag &= equals(aword0[i], aword1[i]);
        }

        return flag;
    }

    public static byte[][] _mth02CB(short aword0[][])
    {
        int i = aword0.length;
        int k = aword0[0].length;
        byte abyte0[][] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            i, k
        });
        for (int j = 0; j < aword0.length; j++)
        {
            for (int l = 0; l < aword0[0].length; l++)
            {
                abyte0[j][l] = (byte)aword0[j][l];
            }

        }

        return abyte0;
    }

    public static byte[][][] _mth02CB(short aword0[][][])
    {
        int i = aword0.length;
        int k = aword0[0].length;
        int i1 = aword0[0][0].length;
        byte abyte0[][][] = (byte[][][])Array.newInstance(Byte.TYPE, new int[] {
            i, k, i1
        });
        for (int j = 0; j < aword0.length; j++)
        {
            for (int l = 0; l < aword0[0].length; l++)
            {
                for (int j1 = 0; j1 < aword0[0][0].length; j1++)
                {
                    abyte0[j][l][j1] = (byte)aword0[j][l][j1];
                }

            }

        }

        return abyte0;
    }

    public static byte[] _mth02CD(int ai[])
    {
        byte abyte0[] = new byte[ai.length];
        for (int i = 0; i < ai.length; i++)
        {
            abyte0[i] = (byte)ai[i];
        }

        return abyte0;
    }

    public static short[][] _mth02CE(byte abyte0[][])
    {
        int i = abyte0.length;
        int k = abyte0[0].length;
        short aword0[][] = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, k
        });
        for (int j = 0; j < abyte0.length; j++)
        {
            for (int l = 0; l < abyte0[0].length; l++)
            {
                aword0[j][l] = (short)(abyte0[j][l] & 0xff);
            }

        }

        return aword0;
    }

    public static int[] _mth14A1(byte abyte0[])
    {
        int ai[] = new int[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            ai[i] = abyte0[i] & 0xff;
        }

        return ai;
    }

    public static short[] _mth14A2(byte abyte0[])
    {
        short aword0[] = new short[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            aword0[i] = (short)(abyte0[i] & 0xff);
        }

        return aword0;
    }
}
