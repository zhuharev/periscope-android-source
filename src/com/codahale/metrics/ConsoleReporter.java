// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.codahale.metrics:
//            ScheduledReporter, Counter, Gauge, Histogram, 
//            Snapshot, Meter, Timer, Clock, 
//            MetricRegistry, MetricFilter

public class ConsoleReporter extends ScheduledReporter
{
    public static class Builder
    {

        private Clock clock;
        private TimeUnit durationUnit;
        private MetricFilter filter;
        private Locale locale;
        private PrintStream output;
        private TimeUnit rateUnit;
        private final MetricRegistry registry;
        private TimeZone timeZone;

        public ConsoleReporter build()
        {
            return new ConsoleReporter(registry, output, locale, clock, timeZone, rateUnit, durationUnit, filter);
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

        public Builder formattedFor(Locale locale1)
        {
            locale = locale1;
            return this;
        }

        public Builder formattedFor(TimeZone timezone)
        {
            timeZone = timezone;
            return this;
        }

        public Builder outputTo(PrintStream printstream)
        {
            output = printstream;
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
            output = System.out;
            locale = Locale.getDefault();
            clock = Clock.defaultClock();
            timeZone = TimeZone.getDefault();
            rateUnit = TimeUnit.SECONDS;
            durationUnit = TimeUnit.MILLISECONDS;
            filter = MetricFilter.ALL;
        }

    }


    private static final int CONSOLE_WIDTH = 80;
    private final Clock clock;
    private final DateFormat dateFormat;
    private final Locale locale;
    private final PrintStream output;

    private ConsoleReporter(MetricRegistry metricregistry, PrintStream printstream, Locale locale1, Clock clock1, TimeZone timezone, TimeUnit timeunit, TimeUnit timeunit1, 
            MetricFilter metricfilter)
    {
        super(metricregistry, "console-reporter", metricfilter, timeunit, timeunit1);
        output = printstream;
        locale = locale1;
        clock = clock1;
        dateFormat = DateFormat.getDateTimeInstance(3, 2, locale1);
        dateFormat.setTimeZone(timezone);
    }


    public static Builder forRegistry(MetricRegistry metricregistry)
    {
        return new Builder(metricregistry);
    }

    private void printCounter(java.util.Map.Entry entry)
    {
        output.printf(locale, "             count = %d%n", new Object[] {
            Long.valueOf(((Counter)entry.getValue()).getCount())
        });
    }

    private void printGauge(java.util.Map.Entry entry)
    {
        output.printf(locale, "             value = %s%n", new Object[] {
            ((Gauge)entry.getValue()).getValue()
        });
    }

    private void printHistogram(Histogram histogram)
    {
        output.printf(locale, "             count = %d%n", new Object[] {
            Long.valueOf(histogram.getCount())
        });
        histogram = histogram.getSnapshot();
        output.printf(locale, "               min = %d%n", new Object[] {
            Long.valueOf(histogram.getMin())
        });
        output.printf(locale, "               max = %d%n", new Object[] {
            Long.valueOf(histogram.getMax())
        });
        output.printf(locale, "              mean = %2.2f%n", new Object[] {
            Double.valueOf(histogram.getMean())
        });
        output.printf(locale, "            stddev = %2.2f%n", new Object[] {
            Double.valueOf(histogram.getStdDev())
        });
        output.printf(locale, "            median = %2.2f%n", new Object[] {
            Double.valueOf(histogram.getMedian())
        });
        output.printf(locale, "              75%% <= %2.2f%n", new Object[] {
            Double.valueOf(histogram.get75thPercentile())
        });
        output.printf(locale, "              95%% <= %2.2f%n", new Object[] {
            Double.valueOf(histogram.get95thPercentile())
        });
        output.printf(locale, "              98%% <= %2.2f%n", new Object[] {
            Double.valueOf(histogram.get98thPercentile())
        });
        output.printf(locale, "              99%% <= %2.2f%n", new Object[] {
            Double.valueOf(histogram.get99thPercentile())
        });
        output.printf(locale, "            99.9%% <= %2.2f%n", new Object[] {
            Double.valueOf(histogram.get999thPercentile())
        });
    }

    private void printMeter(Meter meter)
    {
        output.printf(locale, "             count = %d%n", new Object[] {
            Long.valueOf(meter.getCount())
        });
        output.printf(locale, "         mean rate = %2.2f events/%s%n", new Object[] {
            Double.valueOf(convertRate(meter.getMeanRate())), getRateUnit()
        });
        output.printf(locale, "     1-minute rate = %2.2f events/%s%n", new Object[] {
            Double.valueOf(convertRate(meter.getOneMinuteRate())), getRateUnit()
        });
        output.printf(locale, "     5-minute rate = %2.2f events/%s%n", new Object[] {
            Double.valueOf(convertRate(meter.getFiveMinuteRate())), getRateUnit()
        });
        output.printf(locale, "    15-minute rate = %2.2f events/%s%n", new Object[] {
            Double.valueOf(convertRate(meter.getFifteenMinuteRate())), getRateUnit()
        });
    }

    private void printTimer(Timer timer)
    {
        Snapshot snapshot = timer.getSnapshot();
        output.printf(locale, "             count = %d%n", new Object[] {
            Long.valueOf(timer.getCount())
        });
        output.printf(locale, "         mean rate = %2.2f calls/%s%n", new Object[] {
            Double.valueOf(convertRate(timer.getMeanRate())), getRateUnit()
        });
        output.printf(locale, "     1-minute rate = %2.2f calls/%s%n", new Object[] {
            Double.valueOf(convertRate(timer.getOneMinuteRate())), getRateUnit()
        });
        output.printf(locale, "     5-minute rate = %2.2f calls/%s%n", new Object[] {
            Double.valueOf(convertRate(timer.getFiveMinuteRate())), getRateUnit()
        });
        output.printf(locale, "    15-minute rate = %2.2f calls/%s%n", new Object[] {
            Double.valueOf(convertRate(timer.getFifteenMinuteRate())), getRateUnit()
        });
        output.printf(locale, "               min = %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.getMin())), getDurationUnit()
        });
        output.printf(locale, "               max = %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.getMax())), getDurationUnit()
        });
        output.printf(locale, "              mean = %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.getMean())), getDurationUnit()
        });
        output.printf(locale, "            stddev = %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.getStdDev())), getDurationUnit()
        });
        output.printf(locale, "            median = %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.getMedian())), getDurationUnit()
        });
        output.printf(locale, "              75%% <= %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.get75thPercentile())), getDurationUnit()
        });
        output.printf(locale, "              95%% <= %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.get95thPercentile())), getDurationUnit()
        });
        output.printf(locale, "              98%% <= %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.get98thPercentile())), getDurationUnit()
        });
        output.printf(locale, "              99%% <= %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.get99thPercentile())), getDurationUnit()
        });
        output.printf(locale, "            99.9%% <= %2.2f %s%n", new Object[] {
            Double.valueOf(convertDuration(snapshot.get999thPercentile())), getDurationUnit()
        });
    }

    private void printWithBanner(String s, char c)
    {
        output.print(s);
        output.print(' ');
        for (int i = 0; i < 80 - s.length() - 1; i++)
        {
            output.print(c);
        }

        output.println();
    }

    public void report(SortedMap sortedmap, SortedMap sortedmap1, SortedMap sortedmap2, SortedMap sortedmap3, SortedMap sortedmap4)
    {
        printWithBanner(dateFormat.format(new Date(clock.getTime())), '=');
        output.println();
        if (!sortedmap.isEmpty())
        {
            printWithBanner("-- Gauges", '-');
            java.util.Map.Entry entry;
            for (sortedmap = sortedmap.entrySet().iterator(); sortedmap.hasNext(); printGauge(entry))
            {
                entry = (java.util.Map.Entry)sortedmap.next();
                output.println((String)entry.getKey());
            }

            output.println();
        }
        if (!sortedmap1.isEmpty())
        {
            printWithBanner("-- Counters", '-');
            for (sortedmap = sortedmap1.entrySet().iterator(); sortedmap.hasNext(); printCounter(sortedmap1))
            {
                sortedmap1 = (java.util.Map.Entry)sortedmap.next();
                output.println((String)sortedmap1.getKey());
            }

            output.println();
        }
        if (!sortedmap2.isEmpty())
        {
            printWithBanner("-- Histograms", '-');
            for (sortedmap = sortedmap2.entrySet().iterator(); sortedmap.hasNext(); printHistogram((Histogram)sortedmap1.getValue()))
            {
                sortedmap1 = (java.util.Map.Entry)sortedmap.next();
                output.println((String)sortedmap1.getKey());
            }

            output.println();
        }
        if (!sortedmap3.isEmpty())
        {
            printWithBanner("-- Meters", '-');
            for (sortedmap = sortedmap3.entrySet().iterator(); sortedmap.hasNext(); printMeter((Meter)sortedmap1.getValue()))
            {
                sortedmap1 = (java.util.Map.Entry)sortedmap.next();
                output.println((String)sortedmap1.getKey());
            }

            output.println();
        }
        if (!sortedmap4.isEmpty())
        {
            printWithBanner("-- Timers", '-');
            for (sortedmap = sortedmap4.entrySet().iterator(); sortedmap.hasNext(); printTimer((Timer)sortedmap1.getValue()))
            {
                sortedmap1 = (java.util.Map.Entry)sortedmap.next();
                output.println((String)sortedmap1.getKey());
            }

            output.println();
        }
        output.println();
        output.flush();
    }
}
