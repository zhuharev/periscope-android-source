// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.text.DecimalFormat;
import java.util.HashMap;

public final class aph
{

    public int byB;
    public double byC;
    public double byD;
    public double byE;
    public double byF;

    public aph()
    {
        byB = 0;
        byC = 0.0D;
        byD = 0.0D;
        byE = 0.0D;
        byF = 0.0D;
    }

    private double eh()
    {
        double d = 0.0D;
        if (byB > 1)
        {
            d = Math.sqrt((byF - (byE * byE) / (double)byB) / (double)(byB - 1));
        }
        return d;
    }

    public final String toString()
    {
        DecimalFormat decimalformat = new DecimalFormat("0.###");
        StringBuilder stringbuilder = new StringBuilder("Mean ");
        double d = 0.0D;
        if (byB > 0)
        {
            d = byE / (double)byB;
        }
        return stringbuilder.append(decimalformat.format(d)).append(" StdDev ").append(decimalformat.format(eh())).append(" Min ").append(decimalformat.format(byC)).append(" Max ").append(decimalformat.format(byD)).toString();
    }

    public final void _mth02CA(HashMap hashmap, String s)
    {
        String s1 = (new StringBuilder()).append(s).append("_mean").toString();
        double d = 0.0D;
        if (byB > 0)
        {
            d = byE / (double)byB;
        }
        hashmap.put(s1, Double.valueOf(d));
        hashmap.put((new StringBuilder()).append(s).append("_stddev").toString(), Double.valueOf(eh()));
        hashmap.put((new StringBuilder()).append(s).append("_min").toString(), Double.valueOf(byC));
        hashmap.put((new StringBuilder()).append(s).append("_max").toString(), Double.valueOf(byD));
    }

    public final void _mth02CE(double d)
    {
        byB = byB + 1;
        byE = byE + d;
        byF = byF + d * d;
        if (d > byD)
        {
            byD = d;
        }
        if (byB == 0 || d < byC)
        {
            byC = d;
        }
    }
}
