// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            PolynomialRingGF2, RandUtils

public class GF2mField
{

    public int aOA;
    int aOz;

    public GF2mField(int i, int j)
    {
        aOz = 0;
        if (i != PolynomialRingGF2._mth03AA(j))
        {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        }
        if (!PolynomialRingGF2._mth0407(j))
        {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        } else
        {
            aOz = i;
            aOA = j;
            return;
        }
    }

    private static String _mth0268(int i)
    {
        String s = "";
        if (i == 0)
        {
            return "0";
        }
        if ((byte)(i & 1) == 1)
        {
            s = "1";
        }
        int j = i >>> 1;
        i = 1;
        while (j != 0) 
        {
            String s1 = s;
            if ((byte)(j & 1) == 1)
            {
                s1 = (new StringBuilder()).append(s).append("+x^").append(i).toString();
            }
            j >>>= 1;
            i++;
            s = s1;
        }
        return s;
    }

    public static int _mth1D40(int i, int j)
    {
        return i ^ j;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2mField))
        {
            return false;
        }
        obj = (GF2mField)obj;
        return aOz == ((GF2mField) (obj)).aOz && aOA == ((GF2mField) (obj)).aOA;
    }

    public int hashCode()
    {
        return aOA;
    }

    public String toString()
    {
        return (new StringBuilder("Finite Field GF(2^")).append(aOz).append(") = GF(2)[X]/<").append(_mth0268(aOA)).append("> ").toString();
    }

    public final boolean _mth0208(int i)
    {
        if (aOz == 31)
        {
            return i >= 0;
        }
        return i >= 0 && i < 1 << aOz;
    }

    public final String _mth020B(int i)
    {
        String s = "";
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < aOz; i++)
        {
            if (((byte)j & 1) == 0)
            {
                s = (new StringBuilder("0")).append(s).toString();
            } else
            {
                s = (new StringBuilder("1")).append(s).toString();
            }
            j >>>= 1;
        }

        return s;
    }

    public final int _mth02CA(SecureRandom securerandom)
    {
        int j = 0;
        int i;
        for (i = RandUtils._mth02CB(securerandom, 1 << aOz); i == 0 && j < 0x100000; j++)
        {
            i = RandUtils._mth02CB(securerandom, 1 << aOz);
        }

        if (j == 0x100000)
        {
            i = 1;
        }
        return i;
    }

    public final int _mth1D4B(int i, int j)
    {
        if (i == 0)
        {
            return 0;
        }
        if (i == 1)
        {
            return 1;
        }
        boolean flag = true;
        int i1 = ((flag) ? 1 : 0);
        int l = i;
        int k = j;
        if (j < 0)
        {
            l = _mth1D4B(i, (1 << aOz) - 2);
            k = -j;
            i1 = ((flag) ? 1 : 0);
        }
        while (k != 0) 
        {
            i = i1;
            if ((k & 1) == 1)
            {
                i = PolynomialRingGF2._mth1428(i1, l, aOA);
            }
            l = PolynomialRingGF2._mth1428(l, l, aOA);
            k >>>= 1;
            i1 = i;
        }
        return i1;
    }

    public final int FF68(int i)
    {
        return _mth1D4B(i, (1 << aOz) - 2);
    }
}
