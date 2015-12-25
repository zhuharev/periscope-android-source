// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

// Referenced classes of package com.codahale.metrics:
//            Snapshot

public class WeightedSnapshot extends Snapshot
{
    public static class WeightedSample
    {

        public final long value;
        public final double weight;

        public WeightedSample(long l, double d)
        {
            value = l;
            weight = d;
        }
    }


    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final double normWeights[];
    private final double quantiles[];
    private final long values[];

    public WeightedSnapshot(Collection collection)
    {
        collection = (WeightedSample[])collection.toArray(new WeightedSample[0]);
        Arrays.sort(collection, new _cls1());
        values = new long[collection.length];
        normWeights = new double[collection.length];
        quantiles = new double[collection.length];
        double d = 0.0D;
        int l = collection.length;
        for (int i = 0; i < l; i++)
        {
            d += ((WeightedSample) (collection[i])).weight;
        }

        for (int j = 0; j < collection.length; j++)
        {
            values[j] = ((WeightedSample) (collection[j])).value;
            normWeights[j] = ((WeightedSample) (collection[j])).weight / d;
        }

        for (int k = 1; k < collection.length; k++)
        {
            double ad[] = quantiles;
            ad[k] = ad[k - 1] + normWeights[k - 1];
        }

    }

    public void dump(OutputStream outputstream)
    {
        outputstream = new PrintWriter(new OutputStreamWriter(outputstream, UTF_8));
        long al[];
        int j;
        al = values;
        j = al.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        outputstream.printf("%d%n", new Object[] {
            Long.valueOf(al[i])
        });
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        outputstream.close();
        return;
        Exception exception;
        exception;
        outputstream.close();
        throw exception;
    }

    public long getMax()
    {
        if (values.length == 0)
        {
            return 0L;
        } else
        {
            return values[values.length - 1];
        }
    }

    public double getMean()
    {
        if (values.length == 0)
        {
            return 0.0D;
        }
        double d = 0.0D;
        for (int i = 0; i < values.length; i++)
        {
            d += (double)values[i] * normWeights[i];
        }

        return d;
    }

    public long getMin()
    {
        if (values.length == 0)
        {
            return 0L;
        } else
        {
            return values[0];
        }
    }

    public double getStdDev()
    {
        if (values.length <= 1)
        {
            return 0.0D;
        }
        double d1 = getMean();
        double d = 0.0D;
        for (int i = 0; i < values.length; i++)
        {
            double d2 = (double)values[i] - d1;
            d += normWeights[i] * d2 * d2;
        }

        return Math.sqrt(d);
    }

    public double getValue(double d)
    {
        if (d < 0.0D || d > 1.0D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not in [0..1]").toString());
        }
        if (values.length == 0)
        {
            return 0.0D;
        }
        int k = Arrays.binarySearch(quantiles, d);
        int i = k;
        int j = i;
        if (k < 0)
        {
            j = -i - 1 - 1;
        }
        if (j <= 0)
        {
            return (double)values[0];
        }
        if (j >= values.length)
        {
            return (double)values[values.length - 1];
        } else
        {
            return (double)values[j];
        }
    }

    public long[] getValues()
    {
        return Arrays.copyOf(values, values.length);
    }

    public int size()
    {
        return values.length;
    }


    private class _cls1
        implements Comparator
    {

        final WeightedSnapshot this$0;

        public int compare(WeightedSample weightedsample, WeightedSample weightedsample1)
        {
            if (weightedsample.value > weightedsample1.value)
            {
                return 1;
            }
            return weightedsample.value >= weightedsample1.value ? 0 : -1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((WeightedSample)obj, (WeightedSample)obj1);
        }

        _cls1()
        {
            this$0 = WeightedSnapshot.this;
            super();
        }
    }

}
