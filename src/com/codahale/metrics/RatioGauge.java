// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Gauge

public abstract class RatioGauge
    implements Gauge
{
    public static class Ratio
    {

        private final double denominator;
        private final double numerator;

        public static Ratio of(double d, double d1)
        {
            return new Ratio(d, d1);
        }

        public double getValue()
        {
            double d = denominator;
            if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0D)
            {
                return (0.0D / 0.0D);
            } else
            {
                return numerator / d;
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append(numerator).append(":").append(denominator).toString();
        }

        private Ratio(double d, double d1)
        {
            numerator = d;
            denominator = d1;
        }
    }


    public RatioGauge()
    {
    }

    protected abstract Ratio getRatio();

    public Double getValue()
    {
        return Double.valueOf(getRatio().getValue());
    }

    public volatile Object getValue()
    {
        return getValue();
    }
}
