// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioTrack

static class <init>
{

    protected AudioTrack audioTrack;
    private long endPlaybackHeadPosition;
    private boolean isPassthrough;
    private long lastRawPlaybackHeadPosition;
    private long passthroughWorkaroundPauseOffset;
    private long rawPlaybackHeadWrapCount;
    private int sampleRate;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public long getPlaybackHeadPosition()
    {
        if (stopTimestampUs != -1L)
        {
            long l = ((SystemClock.elapsedRealtime() * 1000L - stopTimestampUs) * (long)sampleRate) / 0xf4240L;
            return Math.min(endPlaybackHeadPosition, stopPlaybackHeadPosition + l);
        }
        int i = audioTrack.getPlayState();
        if (i == 1)
        {
            return 0L;
        }
        long l2 = 0xffffffffL & (long)audioTrack.getPlaybackHeadPosition();
        long l1 = l2;
        if (Util.SDK_INT <= 22)
        {
            l1 = l2;
            if (isPassthrough)
            {
                if (i == 2 && l2 == 0L)
                {
                    passthroughWorkaroundPauseOffset = lastRawPlaybackHeadPosition;
                }
                l1 = l2 + passthroughWorkaroundPauseOffset;
            }
        }
        if (lastRawPlaybackHeadPosition > l1)
        {
            rawPlaybackHeadWrapCount = rawPlaybackHeadWrapCount + 1L;
        }
        lastRawPlaybackHeadPosition = l1;
        return (rawPlaybackHeadWrapCount << 32) + l1;
    }

    public long getPlaybackHeadPositionUs()
    {
        return (getPlaybackHeadPosition() * 0xf4240L) / (long)sampleRate;
    }

    public long getTimestampFramePosition()
    {
        throw new UnsupportedOperationException();
    }

    public long getTimestampNanoTime()
    {
        throw new UnsupportedOperationException();
    }

    public void handleEndOfStream(long l)
    {
        stopPlaybackHeadPosition = getPlaybackHeadPosition();
        stopTimestampUs = SystemClock.elapsedRealtime() * 1000L;
        endPlaybackHeadPosition = l;
        audioTrack.stop();
    }

    public boolean overrideHasPendingData()
    {
        return Util.SDK_INT <= 22 && isPassthrough && audioTrack.getPlayState() == 2 && audioTrack.getPlaybackHeadPosition() == 0;
    }

    public void pause()
    {
        if (stopTimestampUs != -1L)
        {
            return;
        } else
        {
            audioTrack.pause();
            return;
        }
    }

    public void reconfigure(AudioTrack audiotrack, boolean flag)
    {
        audioTrack = audiotrack;
        isPassthrough = flag;
        stopTimestampUs = -1L;
        lastRawPlaybackHeadPosition = 0L;
        rawPlaybackHeadWrapCount = 0L;
        passthroughWorkaroundPauseOffset = 0L;
        if (audiotrack != null)
        {
            sampleRate = audiotrack.getSampleRate();
        }
    }

    public boolean updateTimestamp()
    {
        return false;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
