// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.pqc.math.ntru.euclid.IntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial;
import org.spongycastle.util.Integers;

public class Util
{

    private static volatile boolean aPr;
    private static volatile boolean aPs;

    public Util()
    {
    }

    public static int _mth01C3(int i, int j)
    {
        int l = i % j;
        i = l;
        int k = i;
        if (l < 0)
        {
            k = i + j;
        }
        return IntEuclidean._mth0131(k, j).x;
    }

    public static TernaryPolynomial _mth02CA(int i, int j, int k, boolean flag, SecureRandom securerandom)
    {
        if (flag)
        {
            return SparseTernaryPolynomial._mth02CB(i, j, k, securerandom);
        } else
        {
            return DenseTernaryPolynomial._mth02CA(i, j, k, securerandom);
        }
    }

    public static int[] _mth02CE(int i, int j, int k, SecureRandom securerandom)
    {
        Integer integer = Integers.valueOf(1);
        Integer integer1 = Integers.valueOf(-1);
        Integer integer2 = Integers.valueOf(0);
        ArrayList arraylist = new ArrayList();
        for (int l = 0; l < j; l++)
        {
            arraylist.add(integer);
        }

        for (j = 0; j < k; j++)
        {
            arraylist.add(integer1);
        }

        for (; arraylist.size() < i; arraylist.add(integer2)) { }
        Collections.shuffle(arraylist, securerandom);
        securerandom = new int[i];
        for (j = 0; j < i; j++)
        {
            securerandom[j] = ((Integer)arraylist.get(j)).intValue();
        }

        return securerandom;
    }

    public static boolean _mth1E1E()
    {
        if (!aPr)
        {
            String s = System.getProperty("os.arch");
            String s1 = System.getProperty("sun.arch.data.model");
            boolean flag;
            if ("amd64".equals(s) || "x86_64".equals(s) || "ppc64".equals(s) || "64".equals(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aPs = flag;
            aPr = true;
        }
        return aPs;
    }

    public static int FE73(int i, int j, int k)
    {
        int i1 = 1;
        for (int l = 0; l < j; l++)
        {
            i1 = (i1 * i) % k;
        }

        return i1;
    }
}
