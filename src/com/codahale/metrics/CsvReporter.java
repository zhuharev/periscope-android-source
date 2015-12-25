// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;
import o.wt;
import o.wu;

// Referenced classes of package com.codahale.metrics:
//            ScheduledReporter, Counter, Gauge, Histogram, 
//            Snapshot, Meter, Timer, Clock, 
//            MetricRegistry, MetricFilter

public class CsvReporter extends ScheduledReporter
{
    public static class Builder
    {

        private Clock clock;
        private TimeUnit durationUnit;
        private MetricFilter filter;
        private Locale locale;
        private TimeUnit rateUnit;
        private final MetricRegistry registry;

        public CsvReporter build(File file)
        {
            return new CsvReporter(registry, file, locale, rateUnit, durationUnit, clock, filter);
        }

        public Builder convertDurationsTo(TimeUnit timeunit)
        {
            durationUnit = timeunit;
            return this;
        }

        public Builder convertRatesTo(TimeUnit timeunit)
        {
            rateUnit = timeunit;
            return this;
        }

        public Builder filter(MetricFilter metricfilter)
        {
            filter = metricfilter;
            return this;
        }

        public Builder formatFor(Locale locale1)
        {
            locale = locale1;
            return this;
        }

        public Builder withClock(Clock clock1)
        {
            clock = clock1;
            return this;
        }

        private Builder(MetricRegistry metricregistry)
        {
            registry = metricregistry;
            locale = Locale.getDefault();
            rateUnit = TimeUnit.SECONDS;
            durationUnit = TimeUnit.MILLISECONDS;
            clock = Clock.defaultClock();
            filter = MetricFilter.ALL;
        }

    }


    private static final wt LOGGER = wu._mth02BF(com/codahale/metrics/CsvReporter);
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Clock clock;
    private final File directory;
    private final Locale locale;

    private CsvReporter(MetricRegistry metricregistry, File file, Locale locale1, TimeUnit timeunit, TimeUnit timeunit1, Clock clock1, MetricFilter metricfilter)
    {
        super(metricregistry, "csv-reporter", metricfilter, timeunit, timeunit1);
        directory = file;
        locale = locale1;
        clock = clock1;
    }


    public static Builder forRegistry(MetricRegistry metricregistry)
    {
        return new Builder(metricregistry);
    }

    private transient void report(long l, String s, String s1, String s2, Object aobj[])
    {
        Object obj;
        boolean flag;
        obj = new File(directory, (new StringBuilder()).append(sanitize(s)).append(".csv").toString());
        flag = ((File) (obj)).exists();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (!((File) (obj)).createNewFile())
        {
            break MISSING_BLOCK_LABEL_165;
        }
        obj = new PrintWriter(new OutputStreamWriter(new FileOutputStream(((File) (obj)), true), UTF_8));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        ((PrintWriter) (obj)).println((new StringBuilder("t,")).append(s1).toString());
        ((PrintWriter) (obj)).printf(locale, String.format(locale, "%d,%s%n", new Object[] {
            Long.valueOf(l), s2
        }), aobj);
        try
        {
            ((PrintWriter) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            LOGGER._mth02CA("Error writing to {}", s, s1);
        }
        break MISSING_BLOCK_LABEL_181;
        s1;
        ((PrintWriter) (obj)).close();
        throw s1;
        return;
    }

    private void reportCounter(long l, String s, Counter counter)
    {
        report(l, s, "count", "%d", new Object[] {
            Long.valueOf(counter.getCount())
        });
    }

    private void reportGauge(long l, String s, Gauge gauge)
    {
        report(l, s, "value", "%s", new Object[] {
            gauge.getValue()
        });
    }

    private void reportHistogram(long l, String s, Histogram histogram)
    {
        Snapshot snapshot = histogram.getSnapshot();
        report(l, s, "count,max,mean,min,stddev,p50,p75,p95,p98,p99,p999", "%d,%d,%f,%d,%f,%f,%f,%f,%f,%f,%f", new Object[] {
            Long.valueOf(histogram.getCount()), Long.valueOf(snapshot.getMax()), Double.valueOf(snapshot.getMean()), Long.valueOf(snapshot.getMin()), Double.valueOf(snapshot.getStdDev()), Double.valueOf(snapshot.getMedian()), Double.valueOf(snapshot.get75thPercentile()), Double.valueOf(snapshot.get95thPercentile()), Double.valueOf(snapshot.get98thPercentile()), Double.valueOf(snapshot.get99thPercentile()), 
            Double.valueOf(snapshot.get999thPercentile())
        });
    }

    private void reportMeter(long l, String s, Meter meter)
    {
        report(l, s, "count,mean_rate,m1_rate,m5_rate,m15_rate,rate_unit", "%d,%f,%f,%f,%f,events/%s", new Object[] {
            Long.valueOf(meter.getCount()), Double.valueOf(convertRate(meter.getMeanRate())), Double.valueOf(convertRate(meter.getOneMinuteRate())), Double.valueOf(convertRate(meter.getFiveMinuteRate())), Double.valueOf(convertRate(meter.getFifteenMinuteRate())), getRateUnit()
        });
    }

    private void reportTimer(long l, String s, Timer timer)
    {
        Snapshot snapshot = timer.getSnapshot();
        report(l, s, "count,max,mean,min,stddev,p50,p75,p95,p98,p99,p999,mean_rate,m1_rate,m5_rate,m15_rate,rate_unit,duration_unit", "%d,%f,%f,%f,%f,%f,%f,%f,%f,%f,%f,%f,%f,%f,%f,calls/%s,%s", new Object[] {
            Long.valueOf(timer.getCount()), Double.valueOf(convertDuration(snapshot.getMax())), Double.valueOf(convertDuration(snapshot.getMean())), Double.valueOf(convertDuration(snapshot.getMin())), Double.valueOf(convertDuration(snapshot.getStdDev())), Double.valueOf(convertDuration(snapshot.getMedian())), Double.valueOf(convertDuration(snapshot.get75thPercentile())), Double.valueOf(convertDuration(snapshot.get95thPercentile())), Double.valueOf(convertDuration(snapshot.get98thPercentile())), Double.valueOf(convertDuration(snapshot.get99thPercentile())), 
            Double.valueOf(convertDuration(snapshot.get999thPercentile())), Double.valueOf(convertRate(timer.getMeanRate())), Double.valueOf(convertRate(timer.getOneMinuteRate())), Double.valueOf(convertRate(timer.getFiveMinuteRate())), Double.valueOf(convertRate(timer.getFifteenMinuteRate())), getRateUnit(), getDurationUnit()
        });
    }

    public void report(SortedMap sortedmap, SortedMap sortedmap1, SortedMap sortedmap2, SortedMap sortedmap3, SortedMap sortedmap4)
    {
        long l = TimeUnit.MILLISECONDS.toSeconds(clock.getTime());
        java.util.Map.Entry entry;
        for (sortedmap = sortedmap.entrySet().iterator(); sortedmap.hasNext(); reportGauge(l, (String)entry.getKey(), (Gauge)entry.getValue()))
        {
            entry = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap1.entrySet().iterator(); sortedmap.hasNext(); reportCounter(l, (String)sortedmap1.getKey(), (Counter)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap2.entrySet().iterator(); sortedmap.hasNext(); reportHistogram(l, (String)sortedmap1.getKey(), (Histogram)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap3.entrySet().iterator(); sortedmap.hasNext(); reportMeter(l, (String)sortedmap1.getKey(), (Meter)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap4.entrySet().iterator(); sortedmap.hasNext(); reportTimer(l, (String)sortedmap1.getKey(), (Timer)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

    }

    protected String sanitize(String s)
    {
        return s;
    }

}
