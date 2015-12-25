// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.raw;

import java.util.Random;

// Referenced classes of package org.spongycastle.math.raw:
//            Nat

public abstract class Mod
{

    public Mod()
    {
    }

    public static void _mth02BC(int ai[], int ai1[], int ai2[])
    {
        int l = ai.length;
        if (Nat._mth02BE(l, ai1))
        {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
        if (Nat._mth1FBE(l, ai1))
        {
            System.arraycopy(ai1, 0, ai2, 0, l);
            return;
        }
        ai1 = Nat._mth02BC(l, ai1);
        int ai3[] = Nat._mth1D37(l);
        ai3[0] = 1;
        int i = 0;
        if ((ai1[0] & 1) == 0)
        {
            i = _mth02CA(ai, ai1, l, ai3, 0);
        }
        if (Nat._mth1FBE(l, ai1))
        {
            if (i < 0)
            {
                Nat._mth02CA(ai.length, ai3, ai, ai2);
                return;
            } else
            {
                System.arraycopy(ai3, 0, ai2, 0, ai.length);
                return;
            }
        }
        int ai4[] = Nat._mth02BC(l, ai);
        int ai5[] = Nat._mth1D37(l);
        int j = 0;
        int k;
        int j1;
        do
        {
            do
            {
                for (k = l; ai1[k - 1] == 0 && ai4[k - 1] == 0; k--) { }
                if (!Nat._mth02CF(k, ai1, ai4))
                {
                    break;
                }
                Nat._mth02BB(k, ai4, ai1);
                int i1 = _mth02CA(ai, ai1, k, ai3, i + (Nat._mth02BB(l, ai5, ai3) - j));
                i = i1;
                if (Nat._mth1FBE(k, ai1))
                {
                    if (i1 < 0)
                    {
                        Nat._mth02CA(ai.length, ai3, ai, ai2);
                        return;
                    } else
                    {
                        System.arraycopy(ai3, 0, ai2, 0, ai.length);
                        return;
                    }
                }
            } while (true);
            Nat._mth02BB(k, ai1, ai4);
            j1 = _mth02CA(ai, ai4, k, ai5, j + (Nat._mth02BB(l, ai3, ai5) - i));
            j = j1;
        } while (!Nat._mth1FBE(k, ai4));
        if (j1 < 0)
        {
            Nat._mth02CA(ai.length, ai5, ai, ai2);
            return;
        } else
        {
            System.arraycopy(ai5, 0, ai2, 0, ai.length);
            return;
        }
    }

    public static int[] _mth02BE(int ai[])
    {
        int l = ai.length;
        Random random = new Random();
        int ai1[] = Nat._mth1D37(l);
        int i = ai[l - 1];
        i |= i >>> 1;
        i |= i >>> 2;
        i |= i >>> 4;
        int i1 = i | i >>> 8;
        do
        {
            for (int j = 0; j != l; j++)
            {
                ai1[j] = random.nextInt();
            }

            int k = l - 1;
            ai1[k] = ai1[k] & (i1 | i1 >>> 16);
        } while (Nat._mth02CF(l, ai1, ai));
        return ai1;
    }

    private static int _mth02CA(int ai[], int ai1[], int i, int ai2[], int j)
    {
        int j1 = ai.length;
        int k;
        for (k = 0; ai1[0] == 0; k += 32)
        {
            Nat._mth141D(i, ai1, 0);
        }

        int l = ai1[0];
        int i1;
        for (i1 = 0; (l & 1) == 0; i1++)
        {
            l >>>= 1;
        }

        l = k;
        if (i1 > 0)
        {
            Nat._mth02CB(i, ai1, i1, 0);
            l = k + i1;
        }
        i = 0;
        k = j;
        for (j = i; j < l;)
        {
            i = k;
            if ((ai2[0] & 1) != 0)
            {
                if (k < 0)
                {
                    i = k + Nat._mth02CB(j1, ai, ai2);
                } else
                {
                    i = k + Nat._mth02BB(j1, ai, ai2);
                }
            }
            Nat._mth02CF(j1, ai2, i);
            j++;
            k = i;
        }

        return k;
    }
}
