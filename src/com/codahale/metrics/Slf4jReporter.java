// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;
import o.wt;
import o.wu;
import o.wv;

// Referenced classes of package com.codahale.metrics:
//            ScheduledReporter, Counter, Gauge, Histogram, 
//            Snapshot, Meter, Timer, MetricRegistry, 
//            MetricFilter

public class Slf4jReporter extends ScheduledReporter
{
    public static class Builder
    {

        private TimeUnit durationUnit;
        private MetricFilter filter;
        private wt logger;
        private LoggingLevel loggingLevel;
        private wv marker;
        private TimeUnit rateUnit;
        private final MetricRegistry registry;

        public Slf4jReporter build()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[];

                static 
                {
                    $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel = new int[LoggingLevel.values().length];
                    try
                    {
                        $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[LoggingLevel.TRACE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[LoggingLevel.INFO.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[LoggingLevel.WARN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[LoggingLevel.ERROR.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$codahale$metrics$Slf4jReporter$LoggingLevel[LoggingLevel.DEBUG.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                }
            }

            Object obj;
            switch (_cls1..SwitchMap.com.codahale.metrics.Slf4jReporter.LoggingLevel[loggingLevel.ordinal()])
            {
            case 1: // '\001'
                obj = new TraceLoggerProxy(logger);
                break;

            case 2: // '\002'
                obj = new InfoLoggerProxy(logger);
                break;

            case 3: // '\003'
                obj = new WarnLoggerProxy(logger);
                break;

            case 4: // '\004'
                obj = new ErrorLoggerProxy(logger);
                break;

            default:
                obj = new DebugLoggerProxy(logger);
                break;
            }
            return new Slf4jReporter(registry, ((LoggerProxy) (obj)), marker, rateUnit, durationUnit, filter, null);
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

        public Builder markWith(wv wv)
        {
            marker = wv;
            return this;
        }

        public Builder outputTo(wt wt)
        {
            logger = wt;
            return this;
        }

        public Builder withLoggingLevel(LoggingLevel logginglevel)
        {
            loggingLevel = logginglevel;
            return this;
        }

        private Builder(MetricRegistry metricregistry)
        {
            registry = metricregistry;
            logger = wu._mth02E4("metrics");
            marker = null;
            rateUnit = TimeUnit.SECONDS;
            durationUnit = TimeUnit.MILLISECONDS;
            filter = MetricFilter.ALL;
            loggingLevel = LoggingLevel.INFO;
        }

    }

    static class DebugLoggerProxy extends LoggerProxy
    {

        public transient void log(wv wv, String s, Object aobj[])
        {
            logger._mth02CB(wv, s, aobj);
        }

        public DebugLoggerProxy(wt wt1)
        {
            super(wt1);
        }
    }

    static class ErrorLoggerProxy extends LoggerProxy
    {

        public transient void log(wv wv, String s, Object aobj[])
        {
            logger._mth141D(wv, s, aobj);
        }

        public ErrorLoggerProxy(wt wt1)
        {
            super(wt1);
        }
    }

    static class InfoLoggerProxy extends LoggerProxy
    {

        public transient void log(wv wv, String s, Object aobj[])
        {
            logger._mth02CE(wv, s, aobj);
        }

        public InfoLoggerProxy(wt wt1)
        {
            super(wt1);
        }
    }

    static abstract class LoggerProxy
    {

        protected final wt logger;

        transient abstract void log(wv wv, String s, Object aobj[]);

        public LoggerProxy(wt wt)
        {
            logger = wt;
        }
    }

    public static final class LoggingLevel extends Enum
    {

        private static final LoggingLevel $VALUES[];
        public static final LoggingLevel DEBUG;
        public static final LoggingLevel ERROR;
        public static final LoggingLevel INFO;
        public static final LoggingLevel TRACE;
        public static final LoggingLevel WARN;

        public static LoggingLevel valueOf(String s)
        {
            return (LoggingLevel)Enum.valueOf(com/codahale/metrics/Slf4jReporter$LoggingLevel, s);
        }

        public static LoggingLevel[] values()
        {
            return (LoggingLevel[])$VALUES.clone();
        }

        static 
        {
            TRACE = new LoggingLevel("TRACE", 0);
            DEBUG = new LoggingLevel("DEBUG", 1);
            INFO = new LoggingLevel("INFO", 2);
            WARN = new LoggingLevel("WARN", 3);
            ERROR = new LoggingLevel("ERROR", 4);
            $VALUES = (new LoggingLevel[] {
                TRACE, DEBUG, INFO, WARN, ERROR
            });
        }

        private LoggingLevel(String s, int i)
        {
            super(s, i);
        }
    }

    static class TraceLoggerProxy extends LoggerProxy
    {

        public transient void log(wv wv, String s, Object aobj[])
        {
            logger._mth02CA(wv, s, aobj);
        }

        public TraceLoggerProxy(wt wt1)
        {
            super(wt1);
        }
    }

    static class WarnLoggerProxy extends LoggerProxy
    {

        public transient void log(wv wv, String s, Object aobj[])
        {
            logger._mth02CF(wv, s, aobj);
        }

        public WarnLoggerProxy(wt wt1)
        {
            super(wt1);
        }
    }


    private final LoggerProxy loggerProxy;
    private final wv marker;

    private Slf4jReporter(MetricRegistry metricregistry, LoggerProxy loggerproxy, wv wv, TimeUnit timeunit, TimeUnit timeunit1, MetricFilter metricfilter)
    {
        super(metricregistry, "logger-reporter", metricfilter, timeunit, timeunit1);
        loggerProxy = loggerproxy;
        marker = wv;
    }

    Slf4jReporter(MetricRegistry metricregistry, LoggerProxy loggerproxy, wv wv, TimeUnit timeunit, TimeUnit timeunit1, MetricFilter metricfilter, _cls1 _pcls1)
    {
        this(metricregistry, loggerproxy, wv, timeunit, timeunit1, metricfilter);
    }

    public static Builder forRegistry(MetricRegistry metricregistry)
    {
        return new Builder(metricregistry, null);
    }

    private void logCounter(String s, Counter counter)
    {
        loggerProxy.log(marker, "type=COUNTER, name={}, count={}", new Object[] {
            s, Long.valueOf(counter.getCount())
        });
    }

    private void logGauge(String s, Gauge gauge)
    {
        loggerProxy.log(marker, "type=GAUGE, name={}, value={}", new Object[] {
            s, gauge.getValue()
        });
    }

    private void logHistogram(String s, Histogram histogram)
    {
        Snapshot snapshot = histogram.getSnapshot();
        loggerProxy.log(marker, "type=HISTOGRAM, name={}, count={}, min={}, max={}, mean={}, stddev={}, median={}, p75={}, p95={}, p98={}, p99={}, p999={}", new Object[] {
            s, Long.valueOf(histogram.getCount()), Long.valueOf(snapshot.getMin()), Long.valueOf(snapshot.getMax()), Double.valueOf(snapshot.getMean()), Double.valueOf(snapshot.getStdDev()), Double.valueOf(snapshot.getMedian()), Double.valueOf(snapshot.get75thPercentile()), Double.valueOf(snapshot.get95thPercentile()), Double.valueOf(snapshot.get98thPercentile()), 
            Double.valueOf(snapshot.get99thPercentile()), Double.valueOf(snapshot.get999thPercentile())
        });
    }

    private void logMeter(String s, Meter meter)
    {
        loggerProxy.log(marker, "type=METER, name={}, count={}, mean_rate={}, m1={}, m5={}, m15={}, rate_unit={}", new Object[] {
            s, Long.valueOf(meter.getCount()), Double.valueOf(convertRate(meter.getMeanRate())), Double.valueOf(convertRate(meter.getOneMinuteRate())), Double.valueOf(convertRate(meter.getFiveMinuteRate())), Double.valueOf(convertRate(meter.getFifteenMinuteRate())), getRateUnit()
        });
    }

    private void logTimer(String s, Timer timer)
    {
        Snapshot snapshot = timer.getSnapshot();
        loggerProxy.log(marker, "type=TIMER, name={}, count={}, min={}, max={}, mean={}, stddev={}, median={}, p75={}, p95={}, p98={}, p99={}, p999={}, mean_rate={}, m1={}, m5={}, m15={}, rate_unit={}, duration_unit={}", new Object[] {
            s, Long.valueOf(timer.getCount()), Double.valueOf(convertDuration(snapshot.getMin())), Double.valueOf(convertDuration(snapshot.getMax())), Double.valueOf(convertDuration(snapshot.getMean())), Double.valueOf(convertDuration(snapshot.getStdDev())), Double.valueOf(convertDuration(snapshot.getMedian())), Double.valueOf(convertDuration(snapshot.get75thPercentile())), Double.valueOf(convertDuration(snapshot.get95thPercentile())), Double.valueOf(convertDuration(snapshot.get98thPercentile())), 
            Double.valueOf(convertDuration(snapshot.get99thPercentile())), Double.valueOf(convertDuration(snapshot.get999thPercentile())), Double.valueOf(convertRate(timer.getMeanRate())), Double.valueOf(convertRate(timer.getOneMinuteRate())), Double.valueOf(convertRate(timer.getFiveMinuteRate())), Double.valueOf(convertRate(timer.getFifteenMinuteRate())), getRateUnit(), getDurationUnit()
        });
    }

    protected String getRateUnit()
    {
        return (new StringBuilder("events/")).append(super.getRateUnit()).toString();
    }

    public void report(SortedMap sortedmap, SortedMap sortedmap1, SortedMap sortedmap2, SortedMap sortedmap3, SortedMap sortedmap4)
    {
        java.util.Map.Entry entry;
        for (sortedmap = sortedmap.entrySet().iterator(); sortedmap.hasNext(); logGauge((String)entry.getKey(), (Gauge)entry.getValue()))
        {
            entry = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap1.entrySet().iterator(); sortedmap.hasNext(); logCounter((String)sortedmap1.getKey(), (Counter)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap2.entrySet().iterator(); sortedmap.hasNext(); logHistogram((String)sortedmap1.getKey(), (Histogram)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap3.entrySet().iterator(); sortedmap.hasNext(); logMeter((String)sortedmap1.getKey(), (Meter)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

        for (sortedmap = sortedmap4.entrySet().iterator(); sortedmap.hasNext(); logTimer((String)sortedmap1.getKey(), (Timer)sortedmap1.getValue()))
        {
            sortedmap1 = (java.util.Map.Entry)sortedmap.next();
        }

    }
}
