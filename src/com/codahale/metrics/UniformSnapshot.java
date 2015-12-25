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

public class UniformSnapshot extends Snapshot
{

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final long values[];

    public UniformSnapshot(Collection collection)
    {
        collection = ((Collection) (collection.toArray()));
        values = new long[collection.length];
        for (int i = 0; i < collection.length; i++)
        {
            values[i] = ((Long)collection[i]).longValue();
        }

        Arrays.sort(values);
    }

    public UniformSnapshot(long al[])
    {
        values = Arrays.copyOf(al, al.length);
        Arrays.sort(values);
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
        long al[] = values;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            d += al[i];
        }

        return d / (double)values.length;
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
        long al[] = values;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            double d2 = (double)al[i] - d1;
            d += d2 * d2;
        }

        return Math.sqrt(d / (double)(values.length - 1));
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
        d = (double)(values.length + 1) * d;
        if (d < 1.0D)
        {
            return (double)values[0];
        }
        if (d >= (double)values.length)
        {
            return (double)values[values.length - 1];
        } else
        {
            double d1 = values[(int)d - 1];
            double d2 = values[(int)d];
            return (d - Math.floor(d)) * (d2 - d1) + d1;
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

}
