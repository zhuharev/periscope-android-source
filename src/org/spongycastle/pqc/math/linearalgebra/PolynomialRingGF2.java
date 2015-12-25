// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.io.PrintStream;

public final class PolynomialRingGF2
{

    private PolynomialRingGF2()
    {
    }

    public static int _mth03AA(int i)
    {
        int j = -1;
        for (; i != 0; i >>>= 1)
        {
            j++;
        }

        return j;
    }

    public static boolean _mth0407(int i)
    {
        if (i == 0)
        {
            return false;
        }
        int j = i;
        int l = -1;
        for (; j != 0; j >>>= 1)
        {
            l++;
        }

        int j1 = 2;
        for (int i1 = 0; i1 < l >>> 1; i1++)
        {
            int k1 = _mth1428(j1, j1, i);
            j1 = k1;
            int k = i;
            k1 ^= 2;
            int l1;
            for (; k != 0; k = l1)
            {
                l1 = FF9F(k1, k);
                k1 = k;
            }

            if (k1 != 1)
            {
                return false;
            }
        }

        return true;
    }

    public static int _mth0433(int i)
    {
        if (i < 0)
        {
            System.err.println("The Degree is negative");
            return 0;
        }
        if (i > 31)
        {
            System.err.println("The Degree is more then 31");
            return 0;
        }
        if (i == 0)
        {
            return 1;
        }
        for (int j = (1 << i) + 1; j < 1 << i + 1; j += 2)
        {
            if (_mth0407(j))
            {
                return j;
            }
        }

        return 0;
    }

    public static int _mth1428(int i, int j, int k)
    {
        int i1 = 0;
        boolean flag = false;
        int j1 = FF9F(i, k);
        j = FF9F(j, k);
        i = j;
        if (j != 0)
        {
            j = k;
            int l = -1;
            for (; j != 0; j >>>= 1)
            {
                l++;
            }

            j = i;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j1 == 0)
                {
                    break;
                }
                i1 = i;
                if ((byte)(j1 & 1) == 1)
                {
                    i1 = i ^ j;
                }
                j1 >>>= 1;
                int k1 = j << 1;
                i = k1;
                j = i;
                if (k1 >= 1 << l)
                {
                    j = i ^ k;
                }
                i = i1;
            } while (true);
        }
        return i1;
    }

    private static int FF9F(int i, int j)
    {
        if (j == 0)
        {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        do
        {
            int i1 = i;
            int k = -1;
            for (; i1 != 0; i1 >>>= 1)
            {
                k++;
            }

            i1 = j;
            int k1 = -1;
            for (; i1 != 0; i1 >>>= 1)
            {
                k1++;
            }

            if (k >= k1)
            {
                int j1 = i;
                int l = -1;
                for (; j1 != 0; j1 >>>= 1)
                {
                    l++;
                }

                j1 = j;
                int l1 = -1;
                for (; j1 != 0; j1 >>>= 1)
                {
                    l1++;
                }

                i ^= j << l - l1;
            } else
            {
                return i;
            }
        } while (true);
    }
}
