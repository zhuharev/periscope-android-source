// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.widget.TextView;
import com.google.android.exoplayer.CodecCounters;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.upstream.BandwidthMeter;

public final class DebugTextViewHelper
    implements Runnable
{
    public static interface Provider
    {

        public abstract BandwidthMeter getBandwidthMeter();

        public abstract CodecCounters getCodecCounters();

        public abstract long getCurrentPosition();

        public abstract Format getFormat();
    }


    private static final int REFRESH_INTERVAL_MS = 1000;
    private final Provider debuggable;
    private final TextView textView;

    public DebugTextViewHelper(Provider provider, TextView textview)
    {
        debuggable = provider;
        textView = textview;
    }

    private String getBandwidthString()
    {
        BandwidthMeter bandwidthmeter = debuggable.getBandwidthMeter();
        if (bandwidthmeter == null || bandwidthmeter.getBitrateEstimate() == -1L)
        {
            return "bw:?";
        } else
        {
            return (new StringBuilder("bw:")).append(bandwidthmeter.getBitrateEstimate() / 1000L).toString();
        }
    }

    private String getQualityString()
    {
        Format format = debuggable.getFormat();
        if (format == null)
        {
            return "id:? br:? h:?";
        } else
        {
            return (new StringBuilder("id:")).append(format.id).append(" br:").append(format.bitrate).append(" h:").append(format.height).toString();
        }
    }

    private String getRenderString()
    {
        return (new StringBuilder()).append(getTimeString()).append(" ").append(getQualityString()).append(" ").append(getBandwidthString()).append(" ").append(getVideoCodecCountersString()).toString();
    }

    private String getTimeString()
    {
        return (new StringBuilder("ms(")).append(debuggable.getCurrentPosition()).append(")").toString();
    }

    private String getVideoCodecCountersString()
    {
        CodecCounters codeccounters = debuggable.getCodecCounters();
        if (codeccounters == null)
        {
            return "";
        } else
        {
            return codeccounters.getDebugString();
        }
    }

    public final void run()
    {
        textView.setText(getRenderString());
        textView.postDelayed(this, 1000L);
    }

    public final void start()
    {
        stop();
        run();
    }

    public final void stop()
    {
        textView.removeCallbacks(this);
    }
}
